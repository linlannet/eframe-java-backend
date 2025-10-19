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
package net.linlan.social.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.social.service.ThirdLoginService;
import net.linlan.social.vo.ThirdCallbackVo;
import net.linlan.social.vo.ThirdLoginBody;
import net.linlan.utils.constant.SecurityConstants;

/**
 * 第三方社交平台登录验证
 * 
 * @author Linlan
 */
@RestController
public class ThirdLoginController {
    @Resource
    private ThirdLoginService thirdLoginService;

    /**
     * 社交平台登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PlatLog(value = "社交平台登录方法", category = 10, srcCode = 11)
    @PostMapping(SecurityConstants.SOCIAL_LOGIN)
    @Encrypt
    public ResponseResult<AppLoginInfo> socialLogin(@RequestBody ThirdLoginBody loginBody) {
        // 生成令牌
        AppLoginInfo appLoginInfo = thirdLoginService.socialLogin(loginBody);
        return ResponseResult.ok(appLoginInfo);
    }

    /** 根据类型，获取授权请求
     * @param source 来源类型，alipay|wechat|其他
     * @param response 响应
     * @throws IOException  异常
     */
    @PlatLog(value = "根据类型，获取授权请求", category = 40)
    @RequestMapping(SecurityConstants.SOCIAL_RENDER + "/{source}")
    @Encrypt
    public void renderAuth(@PathVariable("source") String source,
                           HttpServletResponse response) throws IOException {
        AuthRequest authRequest = thirdLoginService.getAuthRequest(source);
        String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
        response.sendRedirect(authorizeUrl);
    }

    /** 根据类型，获取授权请求
     * @param source 来源类型，alipay|wechat|其他
     * @param callback 回调渲染
     * @return 页面跳转
     */
    @PlatLog(value = "根据类型，获取授权请求", category = 40)
    @RequestMapping(SecurityConstants.SOCIAL_CALLBACK + "/{source}")
    @Encrypt
    public ModelAndView login(@PathVariable("source") String source, AuthCallback callback) {
        Map<String, Object> map = new HashMap<>();
        map.put("platformType", source);
        map.put("state", callback.getState());
        map.put("code", callback.getCode());

        return new ModelAndView("third_login", map);
    }

    /** 第三方社交平台账号绑定
     * @param callbackVo    账户信息
     * @return  绑定状态
     */
    @PostMapping(SecurityConstants.IDP_MEMBER_BIND)
    @Encrypt
    @LimitScope(name = "thirdMemberUpdate", key = "thirdMemberUpdate")
    public ResponseResult<String> bind(@RequestBody ThirdCallbackVo callbackVo) {
        AuthRequest authRequest = thirdLoginService.getAuthRequest(callbackVo.getPlatformType());
        AuthCallback callback = AuthCallback.builder().code(callbackVo.getCode())
            .state(callbackVo.getState()).build();
        // 根据code，获取用户信息
        AuthResponse<AuthUser> response = authRequest.login(callback);
        // 判断是否成功
        if (!response.ok()) {
            throw new RuntimeException("第三方登录失败");
        }
        // 绑定用户信息
        thirdLoginService.bind(SecurityUtils.getUserId(), callbackVo.getPlatformType(),
            response.getData());
        return ResponseResult.ok();
    }

    /** 第三方社交平台账号解绑
     * @param platformType    平台类型
     * @return  解绑状态
     */
    @PutMapping(SecurityConstants.IDP_MEMBER_BIND + "/{platformType}")
    @Encrypt
    @LimitScope(name = "thirdMemberUpdate", key = "thirdMemberUpdate")
    public ResponseResult<String> unBind(@PathVariable("platformType") String platformType) {
        thirdLoginService.unBind(SecurityUtils.getUserId(), platformType);
        return ResponseResult.ok();
    }

}
