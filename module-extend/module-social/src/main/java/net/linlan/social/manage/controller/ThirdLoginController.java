/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.manage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.authn.group.constant.PublicGroupEnum;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.social.manage.constant.BindFromEnum;
import net.linlan.social.manage.service.JustAuthUserService;
import net.linlan.social.manage.service.ThirdLoginService;
import net.linlan.social.manage.vo.ThirdBindBody;
import net.linlan.social.manage.vo.ThirdLoginBody;
import net.linlan.social.manage.vo.ThirdUserInfo;
import net.linlan.social.permission.service.ThirdPermissionService;
import net.linlan.social.permission.service.UserRangeOrganService;
import net.linlan.social.third.service.ThirdMemberService;
import net.linlan.utils.exception.CommonException;
import static net.linlan.frame.web.SecurityUtils.getLoginUser;

/**
 * 第三方社交平台登录验证
 * 管理体系管理用户登录，覆盖系统管理员、各个角色岗位管理人员，执行第一步、第二步、第三步，无需进行人员信息添加，只需验证人员信息（暂时不考虑）
 * 会员体系管理用户登录，覆盖服务商工作人员、各类分组WEB端人员，执行第一步、第二步、第三步，无需进行人员信息添加，只需验证人员信息
 * 会员体系门户用户，覆盖网站一般用户、大屏一般用户、移动端一般用户，执行第一步、第二步、第四步、第三步，需要提前执行第四步，完成人员绑定
 * @author Linlan
 */
@Slf4j
@RestController
public class ThirdLoginController {

    @Resource
    private ThirdLoginService      thirdLoginService;
    @Resource
    private ThirdMemberService     thirdMemberService;
    @Resource
    private JustAuthUserService    justAuthUserService;
    @Resource
    private ThirdPermissionService thirdPermissionService;
    @Resource
    private UserRangeOrganService  userRangeOrganService;

    /** 根据类型，获取授权请求，第一步
     * @param source 来源类型，dingtalk|feishu|wechat_work|wechat_open|其他
     * @param response 响应
     * @throws IOException  异常
     */
    @PlatLog(value = "根据类型，获取授权请求", category = 10, srcCode = 1)
    @RequestMapping("/login/social/render/{source}")
    @Encrypt
    public void renderAuth(@PathVariable("source") String source,
                           HttpServletResponse response) throws IOException {
        AuthRequest authRequest = thirdMemberService.getAuthRequest(source);
        String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
        response.sendRedirect(authorizeUrl);
    }

    /** 根据类型，获取授权请求，第二步
     * @param source 来源类型，dingtalk|feishu|wechat_work|wechat_open|其他
     * @param callback 回调渲染
     * @return 页面跳转
     */
    @PlatLog(value = "根据类型，获取授权请求", category = 10, srcCode = 1)
    @RequestMapping("/login/social/callback/{source}")
    @Encrypt
    public ModelAndView callbackAuth(@PathVariable("source") String source, AuthCallback callback) {
        log.info("进入callback：" + source + " callback params：" + JSONObject.toJSONString(callback));

        Map<String, Object> map = new HashMap<>();
        map.put("platformType", source);
        map.put("state", callback.getState());
        map.put("code", callback.getCode());

        return new ModelAndView("third_login", map);
    }

