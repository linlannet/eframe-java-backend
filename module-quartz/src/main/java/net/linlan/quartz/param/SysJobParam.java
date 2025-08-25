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
package net.linlan.quartz.param;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.annotation.Excel.ColumnType;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.job.constant.ScheduleConstants;
import net.linlan.sys.job.param.ScheduleInfoParam;

/**
 * 定时任务调度表 sys_job
 * 
 * @author Linlan
 */
@Data
public class SysJobParam {
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    @Excel(name = "任务序号", cellType = ColumnType.NUMERIC)
    private Long              jobId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String            jobName;

    /** 任务组名 */
    @Excel(name = "任务组名")
    private String            jobGroup;

    /** 调用目标字符串 */
    @Excel(name = "调用目标字符串")
    private String            invokeTarget;

    /** cron执行表达式 */
    @Excel(name = "执行表达式 ")
    private String            cronExpression;

    /** cron计划策略 */
    @Excel(name = "计划策略 ", readConverterExp = "0=默认,1=立即触发执行,2=触发一次执行,3=不触发立即执行")
    private String            misfirePolicy    = ScheduleConstants.MISFIRE_DEFAULT;

    /** 是否并发执行（0允许 1禁止） */
    @Excel(name = "并发执行", readConverterExp = "0=允许,1=禁止")
    private String            concurrent;

    /** 任务状态（0正常 1暂停） */
    @Excel(name = "任务状态", readConverterExp = "0=正常,1=暂停")
    private Integer           status;

    /** 备注 */
    private String            remark;

    public ScheduleInfoParam toModelParam() {
        ScheduleInfoParam result = new ScheduleInfoParam();
        result.setJobType(jobGroup);
        result.setScheduleName(jobName);
        if (StringUtils.isNotEmpty(invokeTarget)) {
            result.setObjectName(StringUtils.substringBefore(invokeTarget, "."));
            result.setMethodName(StringUtils.substringAfter(invokeTarget, "."));
        }
        result.setCronExpression(cronExpression);
        result.setStatus(status);
        result.setDescription(remark);
        return result;
    }
}
