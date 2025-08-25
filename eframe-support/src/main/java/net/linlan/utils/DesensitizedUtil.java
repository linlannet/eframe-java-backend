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
package net.linlan.utils;

import net.linlan.commons.core.StringUtils;

/**
 * 脱敏工具类
 *
 * @author Linlan
 */
public class DesensitizedUtil {
    /**
     * 密码的全部字符都用*代替，比如：******
     *
     * @param password 密码
     * @return 脱敏后的密码
     */
    public static String password(String password) {
        if (StringUtils.isBlank(password)) {
            return StringUtils.EMPTY;
        }
        return StringUtils.repeat('*', password.length());
    }

    /**
     * 车牌中间用*代替，如果是错误的车牌，不处理
     *
     * @param carLicense 完整的车牌号
     * @return 脱敏后的车牌
     */
    public static String carLicense(String carLicense) {
        if (StringUtils.isBlank(carLicense)) {
            return StringUtils.EMPTY;
        }
        // 普通车牌
        if (carLicense.length() == 7) {
            carLicense = StringUtils.hide(carLicense, 3, 6);
        } else if (carLicense.length() == 8) {
            // 新能源车牌
            carLicense = StringUtils.hide(carLicense, 3, 7);
        }
        return carLicense;
    }
}
