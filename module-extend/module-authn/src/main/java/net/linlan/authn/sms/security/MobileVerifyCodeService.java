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
package net.linlan.authn.sms.security;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.linlan.authn.sms.service.SmsSendService;

/**
 * 手机短信登录，验证码校验
 *
 * @author Linlan
 * 
 */
@Service
public class MobileVerifyCodeService {

    @Resource
    private SmsSendService smsSendService;

    /** 通过手机号码和验证码实现验证
     * @param mobile 手机号码
     * @param code  验证码
     * @return  验证结果
     */
    public boolean verifyCode(String mobile, String code) {
        return smsSendService.verifyCode(mobile, code);
    }
}
