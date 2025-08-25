/*
 * module-quartz - quartz定时任务模块
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
package net.linlan.sys.job.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.job.dao.ScheduleLogDao;
import net.linlan.sys.job.dto.ScheduleLogDto;
import net.linlan.sys.job.entity.ScheduleLog;
import net.linlan.sys.job.param.ScheduleLogParam;

/**
 *
 * ScheduleLog数据域:框架-作业-定时任务日志表服务类
 * @author Linlan
 * CreateTime 2018-03-02 17:25:07
 *
 */
@Service
@Slf4j
public class ScheduleLogService {

    @Resource
    private ScheduleLogDao dao;

    /** get the list of entity ScheduleLog，列表方法，返回计划任务日志列表
     * @param map the input select conditions
     * @return 计划任务日志列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<ScheduleLog> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link ScheduleLog}
     * @param id the input id
     * @return {@link ScheduleLog}
     */
    public ScheduleLog findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param scheduleLog the input scheduleLog
     */
    //@Transactional
    public void save(ScheduleLog scheduleLog) {
        scheduleLog.init();
        dao.save(scheduleLog);
    }

    /** save the entity with input list
     * 保存对象框架-作业-定时任务日志表，批量保存list
     * @param list {@link ScheduleLog}
     */
    public void batchSave(List<ScheduleLog> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param scheduleLog the input scheduleLog
     */
    //@Transactional
    public void update(ScheduleLog scheduleLog) {
        dao.update(scheduleLog);
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

    /** get the page of dto ScheduleLogDto，列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link ScheduleLogParam }
     * @return 列表分页方法，返回分页DTO对象列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<ScheduleLogDto> getPageDto(ScheduleLogParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link ScheduleLogDto}
     * @param id the input id
     * @return {@link ScheduleLogDto}
     */
    public ScheduleLogDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

}
