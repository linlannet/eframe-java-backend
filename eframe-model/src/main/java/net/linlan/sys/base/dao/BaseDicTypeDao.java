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
import net.linlan.sys.base.dto.BaseDicTypeDto;
import net.linlan.sys.base.entity.BaseDicType;
import net.linlan.sys.base.param.BaseDicTypeParam;

/**
*
* BaseDicType数据域:字典类型持久层Dao
* @author Linlan
 * CreateTime 2018-05-08 18:37:58
*
*/
@Mapper
public interface BaseDicTypeDao extends MybatisBaseDao<BaseDicType> {

    /** get the page of dto BaseDicTypeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseDicTypeParam }
     * @return 分页的字典分类数据 {@link Page} 对象，包含 {@link BaseDicType} 列表
     */
    Page<BaseDicTypeDto> getPageDto(BaseDicTypeParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseDicTypeDto}
     * @param id 字典类型代码|1
     * @return {@link BaseDicTypeDto}
     */
    BaseDicTypeDto getDtoById(String id);

}
