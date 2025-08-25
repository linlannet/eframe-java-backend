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
package net.linlan.sys.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.BaseXzqhDto;
import net.linlan.sys.base.dto.BaseXzqhListDto;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.dto.XzqhInitDto;
import net.linlan.sys.base.entity.BaseXzqh;
import net.linlan.sys.base.param.BaseXzqhParam;
import net.linlan.sys.base.param.TreeParam;

/**
*
* BaseXzqh数据域:行政区划持久层Dao
* @author Linlan
* CreateTime 2018-03-02 17:17:54
*
*/
@Mapper
public interface BaseXzqhDao extends MybatisBaseDao<BaseXzqh> {

    /** get the page of dto BaseXzqhDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseXzqhParam }
     * @return 分页的基础行政区划数据 {@link Page} 对象，包含 {@link BaseXzqh} 列表
     */
    Page<BaseXzqhDto> getPageDto(BaseXzqhParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseXzqhDto}
     * @param id 行政区划编号|1
     * @return {@link BaseXzqhDto}
     */
    BaseXzqhDto getDtoById(Long id);

    /** 通过父ID获取下级节点，返回Dto对象列表
     * @param id    主键ID
     * @return    查询对象
     */
    List<BaseXzqhDto> getDtoByParentId(Long id);

    /** 通过code查询对象，返回单个Dto对象
     * @param code    代码
     * @return    查询结果
     */
    BaseXzqhDto getDtoByCode(String code);

    /** 查找集合下所有的本身加上下一级子集的结果
     * @param list  当前列表
     * @return  下一级子集
     */
    List<BaseXzqh> getListSelfAndChildren(List list);

    /**
     * 根据appId、地域类型获取行政区划
     * @param params    查询参数
     * @return  查询结果
     */
    BaseXzqh getXzqhByAppAndAreaType(Map<String, Object> params);

    /** 通过父ID获取基础行政区划子节点
     * @param parendId  父节点ID
     * @return  原始行政区划
     */
    List<XzqhInitDto> getChildren(Long parendId);

    /** 通过条件获取树结构行政区划节点
     * @param treeParam 树参数
     * @return  树列表
     */
    List<TreeNode> getXzqhChildren(TreeParam treeParam);

    /** 通过Map条件查询出简洁的BaseXzqhListDto对象列表
     * @param params q，parentId
     * @return  行政区划列表
     */
    List<BaseXzqhListDto> getXzqhListDto(Map<String, Object> params);

    /**
     * 批量保存或更新方法
     * @param list  更新的LIST
     */
    void saveOrUpdateBatch(@Param("list") List<BaseXzqh> list);

}
