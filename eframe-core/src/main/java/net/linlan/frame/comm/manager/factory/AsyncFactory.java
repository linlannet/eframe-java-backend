/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.comm.manager.factory;

import java.util.TimerTask;

import lombok.extern.slf4j.Slf4j;

import eu.bitwalker.useragentutils.UserAgent;
import net.linlan.frame.admin.entity.AdminLoginLog;
import net.linlan.frame.admin.service.AdminLoginLogService;
import net.linlan.utils.LogUtils;
import net.linlan.utils.ServletUtils;
import net.linlan.utils.SpringContextUtils;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.ip.IPAddressUtils;
import net.linlan.utils.ip.IPUtils;

/**
 * 异步工厂（产生任务用）
 * 
 * @author Linlan
 */
@Slf4j
public class AsyncFactory {

    /**
     * 记录登录信息
     * 
     * @param userId 用户id
     * @param username 用户名
     * @param status 状态
     * @param message 消息
     * @param appId 应用ID
     * @param userLid 用户LID
     * @param category 日志类型
     * @param args 列表
     * @return 任务task
     */
    public static TimerTask saveAdminLoginLog(final String userId, final String username,
                                              final String status, final String message,
                                              final String appId, final Long userLid,
                                              final Integer category, final Object... args) {
        final UserAgent userAgent = UserAgent
            .parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IPUtils.getIpAddr(ServletUtils.getRequest());
        final String url = ServletUtils.getRequest().getRequestURI();
        return new TimerTask() {
            @Override
            public void run() {
                String address = IPAddressUtils.getRealAddressByIP(ip);
                StringBuilder sb = new StringBuilder();
                sb.append("IP:" + LogUtils.getBlock(ip));
                sb.append("ADDRESS:" + LogUtils.getBlock(address));
                sb.append("USERNAME:" + LogUtils.getBlock(username));
                sb.append("STATUS:" + LogUtils.getBlock(status));
                sb.append("MESSAGE:" + LogUtils.getBlock(message));
                // 打印信息到日志
                log.info(sb.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                AdminLoginLog adminLoginLog = new AdminLoginLog();
                adminLoginLog.setUserId(userId);
                adminLoginLog.setAdminId(userLid);
                adminLoginLog.setAppId(appId);
                adminLoginLog.setLogIp(ip);
                adminLoginLog.setLogBrowse(browser);
                adminLoginLog.setLogOs(os);
                adminLoginLog.setTitle(message);
                // 日志状态
                adminLoginLog.setStatus(Constants.SUCCESS);
                adminLoginLog.setCategory(category);
                if (Constants.LOGIN_FAIL.equals(status)) {
                    adminLoginLog.setStatus(Constants.FAIL);
                    adminLoginLog.setCategory(1);
                }
                adminLoginLog.setLogUrl(url);
                adminLoginLog.setContent(sb.toString());
                // 插入数据
                SpringContextUtils.getBean(AdminLoginLogService.class).save(adminLoginLog);
            }
        };
    }

}
