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
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.authn.group.entity.PublicGroup;
import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.social.permission.dto.*;
import net.linlan.social.permission.dto.PositionBindUserDto;
import net.linlan.social.permission.dto.UserOrganManageListDto;
import net.linlan.social.permission.dto.UserRangeOrganDto;
import net.linlan.social.permission.dto.UserTelListDto;
import net.linlan.social.permission.entity.UserRangeOrgan;
import net.linlan.social.permission.param.UserOrganListParam;
import net.linlan.social.permission.param.UserRangeOrganParam;
import net.linlan.sys.role.dto.PositionSearchCodeDto;
import net.linlan.sys.role.entity.SysMenu;
import net.linlan.sys.role.entity.SysPosition;

/**
*
* UserRangeOrgan数据域:人员应用范围机构关联持久层Dao
* @author Linlan
* CreateTime 2023-08-29 13:55:02
*
* @version 1.0
* @since 1.0
*
*/
@Mapper
public interface UserRangeOrganDao extends MybatisBaseDao<UserRangeOrgan> {

    /** get the page of dto UserRangeOrganDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link UserRangeOrganParam }
     * @return 分页DTO对象列表
     */
    Page<UserRangeOrganDto> getPageDto(UserRangeOrganParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link UserRangeOrganDto}
     * @param id the UserRangeOrgan 人员机构关系ID | 1
     * @return {@link UserRangeOrganDto}
     */
    UserRangeOrganDto getDtoById(Long id);

    List<Map<String, Object>> getUserRangeOrgan(Map<String, Object> param);

    void bindUserByDept(Map<String, Object> param);

    void unBindUserByDept(Map<String, Object> param);

    List<Map<String, Object>> getUserOrganRole(Map<String, Object> param);

    Long[] getMemberIdsByGroupAndOrganId(Map<String, Object> params);

    Integer exist(@Param("userId") String userId, @Param("organId") String organId,
                  @Param("type") String type);

    /**
     * 根据userId删除对象
     * @param userId    用户ID
     */
    void deleteByUserId(String userId);

    /**
     * 根据userIds删除对象
     * @param userId    用户ID
     */
    void deleteByUserIds(String[] userId);

    /**
     * 绑定用户与岗位
     * @param map   输入对象
     */
    void bindUserByPosition(Map<String, Object> map);

    /**
     * 解绑用户与岗位
     * @param map   输入对象
     */
    void unBindUserByPosition(Map<String, Object> map);

    /**
     * 解绑用户与岗位
     * @param map   输入对象
     */
    void bindIsDefOrType(Map<String, Object> map);

    List<PositionBindUserDto> getListFromSasUserPosition(Map<String, Object> map);

    int queryPositionUserTotal(Map<String, Object> map);

    /**
     * 某个人是否有某个岗位信息
     * @param memberId  会员ID
     * @param positionId    岗位ID
     * @return  当前会员的对象
     */
    UserRangeOrgan getUserPosition(@Param("memberId") Long memberId,
                                   @Param("positionId") String positionId);

    /**
     * 根据groupId和岗位名称获取岗位id
     * @param groupId   分组ID
     * @param positionName  岗位名称
     * @return  岗位ID
     */
    String getPositionId(@Param("groupId") String groupId,
                         @Param("positionName") String positionName);

    List<Map<String, Object>> getPositionUserList(Map<String, Object> map);

    /**
     * 根据机构organId和分组groupId查询人员列表
     * @param map organId，groupId
     * @return    返回列表
     */
    List<Map<String, Object>> getUserByGroup(Map<String, Object> map);

    /**
     * 根据机构organId、岗位positionId查询人员列表的方法
     * @param map organId，positionId
     * @return    返回列表
     */
    List<Map<String, Object>> getUserByOrganIdAndPositionId(Map<String, Object> map);

    /**
     * 根据机构、分组、岗位查询人员列表，允许部分null
     * @param map organId，groupId, positionId
     * @return    返回列表
     */
    List<Map<String, Object>> getUserByGidAndOidAndPidAllowNull(Map<String, Object> map);

