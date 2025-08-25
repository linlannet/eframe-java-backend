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
package net.linlan.frame.admin.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.role.dto.SysMenuButtonDto;
import net.linlan.sys.role.dto.SysMenuDto;
import net.linlan.sys.role.entity.SysMenu;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.constant.Constants;

/**
 * 菜单权限表 ADMIN_MENU
 * 
 * @author Linlan
 */
@Data
public class AdminMenuVo {
    private static final long      serialVersionUID = 1L;

    /** 菜单ID */
    private Long                   menuId;

    /** 菜单名称 */
    private String                 menuName;
    /** 功能类型 */
    private String                 type;
    /** 功能类型 */
    private String                 typeName;

    /** 父菜单名称 */
    private String                 parentName;

    /** 父菜单ID */
    private Long                   parentId;

    /** 显示顺序 */
    private Integer                priority;

    /** 简短名称ENAME */
    private String                 path;

    /** 组件路径URL */
    private String                 component;

    /** 路由参数JS_EVENT */
    private String                 query;

    /** 路由地址 */
    private String                 routeName;

    /** 是否为外链（0是 1否） */
    private String                 isFrame;

    /** 是否缓存（0缓存 1不缓存） */
    private String                 isCache;

    /** 菜单类型URL_TYPE（M目录 C菜单 F按钮） */
    private String                 menuType;
    /** 菜单类型URL_TYPE（M目录 C菜单 F按钮） */
    private String                 menuTypeName;

    /** 显示状态（0隐藏 1显示） */
    private String                 visible;

    /** 菜单禁用（0正常 1禁用） */
    private String                 status;

    /** 权限字符串 */
    private String                 perms;

    /** 菜单图标 */
    private String                 icon;

    /** 菜单图片 */
    private String                 imagePath;

    /** 创建者 */
    private String                 creatorId;

    /** 创建时间 */
    private Date                   createTime;

    /** 更新时间 */
    private Date                   lastTime;

    /** 子菜单 */
    private List<AdminMenuVo>      children         = new ArrayList<AdminMenuVo>();

    /** 子菜单数量 */
    private Integer                childNum;

    /** 备注 */
    private String                 description;
    /** 页面列表JSON */
    private String                 listJson;
    /** 状态0正常1停用2已删除 */
    private Integer                delFlag;

    /** 权限数组 */
    private List<PermsDto>         permsList;
    /** 子菜单按钮 */
    private List<SysMenuButtonDto> buttonMenuList;

    public AdminMenuVo() {

    }

    /**
     * 数据赋值TO方法，将AdminMenu的input对象赋值给AdminMenuVo
     */
    public static final Function TO = new Function<SysMenu, AdminMenuVo>() {
        @Nullable
        @Override
        public AdminMenuVo apply(@Nullable SysMenu input) {
            return new AdminMenuVo(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminMenuVo(SysMenu input) {
        this.menuId = input.getId();
        this.parentId = input.getParentId();
        this.menuName = input.getName();
        this.path = input.getEname();
        this.routeName = input.getUrl();
        this.creatorId = input.getUserId();
        this.perms = input.getPerms();
        this.menuType = input.getUrlType();
        this.component = input.getMenuSeq();
        this.icon = input.getIcon();
        this.query = input.getJsEvent();
        this.visible = input.getIsDisplay() ? "1" : "0";
        this.status = input.getIsDisabled() ? "1" : "0";
        this.isFrame = input.getIsCheck() ? "1" : "0";
        this.priority = input.getPriority();
        this.createTime = input.getCreateTime();
        this.description = input.getDescription();
        this.isCache = input.getSpare2();
        this.delFlag = input.getDelFlag();
        this.imagePath = input.getImagePath();
        //        this.listJson = input.getSpare1();
    }

    /**
     * 数据赋值DTO方法，将AdminMenuDto的input对象赋值给AdminMenuVo
     */
    public static final Function DTO = new Function<SysMenuDto, AdminMenuVo>() {
        @Nullable
        @Override
        public AdminMenuVo apply(@Nullable SysMenuDto input) {
            return new AdminMenuVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminMenuVo(SysMenuDto input) {
        this.menuId = input.getId();
        this.parentId = input.getParentId();
        this.menuName = input.getName();
        this.path = input.getEname();
        this.routeName = input.getUrl();
        this.creatorId = input.getUserId();
        this.perms = input.getPerms();
        this.menuType = input.getUrlType();
        this.component = input.getMenuSeq();
        this.icon = input.getIcon();
        this.query = input.getJsEvent();
        this.visible = input.getIsDisplay() ? "1" : "0";
        this.status = input.getIsDisabled() ? "1" : "0";
        this.isFrame = input.getIsCheck() ? "1" : "0";
        this.priority = input.getPriority();
        this.createTime = input.getCreateTime();
        this.description = input.getDescription();
        this.isCache = input.getSpare2();
        this.delFlag = input.getDelFlag();
        this.imagePath = input.getImagePath();
        //        this.listJson = input.getSpare1();

    }

    public static SysMenu transTo(AdminMenuVo input) {
        SysMenu result = new SysMenu();
        if (ObjectUtils.isNotEmpty(input.getMenuId())) {
            result.setId(input.getMenuId());
        }
        if (ObjectUtils.isEmpty(input.getParentId())) {
            result.setParentId(KernelConstant.DEFAULT_BIGINT);
        } else {
            result.setParentId(input.getParentId());
        }
        result.setAppId(Constants.ENT_APP_ID);
        result.setType(Constants.SUPER_ADMIN);
        result.setName(input.getMenuName());
        result.setEname(input.getPath());
        result.setUrl(input.getRouteName());
        result.setUserId(input.getCreatorId());
        result.setPerms(input.getPerms());
        result.setUrlType(input.getMenuType());
        result.setMenuSeq(input.getComponent());
        result.setIcon(input.getIcon());
        result.setJsEvent(input.getQuery());
        result.setIsDisplay(
            StringUtils.isNotEmpty(input.getVisible()) ? "1".equals(input.getVisible()) : true);
        result.setIsDisabled(
            StringUtils.isNotEmpty(input.getStatus()) ? "1".equals(input.getStatus()) : false);
        result.setIsCheck(
            StringUtils.isNotEmpty(input.getIsFrame()) ? "1".equals(input.getIsFrame()) : false);
        result.setPriority(input.getPriority());
        result.setDescription(input.getDescription());
        result.setSpare2(input.getIsCache());
        result.setDelFlag(input.getDelFlag());
        result.setImagePath(input.getImagePath());
        //        result.setSpare1(input.getListJson());
        return result;
    }

}
