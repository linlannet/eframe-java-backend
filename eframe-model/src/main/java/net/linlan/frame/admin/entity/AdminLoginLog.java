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
package net.linlan.frame.admin.entity;

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * AdminLoginLog数据域:管理员登录日志实体类
 * @author Linlan
 * CreateTime 2024-10-07 20:45:06
 *
 */
@Data
public class AdminLoginLog extends BaseEntity {

    /**
     * 登录ID
     */
    private Long    id;

    /**
     * 管理员ID
     */
    private Long    adminId;

    /**
     * 用户ID或用户名
     */
    private String  userId;

    /**
     * 应用ID
     */
    private String  appId;

    /**
     * 日志类型
     */
    private Integer category;

    /**
     * 日志标题
     */
    private String  title;

    /**
     * 日志内容
     */
    private String  content;

    /**
     * 当前登录来源
     */
    private Integer srcCode;

    /**
     * 登录时间
     */
    private Date    logTime;

    /**
     * 登录IP
     */
    private String  logIp;

    /**
     * 访问的路径地址
     */
    private String  logUrl;

    /**
     * 访问的浏览器
     */
    private String  logBrowse;

    /**
     * 访问的操作系统
     */
    private String  logOs;

    /**
     * 状态，1成功，0失败
     */
    private String  status;

    /**
     * 描述
     */
    private String  description;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }
        if (getLogTime() == null) {
            setLogTime(new Date());
        }
    }

}
