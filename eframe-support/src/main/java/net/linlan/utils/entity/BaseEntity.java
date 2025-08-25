/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 *
 * BaseEntity:基础实体类,所有实体类的父类，包含创建时间、最后时间、创建人基础字段
 * Description 保存的时候自动补齐这些字段 
 * @author Linlan
 * CreateTime 2021-11-22 17:17:54
 *
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建人id
     */
    private String            creatorId;
    /**
     * 创建时间
     */
    private Date              createTime;

    /**
     * 最后修改时间
     */
    private Date              lastTime;

}
