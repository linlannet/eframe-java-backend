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
package net.linlan.sys.role.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;

/**
 *
 * SysRole数据域:系统角色角色岗位关联实体类
 * @author Linlan
 * CreateTime 2019-11-29 11:03:17
 *
 */
@Data
public class SysRolePosition implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户角色ID
     */
    private Long              id;
    /**
     * 角色ID
     */
    private Long              roleId;
    /**
     * 岗位ID
     */
    private String            positionId;
    /**
     * 审核状态0未审核1审核通过2冻结3例外
     */
    private Integer           status;
    /**
     * 开始时间
     */
    private Date              beginTime;
    /**
     * 结束时间
     */
    private Date              endTime;

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
