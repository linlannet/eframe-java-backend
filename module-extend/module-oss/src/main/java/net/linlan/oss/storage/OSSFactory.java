/*
 * module-oss - 存储对接模块
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
package net.linlan.oss.storage;

import javax.annotation.Resource;

import com.alibaba.fastjson2.JSONObject;

import net.linlan.oss.config.CloudStorageConfig;
import net.linlan.sys.base.service.BaseConfigWholeService;

/**
 *
 * Filename:OSSFactory.java
 * Desc:文件上传到第三方存储Factory
 *
 * @author Linlan
 * CreateTime:2017/9/9 15:24
 *
 * @version 1.0
 * @since 1.0
 *
 */
public final class OSSFactory {

    @Resource
    private static BaseConfigWholeService baseConfigWholeService;

    /**
     * 云存储配置KEY
     */
    public final static String            CLOUD_STORAGE_CONFIG_KEY = "CLOUD_STORAGE_CONFIG_KEY";

    /**
     * 云服务商
     */
    public enum CloudService {
                              /**
                               * 七牛云
                               */
                              QINIU(1),
                              /**
                               * 阿里云
                               */
                              ALIYUN(2),
                              /**
                               * 腾讯云
                               */
                              QCLOUD(3),
                              /**
                               * 阿里云
                               */
                              HUAWEICLOUD(4),
                              /**
                               * 腾讯云
                               */
                              MINIO(5);

        private int value;

        private CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static CloudStorageService build() {
        //获取云存储配置信息
        CloudStorageConfig config = JSONObject.parseObject(
            baseConfigWholeService.getByKey(CLOUD_STORAGE_CONFIG_KEY).getCfgValue(),
            CloudStorageConfig.class);

        if (config.getType() == CloudService.QINIU.getValue()) {
            return new QiniuCloudStorageService(config);
        } else if (config.getType() == CloudService.ALIYUN.getValue()) {
            return new AliyunCloudStorageService(config);
        } else if (config.getType() == CloudService.QCLOUD.getValue()) {
            return new QcloudCloudStorageService(config);
        }

        return null;
    }

}
