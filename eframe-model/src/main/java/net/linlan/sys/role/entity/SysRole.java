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

import java.util.Collection;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.base.constant.AppStatusEnum;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * SysRole数据域:系统角色实体类
 * @author Linlan
 * CreateTime 2017-10-17 14:21:37
 *
 */
@Data
public class SysRole extends BaseEntity {

    /**
    * 角色ID
    */
    private Long    id;

    /**
    * 角色分类ID
    */
    private String  roletypeId;

    /**
    * 应用ID
    */
    private String  appId;

    /**
    * 角色自定义名称
    */
    private String  name;

    /**
    * 角色自定义代码
    */
    private String  code;

    /**
    * 重点优先级
    */
    private Integer priority;

    /**
    * 是否固定权限1表示固定角色0表示自定义角色
    */
    private Boolean isRegular;

    /**
    * 拥有所有权限
    */
    private Boolean isSuper;

    /**
    * 是否公共角色
    */
    private Boolean isPublic;

    /**
    * 状态0未生效1正常2受限3锁定4删除
    */
    private Integer status;

    /**
    * 角色描述
    */
    private String  description;

    /**
     * 地域类型
     */
    private String  areaType;

    /** get the ids of input collection
     * @param roles the input
     * @return the ids
     */
    public static Long[] fetchIds(Collection<SysRole> roles) {
        if (roles == null) {
            return null;
        }
        Long[] ids = new Long[roles.size()];
        int i = 0;
        for (SysRole c : roles) {
            ids[i++] = c.getId();
        }
        return ids;
    }

    /**
     * 初始化方法
     */
    public void init() {
        /**
        * 添加对数据库或实体对象的默认值处理
        */
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }
        if (getIsRegular() == null) {
            setIsRegular(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsSuper() == null) {
            setIsSuper(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsPublic() == null) {
            setIsPublic(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
        if (getStatus() == null) {
            setStatus(AppStatusEnum.NORMAL.getKey());
        }
        if (getCode() == null) {
            setCode(RandomUtils.randomCode());
        }

    }

}
