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
package net.linlan.social.service;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.comm.manager.AsyncManager;
import net.linlan.frame.comm.manager.factory.AsyncFactory;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.social.security.ThirdAuthenticationToken;
import net.linlan.social.vo.ThirdLoginBody;
import net.linlan.sys.base.service.BaseUserService;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.exception.SupportException;

/**
 * 登录校验方法
 *
 * @author Linlan
 */
/**
 * 登录校验方法
 *
 * @author Linlan
 */
@Component
public class ThirdLoginService {
    @Resource
    private TokenService          tokenService;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private BaseUserService       baseUserService;

    /**
     * 第三方验证后，调用登录方法
     * @param loginBody 第三方登录对象
     * @return AppLoginInfo对象
     */
    public AppLoginInfo socialLogin(ThirdLoginBody loginBody) {
        // 用户验证
        Authentication authentication = null;
        try {
            authentication = authenticationManager
                .authenticate(new ThirdAuthenticationToken(loginBody));
        } catch (Exception e) {
            throw new SupportException("第三方授权信息错误");
        }
        FrameUserDetails loginUser = (FrameUserDetails) authentication.getPrincipal();
        baseUserService.recordLoginInfo(loginUser.getUserId());
        AsyncManager.me()
            .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS,
                loginUser.getUsername(), Constants.LOGIN_SUCCESS,
                MessageUtils.message("user.third.login.success"), loginUser.getAppId()));
        // 生成token
        return tokenService.createToken(loginUser);
    }

}
