/*
 * eframe-api - api接口网关模块
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
package net.linlan.frame.api.admin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.frame.admin.dto.AdminMenuVo;
import net.linlan.frame.admin.dto.PermsDto;
import net.linlan.frame.admin.param.AdminMenuVoParam;
import net.linlan.frame.admin.service.AdminMenuService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.manager.AdminMenuManager;
import net.linlan.frame.view.admin.vo.MenuTreeRoleVo;
import net.linlan.frame.view.sys.service.FrameDictionaryService;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.frame.web.model.TreeSelect;
import net.linlan.sys.role.dto.SysMenuButtonDto;
import net.linlan.sys.role.dto.SysMenuDto;
import net.linlan.sys.role.entity.SysMenu;
import net.linlan.sys.role.param.SysMenuParam;
import net.linlan.sys.role.service.SysMenuService;
import net.linlan.utils.LayuiCompUtils;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.dto.LayuiTree;

/**
 * 系统菜单信息读写
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/admin/")
public class SysMenuController extends BaseController {
    @Resource
    private SysMenuService         sysMenuService;
    @Resource
    private AdminMenuService       adminMenuService;
    @Resource
    private AdminMenuManager       adminMenuManager;
    @Resource
    private FrameDictionaryService frameDictionaryService;

    /**
     * 获取菜单列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取菜单列表")
    @PreAuthorize("@ss.hasPerms('admin:menu:list')")
    @GetMapping("menu/list")
    @Encrypt
    public ResponseEntity<List<AdminMenuVo>> list(AdminMenuVoParam param) {
        List<AdminMenuVo> menus = adminMenuService.selectMenuList(param,
            SecurityUtils.getUserLid());
        return success(menus);
    }

    /**
     * 获取菜单分页
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取菜单分页")
    @PreAuthorize("@ss.hasPerms('admin:menu:list')")
    @GetMapping("menu/page")
    @Encrypt
    public ResponseEntity<Page<AdminMenuVo>> page(AdminMenuVoParam param) {
        Page<AdminMenuVo> result = adminMenuService.selectMenuListPage(param);
        Map<String, String> typeNameMap = frameDictionaryService
            .getDictionaryList("ADMIN_MENU_TYPE");
        Map<String, String> menuTypeNameMap = frameDictionaryService
            .getDictionaryList("ADMIN_MENU_URLTYPE");
        List<AdminMenuVo> list = result.getResult();
        for (AdminMenuVo vo : list) {
            vo.setTypeName(typeNameMap.get(vo.getType()));
            vo.setMenuTypeName(menuTypeNameMap.get(vo.getMenuType()));
        }
        return successPage(list, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 根据菜单编号获取详细信息
     * @param menuId  菜单ID
     * @return  返回对象
     */
    @PlatLog(value = "根据菜单编号获取详细信息")
    @PreAuthorize("@ss.hasPerms('admin:menu:detail')")
    @GetMapping(value = "menu/{menuId}")
    @Encrypt
    public ResponseEntity<AdminMenuVo> getInfo(@PathVariable Long menuId) {
        if (ObjectUtils.isEmpty(menuId)) {
            return failure();
        }
        AdminMenuVo vo = null;
        SysMenu entity = sysMenuService.findById(menuId);
        Map<String, String> typeNameMap = frameDictionaryService
            .getDictionaryList("ADMIN_MENU_TYPE");
        Map<String, String> menuTypeNameMap = frameDictionaryService
            .getDictionaryList("ADMIN_MENU_URLTYPE");
        if (entity != null) {
            vo = (AdminMenuVo) AdminMenuVo.TO.apply(entity);
            vo.setTypeName(typeNameMap.get(vo.getType()));
            vo.setMenuTypeName(menuTypeNameMap.get(vo.getMenuType()));
            //查询子菜单按钮
            List<SysMenuButtonDto> buttons = adminMenuService.getButtons(menuId);
            vo.setButtonMenuList(buttons);
        }
        return success(vo);
    }

    /**
     * 获取菜单下拉树列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取菜单下拉树列表")
    @GetMapping("menu/treeselect")
    @Encrypt
    public ResponseEntity<MenuTreeRoleVo> treeselect(AdminMenuVoParam param) {
        List<AdminMenuVo> menus = adminMenuService.selectMenuList(param,
            SecurityUtils.getUserLid());
        List<TreeSelect> treeSelects = adminMenuManager.buildMenuTreeSelect(menus);
        MenuTreeRoleVo menuTreeRoleVo = new MenuTreeRoleVo();
        menuTreeRoleVo.setMenus(treeSelects);
        return success(menuTreeRoleVo);
    }

    /**
     * 获取菜单下拉初始树列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取菜单下拉初始树列表")
    @GetMapping("menu/treeInit")
    @Encrypt
    public ResponseEntity<List<LayuiTree>> treeInit(SysMenuParam param) {

        param.setAppId(Constants.ENT_APP_ID);
        param.setIsMenuAll("ALL");
        param.setLimit(30000);

        Page<SysMenuDto> list = sysMenuService.getPageDto(param);
        List<LayuiTree> MenutreeList = new ArrayList<>();

        for (SysMenu adminMenu : list) {
            LayuiTree tree = new LayuiTree();
            tree.setId(adminMenu.getId().toString());
            if (adminMenu.getParentId() == null) {
                tree.setParentId("0");
            } else {
                tree.setParentId(adminMenu.getParentId().toString());
            }
            tree.setExtId(adminMenu.getCode());
            tree.setTitle(adminMenu.getName());
            MenutreeList.add(tree);
        }

        MenutreeList = LayuiCompUtils.buildLayuiTree(MenutreeList, "0");

        return success(MenutreeList);
    }

    /**
     * 加载对应角色菜单列表树
     * @param roleId  角色ID
     * @return  返回对象
     */
    @PlatLog(value = "加载对应角色菜单列表树")
    @GetMapping(value = "menu/roleMenuTreeselect/{roleId}")
    @Encrypt
    public ResponseEntity<MenuTreeRoleVo> roleMenuTreeselect(@PathVariable("roleId") Long roleId) {
        List<AdminMenuVo> menus = adminMenuService.selectMenuList(SecurityUtils.getUserLid());
        MenuTreeRoleVo menuTreeVo = new MenuTreeRoleVo();
        menuTreeVo.setCheckedKeys(adminMenuService.selectMenuListByRoleId(roleId));
        menuTreeVo.setMenus(adminMenuManager.buildMenuTreeSelect(menus));
        return ResponseEntity.ok(menuTreeVo);
    }

    /**
     * 新增单个菜单
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:menu:save')")
    @PlatLog(value = "新增单个菜单", category = 10)
    @PostMapping("menu/save/single")
    @Encrypt
    @LimitScope(name = "sysMenuSave", key = "sysMenuSave")
    public ResponseEntity<String> saveSingle(@Validated @RequestBody AdminMenuVo input) {
        if (!adminMenuManager.checkMenuNameUnique(input)) {
            return error("新增菜单'" + input.getMenuName() + "'失败，菜单名称已存在");
        }
        //        else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.startsWith(menu.getPath(), HttpContextUtils.HTTP, HttpContextUtils.HTTPS))
        //        {
        //            return error("新增菜单'" + menu.getMenuName() + "'失败，地址必须以http(s)://开头");
        //        }
        SysMenu adminMenu = AdminMenuVo.transTo(input);
        Long id = RandomUtils.randomLid();
        adminMenu.setId(id);
        sysMenuService.save(adminMenu);
        return success();
    }

    /**
     * 修改菜单
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:menu:update')")
    @PlatLog(value = "修改菜单管理", category = 20)
    @PostMapping("menu/update/single")
    @Encrypt
    @LimitScope(name = "sysMenuUpdate", key = "sysMenuUpdate")
    public ResponseEntity<String> updateSingle(@Validated @RequestBody AdminMenuVo input) {
        if (!adminMenuManager.checkMenuNameUnique(input)) {
            return error("修改菜单'" + input.getMenuName() + "'失败，菜单名称已存在");
        }
        //        else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.startsWith(menu.getPath(), HttpContextUtils.HTTP, HttpContextUtils.HTTPS))
        //        {
        //            return error("修改菜单'" + menu.getMenuName() + "'失败，地址必须以http(s)://开头");
        //        }
        else if (input.getMenuId().equals(input.getParentId())) {
            return error("修改菜单'" + input.getMenuName() + "'失败，上级菜单不能选择自己");
        }
        SysMenu adminMenu = AdminMenuVo.transTo(input);
        sysMenuService.update(adminMenu);
        return success();
    }

    /**
     * 新增菜单及默认按钮
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:menu:save')")
    @PlatLog(value = "新增菜单及默认按钮", category = 10)
    @PostMapping("menu/save")
    @Encrypt
    @LimitScope(name = "sysMenuSave", key = "sysMenuSave")
    public ResponseEntity<String> save(@Validated @RequestBody AdminMenuVo input) {
        if (!adminMenuManager.checkMenuNameUnique(input)) {
            return error("新增菜单'" + input.getMenuName() + "'失败，菜单名称已存在");
        }
        SysMenu adminMenu = AdminMenuVo.transTo(input);
        Long id = RandomUtils.randomLid();
        adminMenu.setId(id);
        adminMenu.setPerms(input.getPerms());
        sysMenuService.save(adminMenu);
        //保存扩展表信息
        input.setMenuId(id);
        //保存菜单按钮配置
        if (StringUtils.isNotBlank(input.getPerms()) && input.getPermsList().size() > 0) {
            List<SysMenu> buttonMenuList = new ArrayList<>();
            getButtonMenuList(input, id, buttonMenuList);
            if (buttonMenuList.size() > 0) {
                //                sysMenuService.batchSave(buttonMenuList);
                for (SysMenu buttonMenu : buttonMenuList) {
                    sysMenuService.save(buttonMenu);
                }
            }
        }
        return success();
    }

    private static void getButtonMenuList(AdminMenuVo menu, Long id, List<SysMenu> buttonMenuList) {
        for (PermsDto perms : menu.getPermsList()) {
            SysMenu buttonMenu = new SysMenu();
            buttonMenu.setId(RandomUtils.randomLid());
            buttonMenu.setParentId(id);
            buttonMenu.setAppId(Constants.ENT_APP_ID);
            buttonMenu.setName(perms.getPermsName());
            buttonMenu.setEname(perms.getPermsStr());
            buttonMenu.setType(Constants.SUPER_ADMIN);
            buttonMenu.setMenuLevel(3);
            if (StringUtils.isNotBlank(menu.getPerms()) && menu.getPerms().contains(":")) {
                String[] prelist = menu.getPerms().split(":");
                buttonMenu.setPerms(prelist[0] + ":" + prelist[1] + ":" + perms.getPermsStr());
            }
            buttonMenu.setUrlType("BUTTON");
            buttonMenu.setIsLeaf(false);
            buttonMenu.setIsDisplay(true);
            buttonMenu.setIsProtect(true);
            buttonMenu.setIsDisabled(false);
            buttonMenu.setIsCheck(false);
            buttonMenu.setPriority(10);
            buttonMenu.setCreateTime(new Date());
            buttonMenu.setLastTime(new Timestamp(System.currentTimeMillis()));
            buttonMenu.setDelFlag(0);
            buttonMenuList.add(buttonMenu);
        }
    }

    /**
     * 修改菜单及默认按钮
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:menu:update')")
    @PlatLog(value = "修改菜单及默认按钮", category = 20)
    @PostMapping("menu/update")
    @Encrypt
    @LimitScope(name = "sysMenuUpdate", key = "sysMenuUpdate")
    public ResponseEntity<String> update(@Validated @RequestBody AdminMenuVo input) {
        if (!adminMenuManager.checkMenuNameUnique(input)) {
            return error("修改菜单'" + input.getMenuName() + "'失败，菜单名称已存在");
        } else if (input.getMenuId().equals(input.getParentId())) {
            return error("修改菜单'" + input.getMenuName() + "'失败，上级菜单不能选择自己");
        }
        SysMenu adminMenu = AdminMenuVo.transTo(input);
        adminMenu.setPerms(input.getPerms());
        sysMenuService.update(adminMenu);
        //更新菜单按钮配置
        adminMenuService.deleteByParentId(input.getMenuId());
        if (StringUtils.isNotBlank(input.getPerms()) && input.getPermsList().size() > 0) {
            List<SysMenu> buttonMenuList = new ArrayList<>();
            getButtonMenuList(input, input.getMenuId(), buttonMenuList);
            if (buttonMenuList.size() > 0) {
                //                sysMenuService.batchSave(buttonMenuList);
                for (SysMenu buttonMenu : buttonMenuList) {
                    sysMenuService.save(buttonMenu);
                }
            }
        }
        return success();
    }

    /**
     * 删除菜单
     * @param menuIds  菜单Ids
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:menu:delete')")
    @PlatLog(value = "删除菜单", category = 40)
    @PostMapping("menu/delete/{menuIds}")
    @Encrypt
    @LimitScope(name = "sysMenuDelete", key = "sysMenuDelete")
    public ResponseEntity<String> delete(@PathVariable("menuIds") Long[] menuIds) {
        for (Long menuId : menuIds) {
            if (adminMenuService.hasChildByParentId(menuId) > 0) {
                return warn("存在未删除的子菜单,不允许删除");
            }
            if (adminMenuService.checkMenuExistRole(menuId)) {
                return warn("菜单已分配,不允许删除");
            }
            SysMenu menu = new SysMenu();
            menu.setId(menuId);
            menu.setDelFlag(2);
            sysMenuService.update(menu);
        }
        return success();
    }

    /**
     * 停用启用菜单
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:menu:delete')")
    @PlatLog(value = "停用启用菜单", category = 51)
    @PostMapping("menu/disable/{id}")
    @Encrypt
    @LimitScope(name = "sysMenuDelete", key = "sysMenuDelete")
    public ResponseEntity<String> delete(@RequestBody SysMenu input) {
        Long menuId = input.getId();
        if (adminMenuService.hasChildByParentId(menuId) > 0) {
            return error("该部门包含未停用的子菜单！");
        }
        sysMenuService.update(input);
        return returnRow(1);
    }

}
