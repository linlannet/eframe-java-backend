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
 * 字典类型
 */
public enum TypeCodeEnum {

                          SUYYXLK("SUYYXLK",
                                  "所属应用下拉框"), JSFLXLK("JSFLXLK",
                                                      "角色分类下拉框"), JSXLK("JSXLK",
                                                                        "角色下拉框"), HYLXXLK("HYLXXLK",
                                                                                          "会员类型下拉框"), HYZXLK("HYZXLK",
                                                                                                             "会员组下拉框"), GUESTBOOK_TYPE("GUESTBOOK_TYPE",
                                                                                                                                       "咨询分类字典"), GWXLK("GWXLK",
                                                                                                                                                        "岗位下拉框");

    TypeCodeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 配置项名称
     */
    private String key;
    /**
     * 配置项值
     */
    private String value;

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
