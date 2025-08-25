/*
 * module-quartz - quartz定时任务模块
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
package net.linlan.sys.job.utils;

import java.lang.reflect.Method;

import org.springframework.util.ReflectionUtils;

import net.linlan.commons.core.StringUtils;
import net.linlan.utils.SpringContextUtils;
import net.linlan.utils.exception.CommonException;

/**
 *
 * Filename:ScheduleRunnable.java
 * Desc:定时任务执行类
 *
 * @author Linlan
 * CreateTime:2017/7/14 12:08
 *
 * @version 1.0
 * @since 1.0
 *
 */
public class ScheduleRunnable implements Runnable {
    /**
     * 调度作用域，具体某一个appId
     */
    private String appId;
    /**
     * 调度作业的入口对象，为编写的Component注解对象名称
     */
    private Object target;
    /**
     * 调度作业入口对象中的具体方法
     */
    private Method method;
    /**
     * 调度作业携带的参数
     */
    private String params;

    public ScheduleRunnable(String appId, String objectName, String methodName,
                            String params) throws NoSuchMethodException, SecurityException {
        this.appId = appId;
        this.target = SpringContextUtils.getBean(objectName);
        this.params = params;

        if (StringUtils.isNotBlank(params)) {
            if (StringUtils.isNotBlank(appId)) {
                this.method = target.getClass().getDeclaredMethod(methodName, String.class,
                    String.class);
            } else {
                this.method = target.getClass().getDeclaredMethod(methodName, String.class);
            }
        } else {
            if (StringUtils.isNotBlank(appId)) {
                this.method = target.getClass().getDeclaredMethod(methodName, String.class);
            } else {
                this.method = target.getClass().getDeclaredMethod(methodName);
            }
        }
    }

    @Override
    public void run() {
        try {
            ReflectionUtils.makeAccessible(method);
            if (StringUtils.isNotBlank(params)) {
                method.invoke(target, appId, params);
            } else {
                method.invoke(target, appId);
            }
        } catch (Exception e) {
            throw new CommonException("执行定时任务失败");
        }
    }

}
