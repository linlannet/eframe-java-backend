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
 * PublicNotice数据域:平台公共消息实体类
 * @author Linlan
 * CreateTime 2023-10-02 22:29:22
 *
 */
@Data
public class PublicNotice extends BaseEntity {

    /**
     * 信息ID
     */
    private Long    id;

    /**
     * 站点ID
     */
    private Long    siteId;

    /**
     * 机构ID
     */
    private String  organId;

    /**
     * 业务类型1通知公告11促销21模块业务
     */
    private String  bizType;

    /**
     * 类型，1通知2公告
     */
    private Integer type;

    /**
     * 信息标题
     */
    private String  title;

    /**
     * 信息内容
     */
    private String  content;

    /**
     * 信息链接，链接平台内地址，可点击访问
     */
    private String  msgUrl;

    /**
     * 信息外键，如CONTENT_ID或短彩信网关信息ID
     */
    private String  foreignId;

    /**
     * 图片路径
     */
    private String  imagePath;

    /**
     * 图标样式
     */
    private String  iconStyle;

    /**
     * 信息接收会员ID
     */
    private String  recvMemberId;

    /**
     * 信息接收会员组ID
     */
    private String  recvGroupId;

    /**
     * 信息接收部门ID
     */
    private String  recvOrganId;

    /**
     * 接收对象ID或手机号码列表
     */
    private String  recvTargetid;

    /**
     * 信息状态(0未启用1正常2关闭)
     */
    private Integer status;

    /**
     * 维护管理用户ID
     */
    private String  updatorId;

    /**
     * 修改时间
     */
    private Date    updateTime;

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

    }

}
