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
package net.linlan.sys.comm.entity;

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * CommIndustry数据域:国民经济行业表实体类
 * @author Linlan
 * CreateTime 2018-03-02 17:23:31
 *
 */
@Data
public class CommIndustry extends BaseEntity {

    /**
    * 国民经济行业编号
    */
    private Long    id;

    /**
    * 国民经济行业父节点
    */
    private Long    parentId;

    /**
    * 系统管理用户ID
    */
    private String  userId;

    /**
    * 树左边
    */
    private Integer lft;

    /**
    * 树右边
    */
    private Integer rgt;

    /**
    * 国民经济行业代码
    */
    private String  code;

    /**
    * 国民经济行业名称
    */
    private String  name;

    /**
    * 国民经济行业名称英文
    */
    private String  ename;

    /**
    * 快速码
    */
    private String  searchCode;

    /**
    * 是否显示0否1是
    */
    private Boolean isDisplay;

    /**
    * 显示标记，用|分隔，第1位全部第2位重点第3位特殊分类；如1|1|0
    */
    private String  dispFlag;

    /**
    * 排序码
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
     * 初始化方法
     */
    public void init() {
        /**
        * 添加对数据库或实体对象的默认值处理
        */
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }

        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
        if (getDelFlag() == null) {
            setDelFlag(KernelConstant.DEL_FLAG_DEFAULT);
        }
    }

}
