/*
 * module-authn - 动态认证对接模块
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
package net.linlan.authn.group.constant;

import net.linlan.utils.enums.BaseEnumString;

/**
 * 应用类型状态枚举类
 */
public enum GroupPowerEnum implements BaseEnumString {
                                                      /**
                                                       * 业务应用
                                                       */
                                                      POWER_TYPE_BIZ("BIZ", "业务应用"),
                                                      /**
                                                       * 运营运维
                                                       */
                                                      POWER_TYPE_OPERATION("OPERATION", "运营运维"),
                                                      /**
                                                       * 租户租赁
                                                       */
                                                      POWER_TYPE_ENT("POWER_TYPE_ENT", "租户租赁"),
                                                      /**
                                                       * 通用市民
                                                       */
                                                      POWER_TYPE_COMMON("COMMON", "通用市民"),
                                                      /**
                                                       * 工作
                                                       */
                                                      POWER_TYPE_WORK("WORK", "工作"),
                                                      /**
                                                       * 领导
                                                       */
                                                      POWER_TYPE_LEADER("LEADER", "领导"),
                                                      /**
                                                       * 网格
                                                       */
                                                      POWER_TYPE_GRID("GRID", "网格"),
                                                      /**
                                                       * 基层
                                                       */
                                                      POWER_TYPE_JICENG("JICENG", "基层"),
                                                      /**
                                                       * 其他
                                                       */
                                                      QITA("QITA", "其他"),;

    /**
     * 配置项名称
     */
    private String key;
    /**
     * 配置项值
     */
    private String value;

    GroupPowerEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
