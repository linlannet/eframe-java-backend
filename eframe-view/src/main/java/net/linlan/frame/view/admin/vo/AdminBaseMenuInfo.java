/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.admin.vo;

import lombok.Data;

/**
 *
 * Filename:AdminMenuBaseInfo.java
 * Desc: 菜单信息
 *
 * @author Linlan
 * @author <a href="mailto:hcday@qq.com">hcday soo</a>
 * CreateTime:5/10/19 9:38 PM
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class AdminBaseMenuInfo {
    /**
     * 功能菜单ID
     */
    private Long    id;
    /**
     * 父功能菜单ID
     */
    private Long    parentId;
    /**
     * 功能名称
     */
    private String  name;
    /**
     * 功能名称英文
     */
    private String  ename;
    /**
     * 功能类型,0CATAGORY目录1MENU菜单2BUTTON按钮
     */
    private String  type;
    /**
     * 权限字符串
     */
    private String  perms;
    /**
     * 菜单层次
     */
    private Integer menuLevel;
    /**
     * 调用入口类型    // urlType 为 5时，当前组能看到的栏目ID
     */
    private String  urlType;
    /**
     * 功能地址
     */
    private String  url;
    /**
     * 菜单组件
     */
    private String  menuSeq;
    /**
     * 菜单图标
     */
    private String  icon;
    /**
     * 图片路径
     */
    private String  imagePath;
    /**
     *  菜单样式 目前是判断是否为新菜单，css名称
     */
    private String  css;
    /**
     * 新增 菜单 描述字段
     */
    private String  description;
    /**
     * 新增 菜单获取待办数量api配置
     */
    private String  todoTotalApi;

}
