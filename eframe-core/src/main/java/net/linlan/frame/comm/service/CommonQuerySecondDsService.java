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
package net.linlan.frame.comm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.linlan.commons.core.StringUtils;
import net.linlan.commons.db.annotation.DataSource;
import net.linlan.frame.comm.dao.CommonQuerySecondDsDao;
import net.linlan.frame.comm.datasource.BaseDataSourceNames;

/**
 * 功能描述:  第二内部数据源执行service
 * @author Linlan
 * CreateTime 2019/5/6
 */
@Service
public class CommonQuerySecondDsService {

    @Resource
    private CommonQuerySecondDsDao dao;

    @DataSource(name = BaseDataSourceNames.SECOND)
    public List<Map> executeSql(String sql) {
        List<Map> result = new ArrayList<>();
        if (!StringUtils.isEmpty(sql)) {
            result = dao.executeSql(sql);
        }
        return result;
    }

    /**
     * 判断是否存在该表
     * @param tableName    表名称
     * @return 是否存在表
     */
    public Boolean isExistsTable(String tableName) {
        return dao.isExistsTable(tableName);
    }

    /**
     * 判断表中是否存在数据
     * @param tableName    表名称
     * @return 是否存在数据
     */
    public Boolean hasData(String tableName) {
        return dao.hasData(tableName);
    }

}
