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
package net.linlan.oss.config;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

import net.linlan.oss.storage.group.AliyunGroup;
import net.linlan.oss.storage.group.QcloudGroup;
import net.linlan.oss.storage.group.QiniuGroup;

/**
 * 云存储配置信息
 * @author Linlan
 * CreateTime 2017-03-25 16:12
 */
@Data
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 类型 1：七牛  2：阿里云  3：腾讯云
     */
    private Integer           type;
    /**
     * 七牛绑定的域名
     */
    @NotBlank(message = "七牛绑定的域名不能为空", groups = QiniuGroup.class)
    private String            qiniuDomain;
    /**
     * 七牛路径前缀
     */
    private String            qiniuPrefix;
    /**
     * 七牛ACCESS_KEY
     */
    @NotBlank(message = "七牛AccessKey不能为空", groups = QiniuGroup.class)
    private String            qiniuAccessKey;
    /**
     * 七牛SECRET_KEY
     */
    @NotBlank(message = "七牛SecretKey不能为空", groups = QiniuGroup.class)
    private String            qiniuSecretKey;
    /**
     * 七牛存储空间名
     */
    @NotBlank(message = "七牛空间名不能为空", groups = QiniuGroup.class)
    private String            qiniuBucketName;

    /**
     * 阿里云绑定的域名
     */
    @NotBlank(message = "阿里云绑定的域名不能为空", groups = AliyunGroup.class)
    private String            aliyunDomain;
    /**
     * 阿里云路径前缀
     */
    private String            aliyunPrefix;
    /**
     * 阿里云EndPoint
     */
    @NotBlank(message = "阿里云EndPoint不能为空", groups = AliyunGroup.class)
    private String            aliyunEndPoint;
    /**
     * 阿里云AccessKeyId
     */
    @NotBlank(message = "阿里云AccessKeyId不能为空", groups = AliyunGroup.class)
    private String            aliyunAccessKeyId;
    /**
     * 阿里云AccessKeySecret
     */
    @NotBlank(message = "阿里云AccessKeySecret不能为空", groups = AliyunGroup.class)
    private String            aliyunAccessKeySecret;
    /**
     * 阿里云BucketName
     */
    @NotBlank(message = "阿里云BucketName不能为空", groups = AliyunGroup.class)
    private String            aliyunBucketName;

    /**
     * 腾讯云绑定的域名
     */
    @NotBlank(message = "腾讯云绑定的域名不能为空", groups = QcloudGroup.class)
    private String            qcloudDomain;
    /**
     * 腾讯云路径前缀
     */
    private String            qcloudPrefix;
    /**
     * 腾讯云AppId
     */
    @NotNull(message = "腾讯云AppId不能为空", groups = QcloudGroup.class)
    private Integer           qcloudAppId;
    /**
     * 腾讯云SecretId
     */
    @NotBlank(message = "腾讯云SecretId不能为空", groups = QcloudGroup.class)
    private String            qcloudSecretId;
    /**
     * 腾讯云SecretKey
     */
    @NotBlank(message = "腾讯云SecretKey不能为空", groups = QcloudGroup.class)
    private String            qcloudSecretKey;
    /**
     * 腾讯云BucketName
     */
    @NotBlank(message = "腾讯云BucketName不能为空", groups = QcloudGroup.class)
    private String            qcloudBucketName;
    /**
     * 腾讯云COS所属地区
     */
    @NotBlank(message = "所属地区不能为空", groups = QcloudGroup.class)
    private String            qcloudRegion;

}
