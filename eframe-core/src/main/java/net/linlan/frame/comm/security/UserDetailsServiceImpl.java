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
package net.linlan.frame.comm.security;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.frame.FrameAdminUser;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.comm.service.SysPasswordService;
import net.linlan.frame.comm.service.SysPermissionService;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.enums.UserStatus;
import net.linlan.utils.exception.CommonException;

/**
 * 用户验证处理
 *
 * @author Linlan
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger  log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Resource
    private AdminUserService     adminUserService;

    @Resource
    private SysPasswordService   sysPasswordService;

    @Resource
    private SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUserDto user = adminUserService.getByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            log.info("登录用户：{} 不存在.", username);
            throw new CommonException(MessageUtils.message("user.not.exists"));
        } else if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            log.info("登录用户：{} 已被删除.", username);
            throw new CommonException(MessageUtils.message("user.password.delete"));
        } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", username);
            throw new CommonException(MessageUtils.message("user.blocked"));
        }

        sysPasswordService.validate(user);

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(AdminUserDto user) {
        return new FrameAdminUser(user.getId(), user.getDeptId(), user.getUsername(),
            user.getPassword(), user.getLastAppId(), user.getAdminType(),
            sysPermissionService.getMenuPermission(user));
    }
}
