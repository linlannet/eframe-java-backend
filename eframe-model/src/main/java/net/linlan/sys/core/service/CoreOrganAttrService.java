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
package net.linlan.sys.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.core.dao.CoreOrganAttrDao;
import net.linlan.sys.core.entity.CoreOrganAttr;

/**
 *
 * CoreOrganAttr数据域:服务类
 * @author Linlan
 * CreateTime 2024-05-02 16:11:12
 *
 */
@Service
@Slf4j
public class CoreOrganAttrService {

    @Resource
    private CoreOrganAttrDao dao;

    /** get the list of entity CoreOrganAttr
     * 列表方法，返回列表的系统机构扩展数据 {@link List} 对象，包含 {@link CoreOrganAttr} 列表
     * @param map the input select conditions
     * @return 列表的系统机构扩展数据 {@link List} 对象，包含 {@link CoreOrganAttr} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CoreOrganAttr> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CoreOrganAttr}
     * @param id |1
     * @return {@link CoreOrganAttr}
     */
    public CoreOrganAttr findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param coreOrganAttr the input coreOrganAttr
     */
    //@Transactional
    public void save(CoreOrganAttr coreOrganAttr) {
        coreOrganAttr.init();
        dao.save(coreOrganAttr);
    }

    /** batch save the entity with input list
     * 保存对象，批量保存list
     * @param list {@link CoreOrganAttr}
     */
    public void batchSave(List<CoreOrganAttr> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param coreOrganAttr the input coreOrganAttr
     */
    //@Transactional
    public void update(CoreOrganAttr coreOrganAttr) {
        dao.update(coreOrganAttr);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id |1
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

}
