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
 * BaseLabel数据域:全局标签字词表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 13:37:57
 *
 */
@Data
public class BaseLabelParam extends BaseParam {

    /**
    * 标签名称
    */
    private String   name;
    /**
    * 标签属性，归类说明，搜索词标记，可以为标签分类中的关键类型，标签可扩展表、字段应用，如行政区划标签可关联行政区划表
    */
    private String   attr;
    /**
    * 被引用的次数
    */
    private Integer  refCount;
    /**
    * 标签访问次数
    */
    private Integer  accessCount;
    /**
    * 标签状态
    */
    private Integer  status;
    /**
    * 标签描述
    */
    private String   description;
    /**
     * 关键词
     */
    private String   key;
    /**
     * 企业编码
     */
    private String   entCode;
    /**
     * 机构ID
     */
    private String   organId;
    /**
     * 标签名称
     */
    private String   labelTypeName;
    /**
     * 标签Id
     */
    private String   organLabelId;
    /**
     * 类型
     */
    private String   type;
    /**
     * 类型状态
     */
    private String   typeLabelStatus;
    /**
     * 机构状态
     */
    private String   organLabelStatus;
    /**
     * 类型标签组
     */
    private String   organLabelGroup;
    /**
     * 类型绑定
     */
    private String   typeIdBind;
    /**
     * 类型Id
     */
    private String   typeId;
    /**
     * 标签集Id
     */
    private String   labelTypeId;
    /**
     * Ids
     */
    private String[] ids;

}
