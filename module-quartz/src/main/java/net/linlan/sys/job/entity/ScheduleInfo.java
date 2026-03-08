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
package net.linlan.sys.job.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * ScheduleInfo数据域:框架-作业-定时任务信息表实体类
 * @author Linlan
 * CreateTime 2018-03-02 17:25:07
 *
 */
@Data
public class ScheduleInfo extends BaseEntity implements Serializable {
    private static final long  serialVersionUID        = 1L;
    /**
     * 任务调度参数key
     */
    public static final String JOB_PARAM_KEY           = "JOB_PARAM_KEY";
    /**
     * 1系统内添加2预警任务添加3指标数据获取添加4指标数据执行添加
     */
    public static int          JOB_SOURCE_DEFAULT      = 1;
    /**
     * 1内部任务2邮件3短信4内容接口
     */
    public static String       JOB_TYPE_DEFAULT        = "1";

    /**
     * quartz 的 Cron Expression，默认为0 0 0/1 * * ?
     */
    public static final String CRON_EXPRESSION_DEFAULT = "0 0 0/1 * * ?";

    /**
    * 计划编号
    */
    private String             id;

    /**
    * 应用ID
    */
    private String             appId;

    /**
    * 任务类型1系统内添加2预警任务添加3指标数据获取添加4指标数据执行添加
    */
    @NotBlank(message = "任务来源不能为空")
    private Integer            jobSource;

    /**
    * 任务类型1内部任务2邮件3短信4内容接口
    */
    @NotBlank(message = "任务类型不能为空")
    private String             jobType;

    /**
    * 任务名称
    */
    private String             scheduleName;

    /**
    * 类对象名称
    */
    @NotBlank(message = "类对象名称不能为空")
    private String             objectName;

    /**
    * 方法名称
    */
    @NotBlank(message = "方法名称不能为空")
    private String             methodName;

    /**
    * 参数
    */
    private String             params;

    /**
    * cron任务表达式，0 0/30 * * * ?
    */
    @NotBlank(message = "cron表达式不能为空")
    private String             cronExpression;

    /**
    * 任务详情，JSON格式
    */
    private String             jobConfig;

    /**
    * 开始时间
    */
    private Date               startDate;

    /**
    * 结束时间
    */
    private Date               endDate;

    /**
    * 任务状态:0未启动1正常2暂停
    */
    private Integer            status;

    /**
    * 描述
    */
    private String             description;

    /**
    * 备用1
    */
    private String             spare1;

    /**
    * 备用2
    */
    private String             spare2;

    //hcday add 2017-12-10
    // hcday modify 2020-11-04，调整状态
    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
                                /**
                                 * 草稿
                                 */
                                DRAFT(0),
                                /**
                                 * 正常
                                 */
                                NORMAL(1),
                                /**
                                 * 暂停
                                 */
                                PAUSE(2),
                                /**
                                 * 调试
                                 */
                                DEBUG(3);

        private int value;

        private ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }
        if (getJobSource() == null) {
            setJobSource(JOB_SOURCE_DEFAULT);
        }
        if (getJobType() == null) {
            setJobType(JOB_TYPE_DEFAULT);
        }
        if (getCronExpression() == null) {
            setCronExpression(CRON_EXPRESSION_DEFAULT);
        }

        if (getStatus() == null) {
            setStatus(ScheduleStatus.DRAFT.getValue());
        }

    }

}
