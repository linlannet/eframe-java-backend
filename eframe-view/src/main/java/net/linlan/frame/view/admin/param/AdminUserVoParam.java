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

import lombok.Data;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.frame.admin.param.AdminUserParam;
import net.linlan.utils.param.BaseParam;

/**
 * 用户对象 sys_user
 * 
 * @author Linlan
 */
@Data
public class AdminUserVoParam extends BaseParam {

    /** 用户LID */
    private Long    adminId;

    /** 用户UUID */
    private String  userId;

    /** 部门ID */
    private Long    deptId;

    /** 机构ID */
    private String  organId;

    /** 用户账号 */
    private String  username;

    /** 用户昵称 */
    private String  nickName;

    /** 用户邮箱 */
    private String  email;

    /** 手机号码 */
    private String  mobile;

    /** 帐号状态（0未生效 1正常） */
    private String  status;

    /** 删除标志（0代表存在 1代表删除） */
    private Integer delFlag;

    public AdminUserParam toModelParam() {
        AdminUserParam result = new AdminUserParam();
        result.setAdminId(adminId);
        result.setUserId(userId);
        result.setUsername(username);
        result.setDeptId(deptId);
        result.setEmail(email);
        result.setMobile(mobile);
        result.setQ(super.getQ());
        if (ObjectUtils.isNotEmpty(status)) {
            result.setStatus(Integer.parseInt(status));
        }
        result.setDelFlag(delFlag);
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        return result;
    }
}
