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
package net.linlan.tools.generator.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.tools.generator.entity.GenTable;

/**
 * 业务 数据层
 * 
 * @author Linlan
 */
@Mapper
public interface GenTableDao extends MybatisBaseDao<GenTable> {
    /**
     * 查询业务列表
     * 
     * @param genTable 业务信息
     * @return 业务集合
     */
    List<GenTable> selectGenTableList(GenTable genTable);

    /**
     * 查询据库列表
     * 
     * @param genTable 业务信息
     * @return 数据库表集合
     */
    List<GenTable> selectDbTableList(GenTable genTable);

    /**
     * 查询据库列表
     *
     * @param genTable 业务信息
     * @return 数据库表集合
     */
    Page<GenTable> selectDbTablePageDto(GenTable genTable);

    /**
     * 查询据库列表
     * 
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    List<GenTable> selectDbTableListByNames(String[] tableNames);

    /**
     * 查询所有表信息
     * 
     * @return 表信息集合
     */
    List<GenTable> selectGenTableAll();

    /**
     * 查询表ID业务信息
     * 
     * @param id 业务ID
     * @return 业务信息
     */
    GenTable selectGenTableById(Long id);

    /**
     * 查询表名称业务信息
     * 
     * @param tableName 表名称
     * @return 业务信息
     */
    GenTable selectGenTableByName(String tableName);

    /**
     * 新增业务
     * 
     * @param genTable 业务信息
     * @return 结果
     */
    int insertGenTable(GenTable genTable);

    /**
     * 修改业务
     * 
     * @param genTable 业务信息
     * @return 结果
     */
    int updateGenTable(GenTable genTable);

    /**
     * 批量删除业务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteGenTableByIds(Long[] ids);

    /**
     * 创建表
     *
     * @param sql 表结构
     * @return 结果
     */
    int createTable(String sql);
}
