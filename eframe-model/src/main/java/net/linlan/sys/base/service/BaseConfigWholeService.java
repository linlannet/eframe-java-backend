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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson2.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dao.BaseConfigWholeDao;
import net.linlan.sys.base.dto.BaseConfigWholeDto;
import net.linlan.sys.base.entity.BaseConfigWhole;
import net.linlan.sys.base.param.BaseConfigWholeParam;
import net.linlan.utils.exception.CommonException;

/**
 *
 * BaseConfigWhole数据域:通用配置合项服务类
 * @author Linlan
* CreateTime 2018-03-02 17:17:54
 *
 */
@Service
@Slf4j
public class BaseConfigWholeService {

    @Resource
    private BaseConfigWholeDao dao;

    /** get the list of entity BaseConfigWhole
     * 列表方法，返回列表的全局配置数据 {@link List} 对象，包含 {@link BaseConfigWhole} 列表
     * @param map the input select conditions
     * @return 列表的全局配置数据 {@link List} 对象，包含 {@link BaseConfigWhole} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseConfigWhole> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseConfigWhole}
     * @param id 配置编号|1
     * @return {@link BaseConfigWhole}
     */
    public BaseConfigWhole findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseConfigWhole the input baseConfigWhole
     */
    //@Transactional
    public void save(BaseConfigWhole baseConfigWhole) {
        baseConfigWhole.init();
        dao.save(baseConfigWhole);
    }

    /** save the entity with input list
     * 保存对象通用配置合项，批量保存list
     * @param list {@link BaseConfigWhole}
     */
    public void batchSave(List<BaseConfigWhole> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseConfigWhole the input baseConfigWhole
     */
    //@Transactional
    public void update(BaseConfigWhole baseConfigWhole) {
        dao.update(baseConfigWhole);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 配置编号|1
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

    /** get the page of dto BaseConfigWholeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseConfigWholeParam }
     * @return 分页的全局配置数据 {@link Page} 对象，包含 {@link BaseConfigWhole} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseConfigWholeDto> getPageDto(BaseConfigWholeParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseConfigWholeDto}
     * @param id 配置编号|1
     * @return {@link BaseConfigWholeDto}
     */
    public BaseConfigWholeDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    /** update value by key
     * 通过key关键字更新value信息
     * @param key   键
     * @param value 值
     */
    @Transactional
    public void updateValueByKey(String key, String value) {
        dao.updateValueByKey(key, value);
    }

    public String getValue(String key) {
        return dao.getByKey(key).getCfgKey();
    }

    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if (StringUtils.isNotBlank(value)) {
            return JSON.parseObject(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new CommonException("获取参数失败");
        }
    }

    public List<BaseConfigWhole> getByIds(List<String> ids) {
        return dao.getByIds(ids);
    }

    public BaseConfigWhole getByKey(String key) {
        return dao.getByKey(key);
    }

    public List<BaseConfigWhole> getByKeys(List<String> keys) {
        return dao.getByKeys(keys);
    }

    public List<BaseConfigWhole> getByKeyLike(String key) {
        return dao.getByKeyLike(key);
    }

    public void deleteByKey(String key) {
        if (StringUtils.isBlank(key)) {
            return;
        }
        dao.deleteByKey(key);
    }

    public void deleteByKeys(List<String> keys) {
        if (ObjectUtils.isEmpty(keys)) {
            return;
        }
        dao.deleteByKeys(keys);
    }

}
