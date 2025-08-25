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
package net.linlan.sys.core.entity;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * CoreDepttype数据域:部门业务分类表实体类
 * @author Linlan
 * CreateTime 2018-05-09 10:09:40
 *
 */
@Data
public class CoreDepttype extends BaseEntity {

    /**
    * 部门分类ID
    */
    private Long    id;

    /**
    * 父部门分类ID
    */
    private Long    parentId;

    /**
    * 机构分类ID
    */
    private Long    orgtypeId;

    /**
    * 地域ID
    */
    private String  areatypeId;

    /**
    * 部门分类名称
    */
    private String  name;

    /**
    * 部门分类简称,英文
    */
    private String  sname;

    /**
    * 行政区划代码
    */
    private String  code;

    /**
    * 树左边
    */
    private Integer lft;

    /**
    * 树右边
    */
    private Integer rgt;

    /**
    * 快速码
    */
    private String  searchCode;

    /**
    * 显示标记，用|分隔，第1位全部第2位重点第3位特殊分类；如1|1|0
    */
    private String  dispFlag;

    /**
    * 是否禁用0否1是
    */
    private Boolean isDisabled;

    /**
    * 排序
    */
    private Integer priority;

    /**
    * 描述
    */
    private String  description;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }

        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
        if (getIsDisabled() == null) {
            setIsDisabled(KernelConstant.DEFAULT_DISABLED);
        }
    }

}
