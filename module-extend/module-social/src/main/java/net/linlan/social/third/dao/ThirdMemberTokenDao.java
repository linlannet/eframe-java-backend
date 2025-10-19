/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.third.dao;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.social.third.dto.ThirdMemberTokenDto;
import net.linlan.social.third.entity.ThirdMemberToken;
import net.linlan.social.third.param.ThirdMemberTokenParam;

/**
*
* ThirdMemberToken数据域:会员用户令牌持久层Dao
* 
* @author Linlan
* CreateTime 2025-10-13 16:35:28
* @version 1.0
* @since 1.0
*
*/
@Mapper
public interface ThirdMemberTokenDao extends MybatisBaseDao<ThirdMemberToken> {

    /** get the page of dto ThirdMemberTokenDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param 查询参数
     * @return 分页的会员用户令牌数据 {@link Page} 对象，包含 {@link ThirdMemberToken} 列表
     */
    Page<ThirdMemberTokenDto> getPageDto(ThirdMemberTokenParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link ThirdMemberTokenDto}
     * @param id 主键ID|1
     * @return {@link ThirdMemberTokenDto}
     */
    ThirdMemberTokenDto getDtoById(Long id);

}
