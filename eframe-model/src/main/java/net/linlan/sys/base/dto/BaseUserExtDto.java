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

import net.linlan.sys.base.entity.BaseUserExt;

/**
 *
 * BaseUserExt数据域:基础用户扩展信息Dto对象
 * @author Linlan
 * CreateTime 2023-08-12 13:37:57 *
 */
@Data
public class BaseUserExtDto extends BaseUserExt {
    /**
     * 行政区划名称
     */
    private String xzqhName;
}
