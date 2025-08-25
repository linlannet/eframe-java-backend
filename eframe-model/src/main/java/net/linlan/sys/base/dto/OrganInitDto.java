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
 * 机构基础信息，只保留基础常用字段，根据需要酌情添加，减少空间占用
 */
@Data
public class OrganInitDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 机构树id
     */
    private String            organwId;
    /**
     * 机构ID
     */
    private String            organId;
    /**
     * 机构名称,对应BASE_ORGAN.NAME
     */
    private String            name;
    /**
     * 区域id
     */
    private String            areaId;
    /**
     * 简称,对应BASE_ORGAN.SPARE1
     */
    private String            organName;
    /**
     * 全路径
     */
    private String            searchCode;
    /**
     * 全区域
     */
    private String            fullArea;
    /**
     * 全名称
     */
    private String            fullName;
    /**
     * 地域级别
     */
    private String            areaType;
    /**
     * 下级菜单个数
     */
    private Integer           countNextArea;
}
