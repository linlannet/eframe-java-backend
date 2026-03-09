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

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.linlan.commons.core.StringUtils;

/**
 * http请求处理工具类
 * @author Linlan
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpRequestUtils {

    /**
     * 获取request中的参数集合转对象
     *
     * @param request 请求
     * @param obj   obj对象
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
     *
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
     * 获取request中请求头的参数集合转Map
     *
     * @param request {@link HttpServletRequest}
     * @return {@link Map}
     */
    public static Map<String, String> getRequestHeaders(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(16);
        Enumeration<String> paramNames = request.getHeaderNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getHeader(paramName);
            if (!StringUtils.isBlank(paramValue)) {
                map.put(paramName, paramValue);
            }
        }
        return map;
    }

    /**
     * get Request Parameter by name.
     *
     * @param request 请求
     * @param name String
     * @return String
     */
    public static String getParameter(HttpServletRequest request, String name) {
        return request.getParameter(name);
    }

    /**
     * get Request Parameter by name.
     *
     * @param name String
     * @return String
     */
    public static String getParameter(String name) {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        return getParameter(request, name);
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
     * 保存Cookies.
     *
     * @param response response响应
     * @param name     cookie的名字
     * @param value    cookie的值
     * @param path     paht路径
     * @param time     cookie的存在时间
     * @return  HttpServletResponse
     */
    public static HttpServletResponse setCookie(HttpServletResponse response, String name,
                                                String value, String path, int time) {
        // new一个Cookie对象,键值对为参数
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
        try {
            URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 单位：秒
        cookie.setMaxAge(time);
        // 将Cookie添加到Response中,使之生效
        // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
        response.addCookie(cookie);
        return response;
    }

    /**
     **把request转换成json数据
     * @param request HttpServletRequest
     * @return  body的string
     */
    public static String getBody(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     **把request转换成xml数据
     * @param request HttpServletRequest
     * @param clazz     类对象
     * @param <T>   泛型
     * @return  xml对象
     * @throws JAXBException    异常
     */
    public static <T> T getXml(HttpServletRequest request, Class<T> clazz) throws JAXBException {
        String body = getBody(request);
        StringReader reader = new StringReader(body);
        return (T) JAXBContext.newInstance(clazz).createUnmarshaller().unmarshal(reader);
    }

    /**
     **把request转换成map数据
     * @param request HttpServletRequest
     * @return  map对象
     */
    public static Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>(16);
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String[] values = entry.getValue();
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                    : valueStr + values[i] + ",";
            }
            params.put(entry.getKey(), valueStr);
        }
        return params;
    }

    public static MultiValueMap<String, String> getQueryParameters(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>(parameterMap.size());
        parameterMap.forEach((key, values) -> {
            if (values.length > 0) {
                for (String value : values) {
                    parameters.add(key, value);
                }
            }
        });
        return parameters;
    }

    /**
     * @param request    请求
     * @return      form表单参数对
     */
    public static MultiValueMap<String, String> getFormParameters(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>(parameterMap.size());
        parameterMap.forEach((key, values) -> {
            if (values.length > 0) {
                for (String value : values) {
                    parameters.add(key, value);
                }
            }
        });
        return parameters;
    }

}
