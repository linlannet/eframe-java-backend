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

import java.security.MessageDigest;

import net.linlan.commons.core.HexUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.exception.CommonException;

/**
 *
 * Filename:TokenGenerator.java
 * Desc:生成token方法，提供给后台和前台进行Token生成
 *
 * @author Linlan
 * CreateTime:2018/6/18 15:23
 *
 * @version 1.0
 * @since 1.0
 *
 */
public class TokenGenerator {

    public static String generateValue() {
        return generateValue(RandomUtils.UUID());
    }

    private static final char[] hexCode = HexUtils.DIGITS_LOWER;

    public static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new CommonException("生成Token失败");
        }
    }
}
