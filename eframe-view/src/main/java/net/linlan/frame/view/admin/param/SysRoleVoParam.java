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
package net.linlan.frame.view.admin.param;

import lombok.Data;

import net.linlan.sys.role.param.SysRoleParam;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.param.BaseParam;

/**
 * 角色查询对象EntAdminRoleQo
 * 
 * @author Linlan
 */
@Data
public class SysRoleVoParam extends BaseParam {

    /** 角色ID */
    private Long    roleId;

    /** 角色名称 */
    private String  roleName;

    /** 角色权限 */
    private String  roleKey;

    /** 角色状态（0未生效 1正常） */
    private Integer status;

    public SysRoleParam toModelParam() {
        SysRoleParam result = new SysRoleParam();
        result.setName(roleName);
        result.setCode(roleKey);
        result.setStatus(status);
        result.setAppId(Constants.ENT_APP_ID);
        result.setQ(super.getQ());
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        return result;
    }

}
