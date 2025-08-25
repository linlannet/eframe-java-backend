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
import java.util.Set;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.annotation.Excel.ColumnType;
import net.linlan.sys.role.dto.SysRoleDto;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.utils.entity.BaseEntity;

/**
 * 角色表 ADMIN_ROLE
 * 
 * @author Linlan
 */
@Data
public class SysRoleVo extends BaseEntity {

    /** 角色ID */
    @Excel(name = "角色序号", cellType = ColumnType.NUMERIC)
    private Long        roleId;

    /** 角色名称 */
    @Excel(name = "角色名称")
    private String      roleName;

    /** 角色权限 */
    @Excel(name = "角色权限")
    private String      roleKey;

    /** 角色排序 */
    @Excel(name = "角色排序")
    private Integer     roleSort;

    /** 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示） */
    private Boolean     menuCheckStrictly;

    /** 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ） */
    private Boolean     deptCheckStrictly;

    /** 角色状态（0未生效 1正常） */
    @Excel(name = "角色状态", readConverterExp = "0=未生效,1=正常")
    private Integer     status;

    /** 用户是否存在此角色标识 默认不存在 */
    private boolean     flag = false;

    /** 菜单组 */
    private Long[]      menuIds;

    /** 部门组（数据权限） */
    private Long[]      deptIds;

    /** 角色菜单权限 */
    private Set<String> permissions;

    /**
     * 备注
     */
    private String      remark;
    /**
     * 父角色名字
     */
    private String      parentName;
    /**
     *  全局应用信息类
     */
    private String      appName;
    /**
     * 系统角色分类
     */
    private String      roletypeId;
    /**
     * 系统角色分类
     */
    private String      roletypeName;
    /**
     * 创建时间
     */
    private Date        createTime;
    /**
     * 排序码
     */
    private Integer     priority;
    /**
     * 是否拥有所有权限
     */
    private Boolean     isSuper;

    public SysRoleVo() {
    }

    public boolean isAdmin() {
        return isAdmin(this.roleId);
    }

    public static boolean isAdmin(Long roleId) {
        return roleId != null && 1L == roleId;
    }

    /**
     * 数据赋值TO方法，将SysRole的input对象赋值给SysPositionVo
     */
    public static final Function TO = new Function<SysRole, SysRoleVo>() {
        @Nullable
        @Override
        public SysRoleVo apply(@Nullable SysRole input) {
            return new SysRoleVo(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public SysRoleVo(SysRole input) {
        this.roleId = input.getId();
        this.roleName = input.getName();
        this.roleKey = input.getCode();
        this.roleSort = input.getPriority();
        this.menuCheckStrictly = input.getIsRegular();
        this.deptCheckStrictly = input.getIsPublic();
        this.status = input.getStatus();
        this.remark = input.getDescription();
        this.roletypeId = input.getRoletypeId();
        this.priority = input.getPriority();
        this.createTime = input.getCreateTime();
        this.isSuper = input.getIsSuper();
    }

    /**
     * 数据赋值DTO方法，将SysRoleDto的input对象赋值给SysPositionVo
     */
    public static final Function DTO = new Function<SysRoleDto, SysRoleVo>() {
        @Nullable
        @Override
        public SysRoleVo apply(@Nullable SysRoleDto input) {
            return new SysRoleVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public SysRoleVo(SysRoleDto input) {
        this.roleId = input.getId();
        this.roleName = input.getName();
        this.roleKey = input.getCode();
        this.roleSort = input.getPriority();
        this.menuCheckStrictly = input.getIsRegular();
        this.deptCheckStrictly = input.getIsPublic();
        this.status = input.getStatus();
        this.remark = input.getDescription();
        this.parentName = input.getParentName();
        this.appName = input.getAppName();
        this.roletypeName = input.getRoletypeName();
        this.priority = input.getPriority();
        this.createTime = input.getCreateTime();
        this.isSuper = input.getIsSuper();
    }

}
