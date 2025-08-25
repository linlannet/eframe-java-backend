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
package net.linlan.sys.role.dto;

import java.util.Date;

import lombok.Data;

/**
 *
 * SysMenu数据域:系统菜单查询结果ListDto对象
 * @author Linlan
 * CreateTime 2019-06-27 14:19:06
 *
 */
@Data
public class SysMenuListDto {

    /**
     * 菜单ID
     */
    private String  id;
    /**
     * 菜单图标
     */
    private String  icon;
    /**
     * 菜单名称
     */
    private String  name;
    /**
     * 菜单类型
     */
    private String  type;
    /**
     * 图片路径
     */
    private String  imagePath;
    /**
     * 状态(是否显示)
     */
    private Boolean isDisplay;
    /**
     * 创建时间
     */
    private Date    createTime;
    /**
     * 排序码
     */
    private Integer priority;
    /**
     * 调用入口类型，如CATAGORY,MENU,BUTTON,OUTLINK,CHANNEL,COMPOS,SCENES,RECOMMEND,FOLLOW
     */
    private String  urlType;

}
