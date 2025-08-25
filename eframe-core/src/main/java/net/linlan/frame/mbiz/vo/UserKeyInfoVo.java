/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.mbiz.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * Filename UserKeyInfoVo,通用人员关键信息Vo类
 * 对FramePubUser进行敏感信息单独处理
 * @author Linlan
 * CreateTime 2023-08-29 17:23:24
 *
 */
@Data
@NoArgsConstructor
public class UserKeyInfoVo {
    /**
     * 会员ID，同AdminUser的id、MemberUser的id
     */
    private Long   id;
    /**
     * 全局用户LID，同BaseUser的id
     */
    private String userId;
    /**
     * 姓名或者显示名称，同BaseUserExt的name，或者MemberUser内的name或者AdminUser的name
     * 用户显示的名称
     * 用户全名，将用户名、姓名、手机联合起来
     */
    private String name;
    /**
     * 手机号码，同BaseUser的mobile
     */
    private String mobile;
    /**
     * 身份证类型关联baseUserExt表spare3
     */
    private String idType;
    /**
     * 身份证号
     */
    private String idNum;

}
