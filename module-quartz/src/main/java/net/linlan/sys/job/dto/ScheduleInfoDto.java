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
package net.linlan.sys.job.dto;

import lombok.Data;

import net.linlan.sys.job.entity.ScheduleInfo;

/**
 *
 * ScheduleInfo数据域:框架-作业-定时任务信息表查询结果Dto对象
 * @author Linlan
 * CreateTime 2023-08-12 14:36:24
 *
 */
@Data
public class ScheduleInfoDto extends ScheduleInfo {
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 状态名称
     */
    private String statusName;
}
