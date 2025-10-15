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
package net.linlan.frame;

import java.util.Collection;
import java.util.Date;

import java.util.Set;


import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import net.linlan.frame.admin.dto.AdminUserDto;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.linlan.commons.core.DateUtils;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * FrameAdminUser, 管理用户身份权限用户类，基于Spring的UserDetails扩展
 * 适用管理WEB端基本用户，无需人员敏感信息，针对内部平台使用场景
 * @author Linlan
 * CreateTime 2020-03-07 17:23:24
 *
 */
@Getter
@Setter
public class FrameUserDetails implements UserDetails {
    private static final long serialVersionUID = -8631010419770301116L;

    /**
     * 用户UUID
     */
    private String            userId;

    /**
     * 所属应用ID
     */
    private String            appId;

    /**
     * 部门ID
     */
    private Long              deptId;

    /**
     * 用户机构ID
     */
    private String            organId;

    /**
     * 登录令牌
     */
    private String            token;

    /**
     * 用户名
     */
    private String            username;

    /**
     * 昵称
     */
    private String            viewName;

    /**
     * 密码
     */
    private String            password;

    /**
     * 需要修改密码
     */
    private Boolean           needChangePassword;

    /**
     * 邮箱
     */
    private String            email;

    /**
     * 手机号
     */
    private String            mobile;

    /**
     * 头像URL
     */
    private String            imagePath;

    /**
     * 登录次数
     */
    private Integer           loginCount;
    /**
     * 上次登录IP
     */
    private String loginIp;

    /**
     * 最后修改密码时间
     */
    private Date              lastUpdatePasswordTime;

    /**
     * 最后修改时间
     */
    private Date              lastTime;

    /**
     * 外部ID
     */
    private String            foreignId;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 登录时间
     */
    @JsonFormat(pattern = DateUtils.yyyyMMddHHmmss)
    private Date              loginTime;

    /**
     * 用户类型
     */
    @JsonProperty("userType")
    private String            userType;

    /**
     * 是否超级管理员
     */
    private Boolean           isSuperAdmin;
    /**
     * 登录的浏览器
     */
    private String            loginBrowse;

    /**
     * 登录的OS
     */
    private String            loginOs;
    /**
     * 权限列表
     */
    private Set<String> perms;

    public FrameUserDetails() {

    }

    public FrameUserDetails(String userId, Set<String> permissions)
    {
        this.userId = userId;
        this.perms = permissions;
    }

    /**
     * 账户是否未过期,过期无法验证
     */
    @JSONField(serialize = false)
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     *
     * @return  是否解锁
     */
    @JSONField(serialize = false)
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     *
     * @return  是否已过期
     */
    @JSONField(serialize = false)
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     *
     * @return  是否可用
     */
    @JSONField(serialize = false)
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

}
