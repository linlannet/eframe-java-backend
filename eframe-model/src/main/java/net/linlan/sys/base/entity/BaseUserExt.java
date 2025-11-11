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

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.base.constant.IdTypeEnum;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * BaseUserExt数据域:基础用户扩展信息实体类
 * @author Linlan
 * CreateTime 2023-08-12 13:37:57 *
 */
@Data
public class BaseUserExt extends BaseEntity {

    /**
     * 用户ID
     */
    private String  id;

    /**
     * 用户昵称
     */
    private String  nickname;

    /**
     * 真实姓名，加密的姓名
     */
    private String  idName;

    /**
     * 身份证号码，加密的身份证号码
     */
    private String  idNum;

    /**
     * 电话
     */
    private String  idMobile;

    /**
     * 证件类型
     */
    private String  idType;

    /**
     * 姓名全拼，BCryptPasswordEncoder密码")
     */
    private String  namePy;

    /**
     * 姓名缩写，外部输入填写的姓名
     */
    private String  sname;

    /**
     * 姓名英文
     */
    private String  nameEn;

    /**
     * 查询码，名称的拼音首字母
     */
    private String  searchCode;

    /**
     * 性别GB_XBDM
     */
    private String  sex;

    /**
     * 出生日期
     */
    private Date    birthday;

    /**
     * 家庭邮政编码
     */
    private String  postCode;

    /**
     * 地址
     */
    private String  address;

    /**
     *  籍贯GB_XZQHDM_SHENG
     */
    private String  nativePlace;

    /**
     * 家庭地址
     */
    private String  familyAddress;

    /**
     * 住宅电话
     */
    private String  homeTel;

    /**
     * 即时通讯QQ号码
     */
    private String  qqNo;

    /**
     * 微信用户名
     */
    private String  weixinId;

    /**
     * 微博用户名
     */
    private String  weiboId;

    /**
     * 备用手机，紧急手机
     */
    private String  spareMobile;

    /**
     * 手机号码是否验证0否1是
     */
    private Boolean isMobileConfirm;

    /**
     * 紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码
     */
    private String  emergencePhone;

    /**
     * 关键字
     */
    private String  keywords;

    /**
     * 个人介绍
     */
    private String  intro;

    /**
     * 来自
     */
    private String  comefrom;

    /**
     * 用户图像图标
     */
    private String  imagePath;

    /**
     * 用户签名
     */
    private String  userSignature;

    /**
     * 登录IP地址(";"分隔）
     */
    private String  ipRange;

    /**
     * 允许登录MAC地址(";"分隔）
     */
    private String  macCode;

    /**
     * 简历，网格平台使用，人所属的网格多个，分隔
     */
    private String  resume;

    /**
     * 备用1
     */
    private String  spare1;

    /**
     * 备用2
     */
    private String  spare2;

    /**
     * 备用3
     */
    private String  spare3;

    /**
     * 备用4
     */
    private String  spare4;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }
        if (getIdType() == null) {
            setIdType(IdTypeEnum.SHENFENZHENG.getKey());
        }
    }

}
