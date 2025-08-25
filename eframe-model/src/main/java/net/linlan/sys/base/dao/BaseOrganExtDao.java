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
package net.linlan.sys.base.dao;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.BaseOrganExtDto;
import net.linlan.sys.base.entity.BaseOrganExt;
import net.linlan.sys.base.param.BaseOrganExtParam;

/**
*
* BaseOrganExt数据域:基础单位扩展信息持久层Dao
* @author Linlan
 * CreateTime 2023-08-08 13:41:37
*
*/
@Mapper
public interface BaseOrganExtDao extends MybatisBaseDao<BaseOrganExt> {

    /** get the page of dto BaseOrganExtDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseOrganExtParam }
     * @return 分页的基础机构扩展数据 {@link Page} 对象，包含 {@link BaseOrganExt} 列表
     */
    Page<BaseOrganExtDto> getPageDto(BaseOrganExtParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseOrganExtDto}
     * @param id 单位编号|1
     * @return {@link BaseOrganExtDto}
     */
    BaseOrganExtDto getDtoById(String id);

}
