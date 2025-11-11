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
package net.linlan.sys.role.constant;

/**
 * 菜单类型枚举类
 */
public enum MenuTypeEnum {
                          /**
                           * 管理类
                           */
                          ADMIN("ADMIN", "管理类"),
                          /**
                           * 移动端类
                           */
                          APP("APP", "移动端类"),
                          /**
                           * 工作端类
                           */
                          WORK("WORK", "工作端类"),
                          /**
                           * 大屏端类
                           */
                          SCREEN("SCREEN", "大屏端类"),
                          /**
                           * 会员类
                           */
                          MEMBER("MEMBER", "会员类"),
                          /**
                           * 审计类
                           */
                          AUDIT("AUDIT", "审计类"),
                          /**
                           * 其他类
                           */
                          OTHER("OTHER", "其他类"),;

    /**
     * 配置项名称
     */
    private String key;
    /**
     * 配置项值
     */
    private String value;

    MenuTypeEnum(String key, String value) {
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
