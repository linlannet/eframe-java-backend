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
package net.linlan.sys.role.service;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.StringUtils;
import net.linlan.commons.script.json.StringMap;
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.role.dao.SysMenuDao;
import net.linlan.sys.role.dto.SysMenuDto;
import net.linlan.sys.role.dto.SysMenuListDto;
import net.linlan.sys.role.dto.SysMenuTreeDto;
import net.linlan.sys.role.entity.SysMenu;
import net.linlan.sys.role.param.MenuTreeParam;
import net.linlan.sys.role.param.SysMenuParam;
import net.linlan.sys.web.KernelThreadVariable;

/**
 *
 * SysMenu数据域:系统菜单服务类
 * @author Linlan
 * CreateTime 2017-10-17 14:21:37
 *
 */
@Service
@Slf4j
public class SysMenuService {

    @Resource
    private SysMenuDao dao;

    /** get the list of entity SysMenu
     * 列表方法，返回列表的系统菜单数据 {@link List} 对象，包含 {@link SysMenu} 列表
     * @param map the input select conditions
     * @return 列表的系统菜单数据 {@link List} 对象，包含 {@link SysMenu} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<SysMenu> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link SysMenu}
     * @param id the input id
     * @return {@link SysMenu}
     */
    public SysMenu findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param sysMenu the input sysMenu
     */
    //@Transactional
    public void save(SysMenu sysMenu) {
        sysMenu.init();
        dao.save(sysMenu);
    }

