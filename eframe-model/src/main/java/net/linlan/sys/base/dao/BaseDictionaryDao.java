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

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.BaseDictionaryDto;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.entity.BaseDictionary;
import net.linlan.sys.base.param.BaseDictionaryParam;

/**
*
* BaseDictionary数据域:公共字典明细持久层Dao
* @author Linlan
 * CreateTime 2018-05-08 18:37:58
*
*/
@Mapper
public interface BaseDictionaryDao extends MybatisBaseDao<BaseDictionary> {

    /** get the page of dto BaseDictionaryDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseDictionaryParam }
     * @return 分页的字典数据 {@link Page} 对象，包含 {@link BaseDictionary} 列表
     */
    Page<BaseDictionaryDto> getPageDto(BaseDictionaryParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseDictionaryDto}
     * @param id 字典编号|1
     * @return {@link BaseDictionaryDto}
     */
    BaseDictionaryDto getDtoById(Long id);

    /** 通过多个typdCodes获取字典列表
     * @param typeCodes 分类codes
     * @return  字典列表
     */
    List<BaseDictionary> getByTypeCodes(List<String> typeCodes);

    /**
     * 带子集的
     * @param parentId 父节点ID
     * @return  字典列表
     */
    List<BaseDictionary> getAllChild(@Param("parentId") String parentId);

    /**
     * 仅限下一级
     * @param parentId    父节点ID
     * @param typeCoe    字典code
     * @return  原始字典列表
     */
    List<DictionaryInitDto> getChildren(@Param("parentId") String parentId,
                                        @Param("typeCoe") String typeCoe);

    /**
     * 根据typeCode获取字典
     * @param q  关键词
     * @param typeCode  字典分类
     * @return  原始字典列表
     */
    Page<DictionaryInitDto> dicSearch(@Param("typeCode") String typeCode, @Param("q") String q);

    /**
     * 根据typeCode获取字典
     * @param typeCode  字典分类
     * @return  原始字典列表
     */
    List<DictionaryInitDto> getInitByTypeCode(@Param("typeCode") String typeCode);

    /** 通过多个typdCodes获取原始字典列表
     * @param typeCodes 分类codes
     * @return  原始字字典列表
     */
    List<DictionaryInitDto> getInitByTypeCodes(@Param("typeCodes") List<String> typeCodes);

}
