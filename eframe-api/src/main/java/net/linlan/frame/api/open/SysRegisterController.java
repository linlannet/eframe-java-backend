/*
 * eframe-api - api接口网关模块
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
package net.linlan.frame.api.open;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.admin.service.InitialConfigService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.manager.AdminUserOpManager;
import net.linlan.frame.web.model.RegisterBody;

/**
 * 用户注册验证
 * 
 * @author Linlan
 */
@RestController
public class SysRegisterController extends BaseController {
    @Resource
    private AdminUserOpManager   adminUserOpManager;

    @Resource
    private InitialConfigService initialConfigService;

    /**
     * 系统用户注册
     * @param user  注册用户对象
     * @return  返回对象
     */
    @PlatLog(value = "系统用户注册", category = 10)
    @PostMapping("/register")
    @Encrypt
    @LimitScope(name = "adminUserRegister", key = "adminUserRegister")
    public ResponseResult<String> register(@RequestBody RegisterBody user) {
        if (!("true".equals(initialConfigService.selectConfigByKey("sys.account.registerUser")))) {
            return error("当前系统没有开启注册功能！");
        }
        String msg = adminUserOpManager.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