    /** save the entity with input list
     * 保存对象系统菜单，批量保存list
     * @param list {@link SysMenu}
     */
    public void batchSave(List<SysMenu> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param sysMenu the input sysMenu
     */
    //@Transactional
    public void update(SysMenu sysMenu) {
        dao.update(sysMenu);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the input id
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

    /** get the page of dto SysMenuDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link SysMenuParam }
     * @return 分页的系统菜单数据 {@link Page} 对象，包含 {@link SysMenu} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<SysMenuDto> getPageDto(SysMenuParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link SysMenuDto}
     * @param id the input id
     * @return {@link SysMenuDto}
     */
    public SysMenuDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /**
     * 获取本应用下的菜单，以及针对某个角色，菜单是否对该角色进行了授权
     * @param map    查询map
     * @return    返回结果List
     */
    public List<SysMenuTreeDto> menuStatusZtreeList(Map<String, Object> map) {
        return dao.menuStatusZtreeList(map);
    }

    /*
     * 一次性获取所有的有层次的菜单树
     * */
    public List<TreeNode> allMenutreeList(MenuTreeParam menuParam) {
        List<TreeNode> allTreeNodes = dao.allMenutreeList(menuParam);
        List<TreeNode> topNodes = new LinkedList<TreeNode>();
        //获取到顶层节点
        for (TreeNode treeNode : allTreeNodes) {
            if (StringUtils.isEmpty(treeNode.getParentId()) || treeNode.getParentId().equals("0")) {
                topNodes.add(treeNode);
            }
        }
        //递归调用
        return getNextNodes(topNodes, allTreeNodes);
    }

    public List<TreeNode> getNextNodes(List<TreeNode> topNodes, List<TreeNode> allTreeNodes) {
        //找到所有儿子节点并使用setChildren（）设置子节点属性
        for (int i = 0; i < topNodes.size(); i++) {
            TreeNode treeNode = topNodes.get(i);
            if (treeNode.getChildNum() > 0) {
                List<TreeNode> childTreeNodes = new LinkedList<TreeNode>();
                for (TreeNode treeNode1 : allTreeNodes) {
                    if (treeNode.getId().equals(treeNode1.getParentId())) {
                        childTreeNodes.add(treeNode1);
                    }
                }
                treeNode.setChildren(childTreeNodes);
            }
            //递归遍历儿子节点
            if (i == topNodes.size() - 1) {
                for (int j = 0; j < topNodes.size(); j++) {
                    //递归结束条件
                    if (topNodes.get(j).getChildren() != null
                        && topNodes.get(j).getChildren().size() > 0) {
                        getNextNodes(topNodes.get(j).getChildren(), allTreeNodes);
                    }
                }
            }
        }
        return topNodes;
    }

    /**
     * 获取应用初始菜单
     * @param map    查询map
     * @return    返回结果List
     */
    public List<SysMenuTreeDto> menuInitializeZtreeList(Map<String, Object> map) {
        return dao.menuInitializeZtreeList(map);
    }

    /**
     * 根据角色查询菜单
     * @param map    查询map
     * @return    返回结果List
     */
    public List<SysMenuTreeDto> getMenuByRole(Map<String, Object> map) {
        return dao.getMenuByRole(map);
    }

    /** get all list with default input parentNull and appId
     * @param appId the input appId
     * @return 列表的系统菜单数据 {@link List} 对象，包含 {@link SysMenu} 列表
     */
    public List<SysMenu> getListRoot(String appId) {
        return getList(new StringMap().put("parentNull", "parentNull").put("appId", appId).map());
    }

    /** get list by input parentId
     * @param parentId the input parent id
     * @param appId the input app id
     * @return 列表的系统菜单数据 {@link List} 对象，包含 {@link SysMenu} 列表
     */
    public List<SysMenu> getListByParent(Long parentId, String appId) {
        return getList(new StringMap().put("parentId", parentId).put("appId", appId)
            .put("delFlag", DelFlagEnum.NORMAL.getKey()).map());
    }

    /** get list by input parentId and include ids
     * @param parentId the input parentId
     * @param includeMenuIds the include menu ids
     * @param appId the input app id
     * @return 列表的系统菜单数据 {@link List} 对象，包含 {@link SysMenu} 列表
     */
    public List<SysMenu> getListByParent(Long parentId, List<Long> includeMenuIds, String appId) {
        List<SysMenu> menuList = null;
        if (parentId == 0L) {
            menuList = getListRoot(appId);
        } else {
            menuList = getListByParent(parentId, appId);
        }
        //如果includeIds为空，则直接返回全部
        if (includeMenuIds == null) {
            return menuList;
        }
        //includeIds不为空，则进行进一步筛选，只需要满足条件的菜单
        List<SysMenu> afterMenuList = new ArrayList<>();
        for (SysMenu menu : menuList) {
            if (includeMenuIds.contains(menu.getId())) {
                afterMenuList.add(menu);
            }
        }
        return afterMenuList;
    }

    /** 通过条件获取menuIds信息
     * @param byMode    byAdminId：通过管理员ID，byRoleId：通过角色ID
     * @param byValue         相应的输入值
     * @param appId         当前appId
     * @param isProtect     是否前台
     * @param type         类型
     * @return    返回结果List
     */
    public List<Long> getMenuIds(String byMode, Long byValue, String appId, Boolean isProtect,
                                 String type) {
        Map<String, Object> map = new HashMap<>();
        map.put("byMode", byMode);
        map.put("byValue", byValue);
        map.put("appId", appId);
        map.put("isProtect", isProtect);
        map.put("type", type);
        return dao.getMenuIds(map);
    }

    /** get the list by input roleId
     * @param roleId the input roleId
     * @return {@link SysMenu}
     */
    public List<SysMenu> getListByRole(Long roleId) {
        return getList(new StringMap().put("byRoleId", roleId).map());
    }

    /** get the list with type no button
     * @return {@link SysMenu}
     */
    public List<SysMenu> getListNoButton() {
        return getList(new StringMap().put("type", "ADMIN").put("typeNoButton", "typeNoButton")
            .put("appId", KernelThreadVariable.getBaseAppId()).map());
    }

    /** 递归方法从已有menuList内进一步筛选包含的includeMenuIds的ids
     * @param menuList the input menuList
     * @param includeMenuIds the include menuIds
     * @param appId         应用ID
     * @param isProtect     是否前台
     * @return {@link SysMenu}
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<Long> includeMenuIds,
                                          String appId, Boolean isProtect) {
        List<SysMenu> subMenuList = new ArrayList<>();

        for (SysMenu entity : menuList) {
            if (entity.getType().equals(SysMenu.MenuType.ADMIN.getValue())
                && entity.getUrlType().equals(SysMenu.MenuUrlType.CATALOG.getValue())) {//目录
                entity
                    .setList(getMenuTreeList(getListByParent(entity.getId(), includeMenuIds, appId),
                        includeMenuIds, appId, isProtect));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }

    /** 获取所有按照数结构的规则化排序菜单，前台不需要处理数结构，通过include ids和appId条件进行过滤
     * @param includeMenuIds the include ids，这个可以通过人员角色等控制，实现菜单的筛选
     * @param appId the appId
     * @param isProtect     是否前台
     * @param type         类型
     * @return 所有按照数结构的规则化排序菜单
     */
    public List<SysMenu> getListForSider(List<Long> includeMenuIds, String appId, Boolean isProtect,
                                         String type) {
        //查询根菜单列表
        List<SysMenu> menuList = dao.getListForSider(new StringMap().put("menuIds", includeMenuIds)
            .put("appId", appId).put("isProtect", isProtect).put("type", type).map());
        LinkedList<SysMenu> result = new LinkedList<>();
        // parentId为null的根节点
        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i).getParentId() == null) {
                result.add(menuList.get(i));
            }
        }
        if (result != null && result.size() > 0) {
            sortToTree(result, menuList);
        }
        return result;
    }

    // 获取数据库中菜单ID的最大值
    public Long getMaxMenuId() {
        Long maxMenuId = dao.maxMenuId();
        return maxMenuId;
    }

    public void saveOrUpdateMenu(String appId, List<SysMenu> menuIdList) {
        //先删除旧菜单
        dao.deleteByAppId(appId);

        if (menuIdList == null || menuIdList.size() == 0) {
            return;
        }

        //保存应用与菜单关系
        try {
            dao.saveMenuById(new StringMap().put("appId", appId).put("list", menuIdList)
                .put("createTime", new Date()).map());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** 通过递归算法，对当前的全部菜单进行树状结构排序，通过一次查库的方式，解决之前的多次查库慢的效率问题
     * @param parentList    当前的根目录列表
     * @param allList       全部菜单列表
     * @return              组装后的菜单，前台直接进行使用处理
     */
    public static LinkedList<SysMenu> sortToTree(LinkedList<SysMenu> parentList,
                                                 List<SysMenu> allList) {
        LinkedList<SysMenu> temp = new LinkedList<>();
        for (int i = 0; i < parentList.size(); i++) {
            // 通过当前的parentId，查询出list内的全部第一级子节点
            temp = getChildren(parentList.get(i).getId(), allList);
            if (temp != null && temp.size() > 0) {
                parentList.get(i).setList(sortToTree(temp, allList));
            }
            continue;
        }
        return parentList;

    }

    /** 通过parentId，从全部列表中取出当前的子节点
     * @param parentId  当前parentId
     * @param allList   全部菜单列表
     * @return    返回结果
     */
    public static LinkedList<SysMenu> getChildren(Long parentId, List<SysMenu> allList) {
        LinkedList<SysMenu> temp = new LinkedList<>();
        for (int j = 0; j < allList.size(); j++) {
            Long pid = allList.get(j).getParentId();
            if (pid != null && pid.equals(parentId)) {
                temp.add(allList.get(j));
            }
        }
        return temp;
    }

    /**
     * 通过Code(外键)查询记录
     * @param code    代码
     * @return    查询结果
     */
    public SysMenu findByCode(String code) {
        return dao.findByCode(code);
    }

    /**
     * 通过codes拿到menuId列表
     * @param codes  查询codes
     * @return  查询结果
     */
    public List<Long> getListByCodes(String[] codes) {
        return dao.getListByCodes(codes);
    }

    /**
     * 获取简略的列表
     * @param params  查询对象
     * @return  查询结果
     */
    public Page<SysMenuListDto> getSimpleList(SysMenuParam params) {
        PageHelper.startPage(params.getPage(), params.getLimit());
        return dao.getSimpleList(params);
    }

    /**
     * 获取菜单树
     * @param menuTreeParam  菜单树查询对象
     * @return  查询结果
     */
    public List<TreeNode> getMenuChildTree(MenuTreeParam menuTreeParam) {
        return dao.getMenuChildTree(menuTreeParam);
    }

    /**
     * 是否存在菜单子节点
     *
     * @param parentId 菜单ID
     * @return 结果
     */
    public int hasChildByParentId(Long parentId) {
        return dao.hasChildByParentId(parentId);
    }

    /**
     * 校验菜单名称是否唯一
     *
     * @param name 菜单名称
     * @param parentId 父菜单ID
     * @return 结果
     */
    public SysMenu checkNameUnique(String name, Long parentId) {
        return dao.checkNameUnique(name, parentId);
    }

}
