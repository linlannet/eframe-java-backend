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
package net.linlan.frame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.admin.dto.AdminMenuVo;
import net.linlan.frame.admin.param.AdminMenuVoParam;
import net.linlan.sys.role.dto.SysMenuButtonDto;

/**
 * 菜单表 数据层
 *
 * @author Linlan
 */
@Mapper
public interface AdminMenuDao extends MybatisBaseDao<AdminMenuVo> {
    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    List<AdminMenuVo> selectMenuList(AdminMenuVoParam menu);

    /**
     * 查询系统菜单分页
     * @param menu 菜单信息
     * @return 菜单列表
     */
    Page<AdminMenuVo> selectMenuListPage(AdminMenuVoParam menu);

    /**
     * 根据用户所有权限
     *
     * @param currAppId 当前应用ID
     * @return 权限列表
     */
    List<String> selectMenuPerms(@Param("currAppId") String currAppId);

    /**
     * 根据用户查询系统菜单列表
     *
     * @param adminId 管理员ID
     * @param currAppId 当前应用ID
     * @return 菜单列表
     */
    List<AdminMenuVo> selectMenuListByAdminId(@Param("adminId") Long adminId,
                                              @Param("currAppId") String currAppId);

    /**
     * 根据角色ID查询权限
     *
     * @param roleId 角色ID
     * @param currAppId 当前应用ID
     * @return 权限列表
     */
    List<String> selectMenuPermsByRoleId(@Param("roleId") Long roleId,
                                         @Param("currAppId") String currAppId);

    /**
     * 根据用户LID查询权限
     *
     * @param adminId 用户LID
     * @param currAppId 当前应用ID
     * @return 权限列表
     */
    List<String> selectMenuPermsByAdminId(@Param("adminId") Long adminId,
                                          @Param("currAppId") String currAppId);

    /**
     * 根据用户LID查询菜单
     *
     * @return 菜单列表
     */
    List<AdminMenuVo> selectMenuTreeAll();

    /**
     * 根据用户LID查询菜单
     *
     * @param adminId 用户LID
     * @param currAppId 当前应用ID
     * @return 菜单列表
     */
    List<AdminMenuVo> selectMenuTreeByAdminId(@Param("adminId") Long adminId,
                                              @Param("currAppId") String currAppId);

    /**
     * 根据父节点删除子节点
     *
     * @param parentId 用户LID
     */
    void deleteByParentId(Long parentId);

    /**
     * 根据父节点查询子节点
     *
     * @param parentId 用户LID
     * @return 菜单列表
     */
    int hasChildByParentId(Long parentId);

    /**
     * 某个菜单下有权限的按钮
     * @param menuId    菜单ID
     * @return  菜单列表
     */
    List<SysMenuButtonDto> getButtons(@Param("menuId") Long menuId);

    /**
     * 根据角色ID查询菜单树信息
     *
     * @param roleId 角色ID
     * @param menuCheckStrictly 菜单树选择项是否关联显示
     * @param currAppId 当前应用ID
     * @return 选中菜单列表
     */
    List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId,
                                      @Param("menuCheckStrictly") boolean menuCheckStrictly,
                                      @Param("currAppId") String currAppId);

}
