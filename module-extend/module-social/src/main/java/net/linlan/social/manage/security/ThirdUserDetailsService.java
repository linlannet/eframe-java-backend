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

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.social.manage.vo.ThirdUserVo;
import net.linlan.social.permission.service.ThirdPermissionService;
import net.linlan.social.third.dto.ThirdUserDto;
import net.linlan.social.third.service.ThirdMemberService;
import net.linlan.utils.exception.SupportException;

/**
 * 第三方登录
 *
 * @author Linlan
 * 
 */
@Service
public class ThirdUserDetailsService {
    @Resource
    private ThirdMemberService     thirdMemberService;
    @Resource
    private ThirdPermissionService thirdPermissionService;

    /**
     * 通过开放平台类型和唯一标识，加载用户信息
     *
     * @param serverType 开放平台类型
     * @param openId   开放平台唯一标识
     * @return 用户信息
     * @throws UsernameNotFoundException 不存在异常
     */
    FrameUserDetails loadUserByOpenTypeAndOpenId(String serverType,
                                                 String openId) throws UsernameNotFoundException {
        ThirdUserDto thirdUserDto = thirdMemberService.getThirdUserByOpenId(openId, serverType);
        if (ObjectUtils.isEmpty(thirdUserDto)) {
            throw new UsernameNotFoundException("绑定的系统用户，不存在");
        }
        if (!validateSocial(thirdUserDto)) {
            throw new SupportException("当前用户状态异常，无法正常使用");
        }

        ThirdUserVo thirdUserVo = (ThirdUserVo) ThirdUserVo.DTO.apply(thirdUserDto);

        return thirdPermissionService.createLoginUser(thirdUserVo);
    }

    public boolean validateSocial(ThirdUserDto thirdUserDto) {
        return true;
    }

}
