/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.mbiz.result;

/**
 * BackResult视图域:返回信息视图实体类
 *
 * @author Linlan
 * CreateTime 2024-03-31 14:47:45
 * 
 */
public class BackResult {

    /**
     * 返回状态码:正常状态为0
     */
    private String code;
    /**
     * 返回标题
     */
    private String title;
    /**
     * 返回消息
     */
    private String msg;

    public BackResult() {
        super();
    }

    public BackResult(String code, String msg) {
        super();
        this.code = code;
        this.title = "服务中台返回信息";
        this.msg = msg;
    }

    public BackResult(String code, String title, String msg) {
        super();
        this.code = code;
        this.title = title;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.code = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}