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
package net.linlan.frame.admin.param;

import lombok.Data;

import net.linlan.commons.core.StringUtils;
import net.linlan.sys.role.param.SysMenuParam;
import net.linlan.utils.param.BaseParam;

/**
 * 菜单权限表 ADMIN_MENU
 * 
 * @author Linlan
 */
@Data
public class AdminMenuVoParam extends BaseParam {

    /** 菜单ID */
    private Long   menuId;

    /** 菜单名称 */
    private String menuName;

    /** 父菜单ID */
    private Long   parentId;

    /** 当前appId */
    private String currAppId;

    /** 类型（M目录 C菜单 F按钮） */
    private String menuType;

    /** 显示状态（0隐藏 1显示） */
    private String visible;

    /** 菜单状态（0未生效 1正常） */
    private String status;
    /** 状态0正常1停用2已删除 */
    private String delFlag;

    public SysMenuParam toModelParam() {
        SysMenuParam result = new SysMenuParam();
        result.setName(menuName);
        result.setParentId(parentId);
        result.setUrlType(menuType);
        result.setIsDisplay(
            StringUtils.isNotEmpty(visible) ? (visible.equals("1") ? true : false) : null);
        result.setIsDisabled(
            StringUtils.isNotEmpty(status) ? (status.equals("1") ? true : false) : null);
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        return result;
    }

}
