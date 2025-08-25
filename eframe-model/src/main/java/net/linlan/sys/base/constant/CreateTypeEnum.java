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

/**
 * 创建类型枚举，数字类型
 */
public enum CreateTypeEnum {
                            IMPORT(0,
                                   "导入"), INPUT(1,
                                                "录入"), AUTH(2,
                                                            "授权"), AUTH_SMY(40,
                                                                            "市民云授权"), AUTH_ZWWX(41,
                                                                                                "政务微信授权"), AUTH_WECHAT(42,
                                                                                                                       "微信授权"), AUTH_ALIPAY(43,
                                                                                                                                            "支付宝授权"), AUTH_RONGMEITI(50,
                                                                                                                                                                     "融媒体授权"), AUTH_DINGDING(51,
                                                                                                                                                                                             "阿里钉钉授权"), AUTH_WEWORK(52,
                                                                                                                                                                                                                    "企业微信授权"), AUTH_FEISHU(53,
                                                                                                                                                                                                                                           "飞书授权"),;

    /**
     * 配置项名称
     */
    private int    key;
    /**
     * 字典值
     */
    private String value;

    CreateTypeEnum(int key, String value) {
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
