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
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.comm.dto.CommFlowDto;
import net.linlan.sys.comm.entity.CommFlow;
import net.linlan.sys.comm.param.CommFlowParam;

/**
*
* CommFlow数据域:应用报备通用审批流程持久层Dao
* @author Linlan
* CreateTime 2022-05-23 11:54:16
*
*/
@Mapper
public interface CommFlowDao extends MybatisBaseDao<CommFlow> {

    /** get the page of dto CommFlowDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CommFlowParam }
     * @return 分页的通用流程数据 {@link Page} 对象，包含 {@link CommFlow} 列表
     */
    Page<CommFlowDto> getPageDto(CommFlowParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CommFlowDto}
     * @param id the CommFlow 主键 | 1
     * @return {@link CommFlowDto}
     */
    CommFlowDto getDtoById(Long id);

    int deleteByForeignId(@Param("foreignId") String foreignId);

    List<CommFlow> getZblpTaskTimes(@Param("idCard") String idCard);

}
