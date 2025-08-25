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
package net.linlan.sys.comm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.sys.comm.dao.CommAttachDao;
import net.linlan.sys.comm.dto.AttachInitInfo;
import net.linlan.sys.comm.dto.CommAttachDto;
import net.linlan.sys.comm.entity.CommAttach;
import net.linlan.sys.comm.param.CommAttachParam;

/**
 *
 * CommAttach数据域:应用基础通用附件服务类
 * @author Linlan
 * CreateTime 2021-05-07 16:25:50
 *
 */
@Service
@Slf4j
public class CommAttachService {

    @Resource
    private CommAttachDao dao;

    /** get the list of entity CommAttach
     * 列表方法，返回列表的通用附件数据 {@link List} 对象，包含 {@link CommAttach} 列表
     * @param map the input select conditions
     * @return 列表的通用附件数据 {@link List} 对象，包含 {@link CommAttach} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CommAttach> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CommAttach}
     * @param id the CommAttach 附件ID | 1
     * @return {@link CommAttach}
     */
    public CommAttach findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param commAttach the input commAttach
     */
    //@Transactional
    public void save(CommAttach commAttach) {
        commAttach.init();
        dao.save(commAttach);
    }

    /** save the entity with input list
     * 保存对象应用基础通用附件，批量保存list
     * @param list {@link CommAttach}
     */
    public void batchSave(List<CommAttach> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param commAttach the input commAttach
     */
    //@Transactional
    public void update(CommAttach commAttach) {
        dao.update(commAttach);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the CommAttach 附件ID | 1
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

    /** get the page of dto CommAttachDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CommAttachParam }
     * @return 分页的通用附件数据 {@link Page} 对象，包含 {@link CommAttach} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CommAttachDto> getPageDto(CommAttachParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CommAttachDto}
     * @param id the CommAttach 附件ID | 1
     * @return {@link CommAttachDto}
     */
    public CommAttachDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /**
     * 获取附件详情
     * @param businessId 业务ID
     * @param restypeId 附件类别：对应AttachTypeEnum的key值
     * @param attachType 二级类别：如果没有传空
     * @return    返回结果List
     */
    public List<CommAttach> getByResType(String businessId, String restypeId, String attachType) {
        return dao.getByResType(businessId, restypeId, attachType);
    }

    /**
     * 获取附件详情
     * @param businessId 业务ID
     * @param restypeId 附件类别：对应AttachTypeEnum的key值
     * @return  查询结果
     */
    public List<CommAttach> getFiles(String businessId, String restypeId) {
        return dao.getByResType(businessId, restypeId, null);
    }

    /**
     * 修改附件绑定信息
     * @param newBusinessId     新业务ID
     * @param oldBusinessId     旧业务ID
     */
    public void changeBind(String newBusinessId, String oldBusinessId) {
        dao.changeBind(newBusinessId, oldBusinessId);
    }

    /**
     * 删除文件
     * @param businessId 业务ID
     * @param restypeId 资源分类ID
     * @param attachType    附件类型
     */
    public void deleteFiles(String businessId, String restypeId, String attachType) {
        dao.deleteByResType(businessId, restypeId, attachType);
    }

    /** 通过foreignId获取关联对附件列表
     * @param foreignId 外键ID
     * @return    返回结果List
     */
    public List<CommAttach> getByForeignId(String foreignId) {
        return dao.getByForeignId(foreignId);
    }

    /** 通过foreignId和附件对象，批量进行附件插入更新
     * @param attachments   附件
     * @param foreignId 外键ID
     * @return    操作结果
     */
    public int batchUpdateByForeignId(Object[] attachments, String foreignId) {
        return dao.batchUpdateByForeignId(attachments, foreignId);
    }

    public List<CommAttach> getByForeignIdAndFlowId(String foreignId, String flowId) {
        return dao.getByForeignIdAndFlowId(foreignId, flowId);
    }

    public void deleteByForeignId(String foreignId) {
        dao.deleteByForeignId(foreignId);
    }

    public void batchSaveByInit(List<AttachInitInfo> attaches) {
        this.dao.batchSaveByInit(attaches);
    }

}
