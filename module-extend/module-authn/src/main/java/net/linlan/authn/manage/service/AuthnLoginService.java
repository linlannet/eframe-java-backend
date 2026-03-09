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
package net.linlan.authn.manage.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import net.linlan.authn.mail.dto.EmailRegisterDto;
import net.linlan.authn.manage.vo.MobileLoginBody;
import net.linlan.authn.sms.cache.SmsSendCache;
import net.linlan.authn.sms.security.MobileAuthenticationToken;
import net.linlan.authn.sms.service.SmsSendService;
import net.linlan.commons.core.RandomUtils;
import net.linlan.constant.AdminType;
import net.linlan.constant.UserStatus;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.constant.LogCategoryEnum;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.comm.manager.AsyncManager;
import net.linlan.frame.comm.manager.factory.AsyncFactory;
import net.linlan.frame.comm.service.AdminLoginService;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.sys.base.constant.CreateTypeEnum;
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.ServletUtils;
import net.linlan.utils.constant.CacheConstants;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.exception.SupportException;
import net.linlan.utils.ip.IPUtils;
import static net.linlan.utils.constant.Constants.ENT_APP_ID;

/**
 * 登录校验方法
 * 
 * @author Linlan
 */
@Component
public class AuthnLoginService {
    @Value("${spring.profiles.active}")
    private String                activeMode;

    @Resource
    private TokenService          tokenService;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private AdminUserService      adminUserService;
    @Resource
    private AdminLoginService     adminLoginService;
    @Resource
    private SmsSendService        smsSendService;
    @Resource
    private SmsSendCache          smsSendCache;
    @Resource
    private RedisService          redisService;

    private final String[]        avatarList = { "https://api.dicebear.com/6.x/pixel-art/svg?seed=Raccoon",
                                                 "https://api.dicebear.com/6.x/pixel-art/svg?seed=Kitty",
                                                 "https://api.dicebear.com/6.x/pixel-art/svg?seed=Puppy",
                                                 "https://api.dicebear.com/6.x/pixel-art/svg?seed=Bunny",
                                                 "https://api.dicebear.com/6.x/pixel-art/svg?seed=Fox" };

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
        adminLoginService.recordLoginInfo(loginUser.getUserLid(), loginUser.getUserId());
        AsyncManager.me()
            .execute(AsyncFactory.saveAdminLoginLog(loginUser.getUserId(), loginUser.getUsername(),
                Constants.LOGIN_SUCCESS, MessageUtils.message("user.authn.login.success"),
                loginUser.getAppId(), loginUser.getUserLid(), LogCategoryEnum.ADMIN.getKey()));
        // 生成token
        AppLoginInfo appLoginInfo = tokenService.createToken(loginUser);
        return appLoginInfo;
    }

    public boolean sendCode(String mobile) {
        // 生成6位验证码
        String code = RandomUtils.randomNumbers(6);

        AdminUserDto user = adminUserService.getByMobile(mobile);
        if (user == null) {
            throw new SupportException("手机号未注册");
        }

        // 发送短信
        if (activeMode.contains("dev") || activeMode.contains("ver")) {
            smsSendCache.saveCode(mobile, "251021");
            return true;
        }
        return smsSendService.sendCode(mobile, "code", code);
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean register(EmailRegisterDto dto) {

        validateEmailCode(dto);
        AdminUser email = adminUserService.getByEmail(dto.getEmail());
        if (email != null) {
            throw new SupportException("当前邮箱已注册，请前往登录");
        }

        //获取随机头像
        String avatar = avatarList[(int) (Math.random() * avatarList.length)];
        AdminUser adminUser = new AdminUser();
        adminUser.setUserId(RandomUtils.UUID32());
        adminUser.setCreateType(CreateTypeEnum.INPUT.getKey());
        adminUser.setName(dto.getNickname());
        adminUser.setUsername(dto.getNickname());
        adminUser.setEmail(dto.getEmail());
        adminUser.setPassword(dto.getPassword());
        adminUser.setImagePath(avatar);
        adminUser.setAdminType(AdminType.ADMIN.getType());
        adminUser.setIsSuperAdmin(false);
        adminUser.setIsAuditAdmin(false);
        adminUser.setIsSelfAdmin(false);
        adminUser.setLastAppId(ENT_APP_ID);
        adminUser.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
        adminUser.setLastLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
        adminUser.setStatus(UserStatus.OK.getKey());
        adminUser.setDelFlag(DelFlagEnum.NORMAL.getKey());
        adminUserService.save(adminUser);
        //添加用户角色信息, TODO

        redisService.delete(CacheConstants.CAPTCHA_CODE_KEY + dto.getEmail());
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean forgot(EmailRegisterDto dto) {
        validateEmailCode(dto);
        AdminUser email = adminUserService.getByEmail(dto.getEmail());
        if (email == null) {
            throw new SupportException("当前邮箱未注册，请前往注册");
        }
        adminUserService.resetUserPwd(email.getUsername(), dto.getPassword());
        redisService.delete(CacheConstants.CAPTCHA_CODE_KEY + dto.getEmail());
        return true;
    }

    private void validateEmailCode(EmailRegisterDto dto) {
        Object code = redisService.get(CacheConstants.CAPTCHA_CODE_KEY + dto.getEmail());
        if (code == null || !code.equals(dto.getCode())) {
            throw new SupportException("验证码已过期或输入错误");
        }
    }

}
