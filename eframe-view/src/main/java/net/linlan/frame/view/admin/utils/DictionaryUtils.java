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
package net.linlan.frame.view.admin.utils;

import java.util.Collection;
import java.util.List;

import com.alibaba.fastjson2.JSONArray;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.view.sys.vo.BaseDictionaryVo;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.SpringContextUtils;
import net.linlan.utils.constant.CacheConstants;

/**
 * 字典工具类
 * 
 * @author Linlan
 */
public class DictionaryUtils {
    /**
     * 分隔符
     */
    public static final String SEPARATOR = ",";

    /**
     * 设置字典缓存
     * 
     * @param key 参数键
     * @param dictDatas 字典数据列表
     */
    public static void setDictCache(String key, List<BaseDictionaryVo> dictDatas) {
        SpringContextUtils.getBean(RedisService.class).set(getCacheKey(key), dictDatas);
    }

    /**
     * 获取字典缓存
     * 
     * @param key 参数键
     * @return dictDatas 字典数据列表
     */
    public static List<BaseDictionaryVo> getDictCache(String key) {
        JSONArray arrayCache = SpringContextUtils.getBean(RedisService.class).get(getCacheKey(key),
            JSONArray.class);
        if (ObjectUtils.isNotEmpty(arrayCache)) {
            return arrayCache.toList(BaseDictionaryVo.class);
        }
        return null;
    }

    /**
     * 根据字典类型和字典值获取字典标签
     * 
     * @param dictType 字典类型
     * @param dictValue 字典值
     * @return 字典标签
     */
    public static String getDictLabel(String dictType, String dictValue) {
        if (StringUtils.isEmpty(dictValue)) {
            return StringUtils.EMPTY;
        }
        return getDictLabel(dictType, dictValue, SEPARATOR);
    }

    /**
     * 根据字典类型和字典标签获取字典值
     * 
     * @param dictType 字典类型
     * @param dictLabel 字典标签
     * @return 字典值
     */
    public static String getDictValue(String dictType, String dictLabel) {
        if (StringUtils.isEmpty(dictLabel)) {
            return StringUtils.EMPTY;
        }
        return getDictValue(dictType, dictLabel, SEPARATOR);
    }

    /**
     * 根据字典类型和字典值获取字典标签
     * 
     * @param dictType 字典类型
     * @param dictValue 字典值
     * @param separator 分隔符
     * @return 字典标签
     */
    public static String getDictLabel(String dictType, String dictValue, String separator) {
        StringBuilder propertyString = new StringBuilder();
        List<BaseDictionaryVo> datas = getDictCache(dictType);
        if (ObjectUtils.isEmpty(datas)) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.containsAny(separator, dictValue)) {
            for (BaseDictionaryVo dict : datas) {
                for (String value : dictValue.split(separator)) {
                    if (value.equals(dict.getCddValue())) {
                        propertyString.append(dict.getDictLabel()).append(separator);
                        break;
                    }
                }
            }
        } else {
            for (BaseDictionaryVo dict : datas) {
                if (dictValue.equals(dict.getCddValue())) {
                    return dict.getDictLabel();
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 根据字典类型和字典标签获取字典值
     * 
     * @param dictType 字典类型
     * @param dictLabel 字典标签
     * @param separator 分隔符
     * @return 字典值
     */
    public static String getDictValue(String dictType, String dictLabel, String separator) {
        StringBuilder propertyString = new StringBuilder();
        List<BaseDictionaryVo> datas = getDictCache(dictType);
        if (ObjectUtils.isEmpty(datas)) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.containsAny(separator, dictLabel)) {
            for (BaseDictionaryVo dict : datas) {
                for (String label : dictLabel.split(separator)) {
                    if (label.equals(dict.getDictLabel())) {
                        propertyString.append(dict.getCddValue()).append(separator);
                        break;
                    }
                }
            }
        } else {
            for (BaseDictionaryVo dict : datas) {
                if (dictLabel.equals(dict.getDictLabel())) {
                    return dict.getCddValue();
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 根据字典类型获取字典所有值
     *
     * @param dictType 字典类型
     * @return 字典值
     */
    public static String getDictValues(String dictType) {
        StringBuilder propertyString = new StringBuilder();
        List<BaseDictionaryVo> datas = getDictCache(dictType);
        if (ObjectUtils.isEmpty(datas)) {
            return StringUtils.EMPTY;
        }
        for (BaseDictionaryVo dict : datas) {
            propertyString.append(dict.getCddValue()).append(SEPARATOR);
        }
        return StringUtils.stripEnd(propertyString.toString(), SEPARATOR);
    }

    /**
     * 根据字典类型获取字典所有标签
     *
     * @param dictType 字典类型
     * @return 字典值
     */
    public static String getDictLabels(String dictType) {
        StringBuilder propertyString = new StringBuilder();
        List<BaseDictionaryVo> datas = getDictCache(dictType);
        if (ObjectUtils.isEmpty(datas)) {
            return StringUtils.EMPTY;
        }
        for (BaseDictionaryVo dict : datas) {
            propertyString.append(dict.getDictLabel()).append(SEPARATOR);
        }
        return StringUtils.stripEnd(propertyString.toString(), SEPARATOR);
    }

    /**
     * 删除指定字典缓存
     * 
     * @param key 字典键
     */
    public static void removeDictCache(String key) {
        SpringContextUtils.getBean(RedisService.class).delete(getCacheKey(key));
    }

    /**
     * 清空字典缓存
     */
    public static void clearDictCache() {
        Collection<String> keys = SpringContextUtils.getBean(RedisService.class)
            .keys(CacheConstants.BASE_DICTIONARY_KEY + "*");
        SpringContextUtils.getBean(RedisService.class).delete(keys);
    }

    /**
     * 设置cache key
     * 
     * @param configKey 参数键
     * @return 缓存键key
     */
    public static String getCacheKey(String configKey) {
        return CacheConstants.BASE_DICTIONARY_KEY + configKey;
    }
}
