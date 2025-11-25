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

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.social.third.dto.ThirdMemberDto;
import net.linlan.social.third.dto.ThirdUserDto;
import net.linlan.social.third.entity.ThirdMember;
import net.linlan.social.third.param.ThirdMemberParam;

/**
*
* ThirdMember数据域:第三方用户持久层Dao
* 
* @author Linlan
* CreateTime 2025-10-13 16:35:28
* @version 1.0
* @since 1.0
*
*/
@Mapper
public interface ThirdMemberDao extends MybatisBaseDao<ThirdMember> {

    /** get the page of dto ThirdMemberDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param 查询参数
     * @return 分页的第三方用户数据 {@link Page} 对象，包含 {@link ThirdMember} 列表
     */
    Page<ThirdMemberDto> getPageDto(ThirdMemberParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link ThirdMemberDto}
     * @param id 主键ID|1
     * @return {@link ThirdMemberDto}
     */
    ThirdMemberDto getDtoById(Long id);

    List<ThirdMemberDto> getByParams(Map<String, Object> map);

    ThirdMember findByUserId(String userId);

    ThirdMember findByOpenId(@Param("openId") String openId, @Param("source") String source);

    ThirdMember findByUnionId(@Param("unionId") String unionId);

    ThirdMember findByUserIdAccountId(@Param("userId") String userId,
                                      @Param("accountId") String accountId);

    ThirdUserDto getThirdUserById(Long id);

    ThirdUserDto getThirdUserByUserId(String userId);

    ThirdUserDto getThirdUserByOpenId(@Param("openId") String openId,
                                      @Param("source") String source);

    ThirdUserDto getThirdUserByUnionId(@Param("unionId") String unionId);

    Long getMemberId(String userId);

    List<ThirdMember> getByMobile(@Param("mobile") String mobile, @Param("source") String source);

    List<ThirdMember> getByUsername(@Param("username") String username,
                                    @Param("source") String source);

    List<ThirdMember> getByEmail(@Param("email") String email, @Param("source") String source);

    List<ThirdMember> getByUserkey(@Param("userkey") String userkey,
                                   @Param("source") String source);

}
