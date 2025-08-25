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
package net.linlan.frame;

import com.alibaba.fastjson2.JSONObject;

import lombok.Data;

/**
 *
 * Filename:FrameThirdAccount.java
 * Desc: 公共应用支撑的平台账户
 *
 * @author Linlan
 * CreateTime:3/28/19 6:52 PM
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class FrameThirdAccount {
    /**
     * accountId，第三方平台入口的账户ID
     */
    private String     accountId;
    /**
     * ServerCode，第三方平台入口的服务代码
     */
    private String     servCode;
    /**
     * 第三方应用的服务代码的业务类型
     */
    private String     type;
    /**
     * 第三方应用的服务代码的操作类型
     */
    private String     actionType;
    /**
     * 传入的内容，输入的内容
     */
    private String     input;
    /**
     *  输入的内容，JSON对象
     */
    private JSONObject inputObject;

    public FrameThirdAccount() {
    }

}
