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
 * 树查询参数
 */
@Data
public class TreeParam extends BaseParam {
    /**
     * 树类型：参见 TreeTypeEnum
     */
    private String type;
    /**
     * 机构类型
     */
    private String wlType;
    /**
     * 树子类型
     */
    private String subType;
    /**
     * 父id, 空的时候查根节点   TYPE:ID
     */
    private String parentId;
    /**
     * 刷新缓存：Y 是，N 否,
     * 缓存刷新时间，10分钟。
     */
    private String refresh    = "N";

    /**
     * 岗位层级类型
     */
    private String positionType;
    /**
     * 会员组ID,返回岗位是否绑定
     */
    private String groupId;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 角色类型ID
     */
    private String roletypeId;
    /**
     * 岗位ID
     */
    private String positionId;

    /**
     * 角色类型id，注意大小写
     */
    private String roleTypeId;
    /**
     * 标签类型过滤
     */
    private String refType;
    /**
     * 如果传入parentId为空，则通过organwId查自身所属机构节点
     */
    private String organwId;
    /**
     * 用于资源目录管理的字段
     */
    private String metaId;
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 状态
     */
    private String status;
    /**
     * 名字
     */
    private String key;
    /**
     * 功能类型
     */
    private String gnType;
    /**
     * 是否显示button，默认不显示
     */
    private String showButton = "N";
}
