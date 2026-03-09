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

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dao.BaseConfigPartsDao;
import net.linlan.sys.base.dto.BaseConfigPartsDto;
import net.linlan.sys.base.entity.BaseConfigParts;
import net.linlan.sys.base.param.BaseConfigPartsParam;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.crypt.AESUtils;
import static net.linlan.utils.constant.CacheConstants.BASE_CONFIGWHOLE_KEY;

/**
 *
 * BaseConfigParts数据域:通用配置分子项服务类
 * @author Linlan
* CreateTime 2018-03-02 17:17:54
 *
 */
@Service
@Slf4j
public class BaseConfigPartsService {

    @Resource
    private BaseConfigPartsDao  dao;

    @Resource
    private RedisService        redisService;

    /**
     * 解密全局混淆密码的密码，默认混淆密码，字符串长度需要16位
     */
    private static final String SALT                  = "Linlan_20230613!";
    /**
     *  全局AES加解密密码键值
     */
    private static final String AES_SALT_KEY          = "AES_SALT_CONST";
    /**
     * 是否打开加解密开关，TRUE 打开，FALSE  关闭，默认FALSE
     */
    private static boolean      openEncrypt           = false;
    /**
     * 打开敏感信息加解密键值
     */
    private static final String OPEN_ENCRYPT          = "OPEN_ENCRYPT";
    /**
     * redis类型，REDIS 常用的redis，DFT  东方通
     */
    private static String       REDIS_TYPE            = "";
    /**
     * redis 类别
     */
    private static final String REDIS_TYPE_KEY        = "REDIS_TYPE";

    /**
     * 加密类别 KEY，空的话默认为AES
     */
    private static String       ENCRYPT_TYPE          = "";
    /**
     * 加密类别 KEY，空的话默认为AES
     */
    private static final String ENCRYPT_TYPE_KEY      = "ENCRYPT_TYPE";

    /**
     * 是否开启密码机签名
     */
    private static boolean      openEncryptSign       = false;
    /**
     * 开启密码机签名键值
     */
    private static final String ENCRYPT_OPEN_SIGN_KEY = "ENCRYPT_OPEN_SIGN";
    /**
     * 是否开启SM4国密密码机签名
     */
    private static boolean      openSM4Password       = false;
    /**
     * 全局AES加解密的密钥，读取数据库配置加载
     */
    private static String       AES_SALT              = "";
    /**
     * 密码机加解密秘钥
     */
    private static String       SM2_KEY               = "";

    private String              SM2_KEY_KEY           = "SM2_KEY_KEY";

    /** get the list of entity BaseConfigParts
     * 列表方法，返回列表的KV配置数据 {@link List} 对象，包含 {@link BaseConfigParts} 列表
     * @param map the input select conditions
     * @return 列表的KV配置数据 {@link List} 对象，包含 {@link BaseConfigParts} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseConfigParts> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseConfigParts}
     * @param id 配置项名称|1
     * @return {@link BaseConfigParts}
     */
    public BaseConfigParts findById(String id) {
        BaseConfigParts configParts = (BaseConfigParts) redisService.get(BASE_CONFIGWHOLE_KEY + id);
        if (configParts == null) {
            configParts = dao.findById(id);
            redisService.set(BASE_CONFIGWHOLE_KEY + id, configParts,
                KernelConstant.TEN_MINUTE_EXPIRE);
        }
        return configParts;
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseConfigParts the input baseConfigParts
     */
    //@Transactional
    public void save(BaseConfigParts baseConfigParts) {
        baseConfigParts.init();
        dao.save(baseConfigParts);
    }

    /** save the entity with input list
     * 保存对象通用配置分子项，批量保存list
     * @param list {@link BaseConfigParts}
     */
    public void batchSave(List<BaseConfigParts> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseConfigParts the input baseConfigParts
     */
    //@Transactional
    public void update(BaseConfigParts baseConfigParts) {
        dao.update(baseConfigParts);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 配置项名称|1
     */
    public void deleteById(String id) {
        if (StringUtils.isBlank(id)) {
            return;
        }
        dao.deleteById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    //@Transactional
    public void deleteByIds(String[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            return;
        }
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

    /** get the page of dto BaseConfigPartsDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseConfigPartsParam }
     * @return 分页的KV配置数据 {@link Page} 对象，包含 {@link BaseConfigParts} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseConfigPartsDto> getPageDto(BaseConfigPartsParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseConfigPartsDto}
     * @param id 配置项名称|1
     * @return {@link BaseConfigPartsDto}
     */
    public BaseConfigPartsDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    /**
     * 读取数据库配置，看是否启动加密，系统启动的时候加载
     */
    public void setEncryptStatus() {
        BaseConfigParts parts = dao.findById(OPEN_ENCRYPT);
        if (parts != null && "TRUE".equals(parts.getCfgValue())
            && StringUtils.isNotEmpty(AES_SALT_KEY)) {
            openEncrypt = true;
        }
    }

    /**
     * 读取数据库配置，看是否启动加密，系统启动的时候加载
     */
    public void setRedisType() {
        BaseConfigParts parts = dao.findById(REDIS_TYPE_KEY);
        if (parts != null && StringUtils.isNotEmpty(parts.getCfgValue())) {
            REDIS_TYPE = parts.getCfgValue();
        }
    }

    public String setBaseSalt() {
        if (StringUtils.isEmpty(ENCRYPT_TYPE)) {
            BaseConfigParts parts = dao.findById(ENCRYPT_TYPE_KEY);
            if (parts != null) {
                ENCRYPT_TYPE = parts.getCfgValue();
                if ("KOAL".equalsIgnoreCase(ENCRYPT_TYPE)) {
                    openSM4Password = true;
                }
            }
        }
        if (StringUtils.isEmpty(SM2_KEY)) {
            BaseConfigParts parts = dao.findById(SM2_KEY_KEY);
            if (parts != null) {
                SM2_KEY = parts.getCfgValue();
            }
        }

        if (!openEncryptSign) {
            BaseConfigParts parts = dao.findById(ENCRYPT_OPEN_SIGN_KEY);
            if (parts != null && "TRUE".equals(parts.getCfgValue())) {
                openEncryptSign = true;
            }
        }

        if (StringUtils.isNotEmpty(AES_SALT)) {
            return AES_SALT;
        }
        BaseConfigParts parts = dao.findById(AES_SALT_KEY);
        if (parts != null) {
            String globalSalt = AESUtils.decrypt(parts.getCfgValue(), SALT);
            AES_SALT = globalSalt;
            return globalSalt;
        }
        return null;
    }

    /**
     * 敏感信息加密
     * @param content   内容
     * @return    返回结果
     */
    public static String encrypt(String content) {
        if (StringUtils.isEmpty(AES_SALT)) {
            return "";
        }
        return AESUtils.encrypt(content, AES_SALT);
    }

    /**
     * 敏感信息解密
     * @param content    内容
     * @return    返回结果
     */
    public static String decrypt(String content) {
        if (StringUtils.isEmpty(AES_SALT)) {
            return "";
        }
        if (StringUtils.isEmpty(content)) {
            return "";
        }
        return AESUtils.decrypt(content, AES_SALT);
    }

}
