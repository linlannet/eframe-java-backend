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

/**
 *
 * SasPresetCommonDto数据域:机构预置信息通用返回Dto对象
 * @author Linlan
 * CreateTime 2023-09-07 13:55:02
 *
 */
@Data
public class PresetCommonDto {

    /**
     * 权限预置结果代码
     */
    private Integer resultCode;
    /**
     * 权限预置结果消息
     */
    private String  resultMsg;
    /**
     * 机构用户人员ID
     */
    private String  userId;

    /**
     * 用户人员名称，显示名称
     */
    private String  name;

    /**
     * 机构ID
     */
    private String  organId;
    /**
     * 机构名称
     */
    private String  organName;

}
