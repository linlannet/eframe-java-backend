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
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.linlan.annotation.Encrypt;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.frame.view.admin.vo.AdminUserVo;
import net.linlan.frame.view.admin.vo.LoginUserProfileVo;
import net.linlan.frame.view.admin.vo.PasswordVo;
import net.linlan.frame.view.admin.vo.UserImagePathVo;
import net.linlan.sys.comm.dto.FileInfo;
import net.linlan.sys.comm.service.UploadFileService;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.crypt.ShaUtils;

/**
 * 个人信息业务处理
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/admin")
public class ApiAdminUserV1Status extends BaseController {
    @Resource
    private AdminUserService  adminUserService;

    @Resource
    private TokenService      tokenService;

    @Resource
    private UploadFileService uploadFileService;

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
     * 个人重置密码
     * @param vo    当前更新密码对象
     * @return  更新结果
     */
    @PlatLog(value = "个人重置密码", category = 20)
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
