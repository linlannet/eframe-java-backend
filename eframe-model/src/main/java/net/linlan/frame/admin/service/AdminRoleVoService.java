/*
 * eframe-model - model模型数据模块
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
package net.linlan.frame.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.frame.admin.dao.AdminRoleVoDao;
import net.linlan.frame.admin.dao.AdminUserRoleDao;
import net.linlan.frame.admin.entity.AdminUserRole;

/**
 * 角色 业务层处理
 * 
 * @author Linlan
 */
@Service
public class AdminRoleVoService {
    @Resource
    private AdminRoleVoDao   frameAdminRoleDao;

    @Resource
    private AdminUserRoleDao adminUserRoleDao;

    /**
     * 根据用户LID获取角色选择框列表
     *
     * @param adminId 用户LID
     * @return 选中角色ID列表
     */
    public List<Long> selectRoleListByAdminId(Long adminId) {
        return frameAdminRoleDao.selectRoleListByAdminId(adminId);
    }

    /**
     * 根据用户LID查询权限
     * 
     * @param adminId 用户LID
     * @return 权限列表
     */
    public Set<String> selectRoleCodeByAdminId(Long adminId) {
        List<String> perms = frameAdminRoleDao.selectRoleCodeByAdminId(adminId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (ObjectUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 取消授权用户角色
     *
     * @param roleId 角色ID
     * @param adminId 需要取消授权的用户数据ID
     * @return 结果
     */
    public int deleteAuthUser(Long roleId, Long adminId) {
        return adminUserRoleDao.deleteByRoleIdAdminId(roleId, adminId);
    }

    /**
     * 批量取消授权用户角色
     *
     * @param roleId 角色ID
     * @param adminIds 需要取消授权的用户数据ID
     * @return 结果
     */
    public int deleteAuthUsers(Long roleId, Long[] adminIds) {
        return adminUserRoleDao.deleteByRoleIdAdminIds(roleId, adminIds);
    }

    /**
     * 批量选择授权用户角色
     *
     * @param roleId 角色ID
     * @param adminIds 需要授权的用户数据ID
     * @return 结果
     */
    public int insertAuthUsers(Long roleId, Long[] adminIds) {
        // 新增用户与角色管理
        List<AdminUserRole> list = new ArrayList<AdminUserRole>();
        for (Long adminId : adminIds) {
            AdminUserRole ur = new AdminUserRole();
            ur.setAdminId(adminId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        adminUserRoleDao.batchSave(list);
        return 1;
    }

}
