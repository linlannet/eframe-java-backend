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
 * BaseDicType数据域:全局字典类型表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 13:37:57
 *
 */
@Data
public class BaseDicTypeParam extends BaseParam {
    /**
     * 字典类型代码
     */
    private String  typeId;
    /**
    * 字典类型名称
    */
    private String  name;
    /**
     * 全匹配查询  xxx%
     */
    private String  sname;
    /**
    * 字典类型分类
    */
    private String  typeClass;
    /**
    * 字典引用名称
    */
    private String  typeRef;
    /**
    * 字典类型模式0平面1树形
    */
    private Integer typeMode;
    /**
    * 快速码
    */
    private String  searchCode;
    /**
    * 字典类型修改状态
    */
    private Integer status;
    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer delFlag;
    /**
    * 字典类型说明
    */
    private String  description;
    /**
    * 字典类型关联表名
    */
    private String  spare1;
    /**
    * 字典类型关联表名
    */
    private String  spare2;
    /**
     * 关键字,以后用q
     */
    private String  key;
    /**
     * 存在key
     */
    private String  existKey;

}
