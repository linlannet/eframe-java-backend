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
package net.linlan.sys.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.param.TreeParam;
import net.linlan.sys.core.dto.CoreOrgtypeDto;
import net.linlan.sys.core.entity.CoreOrgtype;
import net.linlan.sys.core.param.CoreOrgtypeParam;

/**
*
* CoreOrgtype数据域:机构分类表持久层Dao
* @author Linlan
* CreateTime 2018-03-02 17:19:48
*
*/
@Mapper
public interface CoreOrgtypeDao extends MybatisBaseDao<CoreOrgtype> {

    /** get the page of dto CoreOrgtypeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CoreOrgtypeParam }
     * @return 分页的机构分类数据 {@link Page} 对象，包含 {@link CoreOrgtype} 列表
     */
    Page<CoreOrgtypeDto> getPageDto(CoreOrgtypeParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CoreOrgtypeDto}
     * @param id the input id
     * @return {@link CoreOrgtypeDto}
     */
    CoreOrgtypeDto getDtoById(Long id);

    /** 获取树节点的下级列表
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    List<TreeNode> getOrgTypeChildren(TreeParam treeParam);

    /** 通过名称、简称等条件查询下拉框列表
     * @param params    查询参数
     * @return  查询结果
     */
    Page<CoreOrgtypeDto> getAllSelectList(CoreOrgtypeParam params);
}
