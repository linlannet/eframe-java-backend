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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.sys.comm.dao.CommImportDao;
import net.linlan.sys.comm.dto.CommImportDto;
import net.linlan.sys.comm.entity.CommImport;
import net.linlan.sys.comm.param.CommImportParam;

/**
 *
 * CommImport数据域:应用基础通用导入服务类
 * @author Linlan
 * CreateTime 2022-10-20 17:47:23
 *
 */
@Service
@Slf4j
public class CommImportService {

    @Resource
    private CommImportDao dao;

    /** get the list of entity CommImport
     * 列表方法，返回列表的通用导入数据 {@link List} 对象，包含 {@link CommImport} 列表
     * @param map the input select conditions
     * @return 列表的通用导入数据 {@link List} 对象，包含 {@link CommImport} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CommImport> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CommImport}
     * @param id the CommImport 导出任务ID | 1
     * @return {@link CommImport}
     */
    public CommImport findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param commImport the input commImport
     */
    //@Transactional
    public void save(CommImport commImport) {
        commImport.init();
        dao.save(commImport);
    }

    /** save the entity with input list
     * 保存对象应用基础通用导入，批量保存list
     * @param list {@link CommImport}
     */
    public void batchSave(List<CommImport> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param commImport the input commImport
     */
    //@Transactional
    public void update(CommImport commImport) {
        dao.update(commImport);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the CommImport 导出任务ID | 1
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

    /** get the page of dto CommImportDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CommImportParam }
     * @return 分页的通用导入数据 {@link Page} 对象，包含 {@link CommImport} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CommImportDto> getPageDto(CommImportParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CommImportDto}
     * @param id the CommImport 导出任务ID | 1
     * @return {@link CommImportDto}
     */
    public CommImportDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /**
     * 查询 通用导入记录 列表
     * @param params    查询参数
     * @return  查询结果
     */
    public Page<CommImportDto> getCommImportList(CommImportParam params) {
        PageHelper.startPage(params.getPage(), params.getLimit());
        return dao.getCommImportList(params);
    }

}
