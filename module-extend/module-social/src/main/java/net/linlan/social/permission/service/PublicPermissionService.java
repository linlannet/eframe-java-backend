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

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import jakarta.annotation.Resource;
import net.linlan.authn.group.dto.PublicGroupListDto;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.admin.dto.AdminMenuVo;
import net.linlan.frame.admin.param.AdminMenuVoParam;
import net.linlan.frame.admin.service.CurrAppService;
import net.linlan.social.permission.dao.PublicPermissionDao;
import net.linlan.social.permission.dto.OrganGroupBindDto;
import net.linlan.social.permission.dto.PermissionCommDto;
import net.linlan.social.permission.dto.PublicGroupUserDto;
import net.linlan.social.permission.dto.UserPositionBindDto;
import net.linlan.social.permission.param.*;
import net.linlan.social.third.entity.ThirdMember;
import net.linlan.social.third.service.ThirdMemberService;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.role.dto.SysMenuButtonDto;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.sys.role.service.SysRoleService;

/**
 * Web管理平台权限处理
 * @author Linlan
 */
@Service
public class PublicPermissionService {
    @Resource
    private PublicPermissionDao dao;
    @Resource
    private SysRoleService      sysRoleService;
    @Resource
    private CurrAppService      currAppService;
    @Resource
    private ThirdMemberService  thirdMemberService;

    /**
     * 根据用户所有权限
     *
     * @return 权限列表
     */
    public List<String> selectMenuPerms() {
        String currAppId = currAppService.getCurrAppId();
        return dao.selectMenuPerms(currAppId);
    }

    /**
     * 根据用户查询系统菜单列表
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<AdminMenuVo> selectMenuList(String userId) {
        return selectMenuList(new AdminMenuVoParam(), userId);
    }

    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<AdminMenuVo> selectMenuList(AdminMenuVoParam menu, String userId) {
        List<AdminMenuVo> menuList = null;
        // 管理员显示所有菜单信息
        ThirdMember adminUser = thirdMemberService.findByUserId(userId);
        String currAppId = currAppService.getCurrAppId();
        menuList = dao.selectMenuListByMemberId(adminUser.getId(), currAppId);
        return menuList;
    }

    public Page<AdminMenuVo> selectMenuListPage(AdminMenuVoParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        Page<AdminMenuVo> list = dao.selectMenuListPage(param);
        return list;
    }

    /**
     * 根据用户LID查询权限
     *
     * @param memberId 用户LID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByMemberId(Long memberId) {
        String currAppId = currAppService.getCurrAppId();
        List<String> perms = dao.selectMenuPermsByMemberId(memberId, currAppId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (ObjectUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根据角色ID查询权限
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByRoleId(Long roleId) {
        String currAppId = currAppService.getCurrAppId();
        List<String> perms = dao.selectMenuPermsByRoleId(roleId, currAppId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (ObjectUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根据用户LID查询菜单
     *
     * @param memberId 用户LID
     * @return 菜单列表
     */
    public List<AdminMenuVo> selectMenuTreeByMemberId(Long memberId) {
        List<AdminMenuVo> menus = null;
        ThirdMember adminUser = thirdMemberService.findById(memberId);
        String currAppId = currAppService.getCurrAppId();
        menus = dao.selectMenuTreeByMemberId(memberId, currAppId);
        return menus;
    }

