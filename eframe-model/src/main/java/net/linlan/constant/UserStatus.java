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
package net.linlan.constant;

import net.linlan.utils.enums.BaseEnumInteger;

/**
 * 用户状态
 * 
 * @author Linlan
 */
public enum UserStatus implements BaseEnumInteger {
                                                   /**
                                                    * 未生效
                                                    */
                                                   NOT(0, "未生效"),
                                                   /**
                                                    * 正常
                                                    */
                                                   OK(1, "正常"),
                                                   /**
                                                    * 停用
                                                    */
                                                   DISABLE(2, "停用"),
                                                   /**
                                                    * 锁定
                                                    */
                                                   LOCKED(3, "锁定"),
                                                   /**
                                                    * 删除
                                                    */
                                                   DELETED(4, "删除");

    /**
     * 键
     */
    private final int    key;
    /**
     * 值
     */
    private final String value;

    UserStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

}
