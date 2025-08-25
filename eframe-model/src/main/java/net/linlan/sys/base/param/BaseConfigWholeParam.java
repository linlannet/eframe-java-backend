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
package net.linlan.sys.base.param;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * BaseConfigWhole数据域:通用配置表合项查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-08 13:41:38
 *
 */
@Data
public class BaseConfigWholeParam extends BaseParam {
    /**
     * id
     */
    private String  id;
    /**
     * 配置编号
     */
    private String  cfgId;
    /**
    * 配置项名称，站点ID，地域ID
    */
    private String  cfgKey;
    /**
     * 配置项值，JSON格式，包括缺省图片，定时任务，TRUE/FALSE，0/1
     */
    private String  cfgValue;
    /**
     * 分类标记，名称
     */
    private String  cfgCatagory;
    /**
    * 是否禁用0否1是
    */
    private Boolean isDisabled;
    /**
    * 描述
    */
    private String  description;

}
