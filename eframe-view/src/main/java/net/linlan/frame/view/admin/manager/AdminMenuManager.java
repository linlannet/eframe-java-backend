/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.admin.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.dto.AdminMenuVo;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.service.AdminMenuService;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.view.admin.vo.AdminBaseMenuInfo;
import net.linlan.frame.view.admin.vo.AppPageIndexInfo;
import net.linlan.frame.web.model.TreeSelect;
import net.linlan.sys.role.entity.SysMenu;
import net.linlan.sys.role.service.SysMenuService;
import net.linlan.utils.constant.UserConstants;

/**
 * 登录校验方法
 * 
 * @author Linlan
 */
@Component
public class AdminMenuManager {
    @Resource
    private AdminMenuService adminMenuService;
    @Resource
    private SysMenuService   sysMenuService;
    @Resource
    private AdminUserService adminUserService;
    //    /**
    //     * 构建前端路由所需要的菜单
    //     *
    //     * @param menus 菜单列表
    //     * @return 路由列表
    //     */
    //    public List<RouterVo> buildMenus(List<AdminMenuEntDto> menus)
    //    {
    //        List<RouterVo> routers = new LinkedList<RouterVo>();
    //        for (AdminMenuEntDto menu : menus)
    //        {
    //            RouterVo router = new RouterVo();
    //            router.setHidden("1".equals(menu.getVisible()));
    //            router.setName(menu.getRouteName());
    //            router.setPath(StringUtils.isEmpty(menu.getPath()) ? "" : menu.getPath());
    //            router.setComponent(menu.getComponent());
    //            router.setQuery(menu.getQuery());
    //            router.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), StringUtils.equals("1", menu.getIsCache()), menu.getPath()));
    //            List<AdminMenuEntDto> cMenus = menu.getChildren();
    //            if (ObjectUtils.isNotEmpty(cMenus) && UserConstants.TYPE_DIR.equals(menu.getMenuType()))
    //            {
    //                router.setAlwaysShow(true);
    //                router.setRedirect("noRedirect");
    //                router.setChildren(buildMenus(cMenus));
    //            }
    //            else if (isMenuFrame(menu))
    //            {
    //                router.setMeta(null);
    //                List<RouterVo> childrenList = new ArrayList<RouterVo>();
    //                RouterVo children = new RouterVo();
    //                children.setPath(StringUtils.isEmpty(menu.getPath()) ? "" : menu.getPath());
    //                children.setComponent(menu.getComponent());
    //                children.setName(menu.getRouteName());
    //                children.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), StringUtils.equals("1", menu.getIsCache()), menu.getPath()));
    //                children.setQuery(menu.getQuery());
    //                childrenList.add(children);
    //                router.setChildren(childrenList);
    //            }
    //            else if (menu.getParentId().intValue() == 0 && isInnerLink(menu))
    //            {
    //                router.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon()));
    //                router.setPath("/");
    //                List<RouterVo> childrenList = new ArrayList<RouterVo>();
    //                RouterVo children = new RouterVo();
    //                String path = innerLinkReplaceEach(menu.getPath());
    //                children.setPath(path);
    //                children.setComponent(UserConstants.INNER_LINK);
    //                children.setName(menu.getRouteName());
    //                children.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), menu.getPath()));
    //                childrenList.add(children);
    //                router.setChildren(childrenList);
    //            }
    //            routers.add(router);
    //        }
    //        return routers;
    //    }

