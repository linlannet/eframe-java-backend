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

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * ThirdMember数据域:第三方用户查询参数实体类
 * 
 * @author Linlan
 * CreateTime 2025-10-13 16:35:28
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class ThirdMemberParam extends BaseParam {

    /**
     * 主键ID
     */
    private Long    id;
    /**
     * 机构ID
     */
    private String  organId;
    /**
     * 外键ID，人口库ID
     */
    private String  foreignId;
    /**
     * 身份提供商ID
     */
    private String  accountId;
    /**
     * 开放平台认证平台类型
     */
    private String  serverType;
    /**
     * 三方全局D
     */
    private String  unionId;
    /**
     * 开放平台ID
     */
    private String  openId;
    /**
     * 邮箱
     */
    private String  email;
    /**
     * 手机号对应的国家号
     */
    private String  areaCode;
    /**
     * 电话号码
     */
    private String  mobile;
    /**
     * 昵称
     */
    private String  nickName;
    /**
     * 头像
     */
    private String  avatarUrl;
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
