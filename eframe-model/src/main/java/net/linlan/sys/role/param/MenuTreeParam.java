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
package net.linlan.sys.role.param;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.sys.base.param.TreeParam;
import net.linlan.utils.param.BaseParam;

@Data
public class MenuTreeParam extends BaseParam {

    /**
     * 父节点id
     */
    private String parentId;
    /**
    * prantId
    */

    /**
     * 所属应用
     */
    private String appId;

    /**
     * 名字
     */
    private String key;

    /**
     * 功能类型
     */
    private String type;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 功能类型
     */
    private String gnType;

    /**
     * 刷新缓存：Y 是，N 否
     */
    private String refresh    = "N";
    /**
     * 是否显示button，默认不显示
     */
    private String showButton = "N";

    /**
     * 无参构造方法
     */
    public MenuTreeParam() {
    }

    /**
     * 数据赋值TO方法，将TreeParam的input对象赋值给MenuTreeParam
     */
    public static final Function TO = new Function<TreeParam, MenuTreeParam>() {
        @Nullable
        @Override
        public MenuTreeParam apply(@Nullable TreeParam input) {
            return new MenuTreeParam(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public MenuTreeParam(TreeParam input) {
        this.parentId = input.getParentId();
        this.appId = input.getAppId();
        this.key = input.getKey();
        this.type = input.getType();
        this.roleId = input.getRoleId();
        this.gnType = input.getGnType();
        this.refresh = input.getRefresh();
        this.showButton = input.getShowButton();
    }
}
