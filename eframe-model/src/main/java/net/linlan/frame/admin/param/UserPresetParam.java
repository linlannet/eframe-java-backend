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
package net.linlan.frame.admin.param;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * SasPowerPreset数据域:权限预置信息查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-29 13:55:02
 *
 */
@Data
public class UserPresetParam extends BaseParam {

    /**
     * 类型 RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345
     */
    private String  type;
    /**
     * 状态：0未初始化 1 已初始化， 2.初始化失败
     */
    private Integer status;
    /**
     * 应用Id
     */
    private String  appId;
    /**
     * 角色类型，R31 WEB，R32移动
     * 对应字段：SYNC_MODE
     */
    private String  roleTypeId;
    /**
     * 组id
     */
    private Long    groupId;
    /**
     * 岗位id
     */
    private String  positionId;
    /**
     * 机构id
     */
    private String  organId;
    /**
     * 区域id
     */
    private Long    areaId;
    /**
     * 批次id
     */
    private String  batchId;
    /**
     * 关键字
     */
    private String  keyWords;

}
