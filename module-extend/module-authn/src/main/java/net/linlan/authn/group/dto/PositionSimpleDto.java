/*
 * module-authn - 动态认证对接模块
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
package net.linlan.authn.group.dto;

import lombok.Data;

import net.linlan.utils.entity.BaseEntity;

@Data
public class PositionSimpleDto extends BaseEntity {
    /**
     * 岗位编号
     */
    private String id;
    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 岗位名称
     */
    private String name;
    /**
     * 岗位级别
     */
    private String posRank;
    /**
     * 角色分类
     */
    private String roletypeId;
    /**
     * 排序
     */
    private String priority;
    /**
     * 角色分类名称
     */
    private String roletypeName;
    /**
     * 岗位工作组
     */
    private String groupId;
    /**
     * 对应查询的组织机构树类型
     */
    private String wlType;

}
