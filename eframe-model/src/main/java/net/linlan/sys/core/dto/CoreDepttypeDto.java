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

import net.linlan.sys.core.entity.CoreDepttype;

/**
 *
 * CoreDepttype数据域:部门业务分类表查询结果Dto对象
 * @author Linlan
 * CreateTime 2023-08-12 13:45:49
 *
 */
@Data
public class CoreDepttypeDto extends CoreDepttype {

    /**
     * 父部门名称
     */
    private String parentName;
    /**
     * 机构分类名称
     */
    private String orgtypeName;
    /**
     * 地域类型名称
     */
    private String areatypeName;
}
