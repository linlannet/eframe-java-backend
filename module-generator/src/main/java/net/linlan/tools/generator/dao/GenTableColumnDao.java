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

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.tools.generator.entity.GenTableColumn;

/**
 * 业务字段 数据层
 * 
 * @author Linlan
 */
@Mapper
public interface GenTableColumnDao extends MybatisBaseDao<GenTableColumn> {
    /**
     * 根据表名称查询列信息
     * 
     * @param tableName 表名称
     * @return 列信息
     */
    List<GenTableColumn> selectDbTableColumnsByName(String tableName);

    /**
     * 查询业务字段列表
     * 
     * @param tableId 业务字段编号
     * @return 业务字段集合
     */
    List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);

    /**
     * 新增业务字段
     * 
     * @param genTableColumn 业务字段信息
     * @return 结果
     */
    int insertGenTableColumn(GenTableColumn genTableColumn);

    /**
     * 修改业务字段
     * 
     * @param genTableColumn 业务字段信息
     * @return 结果
     */
    int updateGenTableColumn(GenTableColumn genTableColumn);

    /**
     * 删除业务字段
     * 
     * @param genTableColumns 列数据
     * @return 结果
     */
    int deleteGenTableColumns(List<GenTableColumn> genTableColumns);

    /**
     * 批量删除业务字段
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteGenTableColumnByIds(Long[] ids);
}
