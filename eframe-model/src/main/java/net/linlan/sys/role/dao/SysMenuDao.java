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
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.role.dto.SysMenuDto;
import net.linlan.sys.role.dto.SysMenuListDto;
import net.linlan.sys.role.dto.SysMenuTreeDto;
import net.linlan.sys.role.entity.SysMenu;
import net.linlan.sys.role.param.MenuTreeParam;
import net.linlan.sys.role.param.SysMenuParam;

/**
*
* SysMenu数据域:系统菜单持久层Dao
* @author Linlan
* CreateTime 2017-10-17 14:21:37
*
*/
@Mapper
public interface SysMenuDao extends MybatisBaseDao<SysMenu> {

    /** get the page of dto SysMenuDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link SysMenuParam }
     * @return 分页的系统菜单数据 {@link Page} 对象，包含 {@link SysMenu} 列表
     */
    Page<SysMenuDto> getPageDto(SysMenuParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link SysMenuDto}
     * @param id the input id
     * @return {@link SysMenuDto}
     */
    SysMenuDto getDtoById(Long id);

    List<Long> getMenuIds(Map<String, Object> map);

    List<SysMenu> getListForSider(Map<String, Object> map);

    List<SysMenuTreeDto> menuStatusZtreeList(Map<String, Object> map);

    List<TreeNode> allMenutreeList(MenuTreeParam menuParam);

    List<SysMenuTreeDto> menuInitializeZtreeList(Map<String, Object> map);

    List<SysMenuTreeDto> getMenuByRole(Map<String, Object> map);

    Long maxMenuId();

    void saveMenuById(Map<String, Object> map);

    int deleteByAppId(String appId);

    void saveList(List<SysMenu> sysMenuList);

    /**
     * 通过Code(外键)查询记录
     * @param code    代码
     * @return    查询结果
     */
    SysMenu findByCode(String code);

    /**
     * 通过codes拿到menuId列表
     * @param codes  查询codes
     * @return  查询结果
     */
    List<Long> getListByCodes(String[] codes);

    /**
     * 获取简略的列表
     * @param sysMenuParam  查询对象
     * @return  查询结果
     */
    Page<SysMenuListDto> getSimpleList(SysMenuParam sysMenuParam);

    /**
     * 获取菜单树
     * @param menuTreeParam  菜单树查询对象
     * @return  查询结果
     */
    List<TreeNode> getMenuChildTree(MenuTreeParam menuTreeParam);

    /**
     * 是否存在菜单子节点
     *
     * @param parentId 菜单ID
     * @return 结果
     */
    public int hasChildByParentId(Long parentId);

    /**
     * 校验菜单名称是否唯一
     *
     * @param name 菜单名称
     * @param parentId 父菜单ID
     * @return 结果
     */
    public SysMenu checkNameUnique(@Param("name") String name, @Param("parentId") Long parentId);
}
