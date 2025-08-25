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
import java.util.List;

import lombok.Data;

/**
 * 通用树，节点信息
 */
@Data
public class TreeNode implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private String            id;
    /**
     * 名称
     */
    private String            label;
    /**
     * 简称
     */
    private String            shortName;
    /**
     * 机构id
     */
    private String            organId;
    /**
     * 行政区划id
     */
    private Long              areaId;
    /**
     * 全路径
     */
    private String            searchCode;
    /**
     * 子类数量
     */
    private int               childNum;
    /**
     * 是否选中
     */
    private boolean           checked          = false;
    /**
     * 是否实体，1 是，0 否
     */
    private int               entity;
    /**
     * 是否显示
     */
    private boolean           show             = true;
    /**
     * 是否显示图标
     */
    private boolean           showIcon         = true;
    /**
     * 父id
     */
    private String            parentId;
    /**
     * 子对象
     */
    private List<TreeNode>    children;
}
