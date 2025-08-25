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

/**
 *
 * AppPageIndexInfo视图域:APP端用户首页页面Vo实体类
 * @author Linlan
 * CreateTime 2020-06-17 11:12:25
 *
 */
@Data
public class AppPageIndexInfo {
    /**
     * 当前端ID
     */
    private String                  accountId;
    /**
     * 当前地域ID
     */
    private Long                    areaId;

    /**
     * 当前角色或分组ID
     */
    private Long                    groupId;

    /**
     * 当前岗位ID
     */
    private String                  positionId;

    /**
     * 当前页面模板方案
     */
    private String                  tplSolution;

    /**
     * 用户菜单信息列表
     */
    private List<AdminBaseMenuInfo> menuList;

}
