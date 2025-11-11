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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.service.AdminMenuService;
import net.linlan.frame.admin.service.AdminRoleService;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.sys.web.KernelConstant;

/**
 * 用户权限处理
 * 
 * @author Linlan
 */
@Component
public class SysPermissionService {
    @Resource
    private AdminRoleService adminRoleService;

    @Resource
    private AdminMenuService adminMenuService;

    /**
     * 获取角色数据权限
     * 
     * @param user 用户信息
     * @return 角色权限信息
     */
    public Set<String> getRolePermission(AdminUserDto user) {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin()) {
            roles.add("admin");
        } else {
            roles.addAll(adminRoleService.selectRoleCodeByAdminId(user.getId()));
        }
        return roles;
    }

    /**
     * 获取菜单数据权限
     * 
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(AdminUserDto user) {
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin()) {
            perms.add("*:*:*");
        } else {
            List<SysRole> roles = user.getRoles();
            if (!CollectionUtils.isEmpty(roles)) {
                // 多角色设置permissions属性，以便数据权限匹配权限
                for (SysRole role : roles) {
                    //status 0正常1停用2已删除
                    if (role.getStatus() != null
                        && role.getStatus() == KernelConstant.DEFAULT_INT) {
                        Set<String> rolePerms = adminMenuService
                            .selectMenuPermsByRoleId(role.getId());
                        perms.addAll(rolePerms);
                    }
                }

            } else {
                perms.addAll(adminMenuService.selectMenuPermsByAdminId(user.getId()));
            }
        }
        return perms;
    }

    public FrameUserDetails createLoginUser(AdminUserDto user) {
        // 用户权限列表
        Set<String> perms = getMenuPermission(user);
        FrameUserDetails frameUserDetails = new FrameUserDetails(user.getUserId(), perms);
        frameUserDetails.setUserId(user.getUserId());
        frameUserDetails.setUserLid(user.getId());
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
        Set<String> roleCodeList = getRolePermission(user);
        roleCodeList.forEach(roleCode -> perms.add("ROLE_" + roleCode));

        frameUserDetails.setPerms(perms);
        return frameUserDetails;
    }

}
