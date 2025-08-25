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
import lombok.NoArgsConstructor;

/**
 *
 * BaseDictionary视图域:全局公共字典表显示Vo类
 * 
 * @author Linlan
 * CreateTime 2023-09-04 21:28:45
 *
 */
@Data
@NoArgsConstructor
public class BaseDictionaryTreeParam {

    /**
     * 字典类型代码
     */
    private String typeCode;
    /**
     * 字典父节点编号，简单的字典使用
     */
    private String parentId;
    /**
     * 父节点ID
     */
    private String zparentId;
    /**
     * 角色分类ID
     */
    private String roletypeId;

}
