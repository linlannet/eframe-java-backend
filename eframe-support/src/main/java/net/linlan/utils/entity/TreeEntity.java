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

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 *
 * BaseEntity:基础树实体类
 * @author Linlan
 * CreateTime 2024-09-22 17:17:54
 *
 */
@Data
public class TreeEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 父菜单ID
     */
    private Long              parentId;

    /**
     * 父菜单名称
     */
    private String            parentName;

    /**
     * 排序
     */
    private Integer           priority;

    /**
     * 祖级列表
     */
    private String            searchCode;

    /**
     * 子树列表
     */
    private List<?>           children         = new ArrayList<>();

}
