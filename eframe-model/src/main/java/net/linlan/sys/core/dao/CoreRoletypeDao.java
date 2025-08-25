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
package net.linlan.sys.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.core.dto.CoreRoletypeDto;
import net.linlan.sys.core.entity.CoreRoletype;
import net.linlan.sys.core.param.CoreRoletypeParam;

/**
*
* CoreRoletype数据域:角色分类表持久层Dao
* @author Linlan
* CreateTime 2023-08-12 13:45:49
*
*/
@Mapper
public interface CoreRoletypeDao extends MybatisBaseDao<CoreRoletype> {

    /** get the page of dto CoreRoletypeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CoreRoletypeParam }
     * @return 分页的角色分类数据 {@link Page} 对象，包含 {@link CoreRoletype} 列表
     */
    Page<CoreRoletypeDto> getPageDto(CoreRoletypeParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CoreRoletypeDto}
     * @param id the input id
     * @return {@link CoreRoletypeDto}
     */
    CoreRoletypeDto getDtoById(String id);

    /** 通过code查询角色类型对象
     * @param code    代码
     * @return    查询结果
     */
    CoreRoletype findByCode(String code);

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @param roletypeId    角色类型ID
     * @return    返回结果List
     */
    List<DictionaryInitDto> getForSelect(@Param("roletypeId") String roletypeId);

}
