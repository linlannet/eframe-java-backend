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

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dao.BaseOrganDao;
import net.linlan.sys.base.dto.BaseOrganDto;
import net.linlan.sys.base.dto.KeyValueMapDto;
import net.linlan.sys.base.entity.BaseOrgan;
import net.linlan.sys.base.entity.BaseOrganExt;
import net.linlan.sys.base.param.BaseOrganParam;

/**
 *
 * BaseOrgan数据域:基础单位服务类
 * @author Linlan
 * CreateTime 2023-08-08 13:41:37
 *
 */
@Service
@Slf4j
public class BaseOrganService {

    @Resource
    private BaseOrganDao        dao;
    @Resource
    private BaseOrganExtService baseOrganExtService;

    private final Integer       MAX_NUM = 300;

    /** get the list of entity BaseOrgan
     * 列表方法，返回列表的基础机构数据 {@link List} 对象，包含 {@link BaseOrgan} 列表
     * @param map the input select conditions
     * @return 列表的基础机构数据 {@link List} 对象，包含 {@link BaseOrgan} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseOrgan> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseOrgan}
     * @param id 单位编码|1
     * @return {@link BaseOrgan}
     */
    public BaseOrgan findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseOrgan the input baseOrgan
     */
    //@Transactional
    public void save(BaseOrgan baseOrgan) {
        baseOrgan.init();
        dao.save(baseOrgan);
        //保存扩展信息
        baseOrgan.getBaseOrganExt().setId(baseOrgan.getId());
        baseOrganExtService.save(baseOrgan.getBaseOrganExt());
    }

    /** save the entity with input list
     * 保存对象基础单位，批量保存list
     * @param list {@link BaseOrgan}
     */
    public void batchSave(List<BaseOrgan> list) {
        if (list == null) {
            return;
        }
        if (list.size() > 0 && list.size() <= MAX_NUM) {
            dao.batchSave(list);
        } else if (list.size() > MAX_NUM) {
            List<BaseOrgan> batchBaseOrgans = new LinkedList<>();
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
     * @param baseOrgan the input baseOrgan
     */
    //@Transactional
    public void update(BaseOrgan baseOrgan) {
        dao.update(baseOrgan);
        //更新Ext信息
        BaseOrganExt ext = baseOrgan.getBaseOrganExt();
        //        ext.setTel("aa");
        baseOrganExtService.update(ext);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 单位编码|1
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

    /** get the page of dto BaseOrganDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseOrganParam }
     * @return 分页的基础机构数据 {@link Page} 对象，包含 {@link BaseOrgan} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseOrganDto> getPageDto(BaseOrganParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseOrganDto}
     * @param id 单位编码|1
     * @return {@link BaseOrganDto}
     */
    public BaseOrganDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    public List<?> getExportList(Map<String, Object> params) {
        return dao.getExportList(params);
    }

    /**
     * 根据单位名称查询
     * @param organName 机构名称
     * @return    查询结果
     */
    public BaseOrgan getOrganByName(String organName) {
        BaseOrgan organ = dao.getByName(organName);
        return organ;
    }

    /**
     * 根据单位名称查询
     * @param   organName   机构名称
     * @param   unionCode   统一信用代码
     * @return    查询结果
     */
    public BaseOrgan getOrganByNameUnicode(String organName, String unionCode) {
        BaseOrgan organ = dao.getOrganByNameUnicode(organName, unionCode);
        return organ;
    }

    /**
     * 通过地域类机构外部ID查询机构列表
     * @param ids  id列表
     * @return    查询结果列表
     */
    List<BaseOrgan> getListByOutIds(@Param("ids") List<String> ids) {
        return dao.getListByOutIds(ids);
    }

    /**
     * 通过organCode 查询唯一数据
     * @param   organCode   机构代码
     * @return  查询结果
     */
    public BaseOrgan getOrganByOrganCode(String organCode) {
        return dao.getOrganByOrganCode(organCode);
    }

    public boolean isValidByDelete(String id) {
        return true;
    }

    /** 取出机构键值对给下拉使用
     * @param params    查询参数
     * @return  查询结果
     */
    public Page<KeyValueMapDto> getKeyValueList(BaseOrganParam params) {
        PageHelper.startPage(params.getPage(), params.getLimit());
        return this.dao.getKeyValueList(params);
    }

    /**
     * 根据单位名称查询
     * @param   unionCode   统一信用代码
     * @return    查询结果
     */
    public BaseOrgan getOrganByUnicode(String unionCode) {
        BaseOrgan organ = dao.getOrganByUnicode(unionCode);
        return organ;
    }
}
