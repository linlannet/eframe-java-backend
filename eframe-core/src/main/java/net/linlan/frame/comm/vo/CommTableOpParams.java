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

import net.linlan.utils.entity.BaseEntity;

/**
 *
 * 动态模型对象数据域:通用表字段对象实体类
 * @author Linlan
 * CreateTime 2024-12-19 17:27:08
 *
 */
@Data
public class CommTableOpParams extends BaseEntity {

    /** 字段 */
    private String  field;

    /** 字段值 */
    private String  value;

    /** 字段含义 */
    private String  label;

    /** 是否主键 */
    private Boolean isPk;

    /** 字段前端类型 */
    private String  htmlType;

    /** 字段后端类型 */
    private String  javaType;

    /** 字段 关联字典值 */
    private String  dictType;

    /** 是否必填 */
    private Boolean isNotNull;

    /** 是否单行 */
    private Boolean isSingle;

}
