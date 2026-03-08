/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.manage.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import me.zhyd.oauth.model.AuthUser;
import net.linlan.utils.constant.CacheConstants;

/**
 * 融合用户授权服务类
 *
 * @author Linlan
 */
@Service
public class JustAuthUserService {

    @Resource
    private RedisTemplate                                 redisTemplate;

    private BoundHashOperations<String, String, AuthUser> valueOperations;

    @PostConstruct
    public void init() {
        valueOperations = redisTemplate.boundHashOps(CacheConstants.THIRD_KEY + "justauth:users");
    }

    public AuthUser saveToRedis(AuthUser user) {
        valueOperations.put(user.getUuid(), user);
        return user;
    }

    public AuthUser getByUuid(String uuid) {
        Object user = valueOperations.get(uuid);
        if (null == user) {
            return null;
        }
        return JSONObject.parseObject(JSONObject.toJSONString(user), AuthUser.class);
    }

    public List<AuthUser> listAuthUser() {
        return new LinkedList<>(Objects.requireNonNull(valueOperations.values()));
    }

    public void removeFromRedis(String uuid) {
        valueOperations.delete(uuid);
    }
}
