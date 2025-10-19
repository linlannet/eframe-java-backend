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

import org.apache.commons.collections4.MapUtils;

import com.alibaba.fastjson2.JSON;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;

import lombok.extern.slf4j.Slf4j;

import net.linlan.authn.sms.vo.SmsConfigVo;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.exception.CommonException;

/**
 * 阿里云短信提供商
 *
 * @author Linlan
 * 
 */
@Slf4j
public class AliyunSmsProvider implements SmsProvider {
    private final Client      client;
    private final SmsConfigVo smsConfig;

    public AliyunSmsProvider(SmsConfigVo smsConfig) {
        this.smsConfig = smsConfig;

        try {
            Config config = new Config();
            config.setAccessKeyId(smsConfig.getAccessKey());
            config.setAccessKeySecret(smsConfig.getSecretKey());
            config.endpoint = "dysmsapi.aliyuncs.com";

            this.client = new Client(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void send(String mobile, Map<String, String> params) {
        SendSmsRequest request = new SendSmsRequest();
        request.setSignName(smsConfig.getSignName());
        request.setTemplateCode(smsConfig.getTemplateId());
        request.setPhoneNumbers(mobile);
        //        request.setTemplateParam("{\"code\":\"1234\"}");
        if (MapUtils.isNotEmpty(params)) {
            request.setTemplateParam(JSON.toJSONString(params));
        }

        try {
            // 发送短信
            SendSmsResponse response = client.sendSms(request);

            // 发送失败
            if (!Constants.OK.equalsIgnoreCase(response.getBody().getCode())) {
                throw new CommonException(response.getBody().getMessage());
            }
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }
    }
}
