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

import java.io.Serializable;

import lombok.Data;

/**
 *
 * Filename:PositionBindUserDto.java
 * Desc:
 *
 * @author Linlan
 * CreateTime:2020-03-30 23:00:15
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class PositionBindUserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 会员ID
     */
    private Long              memberId;
    /**
     * 类型，1负责人2书记11一般21文秘50岗位
     */
    private Integer           type;
    /**
     * 岗位ID
     */
    private String            positionId;
    /**
     * 是否主岗位0否1是
     */
    private Boolean           isDef;
    /**
     * 会员名称
     */
    private String            name;
    /**
     * 手机号码
     */
    private String            mobile;
    /**
     * 手机号码
     */
    private String            userId;

}
