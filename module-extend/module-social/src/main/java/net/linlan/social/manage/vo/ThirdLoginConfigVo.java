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
package net.linlan.social.manage.vo;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * 第三方登录配置
 *
 * @author Linlan
 * 
 */
@Data
public class ThirdLoginConfigVo {

    /**
     * 用户ID
     */
    private String        userId;
    /**
     * 开放平台类型
     */
    private String        platformType;
    /**
     * 客户ID
     */
    private String        clientId;
    /**
     * 客户密钥
     */
    private String        clientSecret;
    /**
     * 重定向地址URL
     */
    private String        redirectUri;
    /**
     * 代理ID
     */
    private String        agentId;
    /**
     * 开放平台状态
     */
    private LocalDateTime createTime;

}
