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
 * 菜单地址类型枚举类
 */
public enum UrlTypeEnum {
                         /**
                          * 目录类
                          */
                         CATALOG("CATALOG", "目录类"),
                         /**
                          * 菜单类
                          */
                         MENU("MENU", "菜单类"),
                         /**
                          * 按钮类
                          */
                         BUTTON("BUTTON", "按钮类"),
                         /**
                          * 外链类
                          */
                         OUTLINK("OUTLINK", "外链类"),
                         /**
                          * 组件类
                          */
                         COMPOS("COMPOS", "组件类"),
                         /**
                          * 栏目类
                          */
                         CHANNEL("CHANNEL", "栏目类"),
                         /**
                          * 场景类
                          */
                         SCENES("SCENES", "场景类"),
                         /**
                          * 推荐类
                          */
                         RECOMMEND("RECOMMEND", "推荐类"),
                         /**
                          * 互动类
                          */
                         FOLLOW("FOLLOW", "互动类"),
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

    UrlTypeEnum(String key, String value) {
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
