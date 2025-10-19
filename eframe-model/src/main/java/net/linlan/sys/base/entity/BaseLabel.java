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

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.base.constant.AppStatusEnum;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * BaseLabel数据域:全局标签字词实体类
 * @author Linlan
 * CreateTime 2024-03-21 17:54:39
 *
 */
@Data
public class BaseLabel extends BaseEntity {

    /**
     * 标签ID
     */
    private String  id;

    /**
     * 标签名称
     */
    private String  name;

    /**
     * 标签属性，归类说明，搜索词标记，可以为标签分类中的关键类型，标签可扩展表、字段应用，如行政区划标签可关联行政区划表
     */
    private String  attr;

    /**
     * 被引用的次数
     */
    private Integer refCount;

    /**
     * 标签访问次数
     */
    private Integer accessCount;

    /**
     * 标签状态
     */
    private Integer status;

    /**
     * 标签描述
     */
    private String  description;
    /**
     * 标签描述
     */
    private String  foreignId;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }
        if (getStatus() == null) {
            setStatus(AppStatusEnum.NORMAL.getKey());
        }
        if (getRefCount() == null) {
            setRefCount(KernelConstant.DEFAULT_COUNT);
        }
        if (getAccessCount() == null) {
            setAccessCount(KernelConstant.DEFAULT_COUNT);
        }

    }

}
