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
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Validator;

import net.linlan.utils.crypt.ShaUtils;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.admin.dao.AdminUserPositionDao;
import net.linlan.frame.admin.dao.AdminUserRoleDao;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.admin.service.InitialConfigService;
import net.linlan.frame.comm.manager.AsyncManager;
import net.linlan.frame.comm.manager.factory.AsyncFactory;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.view.admin.vo.AdminUserVo;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.frame.web.model.RegisterBody;
import net.linlan.sys.base.constant.CreateTypeEnum;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.MessageUtils;
import net.linlan.utils.bean.BeanValidators;
import net.linlan.utils.constant.CacheConstants;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.constant.UserConstants;
import net.linlan.utils.exception.CommonException;
import net.linlan.utils.exception.user.CaptchaException;
import net.linlan.utils.exception.user.CaptchaExpireException;
import static net.linlan.utils.constant.Constants.ENT_APP_ID;

/**
 *
 * AdminUser视图域:管理用户增删改操作管理类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Component
@Slf4j
public class AdminUserOpManager {
    @Resource
    private RedisService         redisService;
    @Resource
    private AdminUserService     adminUserService;
    @Resource
    private InitialConfigService initialConfigService;
    @Resource
    private AdminUserRoleDao     adminUserRoleDao;
    @Resource
    private AdminUserPositionDao adminUserPositionDao;
    @Resource
    private AdminDeptService     adminDeptService;
    @Resource
    protected Validator          validator;

    /** 执行AdminUser对象Op操作，进行增加、删除、修改业务
     * @param action 操作类型:10,新增;20,修改;40,删除|20
     * @param id 企业管理用户ID:null,1;1,2,3|1
     * @param input 输入对象信息
     * @return {@link Boolean}:true,success;false,failure
     */
    public boolean doAdminUserOp(String action, String id, AdminUserVo input) {
        if (StringUtils.isBlank(action)) {
            return false;
        }
        if (StringUtils.isNotBlank(action)) {
            if (action.equals(ApiIntfConfig.VALUE_AT_ADD)) {
                if (ObjectUtils.isEmpty(input)) {
                    return false;
                }
                //保存AdminUser
                AdminUser adminUser = new AdminUser();
                if (ObjectUtils.isNotEmpty(input.getId())) {
                    adminUser.setId(input.getId());
                }
                adminUser.setUserId(input.getUserId());
                adminUser.setOrganId(input.getOrganId());
                adminUser.setDeptId(input.getDeptId());
                adminUser.setCreateType(CreateTypeEnum.INPUT.getKey());
                adminUser.setName(input.getName());
                if (StringUtils.isBlank(adminUser.getName())) {
                    adminUser.setName(input.getNickName());
                }
                adminUser.setUsername(input.getUsername());
                adminUser.setMobile(input.getMobile());
                adminUser.setEmail(input.getEmail());
                adminUser.setPassword(input.getPassword());
                adminUser.setImagePath(input.getImagePath());
                adminUser.setAdminType("ADMIN");
                adminUser.setIsSuperAdmin(input.getIsSuperAdmin());
                adminUser.setIsAuditAdmin(input.getIsAuditAdmin());
                adminUser.setIsSelfAdmin(input.getIsSelfAdmin());
                adminUser.setLastAppId(ENT_APP_ID);
                adminUser.setLastLoginTime(input.getLastLoginTime());
                adminUser.setLastLoginIp(input.getLastLoginIp());
                adminUser.setStatus(input.getStatus());
                adminUser.setDelFlag(input.getDelFlag());
                adminUser.setSpare1(input.getDescription());
                adminUser.setLoginCount(0);
                adminUserService.save(adminUser);
                // 新增用户岗位关联
                adminUserService.insertUserPost(input.getId(), input.getPositionIds());
                // 新增用户与角色管理
                adminUserService.insertUserRole(input.getId(), input.getRoleIds());
                return true;
            } else if (action.equals(ApiIntfConfig.VALUE_AT_UPDATE)) {
                if (ObjectUtils.isEmpty(id) || ObjectUtils.isEmpty(input)) {
                    return false;
                }
                if (isValidUpdateSuccess(id)) {
                    AdminUser adminUser = adminUserService.findById(Long.valueOf(id));
                    if (adminUser != null) {
                        //部分字段需要单独更新的，此处请删除，如密码、创建时间等，如有关联更新请添加关联方法
                        adminUser.setUserId(input.getUserId());
                        adminUser.setOrganId(input.getOrganId());
                        adminUser.setDeptId(input.getDeptId());
                        adminUser.setCreateType(CreateTypeEnum.INPUT.getKey());
                        adminUser.setName(input.getName());
                        if (StringUtils.isBlank(adminUser.getName())) {
                            adminUser.setName(input.getNickName());
                        }
                        adminUser.setUsername(input.getUsername());
                        adminUser.setMobile(input.getMobile());
                        adminUser.setEmail(input.getEmail());
                        adminUser.setPassword(input.getPassword());
                        adminUser.setImagePath(input.getImagePath());
                        adminUser.setAdminType("ADMIN");
                        adminUser.setIsSuperAdmin(input.getIsSuperAdmin());
                        adminUser.setIsAuditAdmin(input.getIsAuditAdmin());
                        adminUser.setIsSelfAdmin(input.getIsSelfAdmin());
                        adminUser.setLastAppId(ENT_APP_ID);
                        adminUser.setLastLoginTime(input.getLastLoginTime());
                        adminUser.setLastLoginIp(input.getLastLoginIp());
                        adminUser.setStatus(input.getStatus());
                        adminUser.setDelFlag(input.getDelFlag());
                        adminUser.setSpare1(input.getDescription());
                        // 删除用户与角色关联
                        adminUserRoleDao.deleteByAdminId(input.getId());
                        // 新增用户与角色管理
                        adminUserService.insertUserRole(input.getId(), input.getRoleIds());
                        // 删除用户与岗位关联
                        adminUserPositionDao.deleteUserPositionByAdminId(input.getId());
                        // 新增用户与岗位管理
                        adminUserService.insertUserPost(input.getId(), input.getPositionIds());
                        adminUserService.update(adminUser);
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

    /**
     * 注册
     * @param registerBody  注册体
     * @return 注册状态
     */
    public String register(RegisterBody registerBody) {
        String msg = "", username = registerBody.getUsername(),
                password = registerBody.getPassword();
        AdminUser adminUser = new AdminUser();
        Long id = RandomUtils.randomLid();
        adminUser.setId(id);
        adminUser.setUsername(username);

        // 验证码开关
        boolean captchaEnabled = initialConfigService.selectCaptchaEnabled();
        if (captchaEnabled) {
            validateCaptcha(username, registerBody.getCode(), registerBody.getUuid());
        }

        if (StringUtils.isEmpty(username)) {
            msg = "用户名不能为空";
        } else if (StringUtils.isEmpty(password)) {
            msg = "用户密码不能为空";
        } else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                   || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            msg = "账户长度必须在2到20个字符之间";
        } else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                   || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            msg = "密码长度必须在5到20个字符之间";
        } else if (!adminUserService.checkUsernameUnique(adminUser.getUsername(),
            adminUser.getId())) {
            msg = "保存用户'" + username + "'失败，注册账号已存在";
        } else {
            adminUser.setName(username);
            adminUser.setPassword(ShaUtils.encryptPassword(password));
            boolean regFlag = adminUserService.registerUser(adminUser);
            if (!regFlag) {
                msg = "注册失败,请联系系统管理人员";
            } else {
                AsyncManager.me().execute(AsyncFactory.saveAdminLoginLog(id, username,
                    Constants.REGISTER, MessageUtils.message("user.register.success"), ENT_APP_ID));
            }
        }
        return msg;
    }

    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     */
    public void validateCaptcha(String username, String code, String uuid) {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisService.get(verifyKey);
        redisService.delete(verifyKey);
        if (captcha == null) {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaException();
        }
    }

    /**
     * 导入用户数据
     *
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importUser(List<AdminUserVo> userList, Boolean isUpdateSupport, String operName) {
        if (ObjectUtils.isEmpty(userList) || userList.size() == 0) {
            throw new CommonException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (AdminUserVo user : userList) {
            try {
                // 验证是否存在这个用户
                AdminUser u = adminUserService.selectUserByUsername(user.getUsername());
                if (ObjectUtils.isEmpty(u)) {
                    BeanValidators.validateWithException(validator, user);
                    adminDeptService.checkDeptDataScope(user.getDeptId());
                    String password = initialConfigService
                        .selectConfigByKey("sys.user.initPassword");
                    user.setPassword(ShaUtils.encryptPassword(password));
                    user.setCreatorId(operName);
                    adminUserService.save(AdminUserVo.transTo(user));
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getUsername() + " 导入成功");
                } else if (isUpdateSupport) {
                    BeanValidators.validateWithException(validator, user);
                    adminUserService.checkUserAllowed(new AdminUser(u.getId()));
                    adminUserService.checkUserDataScope(u.getId());
                    adminDeptService.checkDeptDataScope(user.getDeptId());
                    user.setId(u.getId());
                    adminUserService.update(AdminUserVo.transTo(user));
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getUsername() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getUsername() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getUsername() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CommonException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

}
