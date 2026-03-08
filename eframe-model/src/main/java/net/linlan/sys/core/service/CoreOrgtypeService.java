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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.param.TreeParam;
import net.linlan.sys.core.dao.CoreOrgtypeDao;
import net.linlan.sys.core.dto.CoreOrgtypeDto;
import net.linlan.sys.core.entity.CoreOrgtype;
import net.linlan.sys.core.param.CoreOrgtypeParam;

/**
 *
 * CoreOrgtype数据域:机构分类表服务类
 * @author Linlan
 * CreateTime 2023-08-12 13:45:49
 *
 */
@Service
@Slf4j
public class CoreOrgtypeService {

    @Resource
    private CoreOrgtypeDao dao;

    /** get the list of entity CoreOrgtype
     * 列表方法，返回列表的机构分类数据 {@link List} 对象，包含 {@link CoreOrgtype} 列表
     * @param map the input select conditions
     * @return 列表的机构分类数据 {@link List} 对象，包含 {@link CoreOrgtype} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CoreOrgtype> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CoreOrgtype}
     * @param id the input id
     * @return {@link CoreOrgtype}
     */
    public CoreOrgtype findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param coreOrgtype the input coreOrgtype
     */
    //@Transactional
    public void save(CoreOrgtype coreOrgtype) {
        coreOrgtype.init();
        dao.save(coreOrgtype);
    }

    /** save the entity with input list
     * 保存对象机构分类表，批量保存list
     * @param list {@link CoreOrgtype}
     */
    public void batchSave(List<CoreOrgtype> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param coreOrgtype the input coreOrgtype
     */
    //@Transactional
    public void update(CoreOrgtype coreOrgtype) {
        dao.update(coreOrgtype);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the input id
     */
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    //@Transactional
    public void deleteByIds(Long[] ids) {
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

    /** get the page of dto CoreOrgtypeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CoreOrgtypeParam }
     * @return 分页的机构分类数据 {@link Page} 对象，包含 {@link CoreOrgtype} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CoreOrgtypeDto> getPageDto(CoreOrgtypeParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CoreOrgtypeDto}
     * @param id the input id
     * @return {@link CoreOrgtypeDto}
     */
    public CoreOrgtypeDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /** 获取树节点的下级列表
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    public List<TreeNode> getOrgTypeChildren(TreeParam treeParam) {
        return dao.getOrgTypeChildren(treeParam);
    }

    /** 通过名称、简称等条件查询下拉框列表
     * @param params    查询参数
     * @return  查询结果
     */
    public Page<CoreOrgtypeDto> getAllSelectList(CoreOrgtypeParam params) {
        return dao.getAllSelectList(params);
    }

}
