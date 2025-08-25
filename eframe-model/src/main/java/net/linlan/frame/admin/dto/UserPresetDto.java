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
package net.linlan.frame.admin.dto;

import lombok.Data;

import net.linlan.frame.admin.entity.UserPreset;

/**
 *
 * SasPowerPreset数据域:权限预置信息查询结果Dto对象
 * @author Linlan
 * CreateTime 2023-08-29 13:55:02
 *
 */
@Data
public class UserPresetDto extends UserPreset {

    /**
     * 角色组名称，角色名称
     */
    private String groupName;

    /**
     * 岗名称
     */
    private String positionName;
    /**
     * 业务范围名称
     */
    private String bizPowerName;
    /**
     * 业务范围,街镇名称
     */
    private String subdistrictName;
    /**
     * 业务范围,居委名称
     */
    private String communityName;

}
