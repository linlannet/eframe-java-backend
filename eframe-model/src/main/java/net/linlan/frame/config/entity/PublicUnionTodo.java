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
package net.linlan.frame.config.entity;

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * PublicUnionTodo数据域:统一超级待办实体类
 * @author Linlan
 * CreateTime 2023-10-02 22:29:22
 *
 */
@Data
public class PublicUnionTodo extends BaseEntity {

    /**
     * 记录ID
     */
    private String id;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 站点门户ID
     */
    private String foreignId;

    /**
     * 类型，外部则为OUT
     */
    private String type;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 待办创建时间
     */
    private Date   todoCreateTime;

    /**
     * 单据编号
     */
    private String todoId;

    /**
     * 单据类型
     */
    private String todoType;

    /**
     * 单据主题
     */
    private String todoName;

    /**
     * 单据摘要
     */
    private String todoAbstract;

    /**
     * 待办应用账户ID
     */
    private String todoAccountId;

    /**
     * 待办应用系统或账户名称
     */
    private String todoAccountName;

    /**
     * 待办应用应用ID
     */
    private String todoModuleId;

    /**
     * 待办应用应用名称
     */
    private String todoModuleName;

    /**
     * 待办应用用户ID
     */
    private String todoUserId;

    /**
     * 待办应用用户名称
     */
    private String todoUserName;

    /**
     * 待办应用机构ID
     */
    private String todoOrganId;

    /**
     * 待办应用机构名称
     */
    private String todoOrganName;

    /**
     * 待办流程节点名称
     */
    private String todoProcessName;

    /**
     * 待办流程节点状态码
     */
    private String todoProcessStatus;

    /**
     * 待办流程节点信息
     */
    private String todoProcessInfo;

    /**
     * 待办业务当前信息
     */
    private String todoCurrInfo;

    /**
     * 待办业务下一步信息
     */
    private String todoNextInfo;

    /**
     * 待办业务URL
     */
    private String todoUrl;

    /**
     * 单据业务标签
     */
    private String todoLabels;

    /**
     * 单据其他信息
     */
    private String todoContent;

    /**
     * 状态，0待办，1在办，10已办，20办结
     */
    private String status;

    /**
     * 操作人ID
     */
    private String opUserId;

    /**
     * 操作时间
     */
    private Date   opTime;

    /**
     * 操作单位ID
     */
    private String opOrganId;

    /**
     * 操作单位名称
     */
    private String opOrganName;

    /**
     * 备注
     */
    private String description;

    /**
     * 备用1
     */
    private String spare1;

    /**
     * 备用2
     */
    private String spare2;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }

    }

}
