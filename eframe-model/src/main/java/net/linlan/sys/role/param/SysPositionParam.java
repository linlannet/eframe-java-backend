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

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * SysPosition数据域:岗位信息查询参数实体类
 * @author Linlan
 * CreateTime 2020-08-12 14:19:06
 *
 */
@Data
public class SysPositionParam extends BaseParam {
    /**
     * 岗位id数组
     */
    private String[] ids;
    /**
    * 父岗位ID
    */
    private String   parentId;
    /**
    * 岗位分类ID
    */
    private String   postypeId;
    /**
    * 角色分类ID
    */
    private String   roletypeId;
    /**
    * 岗位名称
    */
    private String   name;
    /**
    * 岗位简称，别名
    */
    private String   sname;
    /**
    * UAS岗位id
    */
    private String   code;
    /**
    * 岗位别名
    */
    private String   oname;
    /**
    * 工作分工，二维码申请页面模板
    */
    private String   posFunction;
    /**
    * 级别
    */
    private Integer  posRank;
    /**
    * 岗位类型
    */
    private String   posType;
    /**
     * 岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定4删除
     */
    private Integer  status;
    /**
    * 是否公开0否1是
    */
    private Boolean  isPub;
    /**
    * 岗位移动手机
    */
    private String   mobilePhone;
    /**
    * 岗位办公电话
    */
    private String   officePhone;
    /**
    * 删除标志0正常1已删除2应用内受限3回收站
    */
    private Integer  delFlag;
    /**
    * 描述，岗位职责
    */
    private String   description;
    /**
     * 岗位ID
     */
    private String   positionId;
    /**
     * 分组Id
     */
    private String   groupId;
    /**
     * 编号id
     */
    private String   id;
    /**
     * 创建时间
     */
    private String   createTime;

}
