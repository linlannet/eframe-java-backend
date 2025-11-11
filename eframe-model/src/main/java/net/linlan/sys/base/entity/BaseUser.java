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
package net.linlan.sys.base.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * BaseUser数据域:基础用户实体类
 * @author Linlan
 * CreateTime 2023-08-08 13:41:37 *
 */
@Data
public class BaseUser extends BaseEntity {

    /**
     * 用户ID
     */
    private String  id;

    /**
     * 行政区划编号，用户来源地
     */
    private Long    xzqhId;

    /**
     * 创建来源类型
     */
    private String  source;

    /**
     * 创建方式0导入1录入2授权
     */
    private Integer createType;

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
     * 混淆字符
     */
    private String  salt;

    /**
     * 当前来源0缺省1:WEB或PC,2APP21:AndroidAPP,22:IOSAPP,3WAP,4MINI
     */
    private Integer srcCode;

    /**
     * 注册时间
     */
    private Date    registerTime;

    /**
     * 注册IP
     */
    private String  registerIp;

    /**
     * 当前登录时间
     */
    private Date    currentLoginTime;

    /**
     * 当前登录IP
     */
    private String  currentLoginIp;

    /**
     * 最后登录的应用ID
     */
    private String  lastAppId;

    /**
     * 最后登录时间
     */
    private Date    lastLoginTime;

    /**
     * 最后登录IP
     */
    private String  lastLoginIp;

    /**
     * 最后一次退出时间
     */
    private Date    lastLogoutTime;

    /**
     * 登录次数
     */
    private Integer loginCount;

    /**
     * 重置密码KEY
     */
    private String  resetKey;

    /**
     * 重置密码VALUE
     */
    private String  resetPwd;

    /**
     * 上次修改密码时间，最后一次修改密码时间
     */
    private Date    lastResetTime;

    /**
     * 出错时间
     */
    private Date    errorTime;

    /**
     * 出错数量
     */
    private Integer errorCount;

    /**
     * 出错IP
     */
    private String  errorIp;

    /**
     * 锁定时间
     */
    private Date    lockTime;

    /**
     * 是否激活0否1是
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
     * 删除标记0正常1已删除2应用内受限3回收站
     */
    private Integer delFlag;

    /**
     * 删除时间
     */
    private Date    deleteTime;

    /**
     * 描述
     */
    private String  description;

    /**
     * 备用1，头像
     */
    private String  spare1;

    /**
     * 备用2，第三方用户ID，OpenId
     */
    private String  spare2;
    /**
     * 新密码
     */
    private String  newPassword;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.UUID32());
        }
        if (getCreateTime() == null) {
            setCreateTime(new Date());
        }
        if (getRegisterTime() == null) {
            setRegisterTime(new Timestamp(System.currentTimeMillis()));
        }
        if (getLastTime() == null) {
            setLastTime(new Timestamp(System.currentTimeMillis()));
        }
        if (getRegisterIp() == null) {
            setRegisterIp("127.0.0.1");
        }
        if (getCurrentLoginIp() == null) {
            setCurrentLoginIp("127.0.0.1");
        }
        if (getLastLoginIp() == null) {
            setLastLoginIp("127.0.0.1");
        }
        if (getSrcCode() == null) {
            setSrcCode(KernelConstant.SRC_CODE_DEFAULT);
        }
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
        if (getDelFlag() == null) {
            setDelFlag(DelFlagEnum.NORMAL.getKey());
        }
        if (getLoginCount() == null) {
            setLoginCount(KernelConstant.DEFAULT_COUNT);
        }
        if (getErrorCount() == null) {
            setErrorCount(KernelConstant.DEFAULT_INT);
        }
        if (getActivation() == null) {
            setActivation(Boolean.TRUE);
        }
    }

}
