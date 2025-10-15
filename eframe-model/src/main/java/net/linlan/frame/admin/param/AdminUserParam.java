/*
 * eframe-model - model模型数据模块
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
package net.linlan.frame.admin.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * AdminUser数据域:管理用户查询参数实体类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminUserParam extends BaseParam {

    /**
     * 企业管理用户ID
     */
    private Long    adminId;
    /**
     * 系统管理用户ID
     */
    private String  userId;
    /**
     * 机构ID
     */
    private String  organId;
    /**
     * 单位ID
     */
    private Long    deptId;
    /**
     * 创建方式0导入1录入2授权
     */
    private Integer createType;
    /**
     * 显示名称，可设置为用户名、手机号、昵称、真名
     */
    private String  name;
    /**
     * 用户名
     */
    private String  username;
    /**
     * 手机号码
     */
    private String  mobile;
    /**
     * 电子邮箱
     */
    private String  email;
    /**
     * 密码
     */
    private String  password;
    /**
     * 混淆字符
     */
    private String  salt;
    /**
     * 头像
     */
    private String  imagePath;
    /**
     * 管理类型：ADMIN管理员，DEMO演示用户
     */
    private String  adminType;
    /**
     * 是否超级管理员
     */
    private Boolean isSuperAdmin;
    /**
     * 是否审计只读管理员
     */
    private Boolean isAuditAdmin;
    /**
     * 是否只管理自己的数据
     */
    private Boolean isSelfAdmin;
    /**
     * 管理的范围配置JSON，APP_ID或者SITE_ID的数组，或者单个APP_ID
     */
    private String  adminRange;
    /**
     * 管理权限JSON
     */
    private String  adminPerms;
    /**
     * 最后登录的应用ID
     */
    private String  lastAppId;
    /**
     * 最后登录时间
     */
    private Date    lastLoginTime;
    /**
     * 最后登录IP
     */
    private String  lastLoginIp;
    /**
     * 登录次数
     */
    private Integer loginCount;
    /**
     * 状态0未生效1正常2受限3锁定4删除
     */
    private Integer status;
    /**
     * 创建人ID
     */
    private String  creatorId;
    /**
     * 删除标记0正常1已删除2应用内受限3回收站
     */
    private Integer delFlag;
    /**
     * 备用1
     */
    private String  spare1;
    /**
     * 备用2
     */
    private String  spare2;

}
