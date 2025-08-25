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
import java.util.Date;
import java.util.List;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * SysMenu数据域:系统菜单实体类
 * @author Linlan
 * CreateTime 2017-10-17 14:21:37
 *
 */
@Data
public class SysMenu extends BaseEntity {
    /**
     * 后台菜单：true；后台菜单包括a/模版路径和外部路径，组件和栏目其路径
     * 前台菜单：false，前台菜单包括WORK和APP两种
     * 通过IS_PROTECT来控制
     */
    public static final Boolean MENU_IS_PROTECT_ADMIN  = true;
    public static final Boolean MENU_IS_PROTECT_MEMBER = false;
    /**
     * 菜单类型：ADMIN,APP,WORK,SCREEN,MEMBER,AUDIT
     */
    public static final String  MENU_TYPE_ADMIN        = "ADMIN";
    public static final String  MENU_TYPE_APP          = "APP";
    public static final String  MENU_TYPE_WORK         = "WORK";
    public static final String  MENU_TYPE_SCREEN       = "SCREEN";
    public static final String  MENU_TYPE_MEMBER       = "MEMBER";
    public static final String  MENU_TYPE_AUDIT        = "AUDIT";
    /**
     * 菜单类型：CATALOG,MENU,BUTTON,OUTLINK,CHANNEL,COMPOS,SCENES,RECOMMEND,FOLLOW,OTHER
     */
    public static final String  URL_TYPE_CATALOG       = "CATALOG";
    public static final String  URL_TYPE_MENU          = "MENU";
    public static final String  URL_TYPE_BUTTON        = "BUTTON";
    public static final String  URL_TYPE_OUTLINK       = "OUTLINK";
    public static final String  URL_TYPE_COMPOS        = "COMPOS";
    public static final String  URL_TYPE_CHANNEL       = "CHANNEL";
    public static final String  URL_TYPE_SCENES        = "SCENES";
    public static final String  URL_TYPE_RECOMMEND     = "RECOMMEND";
    public static final String  URL_TYPE_FOLLOW        = "FOLLOW";
    public static final String  URL_TYPE_OTHER         = "OTHER";

    /**
    * 功能菜单ID
    */
    private Long                id;

    /**
    * 父功能菜单ID
    */
    private Long                parentId;

    /**
    * 应用ID
    */
    private String              appId;

    /**
    * 功能名称
    */
    private String              name;

    /**
    * 功能名称简称，英文，其他语种名称
    */
    private String              ename;

    /**
    * 简短名称
    */
    private String              sname;

    /**
    * 是否系统菜单，0否（会员或前端菜单）1是（系统菜单）
    */
    private Boolean             isProtect;

    /**
    * 功能类型,关联BASE_RIGHTTYPE，ADMIN,WORK,APP,SCREEN,MEMBER,AUDIT
    */
    private String              type;

    /**
    * 系统管理用户ID
    */
    private String              userId;

    /**
    * 功能编号
    */
    private String              code;

    /**
    * 菜单层次
    */
    private Integer             menuLevel;

    /**
    * 子节点数
    */
    private Integer             subCount;

    /**
    * 功能模型，多个用逗号分隔，如：admin:user:list
    */
    private String              perms;

    /**
    * 调用入口类型，如CATAGORY,MENU,BUTTON,OUTLINK,CHANNEL,COMPOS,SCENES,RECOMMEND,FOLLOW
    */
    private String              urlType;

    /**
    * 功能地址，前台URL路由地址
    */
    private String              url;

    /**
    * 功能图标，样式序号，图标或按钮路径
    */
    private String              icon;

    /**
    * 弹出位置
    */
    private Integer             popPosition;

    /**
    * 图片路径
    */
    private String              imagePath;

    /**
    * CSS页面样式
    */
    private String              css;

    /**
    * JS事件
    */
    private String              jsEvent;

