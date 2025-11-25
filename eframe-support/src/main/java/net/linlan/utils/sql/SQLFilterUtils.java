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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.linlan.commons.core.StringUtils;

/**
 * 常见SQL注入过滤
 * @author Linlan
 */
public class SQLFilterUtils {
    private static final Logger log            = LoggerFactory.getLogger(SQLFilterUtils.class);

    private static String       sqlKeysStr     = "select|update|delete|insert|truncate|char|into|substr|ascii|declare|exec|count|master|drop|execute|concat|database";
    private static String       replacedString = "INVALID";
    private static List<String> sqlKeys        = null;

    static {
        sqlKeys = StringUtils.split(sqlKeysStr, '|');
    }

    public static String stripSql(String inValue) {
        if (StringUtils.isNotBlank(inValue)) {
            String value = inValue.toLowerCase();
            for (String sqlKey : sqlKeys) {
                if (value.contains(" " + sqlKey) || value.contains(sqlKey + " ")
                    || value.contains("\t" + sqlKey) || value.contains(sqlKey + "\t")
                    || value.contains("+" + sqlKey) || value.contains(sqlKey + "+")) {
                    value = StringUtils.replace(value, sqlKey, replacedString);
                    log.error("已被过滤，参数中包含不允许sql的关键词(" + sqlKey + ")" + ";参数：" + inValue + ";过滤后的参数："
                              + value);
                }
            }
        }
        return inValue;
    }

    public static boolean hasSql(String inValue) {
        if (StringUtils.isNotBlank(inValue)) {
            String value = inValue.toLowerCase();
            for (String sqlKey : sqlKeys) {
                if (value.contains(" " + sqlKey) || value.contains(sqlKey + " ")
                    || value.contains("\t" + sqlKey) || value.contains(sqlKey + "\t")
                    || value.contains("+" + sqlKey) || value.contains(sqlKey + "+")) {
                    log.error("已被过滤，参数中包含不允许sql的关键词(" + sqlKey + ")" + ";参数：" + inValue);
                    return true;
                }
            }
        }
        return false;
    }
}
