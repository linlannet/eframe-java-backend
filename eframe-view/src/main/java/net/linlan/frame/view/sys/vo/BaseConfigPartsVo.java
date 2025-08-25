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
package net.linlan.frame.view.sys.vo;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dto.BaseConfigPartsDto;
import net.linlan.sys.base.dto.BaseConfigWholeDto;
import net.linlan.sys.base.entity.BaseConfigParts;

@Data
public class BaseConfigPartsVo {

    /** 配置项名称 */
    @Excel(name = "配置项名称", cellType = Excel.ColumnType.STRING)
    private String cfgKey;
    /** 配置项值 */
    @Excel(name = "配置项值")
    private String cfgValue;

    public BaseConfigPartsVo() {
    }

    /**
     * 数据赋值方法，将BaseConfigParts的input对象赋值给BaseConfigPartsEntVo
     */
    public static final Function TO = new Function<BaseConfigParts, BaseConfigPartsVo>() {
        @Nullable
        @Override
        public BaseConfigPartsVo apply(@Nullable BaseConfigParts input) {
            return new BaseConfigPartsVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseConfigPartsVo(BaseConfigParts input) {
        this.cfgKey = input.getId();
        this.cfgValue = input.getCfgValue();

    }

    /**
     * 数据赋值DTO方法，将BaseConfigPartsDto的input对象赋值给BaseConfigPartsEntVo
     */
    public static final Function DTO = new Function<BaseConfigPartsDto, BaseConfigPartsVo>() {
        @Nullable
        @Override
        public BaseConfigPartsVo apply(@Nullable BaseConfigPartsDto input) {
            return new BaseConfigPartsVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseConfigPartsVo(BaseConfigWholeDto input) {
        this.cfgKey = input.getId();
        this.cfgValue = input.getCfgValue();
    }

    public static BaseConfigParts transTo(BaseConfigPartsVo input) {
        BaseConfigParts result = new BaseConfigParts();
        if (StringUtils.isNotEmpty(input.getCfgKey())) {
            result.setId(input.getCfgKey());
        }
        result.setId(input.getCfgKey());
        result.setCfgValue(input.getCfgValue());
        return result;
    }

}
