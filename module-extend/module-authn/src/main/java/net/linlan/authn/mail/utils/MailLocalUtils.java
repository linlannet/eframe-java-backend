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
package net.linlan.authn.mail.utils;

import java.io.File;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

import lombok.extern.slf4j.Slf4j;

import net.linlan.authn.mail.vo.MailConfigVo;
import net.linlan.utils.exception.CommonException;

/**
 * 本地 邮件发送
 *
 * @author Linlan
 * 
 */
@Slf4j
public class MailLocalUtils {

    private final MailAccount mailAccount;

    public MailLocalUtils(MailConfigVo config) {
        MailAccount mailAccount = new MailAccount();
        mailAccount.setHost(config.getMailHost());
        if (config.getMailPort() != null) {
            mailAccount.setPort(config.getMailPort());
            // 开启SSL加密
            if (config.getMailPort() == 465 || config.getMailPort() == 587) {
                mailAccount.setSslEnable(true);
            }
        }
        mailAccount.setFrom(config.getMailFrom());
        mailAccount.setPass(config.getMailPass());
        this.mailAccount = mailAccount;
    }

    /**
     * 发送邮件
     *
     * @param tos     收件人邮箱列表，多个收件人逗号隔开
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param isHtml   是否为html类型
     * @param files   附件列表
     * @return message-id
     */
    public String sendEmail(String tos, String subject, String content, boolean isHtml,
                            File... files) {
        try {
            return MailUtil.send(mailAccount, tos, subject, content, isHtml, files);
        } catch (Exception e) {
            log.error("发送邮件失败", e);
            throw new CommonException(e.getMessage());
        }
    }
}
