/*
 * module-authn - 动态认证对接模块
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
package net.linlan.authn.group.entity;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * PublicGroup数据域:会员用户组实体类
 * @author Linlan
 * CreateTime 2019-07-20 18:19:16 *
 */
@Data
public class PublicGroup extends BaseEntity {

    /**
    * 组编号
    */
    private Long    id;

    /**
    * 角色ID
    */
    private Long    roleId;

    /**
    * 会员类型ID
    */
    private Long    mgroupId;

    /**
    * 名称
    */
    private String  name;

    /**
    * 代码
    */
    private String  code;

    /**
    * 图标样式
    */
    private String  iconStyle;

    /**
    * 会员组图标
    */
    private String  imagePath;

    /**
    * 当前组的默认布局
    */
    private String  tplSolution;

    /**
    * 是否通用组0否1是，表示市民组，不需要进行权限控制
    */
    private Boolean isCommonGroup;

    /**
    * 是否领导组0否1是，工作组的一种情况
    */
    private Boolean isLeaderGroup;

    /**
    * 领导组级别
    */
    private String  leaderLevel;

    /**
    * 是否工作组0否1是，工作组的其他缺省情况
    */
    private Boolean isWorkGroup;

    /**
    * 是否网格组0否1是，工作组的一种
    */
    private Boolean isGridGroup;

    /**
    * 是否党员组0否1是，运营运维组
    */
    private Boolean isPartyGroup;

    /**
    * 是否村民组0否1是，租户机构用户组
    */
    private Boolean isVillageGroup;

    /**
    * 是否禁用0否1是
    */
    private Boolean isDisabled;

    /**
    * 重点优先级
    */
    private Integer priority;

    /**
    * 描述
    */
    private String  description;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }
        if (getIsCommonGroup() == null) {
            setIsCommonGroup(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsLeaderGroup() == null) {
            setIsLeaderGroup(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsGridGroup() == null) {
            setIsGridGroup(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsPartyGroup() == null) {
            setIsPartyGroup(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsWorkGroup() == null) {
            setIsWorkGroup(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsVillageGroup() == null) {
            setIsVillageGroup(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsDisabled() == null) {
            setIsDisabled(KernelConstant.DEFAULT_DISABLED);
        }
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
    }

}
