/*
 * eframe-api - api接口网关模块
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
package net.linlan.frame.api.admin;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.dto.WebLayoutDto;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.comm.manager.AsyncManager;
import net.linlan.frame.comm.manager.factory.AsyncFactory;
import net.linlan.frame.comm.service.AdminLoginService;
import net.linlan.frame.comm.service.SysPermissionService;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.frame.comm.service.WebLayoutService;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.frame.mbiz.constant.HttpStatusEnum;
import net.linlan.frame.view.admin.manager.AdminMenuManager;
import net.linlan.frame.view.admin.vo.AdminUserVo;
import net.linlan.frame.view.admin.vo.AppPageIndexInfo;
import net.linlan.frame.view.admin.vo.AppUserInfo;
import net.linlan.frame.web.model.LoginBody;
import net.linlan.sys.base.dto.BaseAppDto;
import net.linlan.sys.base.param.BaseAppParam;
import net.linlan.sys.base.service.BaseAppService;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.core.service.CoreAccountService;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.constant.CacheConstants;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.constant.SecurityConstants;
import net.linlan.utils.exception.user.CaptchaException;
import net.linlan.utils.exception.user.CaptchaExpireException;
import static net.linlan.frame.web.SecurityUtils.getLoginUser;

/**
 * 系统登录验证
 * 
 * @author Linlan
 */
@RestController
public class SysLoginController {
    @Resource
    private AdminLoginService    adminLoginService;
    @Resource
    private AdminMenuManager     adminMenuManager;
    @Resource
    private SysPermissionService sysPermissionService;
    @Resource
    private AdminUserService     adminUserService;
    @Resource
    private TokenService         tokenService;
    @Resource
    private RedisService         redisService;
    @Resource
    private BaseAppService       baseAppService;
    @Resource
    private CoreAccountService   coreAccountService;
    @Resource
    private WebLayoutService     platAdminEntService;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PlatLog(value = "登录方法", category = 10)
    @PostMapping(SecurityConstants.FORM_LOGIN)
    @Encrypt
    public ResponseResult<AppLoginInfo> login(@RequestBody LoginBody loginBody) {
        // 生成令牌
        AppLoginInfo appLoginInfo = adminLoginService.login(loginBody.getUsername(),
            loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid(),
            loginBody.getAppId());
        return ResponseResult.ok(appLoginInfo);
    }

    /**
     * 获取应用用户信息，作用于Work端登录之后进行用户基本信息获取
     * 
     * @return 用户信息
     */
    @PlatLog(value = "获取应用用户信息")
    @GetMapping("appUserInfo")
    @Encrypt
    public ResponseResult<AppUserInfo> appUserInfo() {
        FrameUserDetails loginUser = getLoginUser();
        AdminUserDto user = adminUserService.getByUsername(loginUser.getUsername());
        // 角色集合
        Set<String> roles = sysPermissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = sysPermissionService.getMenuPermission(user);

        AppUserInfo appUserInfo = new AppUserInfo();
        appUserInfo.setUser((AdminUserVo) AdminUserVo.DTO.apply(user));
        appUserInfo.setRoles(roles);
        appUserInfo.setPermissions(permissions);
        if (!loginUser.getPerms().equals(permissions)) {
            loginUser.setPerms(permissions);
            tokenService.refreshToken(loginUser);
        }
        return ResponseResult.ok(appUserInfo);
    }

    /**
     * 获取应用首页信息，包括菜单含路由信息
     * 
     * @return 路由信息
     */
    @PlatLog(value = "获取应用首页信息")
    @GetMapping("appIndexInfo")
    @Encrypt
    public ResponseResult<AppPageIndexInfo> appIndexInfo() {
        FrameUserDetails loginUser = getLoginUser();
        AppPageIndexInfo appPageIndexInfo = adminMenuManager.getAppPageIndexInfo(loginUser);
        return ResponseResult.ok(appPageIndexInfo);
    }

    /**
     * 内部应用，第三方应用登录方法，返回字段少的平台用户对象
     * @param request   请求
     * @return {@link WebLayoutDto}
     */
    @PlatLog(srcCode = 1, value = "内部应用，第三方应用登录方法，返回字段少的平台用户对象.")
    @PostMapping("/platLogin")
    @Encrypt
    public ResponseResult<WebLayoutDto> platLogin(HttpServletRequest request) {
        String accountId = request.getHeader(Constants.ACCOUNT_KEY);
        CoreAccount coreAccount = (CoreAccount) redisService
            .get(CacheConstants.PLAT_ACCOUNT_KEY + accountId);
        if (coreAccount == null) {
            //用户信息未在Session中
            coreAccount = coreAccountService.findById(accountId);
            if (coreAccount == null) {
                BaseAppParam param = new BaseAppParam();
                Page<BaseAppDto> baseApps = baseAppService.getPageDto(param);
                if (baseApps != null && baseApps.size() > 0) {
                    return ResponseResult.error(HttpStatusEnum.TOKEN_ERROR.getCode(),
                        HttpStatusEnum.TOKEN_ERROR.getMsg());
                } else {
                    return ResponseResult.error("1202", "未初始化数据。");
                }
            }
            redisService.set(CacheConstants.PLAT_ACCOUNT_KEY + accountId, coreAccount,
                KernelConstant.TEN_MINUTE_EXPIRE);
        }

        WebLayoutDto platConfInfoDto = platAdminEntService.getPlatConfInfoDto(coreAccount);
        return ResponseResult.ok().setResultData(platConfInfoDto);
    }

    /**
     * 第三方服务商登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PlatLog(value = "第三方服务商登录方法", category = 10, srcCode = 11)
    @PostMapping("/third/ecorgan/login")
    @Encrypt
    public ResponseResult<AppLoginInfo> thirdEcorganLogin(@RequestBody LoginBody loginBody) {
        // 生成令牌
        AppLoginInfo appLoginInfo = adminLoginService.thirdEcorganLogin(loginBody.getUsername(),
            loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid(),
            loginBody.getAppId());
        return ResponseResult.ok(appLoginInfo);
    }

    /**
     * 校验验证码
     * @param code 验证码
     * @param uuid 登录sessionId
     * @return 验证结果
     */
    @PlatLog(value = "校验验证码", category = 10)
    @GetMapping("captcha/verify")
    @Encrypt
    @LimitScope(name = "sysLoginCaptcha", key = "sysLoginCaptcha", interval = 10, count = 5)
    public ResponseResult<String> validateCaptcha(String code, String uuid) {

        FrameUserDetails loginUser = getLoginUser();
        String username = loginUser.getUsername();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = (String) redisService.get(verifyKey);
        if (captcha == null) {
            AsyncManager.me()
                .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                    Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire"),
                    loginUser.getAppId()));
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            AsyncManager.me()
                .execute(AsyncFactory.saveAdminLoginLog(KernelConstant.SUPER_SYS, username,
                    Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error"),
                    loginUser.getAppId()));
            throw new CaptchaException();
        }

        return ResponseResult.ok();
    }

}
