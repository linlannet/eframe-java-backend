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
package net.linlan.authn.sms.channel;

import java.util.Map;

import net.linlan.authn.sms.constant.SmsPlatform;
import net.linlan.authn.sms.vo.SmsConfigVo;
import net.linlan.utils.exception.CommonException;

/**
 * 短信 Context
 *
 * @author Linlan
 * 
 */
public class SmsContext {
    private final SmsProvider smsProvider;

    public SmsContext(SmsConfigVo config) {
        if (config.getProviderId() == SmsPlatform.ALIYUN.getValue()) {
            this.smsProvider = new AliyunSmsProvider(config);
        } else if (config.getProviderId() == SmsPlatform.TENCENT.getValue()) {
            this.smsProvider = new TencentSmsProvider(config);
        } else if (config.getProviderId() == SmsPlatform.HUAWEI.getValue()) {
            this.smsProvider = new HuaweiSmsProvider(config);
        } else {
            throw new CommonException("未知的短信平台");
        }
    }

    public void send(String mobile, Map<String, String> params) {
        smsProvider.send(mobile, params);
    }
}
