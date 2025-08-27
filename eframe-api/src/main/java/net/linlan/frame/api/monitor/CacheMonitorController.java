/*
 * eframe-api - api接口网关模块
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
package net.linlan.frame.api.monitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.view.admin.vo.SysCacheVo;
import net.linlan.utils.constant.CacheConstants;

/**
 * 缓存监控
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/monitor/")
public class CacheMonitorController {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    private final static List<SysCacheVo> caches = new ArrayList<SysCacheVo>();
    {

        caches.add(new SysCacheVo(CacheConstants.LOGIN_TOKEN_KEY, "用户信息"));
        caches.add(new SysCacheVo(CacheConstants.CAPTCHA_CODE_KEY, "验证码"));
        caches.add(new SysCacheVo(CacheConstants.REPEAT_SUBMIT_KEY, "防重提交"));
        caches.add(new SysCacheVo(CacheConstants.RATE_LIMIT_KEY, "限流处理"));
        caches.add(new SysCacheVo(CacheConstants.PWD_ERR_CNT_KEY, "密码错误次数"));
        caches.add(new SysCacheVo(CacheConstants.PLAT_ACCOUNT_KEY, "平台账户"));

        caches.add(new SysCacheVo(CacheConstants.LOGIN_ADMIN_ID_KEY, "管理账号LID"));
        caches.add(new SysCacheVo(CacheConstants.LOGIN_USER_ID_KEY, "用户ID"));

        caches.add(new SysCacheVo(CacheConstants.LOCK_KEY, "锁定缓存前缀"));
        caches.add(new SysCacheVo(CacheConstants.BASE_CONFIGWHOLE_KEY, "配置信息"));
        caches.add(new SysCacheVo(CacheConstants.BASE_DICTIONARY_KEY, "数据字典"));
    }

    /**
     * 获取缓存信息列表
     * @return 缓存列表
     * @throws Exception    异常
     */
    @PlatLog(value = "获取缓存信息列表")
    @PreAuthorize("@ss.hasPerms('monitor:cache:list')")
    @GetMapping("cache")
    public ResponseResult<Map<String, Object>> getInfo() throws Exception {
        Properties info = (Properties) redisTemplate
            .execute((RedisCallback<Object>) connection -> connection.info());
        Properties commandStats = (Properties) redisTemplate
            .execute((RedisCallback<Object>) connection -> connection.info("commandstats"));
        Object dbSize = redisTemplate
            .execute((RedisCallback<Object>) connection -> connection.dbSize());

        Map<String, Object> result = new HashMap<>(3);
        result.put("info", info);
        result.put("dbSize", dbSize);

        List<Map<String, String>> pieList = new ArrayList<>();
        commandStats.stringPropertyNames().forEach(key -> {
            Map<String, String> data = new HashMap<>(2);
            String property = commandStats.getProperty(key);
            data.put("name", StringUtils.remove(key, "cmdstat_"));
            data.put("value", StringUtils.substringBetween(property, "calls=", ",usec"));
            pieList.add(data);
        });
        result.put("commandStats", pieList);
        return ResponseResult.ok(result);
    }

    /**
     * 通过名称前缀获取缓存信息列表
     * @return 缓存列表
     *
     */
    @PlatLog(value = "通过名称前缀获取缓存信息列表")
    @PreAuthorize("@ss.hasPerms('monitor:cache:list')")
    @GetMapping("cache/getNames")
    public ResponseResult<List<SysCacheVo>> cache() {
        return ResponseResult.ok(caches);
    }

    /**
     * 通过名称获取缓存信息列表
     * @param cacheName     缓存名称
     * @return 缓存列表
     */
    @PlatLog(value = "通过名称获取缓存信息列表")
    @PreAuthorize("@ss.hasPerms('monitor:cache:list')")
    @GetMapping("cache/getKeys/{cacheName}")
    public ResponseResult<TreeSet> getCacheKeys(@PathVariable String cacheName) {
        Set<String> cacheKeys = redisTemplate.keys(cacheName + "*");
        return ResponseResult.ok(new TreeSet<>(cacheKeys));
    }

    /**
     * 通过名称获取缓存详情
     * @param cacheName     缓存名称
     * @param cacheKey     缓存Key名称
     * @return 缓存列表
     */
    @PlatLog(value = "通过名称获取缓存详情")
    @PreAuthorize("@ss.hasPerms('monitor:cache:list')")
    @GetMapping("cache/getValue/{cacheName}/{cacheKey}")
    public ResponseResult<SysCacheVo> getCacheValue(@PathVariable String cacheName,
                                                    @PathVariable String cacheKey) {
        String cacheValue = redisTemplate.opsForValue().get(cacheKey);
        SysCacheVo sysCache = new SysCacheVo(cacheName, cacheKey, cacheValue);
        return ResponseResult.ok(sysCache);
    }

    /**
     * 通过名称前缀清理缓存
     * @param cacheName     缓存名称前缀
     * @return 操作结果
     */
    @PlatLog(value = "通过名称前缀清理缓存")
    @PreAuthorize("@ss.hasPerms('monitor:cache:list')")
    @DeleteMapping("cache/clearCacheName/{cacheName}")
    public ResponseResult<String> clearCacheName(@PathVariable String cacheName) {
        Collection<String> cacheKeys = redisTemplate.keys(cacheName + "*");
        redisTemplate.delete(cacheKeys);
        return ResponseResult.ok();
    }

    /**
     * 通过名称清理缓存
     * @param cacheKey     缓存Key名称
     * @return 操作结果
     */
    @PlatLog(value = "通过名称清理缓存")
    @PreAuthorize("@ss.hasPerms('monitor:cache:list')")
    @DeleteMapping("cache/clearCacheKey/{cacheKey}")
    public ResponseResult<String> clearCacheKey(@PathVariable String cacheKey) {
        redisTemplate.delete(cacheKey);
        return ResponseResult.ok();
    }

    /**
     * 清理全部缓存
     * @return 操作结果
     */
    @PlatLog(value = "清理全部缓存")
    @PreAuthorize("@ss.hasPerms('monitor:cache:list')")
    @DeleteMapping("cache/clearCacheAll")
    public ResponseResult<String> clearCacheAll() {
        Collection<String> cacheKeys = redisTemplate.keys("*");
        redisTemplate.delete(cacheKeys);
        return ResponseResult.ok();
    }
}
