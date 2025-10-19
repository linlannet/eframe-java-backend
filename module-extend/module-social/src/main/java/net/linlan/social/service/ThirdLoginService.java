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

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.*;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.comm.manager.AsyncManager;
import net.linlan.frame.comm.manager.factory.AsyncFactory;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.social.constant.ProviderType;
import net.linlan.social.security.ThirdAuthenticationToken;
import net.linlan.social.third.entity.ThirdMember;
import net.linlan.social.third.entity.ThirdMemberBind;
import net.linlan.social.third.service.ThirdMemberBindService;
import net.linlan.social.third.service.ThirdMemberService;
import net.linlan.social.vo.ThirdLoginBody;
import net.linlan.sys.base.constant.CreateTypeEnum;
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.base.constant.SrcCodeEnum;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.base.entity.BaseUserExt;
import net.linlan.sys.base.service.BaseUserService;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.core.service.CoreAccountService;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.ServletUtils;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.exception.CommonException;
import net.linlan.utils.exception.SupportException;
import net.linlan.utils.ip.IPUtils;
import static net.linlan.social.constant.ProviderType.*;

/**
 * 登录校验方法
 * 
 * @author Linlan
 */
@Component
public class ThirdLoginService {
    @Resource
    private TokenService           tokenService;
    @Resource
    private AuthenticationManager  authenticationManager;
    @Resource
    private BaseUserService        baseUserService;
    @Resource
    private CoreAccountService     coreAccountService;
    @Resource
    private ThirdMemberService     thirdMemberService;
    @Resource
    private ThirdMemberBindService thirdMemberBindService;

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

    /**
     * 根据类型，获取授权请求
     *
     * @param serverType 第三方登录类型，如：wechat_oauth，alipay_oauth
     * @return 返回授权请求对象
     */
    public AuthRequest getAuthRequest(String serverType) {
        CoreAccount config = coreAccountService.getByServerType(serverType);

        if (config == null) {
            throw new CommonException("未配置第三方登录，请配置后再尝试");
        }

        AuthRequest authRequest;
        ProviderType providerType = ProviderType.fromType(serverType);

        if (WECHAT_WORK_OAUTH.equals(providerType)) {
            authRequest = new AuthWeChatEnterpriseQrcodeRequest(AuthConfig.builder()
                .clientId(config.getClientId()).clientSecret(config.getClientSecret())
                .redirectUri(config.getServerUrl()).agentId(config.getServerConf1()).build());
        } else if (DINGTALK_OAUTH.equals(providerType)) {
            authRequest = new AuthDingTalkRequest(AuthConfig.builder()
                .clientId(config.getClientId()).clientSecret(config.getClientSecret())
                .redirectUri(config.getServerUrl()).build());
        } else if (FEISHU_OAUTH.equals(providerType)) {
            authRequest = new AuthFeishuRequest(AuthConfig.builder().clientId(config.getClientId())
                .clientSecret(config.getClientSecret()).redirectUri(config.getServerUrl()).build());
        } else if (WECHAT_OAUTH.equals(providerType)) {
            authRequest = new AuthWeChatOpenRequest(AuthConfig.builder()
                .clientId(config.getClientId()).clientSecret(config.getClientSecret())
                .redirectUri(config.getServerUrl()).build());
        } else {
            throw new IllegalArgumentException(
                "Unsupported identity provider type: " + providerType);
        }

        return authRequest;
    }

