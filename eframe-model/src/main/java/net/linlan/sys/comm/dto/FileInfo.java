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
package net.linlan.sys.comm.dto;

import lombok.Data;

/**
 *
 * FileInfo数据域:文件基本信息DTO类
 * Desc: 文件基本信息
 *
 * @author Linlan
 * CreateTime:3/14/20 3:33 PM
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class FileInfo {
    /**
     * 原文件名
     */
    private String originFilename;
    /**
     * 保存文件名
     */
    private String filename;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 保存路径
     */
    private String fileUrl;
    /**
     * 保存路径，对外使用的Http或Https路径
     */
    private String fileHttpUrl;
    /**
     * 是否上传成功
     */
    private String statusCode;

}
