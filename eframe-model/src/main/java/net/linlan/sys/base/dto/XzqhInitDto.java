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

import java.io.Serializable;

import lombok.Data;

/**
 *
 * XzqhInitDto,行政区划基础信息Dto对象
 * @author Linlan
 * CreateTime 2023-08-08 13:41:37
 *
 */
@Data
public class XzqhInitDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 行政区划ID
     */
    private String            id;

    /**
     * 行政区划名称
     */
    private String            name;

}
