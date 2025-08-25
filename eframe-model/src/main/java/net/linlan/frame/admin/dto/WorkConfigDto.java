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

import net.linlan.frame.admin.vo.SiteBaseInfoVo;

/**
 *
 * WorkConfigDto视图域:work端配置基本信息对象Vo实体类
 * work端配置基本信息对象
 * @author Linlan
 * CreateTime:2020-10-31 17:25:55
 *
 */
@Data
public class WorkConfigDto {
    /**
     * 默认缺省
     */
    private String         layout;
    /**
     *站点基本对象
     */
    private SiteBaseInfoVo siteInfo;

}
