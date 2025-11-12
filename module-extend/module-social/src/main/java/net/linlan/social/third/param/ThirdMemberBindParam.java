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
package net.linlan.social.third.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * ThirdMemberBind数据域:用户身份提供商绑定查询参数实体类
 * 
 * @author Linlan
 * CreateTime 2025-10-13 16:35:28
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class ThirdMemberBindParam extends BaseParam {

    /**
     * 主键ID
     */
    private String  id;
    /**
     * 会员ID
     */
    private Long    memberId;
    /**
     * 用户ID
     */
    private String  userId;
    /**
     * 系统用户名，手机号
     */
    private String  username;
    /**
     * 身份提供商ID
     */
    private String  accountId;
    /**
     * 第三方账号KEY，市民云、微信等的UnionId或OpenId
     */
    private String  accountKey;
    /**
     * 绑定时间
     */
    private Date    bindTime;
    /**
     * 附加信息
     */
    private String  additionInfo;
    /**
     * 创建人ID
     */
    private String  creatorId;
    /**
     * 删除标记，0未删除1已删除
     */
    private Integer delFlag;
    /**
     * 备注
     */
    private String  description;
    /**
     * 备用1
     */
    private String  spare1;
    /**
     * 备用2
     */
    private String  spare2;

}
