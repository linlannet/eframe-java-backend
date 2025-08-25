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
import net.linlan.commons.core.ObjectUtils;
import net.linlan.sys.base.param.BaseDicTypeParam;
import net.linlan.utils.param.BaseParam;

/**
 * 字典类型表 sys_dict_type
 * 
 * @author Linlan
 */
@Data
public class BaseDicTypeVoParam extends BaseParam {

    /** 字典主键 */
    @Excel(name = "字典主键", cellType = ColumnType.STRING)
    private String  typeId;

    /** 字典名称 */
    @Excel(name = "字典名称")
    private String  name;

    /**
     * 字典类型模式0平面1树形
     */
    private Integer typeMode;
    /** 字典类型 */
    @Excel(name = "字典类型")
    private String  typeClass;

    /** 状态（0未生效 1正常） */
    @Excel(name = "状态", readConverterExp = "0=未生效,1=正常")
    private String  status;

    /** 备注 */
    private String  remark;
    /** 关键字 */
    private String  key;

    public BaseDicTypeVoParam() {
    }

    public BaseDicTypeParam toModelParam() {
        BaseDicTypeParam result = new BaseDicTypeParam();
        result.setName(name);
        result.setTypeId(typeId);
        if (ObjectUtils.isNotEmpty(status)) {
            result.setStatus(Integer.parseInt(status));
        }
        result.setDescription(remark);
        result.setTypeClass(typeClass);
        result.setTypeMode(typeMode);
        result.setKey(key);
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        return result;
    }
}
