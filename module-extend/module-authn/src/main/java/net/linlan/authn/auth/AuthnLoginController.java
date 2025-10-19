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
package net.linlan.authn.auth;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.linlan.annotation.Encrypt;
import net.linlan.authn.service.AuthnLoginService;
import net.linlan.authn.vo.MobileLoginBody;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.comm.vo.AppLoginInfo;

/**
 * 短信邮箱登录验证
 * 
 * @author Linlan
 */
@RestController
public class AuthnLoginController {
    @Resource
    private AuthnLoginService authnLoginService;

    /**
     * 短信邮箱登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PlatLog(value = "短信邮箱登录方法", category = 10, srcCode = 11)
    @PostMapping("/login/sms")
    @Encrypt
    public ResponseResult<AppLoginInfo> authnLogin(@RequestBody MobileLoginBody loginBody) {
        // 生成令牌
        AppLoginInfo appLoginInfo = authnLoginService.loginByMobile(loginBody);
        return ResponseResult.ok(appLoginInfo);
    }

    /**
     * 登录发送短信验证码
     *
     * @param mobile 手机号码
     * @return 短信发送状态
     */
    @PlatLog(value = "登录发送短信验证码", category = 10, srcCode = 11)
    @PostMapping("/login/otp/send")
    public ResponseResult<String> sendCode(String mobile) {
        boolean flag = authnLoginService.sendCode(mobile);
        if (!flag) {
            return ResponseResult.error("短信发送失败！");
        }

        return ResponseResult.ok();
    }

}
