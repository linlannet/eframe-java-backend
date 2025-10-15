/*
 * eframe-model - model模型数据模块
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
package net.linlan.frame;

import java.util.Date;

import lombok.Data;

/**
 *
 * Filename FramePubUser,通用的基础SA支撑用户类
 * 适用基本用户，仅保留基本信息，可账号注册，允许非实名，如微信公众号授权登录等
 * @author Linlan
 * CreateTime 2019-07-07 17:23:24
 *
 */
@Data
public class FramePubUser {
    /**
     * 会员ID，同AdminUser的id或者MemberUser的id
     */
    private Long    id;
    /**
     * 全局用户ID，同BaseUser的id
     */
    private String  userId;
    /**
     * 会员积分组ID，同MemberGroup的id
     */
    private Long    mgroupId;
    /**
     * 姓名或者显示名称，同BaseUserExt的name，或者MemberUser内的name或者AdminUser的name
     * 用户显示的名称
     * 用户全名，将用户名、姓名、手机联合起来
     */
    private String  name;
    /**
     * 全局用户名字，同BaseUser的username
     */
    private String  username;
    /**
     * 手机号码，同BaseUser的mobile
     */
    private String  mobile;
    /**
     * 身份证类型关联baseUserExt表spare3
     */
    private String  idType;
    /**
     * 身份证号
     */
    private String  idNum;
    /**
     * 是否前台0否1是，是则MEMBER_USER内存在信息，同CoreUser的isMember,否则AdminUser内存在
     */
    private Integer isMember;
    /**
     * 外部来源类型，local，wechat，smy，zwwechat，同ThirdAccountUser内的source，如没有记录则local
     */
    private String  source;
    /**
     * 外部关联ID，accountKey，同ThirdAccountUser内accountKey，如没有记录则local
     */
    private String  foreignId;
    /**
     * 最近登录的来源代码，同BaseUser的srcCode
     */
    private Integer srcCode;
    /**
     * 最近登录的应用，同BaseApp的appId，通过FrameToken内的siteId关联
     */
    private String  appId;
    /**
     * 最近登录的站点
     */
    private Long    siteId;
    /**
     * 所属机构ID，同IdentityUser的organId
     */
    private String  organId;
    /**
     * 所属部门ID，同IdentityUser的deptId
     */
    private Long    deptId;
    /**
     * 所属地域ID，同IdentityUser的areaId
     */
    private Long    areaId;
    /**
     * 认证权限地域ID，同IdentityUser的roleId
     */
    private Long    powerAreaId;
    /**
     * 认证角色ID，同IdentityUser的roleId
     */
    private Long    roleId;
    /**
     * 认证会员应用组ID，同IdentityUser的groupId
     */
    private Long    groupId;
    /**
     * 认证岗位ID，同IdentityUser的positionId
     */
    private String  positionId;
    /**
     * 地域类型ID
     */
    private String  areatypeId;
    /**
     * 地址
     */
    private String  address;
    /**
     * 状态0未生效1正常2受限3锁定4删除
     */
    private String  status;
    /**
     * 认证状态0未提交验证1验证通过2验证不通过
     */
    private Integer identityStatus;
    /**
     * 信息修改锁定标记0未锁定1全锁定2分级锁定3部门锁定
     */
    private Integer lockFlag;
    /**
     * 最后时间
     */
    private Date    lastTime;
    /**
     * 头像
     */
    private String  headerPic;
    /**
     * 全路径organId
     */
    private String  searchCode;
    /**
     * 机构名称
     */
    private String  organName;
    /**
     * 统一社会信用代码
     */
    private String  unionCode;

    public FramePubUser() {
    }

}
