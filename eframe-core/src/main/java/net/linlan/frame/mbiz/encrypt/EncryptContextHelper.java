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
package net.linlan.frame.mbiz.encrypt;

import java.util.Objects;

import org.springframework.util.Assert;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import net.linlan.frame.mbiz.constant.SettingConstants;
import net.linlan.sys.base.entity.BaseConfigWhole;
import net.linlan.sys.base.service.BaseConfigWholeService;
import net.linlan.utils.SpringContextUtils;
import net.linlan.utils.crypt.AESUtils;

/**
 * EncryptContextHelp
 *
 * @author Linlan
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EncryptContextHelper {

    private static final AESUtils AES_UTILS = new AESUtils(getAesSecret());

    public static String encrypt(String content) {
        return AES_UTILS.encrypt(content);
    }

    public static String decrypt(String content) {
        if (Objects.isNull(content)) {
            return null;
        }
        return AES_UTILS.decrypt(content);
    }

    /**
     * 获取AES秘钥
     *
     * @return  {@link String}
     */
    public static String getAesSecret() {
        BaseConfigWhole setting = SpringContextUtils.getBean(BaseConfigWholeService.class)
            .getByKey(SettingConstants.AES_SECRET);
        Assert.notNull(setting, "aes secret must not be null");
        return setting.getCfgValue();
    }

}
