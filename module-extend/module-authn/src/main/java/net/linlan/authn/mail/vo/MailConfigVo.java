/*
 * module-authn - 动态认证对接模块
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
package net.linlan.authn.mail.vo;

import org.springframework.lang.Nullable;

import com.alibaba.fastjson2.JSONObject;
import com.google.common.base.Function;

import lombok.Data;

import net.linlan.sys.base.entity.BaseConfigWhole;

/**
 * 邮箱配置项
 *
 * @author Linlan
 * 
 */
@Data
public class MailConfigVo {
    /**
     * 短信提供商ID
     */
    private String               providerId;

    /**
     * 短信平台名称
     */
    private String               providerName;

    /**
     * 分组名称，发送邮件时，可指定分组
     */
    private String               groupName;

    /**
     * SMTP服务器
     */
    private String               mailHost;

    /**
     * SMTP端口
     */
    private Integer              mailPort;

    /**
     * 发件人邮箱
     */
    private String               mailFrom;

    /**
     * 发件人密码
     */
    private String               mailPass;

    /**
     * regionId
     */
    private String               regionId;

    /**
     * 阿里云 endpoint
     */
    private String               endpoint;

    /**
     * AccessKey
     */
    private String               accessKey;

    /**
     * SecretKey
     */
    private String               secretKey;

    /**
     * 数据赋值DTO方法，将BaseConfigWhole的input对象赋值给EmailConfig
     */
    public static final Function DTO = new Function<BaseConfigWhole, MailConfigVo>() {
                                         @Nullable
                                         @Override
                                         public MailConfigVo apply(@Nullable BaseConfigWhole input) {
                                             return new MailConfigVo(input);
                                         }
                                     };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public MailConfigVo(BaseConfigWhole input) {
        MailConfigVo config = JSONObject.parseObject(input.getCfgValue(), MailConfigVo.class);
        this.providerId = config.getProviderId();
        this.providerName = config.getProviderName();
        this.groupName = config.getGroupName();
        this.mailHost = config.getMailHost();
        this.mailPort = config.getMailPort();
        this.mailFrom = config.getMailFrom();
        this.mailPass = config.getMailPass();
        this.regionId = config.getRegionId();
        this.endpoint = config.getEndpoint();
        this.accessKey = config.getAccessKey();
        this.secretKey = config.getSecretKey();
    }
}
