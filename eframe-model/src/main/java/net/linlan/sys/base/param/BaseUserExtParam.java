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
package net.linlan.sys.base.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * BaseUserExt数据域:用户扩展信息表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-08 13:41:37 *
 */
@Data
public class BaseUserExtParam extends BaseParam {

    /**
    * 用户昵称
    */
    private String   nickname;
    /**
    * 真实姓名，加密的姓名
    */
    private String   name;
    /**
    * 身份证号码，加密的身份证号码
    */
    private String   idNum;
    /**
     * 电话
     */
    private String   idMobile;
    /**
     * 证件类型
     */
    private String   idType;
    /**
    * 姓名全拼
    */
    private String   namePy;
    /**
    * 姓名缩写，外部输入填写的姓名
    */
    private String   sname;
    /**
    * 姓名英文
    */
    private String   nameEn;
    /**
    * 查询码，名称的拼音首字母
    */
    private String   searchCode;
    /**
    * 性别GB_XBDM
    */
    private String   sex;
    /**
    * 出生日期
    */
    private Date     birthday;
    /**
    * 家庭邮政编码
    */
    private String   postCode;
    /**
    * 地址
    */
    private String   address;
    /**
    *  籍贯GB_XZQHDM_SHENG
    */
    private String   nativePlace;
    /**
    * 家庭地址
    */
    private String   familyAddress;
    /**
    * 住宅电话
    */
    private String   homeTel;
    /**
     * QQ号码
     */
    private String   qqNo;
    /**
    * 微信用户名
    */
    private String   weixinId;
    /**
    * 备用手机，紧急手机
    */
    private String   spareMobile;
    /**
     * 手机是否验证
     */
    private boolean  isMobileConfirm;

    /**
    * 紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码
    */
    private String   emergencePhone;
    /**
    * 关键字
    */
    private String   keywords;
    /**
    * 个人介绍
    */
    private String   intro;
    /**
    * 来自
    */
    private String   comefrom;
    /**
    * 备用1
    */
    private String   spare1;
    /**
    * 备用2
    */
    private String   spare2;

    /**
     * 备用3
     */
    private String   spare3;
    /**
    * 备用4
    */
    private String   spare4;
    /**
     * id集合
     */
    private String[] ids;
}
