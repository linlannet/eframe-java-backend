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
package net.linlan.frame.admin.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.entity.BaseConfigWhole;
import net.linlan.sys.base.service.BaseConfigWholeService;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.constant.CacheConstants;
import net.linlan.utils.text.Convert;

/**
 * 参数配置 服务层实现
 * 
 * @author Linlan
 */
@Service
public class InitialConfigService {

    @Resource
    private RedisService           redisService;
    @Resource
    private BaseConfigWholeService baseConfigWholeService;

    /**
     * 根据键名查询参数配置信息
     * 
     * @param configKey 参数key
     * @return 参数键值
     */
    public String selectConfigByKey(String configKey) {
        String configValue = Convert.toStr(redisService.get(getCacheKey(configKey)));
        if (ObjectUtils.isNotEmpty(configValue)) {
            return configValue;
        }
        BaseConfigWhole retConfig = baseConfigWholeService.getByKey(configKey);
        if (ObjectUtils.isNotEmpty(retConfig)) {
            redisService.set(getCacheKey(configKey), retConfig.getCfgValue(),
                KernelConstant.ONE_DAY_EXPIRE);
            return retConfig.getCfgValue();
        }
        return StringUtils.EMPTY;
    }

    /**
     * 获取验证码开关
     * 
     * @return true开启，false关闭
     */
    public boolean selectCaptchaEnabled() {
        String captchaEnabled = selectConfigByKey("sys.account.captchaEnabled");
        if (StringUtils.isEmpty(captchaEnabled)) {
            return true;
        }
        return Convert.toBool(captchaEnabled);
    }

    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    private String getCacheKey(String configKey) {
        return CacheConstants.BASE_CONFIGWHOLE_KEY + configKey;
    }

}
