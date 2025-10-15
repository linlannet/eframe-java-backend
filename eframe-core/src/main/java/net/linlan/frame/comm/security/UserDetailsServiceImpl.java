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

import com.google.common.base.Function;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.comm.service.SysPasswordService;
import net.linlan.frame.comm.service.SysPermissionService;
import net.linlan.frame.web.UserDetailsService;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.enums.UserStatus;
import net.linlan.utils.exception.CommonException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
    public FrameUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUserDto user = adminUserService.getByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            log.info("登录用户：{} 不存在.", username);
            throw new CommonException(MessageUtils.message("user.not.exists"));
        } else if (UserStatus.DELETED.getKey() == user.getDelFlag()) {
            log.info("登录用户：{} 已被删除.", username);
            throw new CommonException(MessageUtils.message("user.password.delete"));
        } else if (UserStatus.DISABLE.getKey() == user.getStatus()) {
            log.info("登录用户：{} 已被停用.", username);
            throw new CommonException(MessageUtils.message("user.blocked"));
        }

        sysPasswordService.validate(user);

        return createLoginUser(user);
    }

    public FrameUserDetails createLoginUser(AdminUserDto user) {
        // 用户权限列表
        Set<String> perms = sysPermissionService.getMenuPermission(user);
        FrameUserDetails frameUserDetails = new FrameUserDetails(user.getUserId(), perms);
        frameUserDetails.setUserId(user.getUserId());
        frameUserDetails.setUsername(user.getUsername());
        frameUserDetails.setPassword(user.getPassword());
        frameUserDetails.setViewName(user.getName());
        frameUserDetails.setDeptId(user.getDeptId());
        frameUserDetails.setOrganId(user.getOrganId());
        frameUserDetails.setMobile(user.getMobile());
        frameUserDetails.setEmail(user.getEmail());
        frameUserDetails.setImagePath(user.getImagePath());
        frameUserDetails.setUserType(user.getAdminType());
        frameUserDetails.setLoginIp(user.getLastLoginIp());
        frameUserDetails.setLoginTime(user.getLastLoginTime());
        frameUserDetails.setLoginCount(user.getLoginCount());
        // 数据权限范围关联机构部门或地域层级，TODO
        List<Long> deptIds = new ArrayList<>();

        // 用户角色编码列表
        Set<String> roleCodeList = sysPermissionService.getRolePermission(user);
        roleCodeList.forEach(roleCode -> perms.add("ROLE_" + roleCode));

        frameUserDetails.setPerms(perms);
        return frameUserDetails;
    }

    @Override
    public void changePassword(String username, String newPassword) {

    }

    @Override
    public void changePassword(String username, String oldPassword,
                               String newPassword) throws Exception {

    }

    @Override
    public FrameUserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public FrameUserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        return null;
    }
}
