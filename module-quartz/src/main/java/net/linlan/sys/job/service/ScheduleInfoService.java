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

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.Scheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.script.json.StringMap;
import net.linlan.sys.job.dao.ScheduleInfoDao;
import net.linlan.sys.job.dto.ScheduleInfoDto;
import net.linlan.sys.job.entity.ScheduleInfo;
import net.linlan.sys.job.param.ScheduleInfoParam;
import net.linlan.sys.job.utils.ScheduleUtils;

/**
 *
 * ScheduleInfo数据域:框架-作业-定时任务信息表服务类
 * @author Linlan
 * CreateTime 2018-03-02 17:25:07
 *
 */
@Service
@Slf4j
public class ScheduleInfoService {

    @Resource
    private ScheduleInfoDao dao;
    @Resource
    private Scheduler       scheduler;

    /** get the list of entity ScheduleInfo，列表方法，返回计划任务列表
     * @param map the input select conditions
     * @return 计划任务列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<ScheduleInfo> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link ScheduleInfo}
     * @param id the input id
     * @return {@link ScheduleInfo}
     */
    public ScheduleInfo findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param scheduleInfo the input scheduleInfo
     */
    //@Transactional
    public void save(ScheduleInfo scheduleInfo) {
        scheduleInfo.init();
        dao.save(scheduleInfo);
        ScheduleUtils.createScheduleJob(scheduler, scheduleInfo);
    }

    /** save the entity with input list
     * 保存对象框架-作业-定时任务信息表，批量保存list
     * @param list {@link ScheduleInfo}
     */
    public void batchSave(List<ScheduleInfo> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param scheduleInfo the input scheduleInfo
     */
    //@Transactional
    public void update(ScheduleInfo scheduleInfo) {
        dao.update(scheduleInfo);
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
        for (String id : ids) {
            ScheduleUtils.deleteScheduleJob(scheduler, id);
        }
        //删除数据
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

    /** get the page of dto ScheduleInfoDto，列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link ScheduleInfoParam }
     * @return 列表分页方法，返回分页DTO对象列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<ScheduleInfoDto> getPageDto(ScheduleInfoParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link ScheduleInfoDto}
     * @param id the input id
     * @return {@link ScheduleInfoDto}
     */
    public ScheduleInfoDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    /** 批量更新传入的ids更新任务调度的状态
     * @param ids    任务Ids
     * @param status    任务状态
     * @return  更新结果
     */
    public long updateStatusBatch(String[] ids, int status) {
        return dao.updateStatusBatch(new StringMap().put("ids", ids).put("status", status)
            .put("lastTime", new Timestamp(System.currentTimeMillis())).map());
    }

    @Transactional
    public void run(String[] ids) {
        //已经初始化后的任务，立即执行
        for (String id : ids) {
            ScheduleUtils.run(scheduler, findById(id));
        }
    }

    @Transactional
    public void pause(String[] ids) {
        //调用Quartz，进行任务暂停
        for (String id : ids) {
            ScheduleUtils.pauseJob(scheduler, id);
        }
        //更新当前任务的状态
        updateStatusBatch(ids, ScheduleInfo.ScheduleStatus.PAUSE.getValue());
    }

    @Transactional
    public void resume(String[] ids) {
        //调用Quartz，进行任务恢复
        for (String id : ids) {
            ScheduleUtils.resumeJob(scheduler, id);
        }
        //更新当前任务的状态
        updateStatusBatch(ids, ScheduleInfo.ScheduleStatus.NORMAL.getValue());
    }

}
