/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.admin.vo;

import java.util.Date;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.frame.admin.dto.AdminDeptPositionDto;
import net.linlan.frame.admin.entity.AdminDeptPosition;

/**
 *
 * AdminDeptPosition视图域:用户角色关联显示Vo类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminDeptPositionVo {
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
     * 无参构造方法
     */
    public AdminDeptPositionVo() {
    }

    /**
     * 数据赋值TO方法，将AdminDeptPosition的input对象赋值给AdminDeptPositionVo
     */
    public static final Function TO = new Function<AdminDeptPosition, AdminDeptPositionVo>() {
        @Nullable
        @Override
        public AdminDeptPositionVo apply(@Nullable AdminDeptPosition input) {
            return new AdminDeptPositionVo(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminDeptPositionVo(AdminDeptPosition input) {
        this.id = input.getId();
        this.deptId = input.getDeptId();
        this.positionId = input.getPositionId();
        this.isDef = input.getIsDef();
        this.delFlag = input.getDelFlag();
        this.createTime = input.getCreateTime();
    }

    /**
     * 数据赋值DTO方法，将AdminDeptPositionDto的input对象赋值给AdminDeptPositionVo
     */
    public static final Function DTO = new Function<AdminDeptPositionDto, AdminDeptPositionVo>() {
        @Nullable
        @Override
        public AdminDeptPositionVo apply(@Nullable AdminDeptPositionDto input) {
            return new AdminDeptPositionVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminDeptPositionVo(AdminDeptPositionDto input) {
        this.id = input.getId();
        this.deptId = input.getDeptId();
        this.positionId = input.getPositionId();
        this.isDef = input.getIsDef();
        this.delFlag = input.getDelFlag();
        this.createTime = input.getCreateTime();
    }

}
