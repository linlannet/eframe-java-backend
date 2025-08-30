/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.enums;

/**
 *
 * BaseEnum:字符串基础枚举接口,对枚举类字段进行定义
 * @author Linlan
 * CreateTime 2021-11-22 18:18:55
 *
 */
public interface BaseEnumString {

    /**
     * 名称
     */
    String    getKey();
    /**
     * 值
     */
    String getValue();

}
