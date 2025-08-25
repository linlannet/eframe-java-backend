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

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 *
 * Filename:SysRole.java
 * Desc:
 *
 * @author Linlan
 * CreateTime:2017-10-17 14:21:37
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class SysRoleListDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private String            id;
    /**
     * 角色自定义名称
     */
    private String            name;
    /**
     * 角色自定义代码
     */
    private String            code;
    /**
     * 重点优先级
     */
    private Integer           priority;
    /**
     * 创建时间
     */
    private Date              createTime;
    /**
     * 状态
     */
    private Integer           status;
    /**
     * 角色描述（父角色id）
     */
    private String            description;
    /**
     * 全局应用信息类
     */
    private String            appName;
    /**
     * 系统角色分类
     */
    private String            roletypeName;
}
