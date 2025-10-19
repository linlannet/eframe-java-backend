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

import java.io.File;
import java.util.List;

import cn.hutool.core.collection.CollectionUtil;

import lombok.Data;

/**
 * 本地 发送邮件参数
 *
 * @author Linlan
 * 
 */
@Data
public class EmailLocalSendParam {
    /**
     * 分组名称，非必填
     */
    private String     groupName;
    /**
     * 收件人邮箱列表，逗号拼接
     */
    private String     tos;
    /**
     * 邮件主题
     */
    private String     subject;
    /**
     * 邮件内容
     */
    private String     content;
    /**
     * 是否为html格式
     */
    private boolean    html;
    /**
     * 附件列表
     */
    private List<File> files = CollectionUtil.newArrayList();
}
