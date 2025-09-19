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
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alibaba.fastjson2.annotation.JSONField;

import lombok.Data;

/**
 *
 * 
 * @author Linlan
 */
/**
 *
 * FrameAdminUser, 管理用户身份权限用户类，基于Spring的UserDetails扩展
 * 适用管理WEB端基本用户，无需人员敏感信息，针对内部平台使用场景
 * @author Linlan
 * CreateTime 2020-03-07 17:23:24
 *
 */
@Data
public class FrameAdminUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    /**
     * 用户LID
     */
    private Long              adminId;

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
     * 密码
     */
    private String            password;

    /**
     * 头像地址
     */
    private String            imagePath;

    /**
     * 是否超级管理员
     */
    private Boolean           isSuperAdmin;

    /**
     * 登录的IP地址
     */
    private String            loginIp;

    /**
     * 登录时间
     */
    private Long              loginTime;

    /**
     * 登录的浏览器
     */
    private String            loginBrowse;

    /**
     * 登录的OS
     */
    private String            loginOs;

    /**
     * 过期时间
     */
    private Long              expireTime;

    /**
     * 权限列表
     */
    private Set<String>       perms;

    /**
     * 管理类型：ADMIN管理员，DEMO演示用户
     */
    @JsonProperty("userType")
    private String   adminType;

    public FrameAdminUser() {
    }

    public FrameAdminUser(Long adminId, Long deptId, String username, String password, String appId,
                          String adminType,
                          Set<String> perms) {
        this.adminId = adminId;
        this.deptId = deptId;
        this.username = username;
        this.password = password;
        this.appId = appId;
        this.adminType = adminType;
        this.perms = perms;
        this.isSuperAdmin = false;
    }

    @JSONField(serialize = false)
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 账户是否未过期,过期无法验证
     */
    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     * 
     * @return  是否解锁
     */
    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     * 
     * @return  是否已过期
     */
    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     * 
     * @return  是否可用
     */
    @JSONField(serialize = false)
    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Set<String> getPerms() {
        return perms;
    }

    public void setPerms(Set<String> perms) {
        this.perms = perms;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
