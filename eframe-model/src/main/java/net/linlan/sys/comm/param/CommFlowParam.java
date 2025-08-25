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
package net.linlan.sys.comm.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * CommFlow数据域:应用报备通用审批流程查询参数实体类
 * @author Linlan
 * CreateTime 2022-05-23 11:54:16
 *
 */
@Data
public class CommFlowParam extends BaseParam {

    /**
     * 外键类型，GWS_YIQ_NORMAL_REPORT通用报备类型，
     */
    private String  foreignType;
    /**
     * 外键ID，GWS_YIQ_NORMAL_REPORT的REPORT_ID
     */
    private String  foreignId;
    /**
     * 对象人员ID，关联USER、关联THEME_PEOPLE、关联MATERIAL_PEOPLE_BASE
     */
    private String  objUserId;
    /**
     * 对象机构ID，关联ORGAN、关联THEME_ORGAN、关联MATERIAL_ORGAN_BASE
     */
    private String  objOrganId;
    /**
     * 对象关联ID，备用字段
     */
    private String  objConnId;
    /**
     * 操作类型 D（派发）、R（复核）、C（催办）、E（退回）
     */
    private String  flowType;
    /**
     * 流程单产生标示，0自动派单，1人工派单
     */
    private Integer assignFlag;
    /**
     * 任务单状态，关联字典
     */
    private String  currStatus;
    /**
     * 当前环节节点名称
     */
    private String  currName;
    /**
     * 流程单发出时间
     */
    private Date    opTime;
    /**
     * 流程单操作人ID
     */
    private String  opUserId;
    /**
     * 流程单操作人名称
     */
    private String  opUserName;
    /**
     * 流程单发出部门ID
     */
    private String  opOrganId;
    /**
     * 流程单发出部门名称
     */
    private String  opOrganName;
    /**
     * 流程单内容
     */
    private String  opInfo;
    /**
     * 流程单备用
     */
    private String  opBak1;
    /**
     * 后续操作状态
     */
    private String  nextStatus;
    /**
     * 后续环节节点名称
     */
    private String  nextName;
    /**
     * 后续环节单位ID
     */
    private String  nextOrganId;
    /**
     * 后续环节部门名称
     */
    private String  nextOrganName;
    /**
     * 后续环节人ID
     */
    private String  nextUserId;
    /**
     * 后续环节人名称
     */
    private String  nextUserName;
    /**
     * 是否签收0否1是
     */
    private Boolean isSign;
    /**
     * 签收时间
     */
    private Date    signTime;
    /**
     * 反馈时限
     */
    private Integer receiveDeadline;
    /**
     * 反馈时间
     */
    private Date    receiveTime;
    /**
     * 反馈处置意见
     */
    private String  receiveContent;
    /**
     * 反馈结果0不通过10通过
     */
    private Integer receiveResult;
    /**
     * 反馈处置备用
     */
    private String  receiveBak1;
    /**
     * 单个流程环节是否超期0否1是
     */
    private Boolean isOvertime;
    /**
     * 到期时间
     */
    private Date    overTime;
    /**
     * 描述
     */
    private String  description;

}
