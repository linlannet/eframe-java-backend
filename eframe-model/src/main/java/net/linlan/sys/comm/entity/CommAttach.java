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
 * CommAttach数据域:应用基础通用附件实体类
 * @author Linlan
 * CreateTime 2023-08-28 08:28:20
 *
 */
@Data
public class CommAttach extends BaseEntity {

    /**
    * 附件ID
    */
    private Long    id;

    /**
    * 外部外键ID，关联TASK时：TASK_ID
    */
    private String  foreignId;

    /**
    * 上传人ID，关联MEMBER_ID
    */
    private Long    opLId;

    /**
    * 类型ID
    */
    private String  restypeId;

    /**
    * 附件类型，材料类型，如一般附件，一般图片，营业执照/组织机构代码证/房屋所有权证/国有土地使用证/企业投资项目备案意见/发改委立项批文/其它/
    */
    private String  attachType;

    /**
    * 附件路径
    */
    private String  attachPath;

    /**
    * 附件名称，材料名称
    */
    private String  attachName;

    /**
    * 文件名，显示名称
    */
    private String  showName;

    /**
    * 是否图片0否1是
    */
    private Boolean isImage;

    /**
    * 是否视频0否1是
    */
    private Boolean isVideo;

    /**
    * 附件预览路径
    */
    private String  previewPath;

    /**
    * 下载次数，收取数量,记录所收取申请材料的数量
    */
    private Integer downCount;

    /**
    * 重点优先级
    */
    private Integer priority;

    /**
    * 描述
    */
    private String  description;

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
