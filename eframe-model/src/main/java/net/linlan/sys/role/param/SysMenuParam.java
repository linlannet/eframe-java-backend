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
 * SysMenu数据域:系统菜单查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 14:19:06
 *
 */
@Data
public class SysMenuParam extends BaseParam {

    /**
    * 父功能菜单ID
    */
    private Long     parentId;
    /**
    * 应用ID
    */
    private String   appId;
    /**
    * 功能名称
    */
    private String   name;
    /**
    * 是否系统菜单，0否（会员或前端菜单）1是（系统菜单）
    */
    private Boolean  isProtect;
    /**
    * 功能类型,关联BASE_RIGHTTYPE，ADMIN,WORK,APP,SCREEN,MEMBER,AUDIT
    */
    private String   type;
    /**
    * 功能编号
    */
    private String   code;
    /**
    * 菜单层次
    */
    private Integer  menuLevel;
    /**
    * 子节点数
    */
    private Integer  subCount;
    /**
    * 调用入口类型，如CATAGORY,MENU,BUTTON,OUTLINK,CHANNEL,COMPOS,SCENES,RECOMMEND,FOLLOW
    */
    private String   urlType;
    /**
    * 功能地址，前台URL路由地址
    */
    private String   url;
    /**
    * 功能图标，样式序号，图标或按钮路径
    */
    private String   icon;
    /**
    * 弹出位置
    */
    private Integer  popPosition;
    /**
    * 图片路径
    */
    private String   imagePath;
    /**
    * 快捷键
    */
    private String   shortCut;
    /**
    * 是否显示0否1是
    */
    private Boolean  isDisplay;
    /**
    * 是否禁用0否1是
    */
    private Boolean  isDisabled;
    /**
    * 是否验证权限0为无需验证，1为需要验证
    */
    private Boolean  isCheck;
    /**
    * 是否删除1已删除0正常
    */
    private Integer  delFlag;
    /**
    * 描述
    */
    private String   description;
    /**
     * 创建时间
     */
    private String   createTime;
    /**
    * 备用1
    */
    private String   spare1;
    /**
    * 备用2
    */
    private String   spare2;
    /**
     * 是否全部菜单
     */
    private String   isMenuAll;
    /**
     * 菜单位置
     */
    private int      offset;
    /**
     * 父节点为空
     */
    private String   parentNull;
    /**
     * 根节点
     */
    private String   parentRoot;
    /**
     * 类型为Button
     */
    private String   typeNoButton;
    /**
     * 应用ID集合
     */
    private String[] appIds;
    /**
     * 菜单ID集合
     */
    private Long[]   menuIds;

}
