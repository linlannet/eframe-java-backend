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
package net.linlan.frame.admin.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * Filename:SiteBaseInfo.java
 * Desc: 站点基础信息
 *
 * @author Linlan
 * @author <a href="mailto:hcday@qq.com">hcday soo</a>
 * CreateTime:2019/7/17 5:04 PM
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
@NoArgsConstructor
public class SiteBaseInfoVo {

    /**
     * 站点ID，场景ID
     */
    private Long   id;
    /**
     * 应用ID，如PA-STAGE
     */
    private String appId;
    /**
     * 地域代码，如310100
     */
    private String areaCode;
    /**
     * 站点路径，访问的前台路径，URL地址
     */
    private String path;
    /**
     * 站点名称，场景名称，如公众门户
     */
    private String name;
    /**
     * 站点简称，场景简称，如公众门户
     */
    private String sname;
    /**
     * 站点门户布局
     */
    private String layout;
    /**
     * 站点logo图片路径URL
     */
    private String logoUrl;
    /**
     * 站点的资源统一cdn路径URL
     */
    private String cdnUrl;

}
