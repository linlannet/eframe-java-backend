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
package net.linlan.social.third.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import net.linlan.utils.enums.BaseEnumString;
import net.linlan.utils.enums.EnumConvert;

/**
 * 开放平台登录来源，用于系统微信服务号扫码登录、小程序扫码登录
 *
 * @author Linlan
 *
 */
public enum ThirdAccountTypeEnum implements BaseEnumString {
                                                            /**
                                                             * 本地授权
                                                             */
                                                            LOCAL_AUTH("local_auth", "本地授权"),

                                                            /**
                                                             * 其他
                                                             */
                                                            OTHER("other", "其他");

    /**
     * 键
     */
    @JsonValue
    private final String key;
    /**
     * 值
     */
    private final String value;

    ThirdAccountTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @EnumConvert
    public static ThirdAccountTypeEnum fromType(String key) {
        ThirdAccountTypeEnum[] values = values();
        for (ThirdAccountTypeEnum value : values) {
            if (value.getKey().equals(key)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
