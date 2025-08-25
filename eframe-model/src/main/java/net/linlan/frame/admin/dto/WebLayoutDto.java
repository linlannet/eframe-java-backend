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
package net.linlan.frame.admin.dto;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * WebLayoutDto视图域:平台WEB布局对象Vo实体类
 * 平台配置基本信息对象
 * @author Linlan
 * CreateTime:2020-10-31 17:25:55
 *
 */
@Data
public class WebLayoutDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 平台ACCOUNT_ID
     */
    private String            id;
    /**
     * 是否加解密
     */
    private Boolean           isAdmin;
    /**
     * 敏感信息是否加密
     */
    private Boolean           isEncryt         = false;
    /**
     * 平台公钥信息
     */
    private String            publicKey;
    /**
     * 平台公钥信息
     */
    private String            aesKey;
    /**
     * 平台clientId
     */
    private String            clientId;
    /**
     * 平台图片域名前缀
     */
    private String            serverUrl;
    /**
     * 平台回调地址
     */
    private String            serverConf1;
    /**
     * 平台配置基本对象
     */
    private AppConfigDto      appConf;
    /**
     * 通过MEMBER_ACCOUNT内的TYPE为1，则isWork为true，workConfig返回信息
     */
    private Boolean           isWork;
    /**
     * workInit，通过请求的url路径，匹配MANAGE_SITE内的PATH，输出site对象
     */
    private WorkConfigDto     workConfig;

}
