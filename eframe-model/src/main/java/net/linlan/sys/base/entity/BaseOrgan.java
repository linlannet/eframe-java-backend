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
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * BaseOrgan数据域:基础单位实体类
 * @author Linlan
 * CreateTime 2018-03-02 13:41:37
 *
 */
@Data
public class BaseOrgan extends BaseEntity {

    /**
     * 单位编码
     */
    private String       id;

    /**
     * 单位所在地行政区划ID，区县级
     */
    private Long         xzqhId;

    /**
     * 名称
     */
    private String       name;

    /**
     * 创建来源类型0后台，1前台
     */
    private Integer      source;

    /**
     * 统一信用代码
     */
    private String       unionCode;

    /**
     * 组织机构代码，地域类机构的地域ID
     */
    private String       organCode;

    /**
     * 创建方式0导入1录入2授权，1为唯一标记，2可能为重复的数据
     */
    private Integer      createType;

    /**
     * 排序
     */
    private Integer      priority;

    /**
     * 删除标记0正常1已删除2应用内受限3回收站
     */
    private Integer      delFlag;

    /**
     * 删除时间
     */
    private Date         deleteTime;

    /**
     * 描述
     */
    private String       description;

    /**
     * 备用1，地域类机构的地域CODE，本地编码
     */
    private String       spare1;

    /**
     * 备用2，地域类机构外部ID
     */
    private String       spare2;

    /**
     * 全局用户扩展类
     */
    private BaseOrganExt baseOrganExt;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }

        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
        if (getDelFlag() == null) {
            setDelFlag(DelFlagEnum.NORMAL.getKey());
        }

    }

}
