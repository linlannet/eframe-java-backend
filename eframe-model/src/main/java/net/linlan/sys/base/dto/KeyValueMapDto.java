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

import net.linlan.utils.entity.BaseEntity;

/**
 *
 * Filename:SceneStandardType.java
 * Desc:
 *
 * @author Linlan
 * CreateTime:2018-07-07 17:25:55
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class KeyValueMapDto extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 规格类型ID
     */
    private String            cmsKey;
    /**
     * 站点ID
     */
    private String            cmsValue;

}
