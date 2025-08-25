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
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.core.dto.CoreAccountDto;
import net.linlan.sys.core.dto.CoreAccountMapDto;
import net.linlan.sys.core.dto.OrganBaseInfoDto;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.core.param.CoreAccountParam;
import net.linlan.sys.core.param.OrganAccountParam;

/**
*
* CoreAccount数据域:平台对接账户持久层Dao
* @author Linlan
* CreateTime 2018-03-01 19:01:51
*
*/
@Mapper
public interface CoreAccountDao extends MybatisBaseDao<CoreAccount> {

    /** get the page of dto CoreAccountDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CoreAccountParam }
     * @return 分页的平台账户数据 {@link Page} 对象，包含 {@link CoreAccount} 列表
     */
    Page<CoreAccountDto> getPageDto(CoreAccountParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CoreAccountDto}
     * @param id 对接账户ID，外部系统分配的主键|1
     * @return {@link CoreAccountDto}
     */
    CoreAccountDto getDtoById(String id);

    /**
     * @param map    查询map
     * @return    返回结果List
     */
    List<CoreAccount> getByParams(Map<String, Object> map);

    /**
     * 更新数据
     * @param coreAccount   平台账户
     */
    void updateCurrCountOrConfLimit(CoreAccount coreAccount);

    /**
     * 获取列表
     * @param coreAccountParam  查询对象
     * @return  返回结果Page
     */
    Page<CoreAccountMapDto> getKeyValueList(CoreAccountParam coreAccountParam);

    /** get the page of dto AdminDeptDto
     * 列表分页方法，返回分页DTO对象列表
     * @param organParam the input param {@link OrganAccountParam }
     * @return 列表的机构基础数据 {@link List} 对象，包含 {@link OrganBaseInfoDto} 列表
     */
    Page<OrganBaseInfoDto> getCoreOrganList(OrganAccountParam organParam);

    /**
     * 获取机构详情
     * @param organId  机构ID
     * @return  查询结果
     */
    OrganBaseInfoDto getCoreOrganInfo(@Param("organId") String organId);
}
