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
package net.linlan.social.permission.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.script.json.StringMap;
import net.linlan.constant.AdminType;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.comm.service.TokenService;
import net.linlan.social.manage.vo.ThirdUserInfo;
import net.linlan.social.manage.vo.ThirdUserVo;
import net.linlan.social.third.dto.ThirdUserDto;
import net.linlan.social.third.service.ThirdMemberService;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.core.service.CoreAccountService;
import net.linlan.utils.exception.CommonException;
import static net.linlan.frame.web.SecurityUtils.getLoginUser;

/**
 * 社交平台用户权限处理
 *
 * @author Linlan
 */
@Component
public class ThirdPermissionService {

    @Resource
    private PublicPermissionService publicPermissionService;
    @Resource
    private CoreAccountService      coreAccountService;
    @Resource
    private ThirdMemberService      thirdMemberService;
    @Resource
    private TokenService            tokenService;
    @Resource
    private UserRangeOrganService   userRangeOrganService;

    public ThirdUserInfo getUserInfo(String source) {
        //查询当前用户信息
        FrameUserDetails loginUser = getLoginUser();
        if (loginUser == null) {
            throw new CommonException("当前用户未登录，无法查看");
        }
        CoreAccount config = coreAccountService.getByServerType(source);
        if (config == null) {
            throw new CommonException("未配置第三方登录，请配置后再尝试");
        }
        ThirdUserDto user = thirdMemberService.getThirdUserByUserId(loginUser.getUserId());
        if (ObjectUtils.isEmpty(user)) {
            throw new CommonException("用户信息异常，请检查");
        }
        ThirdUserVo thirdUserVo = (ThirdUserVo) ThirdUserVo.DTO.apply(user);

        // 角色集合，前台用户的角色通过关联的公共组进行读取
        Set<Long> roles = getPublicGroupPermission(loginUser.getUserLid());
        // 权限集合，前台用户权限集合可为空
        Set<String> permissions = new HashSet<>();
        ThirdUserInfo thirdUserInfo = new ThirdUserInfo();
        thirdUserInfo.setUser(thirdUserVo);
        thirdUserInfo.setRoles(roles);
        thirdUserInfo.setPermissions(permissions);
        if (!loginUser.getPerms().equals(permissions)) {
            loginUser.setPerms(permissions);
            tokenService.refreshToken(loginUser);
        }
        return thirdUserInfo;
    }

    public Set<Long> getPublicGroupPermission(Long memberId) {
        List<Long> roleIds = userRangeOrganService
            .getRoleIdsByMemberId(new StringMap().put("memberId", memberId).map());
        if (roleIds != null && roleIds.size() > 0) {
            return new HashSet<>(roleIds);
        }
        return new HashSet<>();
    }

    public ThirdUserInfo getWorkUserInfo(String source) {
        //查询当前用户信息
        FrameUserDetails loginUser = getLoginUser();
        CoreAccount config = coreAccountService.getByServerType(source);
        if (config == null) {
            throw new CommonException("未配置第三方登录，请配置后再尝试");
        }
        ThirdUserDto user = thirdMemberService.getThirdUserByUserId(loginUser.getUserId());
        if (ObjectUtils.isEmpty(user)) {
            throw new CommonException("用户信息异常，请检查");
        }
        ThirdUserVo thirdUserVo = (ThirdUserVo) ThirdUserVo.DTO.apply(user);

        // 角色集合
        Set<Long> roles = getRolePermission(thirdUserVo);
        // 权限集合
        Set<String> permissions = getMenuPermission(thirdUserVo);

        ThirdUserInfo thirdUserInfo = new ThirdUserInfo();
        thirdUserInfo.setUser(thirdUserVo);
        thirdUserInfo.setRoles(roles);
        thirdUserInfo.setPermissions(permissions);
        if (!loginUser.getPerms().equals(permissions)) {
            loginUser.setPerms(permissions);
            tokenService.refreshToken(loginUser);
        }
        return thirdUserInfo;
    }

    /**
     * 获取角色数据权限
     *
     * @param user 用户信息
     * @return 角色权限信息
     */
    public Set<Long> getRolePermission(ThirdUserVo user) {
        Set<Long> roles = new HashSet<Long>();
        roles.addAll(publicPermissionService.selectRoleListByMemberId(user.getId()));
        return roles;
    }

    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(ThirdUserVo user) {
        Set<String> perms = new HashSet<String>();
        perms.addAll(publicPermissionService.selectMenuPermsByMemberId(user.getId()));
        return perms;
    }

    public FrameUserDetails createLoginUser(ThirdUserVo thirdUserVo) {
        // 用户权限列表
        Set<String> perms = getMenuPermission(thirdUserVo);
        FrameUserDetails frameUserDetails = new FrameUserDetails(thirdUserVo.getUserId(), perms);
        frameUserDetails.setUserId(thirdUserVo.getUserId());
        frameUserDetails.setUserLid(thirdUserVo.getId());
        frameUserDetails.setUsername(thirdUserVo.getUsername());
        frameUserDetails.setPassword(thirdUserVo.getPassword());
        frameUserDetails.setViewName(thirdUserVo.getUsername());
        frameUserDetails.setOrganId(thirdUserVo.getOrganId());
        frameUserDetails.setMobile(thirdUserVo.getMobile());
        frameUserDetails.setEmail(thirdUserVo.getEmail());
        frameUserDetails.setImagePath(thirdUserVo.getAvatarUrl());
        frameUserDetails.setUserType(AdminType.USER.getType());
        frameUserDetails.setLoginIp(thirdUserVo.getLastLoginIp());
        frameUserDetails.setLoginTime(thirdUserVo.getLastLoginTime());
        frameUserDetails.setLoginCount(thirdUserVo.getLoginCount());
        // 数据权限范围关联机构部门或地域层级，TODO
        List<Long> deptIds = new ArrayList<>();
        // 用户角色编码列表
        Set<Long> roleIdList = getRolePermission(thirdUserVo);
        roleIdList.forEach(roleId -> perms.add("ROLE_" + roleId));

        frameUserDetails.setPerms(perms);
        return frameUserDetails;
    }

}
