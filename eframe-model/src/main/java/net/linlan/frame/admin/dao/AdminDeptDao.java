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
import net.linlan.frame.admin.dto.AdminDeptDto;
import net.linlan.frame.admin.entity.AdminDept;
import net.linlan.frame.admin.param.AdminDeptParam;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.param.TreeParam;

/**
*
* AdminDept数据域:系统机构部门持久层Dao
* @author Linlan
* CreateTime 2024-10-02 23:27:08
*
*/
@Mapper
public interface AdminDeptDao extends MybatisBaseDao<AdminDept> {

    /** get the page of dto AdminDeptDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link AdminDeptParam }
     * @return 分页的部门数据 {@link Page} 对象，包含 {@link AdminDept} 列表
     */
    Page<AdminDeptDto> getPageDto(AdminDeptParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link AdminDeptDto}
     * @param id 单位ID|1
     * @return {@link AdminDeptDto}
     */
    AdminDeptDto getDtoById(Long id);

    /**
     * 查询部门管理数据
     *
     * @param dept 部门信息
     * @return 部门信息集合
     */
    public List<AdminDept> selectDeptList(AdminDept dept);

    /**
     * 根据角色ID查询部门树信息
     *
     * @param roleId 角色ID
     * @param deptCheckStrictly 部门树选择项是否关联显示
     * @return 选中部门列表
     */
    public List<Long> selectDeptListByRoleId(@Param("roleId") Long roleId,
                                             @Param("deptCheckStrictly") boolean deptCheckStrictly);

    /**
     * 根据ID查询所有子部门
     *
     * @param deptId 部门ID
     * @return 部门列表
     */
    public List<AdminDept> selectChildrenDeptById(Long deptId);

    /**
     * 根据ID查询所有子部门（正常状态）
     *
     * @param deptId 部门ID
     * @return 子部门数
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 是否存在子节点
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int hasChildByDeptId(Long deptId);

    /**
     * 查询部门是否存在用户
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * 校验部门名称是否唯一
     *
     * @param deptName 部门名称
     * @param parentId 父部门ID
     * @return 结果
     */
    public AdminDept checkDeptNameUnique(@Param("deptName") String deptName,
                                         @Param("parentId") Long parentId);

    /**
     * 新增部门信息
     *
     * @param dept 部门信息
     * @return 结果
     */
    public int insertDept(AdminDept dept);

    /**
     * 修改部门信息
     *
     * @param dept 部门信息
     * @return 结果
     */
    public int updateDept(AdminDept dept);

    /**
     * 修改所在部门正常状态
     *
     * @param deptIds 部门ID组
     */
    public void updateDeptStatusNormal(Long[] deptIds);

    /**
     * 修改子元素关系
     *
     * @param depts 子元素
     * @return 结果
     */
    public int updateDeptChildren(@Param("depts") List<AdminDept> depts);

    /**
     * 删除部门管理信息
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 获取所有部门数据
     *
     * @param treeParam 树查询参数
     * @return 结果
     */
    List<TreeNode> allDepttreeList(TreeParam treeParam);

}
