/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.manage.wechat;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.social.manage.constant.OpenTypeEnum;
import net.linlan.social.manage.vo.ThirdUserInfo;
import net.linlan.social.manage.wechat.service.WechatAuthService;

/**
 * 微信扫码、消息订阅等接口相关控制器
 * 
 * @author Linlan
 */
@Slf4j
@RestController
@RequestMapping("/api/open")
public class WechatOpenController {

    @Resource
    private WechatAuthService wechatAuthService;

    /**
     * 获取微信扫码登录验证码
     *
     * @return 微信登录扫码结果
     */
    @PlatLog(value = "获取微信扫码登录验证码", category = 10, srcCode = 1)
    @GetMapping("/wechat/getCode")
    public ResponseResult<String> getWechatLoginCode() {
        return ResponseResult.ok(wechatAuthService.getWechatLoginCode());
    }

    /**
     * 获取微信扫码是否已登录
     * @param loginCode 登录代码
     * @return 微信登录扫码状态
     */
    @PlatLog(value = "获取微信扫码是否已登录", category = 10, srcCode = 1)
    @GetMapping("/wechat/isLogin/{loginCode}")
    public ResponseResult<ThirdUserInfo> getWechatIsLogin(@PathVariable String loginCode) {
        return ResponseResult.ok(wechatAuthService.getWechatIsLogin(loginCode));
    }

    /**
     * 微信小程序登录
     * @param code 代码
     * @return 微信小程序登录结果
     */
    @PlatLog(value = "微信小程序登录", category = 10, srcCode = 1)
    @GetMapping("/wechat/miniLogin/{code}")
    public ResponseResult<ThirdUserInfo> miniLogin(@PathVariable String code) {
        return ResponseResult
            .ok(wechatAuthService.miniLogin(OpenTypeEnum.WECHAT_MINI.getKey(), code));
    }

}
