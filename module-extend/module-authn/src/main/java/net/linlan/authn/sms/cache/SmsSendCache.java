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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import net.linlan.sys.web.RedisService;

/**
 * 短信发送 Cache
 *
 * @author Linlan
 * 
 */
@Service
@AllArgsConstructor
public class SmsSendCache {

    @Resource
    private RedisService redisCache;

    /**
     * 获取发送手机短信验证码KEY
     *
     * @param mobile 手机号
     * @return KEY
     */
    private String getCodeKey(String mobile) {
        return SmsConfigCache.SMS_CODE_PREFIX + mobile;
    }

    public void saveCode(String mobile, String code) {
        String key = getCodeKey(mobile);

        // 保存到Redis，有效期10分钟
        redisCache.set(key, code, 10 * 60);
    }

    public String getCode(String mobile) {
        String key = getCodeKey(mobile);
        return (String) redisCache.get(key);
    }

    public void deleteCode(String mobile) {
        String key = getCodeKey(mobile);
        redisCache.delete(key);
    }
}
