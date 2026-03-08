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

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dao.BaseLabelDao;
import net.linlan.sys.base.dto.BaseLabelDto;
import net.linlan.sys.base.entity.BaseLabel;
import net.linlan.sys.base.param.BaseLabelParam;
import net.linlan.sys.web.KernelConstant;

/**
 *
 * BaseLabel数据域:全局标签字词服务类
 * @author Linlan
 * CreateTime 2018-05-08 18:37:58
 *
 */
@Service
@Slf4j
public class BaseLabelService {

    @Resource
    private BaseLabelDao dao;

    /** get the list of entity BaseLabel
     * 列表方法，返回列表的全局标签数据 {@link List} 对象，包含 {@link BaseLabel} 列表
     * @param map the input select conditions
     * @return 列表的全局标签数据 {@link List} 对象，包含 {@link BaseLabel} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseLabel> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseLabel}
     * @param id 标签ID|1
     * @return {@link BaseLabel}
     */
    public BaseLabel findById(String id) {
        BaseLabel baseLabel = dao.findById(id);
        if (ObjectUtils.isNotEmpty(baseLabel)) {//判断是否为空
            updateAccessCount(baseLabel.getId());//更新访问量
        }
        return baseLabel;
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseLabel the input baseLabel
     */
    //@Transactional
    public void save(BaseLabel baseLabel) {
        BaseLabel byName = dao.findByName(baseLabel.getName());
        if (ObjectUtils.isEmpty(byName)) {
            baseLabel.init();
            dao.save(baseLabel);
        } else {
            //            if(ObjectUtils.isNotEmpty(baseLabel.getForeignId())){
            //                byName.setForeignId(baseLabel.getForeignId());
            //            }
            if (ObjectUtils.isNotEmpty(baseLabel.getAttr())) {
                if (ObjectUtils.isNotEmpty(byName.getAttr())) {
                    if (!byName.getAttr().contains(baseLabel.getAttr())) {
                        byName.setAttr(byName.getAttr() + "," + baseLabel.getAttr());
                    }
                } else {
                    byName.setAttr(baseLabel.getAttr());
                }
            }
            if (ObjectUtils.isEmpty(baseLabel.getId())) {
                baseLabel.setId(byName.getId());
            }
            byName.setLastTime(new Date());
            byName.setRefCount(byName.getRefCount() + 1);//修改引用数
            baseLabel = byName;
            //updateRefCount(baseLabel.getId());
            dao.update(baseLabel);
        }
    }

    /** save the entity with input list
     * 保存对象全局标签字词，批量保存list
     * @param list {@link BaseLabel}
     */
    public void batchSave(List<BaseLabel> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseLabel the input baseLabel
     */
    //@Transactional
    public void update(BaseLabel baseLabel) {
        dao.update(baseLabel);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 标签ID|1
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

    /** get the page of dto BaseLabelDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseLabelParam }
     * @return 分页的标签数据 {@link Page} 对象，包含 {@link BaseLabel} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseLabelDto> getPageDto(BaseLabelParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseLabelDto}
     * @param id 标签ID|1
     * @return {@link BaseLabelDto}
     */
    public BaseLabelDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    /**
     * 通过name查询，如果有直接返回id，如果没有初始化后返回id
     * @param name  名称
     * @return    返回结果
     */
    public String initBaseLabelReturnId(String name) {

        BaseLabel baseLabel = findByName(name);
        if (baseLabel == null) {
            baseLabel = new BaseLabel();
            baseLabel.init();
            baseLabel.setName(name);
            dao.save(baseLabel);
        } else {
            //当新增时 查询到已经存在该标签 更新引用量
            baseLabel.setRefCount(baseLabel.getRefCount() + 1);
            dao.update(baseLabel);
        }
        return baseLabel.getId();
    }

    /**
     * 更新引用量
     * @param id    主键ID
     * @return    查询对象
     */
    public int updateRefCount(String id) {
        if (StringUtils.isBlank(id)) {
            return KernelConstant.DEFAULT_INT;
        }
        BaseLabel baseLabel = dao.findById(id);
        if (baseLabel != null) {
            baseLabel.setRefCount(baseLabel.getRefCount() + 1);
            baseLabel.setLastTime(new Date());
            dao.update(baseLabel);
            return 1;
        }
        return 0;
    }

    /**
     * 更新查询量
     * @param id    主键ID
     * @return    查询对象
     */
    public int updateAccessCount(String id) {
        if (StringUtils.isBlank(id)) {
            return KernelConstant.DEFAULT_INT;
        }
        BaseLabel baseLabel = dao.findById(id);
        if (baseLabel != null) {
            baseLabel.setAccessCount(baseLabel.getAccessCount() + 1);
            baseLabel.setLastTime(new Date());
            dao.update(baseLabel);
            return 1;
        }
        return 0;
    }

    /**
     *
     * @param name  名称
     * @return    查询结果
     */
    public BaseLabel findByName(String name) {
        BaseLabel baseLabel = dao.findByName(name);
        if (ObjectUtils.isNotEmpty(baseLabel)) {
            updateAccessCount(baseLabel.getId());
        }
        return baseLabel;
    }

    public List<Map<String, Object>> statisticsCount(Map<String, Object> map) {
        return dao.statisticsCount(map);
    }

    public List<String> getLabelNameList(String[] ids) {
        return dao.getLabelNameList(ids);
    }

    //内部查询，不更新查询量
    public List<BaseLabel> getAllList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /**
     * 批量保存或更新方法
     * @param list    当前list
    
     */
    public void saveOrUpdateBatch(List<BaseLabel> list) {
        dao.batchSave(list);
    }
}
