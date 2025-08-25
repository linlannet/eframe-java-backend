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

import java.util.List;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.annotation.Excels;
import net.linlan.frame.admin.entity.AdminDept;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.sys.role.entity.SysRole;

/**
 *
 * AdminUser数据域:管理用户Dto对象
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminUserDto extends AdminUser {
    /**
     * 用户昵称
     */
    @Excel(name = "用户名称")
    private String        nickName;

    /**
     * 部门对象
     */
    @Excels({ @Excel(name = "部门名称", targetAttr = "deptName", type = Excel.Type.EXPORT),
              @Excel(name = "部门负责人", targetAttr = "leader", type = Excel.Type.EXPORT) })
    private AdminDept     dept;
    /** 部门名称 */
    private String        deptName;
    /** 机构名称 */
    private String        organName;

    /**
     * 角色对象
     */
    private List<SysRole> roles;

    private Long          applyId;
}
