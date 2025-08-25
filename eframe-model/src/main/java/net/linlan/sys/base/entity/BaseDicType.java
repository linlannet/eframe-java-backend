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
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * BaseDicType数据域:字典类型实体类
 * @author Linlan
 * CreateTime 2023-08-08 13:41:37
 *
 */
@Data
public class BaseDicType extends BaseEntity {

    /**
     * 字典类型代码
     */
    private String  id;

    /**
     * 字典类型名称
     */
    private String  name;

    /**
     * 字典类型分类
     */
    private String  typeClass;

    /**
     * 字典引用名称
     */
    private String  typeRef;

    /**
     * 字典类型模式0平面1树形
     */
    private Integer typeMode;

    /**
     * 快速码
     */
    private String  searchCode;

    /**
     * 排序码
     */
    private Integer priority;

    /**
     * 字典类型修改状态
     */
    private Integer status;

    /**
     * 删除标记0正常1已删除2应用内受限3回收站
     */
    private Integer delFlag;

    /**
     * 删除时间
     */
    private Date    deleteTime;

    /**
     * 字典类型说明
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

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }

        setTypeMode(KernelConstant.DEFAULT_INT);
        if (getDelFlag() == null) {
            setDelFlag(KernelConstant.DEL_FLAG_DEFAULT);
        }
        setStatus(KernelConstant.DEFAULT_INT);
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
    }

}
