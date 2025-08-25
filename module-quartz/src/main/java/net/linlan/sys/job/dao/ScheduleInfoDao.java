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

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.job.dto.ScheduleInfoDto;
import net.linlan.sys.job.entity.ScheduleInfo;
import net.linlan.sys.job.param.ScheduleInfoParam;

/**
*
* ScheduleInfo数据域:框架-作业-定时任务信息表持久层Dao
* @author Linlan
* CreateTime 2018-03-02 17:25:07
*
*/
@Mapper
public interface ScheduleInfoDao extends MybatisBaseDao<ScheduleInfo> {

    /** get the page of dto ScheduleInfoDto，列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link ScheduleInfoParam }
     * @return 列表分页方法，返回分页DTO对象列表
     */
    Page<ScheduleInfoDto> getPageDto(ScheduleInfoParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link ScheduleInfoDto}
     * @param id the input id
     * @return {@link ScheduleInfoDto}
     */
    ScheduleInfoDto getDtoById(String id);

    /** 批量更新传入的ids更新任务调度的状态
     * @param map    查询map
     * @return  更新结果
     */
    long updateStatusBatch(Map<String, Object> map);

}
