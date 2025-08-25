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
package net.linlan.sys.job.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * ScheduleInfo数据域:框架-作业-定时任务信息表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 14:36:24
 *
 */
@Data
public class ScheduleInfoParam extends BaseParam {

    /**
    * 应用ID
    */
    private String  appId;
    /**
    * 系统管理用户ID
    */
    private String  userId;
    /**
    * 任务类型1系统内添加2预警任务添加3指标数据获取添加4指标数据执行添加
    */
    private Integer jobSource;
    /**
    * 任务类型1内部任务2邮件3短信4内容接口
    */
    private String  jobType;
    /**
    * 任务名称
    */
    private String  scheduleName;
    /**
    * 类对象名称
    */
    private String  objectName;
    /**
    * 方法名称
    */
    private String  methodName;
    /**
    * cron任务表达式，0 0/30 * * * ?
    */
    private String  cronExpression;
    /**
    * 任务详情，JSON格式
    */
    private String  jobConfig;
    /**
    * 开始时间
    */
    private Date    startDate;
    /**
    * 结束时间
    */
    private Date    endDate;
    /**
    * 任务状态:0未启动1正常2暂停
    */
    private Integer status;
    /**
    * 描述
    */
    private String  description;
    /**
    * 备用1
    */
    private String  spare1;
    /**
    * 备用2
    */
    private String  spare2;
    /**
     * 关键字
     */
    private String  key;

    /**
     * 停止状态
     */
    private String  statusStop;
    /**
     * 更新开始日期
     */
    private String  startLastTime;
    /**
     * 更新结束日期
     */
    private String  endLastTime;
}
