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

import java.util.Objects;
import java.util.Set;

import net.linlan.frame.comm.constant.AdminType;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.FrameAdminUser;
import net.linlan.frame.comm.security.context.PermissionContextHolder;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.utils.constant.Constants;

/**
 * JavaEnt首创 自定义权限实现，ss取自SpringSecurity首字母
 * 
 * @author Linlan
 */
@Service("ss")
public class PermissionService {
    /**
     * 验证用户是否具备某权限
     * 
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPerms(String permission) {
        if (StringUtils.isEmpty(permission)) {
            return false;
        }
        FrameAdminUser loginUser = SecurityUtils.getLoginUser();
        if (ObjectUtils.isEmpty(loginUser) || CollectionUtils.isEmpty(loginUser.getPerms())) {
            return false;
        }
        PermissionContextHolder.setContext(permission);
        return hasPermissions(loginUser.getPerms(), permission);
    }

    /**
     * 验证用户是否不具备某权限，与 hasPermi逻辑相反
     *
     * @param permission 权限字符串
     * @return 用户是否不具备某权限
     */
    public boolean lacksPerms(String permission) {
        return hasPerms(permission) != true;
    }

    /**
     * 验证用户是否具有以下任意一个权限
     *
     * @param permissions 以 PERMISSION_DELIMETER 为分隔符的权限列表
     * @return 用户是否具有以下任意一个权限
     */
    public boolean hasAnyPerms(String permissions) {
        if (StringUtils.isEmpty(permissions)) {
            return false;
        }
        FrameAdminUser loginUser = SecurityUtils.getLoginUser();
        if (ObjectUtils.isEmpty(loginUser) || CollectionUtils.isEmpty(loginUser.getPerms())) {
            return false;
        }
        PermissionContextHolder.setContext(permissions);
        Set<String> authorities = loginUser.getPerms();
        for (String permission : permissions.split(Constants.PERMISSION_DELIMETER)) {
            if (permission != null && hasPermissions(authorities, permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否包含权限
     * 
     * @param permissions 权限列表
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    private boolean hasPermissions(Set<String> permissions, String permission) {
        return permissions.contains(Constants.ALL_PERMISSION)
               || permissions.contains(StringUtils.trim(permission));
    }

    /**
     * 判断是否有相应权限
     *
     * @param authority 权限
     * @return {boolean}
     */
    public boolean hasAuthority(Object authority) {
        if (Objects.isNull(authority)) {
            return false;
        }
        String adminType = SecurityUtils.getLoginUser().getAdminType();
        if (adminType.equals(AdminType.ADMIN.getType())) {
            return AdminType.ADMIN.equals(authority);
        }
        return AdminType.USER.equals(authority);
    }
}
