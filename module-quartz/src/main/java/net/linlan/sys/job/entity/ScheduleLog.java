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

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * ScheduleLog数据域:框架-作业-定时任务日志表实体类
 * @author Linlan
 * CreateTime 2018-03-02 17:25:07
 *
 */
@Data
public class ScheduleLog extends BaseEntity {
    /**
     * 任务状态    0：成功    1：失败
     */
    public static int STATUS_SUCCESS = 0;
    public static int STATUS_FAILURE = 1;

    /**
    * 日志编号
    */
    private String    id;

    /**
    * 任务编号
    */
    private String    scheduleId;

    /**
    * 任务状态:0成功1失败
    */
    private Integer   status;

    /**
    * 失败信息
    */
    private String    error;

    /**
    * 耗时(单位：毫秒)
    */
    private Integer   times;

    /**
    * 备用1
    */
    private String    spare1;

    /**
    * 备用2
    */
    private String    spare2;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }
    }

}
