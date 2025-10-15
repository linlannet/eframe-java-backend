/*
 * eframe-java-backend - JAVA开发的企业级后端框架，基于Springboot，采用支持 JAVA 1.8最高版本的framework、security，后端数据访问采用Mybatis框架，支持多种数据库一套代码适配，提供脚手架可快速生成Mapper等，借鉴若依框架，实现最基础的管理员、机构、角色、权限、分组、消息管理，为各类企业级应用提供框架支撑应用扩展。
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

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.aliyun.oss.OSSClient;

import net.linlan.oss.config.CloudStorageConfig;
import net.linlan.utils.exception.CommonException;

/**
 * 阿里云存储
 * @author Linlan
 * CreateTime 2017-03-26 16:22
 */
public class AliyunCloudStorageService extends CloudStorageService {
    private OSSClient client;

    public AliyunCloudStorageService(CloudStorageConfig config) {
        this.config = config;

        //初始化
        init();
    }

    private void init() {
        client = new OSSClient(config.getAliyunEndPoint(), config.getAliyunAccessKeyId(),
            config.getAliyunAccessKeySecret());
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            client.putObject(config.getAliyunBucketName(), path, inputStream);
        } catch (Exception e) {
            throw new CommonException("上传文件失败，请检查配置信息");
        }

        return config.getAliyunDomain() + "/" + path;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(config.getAliyunPrefix(), suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(config.getAliyunPrefix(), suffix));
    }

}
