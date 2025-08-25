/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.admin.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.script.json.StringMap;
import net.linlan.frame.view.admin.utils.DictionaryUtils;
import net.linlan.frame.view.sys.vo.BaseDictionaryVo;
import net.linlan.sys.base.entity.BaseConfigWhole;
import net.linlan.sys.base.entity.BaseDictionary;
import net.linlan.sys.base.service.BaseConfigWholeService;
import net.linlan.sys.base.service.BaseDictionaryService;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.constant.CacheConstants;

/**
 * 参数配置 服务层实现
 * 
 * @author Linlan
 */
@Service
public class InitialRedisService {

    @Resource
    private RedisService           redisService;
    @Resource
    private BaseConfigWholeService baseConfigWholeService;
    @Resource
    private BaseDictionaryService  baseDictionaryService;

    /**
     * 项目启动时，初始化参数到缓存
     */
    @PostConstruct
    public void init() {
        loadingConfigCache();
        //数据库内字典数量太大，暂时不需要加载到缓存，项目启动时，初始化字典到缓存
        //        loadingDictCache();
    }

    /**
     * 加载参数缓存数据
     */
    public void loadingConfigCache() {
        List<BaseConfigWhole> configsList = baseConfigWholeService
            .getList(new StringMap().put("isDisabled", false).map());
        for (BaseConfigWhole config : configsList) {
            redisService.set(getCacheKey(config.getCfgKey()), config.getCfgValue());
        }
    }

    /**
     * 清空参数缓存数据
     */
    public void clearConfigCache() {
        Collection<String> keys = redisService.keys(CacheConstants.SYS_CONFIG_KEY + "*");
        redisService.delete(keys);
    }

    /**
     * 重置参数缓存数据
     */
    public void resetConfigCache() {
        clearConfigCache();
        loadingConfigCache();
    }

    /**
     * 设置cache key
     * 
     * @param configKey 参数键
     * @return 缓存键key
     */
    private String getCacheKey(String configKey) {
        return CacheConstants.SYS_CONFIG_KEY + configKey;
    }

    /**
     * 加载字典缓存数据
     */
    public void loadingDictCache() {
        List<BaseDictionary> result = baseDictionaryService
            .getList(new StringMap().put("delFlag", 0).map());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<BaseDictionaryVo> vos = Lists.transform(result, BaseDictionaryVo.TO);
        Map<String, List<BaseDictionaryVo>> dictDataMap = vos.stream()
            .collect(Collectors.groupingBy(BaseDictionaryVo::getTypeCode));
        for (Map.Entry<String, List<BaseDictionaryVo>> entry : dictDataMap.entrySet()) {
            DictionaryUtils.setDictCache(entry.getKey(),
                entry.getValue().stream()
                    .sorted(Comparator.comparing(BaseDictionaryVo::getPriority))
                    .collect(Collectors.toList()));
        }
    }

    /**
     * 清空字典缓存数据
     */
    public void clearDictCache() {
        DictionaryUtils.clearDictCache();
    }

    /**
     * 重置字典缓存数据
     */
    public void resetDictCache() {
        clearDictCache();
        //        loadingDictCache();
    }

}
