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
package net.linlan.frame.api.monitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.service.AdminUserOnlineService;
import net.linlan.frame.view.admin.vo.AdminUserOnline;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.constant.CacheConstants;

/**
 * 在线用户监控
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/monitor/")
public class UserOnlineController extends BaseController {
    @Resource
    private AdminUserOnlineService adminUserOnlineService;

    @Resource
    private RedisService           redisService;

    /**
     * 获取在线用户列表
     * @param ipaddr    IP地址
     * @param username  用户名
     * @return  在线用户列表
     */
    @PlatLog(value = "获取在线用户列表")
    @PreAuthorize("@ss.hasPerms('monitor:online:list')")
    @GetMapping("online/list")
    public ResponseEntity<List<AdminUserOnline>> list(String ipaddr, String username) {
        Collection<String> keys = redisService.keys(CacheConstants.LOGIN_TOKEN_KEY + "*");
        List<AdminUserOnline> userOnlineList = new ArrayList<>();
        for (String key : keys) {
            FrameUserDetails user = (FrameUserDetails) redisService.get(key);
            if (ObjectUtils.isNotEmpty(ipaddr) && ObjectUtils.isNotEmpty(username)) {
                userOnlineList
                    .add(adminUserOnlineService.selectOnlineByInfo(ipaddr, username, user));
            } else if (ObjectUtils.isNotEmpty(ipaddr)) {
                userOnlineList.add(adminUserOnlineService.selectOnlineByIpaddr(ipaddr, user));
            } else if (ObjectUtils.isNotEmpty(username)) {
                userOnlineList.add(adminUserOnlineService.selectOnlineByUsername(username, user));
            } else {
                userOnlineList.add(adminUserOnlineService.loginUserToUserOnline(user));
            }
        }
        Collections.reverse(userOnlineList);
        userOnlineList.removeAll(Collections.singleton(null));
        return success(userOnlineList);
    }

    /**
     * 在线用户下线
     * @param tokenId   token令牌
     * @return 用户下线状态
     */
    @PreAuthorize("@ss.hasPerms('monitor:online:forceLogout')")
    @PlatLog(value = "在线用户下线", category = 32)
    @DeleteMapping("online/{tokenId}")
    public ResponseEntity<String> forceLogout(@PathVariable String tokenId) {
        redisService.delete(CacheConstants.LOGIN_TOKEN_KEY + tokenId);
        return success();
    }
}
