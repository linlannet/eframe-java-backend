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
package net.linlan.sys.base.dto;

import lombok.Data;

/**
 *
 * BaseUserSelect,用户下拉框dto对象 * Description 作用：解决加载慢 * @author Linlan
 * CreateTime 2018-03-02 17:17:54 *
 */
@Data
public class BaseUserSelect {
    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户手机号
     */
    private String mobile;

}
