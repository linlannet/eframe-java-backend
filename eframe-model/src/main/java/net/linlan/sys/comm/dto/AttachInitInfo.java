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

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * Filename:AttachBaseInfo.java
 * Desc:
 *
 * @author Linlan
 * CreateTime:2021-05-07 16:25:50
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class AttachInitInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 附件ID
     */
    private Long              id;
    /**
     * 外部外键ID
     */
    private String            foreignId;
    /**
     * 上传人ID，关联MEMBER_ID
     */
    private Long              opLId;
    /**
     * 类型ID，如流程、回访、监督
     */
    private String            restypeId;
    /**
     * 可对RESTYPE_ID进一步细分，如流程、回访、监督
     */
    private String            attachType;
    /**
     * 附件路径
     */
    private String            attachPath;
    /**
     * 附件名称
     */
    private String            attachName;
    /**
     * 文件名，显示名称
     */
    private String            showName;
    /**
     * 是否图片0否1是
     */
    private Boolean           isImage;
    /**
     * 是否视频0否1是
     */
    private Boolean           isVideo;
    /**
     * 附件预览路径
     */
    private String            previewPath;
    /**
     * 下载次数
     */
    private Integer           downCount;
    /**
     * 重点优先级
     */
    private Integer           priority;
    /**
     * 描述
     */
    private String            description;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
    }

}
