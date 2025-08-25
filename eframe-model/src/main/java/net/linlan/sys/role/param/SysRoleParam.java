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
package net.linlan.sys.role.param;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * SysRole数据域:系统角色查询参数实体类
 * @author Linlan
 * CreateTime 2018-08-12 14:19:06
 *
 */
@Data
public class SysRoleParam extends BaseParam {

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
    * 状态0未生效1正常2受限3锁定
    */
    private Integer status;
    /**
    * 角色描述
    */
    private String  description;
    /**
     * 角色ids
     */
    private Long[]  ids;

}
