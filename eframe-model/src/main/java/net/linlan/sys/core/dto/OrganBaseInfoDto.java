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
package net.linlan.sys.core.dto;

import java.util.Date;

import lombok.Data;

/**
 * 机构基础信息。
 * 常用的基础字段
 */
@Data
public class OrganBaseInfoDto {

    /**
     * 机构ids
     */
    private String[] ids;
    /**
     * 机构id
     */
    private String   organId;
    /**
     * 机构名称
     */
    private String   organName;
    /**
     * 简称
     */
    private String   organSName;
    /**
     * 地域id
     */
    private String   organCode;
    /**
     * 父类Id
     */
    private String   address;

    /**
     * 类型
     */
    private String   wlType;
    /**
     * 类型中文
     */
    private String   wlTypeName;
    /**
     * 排序
     */
    private Integer  priority;

    /**
     * 状态: 1 删除，0有效
     */
    private Integer  delFlag;
    /**
     * 创建时间
     */
    private Date     createTime;
    /**
     * 最近修改时间
     */
    private Date     lastTime;
    /**
     *   ---------------------------机构通讯录字段---------------------------------------
     */
    /**
     *联系人名称
     */
    private String   contactName;
    /**
     *联系人电子邮箱
     */
    private String   contactEmail;
    /**
     *联系人手机
     */
    private String   contactMobile;
    /**
     *公司简介
     */
    private String   description;
    /**
     *单位电话
     */
    private String   tel;

}