    /**
     * 根据机构、分组、岗位查询人员列表
     * @param map organId，groupId, positionId
     * @return    返回列表
     */
    List<Map<String, Object>> getUserByGidAndOidAndPid(Map<String, Object> map);

    /**
     * 人员机构管理列表
     * @param param 查询条件
     * @return UserOrganManageListDto
     */
    Page<UserOrganManageListDto> getUserOrganManageList(UserOrganListParam param);

    /**
     * 人员通讯录列表
     * @param param 查询条件
     * @return UserTelListDto
     */
    Page<UserTelListDto> getUserBookList(UserOrganListParam param);

    /**
     * 批量添加
     * @param list  输入保存对象
     */
    void batchSave(List<UserRangeOrgan> list);

    void deleteByPositionIds(@Param("ids") Long[] ids, @Param("positionId") String positionId);

    /**
     * 已经绑定的用户，TYPE=10  机构绑定用户
     * @param organId 机构ID
     * @param userIds 用户Ids
     * @return    返回列表
     */
    List<UserRangeOrgan> getAlreadyBindUsers(@Param("organId") String organId,
                                             @Param("userIds") List<String> userIds);

    Integer existRelation(@Param("userId") String userId, @Param("organId") String organId,
                          @Param("type") String type);

    /**
     * 查询机构下全部人数
     * @param organId   机构ID
     * @return  人员数量
     */
    Integer existRelationTotal(@Param("organId") String organId);

    void logicalDeleteById(Long id);

    /**
     * 通过机构ID人员列表
     * @param param 查询条件
     * @return UserTelListDto
     */
    List<UserTelListDto> getUserListByOrganId(UserOrganListParam param);

    List<SysPosition> getListByUserId(@Param("userId") String userId);

    List<PositionSearchCodeDto> getPositionListByUserId(@Param("userId") String userId);

    /**
     * 根据机构ID和ROLETYPE_ID查询机构人员(区分移动端和管理端)
     * @param organId   机构ID
     * @param roletypeId    角色类型ID
     * @return    返回列表
     */
    List<UserTelListDto> getUserByOrganIdAndRoletypeId(@Param("organId") String organId,
                                                       @Param("roletypeId") String roletypeId);

    /**
     * 根据memberId获取会员组
     * @param map   查询条件
     * @return  列表对象
     */
    List<PublicGroup> getGroupByMember(Map<String, Object> map);

    List<PublicGroup> getPublicGroupList(Map<String, Object> map);

    /**
     *根据会员ID、应用ID、角色类型ID，查询会员组
     * @param map   查询条件
     * @return    返回列表
     */
    List<PublicGroup> getGroupByMemberPosition(Map<String, Object> map);

    List<SysMenu> getMenuByMemberUser(Map<String, Object> map);

    /**
     * 多个会员获取去重的菜单
     * @param map   查询条件
     * @return  列表对象
     */
    List<SysMenu> getMergeMenuByMemberUser(Map<String, Object> map);

    /**
     * 是否有某个组的权限
     * @param userId    用户ID
     * @param groupId   组ID
     * @return  用户有权限的组
     */
    PublicGroup hasGroup(@Param("userId") String userId, @Param("groupId") String groupId);

    /**
     * 通过组名模糊查询是否有某个组的权限
     * @param name  组名称
     * @param userId    用户ID
     * @return      是否有权限的组
     */
    PublicGroup hasGroupByName(@Param("name") String name, @Param("userId") String userId);

    int saveMemberById(Map<String, Object> params);

    int deleteMemberById(Map<String, Object> params);

    int deleteGroupById(Long[] ids);

    UserRangeOrgan getUserByIdAndGroupId(@Param("memberId") Long memberId,
                                         @Param("groupId") Long groupId, @Param("power") int power);

    /**
     * 根据memberId获取角色Ids
     * @param map   查询条件
     * @return  列表对象
     */
    List<Long> getRoleIdsByMemberId(Map<String, Object> map);

}