    /**
     * 社交平台登录方法，第三步
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PlatLog(value = "社交平台登录方法", category = 10, srcCode = 1)
    @PostMapping("/login/social")
    @Encrypt
    @LimitScope(name = "thirdUserLogin", key = "thirdUserLogin")
    public ResponseResult<AppLoginInfo> socialLogin(@RequestBody ThirdLoginBody loginBody) {
        // 生成令牌
        AppLoginInfo appLoginInfo = thirdLoginService.socialLogin(loginBody);
        return ResponseResult.ok(appLoginInfo);
    }

    /** 第三方社交平台账号绑定，第四步
     * @param thirdBindBody    账户信息
     * @return  绑定状态
     */
    @PlatLog(value = "第三方社交平台账号绑定", category = 53, srcCode = 1)
    @PostMapping("/login/social/bind")
    @Encrypt
    @LimitScope(name = "thirdUserBind", key = "thirdUserBind")
    public ResponseResult<String> bind(@RequestBody ThirdBindBody thirdBindBody) {
        AuthRequest authRequest = thirdMemberService
            .getAuthRequest(thirdBindBody.getPlatformType());
        AuthCallback callback = AuthCallback.builder().code(thirdBindBody.getCode())
            .state(thirdBindBody.getState()).build();
        // 根据code，获取用户信息
        AuthResponse<AuthUser> response = authRequest.login(callback);
        // 判断是否成功
        if (!response.ok()) {
            throw new RuntimeException("第三方登录失败");
        }
        String bindFrom = "";
        if (StringUtils.isEmpty(thirdBindBody.getBindFrom())) {
            bindFrom = BindFromEnum.WEB.getKey();
        } else {
            bindFrom = thirdBindBody.getBindFrom();
        }
        // 绑定用户信息
        thirdMemberService.bindFromSocial(SecurityUtils.getUserId(), bindFrom,
            thirdBindBody.getPlatformType(), response.getData());

        //管理WEB端绑定方式
        if (bindFrom.equals(BindFromEnum.ADMIN_WORK.getKey())) {
            //管理端仅查询人员的角色、岗位，如果有配置则正常返回，如果人员未做任何配置，则提升失败
            if (!userRangeOrganService.saveOrUpdateFromAdmin(SecurityUtils.getLoginUser(),
                BindFromEnum.fromType(bindFrom))) {
                return ResponseResult.error("管理WEB端来源的绑定失败");
            }
        } else {
            //其他前端绑定逻辑，则需要将人员的分组信息保存到关系表内
            if (ObjectUtils.isEmpty(userRangeOrganService.saveOrUpdateFromSocial(
                SecurityUtils.getLoginUser(), BindFromEnum.fromType(bindFrom)))) {
                return ResponseResult.error("前端工作或通用来源的绑定失败");
            }
        }
        return ResponseResult.ok("用户绑定成功");
    }

    /** 第三方社交平台账号解绑
     * @param thirdBindBody    账户信息
     * @return  解绑状态
     */
    @PlatLog(value = "第三方社交平台账号解绑", category = 54, srcCode = 1)
    @PostMapping("/login/social/unBind")
    @Encrypt
    @LimitScope(name = "thirdMemberUpdate", key = "thirdMemberUpdate")
    public ResponseResult<String> unBind(@RequestBody ThirdBindBody thirdBindBody) {
        //查询当前用户信息
        FrameUserDetails loginUser = getLoginUser();
        if (loginUser == null) {
            throw new CommonException("当前用户未登录，无法查看");
        }
        thirdMemberService.unBindFromSocial(SecurityUtils.getUserId(),
            thirdBindBody.getPlatformType());
        //如果非管理用户，则进行解绑同步的权限处理
        if (!thirdBindBody.getBindFrom().equals(BindFromEnum.ADMIN_WORK.getKey())) {
            userRangeOrganService.removeOrUpdateFromSocial(SecurityUtils.getLoginUser(),
                PublicGroupEnum.WWW_GROUP);
        }
        return ResponseResult.ok();
    }

