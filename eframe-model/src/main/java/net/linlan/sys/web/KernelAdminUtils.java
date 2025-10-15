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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import net.linlan.commons.core.StringUtils;

/**
 *
 * Filename:KernelAdminUtils.java
 * Desc:全局的管理工具类, 提供全局方法，如权限列表，避免总是从数据库内查询
 * 当人员重新登录时，更新该列表
 *
 * @author Linlan
 * CreateTime:2018/6/8 16:55
 *
 * @version 1.0
 * @since 1.0
 *
 */
public class KernelAdminUtils {

    /**  加密算法 */
    public final static String hashAlgorithmName = "SHA-256";
    /**  循环次数 */
    public final static int    hashIterations    = 16;

    /** 对params对象进行处理，确定是否需要增加appId的条件
     * 如果params内包含appId条件，则沿用原appId
     * 当条件内没有appId时，通过线程内获取当前应用的appId，然后进行处理
     * 此时appId为产品域时,不对appId做任何条件处理
     * 当传入的appId为非产品域时,此时表示,只查询此应用的相关资源,即某一个具体项目的资源
     * 如果原有params内包含appId，则覆盖，没有则添加appId的新条件
     * @param params         查询参数
     * @return 配置信息
     */
    public static Map<String, Object> getAppIdByEnv(Map<String, Object> params) {
        String appId = KernelThreadVariable.getBaseAppId();
        if (StringUtils.isNotBlank(appId)) {
            if (appId.contains(KernelConstant.DEFAULT_APP_PREFIX)) {
                //可能原params内包含appId的条件，满足产品条件时，什么都不做
            } else {
                params.put("appId", appId);
            }
        }
        return params;
    }

    //    public static String sha256(String password, String salt) {
    //        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    //    }

    //    public static Subject getSubject() {
    //        return SecurityUtils.getSubject();
    //    }
    //
    //    public static Session getSession() {
    //        return getSubject().getSession();
    //    }
    //
    //    public static void setSessionAttribute(Object key, Object value) {
    //        getSession().setAttribute(key, value);
    //    }
    //
    //    public static Object getSessionAttribute(Object key) {
    //        return getSession().getAttribute(key);
    //    }

    //    /** 后台管理权限列表，为避免每次都进行数据库菜单读取，进行统一管理 */
    //    private static Set<String> permissions = new HashSet<>();
    //
    //    public static Set<String> getPermissions(){
    //        return permissions;
    //    }
    //
    //    public static void setPermissions(Collection<GrantedAuthority> authorities){
    //        permissions.addAll(perms);
    //    }

    /**
     * 处理删除标志，如果没有值，默认为0
     * @param params    查询参数
     * @return  查询结果
     */
    public static Map<String, Object> dealDelFlagParam(Map<String, Object> params) {
        if (!params.containsKey(KernelConstant.FIELD_DEL_FLAG)) {
            params.put(KernelConstant.FIELD_DEL_FLAG, KernelConstant.DEL_FLAG_DEFAULT);
        }
        return params;
    }

    /**
     * 是否禁用标记，如果没有值，默认为false
     * @param params    查询参数
     * @return  查询结果
     */
    public static Map<String, Object> dealIsDisabledParam(Map<String, Object> params) {
        if (!params.containsKey(KernelConstant.FIELD_IS_DISABLED)) {
            params.put(KernelConstant.FIELD_IS_DISABLED, KernelConstant.DEFAULT_DISABLED);
        }
        return params;
    }

    /**
     * 是否默认缺省标记，如果没有值，默认为true
     * @param params    查询参数
     * @return  查询结果
     */
    public static Map<String, Object> dealIsDefaultParam(Map<String, Object> params) {
        if (!params.containsKey(KernelConstant.FIELD_IS_DEFAULT)) {
            params.put(KernelConstant.FIELD_IS_DEFAULT, !KernelConstant.DEFAULT_DISABLED);
        }
        return params;
    }

    /**
     * 是否显示标记，如果没有值，默认为true
     * @param params    查询参数
     * @return  查询结果
     */
    public static Map<String, Object> dealIsDisplayParam(Map<String, Object> params) {
        if (!params.containsKey(KernelConstant.FIELD_IS_DISPLAY)) {
            params.put(KernelConstant.FIELD_IS_DISPLAY, !KernelConstant.DEFAULT_DISABLED);
        }
        return params;
    }

