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

import java.util.List;

import lombok.Data;

import net.linlan.frame.web.model.TreeSelect;

/**
 *
 * MenuTreeRoleVo视图域: 基于角色获取菜单树Vo类
 * 适用管理模式用户
 * @author Linlan
 * CreateTime 2024-09-07 17:24:27
 *
 */
@Data
public class MenuTreeRoleVo {

    /**
     * 选中菜单列表
     */
    private List<Long>       checkedKeys;

    /**
     * 下拉树结构列表
     */
    private List<TreeSelect> menus;

}
