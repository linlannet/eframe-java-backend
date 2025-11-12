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

import java.io.Serializable;

import lombok.Data;

/**
 * 第三方绑定 表单数据
 *
 * @author Linlan
 * 
 */
@Data
public class ThirdBindBody implements Serializable {
    /**
     * 开放平台类型
     */
    private String platformType;

    /**
     * 开放平台Code
     */
    private String code;

    /**
     * 状态信息
     */
    private String state;

    /**
     * 绑定来自，关联BindFromEnum, admin_work:管理WEB端;web:门户前台;h5:移动端前台;web_work:门户工作;h5_work:移动端工作;other:其他
     */
    private String bindFrom;
}
