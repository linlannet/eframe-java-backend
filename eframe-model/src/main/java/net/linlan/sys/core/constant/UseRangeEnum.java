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

/**
 * 应用范围枚举类
 */
public enum UseRangeEnum {
                          TIAOZHUAN("TIAOZHUAN",
                                    "跳转型"), DUIJIE("DUIJIE",
                                                   "对接型"), SSO("SSO",
                                                               "单点登录型"), SSO_TAGUAN("SSO_TAGUAN",
                                                                                    "单点登录他管型"), SSO_TUOGUAN("SSO_TUOGUAN",
                                                                                                            "单点登录托管型"), NEIBU("NEIBU",
                                                                                                                              "内部应用型"), QITA("QITA",
                                                                                                                                             "其他类型"),;

    /**
     * 配置项名称
     */
    private String key;
    /**
     * 配置项值
     */
    private String value;

    UseRangeEnum(String key, String value) {
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
