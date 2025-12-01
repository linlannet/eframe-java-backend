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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import static org.springframework.http.HttpMethod.GET;

import static net.linlan.commons.core.abs.StringConstants.COLON;

/**
 * 
 * 获取应用和工程上下文的request对象
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

    /**
     * get current Session.
     *
     * @return HttpSession
     */
    public static HttpSession getSession() {
        return getHttpServletRequest().getSession();
    }

    /**
     * get current Session,if no session ,new Session created.
     * @param   create      是否创建
     * @return HttpSession
     */
    public static HttpSession getSession(boolean create) {
        return getHttpServletRequest().getSession(create);
    }

    /**
     * set Attribute to session ,Attribute name is name,value is value.
     *
     * @param name  String
     * @param value String
     */
    public static void setAttribute(String name, Object value) {
        getSession().setAttribute(name, value);
    }

    /**
     * get Attribute from session by name.
     *
     * @param name String
     * @return {@link Object}
     */
    public static Object getAttribute(String name) {
        return getSession().getAttribute(name);
    }

    /**
     * remove Attribute from session by name.
     *
     * @param name String
     */
    public static void removeAttribute(String name) {
        getSession().removeAttribute(name);
    }

    /**
     * 根据名字获取cookie.
     *
     * @param request HttpServletRequest
     * @param name    cookie名字
     * @return Cookie
     */
    public static Cookie readCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieAll(request);
        return cookieMap.getOrDefault(name, null);
    }

    /**
     * 将cookie封装到Map里面.
     *
     * @param request HttpServletRequest
     * @return Map
     */
    private static Map<String, Cookie> readCookieAll(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>(16);
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * get Request Parameter by name.
     *
     * @param name String
     * @return String
     */
    public static String getParameter(String name) {
        return getHttpServletRequest().getParameter(name);
    }

    /**
     * 获取request中的参数集合转对象
     * 用法：User user = (User) RequestUtil.getParameterObject(request, new User())
     *
     * @param request 请求
     * @param obj obj对象
     * @return {@link Object}
     */
    public static Object getParameterObject(HttpServletRequest request, Object obj) {
        Map<String, String> map = getParameterMap(request);
        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(obj);
        wrapper.setAutoGrowNestedPaths(true);
        wrapper.setPropertyValues(map);
        return wrapper.getWrappedInstance();
    }

    /**
     * 获取request中的参数集合转Map
     * @param request {@link HttpServletRequest}
     * @return {@link Map}
     */
    public static Map<String, String> getParameterMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(16);
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        return map;
    }

    /**
     * 保存Cookies.
     *
     * @param response response响应
     * @param name     cookie的名字
     * @param value    cookie的值
     * @param path     路径
     * @param time     cookie的存在时间
     * @return HttpServletResponse
     * @throws UnsupportedEncodingException 异常
     */
    public static HttpServletResponse setCookie(HttpServletResponse response, String name,
                                                String value, String path,
                                                int time) throws UnsupportedEncodingException {
        // new一个Cookie对象,键值对为参数
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
        URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        // 单位：秒
        cookie.setMaxAge(time);
        // 将Cookie添加到Response中,使之生效
        // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
        response.addCookie(cookie);
        return response;
    }

    /**
     * 获取
     *
     * @param request {@link HttpServletRequest}
     * @return {@link String}
     */
    public static String getServerRootPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + COLON
               + request.getServerPort() + request.getContextPath() + "/";
    }

    /**
     * Accept  包含  TEXT_HTML
     *
     * @param request {@link HttpServletRequest}
     * @return {@link Boolean}
     */
    public static boolean acceptIncludeTextHtml(HttpServletRequest request) {
        for (MediaType mediaType : getAcceptedMediaTypes(request)) {
            if (mediaType.includes(MediaType.TEXT_HTML)) {
                return true;
            }
        }
        return false;
    }

    private static final List<MediaType> MEDIA_TYPES_ALL = Collections.singletonList(MediaType.ALL);

    /**
     * 获取 MediaType List
     *
     * @param request {@link HttpServletRequest}
     * @return {@link List}
     */
    public static List<MediaType> getAcceptedMediaTypes(HttpServletRequest request) {
        String acceptHeader = request.getHeader(HttpHeaders.ACCEPT);
        if (org.springframework.util.StringUtils.hasText(acceptHeader)) {
            return MediaType.parseMediaTypes(acceptHeader);
        }
        return MEDIA_TYPES_ALL;
    }

    /**
     * 构造
     *
     * @param request {@link HttpServletRequest}
     * @return {@link JSONObject}
     * @throws IOException IOException
     */
    public static JSONObject getRequestJsonObject(HttpServletRequest request) throws IOException {
        String json = getRequestJsonString(request);
        return JSON.parseObject(json);
    }

    /***
     * 获取 request 中 json 字符串的内容
     *
     * @param request {@link HttpServletRequest}
     * @return : String类型的JSON字符串
     * @throws IOException IOException
     */
    public static String getRequestJsonString(HttpServletRequest request) throws IOException {
        String submitMethod = request.getMethod();
        // GET
        if (GET.name().equals(submitMethod)) {
            return new String(request.getQueryString().getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8).replaceAll("%22", "\"");
        }
        // POST
        else {
            return getRequestPostStr(request);
        }
    }

    /**
     * 描述:获取 post 请求的 byte[] 数组
     *
     * @param request {@link HttpServletRequest}
     * @return {@link Byte}
     * @throws IOException IOException
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte[] buffer = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int read = request.getInputStream().read(buffer, i, contentLength - i);
            if (read == -1) {
                break;
            }
            i += read;
        }
        return buffer;
    }

    /**
     * 描述:获取 post 请求内容
     *
     * @param request {@link HttpServletRequest}
     * @return {@link  String}
     * @throws IOException IOException
     */
    public static String getRequestPostStr(HttpServletRequest request) throws IOException {
        byte[] buffer = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer != null ? buffer : new byte[0], charEncoding);
    }

    @SuppressWarnings("AlibabaUndefineMagicConstant")
    public static Map<String, String> getParameterForUrl(String url) {
        Map<String, String> map = new HashMap<>(16);
        try {
            url = URLDecoder.decode(url, StandardCharsets.UTF_8.name());
            if (url.indexOf('?') != -1) {
                final String contents = url.substring(url.indexOf('?') + 1);
                String[] keyValues = contents.split("&");
                for (String keyValue : keyValues) {
                    String key = keyValue.substring(0, keyValue.indexOf("="));
                    String value = keyValue.substring(keyValue.indexOf("=") + 1);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static boolean isHtmlRequest(HttpServletRequest request) {
        return request.isRequestedSessionIdFromURL();
    }

}
