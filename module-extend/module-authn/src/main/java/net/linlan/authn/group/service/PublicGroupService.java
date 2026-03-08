/*
 * module-authn - 动态认证对接模块
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
package net.linlan.authn.group.service;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.authn.group.dao.PublicGroupDao;
import net.linlan.authn.group.dto.PositionCommParam;
import net.linlan.authn.group.dto.PositionSimpleDto;
import net.linlan.authn.group.dto.PublicGroupDto;
import net.linlan.authn.group.dto.PublicGroupPositionDto;
import net.linlan.authn.group.entity.PublicGroup;
import net.linlan.authn.group.param.PublicGroupParam;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.service.BaseAppService;
import net.linlan.sys.web.KernelAdminUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;

/**
 *
 * PublicGroup数据域:会员用户组服务类
 * @author Linlan
 * CreateTime 2018-07-07 17:24:27
 *
 */
@Service
@Slf4j
public class PublicGroupService {

    @Resource
    private PublicGroupDao                   dao;
    @Resource
    private RedisService                     redisService;

    @Resource
    private BaseAppService                   baseAppService;
    /**
     * redis 字典缓存前缀
     */
    public static final String               DIC_PREFIX = "DIC:";
    /**
     * 避免循环走redis，内存直接读，1小时清空重新拿
     */
    private Map<String, Map<String, String>> dics       = new HashMap<>();
    /**
     * 角色类型缓存键值
     */
    private static final String              ROLE_TYPE  = "ROLE_TYPE:";

    /** get the list of entity PublicGroup
     * 列表方法，{@link List} 对象，包含 {@link PublicGroup} 列表
     * @param map the input select conditions
     * @return {@link List} 对象，包含 {@link PublicGroup} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<PublicGroup> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link PublicGroup}
     * @param id the PublicGroup 组编号 | 1
     * @return {@link PublicGroup}
     */
    public PublicGroup findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param publicGroup the input publicGroup
     */
    //@Transactional
    public void save(PublicGroup publicGroup) {
        publicGroup.init();
        dao.save(publicGroup);
    }

    /** save the entity with input list
     * 保存对象会员用户组，批量保存list
     * @param list {@link PublicGroup}
     */
    public void batchSave(List<PublicGroup> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param publicGroup the input publicGroup
     */
    //@Transactional
    public void update(PublicGroup publicGroup) {
        dao.update(publicGroup);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the PublicGroup 组编号 | 1
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

    /** get the page of dto PublicGroupDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link PublicGroupParam }
     * @return 分页的通告数据 {@link Page} 对象，包含 {@link PublicGroupDto} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<PublicGroupDto> getPageDto(PublicGroupParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link PublicGroupDto}
     * @param id the PublicGroup 组编号 | 1
     * @return {@link PublicGroupDto}
     */
    public PublicGroupDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /**
     * 根据app获取会员组
     * @param map   查询条件
     * @return  列表对象
     */
    public List<PublicGroup> getListByApp(Map<String, Object> map) {
        KernelAdminUtils.dealIsDisabledParam(map);
        return dao.getListByApp(map);
    }

    /**
     * 根据appId获取应用默认会员组
     * @param appId 应用ID
     * @return  默认组
     */
    public PublicGroup getCommonMemberGroup(String appId) {
        if (StringUtils.isNotBlank(appId)) {
            Map<String, Object> map = new HashMap<>();
            map.put("appId", appId);
            map.put("isCommonGroup", 1);
            List<PublicGroup> publicGroupList = getList(map);
            if (null != publicGroupList && publicGroupList.size() > 0) {
                return publicGroupList.get(0);
            }
        }
        return null;
    }

    public PublicGroup getGroupByCode(String code) {
        return dao.getGroupByCode(code);
    }

    /**
     * 获取RoleTypeId
     * @param groupId   组ID
     * @return  通过组ID查询的权限分类ID
     */
    public String getRoletypeId(String groupId) {
        String result = redisService.get(ROLE_TYPE + groupId);
        if (StringUtils.isEmpty(result)) {
            result = dao.getRoletypeId(groupId);
            if (StringUtils.isNotEmpty(result)) {
                redisService.set(ROLE_TYPE + groupId, result, KernelConstant.TEN_MINUTE_EXPIRE);
            }
        }
        return result;
    }

    /** 通过字典CODE主键获取MemberGroup的ID和NAME，返回基本字典对象BaseDictionary
     * @param typeCode  字典代码
     * @return  组列表初始化字典
     */
    public List<DictionaryInitDto> getPublicGroupSelect(String typeCode) {
        return dao.getPublicGroupSelect(typeCode);
    }

    public List<TreeNode> getGroupList(@Param("appId") String appId,
                                       @Param("roletypeId") String roletypeId) {
        return dao.getGroupList(appId, roletypeId);
    }

    /**
     * 获取岗位列表
     * @param roletypeId   权限分类ID
     * @param groupId   组ID
     * @return  获取岗位列表
     */
    public List<TreeNode> getPositionListByGroupId(@Param("roletypeId") String roletypeId,
                                                   @Param("groupId") String groupId) {
        return dao.getPositionListByGroupId(roletypeId, groupId);
    }

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @return      组列表初始化字典
     */
    public List<DictionaryInitDto> getForSelect() {
        return dao.getForSelect();
    }

    /**
     * 会员组绑定
     * @param list  绑定输入列表
     */
    public void groupBindPosition(List<PublicGroupPositionDto> list) {
        dao.groupBindPosition(list);
    }

    /**
     * 会员组解绑
     * @param groupId  分组ID
     */
    public void groupUnBindPosition(Long groupId) {
        dao.groupUnBindPosition(groupId);
    }

    public void groupUnBindPositionId(Long groupId, List<String> ids) {
        dao.groupUnBindPositionId(groupId, ids);
    }

    /**
     * 获取岗位列表
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<PositionSimpleDto> getPositionList(PositionCommParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPositionList(param);
    }

    /**
     * 获取岗位列表  通过角色分类
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<PositionSimpleDto> getPositionListByRoleType(PositionCommParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPositionListByRoleType(param);
    }

    /**
     * 获取岗位列表  通过角色
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<PositionSimpleDto> getPositionListByRole(PositionCommParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPositionListByRole(param);
    }

    /**
     * 获取岗位列表  通过岗位
     * @param param 查询条件
     * @return    返回分页
     */
    public Page<PositionSimpleDto> getPositionListByPosition(PositionCommParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPositionListByPosition(param);
    }

}
