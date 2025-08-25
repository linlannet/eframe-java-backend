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
package net.linlan.sys.comm.entity;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * CommFile数据域:公共文件附件表实体类
 * @author Linlan
 * CreateTime 2018-03-02 17:23:31
 *
 */
@Data
public class CommFile extends BaseEntity {
    /** The file type local. 文件保存方式，本地*/
    public static int FILE_TYPE_LOCAL = 0;

    /** The file type cloud. 文件保存方式，云空间*/
    public static int FILE_TYPE_CLOUD = 1;

    /**
    * 文件路径
    */
    private String    id;

    /**
    * 资源种类ID
    */
    private String    resclassId;

    /**
    * 应用ID
    */
    private String    appId;

    /**
    * 用户类型
    */
    private Integer   userType;

    /**
    * 文件名称
    */
    private String    fileName;

    /**
    * 是否有效
    */
    private Boolean   fileIsvalid;

    /**
    * 参考ID
    */
    private String    refId;

    /**
    * 类名称
    */
    private String    refType;

    /**
    * 文件大小，单位KB
    */
    private Long      fileSize;

    /**
    * 文件扩展名
    */
    private String    fileExtension;

    /**
     * 初始化方法
     */
    public void init() {
        /**
        * 添加对数据库或实体对象的默认值处理
        */
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }
        if (getFileIsvalid() == null) {
            setFileIsvalid(!KernelConstant.DEFAULT_BOOLEAN);
        }
    }

}
