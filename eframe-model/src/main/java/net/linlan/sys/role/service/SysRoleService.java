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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.script.json.StringMap;
import net.linlan.sys.base.constant.PositionTypeEnum;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.param.TreeParam;
import net.linlan.sys.role.dao.SysRoleDao;
import net.linlan.sys.role.dto.RoleTypeCode;
import net.linlan.sys.role.dto.SysRoleDto;
import net.linlan.sys.role.dto.SysRoleListDto;
import net.linlan.sys.role.dto.SysRoleMenuDto;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.sys.role.entity.SysRoleAreatype;
import net.linlan.sys.role.param.SysRoleParam;

/**
 *
 * SysRole数据域:系统角色服务类
 * @author Linlan
 * CreateTime 2018-08-12 14:19:06
 *
 */
@Service
@Slf4j
public class SysRoleService {

    @Resource
    private SysRoleDao dao;

    /** get the list of entity SysRole
     * 列表方法，返回列表的角色数据 {@link List} 对象，包含 {@link SysRole} 列表
     * @param map the input select conditions
     * @return 列表的角色数据 {@link List} 对象，包含 {@link SysRole} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<SysRole> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link SysRole}
     * @param id the input id
     * @return {@link SysRole}
     */
    public SysRole findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param sysRole the input sysRole
     */
    //@Transactional
    @Transactional
    public void save(SysRole sysRole) {
        sysRole.init();
        dao.save(sysRole);
    }

