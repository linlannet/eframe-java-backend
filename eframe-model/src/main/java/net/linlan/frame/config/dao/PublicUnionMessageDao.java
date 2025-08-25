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
import net.linlan.frame.config.dto.PublicUnionMessageDto;
import net.linlan.frame.config.entity.PublicUnionMessage;
import net.linlan.frame.config.param.PublicUnionMessageParam;

/**
*
* PublicUnionMessage数据域:统一消息接收持久层Dao
* @author Linlan
* CreateTime 2024-10-02 22:29:21
*
*/
@Mapper
public interface PublicUnionMessageDao extends MybatisBaseDao<PublicUnionMessage> {

    /** get the page of dto PublicUnionMessageDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link PublicUnionMessageParam }
     * @return 分页的统一消息数据 {@link Page} 对象，包含 {@link PublicUnionMessage} 列表
     */
    Page<PublicUnionMessageDto> getPageDto(PublicUnionMessageParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link PublicUnionMessageDto}
     * @param id 记录ID|1
     * @return {@link PublicUnionMessageDto}
     */
    PublicUnionMessageDto getDtoById(String id);

}
