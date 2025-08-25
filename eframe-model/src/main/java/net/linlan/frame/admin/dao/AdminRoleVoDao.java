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
import net.linlan.sys.role.entity.SysRole;

/**
 * 角色表 数据层
 * 
 * @author Linlan
 */
@Mapper
public interface AdminRoleVoDao extends MybatisBaseDao<SysRole> {

    /**
     * 根据用户LID查询角色
     * 
     * @param adminId 用户LID
     * @return 角色列表
     */
    public List<String> selectRoleCodeByAdminId(Long adminId);

    /**
     * 根据用户LID获取角色选择框列表
     * 
     * @param adminId 用户LID
     * @return 选中角色ID列表
     */
    public List<Long> selectRoleListByAdminId(Long adminId);

    /**
     * 根据用户LID查询角色
     * 
     * @param username 用户名
     * @return 角色列表
     */
    public List<SysRole> selectRolesByUsername(String username);

}
