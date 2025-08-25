/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.comm.security.handle;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.alibaba.fastjson2.JSON;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.frame.FrameAdminUser;
import net.linlan.frame.comm.manager.AsyncManager;
import net.linlan.frame.comm.manager.factory.AsyncFactory;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.ServletUtils;
import net.linlan.utils.constant.Constants;

/**
 * 自定义退出处理类 返回成功
 * 
 * @author Linlan
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    @Resource
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException,
                                                               ServletException {
        FrameAdminUser loginUser = tokenService.getLoginUser(request);
        if (ObjectUtils.isNotEmpty(loginUser)) {
            String username = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            AsyncManager.me()
                .execute(AsyncFactory.saveAdminLoginLog(loginUser.getAdminId(), username,
                    Constants.LOGOUT, MessageUtils.message("user.logout.success"),
                    loginUser.getAppId()));
        }
        ServletUtils.renderString(response,
            JSON.toJSONString(ResponseResult.ok(MessageUtils.message("user.logout.success"))));
    }
}
