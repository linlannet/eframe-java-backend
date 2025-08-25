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
package net.linlan.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.linlan.constant.LimitType;

/**
 * @author Linlan
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LimitScope {

    /**
     * 资源名称，用于描述接口功能
     * @return 资源名称
     */
    String name() default "";

    /**
     * 资源key
     * @return 资源key
     */
    String key() default "";

    /**
     * 资源prefix
     * @return 资源prefix
     */
    String prefix() default "limit";

    /**
     * 间隔时间(s)，小于此时间视为重复提交
     * @return 间隔时间
     */
    public int interval() default 60;

    /**
     * 限制访问次数
     * @return 限制访问次数
     */
    int count() default 10;

    /**
     * 限制类型，默认为USER
     * @return 限制类型
     */
    LimitType limitType() default LimitType.USER;

}
