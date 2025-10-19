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
package net.linlan.sys.base.constant;

import net.linlan.utils.enums.BaseEnumInteger;

/**
 * 删除标记枚举
 */
public enum DelFlagEnum implements BaseEnumInteger {
                                                    /**
                                                     * 正常
                                                     */
                                                    NORMAL(0, "正常"),
                                                    /**
                                                     * 已删除
                                                     */
                                                    DELETED(1, "已删除"),
                                                    /**
                                                     * 应用内受限
                                                     */
                                                    LOCKED(2, "应用内受限"),
                                                    /**
                                                     * 回收站
                                                     */
                                                    RECYCLE(3, "回收站"),;

    /**
     * 配置项名称
     */
    private int    key;
    /**
     * 字典值
     */
    private String value;

    DelFlagEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
