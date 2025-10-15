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

import java.sql.Timestamp;
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
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.entity.AdminUserRole;
import net.linlan.frame.admin.param.AdminDeptParam;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.admin.service.AdminRoleVoService;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.comm.service.SysPermissionService;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.view.admin.manager.AdminMenuRolePosEntryManager;
import net.linlan.frame.view.admin.manager.AdminMenuRolePosOpManager;
import net.linlan.frame.view.admin.param.AdminUserVoParam;
import net.linlan.frame.view.admin.param.SysRoleVoParam;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.admin.vo.AdminUserVo;
import net.linlan.frame.view.admin.vo.DeptTreeRoleVo;
import net.linlan.frame.view.admin.vo.SysRoleVo;
import net.linlan.frame.web.model.TreeSelect;
import net.linlan.sys.role.dto.SysRoleDto;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.sys.role.service.SysRoleService;

/**
 * 角色信息
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("api/admin/")
public class SysRoleController extends BaseController {
    @Resource
    private SysRoleService               sysRoleService;
    @Resource
    private AdminRoleVoService           adminRoleVoService;
    @Resource
    private TokenService                 tokenService;
    @Resource
    private SysPermissionService         sysPermissionService;
    @Resource
    private AdminUserService             adminUserService;
    @Resource
    private AdminDeptService             adminDeptService;
    @Resource
    private AdminMenuRolePosOpManager    adminMenuRolePosOpManager;
    @Resource
    private AdminMenuRolePosEntryManager adminMenuRolePosEntryManager;

    /**
     * 获取角色列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取角色列表")
    @PreAuthorize("@ss.hasPerms('admin:role:list')")
    @GetMapping("role/list")
    @Encrypt
    public ResponseResult<List<SysRoleVo>> list(SysRoleVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<SysRoleDto> result = sysRoleService.getPageDto(param.toModelParam());
        if (result == null) {
            return empty();
        }
        List<SysRoleVo> vos = Lists.transform(result.getResult(), SysRoleVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 角色信息导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "角色信息导出", category = 52)
    @PreAuthorize("@ss.hasPerms('admin:role:export')")
    @PostMapping("role/export")
    @Encrypt
    public void export(HttpServletResponse response, SysRoleVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<SysRoleDto> result = sysRoleService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<SysRoleVo> vos = Lists.transform(result.getResult(), SysRoleVo.DTO);
        ExcelUtil<SysRoleVo> util = new ExcelUtil<>(SysRoleVo.class);
        util.exportExcel(response, vos, "角色数据");
    }

    /**
     * 根据角色编号获取详细信息
     * @param roleId  角色ID
     * @return 返回对象
     */
    @PlatLog(value = "根据角色编号获取详细信息")
    @PreAuthorize("@ss.hasPerms('admin:role:detail')")
    @GetMapping(value = "role/{roleId}")
    @Encrypt
    public ResponseResult<SysRoleVo> getInfo(@PathVariable Long roleId) {
        if (ObjectUtils.isEmpty(roleId)) {
            return failure();
        }
        SysRoleVo vo = null;
        SysRole entity = sysRoleService.findById(roleId);
        if (entity != null) {
            vo = (SysRoleVo) SysRoleVo.TO.apply(entity);
        }
        return success(vo);
    }

    /**
     * 新增角色
     * @param input  角色对象
     * @return 返回对象
     */
    @PreAuthorize("@ss.hasPerms('admin:role:save')")
    @PlatLog(value = "新增角色", category = 10)
    @PostMapping("role/save")
    @Encrypt
    @LimitScope(name = "sysRoleSave", key = "sysRoleSave")
    public ResponseResult<String> save(@Validated @RequestBody SysRoleVo input) {
        if (!adminMenuRolePosEntryManager.checkRoleNameUnique(input)) {
            return error("新增角色'" + input.getRoleName() + "'失败，角色名称已存在");
        } else if (!adminMenuRolePosEntryManager.checkRoleCodeUnique(input)) {
            return error("新增角色'" + input.getRoleName() + "'失败，角色编码已存在");
        }
        if (adminMenuRolePosOpManager.doAdminRoleOp(ApiIntfConfig.VALUE_AT_ADD, null, input)) {
            return success();
        }
        return failure();
    }

    /**
     * 修改保存角色
     * @param input  角色对象
     * @return 返回对象
     */
    @PreAuthorize("@ss.hasPerms('admin:role:update')")
    @PlatLog(value = "修改保存角色", category = 20)
    @PostMapping("role/update")
    @Encrypt
    @LimitScope(name = "sysRoleUpdate", key = "sysRoleUpdate")
    public ResponseResult<String> update(@Validated @RequestBody SysRoleVo input) {
        if (!adminMenuRolePosEntryManager.checkRoleNameUnique(input)) {
            return error("修改角色'" + input.getRoleName() + "'失败，角色名称已存在");
        } else if (!adminMenuRolePosEntryManager.checkRoleCodeUnique(input)) {
            return error("修改角色'" + input.getRoleName() + "'失败，角色编码已存在");
        }
        if (adminMenuRolePosOpManager.doAdminRoleOp(ApiIntfConfig.VALUE_AT_UPDATE,
            input.getRoleId().toString(), input)) {
            // 更新缓存用户权限
            FrameUserDetails loginUser = getLoginUser();
            if (ObjectUtils.isNotEmpty(loginUser)) {
                AdminUserDto dto = adminUserService.getByUsername(loginUser.getUsername());
                loginUser.setPerms(sysPermissionService.getMenuPermission(dto));
                tokenService.setLoginUser(loginUser);
            }
            return success();
        }
        return failure();
    }

    /**
     * 新增角色及绑定菜单部门
     * @param input  角色对象
     * @return 返回对象
     */
    @PreAuthorize("@ss.hasPerms('admin:role:save')")
    @PlatLog(value = "新增角色及绑定菜单部门", category = 10)
    @PostMapping("role/save/all")
    @Encrypt
    @LimitScope(name = "sysRoleSave", key = "sysRoleSave")
    public ResponseResult<String> saveAll(@Validated @RequestBody SysRoleVo input) {
        if (!adminMenuRolePosEntryManager.checkRoleNameUnique(input)) {
            return error("新增角色'" + input.getRoleName() + "'失败，角色名称已存在");
        } else if (!adminMenuRolePosEntryManager.checkRoleCodeUnique(input)) {
            return error("新增角色'" + input.getRoleName() + "'失败，角色编码已存在");
        }
        if (adminMenuRolePosOpManager.doAdminRoleOp(ApiIntfConfig.VALUE_AT_ADD, null, input)) {
            return success();
        }
        return failure();
    }

    /**
     * 修改保存角色及绑定菜单部门
     * @param input  角色对象
     * @return 返回对象
     */
    @PreAuthorize("@ss.hasPerms('admin:role:update')")
    @PlatLog(value = "修改保存角色及绑定菜单部门", category = 20)
    @PostMapping("role/update/all")
    @Encrypt
    @LimitScope(name = "sysRoleUpdate", key = "sysRoleUpdate")
    public ResponseResult<String> updateAll(@Validated @RequestBody SysRoleVo input) {
        if (!adminMenuRolePosEntryManager.checkRoleNameUnique(input)) {
            return error("修改角色'" + input.getRoleName() + "'失败，角色名称已存在");
        } else if (!adminMenuRolePosEntryManager.checkRoleCodeUnique(input)) {
            return error("修改角色'" + input.getRoleName() + "'失败，角色编码已存在");
        }
        if (adminMenuRolePosOpManager.doAdminRoleOp(ApiIntfConfig.VALUE_AT_UPDATE,
            input.getRoleId().toString(), input)) {
            // 更新缓存用户权限
            FrameUserDetails loginUser = getLoginUser();
            if (ObjectUtils.isNotEmpty(loginUser)) {
                AdminUserDto dto = adminUserService.getByUsername(loginUser.getUsername());
                loginUser.setPerms(sysPermissionService.getMenuPermission(dto));
                tokenService.setLoginUser(loginUser);
            }
            return success();
        }
        return failure();
    }

    /**
     * 删除角色
     * @param roleIds  角色Ids
     * @return 删除状态
     */
    @PreAuthorize("@ss.hasPerms('admin:role:delete')")
    @PlatLog(value = "删除角色", category = 40)
    @PostMapping("role/delete/{roleIds}")
    @Encrypt
    @LimitScope(name = "sysRoleDelete", key = "sysRoleDelete")
    public ResponseResult<String> delete(@PathVariable Long[] roleIds) {
        //        return returnRow(roleService.deleteRoleByIds(roleIds));
        //        if (ObjectUtils.isEmpty(roleIds)){
        //            return failure();
        //        }
        //        if (PositionOpManager.doSysPositionOp(ApiIntfConfig.VALUE_AT_DELETE, StringUtils.jsonJoin(roleIds), null)){
        //            return success();
        //        }
        //        return failure();
        for (Long roleId : roleIds) {
            SysRole adminRole = new SysRole();
            adminRole.setId(roleId);
            adminRole.setStatus(2);
            sysRoleService.update(adminRole);
        }
        return success();
    }

    /**
     * 停用启用角色
     * @param input  角色对象
     * @return 返回对象
     */
    @PreAuthorize("@ss.hasPerms('admin:role:delete')")
    @PlatLog(value = "停用启用角色", category = 50)
    @PostMapping("role/disable/{roleId}")
    @Encrypt
    @LimitScope(name = "sysRoleDisable", key = "sysRoleDisable")
    public ResponseResult<String> disable(@RequestBody SysRole input) {
        SysRole adminRole = new SysRole();
        adminRole.setId(input.getId());
        adminRole.setLastTime(new Timestamp(System.currentTimeMillis()));
        adminRole.setStatus(input.getStatus());
        sysRoleService.update(adminRole);
        return success();
    }

    /**
     * 角色绑定菜单
     * @param input  角色对象
     * @return 返回对象
     */
    @PreAuthorize("@ss.hasPerms('admin:role:delete')")
    @PlatLog(value = "角色绑定菜单", category = 53)
    @PostMapping("role/bindMenu/{roleId}")
    @Encrypt
    @LimitScope(name = "sysRoleBindMenu", key = "sysRoleBindMenu")
    public ResponseResult<String> bindMenu(@RequestBody SysRoleVo input) {
        if (adminMenuRolePosOpManager.doAdminRoleOp(ApiIntfConfig.VALUE_AT_BIND,
            input.getRoleId().toString(), input)) {
            // 更新缓存用户权限
            FrameUserDetails loginUser = getLoginUser();
            if (ObjectUtils.isNotEmpty(loginUser)) {
                AdminUserDto dto = adminUserService.getByUsername(loginUser.getUsername());
                loginUser.setPerms(sysPermissionService.getMenuPermission(dto));
                tokenService.setLoginUser(loginUser);
            }
            return success("菜单授权成功");
        }
        return failure();
    }

    /**
     * 角色绑定部门
     * @param input  角色对象
     * @return 返回对象
     */
    @PreAuthorize("@ss.hasPerms('admin:role:delete')")
    @PlatLog(value = "角色绑定部门", category = 50)
    @PostMapping("role/bindDept/{roleId}")
    @Encrypt
    @LimitScope(name = "sysRoleBindDept", key = "sysRoleBindDept")
    public ResponseResult<String> bindDept(@RequestBody SysRoleVo input) {
        if (adminMenuRolePosOpManager.doAdminRoleOp(ApiIntfConfig.VALUE_AT_OTHER,
            input.getRoleId().toString(), input)) {
            return success("部门授权成功");
        }
        return failure();
    }

    /**
     * 获取角色选择框列表
     * @return 返回对象
     */
    @PlatLog(value = "获取角色选择框列表")
    @PreAuthorize("@ss.hasPerms('admin:role:detail')")
    @GetMapping("role/option/select")
    @Encrypt
    public ResponseResult<List<SysRoleVo>> optionSelect() {
        List<SysRoleVo> vos = adminMenuRolePosEntryManager.selectRoleAll();
        if (ObjectUtils.isEmpty(vos)) {
            return failure();
        }
        return success(vos);
    }

    /**
     * 查询已分配用户角色列表
     * @param user  用户查询参数
     * @return 返回对象
     */
    @PlatLog(value = "查询已分配用户角色列表")
    @PreAuthorize("@ss.hasPerms('admin:role:list')")
    @GetMapping("role/authUser/allocatedList")
    @Encrypt
    public ResponseResult<List<AdminUserVo>> allocatedList(AdminUserVoParam user) {
        List<AdminUserDto> adminUserDtoList = adminUserService
            .selectAllocatedList(user.toModelParam());
        if (adminUserDtoList == null) {
            return empty();
        }
        List<AdminUserVo> vos = Lists.transform(adminUserDtoList, AdminUserVo.DTO);
        return success(vos);
    }

    /**
     * 查询未分配用户角色列表
     * @param user  用户查询参数
     * @return 返回对象
     */
    @PlatLog(value = "查询未分配用户角色列表")
    @PreAuthorize("@ss.hasPerms('admin:role:list')")
    @GetMapping("role/authUser/unallocatedList")
    @Encrypt
    public ResponseResult<List<AdminUserVo>> unallocatedList(AdminUserVoParam user) {
        List<AdminUserDto> adminUserDtoList = adminUserService
            .selectUnallocatedList(user.toModelParam());
        if (adminUserDtoList == null) {
            return empty();
        }
        List<AdminUserVo> vos = Lists.transform(adminUserDtoList, AdminUserVo.DTO);
        return success(vos);
    }

    /**
     * 取消授权用户
     * @param input  角色对象
     * @return 取消结果
     */
    @PreAuthorize("@ss.hasPerms('admin:role:update')")
    @PlatLog(value = "取消授权用户", category = 31)
    @PostMapping("role/authUser/cancel")
    @Encrypt
    @LimitScope(name = "sysRoleCancel", key = "sysRoleCancel")
    public ResponseResult<String> cancelAuthUser(@RequestBody AdminUserRole input) {
        return returnRow(adminRoleVoService.deleteAuthUser(input.getRoleId(), input.getAdminId()));
    }

    /**
     * 批量取消授权用户
     * @param roleId  角色ID
     * @param adminIds  管理员Ids
     * @return 取消结果
     */
    @PreAuthorize("@ss.hasPerms('admin:role:update')")
    @PlatLog(value = "批量取消授权用户", category = 31)
    @PostMapping("role/authUser/cancelAll")
    @Encrypt
    @LimitScope(name = "sysRoleCancelAll", key = "sysRoleCancelAll")
    public ResponseResult<String> cancelAuthUserAll(Long roleId, Long[] adminIds) {
        return returnRow(adminRoleVoService.deleteAuthUsers(roleId, adminIds));
    }

    /**
     * 批量选择用户授权
     * @param roleId  角色ID
     * @param adminIds  管理员Ids
     * @return 授权结果
     */
    @PreAuthorize("@ss.hasPerms('admin:role:update')")
    @PlatLog(value = "批量选择用户授权", category = 31)
    @PostMapping("role/authUser/selectAll")
    @Encrypt
    @LimitScope(name = "sysRoleSelectAll", key = "sysRoleSelectAll")
    public ResponseResult<String> selectAuthUserAll(Long roleId, Long[] adminIds) {
        adminMenuRolePosEntryManager.checkRoleDataScope(roleId);
        return returnRow(adminRoleVoService.insertAuthUsers(roleId, adminIds));
    }

    /**
     * 获取对应角色部门树列表
     * @param roleId  角色ID
     * @return 返回对象
     */
    @PlatLog(value = "获取对应角色部门树列表")
    @PreAuthorize("@ss.hasPerms('admin:role:detail')")
    @GetMapping(value = "role/deptTree/{roleId}")
    @Encrypt
    public ResponseResult<DeptTreeRoleVo> deptTree(@PathVariable("roleId") Long roleId) {
        DeptTreeRoleVo deptTreeRoleVo = new DeptTreeRoleVo();
        List<Long> checkedKeys = adminDeptService.selectDeptListByRoleId(roleId);
        List<TreeSelect> depts = adminDeptService.selectDeptTreeList(new AdminDeptParam());
        deptTreeRoleVo.setCheckedKeys(checkedKeys);
        deptTreeRoleVo.setDepts(depts);
        return ResponseResult.ok(deptTreeRoleVo);
    }

}
