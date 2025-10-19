/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.constant;

import org.springframework.util.Assert;

import net.linlan.utils.enums.BaseEnumString;

/**
 * @author Linlan
 */
public final class ProviderType implements BaseEnumString {

    /**
     * 用户名密码
     */
    public static final ProviderType USERNAME_PASSWORD_AUTHN = new ProviderType("username_password",
        "用户名密码认证", "通过用户名密码进行身份认证");

    /**
     * 短信验证码
     */
    public static final ProviderType SMS_AUTHN               = new ProviderType("sms", "短信验证码认证",
        "通过短信验证码进行身份认证");

    /**
     * 邮件验证码
     */
    public static final ProviderType MAIL_AUTHN              = new ProviderType("mail", "邮件验证码认证",
        "通过邮件验证码进行身份认证");

    /**
     * 飞书
     */
    public static final ProviderType FEISHU_OAUTH            = new ProviderType("feishu_oauth",
        "飞书认证", "通过飞书进行身份验证");

    /**
     * 钉钉
     */
    public static final ProviderType DINGTALK_OAUTH          = new ProviderType("dingtalk_oauth",
        "钉钉认证", "通过钉钉进行身份认证");

    /**
     * 微信
     */
    public static final ProviderType WECHAT_OAUTH            = new ProviderType("wechat_oauth",
        "微信扫码登录", "通过微信扫码进行身份认证");
    /**
     * 企业微信
     */
    public static final ProviderType WECHAT_WORK_OAUTH       = new ProviderType("wechatwork_oauth",
        "企业微信认证", "通过企业微信同步的用户可使用企业微信扫码登录进行身份认证");

    /**
     * Gitee
     */
    public static final ProviderType GITEE_OAUTH             = new ProviderType("gitee_oauth",
        "Gitee", "通过Gitee进行身份认证");

    /**
     * QQ
     */
    public static final ProviderType QQ_OAUTH                = new ProviderType("qq_oauth", "QQ认证",
        "通过QQ进行身份认证");

    /**
     * GITHUB
     */
    public static final ProviderType GITHUB_OAUTH            = new ProviderType("github_oauth",
        "GITHUB认证", "通过GITHUB进行身份认证");

    /**
     * 支付宝
     */
    public static final ProviderType ALIPAY_OAUTH            = new ProviderType("alipay_oauth",
        "支付宝认证", "通过支付宝进行身份认证");

    /**
     * 键
     */
    private final String             key;
    /**
     * 值
     */
    private final String             value;
    /**
     * 说明
     */
    private final String             description;

    public ProviderType(String key, String value, String description) {
        Assert.hasText(key, "key cannot be empty");
        this.key = key;
        this.value = value;
        this.description = description;
    }

    /**
     * Returns the key of the authorization grant type.
     *
     * @return the key of the authorization grant type
     */
    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    /**
     * getIdentityProviderType
     *
     * @param type {@link String}
     * @return {@link ProviderType}
     */
    public static ProviderType fromType(String type) {
        if (FEISHU_OAUTH.getKey().equals(type)) {
            return FEISHU_OAUTH;
        }
        if (DINGTALK_OAUTH.getKey().equals(type)) {
            return DINGTALK_OAUTH;
        }
        if (WECHAT_OAUTH.getKey().equals(type)) {
            return WECHAT_OAUTH;
        }
        if (WECHAT_WORK_OAUTH.getKey().equals(type)) {
            return WECHAT_WORK_OAUTH;
        }
        if (QQ_OAUTH.getKey().equals(type)) {
            return QQ_OAUTH;
        }
        if (GITHUB_OAUTH.getKey().equals(type)) {
            return GITHUB_OAUTH;
        }
        if (GITEE_OAUTH.getKey().equals(type)) {
            return GITEE_OAUTH;
        }
        if (ALIPAY_OAUTH.getKey().equals(type)) {
            return ALIPAY_OAUTH;
        }
        if (USERNAME_PASSWORD_AUTHN.getKey().equals(type)) {
            return USERNAME_PASSWORD_AUTHN;
        }
        if (MAIL_AUTHN.getKey().equals(type)) {
            return MAIL_AUTHN;
        }
        if (SMS_AUTHN.getKey().equals(type)) {
            return SMS_AUTHN;
        }
        throw new IllegalArgumentException("未知身份提供商类型");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ProviderType that = (ProviderType) obj;
        return this.getKey().equals(that.getKey());
    }

    @Override
    public int hashCode() {
        return this.getKey().hashCode();
    }

    public static int size() {
        return 9;
    }

    @Override
    public String toString() {
        return "IdentityProviderType[" + "key=" + key + ", " + "value=" + value + ", "
               + "description=" + description + ']';
    }

}
