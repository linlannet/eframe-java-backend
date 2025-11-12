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
package net.linlan.social.manage.constant;

import java.util.List;

import com.google.common.collect.Lists;

import net.linlan.utils.enums.BaseEnumString;

/**
 * 身份源类型
 *
 * @author Linlan
 */
public enum ProviderCategory implements BaseEnumString {
                                                        /**
                                                         * 社交
                                                         */
                                                        social("social", "社交",
                                                               Lists.newArrayList(
                                                                   ProviderType.QQ_OAUTH,
                                                                   ProviderType.WECHAT_OAUTH,
                                                                   ProviderType.GITEE_OAUTH,
                                                                   ProviderType.GITHUB_OAUTH,
                                                                   ProviderType.ALIPAY_OAUTH)),
                                                        /**
                                                         * 企业
                                                         */
                                                        enterprise("enterprise", "企业", Lists
                                                            .newArrayList(
                                                                ProviderType.WECHAT_WORK_OAUTH,
                                                                ProviderType.DINGTALK_OAUTH,
                                                                ProviderType.FEISHU_OAUTH));

    /**
     * 键
     */
    private final String             key;
    /**
     * 值
     */
    private final String             value;

    /**
     * 提供商列表
     */
    private final List<ProviderType> providers;

    ProviderCategory(String key, String value, List<ProviderType> providers) {
        this.key = key;
        this.value = value;
        this.providers = providers;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    public List<ProviderType> getProviders() {
        return providers;
    }

    /**
     * 获取类型
     *
     * @param code 代码编码
     * @return {@link ProviderCategory}
     */
    public static ProviderCategory fromType(String code) {
        ProviderCategory[] values = values();
        for (ProviderCategory status : values) {
            if (String.valueOf(status.getKey()).equals(code)) {
                return status;
            }
        }
        throw new NullPointerException("未获取到对应平台");
    }
}
