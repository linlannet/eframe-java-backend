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
package net.linlan.social.manage.vo;

import java.util.Date;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.social.third.dto.ThirdUserDto;

/**
 *
 * BaseUser视图域:统一用户表显示Vo类
 * @author Linlan
 * CreateTime 2023-09-04 21:28:44<br>
 * <br>
 * @version 1.0<br>
 * @since 1.0<br>
 *
 */
@Data
public class ThirdUserVo {
    /**
     * 用户ID
     */
    private Long    id;
    /**
     * 用户UUID
     */
    private String  userId;
    /**
     * 行政区划编号，用户来源地
     */
    private Long    xzqhId;
    /**
     * 创建来源类型
     */
    private String  source;

    /**
     * 用户名，城市APP市民云的用户名
     */
    private String  username;
    /**
     * 手机号码
     */
    private String  mobile;
    /**
     * 电子邮箱
     */
    private String  email;
    /**
     * 密码
     */
    private String  password;
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
    private String  accountType;
    /**
     * 三方全局D
     */
    private String  unionId;
    /**
     * 开放平台ID
     */
    private String  openId;
    /**
     * 昵称
     */
    private String  nickName;
    /**
     * 头像
     */
    private String  avatarUrl;
    /**
     * 注册时间
     */
    private Date    registerTime;
    /**
     * 最后登录时间
     */
    private Date    lastLoginTime;
    /**
     * 最后登录IP
     */
    private String  lastLoginIp;
    /**
     * 登录次数
     */
    private Integer loginCount;
    /**
     * 锁定时间
     */
    private Date    lockTime;
    /**
     * 是否激活0否1是，是否需要更改密码0否1是
     */
    private Boolean activation;
    /**
     * 激活代码
     */
    private String  activationCode;
    /**
     * 排序
     */
    private Integer priority;
    /**
     * 创建时间
     */
    private Date    createTime;
    /**
     * 删除标记0正常1已删除2应用内受限3回收站
     */
    private Integer delFlag;
    /**
     * 描述
     */
    private String  description;
    /**
     * 备用1，第三方的平台的用户名，如随申办统一身份体系的用户名
     */
    private String  spare1;
    /**
     * 备用2，第三方用户ID，OpenId
     */
    private String  spare2;

    /**
     * 无参构造器
     */
    public ThirdUserVo() {
    }

    /**
     * 数据赋值DTO方法，将ThirdUserDto的input对象赋值给BaseUserVo
     */
    public static final Function DTO = new Function<ThirdUserDto, ThirdUserVo>() {
        @Nullable
        @Override
        public ThirdUserVo apply(@Nullable ThirdUserDto input) {
            return new ThirdUserVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public ThirdUserVo(ThirdUserDto input) {
        this.id = input.getId();
        this.userId = input.getUserId();
        this.xzqhId = input.getBaseUser().getXzqhId();
        this.source = input.getBaseUser().getSource();
        this.username = input.getBaseUser().getUsername();
        this.mobile = input.getMobile();
        this.email = input.getEmail();
        this.password = input.getBaseUser().getPassword();
        this.organId = input.getOrganId();
        this.foreignId = input.getForeignId();
        this.accountId = input.getAccountId();
        this.accountType = input.getAccountType();
        this.unionId = input.getUnionId();
        this.openId = input.getOpenId();
        this.nickName = input.getNickName();
        this.avatarUrl = input.getAvatarUrl();
        this.registerTime = input.getBaseUser().getRegisterTime();
        this.lastLoginIp = input.getBaseUser().getLastLoginIp();
        this.lastLoginTime = input.getBaseUser().getLastLoginTime();
        this.loginCount = input.getBaseUser().getLoginCount();
        this.lockTime = input.getBaseUser().getLockTime();
        this.activation = input.getBaseUser().getActivation();
        this.activationCode = input.getBaseUser().getActivationCode();
        this.priority = input.getBaseUser().getPriority();
        this.createTime = input.getCreateTime();
        this.delFlag = input.getDelFlag();
        this.description = input.getDescription();
        this.spare1 = input.getSpare1();
        this.spare2 = input.getSpare2();
    }

}
