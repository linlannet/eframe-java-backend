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

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.view.admin.manager.AdminMenuRolePosEntryManager;
import net.linlan.frame.view.admin.manager.AdminMenuRolePosOpManager;
import net.linlan.frame.view.admin.param.SysPositionVoParam;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.admin.vo.SysPositionVo;
import net.linlan.sys.role.dto.SysPositionDto;
import net.linlan.sys.role.entity.SysPosition;
import net.linlan.sys.role.entity.SysRolePosition;
import net.linlan.sys.role.param.SysPositionParam;
import net.linlan.sys.role.service.SysPositionService;

/**
 * 系统岗位信息操作处理
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/admin/")
public class SysPositionController extends BaseController {
    @Resource
    private AdminMenuRolePosOpManager    adminPositionOpManager;
    @Resource
    private AdminMenuRolePosEntryManager adminPositionEntryManager;
    @Resource
    private SysPositionService           sysPositionService;

    /**
     * 获取岗位列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取岗位列表")
    @PreAuthorize("@ss.hasPerms('admin:position:list')")
    @GetMapping("position/list")
    @Encrypt
    public ResponseEntity<Pagination<SysPositionVo>> getSysPositionPage(SysPositionParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<SysPositionDto> result = adminPositionEntryManager.getPositionList(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * 岗位列表导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "岗位列表导出", category = 52)
    @PreAuthorize("@ss.hasPerms('admin:position:export')")
    @PostMapping("position/export")
    @Encrypt
    public void export(HttpServletResponse response, SysPositionVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<SysPositionDto> result = sysPositionService.getPageDto(param.toModelParam());
        if (result == null) {
            return;
        }
        List<SysPositionVo> vos = Lists.transform(result.getResult(), SysPositionVo.DTO);
        ExcelUtil<SysPositionVo> util = new ExcelUtil<>(SysPositionVo.class);
        util.exportExcel(response, vos, "岗位数据");
    }

    /**
     * 根据岗位编号获取详细信息
     * @param postId  岗位Id
     * @return  操作结果
     */
    @PlatLog(value = "根据岗位编号获取详细信息")
    @PreAuthorize("@ss.hasPerms('admin:position:detail')")
    @GetMapping(value = "position/{postId}")
    @Encrypt
    public ResponseEntity<SysPosition> getInfo(@PathVariable String postId) {
        if (ObjectUtils.isEmpty(postId)) {
            return failure();
        }
        SysPosition entity = sysPositionService.findById(postId);
        return success(entity);
    }

    /**
     * 新增岗位
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:position:save')")
    @PlatLog(value = "新增岗位", category = 10)
    @PostMapping("position/save")
    @Encrypt
    @LimitScope(name = "sysPositionSave", key = "sysPositionSave")
    public ResponseEntity<String> save(@Validated @RequestBody SysPositionDto input) {
        if (!adminPositionEntryManager.checkPostNameUnique(input)) {
            return error("新增岗位'" + input.getName() + "'失败，岗位名称已存在");
        } else if (!adminPositionEntryManager.checkPostCodeUnique(input)) {
            return error("新增岗位'" + input.getName() + "'失败，岗位编码已存在");
        }
        if (adminPositionOpManager.doSysPositionOp(ApiIntfConfig.VALUE_AT_ADD, null, input)) {
            return success();
        }
        return failure();
    }

    /**
     * 修改岗位
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:position:update')")
    @PlatLog(value = "修改岗位", category = 20)
    @PostMapping("position/update")
    @Encrypt
    @LimitScope(name = "sysPositionUpdate", key = "sysPositionUpdate")
    public ResponseEntity<String> update(@Validated @RequestBody SysPositionDto input) {
        if (!adminPositionEntryManager.checkPostNameUnique(input)) {
            return error("修改岗位'" + input.getName() + "'失败，岗位名称已存在");
        } else if (!adminPositionEntryManager.checkPostCodeUnique(input)) {
            return error("修改岗位'" + input.getName() + "'失败，岗位编码已存在");
        }
        if (adminPositionOpManager.doSysPositionOp(ApiIntfConfig.VALUE_AT_UPDATE, input.getId(),
            input)) {
            return success();
        }
        return failure();
    }

    /**
     * 删除岗位
     * @param positionIds  岗位Ids
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:position:delete')")
    @PlatLog(value = "删除岗位", category = 40)
    @PostMapping("position/{positionIds}")
    @Encrypt
    @LimitScope(name = "sysPositionDelete", key = "sysPositionDelete")
    public ResponseEntity<String> delete(@PathVariable String[] positionIds) {
        if (ObjectUtils.isEmpty(positionIds)) {
            return failure();
        }
        if (adminPositionOpManager.doSysPositionOp(ApiIntfConfig.VALUE_AT_DELETE,
            StringUtils.join(positionIds, ","), null)) {
            return success();
        }
        return failure();
    }

    /**
     * 绑定角色
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:position:delete')")
    @PlatLog(value = "绑定角色", category = 53)
    @PostMapping("position/bind/{positionId}")
    @Encrypt
    @LimitScope(name = "sysPositionBindPos", key = "sysPositionBindPos")
    public ResponseEntity<String> bind(@RequestBody SysPositionVo input) {
        SysRolePosition adminRolePosition = new SysRolePosition();
        String[] roleIds = input.getIds();
        adminRolePosition.setPositionId(input.getPositionId());
        if (adminPositionOpManager.doBindPosition(ApiIntfConfig.VALUE_AT_BIND,
            StringUtils.join(roleIds, ","), adminRolePosition)) {
            return success();
        }
        return failure();
    }

    /**
     * 解绑角色
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:position:delete')")
    @PlatLog(value = "解绑角色", category = 54)
    @PostMapping("position/unbind/{positionId}")
    @Encrypt
    @LimitScope(name = "sysPositionUnbindPos", key = "sysPositionUnbindPos")
    public ResponseEntity<String> unbind(@RequestBody SysRolePosition input) {
        if (adminPositionOpManager.doBindPosition(ApiIntfConfig.VALUE_AT_UNBIND, null, input)) {
            return success();
        }
        return failure();
    }

    /**
     * 获取岗位选择框列表
     * @return  返回对象
     */
    @PlatLog(value = "获取岗位选择框列表")
    @GetMapping("position/option/select")
    @Encrypt
    public ResponseEntity<List<SysPositionVo>> optionSelect() {
        List<SysPositionVo> vos = adminPositionEntryManager.selectPositionAll();
        if (vos == null) {
            return empty();
        }
        return success(vos);
    }
}
