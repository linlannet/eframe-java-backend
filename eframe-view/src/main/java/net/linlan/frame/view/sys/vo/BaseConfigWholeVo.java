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
import net.linlan.annotation.Excel.ColumnType;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dto.BaseConfigWholeDto;
import net.linlan.sys.base.entity.BaseConfigWhole;

/**
 * 参数配置表 sys_config
 * 
 * @author Linlan
 */
@Data
public class BaseConfigWholeVo {

    /** 参数主键 */
    @Excel(name = "参数主键", cellType = ColumnType.STRING)
    private String  configId;

    /** 参数键名 */
    @Excel(name = "参数键名")
    private String  configKey;

    /** 参数键值 */
    @Excel(name = "参数键值")
    private String  configValue;
    /**
     * 状态
     */
    private Boolean isDisabled;

    /** 备注 */
    @Excel(name = "备注")
    private String  remark;

    public BaseConfigWholeVo() {
    }

    /**
     * 数据赋值DTO方法，将BaseConfigWholeDto的input对象赋值给GlobalConfigVo
     */
    public static final Function TO = new Function<BaseConfigWhole, BaseConfigWholeVo>() {
        @Nullable
        @Override
        public BaseConfigWholeVo apply(@Nullable BaseConfigWhole input) {
            return new BaseConfigWholeVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseConfigWholeVo(BaseConfigWhole input) {
        this.configId = input.getId();
        this.configKey = input.getCfgKey();
        this.configValue = input.getCfgValue();
        this.isDisabled = input.getIsDisabled();
        this.remark = input.getDescription();
    }

    /**
     * 数据赋值DTO方法，将BaseConfigWholeDto的input对象赋值给GlobalConfigVo
     */
    public static final Function DTO = new Function<BaseConfigWholeDto, BaseConfigWholeVo>() {
        @Nullable
        @Override
        public BaseConfigWholeVo apply(@Nullable BaseConfigWholeDto input) {
            return new BaseConfigWholeVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseConfigWholeVo(BaseConfigWholeDto input) {
        this.configId = input.getId();
        this.configKey = input.getCfgKey();
        this.configValue = input.getCfgValue();
        this.isDisabled = input.getIsDisabled();
        this.remark = input.getDescription();
    }

    public static BaseConfigWhole transTo(BaseConfigWholeVo input) {
        BaseConfigWhole result = new BaseConfigWhole();
        if (StringUtils.isNotEmpty(input.getConfigId())) {
            result.setId(input.getConfigId());
        }
        result.setCfgKey(input.getConfigKey());
        result.setCfgValue(input.getConfigValue());
        result.setIsDisabled(input.getIsDisabled());
        result.setDescription(input.getRemark());
        return result;
    }

}
