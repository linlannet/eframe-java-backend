/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.sys.param;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * 动态模型对象数据域:通用表查询参数实体类
 * @author Linlan
 * CreateTime 2024-12-19 17:27:08
 *
 */
@Data
public class CommTableParam extends BaseParam {

    /**
     * 主键ID
     */
    private Long id;

}
