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

import net.linlan.utils.entity.BaseEntity;

@Data
public class PermissionCommDto extends BaseEntity {

    /**
     * 人员机构关系ID
     */
    private Long    relationId;
    /**
     * 机构ID
     */
    private String  organId;
    /**
     * 岗位ID
     */
    private String  positionId;
    /**
     * 会员组ID
     */
    private String  groupId;
    /**
     * 用户ID
     */
    private String  userId;
    /**
     * 用户名称
     */
    private String  name;
    /**
     * 类型
     */
    private String  type;
    /**
     * 会员ID
     */
    private Long    memberId;
    /**
     * 手机
     */
    private String  mobile;
    /**
     * 删除标记
     */
    private Integer delFlag;
    /**
     * 用户ID
     */
    private Integer areaId;
    /**
     * 站点ID
     */
    private Long    siteId;
}