    /**
     * 构建前端所需要树结构
     *
     * @param menus 菜单列表
     * @return 树结构列表
     */
    public List<AdminMenuVo> buildMenuTree(List<AdminMenuVo> menus) {
        List<AdminMenuVo> returnList = new ArrayList<AdminMenuVo>();
        List<Long> tempList = menus.stream().map(AdminMenuVo::getMenuId)
            .collect(Collectors.toList());
        for (Iterator<AdminMenuVo> iterator = menus.iterator(); iterator.hasNext();) {
            AdminMenuVo menu = (AdminMenuVo) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(menu.getParentId())) {
                adminMenuService.fetchList(menus, menu);
                returnList.add(menu);
            }
        }
        if (returnList.isEmpty()) {
            returnList = menus;
        }
        return returnList;
    }

    /**
     * 构建前端所需要下拉树结构
     *
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildMenuTreeSelect(List<AdminMenuVo> menus) {
        List<AdminMenuVo> menuTrees = buildMenuTree(menus);
        return menuTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 校验菜单名称是否唯一
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public boolean checkMenuNameUnique(AdminMenuVo menu) {
        Long menuId = ObjectUtils.isEmpty(menu.getMenuId()) ? -1L : menu.getMenuId();
        SysMenu info = sysMenuService.checkNameUnique(menu.getMenuName(), menu.getParentId());
        if (ObjectUtils.isNotEmpty(info) && info.getId().longValue() != menuId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    //    /**
    //     * 获取路由名称
    //     *
    //     * @param menu 菜单信息
    //     * @return 路由名称
    //     */
    //    public String getRouteName(AdminMenuEntDto menu)
    //    {
    //        // 非外链并且是一级目录（类型为目录）
    //        if (isMenuFrame(menu))
    //        {
    //            return StringUtils.EMPTY;
    //        }
    //        return getRouteName(menu.getRouteName(), menu.getPath());
    //    }

    //    /**
    //     * 获取路由名称，如没有配置路由名称则取路由地址
    //     *
    //     * @param name 路由名称
    //     * @param path 路由地址
    //     * @return 路由名称（驼峰格式）
    //     */
    //    public String getRouteName(String name, String path)
    //    {
    //        String routerName = ObjectUtils.isNotEmpty(name) ? name : path;
    //        return StringUtils.capitalize(routerName);
    //    }

    //    /**
    //     * 获取路由地址
    //     *
    //     * @param menu 菜单信息
    //     * @return 路由地址
    //     */
    //    public String getRouterPath(AdminMenuEntDto menu)
    //    {
    //        String routerPath = menu.getPath();
    //        // 内链打开外网方式
    //        if (menu.getParentId().intValue() != 0 && isInnerLink(menu))
    //        {
    //            routerPath = innerLinkReplaceEach(routerPath);
    //        }
    //        // 非外链并且是一级目录（类型为目录）
    //        if (0 == menu.getParentId().intValue() && UserConstants.TYPE_DIR.equals(menu.getMenuType())
    //                && UserConstants.NO_FRAME.equals(menu.getIsFrame()))
    //        {
    //            routerPath = "/" + menu.getPath();
    //        }
    //        // 非外链并且是一级目录（类型为菜单）
    //        else if (isMenuFrame(menu))
    //        {
    //            routerPath = "/";
    //        }
    //        return routerPath;
    //    }

    //    /**
    //     * 获取组件信息
    //     *
    //     * @param menu 菜单信息
    //     * @return 组件信息
    //     */
    //    public String getComponent(AdminMenuEntDto menu)
    //    {
    //        String component = UserConstants.LAYOUT;
    //        if (ObjectUtils.isNotEmpty(menu.getComponent()) && !isMenuFrame(menu))
    //        {
    //            component = menu.getComponent();
    //        }
    //        else if (StringUtils.isEmpty(menu.getComponent()) && menu.getParentId().intValue() != 0 && isInnerLink(menu))
    //        {
    //            component = UserConstants.INNER_LINK;
    //        }
    //        else if (StringUtils.isEmpty(menu.getComponent()) && isParentView(menu))
    //        {
    //            component = UserConstants.PARENT_VIEW;
    //        }
    //        return component;
    //    }

    //    /**
    //     * 是否为菜单内部跳转
    //     *
    //     * @param menu 菜单信息
    //     * @return 结果
    //     */
    //    public boolean isMenuFrame(AdminMenuEntDto menu)
    //    {
    //        return menu.getParentId().intValue() == 0 && UserConstants.TYPE_MENU.equals(menu.getMenuType())
    //                && menu.getIsFrame().equals(UserConstants.NO_FRAME);
    //    }
    //
    //    /**
    //     * 是否为内链组件
    //     *
    //     * @param menu 菜单信息
    //     * @return 结果
    //     */
    //    public boolean isInnerLink(AdminMenuEntDto menu)
    //    {
    //        return menu.getIsFrame().equals(UserConstants.NO_FRAME) && StringUtils.startsWith(menu.getPath(), HttpContextUtils.HTTP, HttpContextUtils.HTTPS);
    //    }
    //
    //    /**
    //     * 是否为parent_view组件
    //     *
    //     * @param menu 菜单信息
    //     * @return 结果
    //     */
    //    public boolean isParentView(AdminMenuEntDto menu)
    //    {
    //        return menu.getParentId().intValue() != 0 && UserConstants.TYPE_DIR.equals(menu.getMenuType());
    //    }
    //
    //    /**
    //     * 内链域名特殊字符替换
    //     *
    //     * @return 替换后的内链域名
    //     */
    //    public String innerLinkReplaceEach(String path)
    //    {
    //        return StringUtils.replaceEach(path, new String[] { HttpContextUtils.HTTP, HttpContextUtils.HTTPS, HttpContextUtils.WWW, ".", ":" },
    //                new String[] { "", "", "", "/", "/" });
    //    }

    public AppPageIndexInfo getAppPageIndexInfo(FrameUserDetails loginUser) {
        Long adminId = loginUser.getUserLid();
        AdminUser adminUser = adminUserService.findById(adminId);
        if (ObjectUtils.isNotEmpty(adminUser)) {
            List<AdminMenuVo> menus = adminMenuService.selectMenuTreeByAdminId(adminId);
            List<AdminBaseMenuInfo> menuList = buildMenusForAdmin(menus);
            AdminUserDto user = adminUserService.getByUsername(loginUser.getUsername());
            AppPageIndexInfo entity = new AppPageIndexInfo();
            entity.setAccountId("NULL");
            entity.setAreaId(0L);
            entity.setPositionId(
                ObjectUtils.isNotEmpty(user.getPositionIds()) ? user.getPositionIds()[0] : "");
            entity
                .setGroupId(ObjectUtils.isNotEmpty(user.getRoleIds()) ? user.getRoleIds()[0] : 0L);
            entity.setTplSolution("default");
            entity.setMenuList(menuList);
            return entity;
        }
        return null;
    }

    private List<AdminBaseMenuInfo> buildMenusForAdmin(List<AdminMenuVo> menus) {
        if (menus == null) {
            return null;
        }
        List<AdminBaseMenuInfo> menuInfos = new LinkedList<>();
        for (AdminMenuVo menuEntDto : menus) {
            AdminBaseMenuInfo menuInfo = new AdminBaseMenuInfo();
            menuInfo.setId(menuEntDto.getMenuId());
            menuInfo.setParentId(menuEntDto.getParentId());
            menuInfo.setName(menuEntDto.getMenuName());
            menuInfo.setEname(menuEntDto.getPath());
            menuInfo.setType("ADMIN");
            menuInfo.setPerms(menuEntDto.getPerms());
            menuInfo.setUrlType(menuEntDto.getMenuType());
            menuInfo.setUrl(menuEntDto.getRouteName());
            menuInfo.setMenuSeq(menuEntDto.getComponent());
            menuInfo.setIcon(menuEntDto.getIcon());
            menuInfo.setImagePath(menuEntDto.getImagePath());
            menuInfo.setCss(menuEntDto.getQuery());
            menuInfo.setDescription(menuEntDto.getDescription());
            menuInfos.add(menuInfo);
        }
        return menuInfos;
    }
}
