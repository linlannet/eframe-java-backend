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
package net.linlan.tools.generator.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.linlan.tools.generator.dao.GenTableColumnDao;
import net.linlan.tools.generator.entity.GenTableColumn;

/**
 * 业务字段 服务层实现
 * 
 * @author Linlan
 */
@Service
public class GenTableColumnService {
    @Resource
    private GenTableColumnDao dao;

    /**
     * 查询业务字段列表
     * 
     * @param tableId 业务字段编号
     * @return 业务字段集合
     */
    public List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId) {
        return dao.selectGenTableColumnListByTableId(tableId);
    }

    /**
     * 新增业务字段
     * 
     * @param genTableColumn 业务字段信息
     * @return 结果
     */
    public int insertGenTableColumn(GenTableColumn genTableColumn) {
        return dao.insertGenTableColumn(genTableColumn);
    }

    /**
     * 修改业务字段
     * 
     * @param genTableColumn 业务字段信息
     * @return 结果
     */
    public int updateGenTableColumn(GenTableColumn genTableColumn) {
        return dao.updateGenTableColumn(genTableColumn);
    }

    /**
     * 删除业务字段对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGenTableColumnByIds(Long[] ids) {
        return dao.deleteGenTableColumnByIds(ids);
    }

    public List<GenTableColumn> selectDbTableColumnsByName(String tableName) {
        return dao.selectDbTableColumnsByName(tableName);
    }

    public void deleteGenTableColumns(List<GenTableColumn> delColumns) {
        dao.deleteGenTableColumns(delColumns);
    }

}
