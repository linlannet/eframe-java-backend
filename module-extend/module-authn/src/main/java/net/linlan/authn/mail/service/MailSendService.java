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
package net.linlan.authn.mail.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSONObject;

import cn.hutool.core.util.ArrayUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import net.linlan.authn.mail.cache.MailConfigCache;
import net.linlan.authn.mail.param.MailAliyunBatchSendParam;
import net.linlan.authn.mail.param.MailAliyunSendParam;
import net.linlan.authn.mail.param.MailLocalSendParam;
import net.linlan.authn.mail.utils.MailAliyunUtils;
import net.linlan.authn.mail.utils.MailLocalUtils;
import net.linlan.authn.mail.vo.MailConfigVo;
import net.linlan.commons.core.ExceptionUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.entity.BaseConfigWhole;
import net.linlan.sys.base.service.BaseConfigWholeService;
import net.linlan.utils.exception.CommonException;

/**
 * 邮件服务
 *
 * @author Linlan
 * 
 */
@Slf4j
@Service
@AllArgsConstructor
public class MailSendService {
    /**
     * 短信提供商配置分类ID
     */
    private static final String          CONFIG_MAIL_CATEGORY = "MailCategory";

    private final BaseConfigWholeService baseConfigWholeService;
    private final MailConfigCache        emailConfigCache;
    private final MailSendRecordService  mailSendRecordService;

    /**
     * 本地 发送邮件
     *
     * @param param 发送邮件参数
     * @return 发送状态
     */
    public boolean sendLocal(MailLocalSendParam param) {
        MailConfigVo config = roundEmailConfig(param.getGroupName());
        return sendLocal(param, config);
    }

    /**
     * 本地 发送邮件
     *
     * @param param 发送邮件参数
     * @param config 邮件配置
     * @return 发送状态
     */
    public boolean sendLocal(MailLocalSendParam param, MailConfigVo config) {
        try {
            new MailLocalUtils(config).sendEmail(param.getTos(), param.getSubject(),
                param.getContent(), param.isHtml(),
                ArrayUtil.toArray(param.getFiles(), File.class));
            mailSendRecordService.saveBySend(config, config.getMailFrom(), param.getTos(),
                param.getSubject(), param.getContent(), null);

            return true;
        } catch (Exception e) {
            log.error("本地发送邮件失败", e);
            String errorInfo = StringUtils.substring(ExceptionUtils.getStackTrace(e), 0, 800);
            mailSendRecordService.saveBySend(config, config.getMailFrom(), param.getTos(),
                param.getSubject(), param.getContent(), errorInfo);
            return false;
        }
    }

    /**
     * 阿里云 发送邮件
     *
     * @param param 发送邮件参数
     * @return 发送状态
     */
    public boolean sendAliyun(MailAliyunSendParam param) {
        MailConfigVo config = roundEmailConfig(param.getGroupName());

        return sendAliyun(param, config);
    }

    /**
     * 阿里云 发送邮件
     *
     * @param param 发送邮件参数
     * @param config 邮件配置
     * @return 发送状态
     */
    public boolean sendAliyun(MailAliyunSendParam param, MailConfigVo config) {
        try {
            new MailAliyunUtils(config).sendEmail(param.getFrom(), param.getFormAlias(),
                param.getTos(), param.getSubject(), param.getContent(), param.isHtml());
            mailSendRecordService.saveBySend(config, config.getMailFrom(), param.getTos(),
                param.getSubject(), param.getContent(), null);

            return true;
        } catch (Exception e) {
            log.error("阿里云发送邮件失败", e);
            String errorInfo = StringUtils.substring(ExceptionUtils.getStackTrace(e), 0, 800);
            mailSendRecordService.saveBySend(config, config.getMailFrom(), param.getTos(),
                param.getSubject(), param.getContent(), errorInfo);
            return false;
        }
    }

    /**
     * 阿里云 批量发送邮件
     *
     * @param param 发送邮件参数
     * @return 发送状态
     */
    public boolean batchSendAliyun(MailAliyunBatchSendParam param) {
        MailConfigVo config = roundEmailConfig(param.getGroupName());

        return batchSendAliyun(param, config);
    }

    /**
     * 阿里云 批量发送邮件
     *
     * @param param 发送邮件参数
     * @param config 邮件配置
     * @return 发送状态
     */
    public boolean batchSendAliyun(MailAliyunBatchSendParam param, MailConfigVo config) {
        try {
            new MailAliyunUtils(config).batchSendEmail(param.getFrom(), param.getReceiversName(),
                param.getTemplateName(), param.getTagName());
            mailSendRecordService.saveBySend(config, param.getFrom(), param.getReceiversName(),
                null, param.getTemplateName(), null);
            return true;
        } catch (Exception e) {
            log.error("阿里云发送邮件失败", e);
            String errorInfo = StringUtils.substring(ExceptionUtils.getStackTrace(e), 0, 800);
            mailSendRecordService.saveBySend(config, param.getFrom(), param.getReceiversName(),
                null, param.getTemplateName(), errorInfo);
            return false;
        }
    }

    /**
     * 通过轮询算法，获取邮件平台的配置
     *
     * @param groupName 分组名称
     * @return 邮件平台配置
     */
    private MailConfigVo roundEmailConfig(String groupName) {
        List<BaseConfigWhole> list = baseConfigWholeService.getByCfgCategory(CONFIG_MAIL_CATEGORY);
        List<MailConfigVo> configList = new ArrayList<>();
        if (list != null || list.size() > 0) {
            for (BaseConfigWhole baseConfigWhole : list) {
                MailConfigVo config = JSONObject.parseObject(baseConfigWhole.getCfgCatagory(),
                    MailConfigVo.class);
                configList.add(config);
            }
        } else {
            throw new CommonException("没有可用的邮件平台，请先添加");
        }
        // 没有分组的情况
        if (StringUtils.isBlank(groupName)) {
            // 采用轮询算法，发送邮件
            long round = emailConfigCache.getRoundValue();
            return configList.get((int) round % configList.size());
        }

        // 有分组的情况
        List<MailConfigVo> newList = configList.stream()
            .filter(providerName -> StringUtils.equals(providerName.getGroupName(), groupName))
            .collect(Collectors.toList());
        if (newList.isEmpty()) {
            throw new CommonException("邮件分组不存在");
        }

        long round = emailConfigCache.getRoundCodeValue();

        // 指定邮件平台
        return newList.get((int) round % newList.size());
    }

}
