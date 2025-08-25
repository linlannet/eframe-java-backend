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
 * 应用类型状态枚举类
 */
public enum AppTypeEnum {
                         QUANBU("QUANBU",
                                "全部领域"), WORK("WORK",
                                              "工作端"), H5("H5",
                                                         "移动端"), SCREEN("SCREEN",
                                                                        "大屏端"), BS("BS",
                                                                                   "浏览器服务器"), CS("CS",
                                                                                                 "客户端服务器"), EXE("EXE",
                                                                                                                "独立应用"), QITA("QITA",
                                                                                                                              "其他"),;

    /**
     * 配置项名称
     */
    private String key;
    /**
     * 配置项值
     */
    private String value;

    AppTypeEnum(String key, String value) {
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
