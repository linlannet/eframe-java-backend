/*
 * eframe-model - model模型数据模块
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
package net.linlan.frame.config.dao;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.config.dto.PublicNoticeDto;
import net.linlan.frame.config.entity.PublicNotice;
import net.linlan.frame.config.param.PublicNoticeParam;

/**
*
* PublicNotice数据域:平台公共消息持久层Dao
* @author Linlan
* CreateTime 2023-10-02 22:29:22
*
*/
@Mapper
public interface PublicNoticeDao extends MybatisBaseDao<PublicNotice> {

    /** get the page of dto PublicNoticeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link PublicNoticeParam }
     * @return 分页的通告数据 {@link Page} 对象，包含 {@link PublicNotice} 列表
     */
    Page<PublicNoticeDto> getPageDto(PublicNoticeParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link PublicNoticeDto}
     * @param id 信息ID|1
     * @return {@link PublicNoticeDto}
     */
    PublicNoticeDto getDtoById(Long id);

    Page<PublicNoticeDto> getMyselfList(PublicNoticeParam param);
}
