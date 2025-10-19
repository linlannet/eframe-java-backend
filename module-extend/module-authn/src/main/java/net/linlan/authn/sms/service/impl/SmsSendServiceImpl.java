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
package net.linlan.authn.sms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSONObject;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import net.linlan.authn.sms.cache.SmsConfigCache;
import net.linlan.authn.sms.cache.SmsSendCache;
import net.linlan.authn.sms.channel.SmsContext;
import net.linlan.authn.sms.service.SmsSendRecordService;
import net.linlan.authn.sms.service.SmsSendService;
import net.linlan.authn.sms.vo.SmsConfigVo;
import net.linlan.commons.core.ExceptionUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.entity.BaseConfigWhole;
import net.linlan.sys.base.service.BaseConfigWholeService;
import net.linlan.utils.exception.CommonException;

/**
 * 短信服务Api
 *
 * @author Linlan
 */
@Slf4j
@Component
@AllArgsConstructor
public class SmsSendServiceImpl implements SmsSendService {

    /**
     * 短信提供商配置分类ID
     */
    private static final String    CONFIG_SMS_CATEGORY = "SmsCategory";
    @Resource
    private BaseConfigWholeService baseConfigWholeService;
    @Resource
    private SmsSendRecordService   smsSendRecordService;
    @Resource
    private SmsConfigCache         smsConfigCache;
    @Resource
    private SmsSendCache           smsSendCache;

    @Override
    public boolean send(String mobile, Map<String, String> params) {
        return send(null, mobile, params);
    }

    /**
     * 发送短信
     *
     * @param groupName 分组名称
     * @param mobile    手机号
     * @param params    参数
     * @return 是否发送成功
     */
    @Override
    public boolean send(String groupName, String mobile, Map<String, String> params) {
        SmsConfigVo config = roundSmsConfig(groupName);

        try {
            // 发送短信
            new SmsContext(config).send(mobile, params);

            smsSendRecordService.saveBySend(config, mobile, params, null);
            return true;
        } catch (Exception e) {
            log.error("短信发送失败，手机号：{}", mobile, e);

            smsSendRecordService.saveBySend(config, mobile, params,
                StringUtils.substring(ExceptionUtils.getMessage(e), 0, 800));
            return false;
        }
    }

    @Override
    public boolean sendCode(String mobile, String key, String value) {
        // 短信参数
        Map<String, String> params = new HashMap<>();
        params.put(key, value);

        // 发送短信
        boolean flag = send(null, mobile, params);
        if (flag) {
            smsSendCache.saveCode(mobile, value);
        }
        return flag;
    }

    @Override
    public boolean sendCode(String groupName, String mobile, String key, String value) {
        // 短信参数
        Map<String, String> params = new HashMap<>();
        params.put(key, value);

        // 发送短信
        boolean flag = send(groupName, mobile, params);
        if (flag) {
            smsSendCache.saveCode(mobile, value);
        }
        return flag;
    }

    @Override
    public boolean verifyCode(String mobile, String code) {
        String value = smsSendCache.getCode(mobile);
        if (value != null) {
            // 删除短信验证码
            smsSendCache.deleteCode(mobile);

            // 效验
            return value.equalsIgnoreCase(code);
        }

        return false;
    }

    /**
     * 通过轮询算法，获取短信平台的配置
     *
     * @param groupName 分组名称
     * @return 短信平台配置
     */
    private SmsConfigVo roundSmsConfig(String groupName) {
        List<BaseConfigWhole> list = baseConfigWholeService.getByCfgCategory(CONFIG_SMS_CATEGORY);
        List<SmsConfigVo> configList = new ArrayList<>();
        if (list != null || list.size() > 0) {
            for (BaseConfigWhole baseConfigWhole : list) {
                SmsConfigVo config = JSONObject.parseObject(baseConfigWhole.getCfgCatagory(),
                    SmsConfigVo.class);
                configList.add(config);
            }
        } else {
            throw new CommonException("没有可用的短信平台，请先添加");
        }

        // 没有短信编码的情况
        if (StringUtils.isBlank(groupName)) {
            // 采用轮询算法，发送短信
            long round = smsConfigCache.getRoundValue();

            return configList.get((int) round % configList.size());
        }

        // 有短信编码的情况
        List<SmsConfigVo> newList = configList.stream()
            .filter(providerId -> StringUtils.equals(providerId.getGroupName(), groupName))
            .collect(Collectors.toList());
        if (newList.isEmpty()) {
            throw new CommonException("短信分组不存在");
        }

        long round = smsConfigCache.getRoundCodeValue();

        // 指定短信平台
        return newList.get((int) round % newList.size());
    }
}
