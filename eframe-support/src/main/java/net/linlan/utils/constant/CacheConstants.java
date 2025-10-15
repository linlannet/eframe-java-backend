/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.constant;

/**
 * 缓存的key 常量
 * 
 * @author Linlan
 */
public class CacheConstants {
    /**
     * 登录用户TOKEN
     */
    public static final String LOGIN_TOKEN_KEY      = "login_tokens:";

    /**
     * 登录用户USER_ID
     */
    public static final String LOGIN_USER_ID_KEY    = "login_user_id:";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY     = "captcha_codes:";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY    = "repeat_submit:";

    /**
     * 限流 redis key
     */
    public static final String RATE_LIMIT_KEY       = "limit:";

    /**
     * 登录账户密码错误次数 redis key
     */
    public static final String PWD_ERR_CNT_KEY      = "pwd_err_count:";

    /**
     * 平台用户的ID，对平台信息（前台工程访问信息）进行缓存处理使用的KEY，缓存10分钟
     */
    public static final String PLAT_ACCOUNT_KEY     = "ll_account_id:";

    /**
     * 锁定缓存前缀
     */
    public static final String LOCK_KEY             = "lock_key:";

    /**
     * 参数管理 cache key
     */
    public static final String BASE_CONFIGWHOLE_KEY = "base_config:";

    /**
     * 字典管理 cache key
     */
    public static final String BASE_DICTIONARY_KEY  = "base_dictionary:";

    /**
     * redis 字典缓存前缀
     */
    public static final String BASE_XZQH_KEY = "base_xzqh:";
}
