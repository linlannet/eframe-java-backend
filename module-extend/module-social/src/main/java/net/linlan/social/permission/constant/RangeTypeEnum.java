/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.permission.constant;

import net.linlan.utils.enums.BaseEnumInteger;

/**
 * 人员所属机构类型
 */
public enum RangeTypeEnum implements BaseEnumInteger {
                                                      /**
                                                       * 属于
                                                       */
                                                      SHUYU(0, "属于"),
                                                      /**
                                                       * 挂靠
                                                       */
                                                      GUAKAO(1, "挂靠"),
                                                      /**
                                                       * 虚拟
                                                       */
                                                      XUNI(2, "虚拟"),
                                                      /**
                                                       * 其他
                                                       */
                                                      QITA(9, "其他"),;

    /**
     * 配置项名称
     */
    private int    key;
    /**
     * 字典值
     */
    private String value;

    RangeTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
