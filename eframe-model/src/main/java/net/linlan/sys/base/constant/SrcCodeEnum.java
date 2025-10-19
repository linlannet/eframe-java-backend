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
package net.linlan.sys.base.constant;

import net.linlan.utils.enums.BaseEnumInteger;

/**
 * 来源信息枚举
 */
public enum SrcCodeEnum implements BaseEnumInteger {

                                                    /**
                                                     * 后台中台来源
                                                     */
                                                    SRC_CODE_DEFAULT(0, "后台中台来源"),
                                                    /**
                                                     * THIRD三方后台来源
                                                     */
                                                    SRC_CODE_THIRD(1, "THIRD三方后台来源"),
                                                    /**
                                                     * 业务应用来源
                                                     */
                                                    SRC_CODE_WEB(10, "业务应用来源"),
                                                    /**
                                                     * SSO来源
                                                     */
                                                    SRC_CODE_WEB_SSO(11, "SSO来源"),
                                                    /**
                                                     * 运营维护来源
                                                     */
                                                    SRC_CODE_WEB_OPERATION(12, "运营维护来源"),
                                                    /**
                                                     * 租户来源
                                                     */
                                                    SRC_CODE_WEB_RENTUSER(13, "租户来源"),
                                                    /**
                                                     * 全端来源
                                                     */
                                                    SRC_CODE_UNION(14, "全端来源"),
                                                    /**
                                                     * APP来源
                                                     */
                                                    SRC_CODE_APP(2, "APP来源"),
                                                    /**
                                                     * 安卓手机APP来源
                                                     */
                                                    SRC_CODE_APP_ANDROID(21, "安卓手机APP来源"),
                                                    /**
                                                     * IOS手机APP来源
                                                     */
                                                    SRC_CODE_APP_IOS(22, "IOS手机APP来源"),
                                                    /**
                                                     * WAP来源
                                                     */
                                                    SRC_CODE_WAP(3, "WAP来源"),
                                                    /**
                                                     * H5来源
                                                     */
                                                    SRC_CODE_MINI(4, "H5来源"),
                                                    /**
                                                     * 城市平台来源，随申办、浙里办等
                                                     */
                                                    SRC_CODE_MINI_SMY(40, "城市平台来源"),
                                                    /**
                                                     * 政务微信平台来源
                                                     */
                                                    SRC_CODE_MINI_ZWWX(41, "政务微信平台来源"),
                                                    /**
                                                     * 微信平台来源
                                                     */
                                                    SRC_CODE_MINI_WECHAT(42, "微信平台来源"),
                                                    /**
                                                     * 支付宝平台来源
                                                     */
                                                    SRC_CODE_MINI_ALIPAY(43, "支付宝平台来源"),
                                                    /**
                                                     * 微信小程序
                                                     */
                                                    SRC_CODE_MINI_WEIXIN_MINI(45, "微信小程序"),
                                                    /**
                                                     * 微信公众号
                                                     */
                                                    SRC_CODE_MINI_WEIXIN_MP(46, "微信公众号"),
                                                    /**
                                                     * 支付宝小程序
                                                     */
                                                    SRC_CODE_MINI_ALIPAY_MINI(47, "支付宝小程序"),
                                                    /**
                                                     * 支付宝生活号
                                                     */
                                                    SRC_CODE_MINI_ALIPAY_FUWU(48, "支付宝生活号"),
                                                    /**
                                                     * 融媒体来源
                                                     */
                                                    SRC_CODE_MINI_RONGMEITI(50, "融媒体来源"),
                                                    /**
                                                     * 阿里钉钉来源
                                                     */
                                                    SRC_CODE_MINI_DINGDING(51, "阿里钉钉来源"),
                                                    /**
                                                     * 企业微信来源
                                                     */
                                                    SRC_CODE_MINI_WEWORK(52, "企业微信来源"),
                                                    /**
                                                     * 飞书来源
                                                     */
                                                    SRC_CODE_MINI_FEISHU(53, "飞书来源"),
                                                    /**
                                                     * 外部授权登录来源
                                                     */
                                                    SRC_CODE_OUT(8, "外部授权登录来源"),
                                                    /**
                                                     * 短信来源
                                                     */
                                                    SRC_CODE_OUT_SMS(81, "短信来源"),
                                                    /**
                                                     * 其他来源
                                                     */
                                                    SRC_CODE_OTH(99, "其他来源");

    /**
     * 配置项名称
     */
    private int    key;
    /**
     * 字典值
     */
    private String value;

    SrcCodeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
