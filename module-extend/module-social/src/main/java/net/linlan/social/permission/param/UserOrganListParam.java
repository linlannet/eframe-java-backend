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
package net.linlan.social.permission.param;

import java.util.List;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

@Data
public class UserOrganListParam extends BaseParam {
    /**
     * 工作机构ID
     */
    private String       id;
    /**
     * 用户名称
     */
    private String       name;
    /**
     * 机构名称
     */
    private String       organName;
    /**
     * 用户ID
     */
    private String       userId;
    /**
     * 机构ID
     */
    private String       organId;
    /**
     * 机构ID集合
     */
    private List<String> organIds;
    /**
     * 岗位ID
     */
    private String       positionId;
    /**
     * 创建时间
     */
    private String       createTime;
    /**
     * 只显示本级的：Y 是 只查下一级，N 否 递归所有下一级
     */
    private String       onlyCurrent = "N";
    /**
     * 组查询，多个英文逗号分隔
     */
    private String       groupIds;
}
