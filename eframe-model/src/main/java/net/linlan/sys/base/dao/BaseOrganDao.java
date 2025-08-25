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
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.BaseOrganDto;
import net.linlan.sys.base.dto.KeyValueMapDto;
import net.linlan.sys.base.entity.BaseOrgan;
import net.linlan.sys.base.param.BaseOrganParam;

/**
*
* BaseOrgan数据域:基础单位持久层Dao
* @author Linlan
* CreateTime 2018-03-02 17:17:54
*
*/
@Mapper
public interface BaseOrganDao extends MybatisBaseDao<BaseOrgan> {

    /** get the page of dto BaseOrganDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseOrganParam }
     * @return 分页的基础机构数据 {@link Page} 对象，包含 {@link BaseOrgan} 列表
     */
    Page<BaseOrganDto> getPageDto(BaseOrganParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseOrganDto}
     * @param id 单位编码|1
     * @return {@link BaseOrganDto}
     */
    BaseOrganDto getDtoById(String id);

    /** 通过查询条件导出机构列表
     * @param params    查询参数
     * @return  查询结果
     */
    List<?> getExportList(Map<String, Object> params);

    /** 通过机构名称，查询机构对象
     * @param organName 机构名称
     * @return  查询结果
     */
    BaseOrgan getByName(@Param("organName") String organName);

    /** 通过机构名称和统一信用代码证号，查询机构对象
     * @param organName 机构名称
     * @param unionCode 统一信用代码
     * @return  机构对象
     */
    BaseOrgan getOrganByNameUnicode(@Param("organName") String organName,
                                    @Param("unionCode") String unionCode);

    /**
     * 通过地域类机构外部ID查询机构列表
     * @param ids  id列表
     * @return    查询结果列表
     */
    List<BaseOrgan> getListByOutIds(@Param("ids") List<String> ids);

    /**
     * 通过organCode 查询唯一数据
     * @param organCode 机构代码
     * @return  机构
     */
    BaseOrgan getOrganByOrganCode(@Param("organCode") String organCode);

    /**
     * 获取KV键值对
     * @param params    查询参数
     * @return  键值对
     */
    Page<KeyValueMapDto> getKeyValueList(BaseOrganParam params);

    /** 通过机构名称和统一信用代码证号，查询机构对象
     * @param unionCode 统一信用代码
     * @return  机构
     */
    BaseOrgan getOrganByUnicode(@Param("unionCode") String unionCode);

}
