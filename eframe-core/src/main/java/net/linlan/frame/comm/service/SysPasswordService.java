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
package net.linlan.frame.comm.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.comm.manager.AsyncManager;
import net.linlan.frame.comm.manager.factory.AsyncFactory;
import net.linlan.frame.comm.security.context.AuthenticationContextHolder;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.constant.CacheConstants;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.crypt.ShaUtils;
import net.linlan.utils.exception.user.UserPasswordNotMatchException;
import net.linlan.utils.exception.user.UserPasswordRetryLimitExceedException;

/**
 * 登录密码方法
 * 
 * @author Linlan
 */
@Component
public class SysPasswordService {
    @Resource
    private RedisService redisService;

    @Value("${platform.user.password.maxRetryCount}")
    private int          maxRetryCount;

    @Value("${platform.user.password.lockTime}")
    private int          lockTime;

    /**
     * 登录账户密码错误次数缓存键名
     * 
     * @param username 用户名
     * @return 缓存键key
     */
    private String getCacheKey(String username) {
        return CacheConstants.PWD_ERR_CNT_KEY + username;
    }

    public void validate(AdminUserDto user) {
        Authentication usernamePasswordAuthenticationToken = AuthenticationContextHolder
            .getContext();
        String username = usernamePasswordAuthenticationToken.getName();
        String password = usernamePasswordAuthenticationToken.getCredentials().toString();

        Integer retryCount = (Integer) redisService.get(getCacheKey(username));

        if (retryCount == null) {
            retryCount = 0;
        }

        if (retryCount >= Integer.valueOf(maxRetryCount).intValue()) {
            throw new UserPasswordRetryLimitExceedException(maxRetryCount, lockTime);
        }

        if (!matches(user, password)) {
            retryCount = retryCount + 1;
            redisService.set(getCacheKey(username), retryCount, lockTime * 60);
            throw new UserPasswordNotMatchException();
        } else {
            clearLoginRecordCache(username);
        }
    }

    public void socialValidate(AdminUserDto user, String encodePwd, String appId) {
        String username = user.getUsername();
        String password = user.getPassword();

        Integer retryCount = (Integer) redisService.get(getCacheKey(username));

        if (retryCount == null) {
            retryCount = 0;
        }

        if (retryCount >= Integer.valueOf(maxRetryCount).intValue()) {
            AsyncManager.me().execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS,
                username, Constants.LOGIN_FAIL,
                MessageUtils.message("user.password.retry.limit.exceed", maxRetryCount, lockTime),
                appId));
            throw new UserPasswordRetryLimitExceedException(maxRetryCount, lockTime);
        }

        if (!password.equals(encodePwd)) {
            retryCount = retryCount + 1;
            AsyncManager.me()
                .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                    Constants.LOGIN_FAIL,
                    MessageUtils.message("user.password.retry.limit.count", retryCount), appId));
            redisService.set(getCacheKey(username), retryCount, lockTime * 60);
            throw new UserPasswordNotMatchException();
        } else {
            clearLoginRecordCache(username);
        }
    }

    public boolean matches(AdminUserDto user, String rawPassword) {
        return ShaUtils.matchesPassword(rawPassword, user.getPassword());
    }

    public void clearLoginRecordCache(String loginName) {
        if (redisService.hasKey(getCacheKey(loginName))) {
            redisService.delete(getCacheKey(loginName));
        }
    }
}
