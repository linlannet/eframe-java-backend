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

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * CoreRoletype数据域:角色分类表实体类
 * @author Linlan
 * CreateTime 2018-04-19 17:17:50
 *
 */
@Data
public class CoreRoletype extends BaseEntity {

    /**
    * 角色分类ID
    */
    private String  id;

    /**
    * 角色名称
    */
    private String  name;

    /**
    * 角色类型0全局角色1系统管理角色2应用会员角色
    */
    private String  type;

    /**
    * 角色编码，角色代码
    */
    private String  code;

    /**
    * 重点优先级
    */
    private Integer priority;

    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer delFlag;

    /**
    * 角色描述
    */
    private String  description;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }
        if (getCode() == null) {
            setCode(RandomUtils.randomCode());
        }
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
        if (getDelFlag() == null) {
            setDelFlag(KernelConstant.DEL_FLAG_DEFAULT);
        }
    }

}
