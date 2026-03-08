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
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.constant.PositionTypeEnum;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.param.TreeParam;
import net.linlan.sys.role.dao.SysPositionDao;
import net.linlan.sys.role.dto.PositionSearchCodeDto;
import net.linlan.sys.role.dto.PositionSelectDto;
import net.linlan.sys.role.dto.RoleTypeCode;
import net.linlan.sys.role.dto.SysPositionDto;
import net.linlan.sys.role.entity.SysPosition;
import net.linlan.sys.role.entity.SysRolePosition;
import net.linlan.sys.role.param.SysPositionParam;

/**
 *
 * SysPosition数据域:岗位信息服务类
 * @author Linlan
 * CreateTime 2019-11-25 12:13:00
 *
 */
@Service
@Slf4j
public class SysPositionService {

    @Resource
    private SysPositionDao dao;

    /** get the list of entity SysPosition
     * 列表方法，返回列表的岗位数据 {@link List} 对象，包含 {@link SysPosition} 列表
     * @param map the input select conditions
     * @return 列表的岗位数据 {@link List} 对象，包含 {@link SysPosition} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<SysPosition> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link SysPosition}
     * @param id the input id
     * @return {@link SysPosition}
     */
    public SysPosition findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param sysPosition the input sysPosition
     */
    //@Transactional
    public void save(SysPosition sysPosition) {
        sysPosition.init();
        dao.save(sysPosition);
    }

