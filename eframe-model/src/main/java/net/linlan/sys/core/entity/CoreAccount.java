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
package net.linlan.sys.core.entity;

import java.security.KeyPair;

import org.apache.commons.codec.binary.Base64;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.core.constant.InoutModeEnum;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.crypt.RSAUtil;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * CoreAccount数据域:平台对接账户实体类
 * @author Linlan
 * CreateTime 2018-03-01 19:01:51
 *
 */
@Data
public class CoreAccount extends BaseEntity {
    /**
     * 接口调用不限制标记
     */
    public static final int    INTF_ACCESS_NO_LIMIT                     = 0;

    /**
     * 消息发送方式：政务微信
     */
    public static final String THIRD_LOGIN_SOURCE_ZWWECHAT              = "zwwechat";
    /**
     * 消息发送方式：微信小程序
     */
    public static final String THIRD_LOGIN_SOURCE_WECHAT                = "wechat";
    /**
     * 消息发送方式：微信公众号
     */
    public static final String THIRD_LOGIN_SOURCE_WECHAT_PUBLIC_ACCOUNT = "wechatpublicaccount";

    /**
     * 对接账户ID，外部系统分配的主键
     */
    private String             id;

    /**
     * 系统机构ID
     */
    private String             organId;

    /**
     * 应用ID
     */
    private String             appId;

    /**
     * 系统机构名称，没有ORGAN_ID时使用
     */
    private String             organName;

    /**
     * 对接模式0内部接入1内部接出11外部接入20双向40市民云对接类短信平台
     */
    private Integer            inoutMode;

    /**
     * 对接系统或账户名称，开放平台认证平台名称
     */
    private String             name;

    /**
     * 对接系统名称中文
     */
    private String             cname;

    /**
     * 对接系统类型1平台应用2APP应用3外部接口
     */
    private Integer            type;

    /**
     * 对接系统CLIENTID，或CORPID
     */
    private String             clientId;

    /**
     * 客户密钥
     */
    private String             clientSecret;

    /**
     * AES加解密密钥，备用
     */
    private String             aesKey;

    /**
     * AES iv key，备用
     */
    private String             aesIvKey;

    /**
     * 对接服务器IP地址或域名
     */
    private String             serverIp;

    /**
     * 对接服务器类型，授权类型，开放平台认证平台类型
     */
    private String             serverType;

    /**
     * 默认接口URL，存放CODE_URL，短信网关配置
     */
    private String             serverUrl;

    /**
     * 服务器配置扩展1，MODE为11时，访问IP地址白名单，,分隔；MODE为40时，
     */
    private String             serverConf1;

    /**
     * 服务器配置扩展2，MODE为40时，消息发送方式001,111,100,010等，第一位为发送站内信，第二位为短信，第三位为彩信
     */
    private String             serverConf2;

    /**
     * 服务器配置扩展3，MODE为1时平台类型，如果共用SMY体系，此时填写smy，多个市民云体系的APP可以用一套模式接入；MODE为40时，短信模板
     */
    private String             serverConf3;

    /**
     * 当前调用次数
     */
    private Integer            currCount;

    /**
     * 每日限制调用次数(0无限制)
     */
    private Integer            confLimit;

    /**
     * 是否默认管理后台API账户，是否开启前后端加密，如果开启则使用公钥私钥
     */
    private Boolean            isAdmin;

    /**
     * 是否限制单设备同时登陆
     */
    private Boolean            isSingle;

    /**
     * 是否禁用0否1是
     */
    private Boolean            isDisabled;

    /**
     * 对接系统状态0不可用1可用2过期
     */
    private Integer            status;

    /**
     * 对接系统描述
     */
    private String             description;

    /**
     * 备用1
     */
    private String             spare1;

    /**
     * 备用2
     */
    private String             spare2;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.random("plat_"));
        }

        if (getIsAdmin() == null) {
            setIsAdmin(KernelConstant.DEFAULT_BOOLEAN);
        }
        // 生成密钥对
        KeyPair keyPair = null;
        try {
            keyPair = RSAUtil.getKeyPair();
            String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
            String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
            if (getAesKey() == null || getAesIvKey() == null) {
                setAesKey(publicKey);
                setAesIvKey(privateKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getInoutMode() == null) {
            setInoutMode(InoutModeEnum.INOUT_MODE_INNER_IN.getKey());
        }
        if (getConfLimit() == null) {
            setConfLimit(INTF_ACCESS_NO_LIMIT);
        }
        if (getIsSingle() == null) {
            setIsSingle(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsDisabled() == null) {
            setIsDisabled(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getStatus() == null) {
            setStatus(KernelConstant.DEFAULT_STATUS);
        }

    }

}
