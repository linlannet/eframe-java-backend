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
package net.linlan.sys.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import jakarta.annotation.Resource;
import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.constant.CacheConstants;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import static org.springframework.data.redis.core.ScanOptions.scanOptions;

import static net.linlan.commons.core.NumberUtils.isNumeric;

/**
 * Filename:RedisService.java
 * Desc: redis utils java class to deal with redis server
 *
 * @author Linlan
 * CreateTime:2017/10/25 19:20
 * @version 1.0
 * @since 1.0
 */
@Component
public class RedisService {

    @Resource
    private RedisTemplate       redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 不设置过期时长
     */
    public final static long    NOT_EXPIRE = KernelConstant.NOT_EXPIRE;

    /**
     * get the value of input key
     *
     * @param key the key
     * @return the value
     */
    public <T> T get(String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * get the value of input key
     *
     * @param key    the key
     * @param expire the expire time
     * @return the value
     */
    private <T> T get(String key, long expire) {
        if (expire != NOT_EXPIRE) {
            ValueOperations<String, T> operation = redisTemplate.opsForValue();
            return operation.get(key);
        }
        return null;
    }

    /**
     * set the redis key with value with default expire
     *
     * @param key   the input key
     * @param value the input value
     */
    public <T> void set(String key, T value) {
        set(key, value, KernelConstant.ONE_DAY_EXPIRE);
    }

    /**
     * set the redis key with value
     *
     * @param key    the input key
     * @param value  the input value
     * @param expire the input expire
     */
    public <T> void set(String key, T value, long expire) {
        redisTemplate.opsForValue().set(key, value);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 添加Map数据
     * @param key       键
     * @param value     值
     * @param expire    过期时间
     */
    public void setMap(String key, Map<String, Object> value, Long expire) {
        redisTemplate.opsForHash().putAll(key, value);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 添加集合数据
     * @param key       键
     * @param values    值集合
     * @param expire    过期时间
     */
    public void setList(String key, Collection values, Long expire) {
        String uuid = RandomUtils.UUID32();
        String lockKey = CacheConstants.LOCK_KEY + key;
        boolean lock = getLock(lockKey, uuid);
        if (lock) {
            redisTemplate.delete(key);
            redisTemplate.opsForList().rightPushAll(key, values);
            if (expire != NOT_EXPIRE) {
                redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            }
            boolean releaseLock = releaseLock(lockKey, uuid);
        }
    }

    /**
     * 获取集合数据
     * @param key       键
     * @return      获取列表
     */
    public List getList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 获取集合数据
     * @param key       键
     * @param start     开始位置
     * @param end       结束位置
     * @return      获取列表
     */
    public List getList(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 获取Map数据
     * @param key   键
     * @return  MAP对象
     */
    public Map<String, Object> getMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * delete the key and value
     *
     * @param key the input key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 删除集合对象
     * 20241007添加
     *
     * @param collection 多个对象
     * @return  true/false
     */
    public boolean delete(final Collection collection) {
        return redisTemplate.delete(collection) > 0;
    }

    /**
     * 每日流水号自增，用户生成事件编号
     * 每天 从1 开始
     * @param   key     键
     * @return          流水号
     */
    public Long getNext(String key) {
        RedisAtomicLong atomicLong = new RedisAtomicLong(key,
            redisTemplate.getRequiredConnectionFactory());
        LocalDate now = LocalDate.now();
        LocalDateTime expire = now.plusDays(1).atStartOfDay();
        atomicLong.expireAt(Date.from(expire.atZone(ZoneId.systemDefault()).toInstant()));
        Long autoID = atomicLong.getAndIncrement();
        //从1开始
        if (autoID == 0) {
            return atomicLong.getAndIncrement();
        }
        return autoID;
    }

    /**
     * 根据 key 获取过期时间
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return  增加后的double值
     */
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return  减少后的double值
     */
    public double hdecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    /** 加锁
     * @param key   键
     * @param value 值
     * @return  true/false
     */
    public Boolean getLock(String key, String value) {
        Boolean lockStatus = this.redisTemplate.opsForValue().setIfAbsent(key, value);
        return lockStatus;
    }

    /**
     * 调整为支持redis集群
     * @param prizeId   ID
     * @param uuid      主键
     * @return  true/false
     */
    private boolean releaseLock(String prizeId, String uuid) {

        //使用Lua脚本：先判断是否是自己设置的锁，再执行删除
        // 使用lua脚本删除redis中匹配value的key，可以避免由于方法执行时间过长而redis锁自动过期失效的时候误删其他线程的锁
        // spring自带的执行脚本方法中，集群模式直接抛出不支持执行脚本的异常，所以只能拿到原redis的connection来执行脚本

        String SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        System.out.println(SCRIPT);
        List<String> keys = new ArrayList<>();
        keys.add(prizeId);
        List<String> args = new ArrayList<>();
        args.add(uuid);

        Boolean resp = true;
        Long result = (Long) redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                Object nativeConnection = connection.getNativeConnection();
                // 集群模式和单机模式虽然执行脚本的方法一样，但是没有共同的接口，所以只能分开执行
                // 集群模式
                if (nativeConnection instanceof JedisCluster) {
                    return (Long) ((JedisCluster) nativeConnection).eval(SCRIPT, keys, args);
                }

                // 单机模式
                else if (nativeConnection instanceof Jedis) {
                    return (Long) ((Jedis) nativeConnection).eval(SCRIPT, keys, args);
                }
                return 0L;
            }
        });
        if (result == 1L) {
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }

    /**
     * 获得缓存的基本对象列表
     * 20241007添加，用于批量删除
     *
     * @param pattern 字符串前缀，通用匹配标记
     * @return 对象列表
     */
    public Collection<String> keys(final String pattern) {
        return redisTemplate.keys(pattern);
    }

    /** 往Hash中存入数据
     * @param key   Redis键
     * @param hKey  Hash键
     * @param value 值
     * @param <T>   实体泛型
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key  Redis键
     * @param hKey Hash键
     * @param <T>   实体泛型
     * @return Hash中的对象
     */
    public <T> T getCacheMapValue(final String key, final String hKey) {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 删除Hash中的某条数据
     *
     * @param key  Redis键
     * @param hKey Hash键
     * @return 是否成功
     */
    public boolean deleteCacheMapValue(final String key, final String hKey) {
        return redisTemplate.opsForHash().delete(key, hKey) > 0;
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key   Redis键
     * @param hKeys Hash键集合
     * @param <T>   实体泛型
     * @return Hash对象集合
     */
    public <T> List<Object> getMultiCacheMapValue(final String key,
                                                  final Collection<Object> hKeys) {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 获取所有键值对集合
     *
     * @param key   Redis键
     * @return  Map对象
     */
    public Map hashEntity(String key) {
        return redisTemplate.boundHashOps(key).entries();
    }

    /**
     * 以map集合的形式添加键值对
     *
     * @param key      Redis键
     * @param maps      MAP对象
     */
    public void hashPutAll(String key, Map<String, String> maps) {
        redisTemplate.opsForHash().putAll(key, maps);
    }

    /**
     * 以map集合的形式添加键值对
     *
     * @param key      Redis键
     * @param maps      MAP对象
     */
    public void hashPutAllObj(String key, Map<String, Object> maps) {
        redisTemplate.opsForHash().putAll(key, maps);
    }

    /**
     * 批量获取设备物模型值
     *
     * @param keys          键的集合
     * @param hkeyCondition 筛选字段
     * @return  MAP对象
     */
    public Map<String, Map> hashGetAllByKeys(Set<String> keys, String hkeyCondition) {
        return (Map<String, Map>) redisTemplate.execute((RedisCallback) con -> {
            Iterator<String> it = keys.iterator();
            Map<String, Map> mapList = new HashMap<>();
            while (it.hasNext()) {
                String key = it.next();
                Map<byte[], byte[]> result = con.hGetAll(key.getBytes());
                Map ans;
                if (CollectionUtils.isEmpty(result)) {
                    return new HashMap<>(0);
                }
                ans = new HashMap<>(result.size());
                for (Map.Entry entry : result.entrySet()) {
                    String field = new String((byte[]) entry.getKey());
                    if (!"".equals(hkeyCondition)) {
                        if (field.endsWith(hkeyCondition)) {
                            ans.put(new String((byte[]) entry.getKey()),
                                new String((byte[]) entry.getValue()));
                        }
                    } else {
                        ans.put(new String((byte[]) entry.getKey()),
                            new String((byte[]) entry.getValue()));
                    }
                }
                mapList.put(key, ans);
            }
            return mapList;
        });
    }

    /**
     * 批量获取匹配触发器的物模型值（定时告警使用）
     *
     * @param keys         键的集合
     * @param operator     操作符
     * @param id     ID
     * @param triggerValue 触发的值
     * @return      MAP对象
     */
    public Map<String, String> hashGetAllMatchByKeys(Set<String> keys, String operator, String id,
                                                     String triggerValue) {
        return (Map<String, String>) redisTemplate.execute((RedisCallback) con -> {
            Iterator<String> it = keys.iterator();
            Map<String, String> mapList = new HashMap<>();
            while (it.hasNext()) {
                String key = it.next();
                Map<byte[], byte[]> result = con.hGetAll(key.getBytes());
                if (CollectionUtils.isEmpty(result)) {
                    return new HashMap<>(0);
                }
                for (Map.Entry entry : result.entrySet()) {
                    String field = new String((byte[]) entry.getKey());
                    // 获取物模型值并且匹配规则，获取值的类型和匹配规则后续还要仔细测了然后优化
                    if (field.equals(id) || field.equals(id + "#V")) {
                        String valueStr = new String((byte[]) entry.getValue());
                        JSONObject jsonObject = JSONObject
                            .parseObject((String) JSON.parse(valueStr));
                        String value = (String) jsonObject.get("value");
                        if (ruleResult(operator, value, triggerValue)) {
                            mapList.put(key, value);
                        }
                    }
                }
            }
            return mapList;
        });
    }

    /**
     * 根据key集合获取字符串
     *
     * @param keys 键的集合
     * @return      MAP对象
     */
    public Map<String, String> getStringAllByKeys(Set<String> keys) {
        return (Map<String, String>) redisTemplate.execute((RedisCallback) con -> {
            Iterator<String> it = keys.iterator();
            Map<String, String> mapList = new HashMap<>();
            while (it.hasNext()) {
                String key = it.next();
                byte[] result = con.get(key.getBytes());
                if (result == null) {
                    return new HashMap<>(0);
                }
                String ans = new String((byte[]) result);
                mapList.put(key, ans);
            }
            return mapList;
        });
    }

    /**
     * 规则匹配结果
     *
     * @param operator     操作符
     * @param value        上报的值
     * @param triggerValue 触发器的值
     * @return      true/false
     */
    private boolean ruleResult(String operator, String value, String triggerValue) {
        boolean result = false;
        if ("".equals(value)) {
            return result;
        }
        // 操作符比较
        switch (operator) {
            case "=":
                result = value.equals(triggerValue);
                break;
            case "!=":
                result = !value.equals(triggerValue);
                break;
            case ">":
                if (isNumeric(value) && isNumeric(triggerValue)) {
                    result = Double.parseDouble(value) > Double.parseDouble(triggerValue);
                }
                break;
            case "<":
                if (isNumeric(value) && isNumeric(triggerValue)) {
                    result = Double.parseDouble(value) < Double.parseDouble(triggerValue);
                }
                break;
            case ">=":
                if (isNumeric(value) && isNumeric(triggerValue)) {
                    result = Double.parseDouble(value) >= Double.parseDouble(triggerValue);
                }
                break;
            case "<=":
                if (isNumeric(value) && isNumeric(triggerValue)) {
                    result = Double.parseDouble(value) <= Double.parseDouble(triggerValue);
                }
                break;
            case "contain":
                result = value.contains(triggerValue);
                break;
            case "notcontain":
                result = !value.contains(triggerValue);
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return      增加数量之后的long对象
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * redis 计数器自增
     *
     * @param key      key
     * @param liveTime 过期时间，null不设置过期时间
     * @return 自增数
     */
    public Long incr2(String key, long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key,
            redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();

        if (increment == 0 && liveTime > 0) {//初始设置过期时间
            entityIdCounter.expire(liveTime, TimeUnit.HOURS);
        }

        return increment;
    }

    /**
     * 添加一个元素, zset与set最大的区别就是每个元素都有一个score，因此有个排序的辅助功能;  zadd
     *
     * @param key   键
     * @param value 值
     * @param score 分数
     * @return true/false
     */
    public boolean zSetAdd(String key, String value, double score) {
        try {
            Boolean aBoolean = stringRedisTemplate.opsForZSet().add(key, value, score);
            return Boolean.TRUE.equals(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除一个zset有序集合的key的一个或者多个值
     * zrem key member [member ...] ：移除有序集 key 中的一个或多个成员，不存在的成员将被忽略。当 key 存在但不是有序集类型时，返回一个错误。
     *
     * @param key    集合的键key
     * @param values 需要移除的value
     * @return  移除后是否成功
     */
    public boolean zRem(String key, Object... values) {
        try {
            Long aLong = stringRedisTemplate.opsForZSet().remove(key, values);
            return aLong != null ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
     *
     * @param key   String
     * @param start double 最小score
     * @param end   double 最大score
     * @return  移除有序集后的long数值
     */
    public Long zRemBySocre(String key, double start, double end) {
        try {
            return stringRedisTemplate.opsForZSet().removeRangeByScore(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断value在zset中的排名  zrank命令
     *
     * @param key   键
     * @param value 值
     * @return score 越小排名越高;
     */
    public Long zRank(String key, String value) {
        try {
            return stringRedisTemplate.opsForZSet().rank(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询zSet集合中指定顺序的值， 0 -1 表示获取全部的集合内容  zrange
     *
     * @param key   键
     * @param start 开始
     * @param end   结束
     * @return 返回有序的集合，score小的在前面
     */
    public Set<String> zRange(String key, int start, int end) {
        try {
            return stringRedisTemplate.opsForZSet().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
     * 有序集成员按 score 值递增(从小到大)次序排列。
     *
     * @param key   String
     * @param start double 最小score
     * @param end   double 最大score
     * @return 返回有序的集合，有序集成员按 score 值递增(从小到大)次序排列
     */
    public Set<String> zRangeByScore(String key, double start, double end) {
        try {
            return stringRedisTemplate.opsForZSet().rangeByScore(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回set集合的长度
     *
     * @param key      Redis键
     * @return      获取缓存long值
     */
    public Long zSize(String key) {
        try {
            return stringRedisTemplate.opsForZSet().zCard(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据条件返回所有键
     *
     * @param query 查询条件
     * @return      所以对象列表
     */
    public List<Object> scan(String query) {
        Set<String> keys = (Set<String>) redisTemplate
            .execute((RedisCallback<Set<String>>) connection -> {
                Set<String> keysTmp = new HashSet<>();
                Cursor<byte[]> cursor = connection
                    .scan(scanOptions().match(query).count(1000).build());
                while (cursor.hasNext()) {
                    keysTmp.add(new String(cursor.next()));
                }
                return keysTmp;
            });
        return new ArrayList<>(keys);
    }

    /**
     * 匹配获取键值对，ScanOptions.NONE为获取全部键对
     *
     * @param key      Redis键
     * @param options   检索条件
     * @return      MAP对象
     */
    public Cursor<Map.Entry<Object, Object>> hashScan(String key, ScanOptions options) {
        return redisTemplate.opsForHash().scan(key, options);
    }

}
