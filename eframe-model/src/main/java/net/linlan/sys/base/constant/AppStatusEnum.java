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
 * 应用状态字典
 */
public enum AppStatusEnum implements BaseEnumInteger {
                                                      /**
                                                       * 停用
                                                       */
                                                      DISABLE(0, "停用"),
                                                      /**
                                                       * 正常
                                                       */
                                                      NORMAL(1, "正常"),
                                                      /**
                                                       * 升级
                                                       */
                                                      UPDATE(2, "升级"),
                                                      /**
                                                       * 锁定
                                                       */
                                                      LOCKED(3, "锁定"),;

    /**
     * 配置项名称
     */
    private int    key;
    /**
     * 配置项值
     */
    private String value;

    AppStatusEnum(int key, String value) {
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
