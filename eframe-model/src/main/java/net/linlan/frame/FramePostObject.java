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
package net.linlan.frame;

import com.alibaba.fastjson2.JSONObject;

/**
 *
 * Filename:FramePostObject.java
 * Desc: 公共应用支撑的POST对象
 *
 * @author Linlan
 * CreateTime:3/28/19 6:52 PM
 *
 * @version 1.0
 * @since 1.0
 *
 */

public class FramePostObject {
    /**
     * ServerCode，用户入口的服务代码
     */
    private String     servCode;
    /**
     * 服务的业务来源
     */
    private String     source;
    /**
     * 服务代码的业务类型
     */
    private String     type;
    /**
     * 用户的服务代码的操作类型
     */
    private String     actionType;
    /**
     * 用户的JSON对象数据类型
     */
    private String     jsonType;
    /**
     *  输入的内容，JSON对象
     */
    private JSONObject json;

    public FramePostObject() {

    }

    public FramePostObject(String servCode, String type, String actionType, JSONObject json) {
        this.servCode = servCode;
        this.type = type;
        this.actionType = actionType;
        this.json = json;
    }

    public FramePostObject(String servCode, String source, String type, String actionType,
                           JSONObject json) {
        this.servCode = servCode;
        this.source = source;
        this.type = type;
        this.actionType = actionType;
        this.json = json;
    }

    public FramePostObject(String servCode, String source, String type, String actionType,
                           String jsonType, JSONObject json) {
        this.servCode = servCode;
        this.source = source;
        this.type = type;
        this.actionType = actionType;
        this.jsonType = jsonType;
        this.json = json;
    }

    public String getServCode() {
        return servCode;
    }

    public void setServCode(String servCode) {
        this.servCode = servCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getJsonType() {
        return jsonType;
    }

    public void setJsonType(String jsonType) {
        this.jsonType = jsonType;
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

}
