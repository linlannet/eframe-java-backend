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
package net.linlan.sys.base.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dao.BaseDictionaryDao;
import net.linlan.sys.base.dto.BaseDictionaryDto;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.entity.BaseDictionary;
import net.linlan.sys.base.param.BaseDictionaryParam;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;
import static net.linlan.utils.constant.CacheConstants.BASE_DICTIONARY_KEY;

/**
 *
 * BaseDictionary数据域:公共字典明细服务类
 * @author Linlan
 * CreateTime 2018-05-08 18:37:58
 *
 */
@Service
@Slf4j
public class BaseDictionaryService {

    @Resource
    private BaseDictionaryDao dao;

    @Resource
    private RedisService      redisService;

    /**
     * 过期时间
     */
    private Date              expireTime;

    /** get the list of entity DictionaryInitDto
     * 列表方法，返回列表的全局配置数据 {@link List} 对象，包含 {@link BaseDictionary} 列表
     * @param map the input select conditions
     * @return 列表的字典数据 {@link Page} 对象，包含 {@link BaseDictionary} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseDictionary> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseDictionary}
     * @param id 字典编号|1
     * @return {@link BaseDictionary}
     */
    public BaseDictionary findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseDictionary the input baseDictionary
     */
    //@Transactional
    public void save(BaseDictionary baseDictionary) {
        baseDictionary.init();
        dao.save(baseDictionary);
        refreshCache(baseDictionary.getTypeCode());
    }

