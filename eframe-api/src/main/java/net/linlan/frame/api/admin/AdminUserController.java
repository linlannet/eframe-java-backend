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
import javax.servlet.http.HttpServletRequest;
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
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.dao.AdminUserRoleDao;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.dto.AdminUserRoleDto;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.param.AdminDeptParam;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.admin.service.InitialConfigService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.view.admin.manager.AdminMenuRolePosEntryManager;
import net.linlan.frame.view.admin.manager.AdminUserOpManager;
import net.linlan.frame.view.admin.param.AdminUserVoParam;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.admin.vo.*;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.frame.web.model.TreeSelect;
import net.linlan.sys.comm.dto.FileInfo;
import net.linlan.sys.comm.service.UploadFileService;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.crypt.ShaUtils;

/**
 *
 * 管理用户查询读取控制类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@RestController
@RequestMapping("api/admin/")
public class AdminUserController extends BaseController {

    @Resource
    private AdminMenuRolePosEntryManager PositionEntryManager;
    @Resource
    private AdminUserService             adminUserService;
    @Resource
    private AdminDeptService             adminDeptService;
    @Resource
    private AdminUserRoleDao             adminUserRoleDao;
    @Resource
    private AdminUserOpManager           adminUserOpManager;
    @Resource
    private AdminMenuRolePosEntryManager adminMenuRolePosEntryManager;
    @Resource
    private InitialConfigService         initialConfigService;
    @Resource
    private TokenService                 tokenService;
    @Resource
    private UploadFileService            uploadFileService;

    /**
     * 获取用户列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取用户列表")
    @PreAuthorize("@ss.hasPerms('admin:user:list')")
    @GetMapping("user/list")
    @Encrypt
    public ResponseResult<List<AdminUserVo>> list(AdminUserVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<AdminUserDto> adminUserDtoList = adminUserService.getPageDto(param.toModelParam());
        if (adminUserDtoList == null) {
            return empty();
        }
        List<AdminUserVo> vos = Lists.transform(adminUserDtoList.getResult(), AdminUserVo.DTO);
        return successPage(vos, adminUserDtoList.getPageSize(), adminUserDtoList.getPageNum(),
            adminUserDtoList.getTotal());
    }

    /**
     * 根据用户编号获取详细信息
     * @param adminId  管理员ID
     * @return  返回对象
     */
    @PlatLog(value = "根据用户编号获取详细信息")
    @PreAuthorize("@ss.hasPerms('admin:user:detail')")
    @GetMapping(value = { "user/{adminId}" })
    @Encrypt
    public ResponseResult<LoginUserRolesPosVo> getInfo(@PathVariable(value = "adminId", required = false) Long adminId) {
        LoginUserRolesPosVo loginUserRolesPosVo = new LoginUserRolesPosVo();
        if (ObjectUtils.isNotEmpty(adminId)) {
            adminUserService.checkUserDataScope(adminId);
            AdminUserDto dto = adminUserService.getMoreById(adminId);
            AdminUserVo vo = null;
            if (ObjectUtils.isNotEmpty(dto)) {
                vo = (AdminUserVo) AdminUserVo.DTO.apply(dto);
            }
            loginUserRolesPosVo.setUser(vo);
            loginUserRolesPosVo.setPositionIds(adminUserService.selectPostListByAdminId(adminId));
            if (vo != null && vo.getRoles() != null) {
                loginUserRolesPosVo.setRoleIds(
                    vo.getRoles().stream().map(SysRole::getId).collect(Collectors.toList()));
            }
        }
        List<SysRoleVo> roles = PositionEntryManager.selectRoleAll();
        loginUserRolesPosVo.setRoles(AdminUserVo.isAdmin(adminId) ? roles
            : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        List<SysPositionVo> positions = PositionEntryManager.selectPositionAll();
        loginUserRolesPosVo.setPositions(positions);
        List<AdminUserRoleDto> roleDtoList = adminUserRoleDao.selectUserRoleListByAdminId(adminId);
        loginUserRolesPosVo.setRoleList(roleDtoList);
        return success(loginUserRolesPosVo);
    }

    /**
     * 获取用户部门树列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取用户部门树列表")
    @PreAuthorize("@ss.hasPerms('admin:user:list')")
    @GetMapping("user/deptTree")
    @Encrypt
    public ResponseResult<List<TreeSelect>> deptTree(AdminDeptParam param) {
        return success(adminDeptService.selectDeptTreeList(param));
    }

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
        if (input.getUserId().equals(SecurityUtils.getUserId())) {
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
        String userId = SecurityUtils.getUserId();
        AdminUser adminUser = adminUserService.findByUserId(userId);
        if (adminUser == null) {
            return error("系统未登录");
        }
        if (ArrayUtils.contains(adminIds, adminUser.getId())) {
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
        loginUserRolesVo.setRoles(dto.isAdmin() ? roles
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

    /**
     * 个人资料信息
     * @return  个人资料信息
     */
    @PlatLog(value = "个人资料信息查询")
    @GetMapping("/user/profile")
    @Encrypt
    public ResponseResult<LoginUserProfileVo> profile() {
        FrameUserDetails loginUser = getLoginUser();
        LoginUserProfileVo loginUserProfileVo = new LoginUserProfileVo();
        loginUserProfileVo.setUser(loginUser);
        loginUserProfileVo
            .setRoleGroup(adminUserService.selectUserRoleGroup(loginUser.getUsername()));
        loginUserProfileVo
            .setPositionGroup(adminUserService.selectUserPostGroup(loginUser.getUsername()));
        return ResponseResult.ok(loginUserProfileVo);
    }

    /**
     * 个人信息
     * @return  个人信息
     */
    @PlatLog(value = "个人信息查询")
    @GetMapping("/user/info")
    @Encrypt
    public ResponseResult<AdminUserVo> info() {
        FrameUserDetails loginUser = getLoginUser();
        AdminUserDto currentUser = adminUserService.getByUsername(loginUser.getUsername());

        AdminUserVo userVo = (AdminUserVo) AdminUserVo.DTO.apply(currentUser);

        return ResponseResult.ok(userVo);
    }

    /**
     * 修改用户个人信息
     * @param   input   当前输入对象
     * @return  修改状态
     */
    @PlatLog(value = "修改用户个人信息", category = 20)
    @PostMapping("/user/profile")
    @Encrypt
    public ResponseResult<Boolean> updateProfile(@RequestBody AdminUserVo input) {
        FrameUserDetails loginUser = getLoginUser();
        AdminUserDto currentUser = adminUserService.getByUsername(loginUser.getUsername());
        if (!currentUser.getMobile().equals(input.getMobile())) {
            if (ObjectUtils.isNotEmpty(input.getMobile())
                && !adminUserService.checkMobileUnique(input.getMobile(), input.getId())) {
                return error("修改用户'" + loginUser.getUsername() + "'失败，手机号码已存在");
            }
            currentUser.setMobile(input.getMobile());
        }
        if (!currentUser.getEmail().equals(input.getEmail())) {
            if (ObjectUtils.isNotEmpty(input.getEmail())
                && !adminUserService.checkEmailUnique(input.getEmail(), input.getId())) {
                return error("修改用户'" + loginUser.getUsername() + "'失败，邮箱账号已存在");
            }
            currentUser.setEmail(input.getEmail());
        }
        currentUser.setUsername(input.getUsername());
        currentUser.setName(input.getName());
        currentUser.setIsAuditAdmin(input.getIsAuditAdmin());

        if (adminUserService.updateUserProfile(currentUser) > 0) {
            loginUser.setUsername(input.getUsername());
            // 更新缓存用户信息
            tokenService.setLoginUser(loginUser);
            return success(Boolean.TRUE);
        }
        return error("修改个人信息异常，请联系管理员");
    }

    /**
     * 个人修改密码
     * @param vo    当前更新密码对象
     * @return  更新结果
     */
    @PlatLog(value = "个人修改密码", category = 20)
    @PostMapping("/user/updatePwd")
    @Encrypt
    public ResponseResult updatePwd(@RequestBody PasswordVo vo) {
        FrameUserDetails loginUser = getLoginUser();
        String username = loginUser.getUsername();
        AdminUserDto currentUser = adminUserService.getByUsername(loginUser.getUsername());

        String oldPassword = vo.getOldPassword();
        String newPassword = vo.getNewPassword();

        if (!ShaUtils.matchesPassword(oldPassword, currentUser.getPassword())) {
            return error("修改密码失败，旧密码错误");
        }
        if (ShaUtils.matchesPassword(newPassword, currentUser.getPassword())) {
            return error("新密码不能与旧密码相同");
        }

        newPassword = ShaUtils.encryptPassword(newPassword);
        if (adminUserService.resetUserPwd(username, newPassword) > 0) {
            // 更新缓存用户密码
            loginUser.setPassword(newPassword);
            tokenService.setLoginUser(loginUser);
            return success();
        }
        return error("修改密码异常，请联系管理员");
    }

    /**
     * 用户头像上传
     * @param file  文件
     * @param request     请求
     * @return 上传结果
     * @throws Exception    异常
     */
    @PlatLog(value = "用户头像上传", category = 20)
    @PostMapping("/user/imagePath")
    @Encrypt
    public ResponseResult<UserImagePathVo> imagePath(@RequestParam("file") MultipartFile file,
                                                     HttpServletRequest request) throws Exception {
        if (!file.isEmpty()) {
            FrameUserDetails loginUser = getLoginUser();
            String context = request.getContextPath();
            FileInfo fileInfo = uploadFileService.uploadFileByMember(file, context,
                Constants.ENT_APP_ID, loginUser.getUserId());
            String imagePath = fileInfo.getFileUrl();
            if (adminUserService.updateUserImagePath(loginUser.getUsername(), imagePath)) {
                UserImagePathVo userImagePathVo = new UserImagePathVo();
                userImagePathVo.setImageUrl(imagePath);
                // 更新缓存用户头像
                loginUser.setImagePath(imagePath);
                tokenService.setLoginUser(loginUser);
                return success(userImagePathVo);
            }
        }
        return error("上传图片异常，请联系管理员");
    }

}
