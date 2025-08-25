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
package net.linlan.sys.job.dao;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.job.dto.ScheduleLogDto;
import net.linlan.sys.job.entity.ScheduleLog;
import net.linlan.sys.job.param.ScheduleLogParam;

/**
*
* ScheduleLog数据域:框架-作业-定时任务日志表持久层Dao
* @author Linlan
* CreateTime 2018-03-02 17:25:07
*
*/
@Mapper
public interface ScheduleLogDao extends MybatisBaseDao<ScheduleLog> {

    /** get the page of dto ScheduleLogDto，列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link ScheduleLogParam }
     * @return 列表分页方法，返回分页DTO对象列表
     */
    Page<ScheduleLogDto> getPageDto(ScheduleLogParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link ScheduleLogDto}
     * @param id the input id
     * @return {@link ScheduleLogDto}
     */
    ScheduleLogDto getDtoById(String id);

}
