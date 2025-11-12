/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.permission.dto;

import lombok.Data;

import net.linlan.social.permission.entity.UserRangeOrgan;

/**
 *
 * UserRangeOrgan数据域:人员应用范围机构关联查询结果Dto对象
 * @author Linlan
 * CreateTime 2023-08-29 13:55:02 *
 */
@Data
public class UserRangeOrganDto extends UserRangeOrgan {
    /**
     * 姓名
     */
    private String name;
    /**
     * 机构名称
     */
    private String organName;
}
