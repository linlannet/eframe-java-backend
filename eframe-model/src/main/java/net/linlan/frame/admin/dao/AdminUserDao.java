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
package net.linlan.frame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.param.AdminUserParam;

/**
*
* AdminUser数据域:管理用户持久层Dao
* @author Linlan
* CreateTime 2024-10-02 23:27:08
*
*/
@Mapper
public interface AdminUserDao extends MybatisBaseDao<AdminUser> {

    /** get the page of dto AdminUserDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link AdminUserParam }
     * @return 分页的管理员数据 {@link Page} 对象，包含 {@link AdminUser} 列表
     */
    Page<AdminUserDto> getPageDto(AdminUserParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link AdminUserDto}
     * @param id 企业管理用户ID|1
     * @return {@link AdminUserDto}
     */
    AdminUserDto getDtoById(Long id);

    /**
     * 根据条件分页查询已配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<AdminUserDto> selectAllocatedList(AdminUserParam user);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<AdminUserDto> selectUnallocatedList(AdminUserParam user);

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 用户对象信息
     */
    public AdminUserDto selectUserByUsername(String username);

    /**
     * 通过用户LID查询用户
     *
     * @param adminId 用户LID
     * @return 用户对象信息
     */
    public AdminUserDto selectAdminById(Long adminId);

    /**
     * 通过用户手机查询用户
     *
     * @param mobile 手机号
     * @return 用户对象信息
     */
    AdminUserDto selectUserByMobile(String mobile);

    /**
     * 修改用户状态
     *
     * @param adminId 用户LID
     * @param status 状态
     * @return 结果
     */
    public int updateUserStatus(@Param("adminId") Long adminId, @Param("status") Integer status);

    /**
     * 修改用户头像
     *
     * @param username 用户名
     * @param imagePath 头像地址
     * @return 结果
     */
    public int updateUserImagePath(@Param("username") String username,
                                   @Param("imagePath") String imagePath);

    /**
     * 重置用户密码
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    public int resetUserPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 通过用户LID删除用户
     *
     * @param adminId 用户LID
     * @return 结果
     */
    public int deleteAdminById(Long adminId);

    /**
     * 批量删除用户信息
     *
     * @param adminIds 需要删除的用户LID
     * @return 结果
     */
    public int deleteUserByIds(Long[] adminIds);

    /**
     * 校验用户名称是否唯一
     *
     * @param username 用户名称
     * @return 结果
     */
    public AdminUser checkUsernameUnique(String username);

    /**
     * 校验手机号码是否唯一
     *
     * @param mobile 手机号码
     * @return 结果
     */
    public AdminUser checkMobileUnique(String mobile);

    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
    public AdminUser checkEmailUnique(String email);

}
