/*
 * eframe-api - api接口网关模块
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
package net.linlan.frame.api.admin;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.admin.entity.AdminDept;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.api.BaseController;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.constant.UserConstants;
import net.linlan.utils.exception.CommonException;

/**
 *
 * AdminDept控制域:系统机构部门增删改操作控制类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@RestController
@RequestMapping("api/admin")
public class AdminDeptOpController extends BaseController {

    @Resource
    private AdminDeptService adminDeptService;

    /**
     * 新增部门
     * @param input  保存对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:dept:save')")
    @PlatLog(value = "新增部门管理", category = 10)
    @PostMapping("dept/save")
    @Encrypt
    @LimitScope(name = "adminDeptSave", key = "adminDeptSave")
    public ResponseResult<String> save(@Validated @RequestBody AdminDept input) {
        if (!adminDeptService.checkDeptNameUnique(input)) {
            return error("新增部门'" + input.getName() + "'失败，部门名称已存在");
        }
        if (input.getParentId() == null) {
            input.setParentId(0L);
        }
        AdminDept info = adminDeptService.findById(input.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if (info != null && info.getDelFlag() != 0) {
            throw new CommonException("部门停用，不允许新增");
        }
        input.setId(RandomUtils.randomLid());
        input.setIsDisabled(false);
        input.setAppId(Constants.ENT_APP_ID);
        if (info != null && StringUtils.isNotBlank(info.getSearchCode())) {
            input.setSearchCode(info.getSearchCode() + "," + input.getParentId());
        } else {
            input.setSearchCode("0");
        }
        input.setCreatorId(getUsername());
        adminDeptService.save(input);
        return returnRow(1);
    }

    /**
     * 修改部门
     * @param input  修改对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:dept:update')")
    @PlatLog(value = "修改部门管理", category = 20)
    @PostMapping("dept/update")
    @Encrypt
    @LimitScope(name = "adminDeptUpdate", key = "adminDeptUpdate")
    public ResponseResult<String> update(@Validated @RequestBody AdminDept input) {
        Long deptId = input.getId();
        adminDeptService.checkDeptDataScope(deptId);
        if (!adminDeptService.checkDeptNameUnique(input)) {
            return error("修改部门'" + input.getName() + "'失败，部门名称已存在");
        } else if (input.getParentId().equals(deptId)) {
            return error("修改部门'" + input.getName() + "'失败，上级部门不能是自己");
        } else if (StringUtils.equals(UserConstants.DEPT_DISABLE, input.getDelFlag().toString())
                   && adminDeptService.selectNormalChildrenDeptById(deptId) > 0) {
            return error("该部门包含未停用的子部门！");
        }
        adminDeptService.update(input);
        return returnRow(1);
    }

    /**
     * 删除部门
     * @param deptIds  部门Ids
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:dept:delete')")
    @PlatLog(value = "删除部门管理", category = 40)
    @PostMapping("dept/delete/{deptIds}")
    @Encrypt
    @LimitScope(name = "adminDeptDelete", key = "adminDeptDelete")
    public ResponseResult<String> delete(@PathVariable Long[] deptIds) {
        for (Long deptId : deptIds) {
            if (adminDeptService.hasChildByDeptId(deptId)) {
                return warn("存在下级部门,不允许删除");
            }
            if (adminDeptService.checkDeptExistUser(deptId)) {
                return warn("部门存在用户,不允许删除");
            }
            adminDeptService.checkDeptDataScope(deptId);
            adminDeptService.deleteById(deptId);
        }
        return success();
    }

    /**
     * 停用启用部门
     * @param input  部门对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:dept:update')")
    @PlatLog(value = "停用启用部门管理", category = 20)
    @PostMapping("dept/disable/{id}")
    @Encrypt
    public ResponseResult<String> disable(@RequestBody AdminDept input) {
        Long deptId = input.getId();
        adminDeptService.checkDeptDataScope(deptId);
        if (adminDeptService.selectNormalChildrenDeptById(deptId) > 0) {
            return error("该部门包含未停用的子部门！");
        }
        adminDeptService.update(input);
        return returnRow(1);
    }

}
