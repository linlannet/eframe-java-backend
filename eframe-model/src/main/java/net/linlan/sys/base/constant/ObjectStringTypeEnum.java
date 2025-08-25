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
 * 对象类型枚举，字符类型
 */
public enum ObjectStringTypeEnum {

                                  BASE_USER("BaseUser", "BASE_USER",
                                            "基础人员"), CORE_USER("CoreUser", "CORE_USER",
                                                               "核心人员"), IDENTITY_USER("IdentityUser",
                                                                                      "IDENTITY_USER",
                                                                                      "认证人员"), THEME_PEOPLE("ThemePeople",
                                                                                                            "THEME_PEOPLE",
                                                                                                            "主题库人员"), THEME_PEOPLE_FAMILY("ThemePeopleFamily",
                                                                                                                                          "THEME_PEOPLE_FAMILY",
                                                                                                                                          "主题库家庭"), MATERIAL_PEOPLE_BASE("MaterialPeopleBase",
                                                                                                                                                                         "MATERIAL_PEOPLE_BASE",
                                                                                                                                                                         "业务库人员"), THEME_HOUSE("ThemeHouse",
                                                                                                                                                                                               "THEME_HOUSE",
                                                                                                                                                                                               "主题库房屋"), THEME_BUILDING("ThemeBuilding",
                                                                                                                                                                                                                        "THEME_BUILDING",
                                                                                                                                                                                                                        "主题库楼宇"), THEME_MAP_ADDRESS("ThemeMapAddress",
                                                                                                                                                                                                                                                    "THEME_MAP_ADDRESS",
                                                                                                                                                                                                                                                    "主题库地址"),

                                  BASE_ORGAN("BaseOrgan", "BASE_ORGAN",
                                             "基础机构"), CORE_ORGAN("CoreOrgan", "CORE_ORGAN",
                                                                 "核心机构"), IDENTITY_ORGAN("IdentityOrgan",
                                                                                         "IDENTITY_ORGAN",
                                                                                         "认证机构"), THEME_ORGAN("ThemeOrgan",
                                                                                                              "THEME_ORGAN",
                                                                                                              "主题库机构"), MATERIAL_ORGAN_BASE("MaterialOrganBase",
                                                                                                                                            "MATERIAL_ORGAN_BASE",
                                                                                                                                            "业务库机构"),

                                  MATERIAL_THINGS_BASE("MaterialThingsBase", "MATERIAL_THINGS_BASE",
                                                       "业务库物品"), MATERIAL_DEVICE_BASE("MaterialDeviceBase",
                                                                                      "MATERIAL_DEVICE_BASE",
                                                                                      "业务库设施");

    ObjectStringTypeEnum(String key, String value, String description) {
        this.key = key;
        this.value = value;
        this.description = description;
    }

    /**
     * 配置项名称
     */
    private String key;
    /**
     * 配置项值
     */
    private String value;
    /**
     * 配置说明
     */
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
