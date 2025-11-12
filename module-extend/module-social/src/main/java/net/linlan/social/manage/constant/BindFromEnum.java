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
package net.linlan.social.manage.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import net.linlan.utils.enums.BaseEnumString;
import net.linlan.utils.enums.EnumConvert;

/**
 * 绑定来源，默认处理管理端、工作端、门户端的来源和逻辑
 *
 * @author Linlan
 *
 */
public enum BindFromEnum implements BaseEnumString {
                                                    /**
                                                     * 管理WEB端
                                                     */
                                                    ADMIN_WORK("admin_work", "管理WEB端"),
                                                    /**
                                                     * 门户前台，门户网站用户
                                                     */
                                                    WEB("web", "门户前台"),
                                                    /**
                                                     * 移动端前台，移动端用户
                                                     */
                                                    H5("h5", "移动端前台"),
                                                    /**
                                                     * 门户工作，WEB端工作用户，如供应商、运营团队
                                                     */
                                                    WEB_WORK("web_work", "门户工作"),
                                                    /**
                                                     * 移动端工作，移动端工作用户
                                                     */
                                                    H5_WORK("h5_work", "移动端工作"),
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

    BindFromEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @EnumConvert
    public static BindFromEnum fromType(String key) {
        BindFromEnum[] values = values();
        for (BindFromEnum value : values) {
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
