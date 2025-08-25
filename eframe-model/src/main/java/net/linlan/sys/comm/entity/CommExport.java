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

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * CommExport数据域:应用基础通用导出实体类
 * @author Linlan
 * CreateTime 2022-06-15 11:56:49
 *
 */
@Data
public class CommExport extends BaseEntity {

    /**
    * 导出任务ID
    */
    private Long    id;

    /**
    * 应用ID
    */
    private String  appId;

    /**
    * 站点ID
    */
    private Long    siteId;

    /**
    * 外部外键类型，申请信息TaskInfo，个人信息BaseUser，企业信息BaseOrgan
    */
    private String  foreignType;

    /**
    * 外部外键ID，关联TASK_ID，USER_ID，ORGAN_ID
    */
    private String  foreignId;

    /**
    * 外部名称，申请对象名称，个人名称，企业名称
    */
    private String  foreignName;

    /**
    * 导出材料类型，ZIP压缩包
    */
    private String  type;

    /**
    * 操作时间,最近下载时间
    */
    private Date    opTime;

    /**
    * 操作人ID
    */
    private String  opUserId;

    /**
    * 操作人名称
    */
    private String  opUserName;

    /**
    * 操作部门ID
    */
    private String  opOrganId;

    /**
    * 操作部门名称
    */
    private String  opOrganName;

    /**
    * 下载次数
    */
    private Integer downCount;

    /**
    * 下载预览路径
    */
    private String  downPath;

    /**
    * 重点优先级
    */
    private Integer priority;

    /**
    * 状态：队列中、下载中、已完成
    */
    private String  status;

    /**
    * 描述
    */
    private String  description;

    /**
    * 备用1
    */
    private String  spare1;

    /**
    * 备用2
    */
    private String  spare2;

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
