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
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * BaseOrganExt数据域:基础单位扩展信息实体类
 * @author Linlan
 * CreateTime 2018-03-02 13:41:37
 *
 */
@Data
public class BaseOrganExt extends BaseEntity {

    /**
     * 单位编号
     */
    private String id;

    /**
     * 全拼
     */
    private String namePy;

    /**
     * 单位简称
     */
    private String sname;

    /**
     * 名称英文
     */
    private String nameEn;

    /**
     * 查询码，单位名称的拼音首字母
     */
    private String searchCode;

    /**
     * 成立时间
     */
    private Date   establishDate;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 单位图片
     */
    private String imagePath;

    /**
     * 单位网址
     */
    private String web;

    /**
     * 单位传真
     */
    private String fax;

    /**
     * 单位电话
     */
    private String tel;

    /**
     * 联系人名称
     */
    private String contactName;

    /**
     * 联系人手机
     */
    private String contactMobile;

    /**
     * 联系人电子邮箱
     */
    private String contactEmail;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 地址
     */
    private String address;

    /**
     * 单位LOGO
     */
    private String unitLogo;

    /**
     * 单位二维码
     */
    private String unitQrcode;

    /**
     * 背景音乐
     */
    private String bgdSound;

    /**
     * 单位简介
     */
    private String description;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }

    }

}