    /**
    * 菜单序列,菜单关联的外键ID，如栏目ID，组件ID，三方功能ID
    */
    private String              menuSeq;

    /**
    * 快捷键
    */
    private String              shortCut;

    /**
    * 是否叶子节点0为非叶子节点，1为叶子节点
    */
    private Boolean             isLeaf;

    /**
    * 是否显示0否1是
    */
    private Boolean             isDisplay;

    /**
    * 是否禁用0否1是
    */
    private Boolean             isDisabled;

    /**
    * 是否验证权限0为无需验证，1为需要验证
    */
    private Boolean             isCheck;

    /**
    * 重点优先级
    */
    private Integer             priority;

    /**
    * 是否删除1已删除0正常
    */
    private Integer             delFlag;

    /**
    * 删除时间
    */
    private Date                deleteTime;

    /**
    * 描述
    */
    private String              description;

    /**
    * 备用1
    */
    private String              spare1;

    /**
    * 备用2
    */
    private String              spare2;

    /**
     * ztree属性
     */
    private Boolean             open;

    private List<?>             list;

    //hcday add 2017-10-6
    /**
     * 菜单类型
     */
    public enum MenuType {
                          /**
                           * 管理应用WEB
                           */
                          ADMIN("ADMIN"),
                          /**
                           * 前端管理WORK
                           */
                          WORK("WORK"),
                          /**
                           * 移动端应用APP
                           */
                          APP("APP"),
                          /**
                           * 会员应用
                           */
                          MEMBER("MEMBER"),
                          /**
                           * 大屏端应用
                           */
                          SCREEN("SCREEN"),
                          /**
                           * 服务审计
                           */
                          AUDIT("AUDIT");

        private String value;

        private MenuType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //hcday add 2017-10-6
    /**
     * 菜单类型
     */
    public enum MenuUrlType {
                             /**
                              * 目录
                              */
                             CATALOG("CATALOG"),
                             /**
                              * 菜单
                              */
                             MENU("MENU"),
                             /**
                              * 按钮
                              */
                             BUTTON("BUTTON"),
                             /**
                              * 外部链接
                              */
                             OUTLINK("OUTLINK"),
                             /**
                              * 组件资源
                              */
                             COMPOS("COMPOS"),
                             /**
                              * 栏目分类
                              */
                             CHANNEL("CHANNEL"),
                             /**
                              * 场景应用
                              */
                             SCENES("SCENES"),
                             /**
                              * 推荐热点
                              */
                             RECOMMEND("RECOMMEND"),
                             /**
                              * 关注收藏
                              */
                             FOLLOW("FOLLOW"),
                             /**
                              * 其他
                              */
                             OTHER("OTHER");

        private String value;

        private MenuUrlType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //hcday add 2018-04-23
    /** get the ids of input collection menus
     * @param menus the input menus
     * @return the ids
     */
    public static Long[] fetchIds(Collection<SysMenu> menus) {
        if (menus == null) {
            return null;
        }
        Long[] ids = new Long[menus.size()];
        int i = 0;
        for (SysMenu c : menus) {
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
        if (getIsDisabled() == null) {
            setIsDisabled(KernelConstant.DEFAULT_DISABLED);
        }
        if (getIsLeaf() == null) {
            setIsLeaf(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsProtect() == null) {
            setIsProtect(!KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getIsDisplay() == null) {
            setIsDisplay(KernelConstant.DEFAULT_DISPLAY);
        }
        if (getIsCheck() == null) {
            setIsCheck(KernelConstant.DEFAULT_BOOLEAN);
        }
        if (getUrlType() == null) {
            setUrlType(MenuUrlType.CATALOG.value);
        }
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
        if (getSname() == null) {
            setSname(getName());
        }
        if (getDelFlag() == null) {
            setDelFlag(KernelConstant.DEL_FLAG_DEFAULT);
        }

        if (getCode() == null) {
            setCode(RandomUtils.randomCode());
        }
    }

}
