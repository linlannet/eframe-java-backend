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
package net.linlan.sys.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.BaseUserDto;
import net.linlan.sys.base.dto.BaseUserSelect;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.base.param.BaseUserParam;

/**
*
* BaseUser数据域:基础用户持久层Dao
*
* @author Linlan
 * CreateTime 2018-03-02 17:17:54
* @version 1.0
* @since 1.0
*
*/
@Mapper
public interface BaseUserDao extends MybatisBaseDao<BaseUser> {

    /** get the page of dto BaseUserDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseUserParam }
     * @return 分页的基础机构数据 {@link Page} 对象，包含 {@link BaseUserDto} 列表
     */
    Page<BaseUserDto> getPageDto(BaseUserParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseUserDto}
     * @param id 用户ID|1
     * @return {@link BaseUserDto}
     */
    BaseUserDto getDtoById(String id);

    /** 修改用户登录密码
     * @param map   查询条件
     * @return  更新状态
     */
    int updatePassword(Map<String, Object> map);

    /** 通过用户名查询用户对象
     * @param username  用户名
     * @return  用户对象
     */
    BaseUser getByUsername(String username);

    /** 通过手机号查询用户对象
     * @param mobile    手机
     * @return  用户对象
     */
    BaseUser getByMobile(String mobile);

    /** 通过邮箱地址查询用户对象
     * @param email 邮箱
     * @return  用户对象
     */
    BaseUser getByEmail(String email);

    /** 通过用户名查询用户对象，通过手机号查询用户对象，通过邮箱查询用户对象
     * @param userkey   用户关键键
     * @return  用户列表
     */
    List<BaseUser> getByUserkey(String userkey);

    /** 通过SEARCH_CODE查询提供给SELECT组件渲染使用的选择框列表
     * @param map   查询参数
     * @return  用户下拉列表
     */
    List<BaseUserSelect> getListByCode(Map<String, Object> map);

    /** 通过重要字段多个联合查询获取列表对象
     * @param map   查询参数
     * @return  用户列表
     */
    List<BaseUser> getByParams(Map<String, Object> map);

    /** 当前条件是否存在用户
     * @param map   查询参数
     * @return  用户列表
     */
    List<BaseUser> getIfExists(Map<String, Object> map);

    /** 通过身份证件号码查询用户对象
     * @param map   查询参数
     * @return  用户列表
     */
    List<BaseUser> getByIdNum(Map<String, Object> map);

    /**
     * 批量更新用户密码
     * @param userIds   用户ID列表
     * @param password  用户密码
     * @param salt  密码盐
     * @return  更新状态
     */
    int batUpdatePassword(@Param("userIds") String[] userIds, @Param("password") String password,
                          @Param("salt") String salt);

    BaseUser getByOpenId(String openId);

    BaseUser getByUnionId(String unionId);
}
