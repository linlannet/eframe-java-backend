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

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.BaseAppDto;
import net.linlan.sys.base.dto.BaseAppInfoDto;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.entity.BaseApp;
import net.linlan.sys.base.param.BaseAppParam;

/**
*
* BaseApp数据域:应用信息持久层Dao
* @author Linlan
* CreateTime 2018-03-02 17:17:54
*
*/
@Mapper
public interface BaseAppDao extends MybatisBaseDao<BaseApp> {

    /** get the page of dto BaseAppDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseAppParam }
     * @return 分页的应用数据 {@link Page} 对象，包含 {@link BaseApp} 列表
     */
    Page<BaseAppDto> getPageDto(BaseAppParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseAppDto}
     * @param id 应用ID|1
     * @return {@link BaseAppDto}
     */
    BaseAppDto getDtoById(String id);

    /**
     * 通过appId、name或path等唯一信息，关联查询出areaCode
     * @param params    查询参数
     * @return  查询结果
     */
    String getAreaCodeByParams(Map<String, Object> params);

    /**
     * 通过appId查询出包含外键名称的对象
     * @param id    主键ID
     * @return    查询对象
     */
    BaseAppInfoDto getBaseAppInfoDto(String id);

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @return    返回结果List
     */
    List<DictionaryInitDto> getForSelect();
}
