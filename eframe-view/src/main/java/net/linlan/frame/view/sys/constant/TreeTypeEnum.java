/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.sys.constant;

/**
 * 树类型
 */
public enum TreeTypeEnum {
                          ROLE("ROLE", "角色树"), //鄢涛
                          MENU("MENU", "菜单树"), //张鹏
                          ALL_POSITION("ALL_POSITION", "全部岗位树"), //戚戴力
                          POSITION("POSITION", "岗位树"), //戚戴力
                          SINGLE_POSITION("SINGLE_POSITION", "单表岗位树"), //戚戴力
                          ALL_MENU("ALL_MENU", "全部菜单树"), //张鹏
                          ALL_DEPT("ALL_DEPT", "全部部门树"), //yantao
                          BASE_XZQH("BASE_XZQH", "行政区划树"), //yantao
                          COM_DIC_ECOINDUSTRY("COM_DIC_ECOINDUSTRY", "所属行业树"), //yantao
                          CORE_DEPTTYPE("CORE_DEPTTYPE", "条线部门树"), //yantao
                          CORE_ORGTYPE("CORE_ORGTYPE", "机构分类树");//yantao

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    TreeTypeEnum(String key, String value) {
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
