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
package net.linlan.authn.group.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.authn.group.dto.PositionCommParam;
import net.linlan.authn.group.dto.PositionSimpleDto;
import net.linlan.authn.group.dto.PublicGroupDto;
import net.linlan.authn.group.dto.PublicGroupPositionDto;
import net.linlan.authn.group.entity.PublicGroup;
import net.linlan.authn.group.param.PublicGroupParam;
import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.dto.TreeNode;

/**
*
* PublicGroup数据域:会员用户组持久层Dao
* @author Linlan
* CreateTime 2018-07-07 17:24:27
*
* @version 1.0
* @since 1.0
*
*/
@Mapper
public interface PublicGroupDao extends MybatisBaseDao<PublicGroup> {

    /** get the page of dto PublicGroupDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link PublicGroupParam }
     * @return 分页的通告数据 {@link Page} 对象，包含 {@link PublicGroupDto} 列表
     */
    Page<PublicGroupDto> getPageDto(PublicGroupParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link PublicGroupDto}
     * @param id the PublicGroup 组编号 | 1
     * @return {@link PublicGroupDto}
     */
    PublicGroupDto getDtoById(Long id);

    /**
     * 根据app获取会员组
     * @param map   查询条件
     * @return  列表对象
     */
    List<PublicGroup> getListByApp(Map<String, Object> map);

    /**
     * 根据groupCode获取信息
     * @param code  代码
     * @return  对象
     */
    PublicGroup getGroupByCode(@Param("code") String code);

    /**
     * 获取RoleTypeId
     * @param groupId   组ID
     * @return  通过组ID查询的权限分类ID
     */
    String getRoletypeId(@Param("groupId") String groupId);

    /** 通过字典CODE主键获取MemberGroup的ID和NAME，返回基本字典对象BaseDictionary
     * @param typeCode  字典代码
     * @return  组列表初始化字典
     */
    List<DictionaryInitDto> getPublicGroupSelect(String typeCode);

    List<TreeNode> getGroupList(@Param("appId") String appId,
                                @Param("roletypeId") String roletypeId);

    /**
     * 获取岗位列表
     * @param roletypeId   权限分类ID
     * @param groupId   组ID
     * @return  获取岗位列表
     */
    List<TreeNode> getPositionListByGroupId(@Param("roletypeId") String roletypeId,
                                            @Param("groupId") String groupId);

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @return      组列表初始化字典
     */
    List<DictionaryInitDto> getForSelect();

    void groupBindPosition(List<PublicGroupPositionDto> list);

    void groupUnBindPosition(String id);

    void groupUnBindPositionId(@Param("groupId") Long groupId, @Param("ids") List<String> ids);

    Page<PositionSimpleDto> getPositionList(PositionCommParam param);

    Page<PositionSimpleDto> getPositionListByRoleType(PositionCommParam param);

    Page<PositionSimpleDto> getPositionListByRole(PositionCommParam param);

    Page<PositionSimpleDto> getPositionListByPosition(PositionCommParam param);

}
