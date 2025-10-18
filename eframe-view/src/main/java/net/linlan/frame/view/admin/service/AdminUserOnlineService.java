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
package net.linlan.frame.view.admin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.view.admin.vo.AdminUserOnline;
import net.linlan.utils.ip.IPAddressUtils;

/**
 * 在线用户 服务层处理
 * 
 * @author Linlan
 */
@Service
public class AdminUserOnlineService {

    @Resource
    private AdminUserService adminUserService;

    /**
     * 通过登录地址查询信息
     * 
     * @param ipaddr 登录地址
     * @param user 用户信息
     * @return 在线用户信息
     */
    public AdminUserOnline selectOnlineByIpaddr(String ipaddr, FrameUserDetails user) {
        if (StringUtils.equals(ipaddr, user.getLoginIp())) {
            return loginUserToUserOnline(user);
        }
        return null;
    }

    /**
     * 通过用户名称查询信息
     * 
     * @param username 用户名称
     * @param user 用户信息
     * @return 在线用户信息
     */
    public AdminUserOnline selectOnlineByUsername(String username, FrameUserDetails user) {
        if (StringUtils.equals(username, user.getUsername())) {
            return loginUserToUserOnline(user);
        }
        return null;
    }

    /**
     * 通过登录地址/用户名称查询信息
     * 
     * @param ipaddr 登录地址
     * @param username 用户名称
     * @param user 用户信息
     * @return 在线用户信息
     */
    public AdminUserOnline selectOnlineByInfo(String ipaddr, String username,
                                              FrameUserDetails user) {
        if (StringUtils.equals(ipaddr, user.getLoginIp())
            && StringUtils.equals(username, user.getUsername())) {
            return loginUserToUserOnline(user);
        }
        return null;
    }

    /**
     * 设置在线用户信息
     * 
     * @param loginUser 用户信息
     * @return 在线用户
     */
    public AdminUserOnline loginUserToUserOnline(FrameUserDetails loginUser) {
        if (ObjectUtils.isEmpty(loginUser)) {
            return null;
        }
        AdminUserDto user = adminUserService.getByUsername(loginUser.getUsername());
        if (user != null) {
            AdminUserOnline sysUserOnline = new AdminUserOnline();
            sysUserOnline.setTokenId(loginUser.getToken());
            sysUserOnline.setUsername(user.getUsername());
            sysUserOnline.setIpaddr(user.getLastLoginIp());
            sysUserOnline
                .setLoginLocation(IPAddressUtils.getRealAddressByIP(user.getLastLoginIp()));
            sysUserOnline.setBrowser(loginUser.getLoginBrowse());
            sysUserOnline.setOs(loginUser.getLoginOs());
            sysUserOnline.setLoginTime(user.getLastLoginTime().getTime());
            if (ObjectUtils.isNotEmpty(user.getDeptId())) {
                sysUserOnline.setDeptName(user.getDeptName());
            }
            return sysUserOnline;
        }
        return null;
    }
}
