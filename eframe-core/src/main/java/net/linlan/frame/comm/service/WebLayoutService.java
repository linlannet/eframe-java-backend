/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.comm.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.admin.dto.AppConfigDto;
import net.linlan.frame.admin.dto.WebLayoutDto;
import net.linlan.frame.admin.dto.WorkConfigDto;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.web.RedisService;

@Service
public class WebLayoutService {

    @Resource
    public RedisService redisService;

    /**
     * 获取平台基本配置对象
     * @param coreAccount   平台账户
     * @return    查询结果
     */
    public WebLayoutDto getPlatConfInfoDto(CoreAccount coreAccount) {
        WebLayoutDto platConfInfoDto = new WebLayoutDto();
        platConfInfoDto.setId(coreAccount.getId());
        platConfInfoDto.setIsAdmin(coreAccount.getIsAdmin());
        platConfInfoDto.setPublicKey("loginPublicKey");
        platConfInfoDto.setClientId(coreAccount.getClientId());
        platConfInfoDto.setAesKey(coreAccount.getAesKey());
        platConfInfoDto.setServerUrl(coreAccount.getServerUrl());
        platConfInfoDto.setServerConf1(coreAccount.getServerConf1());
        platConfInfoDto.setIsWork(false);
        platConfInfoDto.setIsEncryt(true);
        AppConfigDto appConfigDto = getAppConfigDto(coreAccount);
        platConfInfoDto.setAppConf(appConfigDto);
        //如果type为 1   则为work端
        if (coreAccount.getType() == 1) {
            platConfInfoDto.setIsWork(true);
            WorkConfigDto workConfigDto = getWorkConfigDto();
            platConfInfoDto.setWorkConfig(workConfigDto);
        }
        return platConfInfoDto;
    }

    /**
     * 获取work基本配置对象
     * @return    返回结果
     */
    private WorkConfigDto getWorkConfigDto() {
        WorkConfigDto workConfigDto = new WorkConfigDto();
        workConfigDto.setLayout("default");
        return workConfigDto;
    }

    /**
     * 获取App基本配置对象
     * @param   coreAccount    平台账户
     * @return    返回结果
     */
    private AppConfigDto getAppConfigDto(CoreAccount coreAccount) {
        String appId = coreAccount.getAppId();
        if (StringUtils.isNotBlank(appId)) {
            AppConfigDto appConfigDto = new AppConfigDto();
            appConfigDto.setAppId(appId);
            appConfigDto.setAppConfJson(null);
            return appConfigDto;
        }
        return null;
    }

}
