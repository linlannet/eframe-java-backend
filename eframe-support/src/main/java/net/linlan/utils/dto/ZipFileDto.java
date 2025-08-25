/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.dto;

import java.io.ByteArrayOutputStream;
import java.util.List;

import lombok.Data;

/**
 * 压缩包工具类
 */
@Data
public class ZipFileDto {
    /**
     * 每个文件的文件名称
     */
    private List<String>                fileNames;
    /**
     * 每个文件的流
     */
    private List<ByteArrayOutputStream> streams;
    /**
     * 定义的压缩文件的名称
     */
    private String                      zipFileName;

}
