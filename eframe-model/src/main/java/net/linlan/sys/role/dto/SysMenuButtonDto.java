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
 * AdminMenu数据域:系统菜单查询结果Dto对象
 * Description 公共菜单查询结果，包括按钮信息
 * @author Linlan
 * CreateTime 2018-04-21 14:19:06
 *
 */
@Data
public class SysMenuButtonDto {
    /**
     * 主键
     */
    private String id;

    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 代码
     */
    private String code;
    /**
     * 名称
     */
    private String name;

}
