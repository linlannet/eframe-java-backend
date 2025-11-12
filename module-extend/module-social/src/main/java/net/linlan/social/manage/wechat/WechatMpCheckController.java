/*
 * module-social - 社交平台对接模块
 * Copyright © 2020-2025 Linlan (open@linlan.net)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.linlan.social.manage.wechat;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import cn.hutool.core.util.ObjectUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import net.linlan.annotation.AuthIgnore;
import net.linlan.annotation.Encrypt;
import net.linlan.annotation.OriginalResponse;
import net.linlan.commons.core.ResponseResult;
import net.linlan.sys.web.RedisService;
import static net.linlan.utils.constant.CacheConstants.WX_MP_USER;

/**
 * 微信服务号接口相关控制器
 * 
 * @author Linlan
 */
@Slf4j
@RestController
@RequestMapping("/api/open/wechat")
@AllArgsConstructor
public class WechatMpCheckController {

    @Resource
    private WxMpService         wxMpService;
    @Resource
    private RedisService        redisService;
    @Resource
    private WxMpMessageRouter   messageRouter;

    //    private final Pattern       pattern             = Pattern.compile("(?i)^DL\\d{4}$");
    private static final String OAUTH2_REDIRECT_URL = "https://linlannet/eframe/mp/home";

    /**
     * 微信公众号token验证
     * @param signature 签名
     * @param timestamp 时间
     * @param nonce 有效期
     * @param echostr 响应字符串
     * @return token验证
     */
    @GetMapping
    @AuthIgnore
    @OriginalResponse
    public String checkToken(String signature, String timestamp, String nonce, String echostr) {
        return wxMpService.checkSignature(timestamp, nonce, signature) ? echostr : null;
    }

    /**
     * 微信公众号消息对接
     * @param requestBody 请求结构体
     * @param signature 签名
     * @param timestamp 时间
     * @param nonce 有效期
     * @param encType 加密类型
     * @param msgSignature 消息签名
     * @return 检查签名结果
     */
    @PostMapping(produces = "application/xml; charset=UTF-8")
    @AuthIgnore
    @OriginalResponse
    public String handleMessage(@RequestBody String requestBody,
                                @RequestParam("signature") String signature,
                                @RequestParam("timestamp") String timestamp,
                                @RequestParam("nonce") String nonce,
                                @RequestParam(name = "encrypt_type", required = false) String encType,
                                @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        log.info("\n接收微信请求：[[signature=[{}], encType=[{}], msgSignature=[{}],"
                 + " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
            signature, encType, msgSignature, timestamp, nonce, requestBody);
        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
        }
        String out = null;
        if (encType == null) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
            WxMpXmlOutMessage outMessage = this.route(inMessage);
            if (outMessage == null) {
                return "";
            }

