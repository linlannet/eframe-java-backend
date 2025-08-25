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
package net.linlan.utils.sql;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.utils.exception.UtilsException;

/**
 * sql操作工具类
 * 
 * @author Linlan
 */
public class SqlUtil {
    /**
     * 定义常用的 sql关键字
     */
    public static String     SQL_REGEX           = "and |extractvalue|updatexml|exec |insert |select |delete |update |drop |count |chr |mid |master |truncate |char |declare |or |+|user()";

    /**
     * 仅支持字母、数字、下划线、空格、逗号、小数点（支持多个字段排序）
     */
    public static String     SQL_PATTERN         = "[a-zA-Z0-9_\\ \\,\\.]+";

    /**
     * 限制orderBy最大长度
     */
    private static final int ORDER_BY_MAX_LENGTH = 500;

    /**
     * 检查字符，防止注入绕过
     * @param value     检查前的字符
     * @return  检查后的字符
     */
    public static String escapeOrderBySql(String value) {
        if (ObjectUtils.isNotEmpty(value) && !isValidOrderBySql(value)) {
            throw new UtilsException("参数不符合规范，不能进行查询");
        }
        if (StringUtils.length(value) > ORDER_BY_MAX_LENGTH) {
            throw new UtilsException("参数已超过最大限制，不能进行查询");
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     * @param value     检查前的字符
     * @return  字符是否符合
     */
    public static boolean isValidOrderBySql(String value) {
        return value.matches(SQL_PATTERN);
    }

    /**
     * SQL关键字检查
     * @param value     检查前的字符
     */
    public static void filterKeyword(String value) {
        if (StringUtils.isEmpty(value)) {
            return;
        }
        String[] sqlKeywords = StringUtils.split(SQL_REGEX, "\\|");
        for (String sqlKeyword : sqlKeywords) {
            if (StringUtils.indexOfIgnoreCase(value, sqlKeyword) > -1) {
                throw new UtilsException("参数存在SQL注入风险");
            }
        }
    }
}
