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

import com.alibaba.fastjson2.JSON;

import jakarta.annotation.Resource;
import net.linlan.sys.base.service.BaseConfigWholeService;

/**
 *
 * Filename:OSSFactory.java
 * Desc:文件上传服务器存储Factory
 *
 * @author Linlan
 * CreateTime:2017/10/9 15:24
 *
 * @version 1.0
 * @since 1.0
 *
 */
public final class FileStorageFactory {

    /**
     * 云存储配置KEY
     */
    public final static String FILE_STORAGE_CONFIG_KEY = "FILE_STORAGE_CONFIG_KEY";

    /**
     * 文件存储服务商
     */
    public enum FileStorage {
                             /**
                              * 文件存储
                              */
                             FILE_STORAGE(1);

        private int value;

        private FileStorage(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static FileStorageService build() {
        //获取云存储配置信息
        FileStorageConfig config = JSON.parseObject(
            baseConfigWholeService.getByKey(FILE_STORAGE_CONFIG_KEY).getCfgValue(),
            FileStorageConfig.class);

        if (config.getType() == FileStorage.FILE_STORAGE.getValue()) {
            return new FileStorageService(config);
        }

        return null;
    }

    @Resource
    private static BaseConfigWholeService baseConfigWholeService;

}
