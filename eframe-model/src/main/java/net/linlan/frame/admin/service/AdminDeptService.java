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

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.admin.dao.AdminDeptDao;
import net.linlan.frame.admin.dto.AdminDeptDto;
import net.linlan.frame.admin.entity.AdminDept;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.param.AdminDeptParam;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.frame.web.model.TreeSelect;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.param.TreeParam;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.sys.role.service.SysRoleService;
import net.linlan.utils.constant.UserConstants;
import net.linlan.utils.exception.CommonException;
import net.linlan.utils.text.Convert;

/**
 *
 * AdminDept数据域:系统机构部门服务类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Service
@Slf4j
public class AdminDeptService {

    @Resource
    private AdminDeptDao   dao;
    @Resource
    private SysRoleService sysRoleService;

    /** get the list of entity AdminDept
     * 列表方法，返回分页的部门数据 {@link Page} 对象，包含 {@link AdminDept} 列表
     * @param map the input select conditions
     * @return 分页的部门数据 {@link Page} 对象，包含 {@link AdminDept} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<AdminDept> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link AdminDept}
     * @param id 单位ID|1
     * @return {@link AdminDept}
     */
    public AdminDept findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param adminDept the input adminDept
     */
    //@Transactional
    public void save(AdminDept adminDept) {
        adminDept.init();
        dao.save(adminDept);
    }

    /** batch save the entity with input list
     * 保存对象系统机构部门，批量保存list
     * @param list {@link AdminDept}
     */
    public void batchSave(List<AdminDept> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param adminDept the input adminDept
     */
    //@Transactional
    public void update(AdminDept adminDept) {
        dao.update(adminDept);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 单位ID|1
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
        if (ObjectUtils.isEmpty(ids)) {
            return;
        }
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

    /** get the page of dto AdminDeptDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link AdminDeptParam }
     * @return 分页的部门数据 {@link Page} 对象，包含 {@link AdminDept} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<AdminDeptDto> getPageDto(AdminDeptParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link AdminDeptDto}
     * @param id 单位ID|1
     * @return {@link AdminDeptDto}
     */
    public AdminDeptDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /**
     * 查询部门树结构信息
     *
     * @param dept 部门信息
     * @return 部门树信息集合
     */
    public List<TreeSelect> selectDeptTreeList(AdminDeptParam dept) {
        Page<AdminDeptDto> depts = getPageDto(dept);
        return buildDeptTreeSelect(depts);
    }

    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return 树结构列表
     */
    public List<AdminDept> buildDeptTree(Page<AdminDeptDto> depts) {
        List<AdminDept> returnList = new ArrayList<AdminDept>();
        List<Long> tempList = depts.stream().map(AdminDept::getId).collect(Collectors.toList());
        for (AdminDept dept : depts) {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId())) {
                recursionFn(depts, dept);
                returnList.add(dept);
            }
        }
        return returnList;
    }

    /**
     * 构建前端所需要下拉树结构
     *
     * @param depts 部门列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildDeptTreeSelect(Page<AdminDeptDto> depts) {
        List<AdminDept> deptTrees = buildDeptTree(depts);
        return deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 根据角色ID查询部门树信息
     *
     * @param roleId 角色ID
     * @return 选中部门列表
     */
    public List<Long> selectDeptListByRoleId(Long roleId) {
        SysRole role = sysRoleService.findById(roleId);
        return dao.selectDeptListByRoleId(roleId,
            ObjectUtils.isNotEmpty(role) ? role.getIsPublic() : false);
    }

    /**
     * 根据ID查询所有子部门（正常状态）
     *
     * @param deptId 部门ID
     * @return 子部门数
     */
    public int selectNormalChildrenDeptById(Long deptId) {
        return dao.selectNormalChildrenDeptById(deptId);
    }

    /**
     * 是否存在子节点
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public boolean hasChildByDeptId(Long deptId) {
        int result = dao.hasChildByDeptId(deptId);
        return result > 0;
    }

    /**
     * 查询部门是否存在用户
     *
     * @param deptId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId) {
        int result = dao.checkDeptExistUser(deptId);
        return result > 0;
    }

    /**
     * 校验部门名称是否唯一
     *
     * @param dept 部门信息
     * @return 结果
     */
    public boolean checkDeptNameUnique(AdminDept dept) {
        Long deptId = ObjectUtils.isEmpty(dept.getId()) ? -1L : dept.getId();
        AdminDept info = dao.checkDeptNameUnique(dept.getName(), dept.getParentId());
        if (ObjectUtils.isNotEmpty(info) && info.getId().longValue() != deptId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验部门是否有数据权限
     *
     * @param deptId 部门id
     */
    public void checkDeptDataScope(Long deptId) {
        if (!AdminUser.isAdmin(SecurityUtils.getAdminId()) && ObjectUtils.isNotEmpty(deptId)) {
            AdminDeptParam param = new AdminDeptParam();
            param.setDeptId(deptId);
            Page<AdminDeptDto> depts = getPageDto(param);
            if (ObjectUtils.isEmpty(depts)) {
                throw new CommonException("没有权限访问部门数据！");
            }
        }
    }

    /**
     * 新增保存部门信息
     *
     * @param dept 部门信息
     * @return 结果
     */
    public int insertDept(AdminDept dept) {
        AdminDept info = dao.findById(dept.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if (!UserConstants.DEPT_NORMAL.equals(info.getDelFlag())) {
            throw new CommonException("部门停用，不允许新增");
        }
        dept.setSearchCode(info.getSearchCode() + "," + dept.getParentId());
        return dao.insertDept(dept);
    }

    /**
     * 修改保存部门信息
     *
     * @param dept 部门信息
     * @return 结果
     */
    public int updateDept(AdminDept dept) {
        AdminDept newParentDept = dao.findById(dept.getParentId());
        AdminDept oldDept = dao.findById(dept.getId());
        if (ObjectUtils.isNotEmpty(newParentDept) && ObjectUtils.isNotEmpty(oldDept)) {
            String newAncestors = newParentDept.getSearchCode() + "," + newParentDept.getId();
            String oldAncestors = oldDept.getSearchCode();
            dept.setSearchCode(newAncestors);
            updateDeptChildren(dept.getId(), newAncestors, oldAncestors);
        }
        int result = dao.updateDept(dept);
        if (UserConstants.DEPT_NORMAL.equals(dept.getDelFlag())
            && ObjectUtils.isNotEmpty(dept.getSearchCode())
            && !StringUtils.equals("0", dept.getSearchCode())) {
            // 如果该部门是启用状态，则启用该部门的所有上级部门
            updateParentDeptStatusNormal(dept);
        }
        return result;
    }

    /**
     * 修改该部门的父级部门状态
     *
     * @param dept 当前部门
     */
    private void updateParentDeptStatusNormal(AdminDept dept) {
        String searchCode = dept.getSearchCode();
        Long[] deptIds = Convert.toLongArray(searchCode);
        dao.updateDeptStatusNormal(deptIds);
    }

    /**
     * 修改子元素关系
     *
     * @param deptId 被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateDeptChildren(Long deptId, String newAncestors, String oldAncestors) {
        List<AdminDept> children = dao.selectChildrenDeptById(deptId);
        for (AdminDept child : children) {
            child.setSearchCode(child.getSearchCode().replaceFirst(oldAncestors, newAncestors));
        }
        if (children.size() > 0) {
            dao.updateDeptChildren(children);
        }
    }

    /**
     * 通过机构ID删除部门信息
     *
     * @param organId 机构ID
     * @return 结果
     */
    public int deleteByOrganId(String organId) {
        return dao.deleteByOrganId(organId);
    }

    /**
     * 递归列表
     * @param list 部门list
     * @param t 部们
     */
    private void recursionFn(Page<AdminDeptDto> list, AdminDept t) {
        // 得到子节点列表
        List<AdminDept> childList = getChildList(list, t);
        t.setChildren(childList);
        for (AdminDept tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     * @param list 部门list
     * @param t 部们
     * @return 部门列表
     */
    private List<AdminDept> getChildList(Page<AdminDeptDto> list, AdminDept t) {
        List<AdminDept> tlist = new ArrayList<AdminDept>();
        Iterator<AdminDeptDto> it = list.iterator();
        while (it.hasNext()) {
            AdminDept n = (AdminDept) it.next();
            if (ObjectUtils.isNotEmpty(n.getParentId())
                && n.getParentId().longValue() == t.getId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     * @param list 部门list
     * @param t 部们
     * @return 是否有子节点
     */
    private boolean hasChild(Page<AdminDeptDto> list, AdminDept t) {
        return getChildList(list, t).size() > 0;
    }

    /**
     * 一次性获取所有的有层次的菜单树
     * @param treeParam 查询树参数
     * @return 树列表
     */
    public List<TreeNode> allDepttreeList(TreeParam treeParam) {
        List<TreeNode> allTreeNodes = dao.allDepttreeList(treeParam);
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
     * 通过机构ID查询机构
     *
     * @param organId 机构ID
     * @return 对象信息
     */
    public AdminDeptDto getByOrganId(String organId) {
        return dao.getByOrganId(organId);
    }

    /**
     * 通过机构名称查询机构
     *
     * @param name 机构名称
     * @return 对象信息
     */
    public AdminDeptDto getByName(String name) {
        return dao.getByName(name);
    }

    /** 通过条件组合查询全部的list，返回Dto对象
     * @param param 查询条件
     * @return  对象列表
     */
    public List<AdminDeptDto> getListByParam(AdminDeptParam param) {
        return dao.getListByParam(param);
    }

}