            out = outMessage.toXml();
        } else if ("aes".equalsIgnoreCase(encType)) {
            // aes加密的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(requestBody,
                wxMpService.getWxMpConfigStorage(), timestamp, nonce, msgSignature);
            log.debug("\n消息解密后内容为：\n{} ", inMessage.toString());
            WxMpXmlOutMessage outMessage = this.route(inMessage);
            if (outMessage == null) {
                return "";
            }
            out = outMessage.toEncryptedXml(wxMpService.getWxMpConfigStorage());
        }

        log.debug("\n组装回复信息：{}", out);
        return out;
    }

    /**
     * 微信公众号 获取oauth2完整授权地址
     *
     * @return 对象
     */
    @GetMapping("/getRedirect")
    @AuthIgnore
    @Encrypt
    public ResponseResult<Object> getRedirect() {
        Map<String, Object> result = new HashMap<>();
        result.put("url", wxMpService.getOAuth2Service().buildAuthorizationUrl(OAUTH2_REDIRECT_URL,
            WxConsts.OAuth2Scope.SNSAPI_USERINFO, null));
        return ResponseResult.ok(result);
    }

    /**
     * 微信公众号 oauth2授权后 获取用户信息
     * @param code  代码
     * @return 对象
     */
    @GetMapping("/login")
    @AuthIgnore
    @Encrypt
    public ResponseResult<Object> login(String code) throws WxErrorException {
        WxOAuth2AccessToken wxOAuth2AccessToken = wxMpService.getOAuth2Service()
            .getAccessToken(code);
        WxOAuth2UserInfo wxOAuth2UserInfo = wxMpService.getOAuth2Service()
            .getUserInfo(wxOAuth2AccessToken, null);
        Map<String, Object> result = new HashMap<>();
        // TODO: oauth获取用户信息后保存
        redisService.set(WX_MP_USER + "oauth:user:" + wxOAuth2UserInfo.getOpenid(),
            wxOAuth2UserInfo);
        result.put("user", wxOAuth2UserInfo);
        return ResponseResult.ok(result);
    }

    /**
     * 微信公众号 页面端原生能力调用
     * @param url   路径URL
     * @return 对象
     */
    @GetMapping("/getJsapiTicket")
    @AuthIgnore
    @Encrypt
    public ResponseResult<Object> getJsapiTicket(@RequestParam String url) throws WxErrorException {
        Map<String, Object> result = new HashMap<>();
        return ResponseResult.ok(result);
    }

    /**
     * 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串
     *
     * @param params    参数
     * @return  签名数据
     */
    private String getSignatureData(Map<String, Object> params) {
        Map<String, Object> sortMap = new TreeMap<String, Object>();
        sortMap.putAll(params);
        // 以k1=v1&k2=v2...方式拼接参数
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> s : sortMap.entrySet()) {
            String k = s.getKey();
            Object v = s.getValue();
            if (ObjectUtil.isNull(v)) {// 过滤空值
                continue;
            }
            builder.append(k).append("=").append(v).append("&");
        }
        if (!sortMap.isEmpty()) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    /**
     * 微信消息路由
     *
     * @param message   消息
     * @return  路由输出
     */
    private WxMpXmlOutMessage route(WxMpXmlMessage message) {
        try {
            return this.messageRouter.route(message);
        } catch (Exception e) {
            log.error("路由消息时出现异常！", e);
        }

        return null;
    }

    //
    //    /**
    //     * 微信公众号服务器配置校验token
    //     *
    //     * @param signature 签名
    //     * @param timestamp 时间
    //     * @param nonce 有效期
    //     * @param echostr 响应字符串
    //     * @return 检查签名结果
    //     */
    //    @PlatLog(value = "微信公众号服务器配置校验token", category = 10, srcCode = 1)
    //    @GetMapping(produces = "text/plain;charset=utf-8")
    //    @AuthIgnore
    //    @OriginalResponse
    //    public String checkSignature(@RequestParam(name = "signature") String signature,
    //                                 @RequestParam(name = "timestamp") String timestamp,
    //                                 @RequestParam(name = "nonce") String nonce,
    //                                 @RequestParam(name = "echostr") String echostr) {
    //        log.info("公众号请求参数:signature:{},timestamp:{},nonce:{},echostr:{}", signature, timestamp,
    //            nonce, echostr);
    //        if (wxMpService.checkSignature(timestamp, nonce, signature)) {
    //            return echostr;
    //        }
    //        return "Invalid signature";
    //    }
    //
    //    @PlatLog(value = "微信公众号服务器配置校验token", category = 10, srcCode = 1)
    //    @PostMapping(produces = "application/xml;charset=UTF-8")
    //    public String handleMsg(HttpServletRequest request) {
    //
    //        try {
    //            WxMpXmlMessage message = WxMpXmlMessage.fromXml(request.getInputStream());
    //            String content = message.getContent();
    //            log.info("公众号请求类型:{};内容为:{}", message.getMsgType(), content);
    //            if (WxConsts.XmlMsgType.TEXT.equals(message.getMsgType())) {
    //                if ("验证码".equals(content)) {
    //                    int code = RandomUtils.random(4);
    //                    String msg = MessageFormat.format("您的本次验证码:{0},该验证码3分钟内有效。", code);
    //                    redisService.set(CacheConstants.CAPTCHA_CODE_KEY + code, code,
    //                        KernelConstant.ONE_MINUTE_EXPIRE * 3);
    //                    return returnMsg(msg, message);
    //                }
    //                //登录逻辑
    //                if (content.toLowerCase().contains("dl")) {
    //                    Matcher matcher = pattern.matcher(content);
    //                    if (!matcher.matches()) {
    //                        return returnMsg("验证不正确或已过期", message);
    //                    } else {
    //                        String msg = wechatAuthService.wechatMpLogin(message);
    //                        return returnMsg(msg, message);
    //                    }
    //                }
    //            }
    //
    //        } catch (IOException e) {
    //            throw new RuntimeException(e);
    //        }
    //        return "";
    //    }
    //
    //    /**
    //     * 返回消息
    //     * @param msg 消息内容
    //     * @param message
    //     * @return  返回消息
    //     */
    //    private static String returnMsg(String msg, WxMpXmlMessage message) {
    //        WxMpXmlOutTextMessage outMessage = WxMpXmlOutTextMessage.TEXT().content(msg)
    //            .fromUser(message.getToUser()).toUser(message.getFromUser()).build();
    //        return outMessage.toXml();
    //    }

}
