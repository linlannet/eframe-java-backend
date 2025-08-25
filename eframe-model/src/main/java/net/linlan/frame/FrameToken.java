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
package net.linlan.frame;

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * FrameToken数据域:会员令牌表实体类
 * @author Linlan
 * CreateTime 2018-03-01 19:01:51
 *
 */
@Data
public class FrameToken extends BaseEntity {

    /**
     * 会员ID
     */
    private Long   id;

    /**
     * 令牌TOKEN
     */
    private String token;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 前台站点ID
     */
    private Long   siteId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 更新时间
     */
    private Date   updateTime;

    /**
     * 过期时间
     */
    private Date   expireTime;

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
