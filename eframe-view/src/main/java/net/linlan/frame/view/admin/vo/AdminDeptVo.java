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

import net.linlan.frame.admin.dto.AdminDeptDto;
import net.linlan.frame.admin.entity.AdminDept;

/**
 *
 * AdminDept视图域:系统机构部门显示Vo类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminDeptVo {
    /**
     * 单位ID
     */
    private Long    id;
    /**
     * 系统机构ID
     */
    private String  organId;
    /**
     * 系统机构名称
     */
    private String  organName;
    /**
     * 父节点
     */
    private Long    parentId;
    /**
     * 应用ID
     */
    private String  appId;
    /**
     * 部门分类ID
     */
    private Long    depttypeId;
    /**
     * 外部业务ID
     */
    private String  foreignId;
    /**
     * 创建方式0导入1录入2授权
     */
    private Integer createType;
    /**
     * 部门类型，NEISHE内设机构，FENZI分子机构
     */
    private String  type;
    /**
     * 名称
     */
    private String  name;
    /**
     * 名称简称，本单位显示名称
     */
    private String  sname;
    /**
     * 地域编码，所在城市
     */
    private String  areaCode;
    /**
     * 领导名称
     */
    private String  organLeader;
    /**
     * 负责人ID，用户接收相关信息
     */
    private String  leaderId;
    /**
     * 负责人手机号码，用户接收相关信息
     */
    private String  leaderMobile;
    /**
     * 是否机构本级1是0否默认1
     */
    private Boolean isOrganLevel;
    /**
     * 是否虚拟节点1是0不是默认0
     */
    private Boolean isVirtual;
    /**
     * 是否叶子节点
     */
    private Boolean isLeaf;
    /**
     * 是否禁用0否1是
     */
    private Boolean isDisabled;
    /**
     * 多级累加路径
     */
    private String  searchCode;
    /**
     * 图片路径
     */
    private String  imagePath;
    /**
     * 排序
     */
    private Integer priority;
    /**
     * 状态0未生效1正常2受限3锁定
     */
    private Integer status;
    /**
     * 创建用户ID
     */
    private String  creatorId;
    /**
     * 创建时间
     */
    private Date    createTime;
    /**
     * 修改时间
     */
    private Date    lastTime;
    /**
     * 是否删除1已删除0正常
     */
    private Integer delFlag;
    /**
     * 描述
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
     * 父节点名称
     */
    private String  parentName;
    /**
     * 字节点数量
     */
    private String  childNum;

    /**
     * 无参构造方法
     */
    public AdminDeptVo() {
    }

    /**
     * 数据赋值TO方法，将AdminDept的input对象赋值给AdminDeptVo
     */
    public static final Function TO = new Function<AdminDept, AdminDeptVo>() {
        @Nullable
        @Override
        public AdminDeptVo apply(@Nullable AdminDept input) {
            return new AdminDeptVo(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminDeptVo(AdminDept input) {
        this.id = input.getId();
        this.organId = input.getOrganId();
        this.parentId = input.getParentId();
        this.appId = input.getAppId();
        this.depttypeId = input.getDepttypeId();
        this.foreignId = input.getForeignId();
        this.createType = input.getCreateType();
        this.type = input.getType();
        this.name = input.getName();
        this.sname = input.getSname();
        this.areaCode = input.getAreaCode();
        this.organLeader = input.getOrganLeader();
        this.leaderId = input.getLeaderId();
        this.leaderMobile = input.getLeaderMobile();
        this.isOrganLevel = input.getIsOrganLevel();
        this.isVirtual = input.getIsVirtual();
        this.isLeaf = input.getIsLeaf();
        this.isDisabled = input.getIsDisabled();
        this.searchCode = input.getSearchCode();
        this.imagePath = input.getImagePath();
        this.priority = input.getPriority();
        this.status = input.getStatus();
        this.creatorId = input.getCreatorId();
        this.createTime = input.getCreateTime();
        this.lastTime = input.getLastTime();
        this.delFlag = input.getDelFlag();
        this.description = input.getDescription();
        this.spare1 = input.getSpare1();
        this.spare2 = input.getSpare2();
    }

    /**
     * 数据赋值DTO方法，将AdminDeptDto的input对象赋值给AdminDeptVo
     */
    public static final Function DTO = new Function<AdminDeptDto, AdminDeptVo>() {
        @Nullable
        @Override
        public AdminDeptVo apply(@Nullable AdminDeptDto input) {
            return new AdminDeptVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminDeptVo(AdminDeptDto input) {
        this.id = input.getId();
        this.organId = input.getOrganId();
        this.organName = input.getOrganName();
        this.parentId = input.getParentId();
        this.appId = input.getAppId();
        this.depttypeId = input.getDepttypeId();
        this.foreignId = input.getForeignId();
        this.createType = input.getCreateType();
        this.type = input.getType();
        this.name = input.getName();
        this.sname = input.getSname();
        this.areaCode = input.getAreaCode();
        this.organLeader = input.getOrganLeader();
        this.leaderId = input.getLeaderId();
        this.leaderMobile = input.getLeaderMobile();
        this.isOrganLevel = input.getIsOrganLevel();
        this.isVirtual = input.getIsVirtual();
        this.isLeaf = input.getIsLeaf();
        this.isDisabled = input.getIsDisabled();
        this.searchCode = input.getSearchCode();
        this.imagePath = input.getImagePath();
        this.priority = input.getPriority();
        this.status = input.getStatus();
        this.creatorId = input.getCreatorId();
        this.createTime = input.getCreateTime();
        this.lastTime = input.getLastTime();
        this.delFlag = input.getDelFlag();
        this.description = input.getDescription();
        this.spare1 = input.getSpare1();
        this.spare2 = input.getSpare2();
        this.parentName = input.getParentName();
        this.childNum = input.getChildNum();
    }

}
