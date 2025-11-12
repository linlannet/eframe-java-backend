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
package net.linlan.social.permission.service;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.authn.group.constant.PublicGroupEnum;
import net.linlan.authn.group.entity.PublicGroup;
import net.linlan.commons.core.CollectionUtils;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.service.AdminRoleService;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.social.manage.constant.BindFromEnum;
import net.linlan.social.manage.constant.OpenTypeEnum;
import net.linlan.social.permission.constant.RangePowerEnum;
import net.linlan.social.permission.constant.RangeTypeEnum;
import net.linlan.social.permission.dao.UserRangeOrganDao;
import net.linlan.social.permission.dto.*;
import net.linlan.social.permission.entity.UserRangeOrgan;
import net.linlan.social.permission.param.UserOrganListParam;
import net.linlan.social.permission.param.UserRangeOrganParam;
import net.linlan.social.third.entity.ThirdMember;
import net.linlan.social.third.service.ThirdMemberService;
import net.linlan.sys.base.constant.AppStatusEnum;
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.base.constant.PositionTypeEnum;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.role.dto.PositionSearchCodeDto;
import net.linlan.sys.role.entity.SysMenu;
import net.linlan.sys.role.entity.SysPosition;
import net.linlan.sys.role.service.SysMenuService;
import net.linlan.sys.role.service.SysPositionService;
import net.linlan.sys.web.KernelAdminUtils;

/**
 *
 * UserRangeOrgan数据域:人员应用范围机构关联服务类
 * @author Linlan
 * CreateTime 2020-04-22 10:44:52 *
 */
@Service
@Slf4j
public class UserRangeOrganService {

    @Resource
    private UserRangeOrganDao  dao;
    @Resource
    private SysPositionService sysPositionService;
    @Resource
    private AdminRoleService   adminRoleService;
    @Resource
    private AdminUserService   adminUserService;
    @Resource
    private ThirdMemberService thirdMemberService;

