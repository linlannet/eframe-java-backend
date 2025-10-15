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
package net.linlan.frame.admin.param;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * AdminDept数据域:系统机构部门查询参数实体类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Data
public class AdminDeptParam extends BaseParam {

    /**
     * 单位ID
     */
    private Long    deptId;
    /**
     * 系统机构ID
     */
    private String  organId;
    /**
     * 父节点
     */
    private Long    parentId;
    /**
     * 应用ID
     */
    private String  appId;
    /**
     * 部门分类ID
     */
    private Long    depttypeId;
    /**
     * 外部业务ID
     */
    private String  foreignId;
    /**
     * 创建方式0导入1录入2授权
     */
    private Integer createType;
    /**
     * 部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构
     */
    private String  type;
    /**
     * 名称，多级累加名称
     */
    private String  name;
    /**
     * 名称简称，本单位显示名称
     */
    private String  sname;
    /**
     * 地域编码，所在城市
     */
    private String  areaCode;
    /**
     * 领导名称
     */
    private String  organLeader;
    /**
     * 负责人ID，用户接收相关信息
     */
    private String  leaderId;
    /**
     * 负责人手机号码，用户接收相关信息
     */
    private String  leaderMobile;
    /**
     * 是否机构本级1是0否默认1
     */
    private Boolean isOrganLevel;
    /**
     * 是否虚拟节点1是0不是默认0
     */
    private Boolean isVirtual;
    /**
     * 是否叶子节点
     */
    private Boolean isLeaf;
    /**
     * 是否禁用0否1是
     */
    private Boolean isDisabled;
    /**
     * 多级累加路径
     */
    private String  searchCode;
    /**
     * 图片路径
     */
    private String  imagePath;
    /**
     * 状态0未生效1正常2受限3锁定4删除
     */
    private Integer status;
    /**
     * 创建用户ID
     */
    private String  creatorId;
    /**
     * 是否删除1已删除0正常
     */
    private Integer delFlag;
    /**
     * 描述
     */
    private String  description;
    /**
     * 备用1
     */
    private String  spare1;
    /**
     * 备用2
     */
    private String  spare2;

}
