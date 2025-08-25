/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.admin.vo;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.frame.admin.dto.AdminUserRoleDto;
import net.linlan.frame.admin.entity.AdminUserRole;

/**
 *
 * AdminUserRole视图域:用户角色关联显示Vo类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminUserRoleVo {
    /**
     * 用户角色ID
     */
    private Long   id;
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
     * 角色ID
     */
    private Long   roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 公共管理用户ID
     */
    private Long   adminId;

    /**
     * 无参构造方法
     */
    public AdminUserRoleVo() {
    }

    /**
     * 数据赋值TO方法，将AdminUserRole的input对象赋值给AdminUserRoleVo
     */
    public static final Function TO = new Function<AdminUserRole, AdminUserRoleVo>() {
        @Nullable
        @Override
        public AdminUserRoleVo apply(@Nullable AdminUserRole input) {
            return new AdminUserRoleVo(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminUserRoleVo(AdminUserRole input) {
        this.id = input.getId();
        this.roleId = input.getRoleId();
        this.adminId = input.getAdminId();
    }

    /**
     * 数据赋值DTO方法，将AdminUserRoleDto的input对象赋值给AdminUserRoleVo
     */
    public static final Function DTO = new Function<AdminUserRoleDto, AdminUserRoleVo>() {
        @Nullable
        @Override
        public AdminUserRoleVo apply(@Nullable AdminUserRoleDto input) {
            return new AdminUserRoleVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminUserRoleVo(AdminUserRoleDto input) {
        this.id = input.getId();
        this.roleId = input.getRoleId();
        this.adminId = input.getAdminId();
        this.deptId = input.getDeptId();
        this.organId = input.getOrganId();
        this.deptName = input.getDeptName();
        this.organName = input.getOrganName();
        this.roleName = input.getRoleName();
    }

}
