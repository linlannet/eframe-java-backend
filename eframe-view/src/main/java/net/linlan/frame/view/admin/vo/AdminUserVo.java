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
import java.util.List;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.annotation.Excel.ColumnType;
import net.linlan.annotation.Excel.Type;
import net.linlan.annotation.Excels;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.entity.AdminDept;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * AdminUser视图域:管理用户显示Vo类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminUserVo extends BaseEntity {
    private static final long     serialVersionUID = 1L;

    /** 用户LID */
    @Excel(name = "用户序号", type = Type.EXPORT, cellType = ColumnType.NUMERIC, prompt = "用户编号")
    private Long                  id;

    /** 用户UUID */
    private String                userId;

    /** 部门ID */
    @Excel(name = "部门编号", type = Type.IMPORT)
    private Long                  deptId;
    /** 部门名称 */
    private String                deptName;

    /** 机构ID */
    private String                organId;
    /** 机构名称 */
    private String                organName;

    /** 人员姓名 */
    @Excel(name = "人员姓名")
    private String                name;

    /** 用户账号 */
    @Excel(name = "登录名称")
    private String                username;

    /** 用户昵称 */
    @Excel(name = "用户名称")
    private String                nickName;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String                email;

    /** 手机号码 */
    @Excel(name = "手机号码", cellType = ColumnType.TEXT)
    private String                mobile;

    /** 用户头像 */
    private String                imagePath;

    /** 密码 */
    private String                password;

    /**
     * 是否超级管理员
     */
    private Boolean               isSuperAdmin;

    /**
     * 是否审计只读管理员
     */
    private Boolean               isAuditAdmin;

    /**
     * 是否只管理自己的数据
     */
    private Boolean               isSelfAdmin;

    /** 帐号状态（0未生效 1正常） */
    @Excel(name = "帐号状态", readConverterExp = "0=未生效,1=正常")
    private Integer               status;

    /** 删除标志（0代表存在 2代表删除） */
    private Integer               delFlag;

    /** 最后登录IP */
    @Excel(name = "最后登录IP", type = Type.EXPORT)
    private String                lastLoginIp;

    /** 最后登录时间 */
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date                  lastLoginTime;
    /**
     * 备注,办公地址
     */
    private String                description;

    /** 部门对象 */
    @Excels({ @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
              @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT) })
    private AdminDept             dept;

    /** 角色对象 */
    private List<SysRole>         roles;

    /** 角色组 */
    private Long[]                roleIds;

    /** 岗位组 */
    private String[]              positionIds;

    /** 角色ID */
    private Long                  roleId;
    /** 角色集合 */
    private List<AdminUserRoleVo> userRoleList;
    /** 创建时间 */
    private Date                  createTime;

    /**
     * 验证码
     */
    private String                code;
    /**
     * uuid标识
     */
    private String                uuid;

    public AdminUserVo() {
    }

    public AdminUserVo(Long id) {
        this.id = id;
        this.isSuperAdmin = false;
    }

    public boolean isAdmin() {
        return isAdmin(this.id) || isSuperAdmin;
    }

    public static boolean isAdmin(Long adminId) {
        return adminId != null && 1L == adminId;
    }

    /**
     * 数据赋值TO方法，将AdminUser的input对象赋值给AdminUserVo
     */
    public static final Function TO = new Function<AdminUser, AdminUserVo>() {
        @Nullable
        @Override
        public AdminUserVo apply(@Nullable AdminUser input) {
            return new AdminUserVo(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminUserVo(AdminUser input) {
        this.id = input.getId();
        this.userId = input.getUserId();
        this.organId = input.getOrganId();
        this.deptId = input.getDeptId();
        this.name = input.getName();
        this.nickName = input.getName();
        this.username = input.getUsername();
        this.mobile = input.getMobile();
        this.email = input.getEmail();
        this.password = input.getPassword();
        this.imagePath = input.getImagePath();
        this.isSuperAdmin = input.getIsSuperAdmin();
        this.isAuditAdmin = input.getIsAuditAdmin();
        this.isSelfAdmin = input.getIsSelfAdmin();
        this.lastLoginTime = input.getLastLoginTime();
        this.lastLoginIp = input.getLastLoginIp();
        this.status = input.getStatus();
        this.delFlag = input.getDelFlag();
        this.description = input.getSpare1();
        this.createTime = input.getCreateTime();
    }

    /**
     * 数据赋值DTO方法，将AdminUserDto的input对象赋值给AdminUserRuoyiDto
     */
    public static final Function DTO = new Function<AdminUserDto, AdminUserVo>() {
        @Nullable
        @Override
        public AdminUserVo apply(@Nullable AdminUserDto input) {
            return new AdminUserVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminUserVo(AdminUserDto input) {
        this.id = input.getId();
        this.userId = input.getUserId();
        this.organId = input.getOrganId();
        this.deptId = input.getDeptId();
        this.name = input.getName();
        this.nickName = input.getName();
        this.username = input.getUsername();
        this.mobile = input.getMobile();
        this.email = input.getEmail();
        this.password = input.getPassword();
        this.imagePath = input.getImagePath();
        this.isSuperAdmin = input.getIsSuperAdmin();
        this.isAuditAdmin = input.getIsAuditAdmin();
        this.isSelfAdmin = input.getIsSelfAdmin();
        this.lastLoginTime = input.getLastLoginTime();
        this.lastLoginIp = input.getLastLoginIp();
        this.status = input.getStatus();
        this.delFlag = input.getDelFlag();
        this.description = input.getSpare1();
        this.createTime = input.getCreateTime();
        this.deptName = input.getDeptName();
        this.organName = input.getOrganName();

    }

    public static AdminUser transTo(AdminUserVo input) {
        AdminUser result = new AdminUser();
        if (ObjectUtils.isNotEmpty(input.getId())) {
            result.setId(input.getId());
        }
        result.setDeptId(input.getDeptId());
        result.setName(input.getName());
        result.setUsername(input.getUsername());
        if (StringUtils.isBlank(input.getName())) {
            result.setName(input.getNickName());
        }
        result.setEmail(input.getEmail());
        result.setMobile(input.getMobile());
        result.setImagePath(input.getImagePath());
        result.setStatus(input.getStatus());
        result.setDelFlag(input.getDelFlag());
        result.setSpare1(input.getDescription());
        return result;
    }

}