    /** save the entity with input list
     * 保存对象公共字典明细，批量保存list
     * @param list {@link BaseDictionary}
     */
    public void batchSave(List<BaseDictionary> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseDictionary the input baseDictionary
     */
    //@Transactional
    public void update(BaseDictionary baseDictionary) {
        dao.update(baseDictionary);
        refreshCache(baseDictionary.getTypeCode());
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 字典编号|1
     */
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    //@Transactional
    public void deleteByIds(Long[] ids) {
        dao.deleteByIds(ids);
    }

    /** query the total count by input select conditions
     * 通过输入的条件查询记录总数
     * @param map the input select conditions
     * @return total count
     */
    public int getCount(Map<String, Object> map) {
        return dao.getCount(map);
    }

    /** get the page of dto BaseDictionaryDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseDictionaryParam }
     * @return 分页的字典数据 {@link Page} 对象，包含 {@link BaseDictionary} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseDictionaryDto> getPageDto(BaseDictionaryParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseDictionaryDto}
     * @param id 字典编号|1
     * @return {@link BaseDictionaryDto}
     */
    public BaseDictionaryDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /** 通过多个typdCodes获取字典列表
     * @param typeCodes     字典codes
     * @return    返回结果List
     */
    public List<BaseDictionary> getByTypeCodes(List<String> typeCodes) {
        return dao.getByTypeCodes(typeCodes);
    }

    /**
     * 根据typeCode获取字典
     * @param typeCode  字典code
     * @return    返回结果List
     */
    public List<DictionaryInitDto> getInitByTypeCode(String typeCode) {
        return dao.getInitByTypeCode(typeCode);
    }

    /**
     * 根据typeCode刷新字典
     * @param typeCode  字典code
     */
    public void refreshByTypeCode(String typeCode) {
        List<DictionaryInitDto> dicResult = dao.getInitByTypeCode(typeCode);
        if (dicResult != null && dicResult.size() > 0) {
            redisService.setList(BASE_DICTIONARY_KEY + typeCode, dicResult,
                KernelConstant.ONE_HOUR_EXPIRE * 2);
        }
    }

    /**
     * 根据typeCode刷新字典
     * @param parentId  父节点ID
     * @param typeCode  字典code
     */
    public void refreshByParent(String parentId, String typeCode) {
        List<DictionaryInitDto> dicResult = dao.getChildren(parentId, typeCode);
        if (dicResult != null && dicResult.size() > 0) {
            redisService.setList(BASE_DICTIONARY_KEY + parentId, dicResult,
                KernelConstant.ONE_HOUR_EXPIRE * 2);
        }
    }

    /**
     * 刷新缓存
     * @param typeCode  字典code
     */
    public void refreshCache(String typeCode) {
        redisService.delete(BASE_DICTIONARY_KEY + typeCode);
    }

    /**
     * 查询下一级字典
     * 字典缓存：2 小时,字典有调整的时候主动调用刷新方法刷新，或者等两小时自动刷新
     * @param parentId    父节点ID
     * @param typeCode  字典code
     * @return    查询结果Map
     */
    public LinkedHashMap<String, String> getChildrenMap(String parentId, String typeCode) {
        List<DictionaryInitDto> dist = redisService.getList(BASE_DICTIONARY_KEY + parentId);
        if (dist.size() > 0) {
            return dis2Map(dist);
        } else {
            List<DictionaryInitDto> dicResult = dao.getChildren(parentId, typeCode);
            if (dicResult != null && dicResult.size() > 0) {
                redisService.setList(BASE_DICTIONARY_KEY + parentId, dicResult,
                    KernelConstant.ONE_HOUR_EXPIRE * 2);
            }
            return dis2Map(dicResult);
        }
    }

    /**
     * 仅限下一级
     * @param parentId    父节点ID
     * @param typeCode  字典code
     * @return    返回结果List
     */
    public List<DictionaryInitDto> getChildren(String parentId, String typeCode) {
        return dao.getChildren(parentId, typeCode);
    }

    /**
     * 字典转Map
     * @param   list    输入LIST
     * @return    返回结果
     */
    private LinkedHashMap<String, String> dis2Map(List<DictionaryInitDto> list) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (DictionaryInitDto dic : list) {
            result.put(dic.getCddValue(), dic.getName());
        }
        return result;
    }

    /**
     * 查询子字典，带子集
     * @param parentId    父节点ID
     * @return    查询结果Map
     */
    public Map<String, String> getAllChildMap(String parentId) {
        List<BaseDictionary> resultList = dao.getAllChild(parentId);
        Map<String, String> result = new HashMap<>();
        for (BaseDictionary dic : resultList) {
            result.put(dic.getCddValue(), dic.getName());
        }
        return result;
    }

    /**
     * 带子集的列表对象
     * @param parentId 父节点ID
     * @param typeCode 字典code
     * @return    返回结果List
     */
    public List<DictionaryInitDto> getAllChild(String parentId, String typeCode) {
        return dao.getChildren(parentId, typeCode);
    }

    /**
     * 根据typeCodes数组查询
     * 字典缓存：2 小时,字典有调整的时候主动调用刷新方法刷新，或者等两小时自动刷新
     * @param typeCodes 字典codes
     * @return 字典数组
     */
    public LinkedHashMap<String, String> getInitByTypeCodes(List<String> typeCodes) {
        // 构造Redis缓存的键
        String cacheKey = BASE_DICTIONARY_KEY + StringUtils.join(typeCodes, "_");
        // 从Redis缓存中获取数据
        List<DictionaryInitDto> res = redisService.getList(BASE_DICTIONARY_KEY + cacheKey);
        if (res != null && res.size() > 0) {
            // 如果缓存中有数据，直接返回
            return dis2Map(res);
        } else {
            // 如果缓存中没有数据，则从数据库中查询
            List<DictionaryInitDto> dicResult = dao.getInitByTypeCodes(typeCodes);
            if (dicResult != null && dicResult.size() > 0) {
                // 将查询结果存入Redis缓存，设置过期时间为2小时
                redisService.setList(BASE_DICTIONARY_KEY + cacheKey, dicResult,
                    KernelConstant.TEN_MINUTE_EXPIRE);
            }
            // 返回数据库查询结果
            return dis2Map(dicResult);
        }
    }

}
