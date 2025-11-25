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

import lombok.Data;

/**
 * 公共账号查询条件
 */
@Data
public class PositionAccountParam {

    /**
     * 岗位id
     */
    private String positionId;
    /**
     * 组id
     */
    private String groupId;
    /**
     * 机构id
     */
    private String organId;
    /**
     * 区域id
     */
    private Long   areaId;
}
