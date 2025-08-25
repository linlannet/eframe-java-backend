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
package net.linlan.quartz.vo;

import java.util.Date;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.sys.job.dto.ScheduleLogDto;
import net.linlan.sys.job.entity.ScheduleLog;
import net.linlan.utils.entity.BaseEntity;

/**
 * 定时任务调度日志表 sys_job_log
 * 
 * @author Linlan
 */
@Data
public class SysJobLogVo extends BaseEntity {
    private static final long    serialVersionUID = 1L;

    /** ID */
    @Excel(name = "日志序号")
    private String               jobLogId;

    @Excel(name = "任务序号")
    private String               jobId;

    /** 日志信息 */
    @Excel(name = "日志信息")
    private String               jobMessage;

    /** 执行状态（0正常 1失败） */
    @Excel(name = "执行状态", readConverterExp = "0=正常,1=失败")
    private Integer              status;

    /** 异常信息 */
    @Excel(name = "异常信息")
    private String               exceptionInfo;

    /** 开始时间 */
    private Date                 startTime;

    /** 停止时间 */
    private Date                 stopTime;

    /** 备注 */
    private String               remark;

    /**
     * 数据赋值TO方法，将ScheduleInfo的input对象赋值给SysJob
     */
    public static final Function TO               = new Function<ScheduleLog, SysJobLogVo>() {
                                                      @Nullable
                                                      @Override
                                                      public SysJobLogVo apply(@Nullable ScheduleLog input) {
                                                          return new SysJobLogVo(input);
                                                      }
                                                  };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public SysJobLogVo(ScheduleLog input) {
        this.jobLogId = input.getId();
        this.jobId = input.getScheduleId();
        this.jobMessage = input.getError();
        this.status = input.getStatus();
        this.remark = input.getSpare1();
    }

    /**
     * 数据赋值DTO方法，将ScheduleInfoDto的input对象赋值给SysJob
     */
    public static final Function DTO = new Function<ScheduleLogDto, SysJobLogVo>() {
        @Nullable
        @Override
        public SysJobLogVo apply(@Nullable ScheduleLogDto input) {
            return new SysJobLogVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public SysJobLogVo(ScheduleLogDto input) {
        this.jobLogId = input.getId();
        this.jobId = input.getScheduleId();
        this.jobMessage = input.getError();
        this.status = input.getStatus();
        this.remark = input.getSpare1();
    }

}
