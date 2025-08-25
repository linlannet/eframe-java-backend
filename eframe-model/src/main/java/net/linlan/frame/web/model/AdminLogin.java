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
package net.linlan.frame.web.model;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * Filename:AdminLogin.java
 * Desc:用户登录实体类
 *
 * @author Linlan
 * CreateTime:2017-08-17 14:21:37
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class AdminLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * appId应用ID
     */
    private String            appId;
    /**
     * 用户名
     */
    private String            username;
    /**
     * 用户密码
     */
    private String            password;
    /**
     * 当前来源1:WEB,21:AndroidAPP,22:IOSAPP
     */
    private Integer           srcCode;
    /**
     * 验证码
     */
    private String            captcha;
    /**
     * 自动登录
     */
    private Boolean           rememberMe;

}
