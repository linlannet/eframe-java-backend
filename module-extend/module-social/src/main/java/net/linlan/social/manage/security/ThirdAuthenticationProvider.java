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

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

import net.linlan.frame.FrameUserDetails;

/**
 * 第三方登录 ThirdAuthenticationProvider
 *
 * @author Linlan
 * 
 */
@Slf4j
public class ThirdAuthenticationProvider implements AuthenticationProvider, InitializingBean,
                                         MessageSourceAware {
    protected MessageSourceAccessor        messages          = SpringSecurityMessageSource
        .getAccessor();
    private final GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();
    private final ThirdUserDetailsService  thirdUserDetailsService;
    private final ThirdOpenIdService       thirdOpenIdService;

    public ThirdAuthenticationProvider(ThirdUserDetailsService thirdUserDetailsService,
                                       ThirdOpenIdService thirdOpenIdService) {
        this.thirdUserDetailsService = thirdUserDetailsService;
        this.thirdOpenIdService = thirdOpenIdService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.isInstanceOf(ThirdAuthenticationToken.class, authentication,
            () -> messages.getMessage("ThirdAuthenticationProvider.onlySupports",
                "Only ThirdAuthenticationProvider is supported"));

        ThirdAuthenticationToken authenticationToken = (ThirdAuthenticationToken) authentication;
        ThirdLogin login = (ThirdLogin) authenticationToken.getPrincipal();

        try {
            // 获取用户 openId
            String openId = thirdOpenIdService.getOpenId(login);
            // 获取用户信息
            FrameUserDetails frameUserDetails = thirdUserDetailsService
                .loadUserByOpenTypeAndOpenId(login.getOpenType(), openId);
            if (frameUserDetails == null) {
                throw new BadCredentialsException("Bad credentials");
            }

            return createSuccessAuthentication(authentication, frameUserDetails);
        } catch (UsernameNotFoundException ex) {
            throw new BadCredentialsException(this.messages
                .getMessage("ThirdAuthenticationProvider.badCredentials", "Bad credentials"));
        }

    }

    protected Authentication createSuccessAuthentication(Authentication authentication,
                                                         UserDetails user) {
        ThirdAuthenticationToken result = new ThirdAuthenticationToken(user,
            authoritiesMapper.mapAuthorities(user.getAuthorities()));
        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ThirdAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(thirdUserDetailsService, "thirdUserDetailsService must not be null");
        Assert.notNull(thirdOpenIdService, "thirdOpenIdService must not be null");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messages = new MessageSourceAccessor(messageSource);
    }

}