    /** 根据来源类型，回收授权信息
     * @param source 来源类型，dingtalk|feishu|wechat_work|wechat_open|其他
     * @param uuid 第三方用户ID
     * @return 回收结果
     */
    @PlatLog(value = "根据来源类型，回收授权信息", category = 54, srcCode = 1)
    @RequestMapping("/login/social/revoke/{source}/{uuid}")
    @ResponseBody
    @Encrypt
    public ResponseResult revokeAuth(@PathVariable("source") String source,
                                     @PathVariable("uuid") String uuid) {
        AuthRequest authRequest = thirdMemberService.getAuthRequest(source.toLowerCase());

        AuthUser user = justAuthUserService.getByUuid(uuid);
        if (null == user) {
            return ResponseResult.error("用户不存在");
        }
        AuthResponse<AuthToken> response = null;
        try {
            response = authRequest.revoke(user.getToken());
            if (response.ok()) {
                justAuthUserService.removeFromRedis(user.getUuid());
                return ResponseResult.ok("用户 [" + user.getUsername() + "] 的 授权状态 已收回！");
            }
            return ResponseResult
                .error("用户 [" + user.getUsername() + "] 的 授权状态 收回失败！" + response.getMsg());
        } catch (AuthException e) {
            return ResponseResult.error(e.getErrorMsg());
        }
    }

    /** 根据来源类型，刷新access_token信息
     * @param source 来源类型，dingtalk|feishu|wechat_work|wechat_open|其他
     * @param uuid 第三方用户ID
     * @return access_token信息
     */
    @PlatLog(value = "根据来源类型，刷新access_token信息", category = 10, srcCode = 1)
    @RequestMapping("/login/social/refresh/{source}/{uuid}")
    @ResponseBody
    public Object refreshAuth(@PathVariable("source") String source,
                              @PathVariable("uuid") String uuid) {
        AuthRequest authRequest = thirdMemberService.getAuthRequest(source.toLowerCase());

        AuthUser user = justAuthUserService.getByUuid(uuid);
        if (null == user) {
            return ResponseResult.error("用户不存在");
        }
        AuthResponse<AuthToken> response = null;
        try {
            response = authRequest.refresh(user.getToken());
            if (response.ok()) {
                user.setToken(response.getData());
                justAuthUserService.saveToRedis(user);
                return ResponseResult
                    .ok("用户 [" + user.getUsername() + "] 的 access token 已刷新！新的 accessToken: "
                        + response.getData().getAccessToken());
            }
            return ResponseResult
                .error("用户 [" + user.getUsername() + "] 的 access token 刷新失败！" + response.getMsg());
        } catch (AuthException e) {
            return ResponseResult.error(e.getErrorMsg());
        }
    }

    /** 查看当前第三方授权用户列表
     * @return 第三方授权用户列表
     */
    @PlatLog(value = "查看当前第三方授权用户列表", category = 0, srcCode = 1)
    @RequestMapping("/login/social/getAuthUsers")
    public ModelAndView getAuthUsers() {
        //查询当前用户信息
        FrameUserDetails loginUser = getLoginUser();
        if (loginUser == null) {
            throw new CommonException("当前用户未登录，无法查看");
        }
        Map<String, Object> map = new HashMap<>(1);
        map.put("users", justAuthUserService.listAuthUser());
        return new ModelAndView("users", map);
    }

    /**
     * 获取通用用户信息
     * @param source    用户来源
     * @return 用户信息
     */
    @PlatLog(value = "获取通用用户信息", category = 0, srcCode = 1)
    @GetMapping("/login/social/userInfo")
    public ResponseResult<ThirdUserInfo> getUserInfo(@RequestParam("source") String source) {
        //查询当前用户信息
        FrameUserDetails loginUser = getLoginUser();
        if (loginUser == null) {
            throw new CommonException("当前用户未登录，无法查看");
        }
        return ResponseResult.ok(thirdPermissionService.getUserInfo(source));
    }

    /**
     * 获取工作用户信息，包含用户权限菜单和角色
     * @param source    用户来源
     * @return 用户信息
     */
    @PlatLog(value = "获取工作用户信息，包含用户权限菜单和角色", category = 0, srcCode = 1)
    @GetMapping("/login/social/workUserInfo")
    public ResponseResult<ThirdUserInfo> getWorkUserInfo(@RequestParam("source") String source) {
        //查询当前用户信息
        FrameUserDetails loginUser = getLoginUser();
        if (loginUser == null) {
            throw new CommonException("当前用户未登录，无法查看");
        }
        return ResponseResult.ok(thirdPermissionService.getWorkUserInfo(source));
    }

}
