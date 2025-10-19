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

/**
 * SecurityConstants
 *
 * @author Linlan
 */
public final class SecurityConstants {
    /**
     * LOGIN
     */
    public static final String LOGIN_PATH             = "/login";

    /**
     * LOGOUT
     */
    public final static String LOGOUT_PATH            = "/logout";

    /**
     * form 表单登录
     */
    public static final String FORM_LOGIN             = LOGIN_PATH;

    /**
     * sms login 路径
     */
    public static final String SMS_LOGIN              = LOGIN_PATH + "/sms";

    /**
     * maf 验证
     */
    public static final String MFA_VALIDATE           = LOGIN_PATH + "/mfa/validate";

    /**
     * mfa 登录提供者
     */
    public static final String LOGIN_MFA_FACTORS      = LOGIN_PATH + "/mfa/factors";

    /**
     * 发送OTP
     */
    public static final String LOGIN_OTP_SEND         = LOGIN_PATH + "/otp/send";

    /**
     * 需要重置密码
     */
    public final static String REQUIRE_RESET_PASSWORD = "require_reset_password";

    /**
     * 第三方登录路径，社交登录路径
     */
    public static final String SOCIAL_LOGIN           = LOGIN_PATH + "/social";
    /**
     * 社交登录渲染路径
     */
    public static final String SOCIAL_RENDER          = LOGIN_PATH + "/social/render";
    /**
     * 社交登录回调路径
     */
    public static final String SOCIAL_CALLBACK        = LOGIN_PATH + "/social/callback";

    /**
     * 社交登录 绑定用户 路径
     */
    public static final String IDP_MEMBER_BIND        = LOGIN_PATH + "/member/bind";
    /**
     * 社交登录 解绑用户 路径
     */
    public static final String IDP_MEMBER_UNBIND      = LOGIN_PATH + "/member/unBind";

}