    /**
     * 根据角色ID查询菜单树信息
     *
     * @param roleId 角色ID
     * @return 选中菜单列表
     */
    public List<Long> selectMenuListByRoleId(Long roleId) {
        SysRole role = sysRoleService.findById(roleId);
        String currAppId = currAppService.getCurrAppId();
        return dao.selectMenuListByRoleId(roleId, role.getIsRegular(), currAppId);
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<AdminMenuVo> getChildPerms(List<AdminMenuVo> list, int parentId) {
        List<AdminMenuVo> returnList = new ArrayList<AdminMenuVo>();
        for (Iterator<AdminMenuVo> iterator = list.iterator(); iterator.hasNext();) {
            AdminMenuVo t = (AdminMenuVo) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (ObjectUtils.isNotEmpty(t.getParentId()) && t.getParentId() == parentId) {
                fetchList(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list 分类表
     * @param t 子节点
     */
    public void fetchList(List<AdminMenuVo> list, AdminMenuVo t) {
        // 得到子节点列表
        List<AdminMenuVo> childList = getChildList(list, t);
        t.setChildren(childList);
        for (AdminMenuVo tChild : childList) {
            if (hasChild(list, tChild)) {
                fetchList(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<AdminMenuVo> getChildList(List<AdminMenuVo> list, AdminMenuVo t) {
        List<AdminMenuVo> tlist = new ArrayList<AdminMenuVo>();
        Iterator<AdminMenuVo> it = list.iterator();
        while (it.hasNext()) {
            AdminMenuVo n = (AdminMenuVo) it.next();
            if (ObjectUtils.isNotEmpty(n.getParentId())
                && (n.getParentId().longValue() == t.getMenuId().longValue())) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<AdminMenuVo> list, AdminMenuVo t) {
        return getChildList(list, t).size() > 0;
    }

    /**
     * 查询菜单使用数量
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public boolean checkMenuExistRole(Long menuId) {
        List<Long> result = sysRoleService.getRoleListByMenuId(menuId);
        return result.size() > 0;
    }

    /**
     * 根据父节点删除子菜单
     *
     * @param parentId 父节点ID
     */
    public void deleteByParentId(Long parentId) {
        dao.deleteByParentId(parentId);
    }

    /**
     * 根据用户LID获取角色选择框列表
     *
     * @param memberId 用户LID
     * @return 选中角色ID列表
     */
    public List<Long> selectRoleListByMemberId(Long memberId) {
        return dao.selectRoleListByMemberId(memberId);
    }

    /**
     * 根据用户LID查询权限
     *
     * @param memberId 用户LID
     * @return 权限列表
     */
    public Set<String> selectRoleCodeByMemberId(Long memberId) {
        List<String> perms = dao.selectRoleCodeByMemberId(memberId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (ObjectUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根据父节点删除子菜单
     *
     * @param parentId 用户LID
     * @return 菜单列表
     */
    public int hasChildByParentId(Long parentId) {
        return dao.hasChildByParentId(parentId);
    }

    /**
     * 某个菜单下有权限的按钮
     * @param menuId    菜单ID
     * @return    返回结果List
     */
    public List<SysMenuButtonDto> getButtons(Long menuId) {
        return dao.getButtons(menuId);
    }

    /**
     * 通用获取未绑定的会员人员列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<PermissionCommDto> getUnBindMemberUserList(PermissionCommParam param) {
        return dao.getUnBindMemberUserList(param);
    }

    /**
     * 获取机构下绑定的人员列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<PermissionCommDto> getUsersByBindOrganList(PermissionCommParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getUsersByBindOrganList(param);
    }

    /**
     * 获取岗位下绑定的人员列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<PermissionCommDto> getUsersByBindPositionList(PermissionCommParam param) {
        return dao.getUsersByBindPositionList(param);
    }

    /**
     * 获取机构、分组、岗位 下绑定的人员列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<PermissionCommDto> getUsersByBindList(PermissionCommParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getUsersByBindList(param);
    }

    /**
     * 绑定机构下的人员
     * @param permissionCommDto    查询参数
     */
    public void bindUsersForOrgan(PermissionCommDto permissionCommDto) {
        dao.bindUsersForOrgan(permissionCommDto);
    }

    /**
     * 获取组织下绑定的人员列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<OrganGroupBindDto> getOrganGroupBindList(OrganGroupBindParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getOrganGroupBindList(param);
    }

    /**
     * 获取组织下绑定的人员列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<OrganGroupBindDto> getOrganGroupUnbindList(OrganGroupBindParam param) {
        //关键词为空，不返回
        if (StringUtils.isEmpty(param.getQ())) {
            return new Page<>();
        }
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getOrganGroupUnbindList(param);
    }

    /**
     * 获取岗位下绑定的人员列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<UserPositionBindDto> getUserPositionBindList(UserPositionBindParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getUserPositionBindList(param);
    }

    /**
     * 获取岗位下绑定的人员列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<UserPositionBindDto> getUserPositionUnBindList(UserPositionBindParam param) {
        //关键词为空，不返回
        if (StringUtils.isEmpty(param.getQ())) {
            return new Page<>();
        }
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getUserPositionUnBindList(param);
    }

    /**
     * 获取分组列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<PublicGroupListDto> getMemberGroupList(PublicGroupSimpleParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getMemberGroupList(param);
    }

    /**
     * 绑定岗位下的人员
     * @param permissionCommDto     权限查询条件
     */
    public void bindUsersForPosition(PermissionCommDto permissionCommDto) {
        dao.bindUsersForPosition(permissionCommDto);
    }

    /**
     * 批量绑定
     * @param list  绑定输入列表
     */
    public void batchBindUsers(List<PermissionCommDto> list) {
        dao.batchBindUsers(list);
    }

    /**
     * 会员组绑定
     * @param list  绑定输入列表
     */
    public void memberGroupBindUser(List<PublicGroupUserDto> list) {
        dao.memberGroupBindUser(list);
    }

    /**
     * 会员组解绑
     * @param id  用户ID
     * @param ids  分组ID
     */
    public void memberGroupUnBindUser(String id, Long[] ids) {
        dao.memberGroupUnBindUser(id, ids);
    }

    public PermissionCommDto findByUserId(PermissionCommDto permissionCommDto) {
        return dao.findByUserId(permissionCommDto);
    }

    /**
     * 批量解绑党员绑定的机构
     * @param ids   人员Ids
     */
    public void logicalDeleteByPeopleIds(String[] ids) {
        if (ObjectUtils.isNotEmpty(ids)) {
            dao.logicalDeleteByPeopleIds(ids);
        }
    }

    /** 通过机构ID查询用户手机列表
     * @param organId   机构ID
     * @return  手机号码列表
     */
    public List<String> getMobileByOrganId(@Param("organId") String organId) {
        return dao.getMobileByOrganId(organId);
    }

    /**
     * 获取公共账户
     * @param param 查询条件
     * @return  用户列表
     */
    public List<BaseUser> getPublicAccount(PositionAccountParam param) {
        return dao.getPublicAccount(param);
    }

    public boolean hasRole(String mobile, Long groupId, String organId) {
        Integer result = dao.hasRoleOrgan(mobile, groupId, organId);
        if (result > 0) {
            return true;
        }
        return false;
    }

    /**
     * 用户是否有某个角色
     * @param userId 用户id
     * @param groupId 用户组id
     * @return  是否有权限
     */
    public boolean hasRole(String userId, Long groupId) {
        Integer result = dao.hasRoleByUser(userId, groupId);
        if (result > 0) {
            return true;
        }
        return false;
    }

    /**
     * 用户是否有某个角色
     * @param memberId MEMBER_USER 表id
     * @param groupId 用户组id
     * @return  是否有权限
     */
    public boolean hasRole(Long memberId, Long groupId) {
        Integer result = dao.hasRole(memberId, groupId);
        if (result > 0) {
            return true;
        }
        return false;
    }

    /**
     * 用户是否有某个角色
     * @param mobile 手机号
     * @param groupId 用户组id
     * @return  是否有权限
     */
    public boolean hasRoleByMobile(String mobile, Long groupId) {
        Integer result = dao.hasRoleByMobile(mobile, groupId);
        if (result > 0) {
            return true;
        }
        return false;
    }

}
