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

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import net.linlan.commons.core.FilePathUtils;
import net.linlan.utils.exception.CommonException;

/**
 *
 * Filename:FileStorageService.java
 * Desc:文件存储
 *
 * @author Linlan
 * CreateTime:2017/10/13 11:40
 *
 * @version 1.0
 * @since 1.0
 *
 */
public class FileStorageService {
    private String    token;
    FileStorageConfig config;

    public FileStorageService(FileStorageConfig config) {
        this.config = config;

        //初始化
        init();
    }

    private void init() {

    }

    public String upload(byte[] data, String path) {
        try {

        } catch (Exception e) {
            throw new CommonException("上传文件失败，请核对云配置信息");
        }

        return config.getDomain() + "/" + path;
    }

    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            throw new CommonException("上传文件失败");
        }
    }

    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, FilePathUtils.getPathOfDay(config.getPrefix(), suffix));
    }

    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, FilePathUtils.getPathOfDay(config.getPrefix(), suffix));
    }

}
