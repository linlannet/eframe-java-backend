/*
 * module-generator - generator代码生成模块
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
package net.linlan.tools.generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 读取代码生成相关配置
 * 
 * @author Linlan
 */
@Component
@ConfigurationProperties(prefix = "gen")
@PropertySource(value = { "classpath:generator.yml" })
public class GenConfig {
    /** 作者 */
    public static String  author;

    /** 生成包路径 */
    public static String  packageName;

    /** 自动去除表前缀，默认是false */
    public static boolean autoRemovePre;

    /** 表前缀(类名不会包含表前缀) */
    public static String  tablePrefix;

    public static String getAuthor() {
        return author;
    }

    @Value("${author}")
    public void setAuthor(String author) {
        GenConfig.author = author;
    }

    public static String getPackageName() {
        return packageName;
    }

    @Value("${packageName}")
    public void setPackageName(String packageName) {
        GenConfig.packageName = packageName;
    }

    public static boolean getAutoRemovePre() {
        return autoRemovePre;
    }

    @Value("${autoRemovePre}")
    public void setAutoRemovePre(boolean autoRemovePre) {
        GenConfig.autoRemovePre = autoRemovePre;
    }

    public static String getTablePrefix() {
        return tablePrefix;
    }

    @Value("${tablePrefix}")
    public void setTablePrefix(String tablePrefix) {
        GenConfig.tablePrefix = tablePrefix;
    }
}
