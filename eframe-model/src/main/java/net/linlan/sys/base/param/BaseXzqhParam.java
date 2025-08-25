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
package net.linlan.sys.base.param;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * BaseXzqh数据域:行政区划表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 13:37:57
 *
 */
@Data
public class BaseXzqhParam extends BaseParam {

    /**
    * 行政区划父节点
    */
    private Long    parentId;

    /**
    * 国家或地区编号
    */
    private String  countryId;
    /**
    * 地域级别ID
    */
    private String  areatypeId;
    /**
    * 树左边
    */
    private Integer lft;
    /**
    * 树右边
    */
    private Integer rgt;
    /**
    * 行政区划代码
    */
    private String  code;
    /**
    * 行政区划名称
    */
    private String  name;
    /**
    * 行政区划完整名称
    */
    private String  nameTotal;
    /**
    * 行政区划简洁名称
    */
    private String  sname;
    /**
    * 名称英文
    */
    private String  nameEn;
    /**
    * 快速码
    */
    private String  searchCode;
    /**
    * 是否显示(1显示0不显示)
    */
    private Boolean isDisplay;
    /**
    * 是否有内容(1有内容，编号单位等)
    */
    private Boolean hasContent;
    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer delFlag;
    /**
    * 描述
    */
    private String  description;
    /**
     * 父节点集合
     */
    private Long[]  parentIds;
    /**
     * 父节点集合
     */
    private Long[]  areatypeIds;
    /**
     * 父节点集合
     */
    private String  likeQuery;
    /**
     * 删除时间
     */
    private String  deleteTime;
    /**
     * id集合
     */
    private Long[]  ids;
}
