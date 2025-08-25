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
package net.linlan.sys.core.dto;

import lombok.Data;

import net.linlan.sys.core.entity.CoreAccount;

/**
 *
 * CoreAccount数据域:平台对接账户Dto对象
 * @author Linlan
 * CreateTime 2018-03-01 19:01:51
 *
 */
@Data
public class CoreAccountDto extends CoreAccount {
    /**
     * 内部系统名称
     */
    private String inOrganName;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 对接模式名字
     */
    private String inoutModeName;
    /**
     * 平台类型名字
     */
    private String typeName;

}
