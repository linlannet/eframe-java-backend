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
import net.linlan.sys.role.dto.PositionSearchCodeDto;
import net.linlan.sys.role.dto.PositionSelectDto;
import net.linlan.sys.role.dto.RoleTypeCode;
import net.linlan.sys.role.dto.SysPositionDto;
import net.linlan.sys.role.entity.SysPosition;
import net.linlan.sys.role.entity.SysRolePosition;
import net.linlan.sys.role.param.SysPositionParam;

/**
*
* SysPosition数据域:岗位信息持久层Dao
* @author Linlan
* CreateTime 2019-11-25 12:13:00
*
*/
@Mapper
public interface SysPositionDao extends MybatisBaseDao<SysPosition> {

    /** get the page of dto SysPositionDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link SysPositionParam }
     * @return 分页的系统岗位数据 {@link Page} 对象，包含 {@link SysPosition} 列表
     */
    Page<SysPositionDto> getPageDto(SysPositionParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link SysPositionDto}
     * @param id the input id
     * @return {@link SysPositionDto}
     */
    SysPositionDto getDtoById(String id);

    /** 通过传入的positonId和roleIds、status查询岗位已经绑定的角色
     * @param map    查询map
     * @return    返回结果List
     */
    List<SysRolePosition> getRoleListById(Map<String, Object> map);

    /** 通过传入的主键ids列表，删除岗位角色关联关系
     * @param ids    ID列表
     */
    void deleteRolePositionByIds(Long[] ids);

    /** 通过主键ID删除岗位角色关联关系
     * @param id    主键ID
     */
    void deleteRolePositionById(String id);

    /** 批量保存岗位角色关联关系
     * @param list    更新list
     */
    void batchSaveRolePosition(List<SysRolePosition> list);

    /** 保存单个岗位角色关联关系
     * @param sysRolePosition    查询对象
     */
    void saveRolePosition(SysRolePosition sysRolePosition);

    /** 通过岗位类型查询角色树结构
     * @param map    查询map
     * @return    返回结果List
     */
    List<RoleTypeCode> getTreeByPostype(Map<String, Object> map);

    /** 通过传入的岗位ids列表，删除岗位角色关联关系
     * @param ids    ID列表
     */
    void deleteByPositionIds(String[] ids);

    /** 通过岗位ID删除岗位角色关联关系
     * @param id    主键ID
     */
    void deleteByPositionId(String id);

    /** 通过岗位ID查询查询码对象
     * @param positionId    岗位ID
     * @return    返回结果
     */
    PositionSearchCodeDto findSearchCodeByPositionId(@Param("positionId") String positionId);

    /** 查询岗位下列组件的列表信息
     * @param params    查询参数
     * @return  查询结果
     */
    Page<PositionSelectDto> getPositionSelect(SysPositionParam params);

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @return    返回结果List
     */
    List<DictionaryInitDto> getForSelect();

    Page<SysPositionDto> getPositionList(SysPositionParam param);

    Page<SysPositionDto> getPositionListByRoleType(SysPositionParam param);

    Page<SysPositionDto> getPositionListByRole(SysPositionParam param);

    Page<SysPositionDto> getPositionListByPosition(SysPositionParam param);

    /** 岗位树第一层角色类型获取树节点
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    List<TreeNode> getSysRoletypeChildTree(TreeParam treeParam);

    /** 岗位树第二层角色获取树节点
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    List<TreeNode> getAdminRoleChildTree(TreeParam treeParam);

    /** 岗位树第三层父岗位获取树节点
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    List<TreeNode> getSysPositionParentTree(TreeParam treeParam);

    /** 通过parentId、roletypeId等条件查询岗位的子节点树
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    List<TreeNode> getSysPositionChildTree(TreeParam treeParam);

    /** 查询岗位树单表模式返回列表节点树
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    List<TreeNode> getSingleSysPositionParentTree(TreeParam treeParam);

}
