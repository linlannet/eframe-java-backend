/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.dto;

import java.util.List;

/**
 * @author Linlan
 * Description layui树结构
 * CreateTime 2019/7/26
 */
public class LayuiTree {
    /**
     * 节点标题
     */
    private String          title;
    /**
     * 节点唯一索引，用于对指定节点进行各类操作
     */
    private String          id;
    /**
     * 父节点ID
     */
    private String          parentId;
    /**
     * 拓展id
     */
    private String          extId;
    /**
     * 点击节点弹出新窗口对应的 url。需开启 isJump 参数
     */
    private String          href;
    /**
     * 节点是否初始展开，默认 false
     */
    private Boolean         spread;
    /**
     * 节点是否初始为选中状态（如果开启复选框的话），默认 false
     */
    private Boolean         checked;
    /**
     * 节点是否为禁用状态。默认 false
     */
    private Boolean         disabled;
    private List<LayuiTree> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public List<LayuiTree> getChildren() {
        return children;
    }

    public void setChildren(List<LayuiTree> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public LayuiTree() {
    }

    public LayuiTree(String title, String id, String href, Boolean spread, Boolean checked,
                     Boolean disabled, List<LayuiTree> children) {
        this.title = title;
        this.id = id;
        this.href = href;
        this.spread = spread;
        this.checked = checked;
        this.disabled = disabled;
        this.children = children;
    }
}