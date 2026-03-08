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
package net.linlan.sys.comm.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.sys.comm.dao.CommFlowDao;
import net.linlan.sys.comm.dto.CommFlowDto;
import net.linlan.sys.comm.entity.CommFlow;
import net.linlan.sys.comm.param.CommFlowParam;

/**
 *
 * CommFlow数据域:应用报备通用审批流程服务类
 * @author Linlan
 * CreateTime 2022-05-23 11:54:16
 *
 */
@Service
@Slf4j
public class CommFlowService {

    @Resource
    private CommFlowDao dao;

    /** get the list of entity CommFlow
     * 列表方法，返回列表的通用流程数据 {@link List} 对象，包含 {@link CommFlow} 列表
     * @param map the input select conditions
     * @return 列表的通用流程数据 {@link List} 对象，包含 {@link CommFlow} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CommFlow> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CommFlow}
     * @param id the CommFlow 主键 | 1
     * @return {@link CommFlow}
     */
    public CommFlow findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param commFlow the input commFlow
     */
    //@Transactional
    public void save(CommFlow commFlow) {
        commFlow.init();
        dao.save(commFlow);
    }

    /** save the entity with input list
     * 保存对象应用报备通用审批流程，批量保存list
     * @param list {@link CommFlow}
     */
    public void batchSave(List<CommFlow> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param commFlow the input commFlow
     */
    //@Transactional
    public void update(CommFlow commFlow) {
        dao.update(commFlow);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the CommFlow 主键 | 1
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

    /** get the page of dto CommFlowDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CommFlowParam }
     * @return 分页的通用流程数据 {@link Page} 对象，包含 {@link CommFlow} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CommFlowDto> getPageDto(CommFlowParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CommFlowDto}
     * @param id the CommFlow 主键 | 1
     * @return {@link CommFlowDto}
     */
    public CommFlowDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    public void deleteByForeignId(String foreignId) {
        dao.deleteByForeignId(foreignId);
    }

    public List<CommFlow> getZblpTaskTimes(String idCard) {
        return dao.getZblpTaskTimes(idCard);
    }

}
