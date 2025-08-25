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

import net.linlan.frame.admin.dto.AdminDeptRoleDto;
import net.linlan.frame.admin.entity.AdminDeptRole;

/**
 *
 * AdminDeptRole视图域:角色部门关联显示Vo类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminDeptRoleVo {
    /**
     * 角色功能ID
     */
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 无参构造方法
     */
    public AdminDeptRoleVo() {
    }

    /**
     * 数据赋值TO方法，将AdminDeptRole的input对象赋值给AdminDeptRoleVo
     */
    public static final Function TO = new Function<AdminDeptRole, AdminDeptRoleVo>() {
        @Nullable
        @Override
        public AdminDeptRoleVo apply(@Nullable AdminDeptRole input) {
            return new AdminDeptRoleVo(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminDeptRoleVo(AdminDeptRole input) {
        this.id = input.getId();
        this.roleId = input.getRoleId();
        this.deptId = input.getDeptId();
    }

    /**
     * 数据赋值DTO方法，将AdminDeptRoleDto的input对象赋值给AdminDeptRoleVo
     */
    public static final Function DTO = new Function<AdminDeptRoleDto, AdminDeptRoleVo>() {
        @Nullable
        @Override
        public AdminDeptRoleVo apply(@Nullable AdminDeptRoleDto input) {
            return new AdminDeptRoleVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminDeptRoleVo(AdminDeptRoleDto input) {
        this.id = input.getId();
        this.roleId = input.getRoleId();
        this.deptId = input.getDeptId();
    }

}
