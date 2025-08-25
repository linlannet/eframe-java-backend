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
import net.linlan.sys.base.dto.BaseLabelDto;
import net.linlan.sys.base.entity.BaseLabel;
import net.linlan.sys.base.param.BaseLabelParam;

/**
 *
 * BaseLabel数据域:全局标签字词持久层Dao
 * @author Linlan
 * CreateTime 2018-05-08 18:37:58
 *
 */
@Mapper
public interface BaseLabelDao extends MybatisBaseDao<BaseLabel> {

    /** get the page of dto BaseLabelDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseLabelParam }
     * @return 分页的标签数据 {@link Page} 对象，包含 {@link BaseLabel} 列表
     */
    Page<BaseLabelDto> getPageDto(BaseLabelParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseLabelDto}
     * @param id 标签ID|1
     * @return {@link BaseLabelDto}
     */
    BaseLabelDto getDtoById(String id);

    /** 通过名称查询标签对象
     * @param name  名称
     * @return  标签对象
     */
    BaseLabel findByName(String name);

    /** 统计标签的使用分类信息
     * @param map   统计参数
     * @return  标签列表
     */
    List<Map<String, Object>> statisticsCount(Map<String, Object> map);

    /** 通过标签IDs数组获取名称数组
     * @param ids  id列表
     * @return    查询结果列表
     */
    List<String> getLabelNameList(String[] ids);

    /**
     * 批量保存或更新方法
     * @param list  更新列表
     */
    void saveOrUpdateBatch(@Param("list") List<BaseLabel> list);

}
