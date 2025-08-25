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
package net.linlan.sys.comm.param;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * CommFile数据域:公共文件附件表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 14:34:47
 *
 */
@Data
public class CommFileParam extends BaseParam {

    /**
    * 资源种类ID
    */
    private String  resclassId;
    /**
    * 应用ID
    */
    private String  appId;
    /**
    * 文件名称
    */
    private String  fileName;
    /**
    * 是否有效，0无效1有效
    */
    private Boolean fileIsvalid;
    /**
     * 参考ID
     */
    private String  refId;

    /**
     * 类名称
     */
    private String  refType;
    /**
    * 文件大小，单位KB
    */
    private Long    fileSize;
    /**
    * 文件扩展名
    */
    private String  fileExtension;
    /**
     * 关键字
     */
    private String  key;

}
