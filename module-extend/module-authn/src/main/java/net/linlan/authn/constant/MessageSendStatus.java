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
package net.linlan.authn.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;

import net.linlan.utils.enums.EnumConvert;

/**
 * 消息发送状态
 *
 * @author Linlan
 */
@Getter
public enum MessageSendStatus {
                               /**
                                * 已发送
                                */
                               SEND("send", "已发送"),
                               /**
                                * 草稿
                                */
                               DRAFT("draft", "草稿");

    /**
     * 键
     */
    @JsonValue
    private final String key;
    /**
     * 值
     */
    private final String value;

    MessageSendStatus(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 获取类型
     *
     * @param key {@link String}
     * @return {@link MessageSendStatus}
     */
    @EnumConvert
    public static MessageSendStatus fromType(String key) {
        MessageSendStatus[] values = values();
        for (MessageSendStatus status : values) {
            if (String.valueOf(status.getKey()).equals(key)) {
                return status;
            }
        }
        return null;
    }
}
