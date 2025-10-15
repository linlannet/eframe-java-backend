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

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dao.BaseUserExtDao;
import net.linlan.sys.base.dto.BaseUserExtDto;
import net.linlan.sys.base.entity.BaseUserExt;
import net.linlan.sys.base.param.BaseUserExtParam;

/**
 *
 * BaseUserExt数据域:基础用户扩展信息服务类
 * @author Linlan
 * CreateTime 2018-03-08 13:41:37 *
 */
@Service
@Slf4j
public class BaseUserExtService {

    @Resource
    private BaseUserExtDao dao;

    /** get the list of entity BaseUserExt
     * 列表方法，返回BaseUserExt列表
     * @param map the input select conditions
     * @return 分页的基础机构数据 {@link Page} 对象，包含 {@link BaseUserExt} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseUserExt> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseUserExt}
     * @param id 用户ID|1
     * @return {@link BaseUserExt}
     */
    public BaseUserExt findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseUserExt the input baseUserExt
     */
    //@Transactional
    public void save(BaseUserExt baseUserExt) {
        baseUserExt.init();
        dao.save(baseUserExt);
    }

    /** save the entity with input list
     * 保存对象基础用户扩展信息，批量保存list
     * @param list {@link BaseUserExt}
     */
    public void batchSave(List<BaseUserExt> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseUserExt the input baseUserExt
     */
    //@Transactional
    public void update(BaseUserExt baseUserExt) {
        if (StringUtils.isEmpty(baseUserExt.getId())) {
            return;
        }
        dao.update(baseUserExt);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 用户ID|1
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

    /** get the page of dto BaseUserExtDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseUserExtParam }
     * @return 分页的基础机构数据 {@link Page} 对象，包含 {@link BaseUserExtDto} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseUserExtDto> getPageDto(BaseUserExtParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseUserExtDto}
     * @param id 用户ID|1
     * @return {@link BaseUserExtDto}
     */
    public BaseUserExtDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    /** 通过身份证号码的中间位数查询用户年龄段
     * @param map   查询参数
     * @return  年龄段统计
     */
    public List<Map<String, Object>> getUserAgeList(Map<String, Object> map) {
        return dao.getUserAgeList(map);
    }

    public int updatePassword(Map<String, Object> map) {
        return dao.updatePassword(map);
    }

    public int batUpdatePassword(@Param("userIds") String[] userIds,
                                 @Param("password") String password) {
        return dao.batUpdatePassword(userIds, password);
    }

    /** 通过ID，更新用户三因素敏感信息单独方法
     * @param baseUserExt   包含用户三因素信息
     * @return  保存结果
     */
    public int updateSensitiveInfo(BaseUserExt baseUserExt) {
        return dao.updateSensitiveInfo(baseUserExt);
    }

}
