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

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.core.dao.CoreRoletypeDao;
import net.linlan.sys.core.dto.CoreRoletypeDto;
import net.linlan.sys.core.entity.CoreRoletype;
import net.linlan.sys.core.param.CoreRoletypeParam;

/**
 *
 * CoreRoletype数据域:角色分类表服务类
 * @author Linlan
 * CreateTime 2018-05-08 19:39:41
 *
 */
@Service
@Slf4j
public class CoreRoletypeService {

    @Resource
    private CoreRoletypeDao dao;

    /** get the list of entity CoreRoletype
     * 列表方法，返回列表的角色分类数据 {@link List} 对象，包含 {@link CoreRoletype} 列表
     * @param map the input select conditions
     * @return 列表的角色分类数据 {@link List} 对象，包含 {@link CoreRoletype} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CoreRoletype> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CoreRoletype}
     * @param id the input id
     * @return {@link CoreRoletype}
     */
    public CoreRoletype findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param coreRoletype the input coreRoletype
     */
    //@Transactional
    public void save(CoreRoletype coreRoletype) {
        coreRoletype.init();
        dao.save(coreRoletype);
    }

    /** save the entity with input list
     * 保存对象角色分类表，批量保存list
     * @param list {@link CoreRoletype}
     */
    public void batchSave(List<CoreRoletype> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param coreRoletype the input coreRoletype
     */
    //@Transactional
    public void update(CoreRoletype coreRoletype) {
        dao.update(coreRoletype);
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

    /** get the page of dto CoreRoletypeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CoreRoletypeParam }
     * @return 分页的角色分类数据 {@link Page} 对象，包含 {@link CoreRoletype} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CoreRoletypeDto> getPageDto(CoreRoletypeParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CoreRoletypeDto}
     * @param id the input id
     * @return {@link CoreRoletypeDto}
     */
    public CoreRoletypeDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    /** 通过code查询角色类型对象
     * @param code    代码
     * @return    查询结果
     */
    public CoreRoletype findByCode(String code) {
        return dao.findByCode(code);
    }

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @param roletypeId    角色类型ID
     * @return    返回结果List
     */
    public List<DictionaryInitDto> getForSelect(@Param("roletypeId") String roletypeId) {
        return dao.getForSelect(roletypeId);
    }
}
