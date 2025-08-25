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
package net.linlan.sys.core.param;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * SysOrgan数据域:系统机构表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 13:45:50
 *
 */
@Data
public class CoreOrganParam extends BaseParam {
    /**
     * ID
     */
    private String  id;
    /**
     * 机构名称
     */
    private String  name;
    /**
    * 机构分类ID
    */
    private Long    orgtypeId;
    /**
    * 机构编码,其他编码,自定义编码
    */
    private String  organOcode;
    /**
    * 单位分组
    */
    private String  organGroup;
    /**
    * 单位级别
    */
    private String  organLevel;
    /**
    * 单位批准文号
    */
    private String  approvalNumber;
    /**
    * 机构类型，GENERAL通用OPEN开放平台PAY支付企业LOGG物流企业
    */
    private String  organType;
    /**
    * 机构性质
    */
    private String  organProperty;
    /**
    * 是否管理0否1是，是则ADMIN_DEPT内存在信息
    */
    private Boolean isAdmin;
    /**
    * 是否前台0否1是
    */
    private Boolean isMember;
    /**
    * 是否禁用0否1是
    */
    private Boolean isDisabled;
    /**
    * 是否非四套班子虚拟节点1是0不是默认0
    */
    private Boolean isVirtual;
    /**
    * 是否公开1是0不是默认0
    */
    private Boolean isPub;
    /**
    * 是否网格机构0否1是
    */
    private Boolean isGridOrgan;
    /**
    * 是否行政村机构0否1是
    */
    private Boolean isVillageOrgan;
    /**
    * 是否党支部机构0否1是
    */
    private Boolean isPartyOrgan;
    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer delFlag;
    /**
     * 关键字
     */
    private String  key;
    /**
     * bindType
     */
    private String  bindType;
    /**
     * bindOrganId
     */
    private String  bindOrganId;

}
