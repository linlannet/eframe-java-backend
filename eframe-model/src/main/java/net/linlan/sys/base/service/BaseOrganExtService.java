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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dao.BaseOrganExtDao;
import net.linlan.sys.base.dto.BaseOrganExtDto;
import net.linlan.sys.base.entity.BaseOrganExt;
import net.linlan.sys.base.param.BaseOrganExtParam;

/**
 *
 * BaseOrganExt数据域:基础单位扩展信息服务类
 * @author Linlan
 * CreateTime 2018-03-02 13:41:37
 *
 */
@Service
@Slf4j
public class BaseOrganExtService {

    @Resource
    private BaseOrganExtDao dao;

    private final Integer   MAX_NUM = 300;

    /** get the list of entity BaseOrganExt
     * 列表方法，返回列表的基础机构扩展数据 {@link List} 对象，包含 {@link BaseOrganExt} 列表
     * @param map the input select conditions
     * @return 列表的基础机构扩展数据 {@link List} 对象，包含 {@link BaseOrganExt} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseOrganExt> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseOrganExt}
     * @param id 单位编号|1
     * @return {@link BaseOrganExt}
     */
    public BaseOrganExt findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseOrganExt the input baseOrganExt
     */
    //@Transactional
    public void save(BaseOrganExt baseOrganExt) {
        baseOrganExt.init();
        dao.save(baseOrganExt);
    }

    /** save the entity with input list
     * 保存对象基础单位扩展信息，批量保存list
     * @param list {@link BaseOrganExt}
     */
    public void batchSave(List<BaseOrganExt> list) {
        if (list == null) {
            return;
        }
        if (list.size() > 0 && list.size() <= MAX_NUM) {
            dao.batchSave(list);
        } else if (MAX_NUM < list.size()) {
            List<BaseOrganExt> batchBaseOrgans = new LinkedList<>();
            int batch = list.size() / MAX_NUM + 1;
            for (int i = 0; i < batch; i++) {
                for (int j = i * MAX_NUM; j < (i + 1) * MAX_NUM && j < list.size(); j++) {
                    batchBaseOrgans.add(list.get(j));
                }
                dao.batchSave(batchBaseOrgans);
                batchBaseOrgans.clear();
            }
        }
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseOrganExt the input baseOrganExt
     */
    //@Transactional
    public void update(BaseOrganExt baseOrganExt) {
        dao.update(baseOrganExt);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 单位编号|1
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

    /** get the page of dto BaseOrganExtDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseOrganExtParam }
     * @return 分页的基础机构扩展数据 {@link Page} 对象，包含 {@link BaseOrganExt} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseOrganExtDto> getPageDto(BaseOrganExtParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseOrganExtDto}
     * @param id 单位编号|1
     * @return {@link BaseOrganExtDto}
     */
    public BaseOrganExtDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

}
