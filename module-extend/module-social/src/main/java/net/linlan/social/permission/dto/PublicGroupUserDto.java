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

import java.util.Date;

import lombok.Data;

/**
 *
 * 用户组关联表查询结果Dto对象
 * @author Linlan
 */
@Data
public class PublicGroupUserDto {
    /**
     * 用户管理组ID
     */
    private Long   id;

    /**
     * 分组编号
     */
    private Long   groupId;

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 会员ID
     */
    private Long   memberId;

    /**
     * 创建人id
     */
    private String creatorId;
    /**
     * 创建时间
     */
    private Date   createTime;

    /**
     * 最后修改时间
     */
    private Date   lastTime;

}
