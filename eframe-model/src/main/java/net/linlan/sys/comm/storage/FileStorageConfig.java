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
package net.linlan.sys.comm.storage;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 *
 * Filename:FileStorageConfig.java
 * Desc:文件存储配置信息
 *
 * @author Linlan
 * CreateTime:2017/10/13 11:42
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class FileStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 文件存储类型
     */
    @JsonFormat()
    private Integer           type;

    /**
     * 文件存储绑定的域名
     */
    private String            domain;
    /**
     * 文件存储路径前缀
     */
    private String            prefix;
    /**
     * 文件存储访问键值
     */
    private String            accessKey;
    /**
     * 文件存储密钥
     */
    private String            secretKey;
    /**
     * 存储空间名
     */
    private String            bucketName;

}
