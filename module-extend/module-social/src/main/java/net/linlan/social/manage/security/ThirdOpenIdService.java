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
package net.linlan.social.manage.security;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import net.linlan.social.third.service.ThirdMemberService;
import net.linlan.utils.exception.CommonException;

/**
 * 第三方登录，通过code，获取开放平台用户唯一标识
 *
 * @author Linlan
 * 
 */
@Service
public class ThirdOpenIdService {

    @Resource
    private ThirdMemberService thirdMemberService;

    /**
     * 通过code，获取开放平台用户唯一标识
     *
     * @param login 第三方登录信息
     * @return 开放平台用户唯一标识
     */
    public String getOpenId(ThirdLogin login) {
        AuthRequest authRequest = thirdMemberService.getAuthRequest(login.getOpenType());
        AuthCallback callback = AuthCallback.builder().code(login.getCode()).state(login.getState())
            .build();

        // 根据code，获取用户信息
        AuthResponse<AuthUser> response = authRequest.login(callback);

        // 判断是否成功
        if (!response.ok()) {
            throw new CommonException("第三方登录失败");
        }

        return response.getData().getUuid();
    }
}
