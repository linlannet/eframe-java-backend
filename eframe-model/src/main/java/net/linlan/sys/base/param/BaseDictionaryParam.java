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
 * BaseDictionary数据域:全局公共字典表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 13:37:57
 *
 */
@Data
public class BaseDictionaryParam extends BaseParam {

    /**
    * 字典类型代码
    */
    private String   typeCode;
    /**
    * 字典父节点编号，简单的字典使用
    */
    private Long     parentId;
    /**
     * 是否所有
     */
    private String   isAllChild;
    /**
    * 字典名称
    */
    private String   name;
    /**
    * 字典名称简称，英文，多语种名称
    */
    private String   sname;
    /**
    * 字典值
    */
    private String   cddValue;
    /**
    * 字典级别, tree时有效
    */
    private String   cddLevel;
    /**
    * 快速码
    */
    private String   searchCode;
    /**
    * 显示标记，用|分隔，第1位全部第2位重点第3位特殊分类；如1|1|0
    */
    private String   dispFlag;
    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer  delFlag;
    /**
    * 描述
    */
    private String   description;
    /**
     * 关键字,以后用q
     */
    private String   key;
    /**
     * 存在key
     */
    private String   existKey;
    /**
     * typeMode
     */
    private String   typeMode;
    /**
     * id集合
     */
    private Long[]   ids;
    /**
     * 字典类型代码
     */
    private String[] typeCodes;
}
