/*
 * module-authn - 动态认证对接模块
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
package net.linlan.authn.sms.cache;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import net.linlan.authn.sms.vo.SmsConfigVo;
import net.linlan.sys.web.RedisService;

/**
 * 短信平台 Cache
 *
 * @author Linlan
 * 
 */
@Service
@AllArgsConstructor
public class SmsConfigCache {
    private final RedisService redisCache;

    /**
     * 短信平台轮询KEY
     */
    private final String       SMS_ROUND_KEY      = "module_ext:sms:round";
    private final String       SMS_ROUND_CODE_KEY = "module_ext:sms:round:code";

    /**
     * 短信平台列表KEY
     */
    private final String       SMS_PLATFORM_KEY   = "module_ext:sms:providerName";

    /**
     * 获取短信轮询值
     * @return 轮询值
     */
    public Long getRoundValue() {
        return redisCache.incr(SMS_ROUND_KEY, 10);
    }

    /**
     * 获取短信编码轮询值
     * @return 轮询值
     */
    public Long getRoundCodeValue() {
        return redisCache.incr(SMS_ROUND_CODE_KEY, 10);
    }

    public List<SmsConfigVo> list() {
        return (List<SmsConfigVo>) redisCache.get(SMS_PLATFORM_KEY);
    }

    public void save(List<SmsConfigVo> list) {
        redisCache.set(SMS_PLATFORM_KEY, list);
    }

    public void delete() {
        redisCache.delete(SMS_PLATFORM_KEY);
    }
}
