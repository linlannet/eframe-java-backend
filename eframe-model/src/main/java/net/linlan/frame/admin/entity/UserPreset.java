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

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * SasPowerPreset数据域:权限预置信息实体类
 * @author Linlan
 * CreateTime 2023-08-29 13:55:02
 *
 */
@Data
public class UserPreset extends BaseEntity {

    /**
    * 预置信息ID
    */
    private Long    id;

    /**
    * 所属应用ID
    */
    private String  appId;

    /**
    * 来源，RGYZ人工预置，PLTJ批量添加
    */
    private String  saveSource;

    /**
    * 服务处所，单位名称
    */
    private String  unitName;

    /**
    * 姓名
    */
    private String  name;

    /**
    * 身份证号
    */
    private String  idNum;

    /**
    * 人员职务
    */
    private String  duty;

    /**
    * 办公电话
    */
    private String  telephone;

    /**
    * 手机号码
    */
    private String  mobile;

    /**
    * 备用信息1，可保存岗位名称
    */
    private String  extInfo1;

    /**
    * 备用信息2，可保存所属网格等信息
    */
    private String  extInfo2;

    /**
    * 备用信息3
    */
    private String  extInfo3;

    /**
    * 是否同步初始化人员，0否1是，是则人员会加入BASE_USER
    */
    private Boolean needInitUser;

    /**
    * 机构用户人员ID，关联BASE_USER，初始化之后更新
    */
    private String  userId;

    /**
    * 是否同步初始化机构，0否1是，是则人员会加入BASE_ORGAN
    */
    private Boolean needInitOrgan;

    /**
    * 机构ID，关联BASE_ORGAN，初始化之后更新
    */
    private String  organId;

    /**
    * 类型，RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345
    */
    private String  type;

    /**
    * 外部URL，如SJKB的URL，人才预约的URL
    */
    private String  foreignUrl;

    /**
    * 业务类型，1具体单位2具体地域3具体权限组4综合权限9多个同类信息，12单位和地域，13单位和权限组，19多个单位，23地域和权限组，29多个地域，39多个权限
    */
    private Integer bizType;

    /**
    * 业务机构ID，人员绑定机构，绑定的ORGAN_ID
    */
    private String  bizOrganId;

    /**
    * 业务权限ID，当前查询范围
    */
    private Long    bizAreaId;

    /**
    * 业务会员组ID
    */
    private Long    bizGroupId;

    /**
    * 业务综合权限，备用字段
    */
    private String  bizPower;

    /**
    * 多个信息时，Ids,隔开
    */
    private String  bizMultiInfo;

    /**
    * 是否需要绑定企业，0否1是，是则人员会配置IDENTITY的ORGAN_ID信息
    */
    private Boolean needSetOrgan;

    /**
    * 是否需要绑定地域，0否1是，是则人员会配置IDENTITY的POWER_AREA_ID信息
    */
    private Boolean needSetArea;

    /**
    * 是否需要绑定会员组，0否1是，是则人员会配置会员组，并设置IDENTITY内的GROUP_ID
    */
    private Boolean needSetGroup;

    /**
    * 是否需要绑定综合权限，0否1是，是则人员会配置IDENTITY的其他综合权限等信息
    */
    private Boolean needSetPower;

    /**
    * 操作人ID
    */
    private String  opUserId;

    /**
    * 操作单位ID
    */
    private String  opOrganId;

    /**
    * 操作时间
    */
    private Date    opTime;

    /**
    * 操作说明
    */
    private String  opInfo;

    /**
    * 排序码
    */
    private Integer priority;

    /**
    * 状态0未初始化1初始化配置成功2初始化配置不成功
    */
    private Integer status;

    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer delFlag;

    /**
    * 数据批次号
    */
    private String  dataBatch;

    /**
    * 数据版本，流水号，向上增加
    */
    private Integer dataVersion;

    /**
    * 数据更新时间
    */
    private Date    updateTime;

    /**
    * 同步类型，I插入，U更新，D删除，DM人工删除，UM人工更新
    */
    private String  syncMode;

    /**
    * 同步更新时间
    */
    private Date    syncTime;

    /**
    * 描述
    */
    private String  description;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (ObjectUtils.isEmpty(this.id)) {
            this.id = RandomUtils.randomLid();
        }

    }

}
