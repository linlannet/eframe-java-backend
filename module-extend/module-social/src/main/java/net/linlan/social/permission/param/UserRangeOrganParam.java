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
package net.linlan.social.permission.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * UserRangeOrgan数据域:人员应用范围机构关联查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-29 13:55:02 *
 */
@Data
public class UserRangeOrganParam extends BaseParam {

    /**
     * 机构ID
     */
    private String   organId;
    /**
     * 会员ID，用户的LONG类型ID，管理用户ID
     */
    private Long     userlId;
    /**
     * 岗位ID
     */
    private String   positionId;
    /**
     * 机构下级单位ID
     */
    private Long     deptId;
    /**
     * 外键ID，备用ID，地域ID
     */
    private String   foreignId;
    /**
     * 是否会员0否1是
     */
    private Boolean  isMember;
    /**
     * 类型：0所属1挂靠2虚拟，10小区生活，11小区房屋关系，20物业服务，21志愿服务22生活服务30公共设施服务
     */
    private Integer  type;
    /**
     * 类型，10属于所属，11自有房屋12租赁房屋13群租房屋20管理30服务90其他
     */
    private Integer  power;
    /**
     * 是否主岗位0否1是
     */
    private Boolean  isDef;
    /**
     * 是否删除1已删除0正常
     */
    private Integer  delFlag;
    /**
     * 状态0未生效1正常2受限3锁定4删除
     */
    private Integer  status;
    /**
     * 创建人ID
     */
    private String   creatorId;
    /**
     * 更新人ID
     */
    private String   updatorId;
    /**
     * 更新时间
     */
    private Date     updateTime;
    /**
     * 备用1，具体为TYPE和POWER结合的信息，如房屋地址
     */
    private String   spare1;
    /**
     * 备用2
     */
    private String   spare2;
    /**
     * 基层类型，XZC行政村，DZB党支部，GZZ工作站
     */
    private String   wlType;
    /**
     * 系统管理用户ID
     */
    private String   userId;
    /**
     * id集合
     */
    private String[] ids;
}
