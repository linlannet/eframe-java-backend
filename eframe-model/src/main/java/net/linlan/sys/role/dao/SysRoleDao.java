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
package net.linlan.sys.role.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.param.TreeParam;
import net.linlan.sys.role.dto.RoleTypeCode;
import net.linlan.sys.role.dto.SysRoleDto;
import net.linlan.sys.role.dto.SysRoleListDto;
import net.linlan.sys.role.dto.SysRoleMenuDto;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.sys.role.entity.SysRoleAreatype;
import net.linlan.sys.role.param.SysRoleParam;

/**
*
* SysRole数据域:系统角色持久层Dao
* @author Linlan
* CreateTime 2017-10-17 14:21:37
*
*/
@Mapper
public interface SysRoleDao extends MybatisBaseDao<SysRole> {

    /** get the page of dto SysRoleDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link SysRoleParam }
     * @return 分页的系统角色数据 {@link Page} 对象，包含 {@link SysRole} 列表
     */
    Page<SysRoleDto> getPageDto(SysRoleParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link SysRoleDto}
     * @param id the input id
     * @return {@link SysRoleDto}
     */
    SysRoleDto getDtoById(Long id);

    List<Long> getMenuIds(Long roleId);

    void saveMenuById(Map<String, Object> map);

    void saveAreaById(Map<String, Object> map);

    int deleteMenuById(Long roleId);

    int deleteMenuByIds(Long[] roleIds);

    int deleteAreaById(Long roleId);

    int deleteAreaByIds(Long[] roleIds);

    /** 通过传入的map条件，进行list获取，得到的list采用RoleTypeCode作为信息进行树结构展示
     * @param map    查询map
     * @return    返回结果List
     */
    List<RoleTypeCode> getTreeByRoletype(Map<String, Object> map);

    List<RoleTypeCode> getRoletypeList(Map<String, Object> map);

    /**
     * 角色菜单绑定
     * @param sysRoleMenuDto    保存对象
     */
    void saveSysRoleMenu(SysRoleMenuDto sysRoleMenuDto);

    /**
     * 角色地域类型绑定
     * @param sysRoleAreatype    保存对象
     */
    void saveSysRoleAreatype(SysRoleAreatype sysRoleAreatype);

    /**
     * 通过菜单ID获得所有角色ID列表
     * @param menuId    菜单ID
     * @return    返回结果List
     */
    List<Long> getRoleListByMenuId(Long menuId);

    /**
     * 批量保存
     * @param list  更新list
     */
    void sysRoleMenuBatchInsert(@Param("list") List<SysRoleMenuDto> list);

    /**
     * 通过menuIds批量删除绑定关系
     * @param menuIds    菜单IDs
     * @return  删除结果
     */
    int deleteRoleMenuByMenuIds(Long[] menuIds);

    List<TreeNode> getCoreRoletypeChildTree(TreeParam treeParam);

    List<TreeNode> getSysRoleChildTree(TreeParam treeParam);

    Page<SysRoleListDto> getSysMenuList(SysRoleParam param);

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @param roletypeId    角色类型ID
     * @return    返回结果List
     */
    List<DictionaryInitDto> getForSelect(@Param("roletypeId") String roletypeId);

}
