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
package net.linlan.sys.core.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.base.entity.BaseOrgan;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * SysOrgan数据域:系统机构表实体类
 * @author Linlan
 * CreateTime 2018-03-02 17:19:48
 *
 */
@Data
public class CoreOrgan extends BaseEntity {

    /**
    * 机构ID
    */
    private String    id;

    /**
    * 机构分类ID
    */
    private Long      orgtypeId;

    /**
    * 机构编码,其他编码,自定义编码
    */
    private String    organOcode;

    /**
    * 单位分组
    */
    private String    organGroup;

    /**
    * 单位级别
    */
    private String    organLevel;

    /**
    * 单位批准文号
    */
    private String    approvalNumber;

    /**
    * 是否是派驻单位
    */
    private Boolean   isStationOrg;

    /**
    * 机构类型，GENERAL通用OPEN开放平台PAY支付企业LOGG物流企业
    */
    private String    organType;

    /**
    * 机构性质
    */
    private String    organProperty;

    /**
    * 维护管理用户ID
    */
    private String    updatorId;

    /**
    * 修改时间
    */
    private Date      updateTime;

    /**
    * 是否管理0否1是，是则ADMIN_DEPT内存在信息
    */
    private Boolean   isAdmin;

    /**
    * 是否前台0否1是
    */
    private Boolean   isMember;

    /**
    * 是否禁用0否1是
    */
    private Boolean   isDisabled;

    /**
    * 是否非四套班子虚拟节点1是0不是默认0
    */
    private Boolean   isVirtual;

    /**
    * 是否公开1是0不是默认0
    */
    private Boolean   isPub;

    /**
    * 是否网格机构0否1是
    */
    private Boolean   isGridOrgan;

    /**
    * 是否行政村机构0否1是
    */
    private Boolean   isVillageOrgan;

    /**
    * 是否党支部机构0否1是
    */
    private Boolean   isPartyOrgan;

    /**
    * 重点优先级
    */
    private Integer   priority;

    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer   delFlag;

    /**
     * 全局单位信息类
     */
    private BaseOrgan baseOrgan;

    /**
     * 机构分类名称
     */
    private String    orgtypeName;
    /**
     * 单位级别名称
     */
    private String    organLevelName;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }
        if (getIsDisabled() == null) {
            setIsDisabled(false);
        }
        if (getDelFlag() == null) {
            setDelFlag(DelFlagEnum.NORMAL.getKey());
        }
        if (getCreateTime() == null) {
            setCreateTime(new Date());
        }
        if (getLastTime() == null) {
            setLastTime(new Timestamp(System.currentTimeMillis()));
        }
        if (getIsStationOrg() == null) {
            setIsStationOrg(KernelConstant.DEFAULT_DISABLED);
        }
        if (getIsVirtual() == null) {
            setIsVirtual(KernelConstant.DEFAULT_DISABLED);
        }
        if (getIsPub() == null) {
            setIsPub(KernelConstant.DEFAULT_DISABLED);
        }
        if (getIsMember() == null) {
            setIsMember(KernelConstant.DEFAULT_DISABLED);
        }
        if (getIsAdmin() == null) {
            setIsAdmin(KernelConstant.DEFAULT_DISABLED);
        }
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }

    }

}
