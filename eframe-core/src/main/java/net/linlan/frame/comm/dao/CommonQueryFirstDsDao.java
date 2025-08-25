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

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.comm.vo.CommTableColumn;

/**
 * 功能描述:  第一内部数据源执行dao
 * @author Linlan
 * CreateTime 2019/5/6
 */
@Mapper
public interface CommonQueryFirstDsDao extends MybatisBaseDao {

    /**
     * 功能描述:
     * @author Linlan
     * CreateTime 2019/5/6
     * @param sql    sql语句
     * @return 结果LIST
     */
    List<Map> executeSql(String sql);

    Boolean isExistsTable(@Param("tableName") String tableName);

    Boolean hasData(@Param("tableName") String tableName);

    /**
     * 通用保存数据
     * @param tableName    表名称
     * @param columns    全部列
     */
    void saveData(@Param("tableName") String tableName,
                  @Param("columns") List<CommTableColumn> columns);

    /**
     * 通用根据id更新数据
     * @param tableName    表名称
     * @param columns    全部列
     */
    void updateDataById(@Param("tableName") String tableName,
                        @Param("columns") List<CommTableColumn> columns);

    /**
     * 通用更新数据
     * @param tableName    表名称
     * @param columns    全部列
     */
    void updateData(@Param("tableName") String tableName,
                    @Param("columns") List<CommTableColumn> columns);

    /**
     * 通用删除数据
     * @param tableName    表名称
     * @param idName    id名称
     * @param ids    ID列表
     */
    void deleteData(@Param("tableName") String tableName, @Param("idName") String idName,
                    @Param("ids") String ids);

    /**
     * 获取数据列表
     * @param tableName    表名称
     * @param pages    页面
     * @param limit    每页数量
     * @param orderBy    排序字段
     * @param sortOrder    排序方式
     * @param paramColumns    查询列名称
     * @param allColumns    全部列名称
     * @return    查询结果
     */
    List<Map<String, Object>> getDataV2(@Param("tableName") String tableName,
                                        @Param("pages") Integer pages,
                                        @Param("limit") Integer limit,
                                        @Param("orderBy") Integer orderBy,
                                        @Param("sortOrder") Integer sortOrder,
                                        @Param("paramColumns") List<CommTableColumn> paramColumns,
                                        @Param("allColumns") List<CommTableColumn> allColumns);

    /**
     * 获取数据列表
     * @param tableName    表名称
     * @param columns    全部列名称
     * @return    查询结果
     */
    Integer getDataCount(@Param("tableName") String tableName,
                         @Param("columns") List<CommTableColumn> columns);

    /**
     * 获取数据详情
     * @param tableName    表名称
     * @param idName    id名称
     * @param id    主键ID
     * @return    查询对象
     */
    Map<String, Object> findData(@Param("tableName") String tableName,
                                 @Param("idName") String idName, @Param("id") String id);

}
