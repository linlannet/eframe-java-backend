/*
 * module-authn - 动态认证对接模块
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
package net.linlan.authn.sms.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import net.linlan.utils.enums.BaseEnumString;
import net.linlan.utils.enums.EnumConvert;

/**
 * 短信平台枚举
 *
 * @author Linlan
 *
 */
public enum SmsPlatform implements BaseEnumString {
                                                   /**
                                                    * 阿里云短信
                                                    */
                                                   ALIYUN("aliyun", "阿里云"),
                                                   /**
                                                    * 腾讯云短信
                                                    */
                                                   TENCENT("tencloud", "腾讯云"),
                                                   /**
                                                    * 华为云短信
                                                    */
                                                   HUAWEI("huaweicloud", "华为云"),
                                                   /**
                                                    * 七牛
                                                    */
                                                   QINIU("qiniu", "七牛云"),
                                                   /**
                                                    * MINIO
                                                    */
                                                   OTHER("other", "其他短信");

    /**
     * 键
     */
    @JsonValue
    private final String key;
    /**
     * 值
     */
    private final String value;

    SmsPlatform(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @EnumConvert
    public static SmsPlatform getType(String key) {
        SmsPlatform[] values = values();
        for (SmsPlatform status : values) {
            if (String.valueOf(status.getKey()).equals(key)) {
                return status;
            }
        }
        throw new NullPointerException("未找到该平台");
    }

    @Override
    public String toString() {
        return this.key;
    }
}
