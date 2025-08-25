/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.sys.param;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.annotation.Excel.ColumnType;
import net.linlan.sys.base.param.BaseDictionaryParam;
import net.linlan.utils.param.BaseParam;

/**
 * 字典数据表 sys_dict_data
 * 
 * @author Linlan
 */
@Data
public class BaseDictionaryVoParam extends BaseParam {

    /** 字典编码 */
    @Excel(name = "字典编码", cellType = ColumnType.NUMERIC)
    private Long   cddId;

    /** 字典排序 */
    @Excel(name = "字典排序", cellType = ColumnType.NUMERIC)
    private Long   dictSort;

    /**
     * 字典名称
     */
    private String name;
    /** 字典标签 */
    @Excel(name = "字典标签")
    private String dictLabel;

    /** 字典键值 */
    @Excel(name = "字典键值")
    private String cddValue;

    /** 字典类型 */
    @Excel(name = "字典类型")
    private String typeCode;

    /** 样式属性（其他样式扩展） */
    private String cssClass;

    /** 表格字典样式 */
    private String listClass;

    /** 是否默认（Y是 N否） */
    @Excel(name = "是否默认", readConverterExp = "Y=是,N=否")
    private String isDefault;

    /** 状态（0未生效 1正常） */
    @Excel(name = "状态", readConverterExp = "0=未生效,1=正常")
    private String status;

    /** 备注 */
    private String remark;

    /**
     * 关键字
     */
    private String key;

    /**
     * 快速码
     */
    private String searchCode;

    /**
     * 父节点ID
     */
    private Long   parentId;

    public BaseDictionaryVoParam() {
    }

    public BaseDictionaryParam toModelParam() {
        BaseDictionaryParam result = new BaseDictionaryParam();
        result.setName(dictLabel);
        result.setCddValue(cddValue);
        result.setTypeCode(typeCode);
        result.setDispFlag(status);
        result.setDescription(remark);
        result.setKey(key);
        result.setSearchCode(searchCode);
        if (parentId != null) {
            result.setParentId(parentId);
        }
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        result.setQ(super.getQ());
        return result;
    }
}
