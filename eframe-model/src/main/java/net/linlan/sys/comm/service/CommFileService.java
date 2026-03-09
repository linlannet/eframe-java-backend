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

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.comm.dao.CommFileDao;
import net.linlan.sys.comm.dto.CommFileDto;
import net.linlan.sys.comm.entity.CommFile;
import net.linlan.sys.comm.param.CommFileParam;
import net.linlan.sys.web.KernelConstant;

/**
 *
 * CommFile数据域:公共文件附件表服务类
 * @author Linlan
 * CreateTime 2023-08-12 14:34:47
 *
 */
@Service
@Slf4j
public class CommFileService {

    @Resource
    private CommFileDao dao;

    /** get the list of entity CommFile
     * 列表方法，返回列表的通用文件数据 {@link List} 对象，包含 {@link CommFile} 列表
     * @param map the input select conditions
     * @return 列表的通用文件数据 {@link List} 对象，包含 {@link CommFile} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CommFile> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CommFile}
     * @param id the input id
     * @return {@link CommFile}
     */
    public CommFile findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param commFile the input commFile
     */
    //@Transactional
    public void save(CommFile commFile) {
        commFile.init();
        dao.save(commFile);
    }

    /** save the entity with input list
     * 保存对象公共文件附件表，批量保存list
     * @param list {@link CommFile}
     */
    public void batchSave(List<CommFile> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param commFile the input commFile
     */
    //@Transactional
    public void update(CommFile commFile) {
        dao.update(commFile);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the input id
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

    /** get the page of dto CommFileDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CommFileParam }
     * @return 分页的通用文件数据 {@link Page} 对象，包含 {@link CommFile} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CommFileDto> getPageDto(CommFileParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CommFileDto}
     * @param id the input id
     * @return {@link CommFileDto}
     */
    public CommFileDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    public void saveOrUpdateByFile(Boolean valid, String filePath, String appId, String resclassId,
                                   String fileName, long size, String extension, Boolean isAdmin,
                                   String userId) {
        if (StringUtils.isBlank(filePath)) {
            return;
        }
        if (StringUtils.isBlank(fileName)) {
            fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        }
        CommFile file = findById(filePath);
        if (file == null) {
            saveByPath(valid, filePath, fileName, appId, resclassId, size, extension, isAdmin,
                userId);
        } else {
            //如果文件存在，仅需要修改valid信息
            file.setFileIsvalid(valid);
            update(file);
        }

        //后续增加处理file的保存信息
        //判断类型，查看该类型的信息保存方式
    }

    public void saveByPath(Boolean valid, String filePath, String fileName, String appId,
                           String resclassId, long size, String extension, Boolean isAdmin,
                           String userId) {
        CommFile bean = new CommFile();
        bean.setId(filePath);
        bean.setAppId(appId);
        bean.setFileName(fileName);
        bean.setFileIsvalid(valid);
        bean.setResclassId(resclassId);
        //保存创建者等信息
        if (isAdmin) {
            //按照管理模式处理创建者信息
            bean.setUserType(KernelConstant.USER_TYPE_ADMIN);
        } else {
            //按照会员模式处理创建者信息
            bean.setUserType(KernelConstant.USER_TYPE_MEMBER);
        }
        bean.setCreatorId(userId);
        bean.setFileSize(size);
        bean.setFileExtension(extension);
        save(bean);
    }

    public void saveOrUpdateByFileWithRef(Boolean valid, String filePath, String appId,
                                          String resclassId, String fileName, long size,
                                          String extension, Boolean isAdmin, String userId,
                                          String refId, String refType) {
        if (StringUtils.isBlank(filePath)) {
            return;
        }
        if (StringUtils.isBlank(fileName)) {
            fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        }
        CommFile file = findById(filePath);
        if (file == null) {
            CommFile bean = new CommFile();
            bean.setId(filePath);
            bean.setAppId(appId);
            bean.setFileName(fileName);
            bean.setFileIsvalid(valid);
            bean.setResclassId(resclassId);
            //保存创建者等信息
            if (isAdmin) {
                //按照管理模式处理创建者信息
                bean.setUserType(KernelConstant.USER_TYPE_ADMIN);
            } else {
                //按照会员模式处理创建者信息
                bean.setUserType(KernelConstant.USER_TYPE_MEMBER);
            }
            bean.setCreatorId(userId);
            bean.setFileSize(size);
            bean.setFileExtension(extension);
            bean.setRefId(refId);
            bean.setRefType(refType);
            save(bean);
        } else {
            //如果文件存在，仅需要修改valid信息
            file.setFileIsvalid(valid);
            update(file);
        }

        //后续增加处理file的保存信息
        //判断类型，查看该类型的信息保存方式
    }

}
