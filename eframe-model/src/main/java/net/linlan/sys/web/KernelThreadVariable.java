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
package net.linlan.sys.web;

/**
 *
 * Filename:KernelThreadVariable.java
 * Desc:系统支撑的共用线程处理类，为需要进行共用缓存处理的提供统一的线程管理
 *
 * @author Linlan
 * CreateTime:2018/5/14 18:32
 *
 * @version 1.0
 * @since 1.0
 *
 */
public class KernelThreadVariable {

    /**
     * 当前登录系统的应用信息，appId
     */
    private static ThreadLocal<String> baseAppId = new ThreadLocal<>();

    public static String getBaseAppId() {
        return baseAppId.get();
    }

    public static void setBaseAppId(String appId) {
        baseAppId.set(appId);
    }

    public static void removeBaseAppId() {
        baseAppId.remove();
    }

}
