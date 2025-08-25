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

import lombok.Data;

/**
 *
 * IndexApplicationDto数据域:首页工作台应用支撑统计对象
 * @author Linlan
 * CreateTime 2025-01-16
 *
 */

@Data
public class IndexApplicationDto {

    /**
     * 机构数
     */
    private String organNum;
    /**
     * 部门数
     */
    private String deptNum;
    /**
     * 人员数
     */
    private String peopleNum;
    /**
     * 角色数
     */
    private String roleNum;
    /**
     * 数据字典分类数
     */
    private String dicTypeNum;
    /**
     * 应用数
     */
    private String appNum;
    /**
     * 资源存储数
     */
    private String fileNum;
    /**
     * 参数数
     */
    private String paramNum;

}
