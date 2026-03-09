/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.comm.vo;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * 动态模型对象数据域:通用表字段对象实体类
 * @author Linlan
 * CreateTime 2024-12-19 17:27:08
 *
 */
@Data
public class CommTableColumn extends BaseEntity {

    /** 模型编号，对应表编号 */
    private String  modelId;

    /** 归属表编号 */
    private String  tableName;

    /** 模型项编号，对应字段编号 */
    private Long    modelItemId;

    /** 列名称 */
    @NotBlank(message = "列名称不能为空")
    private String  columnName;

    /** 列值 */
    @NotBlank(message = "列值不能为空")
    private String  columnValue;

    /** 列值 */
    @NotBlank(message = "列值含义")
    private String  columnMean;

    /** JAVA字段名 */
    @NotBlank(message = "列属性不能为空")
    private String  columnType;

    /** 是否主键（1是） */
    private Boolean isPk;

    /** 是否自增（1是） */
    private Boolean isIncrement;

    /** 是否查询条件（1是） */
    private Boolean isQuery;

    /** 是否排序（1是） */
    private Boolean isOrder;

    /** 是否加密（1是） */
    private Boolean isEncryt;

    /** 是否必填（1是） */
    private Boolean isNotNull;

    /** 是否独占一行（1是） */
    private Boolean isSingle;

    /** 是否显示 */
    private Boolean isDisplay;

    /** 字典值 */
    private String  dictType;

    /** 组件类型 */
    private String  htmlType;
}
