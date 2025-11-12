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
package net.linlan.authn.manage.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.util.StrUtil;

import net.linlan.annotation.Encrypt;
import net.linlan.authn.mail.constant.MailFormatEnum;
import net.linlan.authn.mail.constant.MailPlatformEnum;
import net.linlan.authn.mail.dto.EmailRegisterDto;
import net.linlan.authn.mail.param.MailAliyunBatchSendParam;
import net.linlan.authn.mail.param.MailAliyunSendParam;
import net.linlan.authn.mail.param.MailLocalSendParam;
import net.linlan.authn.mail.service.MailSendService;
import net.linlan.authn.mail.vo.MailSendVo;
import net.linlan.authn.manage.service.AuthnLoginService;
import net.linlan.authn.manage.vo.MobileLoginBody;
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
    @Resource
    private MailSendService   mailSendService;

    /**
     * 短信邮箱登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PlatLog(value = "短信邮箱登录方法", category = 10, srcCode = 10)
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
    @PlatLog(value = "登录发送短信验证码", category = 10, srcCode = 10)
    @PostMapping("/login/otp/send")
    public ResponseResult<String> sendOtpCode(String mobile) {
        boolean flag = authnLoginService.sendCode(mobile);
        if (!flag) {
            return ResponseResult.error("短信发送失败！");
        }

        return ResponseResult.ok();
    }

    /**
     * 发送邮件
     *
     * @param vo 邮件发送对象
     * @return 发送状态
     */
    @PlatLog(value = "登录发送短信验证码", category = 10, srcCode = 10)
    @PostMapping("/login/mail/send")
    public ResponseResult<String> send(@RequestBody MailSendVo vo) {
        // 发送本地邮件
        if (vo.getPlatform() == MailPlatformEnum.LOCAL.getValue()) {
            MailLocalSendParam local = new MailLocalSendParam();
            local.setTos(vo.getMailTos());
            local.setSubject(vo.getSubject());
            local.setContent(vo.getContent());
            local.setHtml(StrUtil.equalsIgnoreCase(vo.getMailFormat(), MailFormatEnum.HTML.name()));
            boolean flag = mailSendService.sendLocal(local);

            return flag ? ResponseResult.ok() : ResponseResult.error("发送失败");
        }

        // 发送阿里云模板邮件
        if (vo.getPlatform() == MailPlatformEnum.ALIYUN.getValue()
            && StrUtil.equalsIgnoreCase(vo.getMailFormat(), MailFormatEnum.TEMPLATE.name())) {
            MailAliyunBatchSendParam aliyun = new MailAliyunBatchSendParam();
            aliyun.setFrom(vo.getMailFrom());
            aliyun.setReceiversName(vo.getReceiversName());
            aliyun.setTagName(vo.getTagName());
            aliyun.setTemplateName(vo.getTemplateName());
            boolean flag = mailSendService.batchSendAliyun(aliyun);

            return flag ? ResponseResult.ok() : ResponseResult.error("发送失败");
        }

        // 发送阿里云邮件
        if (vo.getPlatform() == MailPlatformEnum.ALIYUN.getValue()) {
            MailAliyunSendParam aliyun = new MailAliyunSendParam();
            aliyun.setFrom(vo.getMailFrom());
            aliyun.setFormAlias(vo.getFormAlias());
            aliyun.setTos(vo.getMailTos());
            aliyun.setSubject(vo.getSubject());
            aliyun.setContent(vo.getContent());
            aliyun
                .setHtml(StrUtil.equalsIgnoreCase(vo.getMailFormat(), MailFormatEnum.HTML.name()));
            boolean flag = mailSendService.sendAliyun(aliyun);

            return flag ? ResponseResult.ok() : ResponseResult.error("发送失败");
        }

        return ResponseResult.error("不支持的邮件平台或邮件格式");
    }

    /**
     * 邮箱账号注册
     *
     * @param dto 邮箱注册信息
     * @return 邮箱注册状态
     */
    @PlatLog(value = "邮箱账号注册", category = 10, srcCode = 10)
    @PostMapping("/login/mail/register")
    public ResponseResult<Boolean> register(@RequestBody EmailRegisterDto dto) {
        return ResponseResult.ok(authnLoginService.register(dto));
    }

    /**
     * 根据邮箱修改密码
     *
     * @param dto 邮箱注册信息
     * @return 邮箱忘记密码修改状态
     */
    @PlatLog(value = "根据邮箱修改密码", category = 10, srcCode = 10)
    @PostMapping("/login/mail/email/forgot")
    public ResponseResult<Boolean> forgot(@RequestBody EmailRegisterDto dto) {
        return ResponseResult.ok(authnLoginService.forgot(dto));
    }

}
