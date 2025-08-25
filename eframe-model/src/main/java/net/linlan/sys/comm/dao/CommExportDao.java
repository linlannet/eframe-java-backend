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

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.comm.dto.CommExportDto;
import net.linlan.sys.comm.dto.PackageDto;
import net.linlan.sys.comm.entity.CommExport;
import net.linlan.sys.comm.param.CommExportParam;

/**
*
* CommExport数据域:应用基础通用导出持久层Dao
* @author Linlan
* CreateTime 2022-06-15 11:56:49
*
*/
@Mapper
public interface CommExportDao extends MybatisBaseDao<CommExport> {

    /** get the page of dto CommExportDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CommExportParam }
     * @return 分页的通用导出数据 {@link Page} 对象，包含 {@link CommExport} 列表
     */
    Page<CommExportDto> getPageDto(CommExportParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CommExportDto}
     * @param id the CommExport 导出任务ID | 1
     * @return {@link CommExportDto}
     */
    CommExportDto getDtoById(Long id);

    /**
     * 获取导出信息，目前name对应taskInfo的name
     * @param exportId  导出ID
     * @return  查询结果
     */
    List<PackageDto> getPackageList(String exportId);

}
