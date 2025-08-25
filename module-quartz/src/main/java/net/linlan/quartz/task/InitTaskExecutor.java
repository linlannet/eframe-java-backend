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
package net.linlan.quartz.task;

import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import net.linlan.commons.script.json.StringMap;
import net.linlan.sys.job.entity.ScheduleInfo;
import net.linlan.sys.job.service.ScheduleInfoService;
import net.linlan.sys.job.utils.ScheduleUtils;
import net.linlan.utils.SpringContextUtils;

/**
 *
 * Filename:InitTask.java
 * Desc:初始化任务执行类
 *
 * @author Linlan
 * CreateTime:2018/7/15 17:31
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Configuration
public class InitTaskExecutor implements InitializingBean {

    private Logger  logger = LoggerFactory.getLogger(this.getClass());

    //是否开启quartz, true开启   false关闭
    @Value("${platform.quartz.openInit}")
    private boolean openInit;

    /**
     * 项目启动时，初始化定时器
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (openInit) {
            Scheduler scheduler = SpringContextUtils.getBean(Scheduler.class);
            ScheduleInfoService scheduleInfoService = SpringContextUtils
                .getBean(ScheduleInfoService.class);
            //查找未开启的调度关闭任务
            List<ScheduleInfo> scheduleStatusStopList = scheduleInfoService.getList(new StringMap()
                .put("statusStop", ScheduleInfo.ScheduleStatus.NORMAL.getValue()).map());
            for (ScheduleInfo schedule : scheduleStatusStopList) {
                ScheduleUtils.deleteScheduleJob(scheduler, schedule.getId());
            }
            //查找已开启的任务调度执行任务
            List<ScheduleInfo> scheduleList = scheduleInfoService.getList(
                new StringMap().put("status", ScheduleInfo.ScheduleStatus.NORMAL.getValue()).map());
            if (scheduleList != null && scheduleList.size() > 0) {
                logger.info("调度任务启动，进入后台调度自动运行模式");
                for (ScheduleInfo schedule : scheduleList) {
                    CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler,
                        schedule.getId());
                    //如果不存在，则创建
                    if (cronTrigger == null) {
                        ScheduleUtils.createScheduleJob(scheduler, schedule);
                    } else {
                        ScheduleUtils.updateScheduleJob(scheduler, schedule);
                    }
                }
            }
        }
    }
}
