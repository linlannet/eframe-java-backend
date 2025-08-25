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
package net.linlan.sys.core.entity;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * CoreOrganAttr数据域:实体类
 * @author Linlan
 * CreateTime 2024-05-02 16:11:12
 *
 */
@Data
public class CoreOrganAttr extends BaseEntity {

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String attrId;

    /**
     * 
     */
    private String attrKey;

    /**
     * 
     */
    private String attrValue;

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
