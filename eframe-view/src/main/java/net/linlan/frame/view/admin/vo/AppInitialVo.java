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
package net.linlan.frame.view.admin.vo;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import lombok.Data;

/**
 *
 * SasOrganPreset视图域:应用初始化导出导入包装Vo类
 * @author Linlan
 * CreateTime 2023-09-19 10:47:26
 *
 */
@Data
public class AppInitialVo {
    /**
     * 应用ID，导入和导出的APPID
     */
    private String     id;
    /**
     * 菜单JSON对象
     */
    private JSONArray  menuJsons;
    /**
     * 初始化JSON对象
     */
    private JSONObject initJson;
    /**
     * 初始化用户名
     */
    private String     username;
    /**
     * 初始化密码
     */
    private String     password;
    /**
     * 导入的文件路径
     */
    private String     initPath;
}
