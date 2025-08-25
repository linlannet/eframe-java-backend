/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.admin.vo;

import lombok.Data;

/**
 *
 * LoginTokenVo视图域: 管理登录令牌表显示Vo类
 * @author Linlan
 * CreateTime 2024-09-01 19:01:51
 *
 */
@Data
public class CaptchaReturnVo {
    /**
     * 是否开启
     */
    private boolean captchaEnabled;
    /**
     * UUID
     */
    private String  uuid;
    /**
     * 图片验证码
     */
    private String  img;

    private String  code;

    /**
     * 无参构造方法
     */
    public CaptchaReturnVo() {
    }

}
