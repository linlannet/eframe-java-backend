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

import net.linlan.sys.base.entity.BaseXzqh;

/**
 *
 * BaseXzqh数据域:行政区划Dto对象
 * @author Linlan
 * CreateTime 2023-08-12 13:37:57
 *
 */
@Data
public class BaseXzqhDto extends BaseXzqh {
    /**
     * 全局国家或地区类
     */
    private String countryName;
    /**
     * 全局行政区划父类名称
     */
    private String parentName;
    /**
     * 行政区划子节点列表集
     */
    private String areatypeName;
}
