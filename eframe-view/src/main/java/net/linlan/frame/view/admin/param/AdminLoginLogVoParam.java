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
package net.linlan.frame.view.admin.param;

import java.util.Date;

import lombok.Data;

import net.linlan.frame.admin.param.AdminLoginLogParam;
import net.linlan.utils.param.BaseParam;

/**
 * 系统访问记录表 EntAdminLoginLogParam
 * 
 * @author Linlan
 */
@Data
public class AdminLoginLogVoParam extends BaseParam {

    /** ID */
    private Long   infoId;

    /** 用户账号 */
    private String username;

    /** 登录状态 0成功 1失败 */
    private String status;

    /** 登录IP地址 */
    private String ipaddr;

    /** 访问时间 */
    private Date   loginTime;
    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** 提示消息 */
    private String msg;

    public AdminLoginLogParam toModelParam() {
        AdminLoginLogParam result = new AdminLoginLogParam();
        result.setLogId(infoId);
        result.setUserId(username);
        result.setLogIp(ipaddr);
        result.setStatus(status);
        result.setTitle(msg);
        result.setLogBrowse(browser);
        result.setLogOs(os);
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        return result;
    }
}
