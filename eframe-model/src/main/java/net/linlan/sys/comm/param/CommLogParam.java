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
package net.linlan.sys.comm.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * CommLog数据域:管理日志表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 14:41:14
 *
 */
@Data
public class CommLogParam extends BaseParam {

    /**
    * 应用ID
    */
    private String  appId;
    /**
    * 系统管理用户ID
    */
    private String  userId;
    /**
    * 用户名
    */
    private String  username;
    /**
    * 日志类型
    */
    private Integer category;
    /**
    * 操作
    */
    private String  operation;
    /**
    * 方法
    */
    private String  method;
    /**
    * 当前登录来源
    */
    private Integer srcCode;
    /**
    * 创建时间
    */
    private Date    createTime;
    /**
    * 来访IP地址
    */
    private String  ip;
    /**
    * 执行时长
    */
    private Long    time;

}
