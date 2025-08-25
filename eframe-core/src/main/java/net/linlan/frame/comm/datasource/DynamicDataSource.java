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
package net.linlan.frame.comm.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 * Filename:DynamicDataSource.java
 * Desc:动态数据源定义类
 *
 * @author Linlan
 * CreateTime:2017-10-20 10:34 PM
 *
 * @version 1.0
 * @since 1.0
 *
 */

public class DynamicDataSource extends AbstractRoutingDataSource {
    static Logger                            logger        = LoggerFactory
        .getLogger(DynamicDataSource.class);
    /**
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource,
                             Map<String, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(new HashMap<>(targetDataSources));
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    /**
     * 设置数据源的变量
     * @param dataSource    数据源
     */
    public static void setDataSource(String dataSource) {
        logger.info("切换到{}数据源", dataSource);
        contextHolder.set(dataSource);
    }

    /**
     * 获得数据源的变量
     * @return 返回数据源
     */
    public static String getDataSource() {
        return contextHolder.get();
    }

    /**
     * 清空数据源变量
     */
    public static void clearDataSource() {
        contextHolder.remove();
    }

}
