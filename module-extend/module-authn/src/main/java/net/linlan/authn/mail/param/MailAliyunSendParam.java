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
package net.linlan.authn.mail.param;

import lombok.Data;

/**
 * 阿里云 发送邮件参数
 *
 * @author Linlan
 * 
 */
@Data
public class MailAliyunSendParam {
    /**
     * 分组名称，非必填
     */
    private String  groupName;
    /**
     * 发件人邮箱
     */
    private String  from;
    /**
     * 发件人昵称
     */
    private String  formAlias;
    /**
     * 收件人邮箱列表，逗号拼接
     */
    private String  tos;
    /**
     * 邮件主题
     */
    private String  subject;
    /**
     * 邮件内容
     */
    private String  content;
    /**
     * 是否为html格式
     */
    private boolean html;
}
