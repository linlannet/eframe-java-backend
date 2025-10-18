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
package net.linlan.frame.config.entity;

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * PublicUnionMessage数据域:统一消息接收实体类
 * @author Linlan
 * CreateTime 2024-10-02 22:29:21
 *
 */
@Data
public class PublicUnionMessage extends BaseEntity {

    /**
     * 记录ID
     */
    private String  id;

    /**
     * 应用ID
     */
    private String  appId;

    /**
     * 站点门户ID
     */
    private String  foreignId;

    /**
     * 类型
     */
    private String  type;

    /**
     * 业务类型
     */
    private String  bizType;

    /**
     * 统一消息创建时间
     */
    private Date    msgCreateTime;

    /**
     * 信息ID
     */
    private Long    msgId;

    /**
     * 消息类型
     */
    private Integer msgType;

    /**
     * 信息标题
     */
    private String  msgTitle;

    /**
     * 统一消息摘要
     */
    private String  msgAbstract;

    /**
     * 统一消息应用账户ID
     */
    private String  msgAccountId;

    /**
     * 统一消息应用系统或账户名称
     */
    private String  msgAccountName;

    /**
     * 统一消息应用应用ID
     */
    private String  msgModuleId;

    /**
     * 统一消息应用应用名称
     */
    private String  msgModuleName;

    /**
     * 统一消息应用用户ID
     */
    private String  msgUserId;

    /**
     * 统一消息应用用户名称
     */
    private String  msgUserName;

    /**
     * 统一消息应用机构ID
     */
    private String  msgOrganId;

    /**
     * 统一消息应用机构名称
     */
    private String  msgOrganName;

    /**
     * 统一信息链接，链接平台内地址，可点击访问
     */
    private String  msgUrl;

    /**
     * 统一消息业务标签
     */
    private String  msgLabels;

    /**
     * 统一消息信息内容
     */
    private String  msgContent;

    /**
     * 状态，0待阅读，10已阅读
     */
    private String  status;

    /**
     * 操作人ID
     */
    private String  opUserId;

    /**
     * 操作时间
     */
    private Date    opTime;

    /**
     * 操作单位ID
     */
    private String  opOrganId;

    /**
     * 操作单位名称
     */
    private String  opOrganName;

    /**
     * 备注
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
            setId(RandomUtils.randomSid());
        }

    }

}
