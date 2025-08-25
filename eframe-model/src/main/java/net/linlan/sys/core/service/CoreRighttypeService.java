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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.core.dao.CoreRighttypeDao;
import net.linlan.sys.core.dto.CoreRighttypeDto;
import net.linlan.sys.core.entity.CoreRighttype;
import net.linlan.sys.core.param.CoreRighttypeParam;

/**
 *
 * CoreRighttype数据域:权限资源类型表服务类
 * @author Linlan
 * CreateTime 2018-05-08 19:39:41
 *
 */
@Service
@Slf4j
public class CoreRighttypeService {

    @Resource
    private CoreRighttypeDao dao;

    /** get the list of entity CoreRighttype
     * 列表方法，返回列表的权限资源分类数据 {@link List} 对象，包含 {@link CoreRighttype} 列表
     * @param map the input select conditions
     * @return 列表的权限资源分类数据 {@link List} 对象，包含 {@link CoreRighttype} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CoreRighttype> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CoreRighttype}
     * @param id the input id
     * @return {@link CoreRighttype}
     */
    public CoreRighttype findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param coreRighttype the input coreRighttype
     */
    //@Transactional
    public void save(CoreRighttype coreRighttype) {
        coreRighttype.init();
        dao.save(coreRighttype);
    }

    /** save the entity with input list
     * 保存对象权限资源类型表，批量保存list
     * @param list {@link CoreRighttype}
     */
    public void batchSave(List<CoreRighttype> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param coreRighttype the input coreRighttype
     */
    //@Transactional
    public void update(CoreRighttype coreRighttype) {
        dao.update(coreRighttype);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the input id
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

    /** get the page of dto CoreRighttypeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CoreRighttypeParam }
     * @return 分页的权限资源分类数据 {@link Page} 对象，包含 {@link CoreRighttype} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CoreRighttypeDto> getPageDto(CoreRighttypeParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CoreRighttypeDto}
     * @param id the input id
     * @return {@link CoreRighttypeDto}
     */
    public CoreRighttypeDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

}
