/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.param;

import lombok.Data;

/**
 *
 * BaseParam:查询参数对象基础信息，包含分页、关键字、时间等基础字段
 * @author Linlan
 * CreateTime 2021-11-22 17:17:54
 *
 */
@Data
public class BaseParam {

    /**
     * 关键字：查询输入条件q，可匹配name、title、keywords等文本信息
     */
    private String  q;
    /**
     * 排序，默认主键倒序
     */
    private Integer orderBy;
    /**
     * 开始时间
     */
    private String  startTime;
    /**
     * 结束时间
     */
    private String  endTime;
    /**
     * 分页信息：默认第1页
     */
    private Integer page  = 1;
    /**
     * 分页每页条数，默认10条
     */
    private Integer limit = 10;

}
