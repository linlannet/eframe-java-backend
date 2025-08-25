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

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * SysPosition数据域:岗位信息实体类
 * @author Linlan
 * CreateTime 2019-11-25 12:13:00
 *
 */
@Data
public class SysPosition extends BaseEntity {

    /**
     * 岗位ID
     */
    private String  id;

    /**
     * 父岗位ID
     */
    private String  parentId;

    /**
     * 岗位分类ID
     */
    private String  postypeId;

    /**
     * 角色分类ID
     */
    private String  roletypeId;

    /**
     * 系统管理用户ID
     */
    private String  userId;

    /**
     * 岗位名称
     */
    private String  name;

    /**
     * 岗位简称，别名
     */
    private String  sname;

    /**
     * UAS岗位id
     */
    private String  code;

    /**
     * 岗位别名
     */
    private String  oname;

    /**
     * 工作分工，二维码申请页面模板
     */
    private String  posFunction;

    /**
     * 级别
     */
    private Integer posRank;

    /**
     * 岗位类型
     */
    private String  posType;

    /**
     * 编制类型
     */
    private String  editorType;

    /**
     * 是否编委创建
     */
    private Boolean isEditorCreate;

    /**
     * 岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定
     */
    private Integer status;

    /**
     * 是否公开0否1是
     */
    private Boolean isPub;

    /**
     * 是否代理岗位0否1是
     */
    private Boolean isAgent;

    /**
     * 是否为部门领导0否1是
     */
    private Boolean isLeader;

    /**
     * 部门领导用户ID
     */
    private String  leaderId;

    /**
     * 分管内设机构
     */
    private String  manageDeptids;

    /**
     * 是否大通讯录
     */
    private Boolean isBigContact;

    /**
     * 是否小通讯录
     */
    private Boolean isSmallContact;

    /**
     * 岗位移动手机
     */
    private String  mobilePhone;

    /**
     * 岗位办公电话
     */
    private String  officePhone;

    /**
     * 建筑楼栋号
     */
    private String  buildingId;

    /**
     * 房间号
     */
    private String  roomNo;

    /**
     * 微信签名类型
     */
    private String  extQmType;

    /**
     * 微信签名类型图片
     */
    private String  extQmTypePhoto;

    /**
     * 微信岗位
     */
    private String  extPosName;

    /**
     * 微信单位
     */
    private String  extOrganName;

    /**
     * 排序
     */
    private Integer priority;

    /**
     * 机构内排序
     */
    private Integer priorityInOrgan;

    /**
     * 应用域内排序
     */
    private Integer priorityInDomain;

    /**
     * 修改人
     */
    private String  updaterId;

    /**
     * 修改时间
     */
    private Date    updateTime;

    /**
     * 删除标志0正常1已删除2应用内受限3回收站
     */
    private Integer delFlag;

    /**
     * 描述，岗位职责
     */
    private String  description;

    /**
     * 备注
     */
    private String  remark;

    /**
     * 初始化方法
     */
    public void init() {
        /**
         * 添加对数据库或实体对象的默认值处理
         */
        if (getId() == null) {
            setId(RandomUtils.UUID());
        }
        if (getStatus() == null) {
            setStatus(KernelConstant.DEFAULT_STATUS);
        }
        if (getDelFlag() == null) {
            setDelFlag(KernelConstant.DEL_FLAG_DEFAULT);
        }
    }

}
