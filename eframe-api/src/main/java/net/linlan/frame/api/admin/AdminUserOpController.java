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
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.*;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.admin.service.InitialConfigService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.view.admin.manager.AdminMenuRolePosEntryManager;
import net.linlan.frame.view.admin.manager.AdminUserOpManager;
import net.linlan.frame.view.admin.param.AdminUserVoParam;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.admin.vo.AdminUserVo;
import net.linlan.frame.view.admin.vo.LoginUserRolesVo;
import net.linlan.frame.view.admin.vo.SysRoleVo;
import net.linlan.utils.crypt.ShaUtils;

/**
 *
 * AdminUser控制域:管理用户增删改操作控制类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@RestController
@RequestMapping("api/admin")
public class AdminUserOpController extends BaseController {

    @Resource
    private AdminUserOpManager           adminUserOpManager;
    @Resource
    private AdminMenuRolePosEntryManager adminMenuRolePosEntryManager;
    @Resource
    private AdminDeptService             adminDeptService;
    @Resource
    private AdminUserService             adminUserService;
    @Resource
    private InitialConfigService         initialConfigService;

    /** AdminUser Operation. AdminUser数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入Vo对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PlatLog(value = "新增用户信息", category = 10)
    @PreAuthorize("@ss.hasPerms('admin:user:save')")
    @PostMapping("user/save")
    @Encrypt
    @LimitScope(name = "adminUserSave", key = "adminUserSave")
    public ResponseResult<String> adminUserAddOp(@RequestBody AdminUserVo input) {
        adminDeptService.checkDeptDataScope(input.getDeptId());
        adminMenuRolePosEntryManager.checkRoleDataScope(input.getRoleIds());
        if (!adminUserService.checkUsernameUnique(input.getUsername(), input.getId())) {
            return error("新增用户'" + input.getUsername() + "'失败，登录账号已存在");
        } else if (ObjectUtils.isNotEmpty(input.getMobile())
                   && !adminUserService.checkMobileUnique(input.getMobile(), input.getId())) {
            return error("新增用户'" + input.getUsername() + "'失败，手机号码已存在");
        } else if (ObjectUtils.isNotEmpty(input.getEmail())
                   && !adminUserService.checkEmailUnique(input.getEmail(), input.getId())) {
            return error("新增用户'" + input.getUsername() + "'失败，邮箱账号已存在");
        }
        input.setId(RandomUtils.randomLid());
        input.setCreatorId(getUsername());
        String password = input.getPassword();
        if (StringUtils.isBlank(password)) { //默认一个初始化密码
            password = initialConfigService.selectConfigByKey("sys.user.initPassword");
        }
        input.setPassword(ShaUtils.encryptPassword(password));
        if (adminUserOpManager.doAdminUserOp(ApiIntfConfig.VALUE_AT_ADD, null, input)) {
            return success();
        }
        return failure();
    }

    /** AdminUser Operation. AdminUser数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入Vo对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PlatLog(value = "修改用户信息", category = 20)
    @PreAuthorize("@ss.hasPerms('admin:user:update')")
    @PostMapping("user/update")
    @Encrypt
    @LimitScope(name = "adminUserUpdate", key = "adminUserUpdate")
    public ResponseResult<String> adminUserUpdateOp(@RequestBody AdminUserVo input) {
        adminUserService.checkUserAllowed(new AdminUser(input.getId()));
        adminUserService.checkUserDataScope(input.getId());
        adminDeptService.checkDeptDataScope(input.getDeptId());
        adminMenuRolePosEntryManager.checkRoleDataScope(input.getRoleIds());
        if (!adminUserService.checkUsernameUnique(input.getUsername(), input.getId())) {
            return error("修改用户'" + input.getUsername() + "'失败，登录账号已存在");
        } else if (ObjectUtils.isNotEmpty(input.getMobile())
                   && !adminUserService.checkMobileUnique(input.getMobile(), input.getId())) {
            return error("修改用户'" + input.getUsername() + "'失败，手机号码已存在");
        } else if (ObjectUtils.isNotEmpty(input.getEmail())
                   && !adminUserService.checkEmailUnique(input.getEmail(), input.getId())) {
            return error("修改用户'" + input.getUsername() + "'失败，邮箱账号已存在");
        }
        if (adminUserOpManager.doAdminUserOp(ApiIntfConfig.VALUE_AT_UPDATE,
            input.getId().toString(), input)) {
            return success();
        }
        return failure();
    }

    /**
     * 停用启用用户
     * @param input  用户对象
     * @return  返回结果
     */
    @PreAuthorize("@ss.hasPerms('admin:user:delete')")
    @PlatLog(value = "停用启用用户", category = 50)
    @PostMapping("user/disable/{id}")
    @Encrypt
    public ResponseResult<String> disable(@RequestBody AdminUser input) {
        if (input.getId().equals(getAdminId())) {
            return error("当前用户不能停用");
        }
        adminUserService.update(input);
        return success();
    }

    /**
     * 重置密码
     * @param ids  管理员Ids
     * @param input  用户对象
     * @return  返回结果
     */
    @PreAuthorize("@ss.hasPerms('admin:user:delete')")
    @PlatLog(value = "重置密码", category = 51)
    @PostMapping("user/resetpassword/{ids}")
    @Encrypt
    public ResponseResult<String> resetpassword(@PathVariable Long[] ids,
                                                @RequestBody AdminUserVo input) {
        for (Long id : ids) {
            AdminUser adminUser = new AdminUser();
            adminUser.setId(id);
            String password = input.getPassword();
            if (StringUtils.isBlank(password)) { //默认一个初始化密码
                password = initialConfigService.selectConfigByKey("sys.user.initPassword");
            }
            adminUser.setPassword(ShaUtils.encryptPassword(password));
            adminUserService.update(adminUser);
        }
        return success();
    }

    /**
     * 删除用户
     * @param adminIds  管理员Ids
     * @return  返回结果
     */
    @PreAuthorize("@ss.hasPerms('admin:user:delete')")
    @PlatLog(value = "删除用户", category = 40)
    @PostMapping("user/delete/{adminIds}")
    @Encrypt
    @LimitScope(name = "adminUserDelete", key = "adminUserDelete")
    public ResponseResult<String> delete(@PathVariable Long[] adminIds) {
        if (ArrayUtils.contains(adminIds, getAdminId())) {
            return error("当前用户不能删除");
        }
        adminUserService.deleteByIdsWithRelation(adminIds);
        return success();
    }

    /**
     * 用户数据导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "用户数据导出", category = 52)
    @PreAuthorize("@ss.hasPerms('admin:user:export')")
    @PostMapping("user/export")
    @Encrypt
    public void export(HttpServletResponse response, AdminUserVoParam param) {
        Page<AdminUserDto> adminUserDtoList = adminUserService.getPageDto(param.toModelParam());
        if (adminUserDtoList == null) {
            return;
        }
        List<AdminUserVo> vos = Lists.transform(adminUserDtoList.getResult(), AdminUserVo.DTO);
        ExcelUtil<AdminUserVo> util = new ExcelUtil<AdminUserVo>(AdminUserVo.class);
        util.exportExcel(response, vos, "用户数据");
    }

    /**
     * 用户数据导入
     * @param file  文件
     * @param updateSupport     是否支持更新
     * @return 导入结果
     * @throws Exception    异常
     */
    @PlatLog(value = "用户导入数据", category = 51)
    @PreAuthorize("@ss.hasPerms('admin:user:import')")
    @PostMapping("user/importData")
    @Encrypt
    public ResponseResult<String> importData(MultipartFile file,
                                             boolean updateSupport) throws Exception {
        ExcelUtil<AdminUserVo> util = new ExcelUtil<AdminUserVo>(AdminUserVo.class);
        List<AdminUserVo> userList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = adminUserOpManager.importUser(userList, updateSupport, operName);
        return success(message);
    }

    /**
     * 用户导入模板下载
     * @param response  响应
     */
    @PlatLog(value = "用户导入模板下载", category = 20)
    @PostMapping("user/importTemplate")
    @Encrypt
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<AdminUserVo> util = new ExcelUtil<AdminUserVo>(AdminUserVo.class);
        util.importTemplateExcel(response, "用户数据");
    }

    /**
     * 重置密码
     * @param input     输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:user:resetPwd')")
    @Encrypt
    @PlatLog(value = "重置密码", category = 20)
    @PostMapping("user/resetPwd")
    public ResponseResult<String> resetPwd(@RequestBody AdminUserVo input) {
        adminUserService.checkUserAllowed(new AdminUser(input.getId()));
        adminUserService.checkUserDataScope(input.getId());
        String newPassword = ShaUtils.encryptPassword(input.getPassword());
        return returnRow(adminUserService.resetUserPwd(input.getUsername(), newPassword));
    }

    /**
     * 用户状态修改
     * @param input     输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:user:update')")
    @PlatLog(value = "用户状态修改", category = 20)
    @PostMapping("user/changeStatus")
    @Encrypt
    public ResponseResult<String> changeStatus(@RequestBody AdminUserVo input) {
        adminUserService.checkUserAllowed(new AdminUser(input.getId()));
        adminUserService.checkUserDataScope(input.getId());
        return returnRow(adminUserService.updateUserStatus(input.getId(), input.getStatus()));
    }

    /**
     * 根据用户编号获取授权角色
     * @param adminId     管理员ID
     * @return  操作结果
     */
    @PlatLog(value = "根据用户编号获取授权角色")
    @PreAuthorize("@ss.hasPerms('admin:user:detail')")
    @GetMapping("user/authRole/{adminId}")
    @Encrypt
    public ResponseResult<String> authRole(@PathVariable("adminId") Long adminId) {
        LoginUserRolesVo loginUserRolesVo = new LoginUserRolesVo();
        AdminUserDto dto = adminUserService.getMoreById(adminId);
        AdminUserVo vo = null;
        if (ObjectUtils.isNotEmpty(dto)) {
            vo = (AdminUserVo) AdminUserVo.DTO.apply(dto);
        }
        List<SysRoleVo> roles = adminMenuRolePosEntryManager.selectRolesByAdminId(adminId);
        loginUserRolesVo.setUser(vo);
        loginUserRolesVo.setRoles(AdminUser.isAdmin(adminId) ? roles
            : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));

        return success(loginUserRolesVo);
    }

    /**
     * 用户授权角色
     * @param adminId     管理员ID
     * @param roleIds     角色Ids
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:user:update')")
    @PlatLog(value = "用户授权角色", category = 31)
    @PostMapping("user/authRole")
    @Encrypt
    public ResponseResult<String> insertAuthRole(Long adminId, Long[] roleIds) {
        adminUserService.checkUserDataScope(adminId);
        adminMenuRolePosEntryManager.checkRoleDataScope(roleIds);
        adminUserService.insertUserAuth(adminId, roleIds);
        return success();
    }

}
