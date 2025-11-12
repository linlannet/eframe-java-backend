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
package net.linlan.authn.mail.vo;

import lombok.Data;

/**
 * 邮件发送
 *
 * @author Linlan
 */
@Data
public class MailSendVo {

    /**
     * 主键ID
     */
    private Long    id;
    /**
     * 平台
     */
    private Integer platform;
    /**
     * 邮件格式
     */
    private String  mailFormat;
    /**
     * 发件人邮箱
     */
    private String  mailFrom;
    /**
     * 发件人昵称
     */
    private String  formAlias;
    /**
     * 接收人邮箱
     */
    private String  mailTos;
    /**
     * 收件人列表
     */
    private String  receiversName;
    /**
     * 模板名
     */
    private String  templateName;
    /**
     * 标签名
     */
    private String  tagName;
    /**
     * 邮件主题
     */
    private String  subject;
    /**
     * 邮件正文
     */
    private String  content;

}
