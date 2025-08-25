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
package net.linlan.sys.core.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.entity.BaseOrgan;
import net.linlan.sys.base.service.BaseOrganService;
import net.linlan.sys.core.dao.CoreOrganDao;
import net.linlan.sys.core.dto.CoreOrganDto;
import net.linlan.sys.core.entity.CoreOrgan;
import net.linlan.sys.core.param.CoreOrganParam;

/**
 *
 * SysOrgan数据域:系统机构表服务类
 * @author Linlan
 * CreateTime 2018-05-08 19:39:42
 *
 */
@Service
@Slf4j
public class CoreOrganService {

    @Resource
    private CoreOrganDao     dao;
    @Resource
    private BaseOrganService baseOrganService;

    /** get the list of entity CoreOrgan
     * 列表方法，返回列表的系统机构数据 {@link List} 对象，包含 {@link CoreOrgan} 列表
     * @param map the input select conditions
     * @return 列表的系统机构数据 {@link List} 对象，包含 {@link CoreOrgan} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CoreOrgan> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CoreOrgan}
     * @param id the input id
     * @return {@link CoreOrgan}
     */
    public CoreOrgan findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param coreOrgan the input coreOrgan
     */
    //@Transactional
    public void save(CoreOrgan coreOrgan) {
        //首先保存baseOrgan信息
        //update by linlan on 2021年10月9日09:36:01 id有的话用传的，无id的自动生成
        String id = coreOrgan.getId();
        if (id == null || "".equals(id)) {
            id = RandomUtils.randomSid();
        }
        BaseOrgan baseOrgan = coreOrgan.getBaseOrgan();
        baseOrgan.init();
        baseOrgan.setId(id);
        baseOrganService.save(baseOrgan);

        //再保存coreOrgan信息
        coreOrgan.init();
        coreOrgan.setId(id);
        dao.save(coreOrgan);

    }

    /** save the entity with input list
     * 保存对象系统机构表，批量保存list
     * @param list {@link CoreOrgan}
     */
    public void batchSave(List<CoreOrgan> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param coreOrgan the input coreOrgan
     */
    //@Transactional
    public void update(CoreOrgan coreOrgan) {
        //首先更新baseOrgan的信息
        baseOrganService.update(coreOrgan.getBaseOrgan());
        //然后更新SysOrgan信息
        coreOrgan.setLastTime(new Timestamp(System.currentTimeMillis()));
        dao.update(coreOrgan);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the input id
     */
    public void deleteById(String id) {
        //判断是否需要删除BaseOrgan信息
        if (baseOrganService.isValidByDelete(id)) {
            baseOrganService.deleteById(id);
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

    /** get the page of dto CoreOrganDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CoreOrganParam }
     * @return 分页的系统机构数据 {@link Page} 对象，包含 {@link CoreOrgan} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CoreOrganDto> getPageDto(CoreOrganParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CoreOrganDto}
     * @param id the input id
     * @return {@link CoreOrganDto}
     */
    public CoreOrganDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

}
