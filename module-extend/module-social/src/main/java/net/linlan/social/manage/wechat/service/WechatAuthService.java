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
package net.linlan.social.manage.wechat.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import cn.hutool.http.HttpUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.social.manage.constant.OpenTypeEnum;
import net.linlan.social.manage.vo.ThirdUserInfo;
import net.linlan.social.manage.vo.ThirdUserVo;
import net.linlan.social.permission.service.ThirdPermissionService;
import net.linlan.social.permission.service.UserRangeOrganService;
import net.linlan.social.third.dto.ThirdUserDto;
import net.linlan.social.third.service.ThirdMemberService;
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.core.service.CoreAccountService;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.constant.CacheConstants;
import net.linlan.utils.exception.SupportException;

@Slf4j
@Service
@RequiredArgsConstructor
public class WechatAuthService {

    @Resource
    private RedisService           redisService;
    @Resource
    private CoreAccountService     coreAccountService;
    @Resource
    private ThirdMemberService     thirdMemberService;
    @Resource
    private UserRangeOrganService  userRangeOrganService;
    @Resource
    private ThirdPermissionService thirdPermissionService;

    public String getWechatLoginCode() {
        //随机获取4位数字
        String code = "DL" + RandomUtils.randomNumbers(4);
        redisService.set(CacheConstants.WX_LOGIN_USER_CODE + code, "NOT-LOGIN",
            KernelConstant.ONE_MINUTE_EXPIRE);
        return code;
    }

    public ThirdUserInfo getWechatIsLogin(String loginCode) {
        ThirdUserInfo loginUserInfo = redisService.get(CacheConstants.WX_LOGIN_USER + loginCode);

        if (loginUserInfo == null) {
            throw new SupportException("登录失败");
        }
        return loginUserInfo;
    }

    public String wechatMpLogin(WxMpXmlMessage message) {
        String code = message.getContent().toUpperCase();
        //先判断登录码是否已过期
        Object e = redisService.hasKey(CacheConstants.WX_LOGIN_USER_CODE + code);
        if (e == null) {
            return "验证码已过期";
        }
        ThirdUserInfo loginUserInfo = wechatMpLogin(message.getFromUser());
        //修改redis缓存 以便监听是否已经授权成功
        redisService.set(CacheConstants.WX_LOGIN_USER + code, loginUserInfo,
            KernelConstant.ONE_MINUTE_EXPIRE);
        return "麟览信息数据服务网登录成功！";
    }

    private ThirdUserInfo wechatMpLogin(String openId) {
        String openType = OpenTypeEnum.WECHAT_MP.getKey();
        // 查询用户
        return getThirdUserInfoForWechat(openType, openId);
    }

    public ThirdUserInfo miniLogin(String platformType, String code) {
        String openType = "";
        if (platformType.startsWith("wechat")) {
            openType = OpenTypeEnum.WECHAT_MINI.getKey();
        }
        CoreAccount coreAccount = coreAccountService.getByServerType(openType);
        if (ObjectUtils.isEmpty(coreAccount)) {
            return null;
        }
        String url = coreAccount.getServerUrl();

        // 使用示例
        url = buildWechatUrl(url, coreAccount.getClientId(), coreAccount.getClientSecret(), code);
        String result = HttpUtil.get(url);
        JSONObject jsonObject = JSON.parseObject(result);
        Object openid = jsonObject.get("openid");
        if (openid == null) {
            throw new SupportException("登录失败");
        }
        return getThirdUserInfoForWechat(openType, openid.toString());

    }

    private ThirdUserInfo getThirdUserInfoForWechat(String openType, String openId) {
        // 查询用户
        ThirdUserDto thirdUserDto = thirdMemberService.getThirdUserByOpenId(openId, openType);
        if (ObjectUtils.isEmpty(thirdUserDto)) {
            //添加用户
            thirdUserDto = thirdMemberService.bindFromMpMini(openType, openId);
            //添加用户角色信息
            userRangeOrganService.saveOrUpdateFromMpMini(openType, openId);
        } else {
            if (thirdUserDto.getDelFlag() != DelFlagEnum.NORMAL.getKey()) {
                throw new SupportException("账号已被禁用，请联系管理员");
            }
        }
        ThirdUserVo thirdUserVo = (ThirdUserVo) ThirdUserVo.DTO.apply(thirdUserDto);
        ThirdUserInfo loginUserInfo = new ThirdUserInfo();
        // 角色集合，前台用户的角色通过关联的公共组进行读取
        Set<Long> roles = thirdPermissionService.getPublicGroupPermission(thirdUserDto.getId());
        // 权限集合，前台用户权限集合可为空
        Set<String> permissions = new HashSet<>();
        ThirdUserInfo thirdUserInfo = new ThirdUserInfo();
        thirdUserInfo.setUser(thirdUserVo);
        thirdUserInfo.setRoles(roles);
        thirdUserInfo.setPermissions(permissions);
        return loginUserInfo;
    }

    public String buildWechatUrl(String url, String clientId, String clientSecurity, String code) {
        return String.format(url, clientId, clientSecurity, code);
    }

}
