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

import java.util.List;

import lombok.Data;

/**
 * Created by Administrator on 2019/7/29.
 */
@Data
public class RoleTypeCode {

    private static final long serialVersionUID = 1L;

    /**
     * 编号id
     */
    private String            id;
    /**
     * 父节点编号id
     */
    private String            parentId;
    /**
     * 是否角色分类分类：1是2不是
     */
    private int               isRoleType;
    /**
     * 节点名称
     */
    private String            name;
    /**
     * 排序
     */
    private String            priority;
    /**
     * 角色类型0全局角色1系统管理角色2应用会员角色
     */
    private String            type;
    /**
     * 角色代码
     */
    private String            code;
    /**
     * ztree属性是否展开
     */
    private Boolean           open;
    /**
     * ztree列表
     */
    private List<?>           list;

}
