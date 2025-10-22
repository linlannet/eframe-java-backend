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
package net.linlan.sys.core.constant;

import net.linlan.utils.enums.BaseEnumInteger;

/**
 * 对接模式枚举类
 */
public enum InoutModeEnum implements BaseEnumInteger {
                                                      /**
                                                       * 内部接入
                                                       */
                                                      INOUT_MODE_INNER_IN(0, "内部接入"),
                                                      /**
                                                       * 内部接出
                                                       */
                                                      INOUT_MODE_INNER_OUT(1, "内部接出"),
                                                      /**
                                                       * 外部接入
                                                       */
                                                      INOUT_MODE_OUTER_IN(11, "外部接入"),
                                                      /**
                                                       * 双向接出接入
                                                       */
                                                      INOUT_MODE_TWO_WAY(20, "双向接出接入"),
                                                      /**
                                                       * 城市平台对接类短信平台
                                                       */
                                                      INOUT_MODE_SMY_SMS(40, "城市平台对接类短信平台"),;

    private int    key;

    private String value;

    InoutModeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
