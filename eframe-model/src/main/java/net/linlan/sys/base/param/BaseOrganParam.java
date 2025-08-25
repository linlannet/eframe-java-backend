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
 * BaseOrgan数据域:单位信息表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 13:37:57
 *
 */
@Data
public class BaseOrganParam extends BaseParam {

    /**
    * 单位所在地行政区划ID，区县级
    */
    private Long     xzqhId;
    /**
     * 机构类型
     */
    private String   orgtypeId;
    /**
    * 名称
    */
    private String   name;
    /**
    * 创建来源类型0后台，1前台
    */
    private Integer  source;
    /**
    * 统一信用代码
    */
    private String   unionCode;
    /**
    * 组织机构代码，地域类机构的地域ID
    */
    private String   organCode;
    /**
     * 组织机构名称
     */
    private String   organName;
    /**
    * 创建方式0导入1录入2授权，1为唯一标记，2可能为重复的数据
    */
    private Integer  createType;
    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer  delFlag;
    /**
    * 描述
    */
    private String   description;
    /**
    * 备用1，地域类机构的地域CODE，本地编码
    */
    private String   spare1;
    /**
    * 备用2，地域类机构外部ID
    */
    private String   spare2;
    /**
     * 关键字
     */
    private String   key;
    /**
     * id集合
     */
    private String[] ids;
    /**
     * 是否工作机构
     */
    private String   isOrganWork;

}
