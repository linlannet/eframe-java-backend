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
package net.linlan.frame.comm.vo;

import java.util.Date;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.sys.base.dto.TokenResponse;

/**
 *
 * AppLoginInfo视图域: 管理登录令牌表显示Vo类
 * @author Linlan
 * CreateTime 2024-09-01 19:01:51
 *
 */
@Data
public class AppLoginInfo {
    /**
     * 用户ID
     */
    private String  userId;
    /**
     * 令牌TOKEN
     */
    private String  token;
    /**
     * 更新时间
     */
    private Date    updateTime;
    /**
     * 过期时间
     */
    private Date    expireTime;
    /**
     * 是否有手机号码
     */
    private boolean isMobileConfirm = true;

    /**
     * 无参构造方法
     */
    public AppLoginInfo() {
    }

    /**
     * entity对象直接输出进行转换
     */
    public static final Function TO = new Function<TokenResponse, AppLoginInfo>() {
        @Nullable
        @Override
        public AppLoginInfo apply(@Nullable TokenResponse input) {
            return new AppLoginInfo(input);
        }
    };

    public AppLoginInfo(TokenResponse input) {
        this.token = input.getToken();
        this.expireTime = input.getExpireTime();
        this.isMobileConfirm = true;
    }
}