    /** save the entity with input list
     * 保存对象岗位信息，批量保存list
     * @param list {@link SysPosition}
     */
    public void batchSave(List<SysPosition> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param sysPosition the input sysPosition
     */
    //@Transactional
    public void update(SysPosition sysPosition) {
        dao.update(sysPosition);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the input id
     */
    public void deleteById(String id) {
        if (StringUtils.isBlank(id)) {
            return;
        }
        dao.deleteById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    //@Transactional
    public void deleteByIds(String[] ids) {
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

    /** get the page of dto SysPositionDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link SysPositionParam }
     * @return 分页的系统岗位数据 {@link Page} 对象，包含 {@link SysPosition} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<SysPositionDto> getPageDto(SysPositionParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link SysPositionDto}
     * @param id the input id
     * @return {@link SysPositionDto}
     */
    public SysPositionDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    /** 通过岗位类型查询角色树结构
     * @param map    查询map
     * @return    返回结果List
     */
    public List<RoleTypeCode> getTreeByPostype(Map<String, Object> map) {
        return this.dao.getTreeByPostype(map);
    }

    /** 通过传入的positonId和roleIds、status查询岗位已经绑定的角色
     * @param map    查询map
     * @return    返回结果List
     */
    public List<SysRolePosition> getRoleListById(Map<String, Object> map) {
        return dao.getRoleListById(map);
    }

    /** 通过传入的主键ids列表，删除岗位角色关联关系
     * @param ids    ID列表
     */
    public void deleteRolePositionByIds(Long[] ids) {
        dao.deleteRolePositionByIds(ids);
    }

    /** 批量保存岗位角色关联关系
     * @param list    更新list
     */
    public void batchSaveRolePosition(List<SysRolePosition> list) {
        dao.batchSaveRolePosition(list);
    }

    /** 保存单个岗位角色关联关系
     * @param sysRolePosition    查询对象
     */
    public void saveRolePosition(SysRolePosition sysRolePosition) {
        dao.saveRolePosition(sysRolePosition);
    }

    /** 通过主键ID删除岗位角色关联关系
     * @param id    主键ID
     */
    public void deleteRolePositionById(String id) {
        dao.deleteRolePositionById(id);
    }

    /** 通过传入的岗位ids列表，删除岗位角色关联关系
     * @param ids    ID列表
     */
    public void deleteByPositionIds(String[] ids) {
        dao.deleteByPositionIds(ids);
    }

    /** 通过岗位ID删除岗位角色关联关系
     * @param id    主键ID
     */
    public void deleteByPositionId(String id) {
        dao.deleteByPositionId(id);
    }

    /** 通过岗位ID查询查询码对象
     * @param positionId    岗位ID
     * @return    查询结果
     */
    public PositionSearchCodeDto findSearchCodeByPositionId(@Param("positionId") String positionId) {
        return dao.findSearchCodeByPositionId(positionId);
    }

    /** 查询岗位下列组件的列表信息
     * @param params    查询参数
     * @return  查询结果
     */
    public Page<PositionSelectDto> getPositionSelect(SysPositionParam params) {
        return this.dao.getPositionSelect(params);
    }

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @return    返回结果List
     */
    public List<DictionaryInitDto> getForSelect() {
        return dao.getForSelect();
    }

    /**
     * 获取岗位列表
     * @param param    查询参数
     * @return  查询结果
     */
    public Page<SysPositionDto> getPositionList(SysPositionParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPositionList(param);
    }

    /**
     * 获取岗位列表  通过角色分类
     * @param param    查询参数
     * @return  查询结果
     */
    public Page<SysPositionDto> getPositionListByRoleType(SysPositionParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPositionListByRoleType(param);
    }

    /**
     * 获取岗位列表  通过角色
     * @param param    查询参数
     * @return  查询结果
     */
    public Page<SysPositionDto> getPositionListByRole(SysPositionParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPositionListByRole(param);
    }

    /**
     * 获取岗位列表  通过岗位
     * @param param    查询参数
     * @return  查询结果
     */
    public Page<SysPositionDto> getPositionListByPosition(SysPositionParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPositionListByPosition(param);
    }

    /**
     * 获取岗位树(完整树)
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    public List<TreeNode> getChildTree(TreeParam treeParam) {
        List<TreeNode> organs = new ArrayList<>();
        String parentId = treeParam.getParentId();
        String regexJslx = "JSLX;.*";
        String regexJs = "JS;.*";
        String regexFgw = "FGW;.*";
        String regexZgw = "ZGW;.*";
        //根据parentId来匹配进入哪个方法
        if (StringUtils.isBlank(parentId)) {
            organs = dao.getSysRoletypeChildTree(treeParam);
            organs = substrId(organs, PositionTypeEnum.JSLX.getKey());
            parentId = "";
        }
        if (parentId.matches(regexJslx)) {
            String jsParentId = parentId.substring(parentId.indexOf(";") + 1);
            treeParam.setRoletypeId(jsParentId);
            organs = dao.getAdminRoleChildTree(treeParam);
            organs = substrId(organs, PositionTypeEnum.JS.getKey());
        }
        if (parentId.matches(regexJs)) {
            String fgwParentId = parentId.substring(parentId.indexOf(";") + 1);
            treeParam.setRoleId(fgwParentId);
            organs = dao.getSysPositionParentTree(treeParam);
            organs = substrId(organs, PositionTypeEnum.FGW.getKey());
        }
        if (parentId.matches(regexFgw)) {
            String zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
            treeParam.setParentId(zgwParentId);
            organs = dao.getSysPositionChildTree(treeParam);
            organs = substrId(organs, PositionTypeEnum.ZGW.getKey());
        }
        if (parentId.matches(regexZgw)) {
            String zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
            treeParam.setParentId(zgwParentId);
            organs = dao.getSysPositionChildTree(treeParam);
            organs = substrId(organs, PositionTypeEnum.ZGW.getKey());
        }
        return organs;
    }

    /** 查询岗位树单表模式返回列表节点树
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    public List<TreeNode> getSingleChildTree(TreeParam treeParam) {
        List<TreeNode> organs = new ArrayList<>();
        String parentId = treeParam.getParentId();
        String regexFgw = "FGW;.*";
        String regexZgw = "ZGW;.*";
        //根据parentId来匹配进入哪个方法
        if (StringUtils.isBlank(parentId)) {
            organs = dao.getSingleSysPositionParentTree(treeParam);
            organs = substrId(organs, PositionTypeEnum.FGW.getKey());
            parentId = "";
        }
        if (parentId.matches(regexFgw)) {
            String zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
            treeParam.setParentId(zgwParentId);
            organs = dao.getSysPositionChildTree(treeParam);
            organs = substrId(organs, PositionTypeEnum.ZGW.getKey());
        }
        if (parentId.matches(regexZgw)) {
            String zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
            treeParam.setParentId(zgwParentId);
            organs = dao.getSysPositionChildTree(treeParam);
            organs = substrId(organs, PositionTypeEnum.ZGW.getKey());
        }
        return organs;
    }

    //对回显ID进行处理
    public List<TreeNode> substrId(List<TreeNode> organs, String positionType) {
        List<TreeNode> node = new ArrayList<>();
        for (TreeNode treeNode : organs) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(positionType);
            stringBuffer.append(";");
            stringBuffer.append(treeNode.getId());
            treeNode.setId(stringBuffer.toString());
            node.add(treeNode);
        }
        return node;
    }
}
