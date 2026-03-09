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
package net.linlan.sys.base.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.sys.base.dao.BaseXzqhDao;
import net.linlan.sys.base.dto.BaseXzqhDto;
import net.linlan.sys.base.dto.BaseXzqhListDto;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.dto.XzqhInitDto;
import net.linlan.sys.base.entity.BaseXzqh;
import net.linlan.sys.base.param.BaseXzqhParam;
import net.linlan.sys.base.param.TreeParam;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;
import static net.linlan.utils.constant.CacheConstants.BASE_XZQH_KEY;

/**
 *
 * BaseXzqh数据域:行政区划服务类
 * @author Linlan
* CreateTime 2018-03-02 17:17:54
 *
 */
@Service
@Slf4j
public class BaseXzqhService {

    @Resource
    private BaseXzqhDao  dao;
    @Resource
    private RedisService redisService;

    /** get the list of entity BaseXzqh
     * 列表方法，返回列表的行政区划数据 {@link List} 对象，包含 {@link BaseXzqh} 列表
     * @param map the input select conditions
     * @return 列表的行政区划数据 {@link List} 对象，包含 {@link BaseXzqh} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseXzqh> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseXzqh}
     * @param id 行政区划编号|1
     * @return {@link BaseXzqh}
     */
    public BaseXzqh findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseXzqh the input baseXzqh
     */
    //@Transactional
    public void save(BaseXzqh baseXzqh) {
        baseXzqh.init();
        dao.save(baseXzqh);
    }

    /** save the entity with input list
     * 保存对象行政区划，批量保存list
     * @param list {@link BaseXzqh}
     */
    public void batchSave(List<BaseXzqh> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseXzqh the input baseXzqh
     */
    //@Transactional
    public void update(BaseXzqh baseXzqh) {
        dao.update(baseXzqh);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 行政区划编号|1
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

    /** get the page of dto BaseXzqhDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseXzqhParam }
     * @return 分页的基础行政区划数据 {@link Page} 对象，包含 {@link BaseXzqh} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseXzqhDto> getPageDto(BaseXzqhParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseXzqhDto}
     * @param id 行政区划编号|1
     * @return {@link BaseXzqhDto}
     */
    public BaseXzqhDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /** 通过父ID获取下级节点，返回Dto对象列表
     * @param id    主键ID
     * @return    查询对象
     */
    public List<BaseXzqhDto> getDtoByParentId(Long id) {
        return dao.getDtoByParentId(id);
    }

    /** 通过code查询对象，返回单个Dto对象
     * @param code    代码
     * @return    查询结果
     */
    public BaseXzqhDto getDtoByCode(String code) {
        return dao.getDtoByCode(code);
    }

    /** 查找集合下所有的本身加上下一级子集的结果
     * @param list    当前list
     * @return    下一级子集
     */
    public List<BaseXzqh> getListSelfAndChildren(List list) {
        return dao.getListSelfAndChildren(list);
    }

    /**
     * 根据appId、地域类型获取行政区划
     * @param params    查询参数
     * @return  查询结果
     */
    public BaseXzqh getXzqhByAppAndAreaType(Map<String, Object> params) {
        return dao.getXzqhByAppAndAreaType(params);
    }

    /** 通过父ID获取基础行政区划子节点
     * @param parentId  父节点ID
     * @return  原始行政区划列表
     */
    public List<XzqhInitDto> getChildren(Long parentId) {
        if (parentId == null) {
            parentId = 0L;
        }
        List<XzqhInitDto> dist = redisService.getList(BASE_XZQH_KEY + parentId);
        if (dist != null && dist.size() > 0) {
            return dist;
        } else {
            List<XzqhInitDto> dicResult = dao.getChildren(parentId);
            if (dicResult != null && dicResult.size() > 0) {
                redisService.setList(BASE_XZQH_KEY + parentId, dicResult,
                    KernelConstant.ONE_HOUR_EXPIRE * 2);
            }
            return dicResult;
        }
    }

    /** 通过条件获取树结构行政区划节点
     * @param treeParam    树查询参数
     * @return    查询结果列表
     */
    public List<TreeNode> getXzqhChildren(TreeParam treeParam) {
        return dao.getXzqhChildren(treeParam);
    }

    /** 通过Map条件查询出简洁的BaseXzqhListDto对象列表
     * @param params q，parentId
     * @return  行政区划列表
     */
    public List<BaseXzqhListDto> getXzqhListDto(Map<String, Object> params) {
        return dao.getXzqhListDto(params);
    }

    /**
     * 批量保存或更新方法
     * @param list    当前list
     */
    public void saveOrUpdateBatch(@Param("list") List<BaseXzqh> list) {
        dao.saveOrUpdateBatch(list);
    }

}
