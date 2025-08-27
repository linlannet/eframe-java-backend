/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.constant;

import io.jsonwebtoken.Claims;

/**
 * 通用常量信息
 * 
 * @author Linlan
 */
public class Constants {
    /**
     * www主域
     */
    public static final String   ENT_APP_ID           = "PA-EFRAME";
    /**
     * www主域
     */
    public static final String   WWW                  = "www.";

    /**
     * http请求
     */
    public static final String   HTTP                 = "http://";

    /**
     * https请求
     */
    public static final String   HTTPS                = "https://";

    /**
     * 通用成功标识
     */
    public static final String   SUCCESS              = "0";

    /**
     * 通用失败标识
     */
    public static final String   FAIL                 = "1";

    /**
     * 登录成功
     */
    public static final String   LOGIN_SUCCESS        = "Success";

    /**
     * 注销
     */
    public static final String   LOGOUT               = "Logout";

    /**
     * 注册
     */
    public static final String   REGISTER             = "Register";

    /**
     * 登录失败
     */
    public static final String   LOGIN_FAIL           = "Error";

    /**
     * 所有权限标识
     */
    public static final String   ALL_PERMISSION       = "*:*:*";

    /**
     * 管理员角色权限标识
     */
    public static final String   SUPER_ADMIN          = "admin";

    /**
     * 角色权限分隔符
     */
    public static final String   ROLE_DELIMETER       = ",";

    /**
     * 权限标识分隔符
     */
    public static final String   PERMISSION_DELIMETER = ",";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer  CAPTCHA_EXPIRATION   = 2;

    /**
     * 令牌
     */
    public static final String   TOKEN_KEY            = "token";

    /**
     * 令牌前缀
     */
    public static final String   TOKEN_PREFIX         = "Linlan ";

    /**
     * 令牌前缀
     */
    public static final String   LOGIN_USER_KEY       = "login_user_key";

    /**
     * 用户LID
     */
    public static final String   JWT_USERID           = "userid";

    /**
     * 用户名称
     */
    public static final String   JWT_USERNAME         = Claims.SUBJECT;

    /**
     * 用户头像
     */
    public static final String   JWT_IMAGE_PATH       = "imagePath";

    /**
     * 创建时间
     */
    public static final String   JWT_CREATED          = "created";

    /**
     * 用户权限
     */
    public static final String   JWT_AUTHORITIES      = "authorities";

    /**
     * 资源映射路径 前缀
     */
    public static final String   RESOURCE_PREFIX      = "/profile";

    /**
     * RMI 远程方法调用
     */
    public static final String   LOOKUP_RMI           = "rmi:";

    /**
     * LDAP 远程方法调用
     */
    public static final String   LOOKUP_LDAP          = "ldap:";

    /**
     * LDAPS 远程方法调用
     */
    public static final String   LOOKUP_LDAPS         = "ldaps:";

    /**
     * 自动识别json对象白名单配置（仅允许解析的包名，范围越小越安全）
     */
    public static final String[] JSON_WHITELIST_STR   = { "org.springframework", "net.linlan" };

    /**
     * 定时任务白名单配置（仅允许访问的包名，如其他需要可以自行添加）
     */
    public static final String[] JOB_WHITELIST_STR    = { "net.linlan.quartz.task" };

    /**
     * 定时任务违规的字符
     */
    public static final String[] JOB_ERROR_STR        = { "java.net.URL",
                                                          "javax.naming.InitialContext",
                                                          "org.yaml.snakeyaml",
                                                          "org.springframework", "org.apache",
                                                          "net.linlan.utils.file",
                                                          "net.linlan.utils.config",
                                                          "net.linlan.commons.generator" };

    /**
     * The Constant FIELD_VERSION. 应用版本号
     */
    public static final String   FIELD_VERSION        = "version";

    /**
     * 返回字段的统一名称
     */
    public static final String   REQUEST_PARAMS       = "params";
    /**
     * 平台用户的ID，对平台信息（前台工程访问信息）进行缓存处理使用的KEY，缓存10分钟
     */
    public static final String   ACCOUNT_KEY          = "ll-account-id";

    /**
     * 站点的ID，对站点信息进行缓存处理使用的KEY，缓存10分钟
     */
    public static final String   SITE_KEY             = "ll-site";

}
