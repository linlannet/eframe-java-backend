/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.comm.aspect;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import net.linlan.utils.exception.CommonException;

/**
 *
 * Filename:DataFilterAspect.java
 * Desc:数据过滤，切面处理类
 *
 * @author Linlan
 * CreateTime:2017/8/29 9:38
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Aspect
@Component
public class DataFilterAspect {

    @Pointcut("@annotation(net.linlan.commons.db.annotation.DataFilter)")
    public void dataFilterCut() {

    }

    @Before("dataFilterCut()")
    public void dataFilter(JoinPoint point) throws Throwable {
        Object params = point.getArgs()[0];
        if (params != null && params instanceof Map) {

            return;
        }

        throw new CommonException("要实现数据权限接口的参数，只能是Map类型，且不能为NULL");
    }

}
