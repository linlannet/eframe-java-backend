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
 * CoreRoletype数据域:角色分类表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 13:45:49
 *
 */
@Data
public class CoreRoletypeParam extends BaseParam {

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
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer delFlag;
    /**
    * 角色描述
    */
    private String  description;
    /**
     * existKey
     */
    private String  existKey;

}
