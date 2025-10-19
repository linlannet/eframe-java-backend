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

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import com.tencentcloudapi.sms.v20210111.models.SendStatus;

import net.linlan.authn.sms.vo.SmsConfigVo;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.exception.CommonException;

/**
 * 腾讯云短信提供商
 *
 * @author Linlan
 * 
 */
public class TencentSmsProvider implements SmsProvider {
    private final SmsConfigVo smsConfig;
    private SmsClient         client;

    public TencentSmsProvider(SmsConfigVo smsConfig) {
        this.smsConfig = smsConfig;

        try {
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setReqMethod("POST");
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            Credential cred = new Credential(smsConfig.getAccessKey(), smsConfig.getSecretKey());
            this.client = new SmsClient(cred, "ap-shanghai", clientProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(String mobile, Map<String, String> params) {
        SendSmsRequest request = new SendSmsRequest();
        request.setSmsSdkAppId(smsConfig.getAppId());
        request.setSignName(smsConfig.getSignName());
        request.setTemplateId(smsConfig.getTemplateId());

        // 有参数则设置
        if (MapUtils.isNotEmpty(params)) {
            request.setTemplateParamSet(params.values().toArray(new String[0]));
        }

        // 手机号
        String[] phoneNumberSet = { "+86" + mobile };
        request.setPhoneNumberSet(phoneNumberSet);

        // 国际、港澳台短信，需要添加SenderId，国内短信填空，默认未开通
        request.setSenderId(smsConfig.getSenderId());

        try {
            // 发送短信
            SendSmsResponse response = client.SendSms(request);
            SendStatus sendStatus = response.getSendStatusSet()[0];

            // 发送失败
            if (!Constants.OK.equalsIgnoreCase(sendStatus.getCode())) {
                throw new CommonException(sendStatus.getMessage());
            }
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }
    }
}
