/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.comm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import net.linlan.commons.db.mybatis.MybatisBaseDao;

/**
 * 功能描述:  第二内部数据源执行dao
 * @author Linlan
 * CreateTime 2019/5/6
 */
@Mapper
public interface CommonQuerySecondDsDao extends MybatisBaseDao {
    @Value("${spring.datasource.druid.h2.url}")
    public String jdbcUrl = "jdbc:mysql:";

    /**
     * 功能描述:
     * @author Linlan
     * @param sql    sql语句
     * @return 结果LIST
     */
    List<Map> executeSql(String sql);

    Boolean isExistsTable(@Param("tableName") String tableName);

    Boolean hasData(@Param("tableName") String tableName);

    /**
     * 获取数据库类型
     * @return    返回结果
     */
    public static String getDatabaseTypeFromUrl() {
        // 检查 URL 是否为空
        if (jdbcUrl == null || jdbcUrl.isEmpty()) {
            throw new IllegalArgumentException("JDBC URL cannot be null or empty");
        }

        // 从 JDBC URL 中提取数据库类型
        String databaseType = null;
        if (jdbcUrl.startsWith("jdbc:mysql:")) {
            databaseType = "MySQL";
        } else if (jdbcUrl.startsWith("jdbc:oracle:")) {
            databaseType = "Oracle";
        } else if (jdbcUrl.startsWith("jdbc:sqlserver:")) {
            databaseType = "SQL Server";
        } else if (jdbcUrl.startsWith("jdbc:postgresql:")) {
            databaseType = "PostgreSQL";
        } else if (jdbcUrl.startsWith("jdbc:dm:")) {
            databaseType = "dm"; // 识别达梦数据库
        } else {
            // 如果 URL 不匹配任何已知的数据库类型
            databaseType = "MySQL";
        }

        return databaseType;
    }

}
