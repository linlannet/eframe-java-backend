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
package net.linlan.utils.http;

/**
 * 返回状态码
 * 
 * @author Linlan
 */
public class HttpStatus {
    /**
     * 操作成功
     */
    public static final int SUCCESS          = 200;

    /**
     * 对象创建成功
     */
    public static final int CREATED          = 201;

    /**
     * 请求已经被接受
     */
    public static final int ACCEPTED         = 202;

    /**
     * 操作已经执行成功，但是没有返回数据
     */
    public static final int NO_CONTENT       = 204;

    /**
     * 资源已被移除
     */
    public static final int MOVED_PERM       = 301;

    /**
     * 重定向
     */
    public static final int SEE_OTHER        = 303;

    /**
     * 资源没有被修改
     */
    public static final int NOT_MODIFIED     = 304;

    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    public static final int BAD_REQUEST      = 400;

    /**
     * 未授权
     */
    public static final int UNAUTHORIZED     = 401;

    /**
     * 访问受限，授权过期
     */
    public static final int FORBIDDEN        = 403;

    /**
     * 资源，服务未找到
     */
    public static final int NOT_FOUND        = 404;

    /**
     * 不允许的http方法
     */
    public static final int BAD_METHOD       = 405;

    /**
     * 资源冲突，或者资源被锁
     */
    public static final int CONFLICT         = 409;

    /**
     * 不支持的数据，媒体类型
     */
    public static final int UNSUPPORTED_TYPE = 415;

    /**
     * 用户不存在
     */
    public static final int USER_NO_EXIST    = 450;

    /**
     * 系统内部错误
     */
    public static final int ERROR            = 500;

    /**
     * 接口未实现
     */
    public static final int NOT_IMPLEMENTED  = 501;

    /**
     * 不弹窗显示
     */
    public static final int NO_MESSAGE_ALERT = 502;

    /**
     * 系统警告消息
     */
    public static final int WARN             = 601;
}
