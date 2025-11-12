/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.third.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * ThirdMemberToken数据域:会员用户令牌实体类
 * 
 * @author Linlan
 * CreateTime 2025-10-13 16:35:28
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class ThirdMemberToken extends BaseEntity {

    /**
     * 主键ID
     */
    private Long   id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 令牌TOKEN
     */
    private String token;

    /**
     * 前台应用或站点ID
     */
    private String foreignId;

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
     * 备注
     */
    private String description;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }
        if (getUpdateTime() == null) {
            setUpdateTime(new Timestamp(System.currentTimeMillis()));
        }

    }

}
