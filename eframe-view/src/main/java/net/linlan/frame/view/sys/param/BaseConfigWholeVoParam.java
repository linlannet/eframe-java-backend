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
import net.linlan.sys.base.param.BaseConfigWholeParam;
import net.linlan.utils.param.BaseParam;

/**
 * 参数配置表 sys_config
 * 
 * @author Linlan
 */
@Data
public class BaseConfigWholeVoParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    /** 参数键名 */
    @Excel(name = "参数键名")
    private String            configKey;

    /** 参数键值 */
    @Excel(name = "参数键值")
    private String            configValue;
    /**
     * 状态
     */
    @Excel(name = "状态")
    private Boolean           isDisabled;

    /** 描述 */
    @Excel(name = "描述")
    private String            remark;

    public BaseConfigWholeParam toModelParam() {
        BaseConfigWholeParam result = new BaseConfigWholeParam();
        result.setCfgKey(configKey);
        result.setCfgValue(configValue);
        result.setDescription(remark);
        result.setIsDisabled(isDisabled);
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        result.setQ(super.getQ());
        return result;
    }

}
