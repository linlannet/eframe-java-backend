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
package net.linlan.frame.view.admin.param;

import lombok.Data;

import net.linlan.sys.role.param.SysPositionParam;
import net.linlan.utils.param.BaseParam;

/**
 * 岗位查询对象
 * 
 * @author Linlan
 */
@Data
public class SysPositionVoParam extends BaseParam {

    /** 岗位编码 */
    private String  postCode;

    /** 岗位名称 */
    private String  postName;

    /** 状态（0未生效1正常2受限3锁定4删除） */
    private Integer status;

    /** 删除标记（0正常 1删除） */
    private Integer delFlag;

    public SysPositionParam toModelParam() {
        SysPositionParam result = new SysPositionParam();
        result.setCode(postCode);
        result.setName(postName);
        result.setStatus(status);
        result.setDelFlag(delFlag);
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        return result;
    }

}
