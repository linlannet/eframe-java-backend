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

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;

import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.StringUtils;
import net.linlan.constant.LimitType;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.utils.exception.base.BaseException;
import net.linlan.utils.http.HttpContextUtils;
import net.linlan.utils.ip.IPUtils;

/**
 * @author Linlan
 */
@Aspect
@Component
public class LimitFilterAspect {

    private final RedisTemplate<Object, Object> redisTemplate;

    public LimitFilterAspect(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Pointcut("@annotation(net.linlan.annotation.LimitScope)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method signatureMethod = signature.getMethod();
        LimitScope limit = signatureMethod.getAnnotation(LimitScope.class);
        LimitType limitType = limit.limitType();
        String key = limit.key();
        if (limitType == LimitType.IPADDR) {
            key += "_" + IPUtils.getIpAddr(request);
        } else if (limitType == LimitType.USER) {
            key += "_" + SecurityUtils.getUserId();
        }
        ImmutableList<Object> keys = ImmutableList.of(StringUtils.join(limit.prefix(), "_", key,
            request.getRequestURI().replaceAll("/", "_"), "_", signatureMethod.getName()));

        String luaScript = buildLuaScript();
        RedisScript<Long> redisScript = new DefaultRedisScript<>(luaScript, Long.class);
        Number count = redisTemplate.execute(redisScript, keys, limit.count(), limit.interval());
        if (null != count && count.intValue() <= limit.count()) {
            return joinPoint.proceed();
        } else {
            throw new BaseException("您的访问频率过快，请稍后再试");
        }
    }

    /**
     * 限流脚本
     */
    private String buildLuaScript() {
        return "local c" + "\nc = redis.call('get',KEYS[1])"
               + "\nif c and tonumber(c) > tonumber(ARGV[1]) then" + "\nreturn c;" + "\nend"
               + "\nc = redis.call('incr',KEYS[1])" + "\nif tonumber(c) == 1 then"
               + "\nredis.call('expire',KEYS[1],ARGV[2])" + "\nend" + "\nreturn c;";
    }
}
