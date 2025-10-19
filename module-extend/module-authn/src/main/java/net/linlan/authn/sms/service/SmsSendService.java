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
package net.linlan.authn.sms.service;

import java.util.Map;

/**
 * 短信服务API
 *
 * @author Linlan
 * 
 */
public interface SmsSendService {

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param params 参数
     * @return 是否发送成功
     */
    boolean send(String mobile, Map<String, String> params);

    /**
     * 发送短信
     *
     * @param groupName 分组名称
     * @param mobile    手机号
     * @param params    参数
     * @return 是否发送成功
     */
    boolean send(String groupName, String mobile, Map<String, String> params);

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param key    参数KEY
     * @param value  参数Value
     * @return 是否发送成功
     */
    boolean sendCode(String mobile, String key, String value);

    /**
     * 发送短信
     *
     * @param groupName 分组名称
     * @param mobile    手机号
     * @param key       参数KEY
     * @param value     参数Value
     * @return 是否发送成功
     */
    boolean sendCode(String groupName, String mobile, String key, String value);

    /**
     * 效验短信验证码
     *
     * @param mobile 手机号
     * @param code   验证码
     * @return 是否效验成功
     */
    boolean verifyCode(String mobile, String code);
}
