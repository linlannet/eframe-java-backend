/*
 * module-authn - 动态认证对接模块
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
package net.linlan.authn.service;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import net.linlan.authn.sms.security.MobileAuthenticationToken;
import net.linlan.authn.sms.service.SmsSendService;
import net.linlan.authn.vo.MobileLoginBody;
import net.linlan.commons.core.RandomUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.comm.manager.AsyncManager;
import net.linlan.frame.comm.manager.factory.AsyncFactory;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.base.service.BaseUserService;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.exception.SupportException;

/**
 * 登录校验方法
 * 
 * @author Linlan
 */
@Component
public class AuthnLoginService {

    @Resource
    private TokenService          tokenService;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private BaseUserService       baseUserService;
    @Resource
    private SmsSendService        smsSendService;

    public AppLoginInfo loginByMobile(MobileLoginBody login) {
        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager
                .authenticate(new MobileAuthenticationToken(login.getMobile(), login.getCode()));
        } catch (BadCredentialsException e) {
            throw new SupportException("手机号或验证码错误");
        }

        FrameUserDetails loginUser = (FrameUserDetails) authentication.getPrincipal();
        baseUserService.recordLoginInfo(loginUser.getUserId());
        AsyncManager.me()
            .execute(AsyncFactory.saveAdminLoginLog(loginUser.getUserId(), loginUser.getUsername(),
                Constants.LOGIN_SUCCESS, MessageUtils.message("user.authn.login.success"),
                loginUser.getAppId()));
        // 生成token
        return tokenService.createToken(loginUser);
    }

    public boolean sendCode(String mobile) {
        // 生成6位验证码
        String code = RandomUtils.randomNumbers(6);

        BaseUser user = baseUserService.getByMobile(mobile);
        if (user == null) {
            throw new SupportException("手机号未注册");
        }

        // 发送短信
        return smsSendService.sendCode(mobile, "code", code);
    }

}
