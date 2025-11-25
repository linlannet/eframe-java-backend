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
package net.linlan.social.permission.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.authn.group.dto.PublicGroupListDto;
import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.admin.dto.AdminMenuVo;
import net.linlan.frame.admin.param.AdminMenuVoParam;
import net.linlan.social.permission.dto.OrganGroupBindDto;
import net.linlan.social.permission.dto.PermissionCommDto;
import net.linlan.social.permission.dto.PublicGroupUserDto;
import net.linlan.social.permission.dto.UserPositionBindDto;
import net.linlan.social.permission.param.*;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.role.dto.SysMenuButtonDto;
import net.linlan.sys.role.entity.SysRole;

/**
 *
 * Filename:UserRangeOrgan.java
 * Desc:
 *
 * @author Linlan
 * CreateTime:2020-04-22 10:44:52
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Mapper
public interface PublicPermissionDao extends MybatisBaseDao<PermissionCommDto> {

    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    List<AdminMenuVo> selectMenuList(AdminMenuVoParam menu);

    /**
     * 查询系统菜单分页
     * @param menu 菜单信息
     * @return 菜单列表
     */
    Page<AdminMenuVo> selectMenuListPage(AdminMenuVoParam menu);

    /**
     * 根据用户所有权限
     *
     * @param currAppId 当前应用ID
     * @return 权限列表
     */
    List<String> selectMenuPerms(@Param("currAppId") String currAppId);

    /**
     * 根据用户查询系统菜单列表
     *
     * @param memberId 管理员ID
     * @param currAppId 当前应用ID
     * @return 菜单列表
     */
    List<AdminMenuVo> selectMenuListByMemberId(@Param("memberId") Long memberId,
                                               @Param("currAppId") String currAppId);

    /**
     * 根据角色ID查询权限
     *
     * @param roleId 角色ID
     * @param currAppId 当前应用ID
     * @return 权限列表
     */
    List<String> selectMenuPermsByRoleId(@Param("roleId") Long roleId,
                                         @Param("currAppId") String currAppId);

    /**
     * 根据用户LID查询权限
     *
     * @param memberId 用户LID
     * @param currAppId 当前应用ID
     * @return 权限列表
     */
    List<String> selectMenuPermsByMemberId(@Param("memberId") Long memberId,
                                           @Param("currAppId") String currAppId);

    /**
     * 根据用户LID查询菜单
     *
     * @return 菜单列表
     */
    List<AdminMenuVo> selectMenuTreeAll();

    /**
     * 根据用户LID查询菜单
     *
     * @param memberId 用户LID
     * @param currAppId 当前应用ID
     * @return 菜单列表
     */
    List<AdminMenuVo> selectMenuTreeByMemberId(@Param("memberId") Long memberId,
                                               @Param("currAppId") String currAppId);

    /**
     * 根据父节点删除子节点
     *
     * @param parentId 用户LID
     */
    void deleteByParentId(Long parentId);

    /**
     * 根据父节点查询子节点
     *
     * @param parentId 用户LID
     * @return 菜单列表
     */
    int hasChildByParentId(Long parentId);

    /**
     * 某个菜单下有权限的按钮
     * @param menuId    菜单ID
     * @return  菜单列表
     */
    List<SysMenuButtonDto> getButtons(@Param("menuId") Long menuId);

    /**
     * 根据角色ID查询菜单树信息
     *
     * @param roleId 角色ID
     * @param menuCheckStrictly 菜单树选择项是否关联显示
     * @param currAppId 当前应用ID
     * @return 选中菜单列表
     */
    List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId,
                                      @Param("menuCheckStrictly") boolean menuCheckStrictly,
                                      @Param("currAppId") String currAppId);

    /**
     * 根据用户LID查询角色
     *
     * @param memberId 用户LID
     * @return 角色列表
     */
    public List<String> selectRoleCodeByMemberId(Long memberId);

    /**
     * 根据用户LID获取角色选择框列表
     *
     * @param memberId 用户LID
     * @return 选中角色ID列表
     */
    public List<Long> selectRoleListByMemberId(Long memberId);

    /**
     * 根据用户LID查询角色
     *
     * @param username 用户名
     * @return 角色列表
     */
    public List<SysRole> selectRolesByUsername(String username);

    /**
     * 通用获取未绑定的会员人员列表
     * @param param 查询条件
     * @return    返回列表
     */
    Page<PermissionCommDto> getUnBindMemberUserList(PermissionCommParam param);

    /**
     * 获取机构下绑定的人员列表
     * @param param 查询条件
     * @return    返回列表
     */
    Page<PermissionCommDto> getUsersByBindOrganList(PermissionCommParam param);

    /**
     * 获取岗位下绑定的人员列表
     * @param param 查询条件
     * @return    返回列表
     */
    Page<PermissionCommDto> getUsersByBindPositionList(PermissionCommParam param);

    /**
     * 获取机构、分组、岗位 下绑定的人员列表
     * @param param 查询条件
     * @return    返回列表
     */
    Page<PermissionCommDto> getUsersByBindList(PermissionCommParam param);

    /**
     * 绑定机构下的人员
     * @param permissionCommDto 查询参数
     */
    void bindUsersForOrgan(PermissionCommDto permissionCommDto);

    /**
     * 绑定岗位下的人员
     * @param permissionCommDto    查询参数
     */
    void bindUsersForPosition(PermissionCommDto permissionCommDto);

    Page<OrganGroupBindDto> getOrganGroupBindList(OrganGroupBindParam param);

    Page<OrganGroupBindDto> getOrganGroupUnbindList(OrganGroupBindParam param);

    Page<PublicGroupListDto> getMemberGroupList(PublicGroupSimpleParam param);

    /**
     * 批量绑定
     * @param list  绑定对象列表
     */
    void batchBindUsers(@Param("list") List<PermissionCommDto> list);

    /**
     * 获取用户已有权限
     * @param permissionCommDto    查询参数
     * @return  通用权限对象
     */
    PermissionCommDto findByUserId(PermissionCommDto permissionCommDto);

    void memberGroupBindUser(List<PublicGroupUserDto> list);

    void memberGroupUnBindUser(@Param("groupId") String id, @Param("ids") Long[] ids);

    Page<UserPositionBindDto> getUserPositionBindList(UserPositionBindParam param);

    Page<UserPositionBindDto> getUserPositionUnBindList(UserPositionBindParam param);

    int logicalDeleteByPeopleIds(@Param("ids") String[] ids);

    /** 通过机构ID查询用户手机列表
     * @param organId   机构ID
     * @return    返回列表
     */
    List<String> getMobileByOrganId(@Param("organId") String organId);

    /**
     * 获取公共账户
     * @param param 查询条件
     * @return    返回列表
     */
    List<BaseUser> getPublicAccount(PositionAccountParam param);

    /**
     * 是否有某个角色组的权限
     * @param userId    用户ID
     * @param groupId   分组ID
     * @return  是否有某个角色组的权限
     */
    Integer hasRoleByUser(@Param("userId") String userId, @Param("groupId") Long groupId);

    /**
     * 是否有某个角色组的权限
     * @param memberId  会员ID
     * @param groupId   分组ID
     * @return  是否有某个角色组的权限
     */
    Integer hasRole(@Param("memberId") Long memberId, @Param("groupId") Long groupId);

    /**
     * 是否有某个角色组的权限
     * @param mobile    手机号码
     * @param groupId   分组ID
     * @return  是否有某个角色组的权限
     */
    Integer hasRoleByMobile(@Param("mobile") String mobile, @Param("groupId") Long groupId);

    /**
     * 是否有某个角色并且在某个机构
     * @param mobile    手机号码
     * @param groupId   分组ID
     * @param organId   机构ID
     * @return  是否有某个角色并且在某个机构
     */
    Integer hasRoleOrgan(@Param("mobile") String mobile, @Param("groupId") Long groupId,
                         @Param("organId") String organId);
}
