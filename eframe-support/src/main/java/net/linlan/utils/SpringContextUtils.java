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
package net.linlan.utils;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import net.linlan.commons.core.ObjectUtils;

/**
 * Spring Context 工具类, 在非spring管理环境中获取bean
 *
 * @author Linlan
 * CreateTime 2017-08-29 23:45:51
 */
@Component
public class SpringContextUtils implements BeanFactoryPostProcessor, ApplicationContextAware {

    /**
     * Spring应用上下文环境
     */
    private static ConfigurableListableBeanFactory beanFactory;
    /**
     * Spring应用上下文
     */
    public static ApplicationContext               applicationContext;

    /**
     * @param beanFactory   配置工厂
     * @throws BeansException   异常
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringContextUtils.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    /**
     * 获取对象
     *
     * @param name  名称
     * @param <T>   泛型类型
     * @return Object 一个以所给名字注册的bean的实例
     * @throws org.springframework.beans.BeansException 异常
     */
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * @param name  名称
     * @param requiredType  所需类型
     * @param <T>   泛型类型
     * @return  Object 一个以所给名字注册的bean的实例
     */
    public static <T> T getBean(String name, Class<T> requiredType) {
        return (T) beanFactory.getBean(name, requiredType);
    }

    /**
     * 获取类型为requiredType的对象
     *
     * @param       clazz 对象
     * @param <T>   泛型类型
     * @return      Object 一个以所给名字注册的bean的实例
     * @throws org.springframework.beans.BeansException 异常
     *
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        T result = (T) beanFactory.getBean(clazz);
        return result;
    }

    /**
     * 是否包含bean
     * @param name  名称
     * @return  是否包含，true，false
     */
    public static boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

    /**
     * 是否单例
     * @param name  名称
     * @return  是否单例，true，false
     */
    public static boolean isSingleton(String name) {
        return beanFactory.isSingleton(name);
    }

    public static Class<? extends Object> getType(String name) {
        return beanFactory.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name  名称
     * @return  数值对应的别名
     * @throws org.springframework.beans.factory.NoSuchBeanDefinitionException  异常
     *
     */
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.getAliases(name);
    }

    /**
     * 获取aop代理对象
     *
     * @param invoker   请求
     * @param <T>   泛型类型
     * @return  代理对象
     */
    public static <T> T getAopProxy(T invoker) {
        return (T) AopContext.currentProxy();
    }

    /**
     * 获取当前的环境配置，无配置返回null
     *
     * @return 当前的环境配置
     */
    public static String[] getActiveProfiles() {
        return applicationContext.getEnvironment().getActiveProfiles();
    }

    /**
     * 获取当前的环境配置，当有多个环境配置时，只获取第一个
     *
     * @return 当前的环境配置
     */
    public static String getActiveProfile() {
        final String[] activeProfiles = getActiveProfiles();
        return ObjectUtils.isNotEmpty(activeProfiles) ? activeProfiles[0] : null;
    }

    /**
     * 获取配置文件中的值
     *
     * @param key 配置文件的key
     * @return 当前的配置文件的值
     *
     */
    public static String getRequiredProperty(String key) {
        return applicationContext.getEnvironment().getRequiredProperty(key);
    }

}
