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
package net.linlan.frame.admin.entity;

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;

/**
 *
 * AdminDeptPosition数据域:用户角色关联实体类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminDeptPosition {

    /**
     * 用户角色ID
     */
    private Long    id;

    /**
     * 单位ID
     */
    private Long    deptId;

    /**
     * 岗位ID
     */
    private String  positionId;

    /**
     * 是否默认部门0否1是
     */
    private Boolean isDef;

    /**
     * 是否删除1已删除0正常
     */
    private Integer delFlag;

    /**
     * 创建时间
     */
    private Date    createTime;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }

    }

}
