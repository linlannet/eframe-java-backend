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
import net.linlan.sys.base.dto.BaseConfigWholeDto;
import net.linlan.sys.base.entity.BaseConfigWhole;
import net.linlan.sys.base.param.BaseConfigWholeParam;

/**
*
* BaseConfigWhole数据域:通用配置合项持久层Dao
* @author Linlan
* CreateTime 2018-03-02 17:17:54
*
*/
@Mapper
public interface BaseConfigWholeDao extends MybatisBaseDao<BaseConfigWhole> {

    /** get the page of dto BaseConfigWholeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseConfigWholeParam }
     * @return 分页的全局配置数据 {@link Page} 对象，包含 {@link BaseConfigWhole} 列表
     */
    Page<BaseConfigWholeDto> getPageDto(BaseConfigWholeParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseConfigWholeDto}
     * @param id 配置编号|1
     * @return {@link BaseConfigWholeDto}
     */
    BaseConfigWholeDto getDtoById(String id);

    /**
     * 根据key，查询对象
     * @param key 关键字
     * @return    查询结果
     */
    BaseConfigWhole getByKey(String key);

    /**
     * 根据key，更新value
     * @param key 关键字
     * @param value 值
     * @return    更新结果
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);

    /**
     * 根据id查询多个
     * @param ids  id列表
     * @return    查询结果列表
     */
    List<BaseConfigWhole> getByIds(@Param("ids") List<String> ids);

    /** 通过key和description查询对象
     * @param key 关键字
     * @param description 分类类型
     * @return  查询结果
     */
    BaseConfigWhole getConfigs(@Param("key") String key, @Param("description") String description);

}
