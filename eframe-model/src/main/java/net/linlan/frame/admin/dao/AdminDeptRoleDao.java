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

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.admin.entity.AdminDeptRole;

/**
*
* AdminDeptRole数据域:角色部门关联持久层Dao
* @author Linlan
* CreateTime 2024-10-02 23:27:08
*
*/
@Mapper
public interface AdminDeptRoleDao extends MybatisBaseDao<AdminDeptRole> {

    /**
     * 通过角色ID删除角色和部门关联
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteByRoleId(Long roleId);

    /**
     * 批量删除角色部门关联信息
     *
     * @param roleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteByRoleIds(Long[] roleIds);

    /**
     * 查询部门使用数量
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int getCountByDeptId(Long deptId);

    /**
     * 批量新增角色部门信息
     *
     * @param list 角色部门列表
     * @return 结果
     */
    public int batchSaveDeptRole(List<AdminDeptRole> list);

}
