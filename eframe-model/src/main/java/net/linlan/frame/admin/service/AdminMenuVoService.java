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
package net.linlan.frame.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.frame.admin.dao.AdminMenuVoDao;
import net.linlan.frame.admin.dto.AdminMenuVo;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.param.AdminMenuVoParam;
import net.linlan.sys.role.dto.SysMenuButtonDto;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.sys.role.service.SysRoleService;

/**
 * 菜单 业务层处理
 * 
 * @author Linlan
 */
@Service
public class AdminMenuVoService {
    public static final String PREMISSION_STRING = "perms[\"{0}\"]";

    @Resource
    private AdminMenuVoDao     adminMenuDao;
    @Resource
    private SysRoleService     sysRoleService;
    @Resource
    private CurrAppService     currAppService;

    /**
     * 根据用户所有权限
     *
     * @return 权限列表
     */
    public List<String> selectMenuPerms() {
        String currAppId = currAppService.getCurrAppId();
        return adminMenuDao.selectMenuPerms(currAppId);
    }

    /**
     * 根据用户查询系统菜单列表
     * 
     * @param adminId 用户LID
     * @return 菜单列表
     */
    public List<AdminMenuVo> selectMenuList(Long adminId) {
        return selectMenuList(new AdminMenuVoParam(), adminId);
    }

    /**
     * 查询系统菜单列表
     * 
     * @param menu 菜单信息
     * @param adminId 管理员ID
     * @return 菜单列表
     */
    public List<AdminMenuVo> selectMenuList(AdminMenuVoParam menu, Long adminId) {
        List<AdminMenuVo> menuList = null;
        // 管理员显示所有菜单信息
        if (AdminUser.isAdmin(adminId)) {
            menuList = adminMenuDao.selectMenuList(menu);
        } else {
            String currAppId = currAppService.getCurrAppId();
            menuList = adminMenuDao.selectMenuListByAdminId(adminId, currAppId);
        }
        return menuList;
    }

    public Page<AdminMenuVo> selectMenuListPage(AdminMenuVoParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        Page<AdminMenuVo> list = adminMenuDao.selectMenuListPage(param);
        return list;
    }

    /**
     * 根据用户LID查询权限
     * 
     * @param adminId 用户LID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByAdminId(Long adminId) {
        String currAppId = currAppService.getCurrAppId();
        List<String> perms = adminMenuDao.selectMenuPermsByAdminId(adminId, currAppId);
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
        List<String> perms = adminMenuDao.selectMenuPermsByRoleId(roleId, currAppId);
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
     * @param adminId 用户LID
     * @return 菜单列表
     */
    public List<AdminMenuVo> selectMenuTreeByAdminId(Long adminId) {
        List<AdminMenuVo> menus = null;
        if (AdminUser.isAdmin(adminId)) {
            menus = adminMenuDao.selectMenuTreeAll();
        } else {
            String currAppId = currAppService.getCurrAppId();
            menus = adminMenuDao.selectMenuTreeByAdminId(adminId, currAppId);

        }
        return menus;
        //        shuxiaobo 20250307 modify 直接返回全部菜单，不在后台组装
        //        return getChildPerms(menus, 0);
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
        return adminMenuDao.selectMenuListByRoleId(roleId, role.getIsRegular(), currAppId);
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
        adminMenuDao.deleteByParentId(parentId);
    }

    /**
     * 根据父节点删除子菜单
     *
     * @param parentId 用户LID
     * @return 菜单列表
     */
    public int hasChildByParentId(Long parentId) {
        return adminMenuDao.hasChildByParentId(parentId);
    }

    /**
     * 某个菜单下有权限的按钮
     * @param menuId    菜单ID
     * @return    返回结果List
     */
    public List<SysMenuButtonDto> getButtons(Long menuId) {
        return adminMenuDao.getButtons(menuId);
    }

}
