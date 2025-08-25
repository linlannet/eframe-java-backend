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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * Filename:HttpContextUtils.java
 * Desc: 获取应用和工程上下文的request对象
 *
 * @author Linlan
 * CreateTime:2018/4/22 12:58
 *
 * @version 1.0
 * @since 1.0
 *
 */
public class HttpContextUtils {

    /**
     * www主域
     */
    public static final String  WWW       = "www";

    /**
     * http前缀
     */
    public static final String  HTTP      = "http";

    /**
     * https前缀
     */
    public static final String  HTTPS     = "https";

    /**
     * http请求
     */
    public static final String  URL_HTTP  = HTTP + "://";

    /**
     * https请求
     */
    private static final String URL_HTTPS = HTTPS + "://";

    /** get http servlet request
     * @return  HttpServletRequest
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
            .getRequest();
    }

    /** get the source domain
     * @return  域名
     */
    public static String getDomain() {
        HttpServletRequest request = getHttpServletRequest();
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    }

    /** get the source origin
     * @return  来源Origin
     */
    public static String getOrigin() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getHeader("Origin");
    }

    /** get http servlet response
     * @return  响应体
     */
    public static HttpServletResponse getHttpServletResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
            .getResponse();
    }

}
