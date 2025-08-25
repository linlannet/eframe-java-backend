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
package net.linlan.sys.role.dto;

import lombok.Data;

/**
 *
 * SysMenu数据域:系统菜单菜单ztree对象
 * @author Linlan
 * CreateTime 2019-06-27 14:19:06
 *
 */
@Data
public class SysMenuTreeDto {
    /**
     * 功能菜单ID
     */
    private Long    id;
    /**
     * 父功能菜单ID
     */
    private Long    parentId;
    /**
     * 功能名称
     */
    private String  name;
    /**
     * 选中状态
     */
    private boolean checked;
    /**
     * 应用ID
     */
    private String  appId;

}
