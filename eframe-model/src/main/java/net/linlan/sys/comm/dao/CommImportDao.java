/*
 * eframe-model - model模型数据模块
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
package net.linlan.sys.comm.dao;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.comm.dto.CommImportDto;
import net.linlan.sys.comm.entity.CommImport;
import net.linlan.sys.comm.param.CommImportParam;

/**
*
* CommImport数据域:应用基础通用导入持久层Dao
* @author Linlan
* CreateTime 2022-10-20 17:47:23
*
*/
@Mapper
public interface CommImportDao extends MybatisBaseDao<CommImport> {

    /** get the page of dto CommImportDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CommImportParam }
     * @return 分页的通用导入数据 {@link Page} 对象，包含 {@link CommImport} 列表
     */
    Page<CommImportDto> getPageDto(CommImportParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CommImportDto}
     * @param id the CommImport 导出任务ID | 1
     * @return {@link CommImportDto}
     */
    CommImportDto getDtoById(Long id);

    Page<CommImportDto> getCommImportList(CommImportParam params);

}
