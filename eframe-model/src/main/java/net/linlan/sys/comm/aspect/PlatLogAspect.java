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
package net.linlan.sys.comm.aspect;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson2.JSON;

import net.linlan.commons.core.ArrayUtils;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.script.json.JsonUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.sys.comm.entity.CommLog;
import net.linlan.sys.comm.service.CommLogService;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.http.HttpContextUtils;
import net.linlan.utils.ip.IPUtils;

/**
 *
 * Filename PlatLogAspect,切面控制:会员日志控制切面类
 * 会员日志，切面处理类
 *  * 应用方法：在Controller上添加@PlatLog即可
 * @author Linlan
 * CreateTime 2023-07-29 9:39
 *
 */
@Aspect
@Component
public class PlatLogAspect {
    /**
     * 切面PlatLog日志是否保存在管理日志中，默认为true，如果不保存设置变量为false
     */
    @Value("${platform.frame.saveCommLog:true}")
    private boolean              saveCommLog;

    /** 排除敏感属性字段 */
    public static final String[] EXCLUDE_PROPERTIES = { "password", "oldPassword", "newPassword",
                                                        "confirmPassword" };

    @Resource
    private CommLogService       commLogService;

    @Pointcut("@annotation(net.linlan.commons.core.annotation.PlatLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //默认为保存，如果不需要保存操作日志，则配置变量为false，不保存日志
        if (saveCommLog) {
            long beginTime = System.currentTimeMillis();
            //执行方法
            Object result = point.proceed();
            //执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;

            //保存日志
            savePlatLog(point, time);

            return result;
        }
        return null;
    }

    private void savePlatLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CommLog commLog = new CommLog();
        PlatLog memberLog = method.getAnnotation(PlatLog.class);
        if (memberLog != null) {
            //注解上的描述
            commLog.setOperation(memberLog.value());
            //add 20240510，拦截中增加category变量，存入日志分类中
            commLog.setCategory(memberLog.category());
            commLog.setSrcCode(memberLog.srcCode());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        commLog.setMethod(className + "." + methodName + "()");

        //请求的参数
        String args = argsArrayToString(joinPoint.getArgs(), memberLog.excludeParamNames());
        try {
            String params = JsonUtils.toJson(args);

            //当数据中为树状结构时，该信息值将会很大，考虑到数据库内存储，进行截取
            int endLength = params.length();
            if (endLength > 666) {
                endLength = 666;
            }
            commLog.setParams(params.substring(0, endLength));
        } catch (Exception e) {

        }

        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        commLog.setIp(IPUtils.getIpAddr(request));

        //20240511，进行request内传递使用
        FrameUserDetails user = SecurityUtils.getLoginUser();
        if (user != null) {
            commLog.setUsername(user.getUsername());
        } else {
            commLog.setUsername("member_noToken");
        }
        commLog.setAppId(Constants.ENT_APP_ID);
        commLog.setTime(time);
        //保存系统日志
        commLogService.save(commLog);
    }

    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray, String[] excludeParamNames) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (ObjectUtils.isNotEmpty(o) && !isFilterObject(o)) {
                    try {
                        String jsonObj = JSON.toJSONString(o,
                            excludePropertyPreFilter(excludeParamNames));
                        params += jsonObj.toString() + " ";
                    } catch (Exception e) {
                    }
                }
            }
        }
        return params.trim();
    }

    /**
     * 忽略敏感属性
     * @param excludeParamNames  排除的参数名
     * @return 忽略敏感属性
     */
    public PropertyPreExcludeFilter excludePropertyPreFilter(String[] excludeParamNames) {
        return new PropertyPreExcludeFilter()
            .addExcludes(ArrayUtils.addAll(EXCLUDE_PROPERTIES, excludeParamNames));
    }

    /**
     * 判断是否需要过滤的对象。
     *
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    public boolean isFilterObject(final Object o) {
        Class<?> clazz = o.getClass();
        if (clazz.isArray()) {
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            Collection collection = (Collection) o;
            for (Object value : collection) {
                return value instanceof MultipartFile;
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            Map map = (Map) o;
            for (Object value : map.entrySet()) {
                Map.Entry entry = (Map.Entry) value;
                return entry.getValue() instanceof MultipartFile;
            }
        }
        return o instanceof MultipartFile || o instanceof HttpServletRequest
               || o instanceof HttpServletResponse || o instanceof BindingResult;
    }

}
