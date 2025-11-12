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
package net.linlan.social.permission.constant;

import net.linlan.utils.enums.BaseEnumInteger;

/**
 * 人员所属机构类型
 */
public enum RangePowerEnum implements BaseEnumInteger {
                                                       /**
                                                        * 属于
                                                        */
                                                       SHUYU(10, "属于"),
                                                       /**
                                                        * 自有房屋
                                                        */
                                                       ZIYOUFANGWU(11, "属于"),
                                                       /**
                                                        * 租赁房屋
                                                        */
                                                       ZULINFANGWU(12, "租赁房屋"),
                                                       /**
                                                        * 群租房屋
                                                        */
                                                       QUNZUFANGWU(10, "群租房屋"),
                                                       /**
                                                        * 管理
                                                        */
                                                       GUANLI(20, "管理"),
                                                       /**
                                                        * 服务
                                                        */
                                                       FUWU(30, "服务"),
                                                       /**
                                                        * 10属于所属，20管理30服务90其他
                                                        */
                                                       QITA(90, "其他"),;

    /**
     * 配置项名称
     */
    private int    key;
    /**
     * 字典值
     */
    private String value;

    RangePowerEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
