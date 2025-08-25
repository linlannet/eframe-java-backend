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

import java.util.Date;

import lombok.Data;

@Data
public class BaseXzqhListDto {
    /**
     * 行政区划ID
     */
    private String  id;
    /**
     * 地域级别
     */
    private String  areatypeId;
    /**
     * 本地代码
     */
    private String  code;
    /**
     * 行政区划名称
     */
    private String  name;
    /**
     * 完整名称
     */
    private String  nameTotal;
    /**
     * 是否显示
     */
    private Boolean isDisplay;
    /**
     * 排序码
     */
    private String  priority;
    /**
     * 创建时间
     */
    private Date    createTime;

}
