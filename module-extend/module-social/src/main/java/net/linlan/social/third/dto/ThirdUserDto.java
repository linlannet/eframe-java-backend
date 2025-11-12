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
package net.linlan.social.third.dto;

import lombok.Data;

import net.linlan.social.third.entity.ThirdMember;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.base.entity.BaseUserExt;

/**
 *
 * ThirdMember数据域:第三方用户Dto对象
 * 
 * @author Linlan
 * CreateTime 2025-10-13 16:35:28
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class ThirdUserDto extends ThirdMember {

    /**
     * 全局用户
     */
    private BaseUser    baseUser;
    /**
     * 全局用户扩展
     */
    private BaseUserExt baseUserExt;
}