    /** get the list of entity UserRangeOrgan
     * 列表方法，返回UserRangeOrgan对象
     * @param map the input select conditions
     * @return 列表的第三方用户数据 {@link List} 对象，包含 {@link UserRangeOrgan} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<UserRangeOrgan> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link UserRangeOrgan}
     * @param id the UserRangeOrgan 人员机构关系ID | 1
     * @return {@link UserRangeOrgan}
     */
    public UserRangeOrgan findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param userRangeOrgan the input userRangeOrgan
     */
    //@Transactional
    public void save(UserRangeOrgan userRangeOrgan) {
        userRangeOrgan.init();
        dao.save(userRangeOrgan);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param userRangeOrgan the input userRangeOrgan
     */
    //@Transactional
    public void update(UserRangeOrgan userRangeOrgan) {
        dao.update(userRangeOrgan);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the UserRangeOrgan 人员机构关系ID | 1
     */
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    //@Transactional
    public void deleteByIds(Long[] ids) {
        dao.deleteByIds(ids);
    }

    /** query the total count by input select conditions
     * 通过输入的条件查询记录总数
     * @param map the input select conditions
     * @return total count
     */
    public int getCount(Map<String, Object> map) {
        return dao.getCount(map);
    }

    /** get the page of dto UserRangeOrganDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link UserRangeOrganParam }
     * @return 分页对象
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<UserRangeOrganDto> getPageDto(UserRangeOrganParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link UserRangeOrganDto}
     * @param id the UserRangeOrgan 人员机构关系ID | 1
     * @return {@link UserRangeOrganDto}
     */
    public UserRangeOrganDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     * @param positionId 岗位ID
     */
    //@Transactional
    //@CacheEvict(allEntries = true)
    public void deleteByPositionIds(Long[] ids, String positionId) {
        dao.deleteByPositionIds(ids, positionId);
    }

    public List<Map<String, Object>> getUserByGroup(Map<String, Object> map) {
        return dao.getUserByGroup(map);
    }

    public List<Map<String, Object>> getUserRangeOrgan(Map<String, Object> param) {
        return dao.getUserRangeOrgan(param);
    }

    public void bindUserByDept(Map<String, Object> param) {
        dao.bindUserByDept(param);
    }

    public void unBindUserByDept(Map<String, Object> param) {
        dao.unBindUserByDept(param);
    }

    public List<Map<String, Object>> getUserOrganRole(Map<String, Object> param) {
        return dao.getUserOrganRole(param);
    }

    /**
     * 该机构是否已经存在该用户
     * @param userId    用户ID
     * @param organId   机构ID
     * @param type   人员类型
     * @return  是否已存在
     */
    public boolean exist(String userId, String organId, String type) {
        Integer count = dao.exist(userId, organId, type);
        if (count > 0) {
            return true;
        }
        return false;
    }

    public Long[] getMemberIdsByGroupAndOrganId(Map<String, Object> params) {
        return dao.getMemberIdsByGroupAndOrganId(params);
    }

    /**
     * 根据userId删除对象
     * @param userId    用户ID
     */
    public void deleteByUserId(String userId) {
        dao.deleteByUserId(userId);
    }

    /**
     * 根据userIds删除对象
     * @param userIds   用户Ids
     */
    public void deleteByUserIds(String[] userIds) {
        dao.deleteByUserIds(userIds);
    }

    /**
     * 绑定用户与岗位
     * @param map   输入的保存对象
     */
    public void bindUserByPosition(Map<String, Object> map) {
        if (!map.containsKey("posuserId")) {
            map.put("posuserId", RandomUtils.randomLid());
        }
        dao.bindUserByPosition(map);
    }

    /**
     * 解绑用户与岗位
     * @param map   输入的解绑对象
     */
    public void unBindUserByPosition(Map<String, Object> map) {
        dao.unBindUserByPosition(map);
    }

    /**
     * 绑定主岗位和类型
     * @param map   输入对象
     */
    public void bindIsDefOrType(Map<String, Object> map) {
        dao.bindIsDefOrType(map);
    }

    public List<PositionBindUserDto> getListFromSasUserPosition(Map<String, Object> map) {
        return dao.getListFromSasUserPosition(map);
    }

    public int queryPositionUserTotal(Map<String, Object> map) {
        return dao.queryPositionUserTotal(map);
    }

    public boolean existPosition(Long memberId, String positionId) {
        //已经有了，直接返回
        UserRangeOrgan positionUser = dao.getUserPosition(memberId, positionId);
        if (positionUser != null) {
            return true;
        }
        return false;
    }

    /**
     * 添加岗位信息
     * @param memberId  会员ID
     * @param positionId    岗位ID
     */
    public void addPosition(Long memberId, String positionId) {
        //已经有了，直接返回
        UserRangeOrgan positionUser = dao.getUserPosition(memberId, positionId);
        if (positionUser != null) {
            return;
        }
        UserRangeOrgan userRangeOrgan = new UserRangeOrgan();
        userRangeOrgan.setId(RandomUtils.randomLid());
        userRangeOrgan.setIsMember(true);
        userRangeOrgan.setType(30);
        userRangeOrgan.setPositionId(positionId);
        userRangeOrgan.setUserlId(memberId);
        userRangeOrgan.setIsDef(false);
        userRangeOrgan.setDelFlag(0);
        userRangeOrgan.setCreateTime(new Date());
        dao.save(userRangeOrgan);
    }

    public List<Map<String, Object>> getPositionUserList(Map<String, Object> map) {
        return this.dao.getPositionUserList(map);
    }

    /**
     * 根据机构organId和分组groupId查询人员列表
     * @param map   输入对象，organId，groupId
     * @return  人员列表
     */
    public List<Map<String, Object>> getUserByGroupId(Map<String, Object> map) {
        return dao.getUserByGroup(map);
    }

    /**
     * 根据机构organId、岗位positionId查询人员列表的方法
     * @param map   输入对象，organId，positionId
     * @return  人员列表
     */
    public List<Map<String, Object>> getUserByOrganIdAndPositionId(Map<String, Object> map) {
        return dao.getUserByOrganIdAndPositionId(map);
    }

    /**
     * 根据机构、分组、岗位查询人员列表，允许部分null
     * @param map organId，groupId, positionId
     * @return    返回列表
     */
    public List<Map<String, Object>> getUserByGidAndOidAndPidAllowNull(Map<String, Object> map) {
        return dao.getUserByGidAndOidAndPidAllowNull(map);
    }

    /**
     * 根据机构、分组、岗位查询人员列表
     * @param map   输入的查询条件
     * @return  人员列表
     */
    public List<Map<String, Object>> getUserByGidAndOidAndPid(Map<String, Object> map) {
        return dao.getUserByGidAndOidAndPid(map);
    }

    /**
     * 人员机构管理列表
     * @param param   输入的查询条件
     * @return 人员机构管理列表
     */
    public Page<UserOrganManageListDto> getUserOrganManageList(UserOrganListParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getUserOrganManageList(param);
    }

    /**
     * 人员通讯录列表
     * @param param   输入的查询条件
     * @return 人员通讯录列表
     */
    public Page<UserTelListDto> getUserBookList(UserOrganListParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getUserBookList(param);
    }

    public List<UserRangeOrgan> getAlreadyBindUsers(String organId, List<String> userIds) {
        return dao.getAlreadyBindUsers(organId, userIds);
    }

    public int unBindUsers(Long[] ids) {
        return dao.deleteByIds(ids);
    }

    /**
     * 该机构是否已经存在该用户
     * @param userId    用户ID
     * @param organId   机构ID
     * @param type   人员类型
     * @return  是否已经存在该用户
     */
    public boolean existRelation(String userId, String organId, String type) {
        Integer count = dao.existRelation(userId, organId, type);
        if (count > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询机构下全部人数
     * @param organId   机构ID
     * @return  全部人数
     */
    public Integer existRelationTotal(String organId) {
        return dao.existRelationTotal(organId);
    }

    public void logicalDeleteById(Long id) {
        dao.logicalDeleteById(id);
    }

    public List<UserTelListDto> getUserListByOrganId(UserOrganListParam param) {
        return dao.getUserListByOrganId(param);
    }

    /** 获取岗位ID
     * @param groupId   分组ID
     * @param positionName  岗位名称
     * @return  岗位ID
     */
    public String getPositionId(String groupId, String positionName) {
        return dao.getPositionId(groupId, positionName);
    }

    public UserRangeOrgan getUserPosition(Long memberId, String positionId) {
        return dao.getUserPosition(memberId, positionId);
    }

    /**
     * 获取用户已有岗位
     * @param userId    用户ID
     * @return  用户岗位树
     */
    public List<TreeNode> getUserPositionTree(String userId) {
        List<TreeNode> userPositionList = new ArrayList<TreeNode>();
        //如果传userId则获取该用户已有岗位
        if (StringUtils.isNotBlank(userId)) {
            List<PositionSearchCodeDto> positionSearchCodeDtoList = dao
                .getPositionListByUserId(userId);
            if (!CollectionUtils.isEmpty(positionSearchCodeDtoList)) {
                for (PositionSearchCodeDto positionSearchCodeDto : positionSearchCodeDtoList) {
                    StringBuffer stringBuffer = new StringBuffer();
                    TreeNode treeNode = new TreeNode();
                    //判断是否是父岗位
                    if (StringUtils.isEmpty(positionSearchCodeDto.getParentId())) {
                        //拼接该岗位的searchCode
                        stringBuffer.append(PositionTypeEnum.FGW.getKey());
                        stringBuffer.append(";");
                        stringBuffer.append(positionSearchCodeDto.getPositionId());
                        treeNode.setId(stringBuffer.toString());
                        substrPositionId(positionSearchCodeDto.getRoleId().toString(), stringBuffer,
                            PositionTypeEnum.JS.getKey());
                        substrPositionId(positionSearchCodeDto.getRoletypeId(), stringBuffer,
                            PositionTypeEnum.JSLX.getKey());
                        treeNode.setSearchCode(stringBuffer.toString());
                    } else {//如果是子岗位
                            //获得树ID，叶子节点ID
                        stringBuffer.append(PositionTypeEnum.ZGW.getKey());
                        stringBuffer.append(";");
                        stringBuffer.append(positionSearchCodeDto.getPositionId());
                        treeNode.setId(stringBuffer.toString());
                        SysPosition childPosition = sysPositionService
                            .findById(positionSearchCodeDto.getParentId());
                        if (StringUtils.isNotBlank(childPosition.getId())) {
                            //判断是否还有父节点，若有则进循环继续找上一级
                            while (StringUtils.isNotBlank(childPosition.getParentId())) {
                                SysPosition grandChildPosition = sysPositionService
                                    .findById(childPosition.getParentId());
                                if (StringUtils.isBlank(grandChildPosition.getId())) {
                                    break;
                                }
                                stringBuffer.append(",");
                                stringBuffer.append(PositionTypeEnum.ZGW.getKey());
                                stringBuffer.append(";");
                                stringBuffer.append(grandChildPosition.getId());
                            }
                            //获取该岗位的searchCode相关信息
                            PositionSearchCodeDto childDto = sysPositionService
                                .findSearchCodeByPositionId(childPosition.getId());
                            //拼接该岗位的searchCode
                            substrPositionId(childDto.getPositionId(), stringBuffer,
                                PositionTypeEnum.FGW.getKey());
                            substrPositionId(childDto.getRoleId(), stringBuffer,
                                PositionTypeEnum.JS.getKey());
                            substrPositionId(childDto.getRoletypeId(), stringBuffer,
                                PositionTypeEnum.JSLX.getKey());
                            treeNode.setSearchCode(stringBuffer.toString());
                        }
                    }
                    treeNode.setLabel(positionSearchCodeDto.getName());
                    //设置选中
                    treeNode.setChecked(true);
                    userPositionList.add(treeNode);
                }
            }
        }
        return userPositionList;
    }

    public List<TreeNode> substrId(List<TreeNode> organs, List<TreeNode> node,
                                   String positionType) {
        for (TreeNode treeNode : organs) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(positionType);
            stringBuffer.append(";");
            stringBuffer.append(treeNode.getId());
            treeNode.setId(stringBuffer.toString());
            node.add(treeNode);
        }
        return node;
    }

    public void substrPositionId(Object origin, StringBuffer stringBuffer, String positionType) {
        if (ObjectUtils.isNotEmpty(origin)) {
            stringBuffer.append(",");
            stringBuffer.append(positionType);
            stringBuffer.append(";");
            stringBuffer.append(origin);
        }
    }

    /**
     * 根据机构ID和ROLETYPE_ID查询机构人员(区分移动端和管理端)
     * @param organId   机构ID
     * @param roletypeId    角色分组ID
     * @return  人员通讯录
     */
    public List<UserTelListDto> getUserByOrganIdAndRoletypeId(String organId, String roletypeId) {
        return dao.getUserByOrganIdAndRoletypeId(organId, roletypeId);
    }

    public List<PublicGroup> getPublicGroupList(Map<String, Object> map) {
        KernelAdminUtils.dealIsDisabledParam(map);
        return dao.getPublicGroupList(map);
    }

    /**
     * 根据memberId获取会员组
     * @param map   查询条件
     * @return  列表对象
     */
    public List<PublicGroup> getGroupByMember(Map<String, Object> map) {
        KernelAdminUtils.dealIsDisabledParam(map);
        return dao.getGroupByMember(map);
    }

    /**
     *根据会员ID、应用ID、角色类型ID，查询会员组
     * @param map   查询条件
     * @return  公共分组列表
     */
    public List<PublicGroup> getGroupByMemberPosition(Map<String, Object> map) {
        return dao.getGroupByMemberPosition(map);
    }

    /**
     * 根据会员信息获取相对应菜单
     * @param map   查询条件
     * @return  菜单列表
     */
    public List<SysMenu> getMenuByMemberUser(Map<String, Object> map) {
        List<SysMenu> sysMenuList = dao.getMenuByMemberUser(map);
        LinkedList<SysMenu> result = new LinkedList<>();
        // parentId为null的根节点
        for (int i = 0; i < sysMenuList.size(); i++) {
            if (sysMenuList.get(i).getParentId() == null || sysMenuList.get(i).getParentId() == 0) {
                result.add(sysMenuList.get(i));
            }
        }
        if (result != null && result.size() > 0) {
            SysMenuService.sortToTree(result, sysMenuList);
        }
        return result;
    }

    /**
     * 根据会员信息获取相对应菜单  多个会员获取去重的菜单
     * @param map   查询条件
     * @return  菜单列表
     */
    public List<SysMenu> getMergeMenuByMemberUser(Map<String, Object> map) {
        List<SysMenu> sysMenuList = dao.getMergeMenuByMemberUser(map);
        LinkedList<SysMenu> result = new LinkedList<>();
        // parentId为null的根节点
        for (int i = 0; i < sysMenuList.size(); i++) {
            if (sysMenuList.get(i).getParentId() == null || sysMenuList.get(i).getParentId() == 0) {
                result.add(sysMenuList.get(i));
            }
        }
        if (result != null && result.size() > 0) {
            SysMenuService.sortToTree(result, sysMenuList);
        }
        return result;
    }

    /**
     * 是否有某个组的权限
     * @param userId   用户ID
     * @param groupId   组ID
     * @return  用户有权限的组
     */
    public PublicGroup hasGroup(String userId, String groupId) {
        PublicGroup result = dao.hasGroup(userId, groupId);
        return result;
    }

    /**
     * 通过组名模糊查询是否有某个组的权限
     * @param name  组名称
     * @param userId    用户ID
     * @return      是否有权限的组
     */
    public Boolean hasGroupByName(String name, String userId) {
        Boolean flag = false;
        PublicGroup result = dao.hasGroupByName(name, userId);
        if (!org.springframework.util.ObjectUtils.isEmpty(result)) {
            flag = true;
        }
        return flag;
    }

    public int saveMemberById(Map<String, Object> params) {
        return dao.saveMemberById(params);
    }

    public int deleteMemberById(Map<String, Object> params) {
        return dao.deleteMemberById(params);
    }

    public int deleteGroupById(Long[] ids) {
        return dao.deleteGroupById(ids);
    }

    public UserRangeOrgan getUserByIdAndGroupId(Long memberId, Long groupId, int power) {
        return dao.getUserByIdAndGroupId(memberId, groupId, power);
    }

    public UserRangeOrgan saveOrUpdateFromSocial(FrameUserDetails loginUser, BindFromEnum from) {
        // 处理用户默认组
        String bindFrom = from.getKey();
        PublicGroupEnum publicGroupEnum = PublicGroupEnum.fromCode(bindFrom);
        if (ObjectUtils.isEmpty(publicGroupEnum)) {
            publicGroupEnum = PublicGroupEnum.WWW_GROUP;
        }
        UserRangeOrgan entity = getUserByIdAndGroupId(loginUser.getUserLid(),
            publicGroupEnum.getGroupId(), RangePowerEnum.FUWU.getKey());
        Boolean ifUpdate = true;
        if (entity == null) {
            ifUpdate = false;
            entity = new UserRangeOrgan();
            entity.setType(RangeTypeEnum.SHUYU.getKey());
            entity.setPower(RangePowerEnum.FUWU.getKey());
            entity.setIsMember(true);
            entity.setIsDef(true);
        }
        entity.setUserId(loginUser.getUserId());
        entity.setUserlId(loginUser.getUserLid());
        entity.setGroupId(publicGroupEnum.getGroupId());
        entity.setOrganId(loginUser.getOrganId());
        entity.setDeptId(loginUser.getDeptId());
        entity.setDelFlag(DelFlagEnum.NORMAL.getKey());
        entity.setStatus(AppStatusEnum.NORMAL.getKey());
        if (ifUpdate) {
            update(entity);
        } else {
            save(entity);
        }
        return entity;
    }

    public void removeOrUpdateFromSocial(FrameUserDetails loginUser,
                                         PublicGroupEnum publicGroupEnum) {
        UserRangeOrgan entity = getUserByIdAndGroupId(loginUser.getUserLid(),
            publicGroupEnum.getGroupId(), RangePowerEnum.FUWU.getKey());
        if (entity != null) {
            entity.setStatus(AppStatusEnum.DISABLE.getKey());
            entity.setDelFlag(DelFlagEnum.DELETED.getKey());
            update(entity);
        }
    }

    public List<Long> getRoleIdsByMemberId(Map<String, Object> map) {
        return dao.getRoleIdsByMemberId(map);
    }

    public boolean saveOrUpdateFromAdmin(FrameUserDetails loginUser, BindFromEnum from) {
        //管理人员，查询当前人员的角色和岗位，管理人员必须已经配置正常的角色、岗位
        //优先判断是否有角色，如果已配置角色，则返回正常，如果未配置角色，再查询是否配置岗位
        List<Long> roleIds = adminRoleService.selectRoleListByAdminId(loginUser.getUserLid());
        if (ObjectUtils.isEmpty(roleIds)) {
            return true;
        }
        List<String> positionIds = adminUserService.selectPostListByAdminId(loginUser.getUserLid());
        if (ObjectUtils.isEmpty(positionIds)) {
            return true;
        }
        return false;
    }

    public UserRangeOrgan saveOrUpdateFromMpMini(String openType, String openId) {
        // 处理用户默认组
        PublicGroupEnum publicGroupEnum = null;
        if (openType.equals(OpenTypeEnum.WECHAT_MP.getKey())) {
            publicGroupEnum = PublicGroupEnum.WWW_GROUP;
        } else {
            publicGroupEnum = PublicGroupEnum.H5_GROUP;
        }
        ThirdMember thirdMember = thirdMemberService.getThirdUserByOpenId(openId, openType);
        if (thirdMember == null) {
            return null;
        }
        UserRangeOrgan entity = getUserByIdAndGroupId(thirdMember.getId(),
            publicGroupEnum.getGroupId(), RangePowerEnum.FUWU.getKey());
        Boolean ifUpdate = true;
        if (entity == null) {
            ifUpdate = false;
            entity = new UserRangeOrgan();
            entity.setType(RangeTypeEnum.SHUYU.getKey());
            entity.setPower(RangePowerEnum.FUWU.getKey());
            entity.setIsMember(true);
            entity.setIsDef(true);
        }
        entity.setUserId(thirdMember.getUserId());
        entity.setUserlId(thirdMember.getId());
        entity.setGroupId(publicGroupEnum.getGroupId());
        entity.setOrganId(thirdMember.getOrganId());
        entity.setDelFlag(DelFlagEnum.NORMAL.getKey());
        entity.setStatus(AppStatusEnum.NORMAL.getKey());
        if (ifUpdate) {
            update(entity);
        } else {
            save(entity);
        }
        return entity;
    }
}
