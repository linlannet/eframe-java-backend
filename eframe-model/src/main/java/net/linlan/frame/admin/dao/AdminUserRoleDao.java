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
package net.linlan.frame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.admin.dto.AdminUserRoleDto;
import net.linlan.frame.admin.entity.AdminUserRole;

/**
*
* AdminUserRole数据域:用户角色关联持久层Dao
* @author Linlan
* CreateTime 2024-10-02 23:27:08
*
*/
@Mapper
public interface AdminUserRoleDao extends MybatisBaseDao<AdminUserRole> {

    /**
     * 通过用户LID查询用户角色部门信息
     *
     * @param adminId 用户LID
     * @return 结果
     */
    List<AdminUserRoleDto> selectUserRoleListByAdminId(Long adminId);

    /**
     * 通过用户LID删除用户和角色关联
     *
     * @param adminId 用户LID
     * @return 结果
     */
    public int deleteByAdminId(Long adminId);

    /**
     * 批量删除用户和角色关联
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteByAdminIds(Long[] ids);

    /**
     * 通过角色ID查询角色使用数量
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int countByRoleId(Long roleId);

    /**
     * 删除用户和角色关联信息
     *
     * @param roleId 角色ID
     * @param adminId 需要删除的用户数据ID
     * @return 结果
     */
    public int deleteByRoleIdAdminId(@Param("roleId") Long roleId, @Param("adminId") Long adminId);

    /**
     * 批量取消授权用户角色
     *
     * @param roleId 角色ID
     * @param adminIds 需要删除的用户数据ID
     * @return 结果
     */
    public int deleteByRoleIdAdminIds(@Param("roleId") Long roleId,
                                      @Param("adminIds") Long[] adminIds);

}
