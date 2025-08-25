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

import net.linlan.sys.comm.dao.CommExportDao;
import net.linlan.sys.comm.dto.CommExportDto;
import net.linlan.sys.comm.dto.PackageDto;
import net.linlan.sys.comm.entity.CommExport;
import net.linlan.sys.comm.param.CommExportParam;

/**
 *
 * CommExport数据域:应用基础通用导出服务类
 * @author Linlan
 * CreateTime 2022-06-15 11:56:49
 *
 */
@Service
@Slf4j
public class CommExportService {

    @Resource
    private CommExportDao dao;

    /** get the list of entity CommExport
     * 列表方法，返回列表的通用导出数据 {@link List} 对象，包含 {@link CommExport} 列表
     * @param map the input select conditions
     * @return 列表的通用导出数据 {@link List} 对象，包含 {@link CommExport} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CommExport> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CommExport}
     * @param id the CommExport 导出任务ID | 1
     * @return {@link CommExport}
     */
    public CommExport findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param commExport the input commExport
     */
    //@Transactional
    public void save(CommExport commExport) {
        commExport.init();
        dao.save(commExport);
    }

    /** save the entity with input list
     * 保存对象应用基础通用导出，批量保存list
     * @param list {@link CommExport}
     */
    public void batchSave(List<CommExport> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param commExport the input commExport
     */
    //@Transactional
    public void update(CommExport commExport) {
        dao.update(commExport);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the CommExport 导出任务ID | 1
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

    /** get the page of dto CommExportDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CommExportParam }
     * @return 分页的通用导出数据 {@link Page} 对象，包含 {@link CommExport} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CommExportDto> getPageDto(CommExportParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CommExportDto}
     * @param id the CommExport 导出任务ID | 1
     * @return {@link CommExportDto}
     */
    public CommExportDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /**
     * 获取导出信息，目前name对应taskInfo的name
     * @param exportId  导出ID
     * @return  查询结果
     */
    public List<PackageDto> getPackageList(String exportId) {
        return dao.getPackageList(exportId);
    }

}
