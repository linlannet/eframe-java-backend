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

/**
 *
 * Filename:MutualOrganBaseDto.java
 * Desc: 街镇频道最近访问信息
 *
 * @author Linlan
 * CreateTime:9/13/20 5:21 PM
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class OrganResidentialUserDto {
    /**
     * 编号
     */
    private String id;
    /**
     * 区县名称
     */
    private String districtName;
    /**
     * 街镇名称
     */
    private String subdistrictName;
    /**
     * 小区名称
     */
    private String residentialName;
    /**
     * 权限
     */
    private String power;
    /**
     * 名称
     */
    private String name;
    /**
     * 电话
     */
    private String tel;
    /**
     * 地址
     */
    private String address;

    public OrganResidentialUserDto() {

    }

}
