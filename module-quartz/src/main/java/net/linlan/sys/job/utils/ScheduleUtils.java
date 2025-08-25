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

import java.text.ParseException;
import java.util.Date;

import org.quartz.*;

import net.linlan.commons.core.StringUtils;
import net.linlan.sys.job.entity.ScheduleInfo;
import net.linlan.utils.SpringContextUtils;
import net.linlan.utils.exception.UtilsException;

/**
 *
 * Filename:ScheduleUtils.java
 * Desc:定时任务工具类
 *
 * @author Linlan
 * CreateTime:2017/7/14 12:08
 *
 * @version 1.0
 * @since 1.0
 *
 */
public class ScheduleUtils {

    private final static String  JOB_NAME          = "LL_TASK_";

    /**
     * 定时任务白名单配置（仅允许访问的包名，如其他需要可以自行添加）
     */
    public static final String[] JOB_WHITELIST_STR = { "net.linlan.plat.job.task",
                                                       "net.linlan.quartz.task" };

    /**
     * 定时任务违规的字符
     */
    public static final String[] JOB_ERROR_STR     = { "java.net.URL",
                                                       "javax.naming.InitialContext",
                                                       "org.yaml.snakeyaml", "org.springframework",
                                                       "org.apache" };

    /**
     * 获取触发器key
     * @param scheduleId    计划ID
     * @return 触发器Key
     */
    public static TriggerKey getTriggerKey(String scheduleId) {
        return TriggerKey.triggerKey(JOB_NAME + scheduleId);
    }

    /**
     * 获取jobKey
     * @param scheduleId    计划ID
     * @return 任务Key
     */
    public static JobKey getJobKey(String scheduleId) {
        return JobKey.jobKey(JOB_NAME + scheduleId);
    }

    /**
     * 获取表达式触发器
     * @param scheduler    执行器
     * @param scheduleId    计划ID
     * @return 触发调度
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, String scheduleId) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(scheduleId));
        } catch (SchedulerException e) {
            throw new UtilsException("获取定时任务CronTrigger出现异常", e);
        }
    }

    /**
     * 创建定时任务
     * @param scheduler    执行器
     * @param scheduleJob    计划对象
     */
    public static void createScheduleJob(Scheduler scheduler, ScheduleInfo scheduleJob) {
        try {
            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class)
                .withIdentity(getJobKey(scheduleJob.getId())).build();

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(scheduleJob.getCronExpression())
                .withMisfireHandlingInstructionDoNothing();

            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(getTriggerKey(scheduleJob.getId())).withSchedule(scheduleBuilder)
                .build();

            //放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(ScheduleInfo.JOB_PARAM_KEY, scheduleJob);

            scheduler.scheduleJob(jobDetail, trigger);

            //暂停任务
            if (scheduleJob.getStatus() == ScheduleInfo.ScheduleStatus.PAUSE.getValue()) {
                pauseJob(scheduler, scheduleJob.getId());
            }
        } catch (SchedulerException e) {
            throw new UtilsException("创建定时任务失败", e);
        }
    }

    /**
     * 更新定时任务
     * @param scheduler    执行器
     * @param scheduleJob    计划对象
     */
    public static void updateScheduleJob(Scheduler scheduler, ScheduleInfo scheduleJob) {
        try {
            TriggerKey triggerKey = getTriggerKey(scheduleJob.getId());

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(scheduleJob.getCronExpression())
                .withMisfireHandlingInstructionDoNothing();

            CronTrigger trigger = getCronTrigger(scheduler, scheduleJob.getId());

            //按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                .withSchedule(scheduleBuilder).build();

            //参数
            trigger.getJobDataMap().put(ScheduleInfo.JOB_PARAM_KEY, scheduleJob);

            scheduler.rescheduleJob(triggerKey, trigger);

            //暂停任务
            if (scheduleJob.getStatus() == ScheduleInfo.ScheduleStatus.PAUSE.getValue()) {
                pauseJob(scheduler, scheduleJob.getId());
            }

        } catch (SchedulerException e) {
            throw new UtilsException("更新定时任务失败", e);
        }
    }

    /**
     * 立即执行任务
     * @param scheduler    执行器
     * @param scheduleJob    计划对象
     */
    public static void run(Scheduler scheduler, ScheduleInfo scheduleJob) {
        try {
            //参数
            JobDataMap dataMap = new JobDataMap();
            dataMap.put(ScheduleInfo.JOB_PARAM_KEY, scheduleJob);

            scheduler.triggerJob(getJobKey(scheduleJob.getId()), dataMap);
        } catch (SchedulerException e) {
            throw new UtilsException("立即执行定时任务失败", e);
        }
    }

    /**
     * 暂停任务
     * @param scheduler    执行器
     * @param scheduleId    计划ID
     */
    public static void pauseJob(Scheduler scheduler, String scheduleId) {
        try {
            scheduler.pauseJob(getJobKey(scheduleId));
        } catch (SchedulerException e) {
            throw new UtilsException("暂停定时任务失败", e);
        }
    }

    /**
     * 恢复任务
     * @param scheduler    执行器
     * @param scheduleId    计划ID
     */
    public static void resumeJob(Scheduler scheduler, String scheduleId) {
        try {
            scheduler.resumeJob(getJobKey(scheduleId));
        } catch (SchedulerException e) {
            throw new UtilsException("暂停定时任务失败", e);
        }
    }

    /**
     * 删除定时任务
     * @param scheduler    执行器
     * @param scheduleId    计划ID
     */
    public static void deleteScheduleJob(Scheduler scheduler, String scheduleId) {
        try {
            scheduler.deleteJob(getJobKey(scheduleId));
        } catch (SchedulerException e) {
            throw new UtilsException("删除定时任务失败", e);
        }
    }

    /**
     * 检查包名是否为白名单配置
     *
     * @param invokeTarget 目标字符串
     * @return 结果
     */
    public static boolean whiteList(String invokeTarget) {
        String packageName = StringUtils.substringBefore(invokeTarget, "(");
        int count = StringUtils.countMatches(packageName, ".");
        if (count > 1) {
            return StringUtils.containsAnyIgnoreCase(invokeTarget, JOB_WHITELIST_STR);
        }
        Object obj = SpringContextUtils.getBean(StringUtils.split(invokeTarget, ".")[0]);
        String beanPackageName = obj.getClass().getPackage().getName();
        return StringUtils.containsAnyIgnoreCase(beanPackageName, JOB_WHITELIST_STR)
               && !StringUtils.containsAnyIgnoreCase(beanPackageName, JOB_ERROR_STR);
    }

    /**
     * 返回一个布尔值代表一个给定的Cron表达式的有效性
     *
     * @param cronExpression Cron表达式
     * @return boolean 表达式是否有效
     */
    public static boolean isValid(String cronExpression) {
        return CronExpression.isValidExpression(cronExpression);
    }

    /**
     * 返回一个字符串值,表示该消息无效Cron表达式给出有效性
     *
     * @param cronExpression Cron表达式
     * @return String 无效时返回表达式错误描述,如果有效返回null
     */
    public static String getInvalidMessage(String cronExpression) {
        try {
            new CronExpression(cronExpression);
            return null;
        } catch (ParseException pe) {
            return pe.getMessage();
        }
    }

    /**
     * 返回下一个执行时间根据给定的Cron表达式
     *
     * @param cronExpression Cron表达式
     * @return Date 下次Cron表达式执行时间
     */
    public static Date getNextExecution(String cronExpression) {
        try {
            CronExpression cron = new CronExpression(cronExpression);
            return cron.getNextValidTimeAfter(new Date(System.currentTimeMillis()));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
