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

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.constant.LogCategoryEnum;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.admin.service.InitialConfigService;
import net.linlan.frame.comm.manager.AsyncManager;
import net.linlan.frame.comm.manager.factory.AsyncFactory;
import net.linlan.frame.comm.security.context.AuthenticationContextHolder;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.ServletUtils;
import net.linlan.utils.constant.CacheConstants;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.constant.UserConstants;
import net.linlan.utils.exception.CommonException;
import net.linlan.utils.exception.user.BlackListException;
import net.linlan.utils.exception.user.CaptchaException;
import net.linlan.utils.exception.user.CaptchaExpireException;
import net.linlan.utils.exception.user.UserNotExistsException;
import net.linlan.utils.exception.user.UserPasswordNotMatchException;
import net.linlan.utils.ip.IPUtils;

/**
 * 登录校验方法
 * 
 * @author Linlan
 */
@Component
public class AdminLoginService {
    @Resource
    private TokenService          tokenService;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private RedisService          redisService;
    @Resource
    private AdminUserService      adminUserService;
    @Resource
    private InitialConfigService  initialConfigService;

    /**
     * 登录验证
     * 
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @param appId 应用ID
     * @return 结果
     */
    public AppLoginInfo login(String username, String password, String code, String uuid,
                              String appId) {
        //         验证码校验
        validateCaptcha(username, code, uuid, appId);
        // 登录前置校验
        loginPreCheck(username, password, appId);
        // 用户验证
        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                username, password);
            AuthenticationContextHolder.setContext(authenticationToken);
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                AsyncManager.me()
                    .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                        Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"),
                        appId, KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
                throw new UserPasswordNotMatchException();
            } else {
                AsyncManager.me()
                    .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                        Constants.LOGIN_FAIL, e.getMessage(), appId, KernelConstant.SUPER_ADMIN,
                        LogCategoryEnum.ADMIN.getKey()));
                throw new CommonException(e.getMessage());
            }
        } finally {
            AuthenticationContextHolder.clearContext();
        }
        FrameUserDetails loginUser = (FrameUserDetails) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserLid(), loginUser.getUserId());
        AsyncManager.me()
            .execute(AsyncFactory.saveAdminLoginLog(loginUser.getUserId(), username,
                Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success"),
                loginUser.getAppId(), KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
        // 生成token
        AppLoginInfo appLoginInfo = tokenService.createToken(loginUser);
        return appLoginInfo;
    }

    /**
     * 服务商登录
     *
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @param appId 应用ID
     * @return 结果
     */
    public AppLoginInfo thirdEcorganLogin(String username, String password, String code,
                                          String uuid, String appId) {
        // 验证码校验
        // 登录前置校验
        loginPreCheck(username, password, appId);
        // 用户验证
        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                username, password);
            AuthenticationContextHolder.setContext(authenticationToken);
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                AsyncManager.me()
                    .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                        Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"),
                        appId, KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
                throw new UserPasswordNotMatchException();
            } else {
                AsyncManager.me()
                    .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                        Constants.LOGIN_FAIL, e.getMessage(), appId, KernelConstant.SUPER_ADMIN,
                        LogCategoryEnum.ADMIN.getKey()));
                throw new CommonException(e.getMessage());
            }
        } finally {
            AuthenticationContextHolder.clearContext();
        }
        FrameUserDetails loginUser = (FrameUserDetails) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserLid(), loginUser.getUserId());
        AsyncManager.me()
            .execute(AsyncFactory.saveAdminLoginLog(loginUser.getUserId(), username,
                Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success"),
                loginUser.getAppId(), KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
        // 生成token
        AppLoginInfo appLoginInfo = tokenService.createToken(loginUser);
        return appLoginInfo;
    }

    /**
     * 校验验证码
     * 
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @param appId 应用ID
     */
    public void validateCaptcha(String username, String code, String uuid, String appId) {
        boolean captchaEnabled = initialConfigService.selectCaptchaEnabled();
        if (captchaEnabled) {
            String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
            String captcha = (String) redisService.get(verifyKey);
            if (captcha == null) {
                AsyncManager.me()
                    .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                        Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire"), appId,
                        KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
                throw new CaptchaExpireException();
            }
            redisService.delete(verifyKey);
            if (!code.equalsIgnoreCase(captcha)) {
                AsyncManager.me()
                    .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                        Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error"), appId,
                        KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
                throw new CaptchaException();
            }
        }
    }

    /**
     * 登录前置校验
     * @param username 用户名
     * @param password 用户密码
     * @param appId 应用ID
     */
    public void loginPreCheck(String username, String password, String appId) {
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            AsyncManager.me()
                .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                    Constants.LOGIN_FAIL, MessageUtils.message("not.null"), appId,
                    KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
            || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            AsyncManager.me()
                .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                    Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"), appId,
                    KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
            throw new UserPasswordNotMatchException();
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
            || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            AsyncManager.me()
                .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                    Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"), appId,
                    KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
            throw new UserPasswordNotMatchException();
        }
        // IP黑名单校验
        String blackStr = initialConfigService.selectConfigByKey("sys.login.blackIPList");
        if (IPUtils.isMatchedIp(blackStr, IPUtils.getIpAddr(ServletUtils.getRequest()))) {
            AsyncManager.me()
                .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                    Constants.LOGIN_FAIL, MessageUtils.message("login.blocked"), appId,
                    KernelConstant.SUPER_ADMIN, LogCategoryEnum.ADMIN.getKey()));
            throw new BlackListException();
        }
    }

    /**
     * 记录登录信息
     *
     * @param adminId 用户LID
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long adminId, String userId) {
        AdminUser adminUser = new AdminUser();
        if (ObjectUtils.isEmpty(adminId)) {
            adminUser.setId(RandomUtils.randomLid());

        } else {
            adminUser.setId(adminId);
        }
        if (ObjectUtils.isEmpty(userId)) {
            adminUser.setUserId(RandomUtils.UUID32());
        } else {
            adminUser.setUserId(userId);
        }
        adminUser.setLastLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
        adminUser.setLastLoginTime(new Date());
        adminUserService.update(adminUser);
    }
}
