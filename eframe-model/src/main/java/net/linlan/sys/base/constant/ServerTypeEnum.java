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
 * 服务类型枚举类
 */
public enum ServerTypeEnum {

                            SERTYPE_S01("SYS",
                                        "系统服务"), SERTYPE_S02("ELE",
                                                             "要素服务"), SERTYPE_S03("MAN",
                                                                                  "管理服务"), SERTYPE_S11("PUBLIC",
                                                                                                       "应用支撑服务"), SERTYPE_S12("FRAME",
                                                                                                                              "业务框架服务"), SERTYPE_S13("PORTAL",
                                                                                                                                                     "门户内容服务"), SERTYPE_S21("GENERAL-MONITOR",
                                                                                                                                                                            "指标中心服务"), SERTYPE_S22("GENERAL-DESIGN",
                                                                                                                                                                                                   "设计中心服务"), SERTYPE_S23("GENERAL-FLOWEVENT",
                                                                                                                                                                                                                          "事件中心服务"), SERTYPE_S24("GENERAL-EVALUATE",
                                                                                                                                                                                                                                                 "效能中心服务"), SERTYPE_S51("SCENES-SHIYU",
                                                                                                                                                                                                                                                                        "市域治理服务"), SERTYPE_S52("SCENES-DANGQUN",
                                                                                                                                                                                                                                                                                               "党群引领服务"), SERTYPE_S53("SCENES-XIANGCUN",
                                                                                                                                                                                                                                                                                                                      "数字乡村服务"), SERTYPE_S54("SCENES-WEIJIAN",
                                                                                                                                                                                                                                                                                                                                             "卫健防控服务"), SERTYPE_S55("SCENES-YINGJI",
                                                                                                                                                                                                                                                                                                                                                                    "应急安全服务");

    /**
     * 配置项名称
     */
    private String key;
    /**
     * 配置项值
     */
    private String value;

    ServerTypeEnum(String key, String value) {
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
