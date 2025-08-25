/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.admin.manager;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.admin.entity.AdminDept;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.view.admin.vo.AdminDeptVo;

/**
 *
 * AdminDept视图域:系统机构部门增删改操作管理类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Component
@Slf4j
public class AdminDeptOpManager {
    @Resource
    private AdminDeptService adminDeptService;

    /** 执行AdminDept对象Op操作，进行增加、删除、修改业务
     * @param action 操作类型:10,新增;20,修改;40,删除|20
     * @param id 单位ID:null,1;1,2,3|1
     * @param input 输入对象信息
     * @return {@link Boolean}:true,success;false,failure
     */
    public boolean doAdminDeptOp(String action, String id, AdminDeptVo input) {
        if (StringUtils.isBlank(action)) {
            return false;
        }
        if (StringUtils.isNotBlank(action)) {
            if (action.equals(ApiIntfConfig.VALUE_AT_ADD)) {
                if (ObjectUtils.isEmpty(input)) {
                    return false;
                }
                //保存AdminDept
                AdminDept adminDept = new AdminDept();
                if (ObjectUtils.isNotEmpty(input.getId())) {
                    adminDept.setId(input.getId());
                }
                adminDept.setOrganId(input.getOrganId());
                adminDept.setParentId(input.getParentId());
                adminDept.setAppId(input.getAppId());
                adminDept.setDepttypeId(input.getDepttypeId());
                adminDept.setForeignId(input.getForeignId());
                adminDept.setCreateType(input.getCreateType());
                adminDept.setType(input.getType());
                adminDept.setName(input.getName());
                adminDept.setSname(input.getSname());
                adminDept.setAreaCode(input.getAreaCode());
                adminDept.setOrganLeader(input.getOrganLeader());
                adminDept.setLeaderId(input.getLeaderId());
                adminDept.setLeaderMobile(input.getLeaderMobile());
                adminDept.setIsOrganLevel(input.getIsOrganLevel());
                adminDept.setIsVirtual(input.getIsVirtual());
                adminDept.setIsLeaf(input.getIsLeaf());
                adminDept.setIsDisabled(input.getIsDisabled());
                adminDept.setSearchCode(input.getSearchCode());
                adminDept.setImagePath(input.getImagePath());
                adminDept.setPriority(input.getPriority());
                adminDept.setStatus(input.getStatus());
                adminDept.setLastTime(input.getLastTime());
                adminDept.setDelFlag(input.getDelFlag());
                adminDept.setDescription(input.getDescription());
                adminDept.setSpare1(input.getSpare1());
                adminDept.setSpare2(input.getSpare2());
                adminDeptService.save(adminDept);
                return true;
            } else if (action.equals(ApiIntfConfig.VALUE_AT_UPDATE)) {
                if (ObjectUtils.isEmpty(id) || ObjectUtils.isEmpty(input)) {
                    return false;
                }
                if (isValidUpdateSuccess(id)) {
                    AdminDept adminDept = adminDeptService.findById(Long.valueOf(id));
                    if (adminDept != null) {
                        //部分字段需要单独更新的，此处请删除，如密码、创建时间等，如有关联更新请添加关联方法
                        adminDept.setOrganId(input.getOrganId());
                        adminDept.setParentId(input.getParentId());
                        adminDept.setAppId(input.getAppId());
                        adminDept.setDepttypeId(input.getDepttypeId());
                        adminDept.setForeignId(input.getForeignId());
                        adminDept.setCreateType(input.getCreateType());
                        adminDept.setType(input.getType());
                        adminDept.setName(input.getName());
                        adminDept.setSname(input.getSname());
                        adminDept.setAreaCode(input.getAreaCode());
                        adminDept.setOrganLeader(input.getOrganLeader());
                        adminDept.setLeaderId(input.getLeaderId());
                        adminDept.setLeaderMobile(input.getLeaderMobile());
                        adminDept.setIsOrganLevel(input.getIsOrganLevel());
                        adminDept.setIsVirtual(input.getIsVirtual());
                        adminDept.setIsLeaf(input.getIsLeaf());
                        adminDept.setIsDisabled(input.getIsDisabled());
                        adminDept.setSearchCode(input.getSearchCode());
                        adminDept.setImagePath(input.getImagePath());
                        adminDept.setPriority(input.getPriority());
                        adminDept.setStatus(input.getStatus());
                        adminDept.setLastTime(input.getLastTime());
                        adminDept.setDelFlag(input.getDelFlag());
                        adminDept.setDescription(input.getDescription());
                        adminDept.setSpare1(input.getSpare1());
                        adminDept.setSpare2(input.getSpare2());
                        adminDeptService.update(adminDept);
                        doUpdateRelation(id);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isValidUpdateSuccess(Serializable id) {
        return true;
    }

    public void doUpdateRelation(Serializable id) {

    }

    public boolean isValidDeleteSuccess(Serializable id) {
        return true;
    }

    public void doDeleteRelation(Serializable id) {

    }

}
