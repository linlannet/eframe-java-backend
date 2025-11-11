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
package net.linlan.sys.base.constant;

import net.linlan.utils.enums.BaseEnumString;

/**
 * 身份证类型枚举类
 */
public enum IdTypeEnum implements BaseEnumString {
                                                  /**
                                                   * 身份证
                                                   */
                                                  SHENFENZHENG("shenfenzheng", "身份证"),
                                                  /**
                                                   * 港澳通行证
                                                   */
                                                  GANGAOZHENG("gangaozheng", "港澳通行证"),
                                                  /**
                                                   * 台湾通行证
                                                   */
                                                  TAIWANGZHENG("taiwangzheng", "台湾通行证"),
                                                  /**
                                                   * 护照
                                                   */
                                                  HUZHAO("huzhao", "护照"),
                                                  /**
                                                   * 外国人居留证
                                                   */
                                                  WAIGUORENZHENG("waiguorenzheng", "外国人居留证"),
                                                  /**
                                                   * 其他
                                                   */
                                                  QITA("qita", "其他"),;

    /**
     * 配置项名称
     */
    private String key;
    /**
     * 配置项值
     */
    private String value;

    IdTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
