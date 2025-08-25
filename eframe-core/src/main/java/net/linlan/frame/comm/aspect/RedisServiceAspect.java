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

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import net.linlan.utils.exception.CommonException;

/**
 * the class of redis aspect
 * Filename:RedisAspect.java
 * Desc: the redis aspect class
 * 通过配置文件内的开启状态，执行是否需要保存到Redis服务器的操作
 *
 * @author Linlan
 * CreateTime:2017/10/25 20:01
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Aspect
@Configuration
public class RedisServiceAspect {
    private Logger  logger = LoggerFactory.getLogger(getClass());
    //是否开启redis缓存  true开启   false关闭
    @Value("${platform.redis.open}")
    private boolean open;

    @Around("execution(* net.linlan.sys.web.RedisService.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if (open) {
            try {
                result = point.proceed();
                //System.out.println("-------redis aspect-------");

            } catch (Exception e) {
                logger.error("redis error", e);
                throw new CommonException("Redis服务异常");
            }
        }
        return result;
    }

}
