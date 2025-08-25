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
package net.linlan.frame.admin.dto;

import lombok.Data;

import net.linlan.frame.admin.entity.AdminUserRole;

/**
 *
 * AdminUserRole数据域:用户角色关联Dto对象
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminUserRoleDto extends AdminUserRole {
    /**
     * 部门ID
     */
    private Long   deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 机构ID
     */
    private String organId;
    /**
     * 机构名称
     */
    private String organName;
    /**
     * 角色名称
     */
    private String roleName;
}
