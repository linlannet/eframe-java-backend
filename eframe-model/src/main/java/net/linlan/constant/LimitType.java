/*
 * eframe-model - model模型数据模块
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
package net.linlan.constant;

/**
 * 限流枚举
 */
public enum LimitType {
                       /**
                        * 所有请求限流
                        */
                       ALL,
                       /**
                        * 对用户请求限流
                        */
                       USER,
                       // by idCard
                       /**
                        * 对用户敏感信息查看限流
                        */
                       SENSITIVE,
                       /**
                        * 对用户IP地址限流
                        */
                       IPADDR
}