    /**
     * 是否显示标记，如果没有值，默认为true
     * @param params    查询参数
     * @return  查询结果
     */
    public static Map<String, Object> dealStatusParam(Map<String, Object> params) {
        if (!params.containsKey(KernelConstant.FIELD_STATUS)) {
            params.put(KernelConstant.FIELD_STATUS, KernelConstant.DEFAULT_STATUS);
        }
        return params;
    }

    /**
     * 站点接口的api前缀
     */
    public static final String SITE_API_PREFIX    = "api.";

    /**
     * 站点接口的api前缀
     */
    public static final String REQUEST_API_PREFIX = "api/";

    /**
     * 获取域名
     * @param reqUrl 请求URL
     * @return request内的domain
     */
    public static String getDomain(String reqUrl) {
        String domain = "";
        if (StringUtils.isNotBlank(reqUrl)) {
            URL url = null;
            try {
                url = new URL(reqUrl);
                domain = url.getHost();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        return domain;
    }

    public static String getDomainMore(String reqUrl) {
        String domain = "";
        if (StringUtils.isNotBlank(reqUrl)) {
            URL url = null;
            try {
                url = new URL(reqUrl);
                domain = url.getHost();
                int port = url.getPort();
                //如果域名内包含api，则进行分段截取，否则，直接返回域名
                if (domain.contains(SITE_API_PREFIX)) {
                    domain = domain.replace(SITE_API_PREFIX, "");
                }
                String path = url.getPath();
                if (StringUtils.isNotBlank(path)) {
                    //判断是否为api相关的后续路径，则截取到api/的前面
                    if (path.contains(REQUEST_API_PREFIX)) {
                        path = path.substring(0, path.indexOf(REQUEST_API_PREFIX) - 1);
                    }
                    //判断是否为国际化相关的后续路径
                    String langsId = "";
                    String[] paths = path.split("/");
                    List<String> pathList = Arrays.asList(paths);
                    if (null != pathList && pathList.size() > 0) {
                        for (int i = 0; i < pathList.size(); i++) {
                            langsId = pathList.get(i);
                            if (StringUtils.isNotBlank(langsId)) {
                                if (reqLangs().contains(langsId)) {
                                    path = path.replace(langsId, "");
                                }
                            }
                        }
                    }
                    // 访问默认80端口时 URL类获取的port端口号是默认值-1  需要单独判断一下
                    if (port == -1) {
                        domain = domain + path.replace("//", "/");
                    } else {
                        domain = domain + ":" + port + path.replace("//", "/");
                    }
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        return domain;
    }

    /**
     * 获取请求url类型以及path
     * @param reqUrl    请求URL
     * @param prefixField：过滤字符串
     * @return    返回结果
     */
    public static Map<String, String> getUrlTypeAndPath(String reqUrl, String prefixField) {
        String reqType = "";
        StringBuffer reqPath = new StringBuffer();
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isNotBlank(reqUrl)) {
            URL url = null;
            try {
                url = new URL(reqUrl);
                String path = url.getPath();
                if (StringUtils.isNotBlank(path) && !path.equals("/")) {
                    if (path.startsWith("/")) {
                        path = path.substring(1, path.length());
                        //处理过滤字符串
                        if (StringUtils.isNotBlank(prefixField)) {
                            path = path.substring(prefixField.length() + 1, path.length());
                        }
                        String[] paths = path.split("/");
                        List<String> pathList = Arrays.asList(paths);
                        reqType = paths[0];
                        if (pathList.size() > 1) {
                            pathList = removeListElement(pathList, reqType);
                            if (pathList != null && pathList.size() > 0) {
                                for (int i = 0; i < pathList.size(); i++) {
                                    reqPath.append("/").append(pathList.get(i));
                                }
                            }
                        }
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        map.put("type", reqType);
        map.put("path", reqPath.toString());
        return map;
    }

    /**
     * 请求语种，非规定的语种开头的，全部默认cn中文
     * @return    返回结果List
     */
    public static List<String> reqLangs() {
        List<String> reqLangList = new ArrayList<>();
        reqLangList.add("cn");
        reqLangList.add("en");
        return reqLangList;
    }

    /**
     * 移除list中某个元素
     * @param list  输入list
     * @param element   移除元素
     * @return    返回结果List
     */
    public static List<String> removeListElement(List<String> list, String element) {
        List<String> result = new ArrayList<>();
        if (null != list && null != element) {
            for (int i = 0; i < list.size(); i++) {
                if (!element.equals(list.get(i))) {
                    result.add(list.get(i));
                }
            }
        }
        return result;
    }

}
