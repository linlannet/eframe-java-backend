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

import java.util.Date;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.sys.job.param.ScheduleLogParam;
import net.linlan.utils.entity.BaseEntity;

/**
 * 定时任务调度日志表 sys_job_log
 * 
 * @author Linlan
 */
@Data
public class SysJobLogParam extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "日志序号")
    private Long              jobLogId;

    @Excel(name = "任务序号")
    private String            jobId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String            jobName;

    /** 任务组名 */
    @Excel(name = "任务组名")
    private String            jobGroup;

    /** 调用目标字符串 */
    @Excel(name = "调用目标字符串")
    private String            invokeTarget;

    /** 日志信息 */
    @Excel(name = "日志信息")
    private String            jobMessage;

    /** 执行状态（0正常 1失败） */
    @Excel(name = "执行状态", readConverterExp = "0=正常,1=失败")
    private Integer           status;

    /** 异常信息 */
    @Excel(name = "异常信息")
    private String            exceptionInfo;

    /** 开始时间 */
    private Date              startTime;

    /** 停止时间 */
    private Date              stopTime;

    /** 备注 */
    private String            remark;

    public ScheduleLogParam toModelParam() {
        ScheduleLogParam result = new ScheduleLogParam();
        result.setScheduleId(jobId);
        result.setStatus(status);
        result.setError(jobMessage);
        return result;
    }
}