    /** save the entity with input list
     * 保存对象系统角色，批量保存list
     * @param list {@link SysRole}
     */
    public void batchSave(List<SysRole> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param sysRole the input sysRole
     */
    //@Transactional
    public void update(SysRole sysRole) {
        dao.update(sysRole);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the input id
     */
    public void deleteById(Long id) {
        dao.deleteById(id);
        deleteMenuById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    //@Transactional
    public void deleteByIds(Long[] ids) {
        dao.deleteByIds(ids);
        deleteMenuByIds(ids);
    }

    /** query the total count by input select conditions
     * 通过输入的条件查询记录总数
     * @param map the input select conditions
     * @return total count
     */
    public int getCount(Map<String, Object> map) {
        return dao.getCount(map);
    }

    /** get the page of dto SysRoleDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link SysRoleParam }
     * @return 分页的系统角色数据 {@link Page} 对象，包含 {@link SysRole} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<SysRoleDto> getPageDto(SysRoleParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link SysRoleDto}
     * @param id the input id
     * @return {@link SysRoleDto}
     */
    public SysRoleDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    public Page<SysRoleListDto> getSysMenuList(SysRoleParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getSysMenuList(param);
    }

    public List<RoleTypeCode> getTreeByRoletype(Map<String, Object> map) {
        return dao.getTreeByRoletype(map);
    }

    public List<RoleTypeCode> getRoletypeList(Map<String, Object> map) {
        return dao.getRoletypeList(map);
    }

    /** 通过roleId查询到关联的menuIds
     * @param id role id
     * @return    返回结果List
     */
    public List<Long> getMenuIds(Long id) {
        return dao.getMenuIds(id);
    }

    /**
     * 角色菜单绑定
     * @param sysRoleMenuDto    保存对象
     */
    public void saveSysRoleMenu(SysRoleMenuDto sysRoleMenuDto) {
        dao.saveSysRoleMenu(sysRoleMenuDto);
    }

    /**
     * 角色地域类型绑定
     * @param sysRoleAreatype    保存对象
     */
    public void saveSysRoleAreatype(SysRoleAreatype sysRoleAreatype) {
        dao.saveSysRoleAreatype(sysRoleAreatype);
    }

    /**
     * 通过菜单ID获得所有角色ID列表
     * @param menuId    菜单ID
     * @return    返回结果List
     */
    public List<Long> getRoleListByMenuId(Long menuId) {
        return dao.getRoleListByMenuId(menuId);
    }

    /**
     * 批量插入
     * @param list    更新list
     */
    public void sysRoleMenuBatchInsert(List<SysRoleMenuDto> list) {
        dao.sysRoleMenuBatchInsert(list);
    }

    /**
     * 批量删除
     * @param menuIds    菜单IDs
     * @return    操作结果
     */
    public int deleteRoleMenuByMenuIds(Long[] menuIds) {
        return dao.deleteRoleMenuByMenuIds(menuIds);
    }

    /**
     * 获取角色树
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    public List<TreeNode> getChildTree(TreeParam treeParam) {
        List<TreeNode> roles = new ArrayList<>();
        List<TreeNode> node = new ArrayList<>();
        String parentId = treeParam.getParentId();
        String regexJslx = "JSLX;.*";
        String regexJs = "JS;.*";
        //查角色分类
        if (StringUtils.isBlank(parentId)) {
            roles = dao.getCoreRoletypeChildTree(treeParam);
            roles = substrId(roles, node, PositionTypeEnum.JSLX.getKey());
            //通过分类查角色
        } else if (parentId.matches(regexJslx)) {
            String roletypeId = parentId.substring(parentId.indexOf(";") + 1);
            treeParam.setRoletypeId(roletypeId);
            treeParam.setParentId("");
            roles = dao.getSysRoleChildTree(treeParam);
            roles = substrId(roles, node, PositionTypeEnum.JS.getKey());
            //通过角色查角色
        } else if (parentId.matches(regexJs)) {
            String jsParentId = parentId.substring(parentId.indexOf(";") + 1);
            treeParam.setParentId(jsParentId);
            roles = dao.getSysRoleChildTree(treeParam);
            roles = substrId(roles, node, PositionTypeEnum.JS.getKey());
        }
        return roles;
    }

    public List<TreeNode> substrId(List<TreeNode> roles, List<TreeNode> node, String positionType) {
        for (TreeNode treeNode : roles) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(positionType);
            stringBuffer.append(";");
            stringBuffer.append(treeNode.getId());
            treeNode.setId(stringBuffer.toString());
            node.add(treeNode);
        }
        return node;
    }

    @Transactional
    public void saveOrUpdateMenu(Long roleId, List<Long> menuIds) {
        //先删除角色与菜单关系
        deleteMenuById(roleId);

        if (menuIds == null || menuIds.size() == 0) {
            return;
        }
        List<SysRoleMenuDto> insert = new ArrayList();
        //保存角色与菜单关系
        for (Long menuId : menuIds) {
            SysRoleMenuDto role = new SysRoleMenuDto();
            role.setRoleId(roleId);
            role.setMenuId(menuId);
            role.setMenuroleId(RandomUtils.randomLid());
            insert.add(role);
            if (insert.size() == 100) {
                sysRoleMenuBatchInsert(insert);
                insert = new ArrayList<>();
            }
        }
        if (insert.size() > 0) {
            sysRoleMenuBatchInsert(insert);
        }
    }

    @Transactional
    public void saveOrUpdateArea(Long roleId, List<String> areaTypeIds) {
        //先删除角色与地域关系
        deleteAreaById(roleId);

        if (areaTypeIds == null || areaTypeIds.size() == 0) {
            return;
        }
        //保存角色与地域关系
        dao.saveAreaById(
            new StringMap().put("roleId", roleId).put("areaTypeIds", areaTypeIds).map());

        for (String areaTypeId : areaTypeIds) {
            Map<String, Object> map = new HashMap<>();
            map.put("roleId", roleId);
            map.put("areaTypeId", areaTypeId);
            map.put("roleareaId", RandomUtils.randomLid());
            dao.saveAreaById(map);
        }
    }

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @param roletypeId    角色类型ID
     * @return    返回结果List
     */
    public List<DictionaryInitDto> getForSelect(@Param("roletypeId") String roletypeId) {
        return dao.getForSelect(roletypeId);
    }

    public int deleteMenuById(Long roleId) {
        return dao.deleteMenuById(roleId);
    }

    public int deleteMenuByIds(Long[] roleIds) {
        return dao.deleteMenuByIds(roleIds);
    }

    public int deleteAreaById(Long roleId) {
        return dao.deleteAreaById(roleId);
    }

    public int deleteAreaByIds(Long[] roleIds) {
        return dao.deleteAreaByIds(roleIds);
    }

}
