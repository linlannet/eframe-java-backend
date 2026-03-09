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
package net.linlan.sys.base.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dao.BaseDicTypeDao;
import net.linlan.sys.base.dto.BaseDicTypeDto;
import net.linlan.sys.base.entity.BaseDicType;
import net.linlan.sys.base.param.BaseDicTypeParam;

/**
 *
 * BaseDicType数据域:字典类型服务类
 * @author Linlan
 * CreateTime 2023-08-08 13:41:37
 *
 */
@Service
@Slf4j
public class BaseDicTypeService {

    @Resource
    private BaseDicTypeDao dao;

    /** get the list of entity BaseDicType
     * 列表方法，返回列表的字典分类数据 {@link Page} 对象，包含 {@link BaseDicType} 列表
     * @param map the input select conditions
     * @return 列表的字典分类数据 {@link Page} 对象，包含 {@link BaseDicType} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseDicType> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseDicType}
     * @param id 字典类型代码|1
     * @return {@link BaseDicType}
     */
    public BaseDicType findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseDicType the input baseDicType
     */
    //@Transactional
    public void save(BaseDicType baseDicType) {
        baseDicType.init();
        dao.save(baseDicType);
    }

    /** save the entity with input list
     * 保存对象字典类型，批量保存list
     * @param list {@link BaseDicType}
     */
    public void batchSave(List<BaseDicType> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseDicType the input baseDicType
     */
    //@Transactional
    public void update(BaseDicType baseDicType) {
        dao.update(baseDicType);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 字典类型代码|1
     */
    public void deleteById(String id) {
        if (StringUtils.isBlank(id)) {
            return;
        }
        dao.deleteById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    //@Transactional
    public void deleteByIds(String[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            return;
        }
        dao.deleteByIds(ids);
    }

    /** query the total count by input select conditions
     * 通过输入的条件查询记录总数
     * @param map the input select conditions
     * @return total count
     */
    public int getCount(Map<String, Object> map) {
        return dao.getCount(map);
    }

    /** get the page of dto BaseDicTypeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseDicTypeParam }
     * @return 分页的字典分类数据 {@link Page} 对象，包含 {@link BaseDicType} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseDicTypeDto> getPageDto(BaseDicTypeParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseDicTypeDto}
     * @param id 字典类型代码|1
     * @return {@link BaseDicTypeDto}
     */
    public BaseDicTypeDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

}