    public void bind(String userId, String platformType, AuthUser authUser) {
        //保存ThirdMember
        Long memberId = null;
        ThirdMember thirdMember = thirdMemberService.findByUserId(userId);
        CoreAccount coreAccount = coreAccountService.getByServerType(platformType);
        if (thirdMember == null) {
            thirdMember = new ThirdMember();
            memberId = RandomUtils.randomLid();
            thirdMember.setId(memberId);
            thirdMember.setUserId(userId);
            thirdMember.setOpenId(authUser.getUuid());
            if (coreAccount != null) {
                thirdMember.setAccountId(coreAccount.getId());
            }
            thirdMember.setServerType(platformType);
            thirdMember.setAvatarUrl(authUser.getAvatar());
            thirdMemberService.save(thirdMember);
        } else {
            memberId = thirdMember.getId();
            thirdMember.setUserId(userId);
            thirdMember.setOpenId(authUser.getUuid());
            if (coreAccount != null) {
                thirdMember.setAccountId(coreAccount.getId());
            }
            thirdMember.setServerType(platformType);
            thirdMember.setAvatarUrl(authUser.getAvatar());
            thirdMember.setDelFlag(DelFlagEnum.NORMAL.getKey());
            thirdMemberService.update(thirdMember);
        }

        //保存BaseUser和BaseUserExt
        BaseUser baseUser = baseUserService.findById(userId);
        if (baseUser == null) {
            baseUser = new BaseUser();
            baseUser.setId(userId);
            baseUser.setSource(coreAccount.getId());
            baseUser.setCreateType(CreateTypeEnum.AUTH.getKey());
            baseUser.setSrcCode(SrcCodeEnum.SRC_CODE_THIRD.getKey());
            baseUser.setUsername(authUser.getUsername());
            baseUser.setEmail(authUser.getEmail());
            baseUser.setSpare2(authUser.getUuid());
            baseUser.setLastLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
            baseUser.setLastLoginTime(new Date());
            baseUser.setLoginCount(1);
            baseUser.setCurrentLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
            baseUser.setCurrentLoginTime(new Date());
            BaseUserExt baseUserExt = new BaseUserExt();
            baseUser.setBaseUserExt(baseUserExt);
            baseUserExt.setNickname(authUser.getNickname());
            baseUserExt.setSex(authUser.getGender().getDesc());
            baseUserExt.setImagePath(authUser.getAvatar());
            baseUserExt.setIntro(authUser.getRemark());
            baseUserExt.setComefrom(authUser.getLocation());
            baseUserExt.setResume(authUser.getRawUserInfo().toJSONString());
            baseUserExt.setSpare1(authUser.getCompany());
            baseUserExt.setSpare2(authUser.getSource());
            baseUserService.save(baseUser);
        } else {
            baseUser.setId(userId);
            baseUser.setSource(coreAccount.getId());
            baseUser.setCreateType(CreateTypeEnum.AUTH.getKey());
            baseUser.setSrcCode(SrcCodeEnum.SRC_CODE_THIRD.getKey());
            baseUser.setUsername(authUser.getUsername());
            baseUser.setEmail(authUser.getEmail());
            baseUser.setSpare2(authUser.getUuid());
            baseUser.setLastLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
            baseUser.setLastLoginTime(new Date());
            baseUser.setLoginCount(1);
            baseUser.setCurrentLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
            baseUser.setCurrentLoginTime(new Date());
            BaseUserExt baseUserExt = baseUser.getBaseUserExt();
            baseUserExt.setNickname(authUser.getNickname());
            baseUserExt.setSex(authUser.getGender().getDesc());
            baseUserExt.setImagePath(authUser.getAvatar());
            baseUserExt.setIntro(authUser.getRemark());
            baseUserExt.setComefrom(authUser.getLocation());
            baseUserExt.setResume(authUser.getRawUserInfo().toJSONString());
            baseUserExt.setSpare1(authUser.getCompany());
            baseUserExt.setSpare2(authUser.getSource());
            baseUser.setBaseUserExt(baseUserExt);
            baseUserService.update(baseUser);
        }
        //保存绑定记录
        ThirdMemberBind thirdMemberBind = thirdMemberBindService.findByUserIdAccountKey(userId,
            authUser.getUuid());
        if (thirdMemberBind == null) {
            thirdMemberBind = new ThirdMemberBind();
            thirdMemberBind.setMemberId(memberId);
            thirdMemberBind.setUserId(userId);
            thirdMemberBind.setUsername(authUser.getUsername());
            if (coreAccount != null) {
                thirdMember.setAccountId(coreAccount.getId());
            }
            thirdMemberBind.setAccountKey(authUser.getUuid());
            thirdMemberBind.setBindTime(new Date());
            thirdMemberBind.setAdditionInfo(authUser.getRawUserInfo().toJSONString());
            thirdMemberBind.setDelFlag(DelFlagEnum.NORMAL.getKey());
            thirdMemberBindService.save(thirdMemberBind);
        } else {
            //当前用户可能解绑过，设置状态可用即可
            thirdMemberBind.setDelFlag(DelFlagEnum.NORMAL.getKey());
            thirdMemberBindService.update(thirdMemberBind);
        }

    }

    public void unBind(String userId, String platformType) {
        ThirdMember thirdMember = thirdMemberService.findByUserId(userId);
        CoreAccount coreAccount = coreAccountService.getByServerType(platformType);
        String accountId = "";
        if (coreAccount != null) {
            accountId = coreAccount.getId();
        }
        if (thirdMember != null && StringUtils.isNotBlank(accountId)) {
            //设置会员用户状态为应用锁定
            thirdMember.setDelFlag(DelFlagEnum.LOCKED.getKey());
            thirdMemberService.update(thirdMember);
            //设置会员用户绑定状态为应用锁定
            ThirdMemberBind thirdMemberBind = thirdMemberBindService.findByUserIdAccountId(userId,
                accountId);
            if (thirdMemberBind != null) {
                thirdMemberBind.setDelFlag(DelFlagEnum.LOCKED.getKey());
                thirdMemberBindService.update(thirdMemberBind);
            }
        }
    }
}
