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

import net.linlan.sys.base.param.BaseConfigPartsParam;
import net.linlan.utils.param.BaseParam;

@Data
public class BaseConfigPartsVoParam extends BaseParam {

    /** 配置项名称 */
    private String   cfgKey;
    /** 配置项值 */
    private String   cfgValue;
    /**
     * 数组
     */
    private String[] ids;

    public BaseConfigPartsParam toModelParam() {
        BaseConfigPartsParam result = new BaseConfigPartsParam();
        result.setCfgKey(cfgKey);
        result.setCfgValue(cfgValue);
        result.setQ(super.getQ());
        result.setOrderBy(super.getOrderBy());
        result.setStartTime(super.getStartTime());
        result.setEndTime(super.getEndTime());
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        return result;
    }
}
