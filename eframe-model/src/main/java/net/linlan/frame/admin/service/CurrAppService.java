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

import net.linlan.commons.core.StringUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.utils.config.PlatformConfig;
import static net.linlan.frame.web.SecurityUtils.getLoginUser;
import static net.linlan.utils.constant.Constants.ENT_APP_ID;

@Service
public class CurrAppService {

    /** 查询配置文件中是否存在开启APP切换的配置，先判断配置文件是否开启，然后查询全局用户变量
     * @return  当前appId
     */
    public String getCurrAppId() {
        String result = "";
        // 是否开启app全局切换
        boolean openAppChange = PlatformConfig.isOpenAppChange();
        if (openAppChange) {
            FrameUserDetails loginUser = getLoginUser();
            String lastAppId = loginUser.getAppId();
            if (StringUtils.isNotBlank(lastAppId)) {
                result = lastAppId;
            } else {
                result = ENT_APP_ID;
            }
        }
        return result;
    }

}
