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

import net.linlan.utils.enums.BaseEnumInteger;

/**
 * 创建类型枚举，数字类型
 */
public enum SysRoleDefEnum implements BaseEnumInteger {
                                                       /**
                                                        * 互联网门户通用角色
                                                        */
                                                       WWW_ROLE(10, "互联网门户通用角色"),
                                                       /**
                                                        * 互联网门户工作通用角色
                                                        */
                                                       WWW_WORK_ROLE(11, "互联网门户工作通用角色"),
                                                       /**
                                                        * 移动端小程序通用角色
                                                        */
                                                       H5_ROLE(20, "移动端小程序通用角色"),
                                                       /**
                                                                                                           * 移动端小程序工作角色
                                                                                                           */
                                                       H5_WORK_ROLE(21, "移动端小程序工作角色"),
                                                       /**
                                                        * 大屏端智能终端通用角色
                                                        */
                                                       SCREEN_ROLE(30, "大屏端智能终端通用角色"),
                                                       /**
                                                        * 其他通用角色
                                                        */
                                                       OTHER_ROLE(90, "其他通用角色"),;

    /**
     * 配置项名称
     */
    private int    key;
    /**
     * 字典值
     */
    private String value;

    SysRoleDefEnum(int key, String value) {
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
