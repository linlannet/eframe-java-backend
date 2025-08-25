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
package net.linlan.sys.job.utils;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import net.linlan.commons.core.StringUtils;
import net.linlan.sys.job.entity.ScheduleInfo;
import net.linlan.sys.job.entity.ScheduleLog;
import net.linlan.sys.job.service.ScheduleLogService;
import net.linlan.utils.SpringContextUtils;

/**
 *
 * Filename:ScheduleJob.java
 * Desc:定时任务执行类，对QuartzJobBean进行扩展，实现任务的调度和运行
 *
 * @author Linlan
 * CreateTime:2018-03-01 14:25:07
 *
 * @version 1.0
 * @since 1.0
 *
 */
public class ScheduleJob extends QuartzJobBean {
    private Logger          logger  = LoggerFactory.getLogger(getClass());
    private ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        ScheduleInfo schedule = (ScheduleInfo) context.getMergedJobDataMap()
            .get(ScheduleInfo.JOB_PARAM_KEY);
        //如果任务已经暂停，则不执行，直接返回，因为此处存在一次性运行的测试情况，暂时允许通过
        if (schedule.getStatus() == ScheduleInfo.ScheduleStatus.PAUSE.getValue()) {
            return;
        }
        //获取spring bean
        ScheduleLogService scheduleLogService = (ScheduleLogService) SpringContextUtils
            .getBean("scheduleLogService");

        //数据库保存执行记录
        ScheduleLog log = new ScheduleLog();
        log.setScheduleId(schedule.getId());
        log.setCreateTime(new Date());

        //任务开始时间
        long startTime = System.currentTimeMillis();

        try {
            //执行任务
            logger.info("任务准备执行，任务ID：" + schedule.getId());
            //通过ObjectName， MethodName， Params执行调度任务
            ScheduleRunnable task = new ScheduleRunnable(schedule.getAppId(),
                schedule.getObjectName(), schedule.getMethodName(), schedule.getParams());
            Future<?> future = service.submit(task);

            future.get();

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            log.setTimes((int) times);
            //任务状态    0：成功    1：失败
            log.setStatus(ScheduleLog.STATUS_SUCCESS);

            logger.info("任务执行完毕，任务ID：" + schedule.getId() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {
            logger.error("任务执行失败，任务ID：" + schedule.getId(), e);

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            log.setTimes((int) times);

            //任务状态    0：成功    1：失败
            log.setStatus(ScheduleLog.STATUS_FAILURE);
            log.setError(StringUtils.substring(e.toString(), 0, 2000));
        } finally {
            scheduleLogService.save(log);
        }

    }

}
