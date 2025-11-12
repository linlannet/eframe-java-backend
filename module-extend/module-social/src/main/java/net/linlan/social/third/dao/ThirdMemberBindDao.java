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
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.social.third.dto.ThirdMemberBindDto;
import net.linlan.social.third.entity.ThirdMemberBind;
import net.linlan.social.third.param.ThirdMemberBindParam;

/**
*
* ThirdMemberBind数据域:用户身份提供商绑定持久层Dao
* 
* @author Linlan
* CreateTime 2025-10-13 16:35:28
* @version 1.0
* @since 1.0
*
*/
@Mapper
public interface ThirdMemberBindDao extends MybatisBaseDao<ThirdMemberBind> {

    /** get the page of dto ThirdMemberBindDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param 查询参数
     * @return 分页的用户身份提供商绑定数据 {@link Page} 对象，包含 {@link ThirdMemberBind} 列表
     */
    Page<ThirdMemberBindDto> getPageDto(ThirdMemberBindParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link ThirdMemberBindDto}
     * @param id 主键ID|1
     * @return {@link ThirdMemberBindDto}
     */
    ThirdMemberBindDto getDtoById(String id);

    ThirdMemberBind findByUserIdAccountKey(@Param("userId") String userId,
                                           @Param("accountKey") String accountKey);

    ThirdMemberBind findByUserIdAccountId(@Param("userId") String userId,
                                          @Param("accountId") String accountId);

    ThirdMemberBind findByUserIdOpenType(@Param("userId") String userId,
                                         @Param("openType") String openType);
}
