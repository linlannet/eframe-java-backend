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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.comm.dao.CommonQueryFirstDsDao;
import net.linlan.frame.comm.vo.CommTableColumn;

/**
 * 功能描述:  第一内部数据源执行service
 * @author Linlan
 * CreateTime 2019/5/6
 */
@Service
public class CommonQueryFirstDsService {
    @Value("${spring.datasource.druid.first.url}")
    private String                jdbcUrl = "jdbc:mysql:";
    @Resource
    private CommonQueryFirstDsDao dao;

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

    /**
     * 通用删除
     * @param tableName 表名称
     * @param idName 主键名称
     * @param ids   字段ID
     */
    public void deleteData(String tableName, String idName, String ids) {
        dao.deleteData(tableName, idName, ids);
    }

    /**
     * 通用新增
     * @param tableName    表名称
     * @param columns    全部列
     */
    public void saveData(String tableName, List<CommTableColumn> columns) {
        //当 columns中 isPk  主键 ==1 时候 附上值 当是String类型 就 RandomUtils.UUID() 当Long就 RandomUtils.randomLid() 其他类型默认是RandomUtils.UUID()
        for (CommTableColumn column : columns) {
            if (column.getIsPk()) {
                Object randomValue = generateRandomValue(column);
                column.setColumnValue(randomValue.toString()); // 假设setColumnValue方法用于设置列的值
            }
        }
        // 过滤掉 columnValue 为空的 CommTableColumn 对象
        List<CommTableColumn> filteredColumns = columns.stream()
            .filter(column -> ObjectUtils.isNotEmpty(column.getColumnValue()))
            .collect(Collectors.toList());

        // 使用过滤后的 columns 列表进行保存
        dao.saveData(tableName, filteredColumns);
    }

    /**
     * 设置主键值  新增时使用
     * @param column    列
     * @return    返回结果
     */
    private Object generateRandomValue(CommTableColumn column) {
        // 根据列的类型生成随机值
        if (column.getColumnType().equals("String")) { // 假设getColumnType方法用于获取列的类型
            return RandomUtils.UUID();
        } else if (column.getColumnType().equals("Long")) {
            return RandomUtils.randomLid();
        } else {
            return RandomUtils.UUID(); // 其他类型默认生成UUID
        }
    }

    /**
     * 根据主键修改
     * @param tableName    表名称
     * @param columns    全部列
     */
    public void updateDataById(String tableName, List<CommTableColumn> columns) {
        if (ObjectUtils.isNotEmpty(columns)) {
            dao.updateDataById(tableName, columns);
        }
    }

    /**
     * 根据查询条件修改
     * @param tableName    表名称
     * @param columns    全部列
     */
    public void updateData(String tableName, List<CommTableColumn> columns) {
        dao.updateData(tableName, columns);
    }

    /**
     * 获取数据列表
     * @param tableName    表名称
     * @param paramColumns    查询列名称
     * @param allColumns    全部列名称
     * @param pages    页面
     * @param limit    每页数量
     * @param orderBy    排序字段
     * @return    查询结果
     */
    public Pagination<Map<String, Object>> getDataV2(String tableName,
                                                     List<CommTableColumn> paramColumns,
                                                     List<CommTableColumn> allColumns,
                                                     Integer pages, Integer limit,
                                                     Integer orderBy) {
        Page<Map<String, Object>> page = new Page<>(pages, limit, true);
        Integer dataCount = dao.getDataCount(tableName, paramColumns);//获取总数量
        List<Map<String, Object>> data = new ArrayList<>();
        if (dataCount > 0) {
            // 计算排序方向
            Integer sortOrder = orderBy % 2;
            data = dao.getDataV2(tableName, pages, limit, orderBy, sortOrder, paramColumns,
                allColumns);//获取数据
            page.addAll(data);
            page.setTotal(dataCount); // 设置总记录数
        }
        return new Pagination(data, page);
    }

    /**
     * 获取数据详情
     * @param tableName    表名称
     * @param idName    id名称
     * @param ids  id列表
     * @return    查询结果列表
     */
    public Map<String, Object> findData(String tableName, String idName, String ids) {
        //idName = convertTableNameToEntityName(idName);//id驼峰转换
        return dao.findData(tableName, idName, ids);
    }

    /**
     * 加单引号
     * @param columns   全部列
     */
    public void addSingleQuotesToColumnValues(List<CommTableColumn> columns) {
        for (CommTableColumn column : columns) {
            // 获取当前列的值
            Object value = column.getColumnValue();
            if (value != null) {
                // 将值转换为字符串并加上单引号
                String quotedValue = "'" + value.toString() + "'";
                column.setColumnValue(quotedValue); // 设置带单引号的值
            }
        }
    }

    /**
     * 获取数据库类型
     * @return    返回结果
     */
    public String getDatabaseTypeFromUrl() {
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

    /**
     * 根据实体类的简单名称获取其实例
     * @param simpleClassName 实体类的简单名称
     * @return 实体类的实例，如果找不到类或无法实例化，则返回null
     */
    public static Object getEntityInstance(String simpleClassName) {
        try {
            // 获取当前线程的类加载器
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            // 加载实体类
            Class<?> clazz = classLoader.loadClass(simpleClassName);
            // 获取无参构造函数
            java.lang.reflect.Constructor<?> constructor = clazz.getConstructor();
            // 创建实例
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 驼峰转换
     * @param tableName    表名称
     * @return    查询结果
     */
    public static String convertTableNameToEntityName(String tableName) {
        // 将表名转换为实体类名，假设表名为大写字母，实体类名为首字母大写的驼峰命名
        String[] parts = tableName.split("_");
        StringBuilder entityName = new StringBuilder();
        for (String part : parts) {
            entityName.append(part.substring(0, 1).toUpperCase())
                .append(part.substring(1).toLowerCase());
        }
        return entityName.toString();
    }

}
