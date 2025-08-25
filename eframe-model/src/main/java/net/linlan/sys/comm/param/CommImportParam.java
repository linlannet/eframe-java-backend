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
package net.linlan.sys.comm.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * CommImport数据域:应用基础通用导入查询参数实体类
 * @author Linlan
 * CreateTime 2022-10-20 17:47:23
 *
 */
@Data
public class CommImportParam extends BaseParam {

    /**
     * 应用ID
     */
    private String  appId;
    /**
     * 站点ID
     */
    private Long    siteId;
    /**
     * 导入数据材料类型，BDATA业务数据，BFILE业务附件
     */
    private String  type;
    /**
     * 导入子类型
     */
    private String  subType;
    /**
     * 名称
     */
    private String  name;
    /**
     * 外部文件路径
     */
    private String  outFilePath;
    /**
     * 导入目标表
     */
    private String  targetTable;
    /**
     * 导入方法函数代码
     */
    private String  funcCode;
    /**
     * 导入方法函数路径URL
     */
    private String  funcUrl;
    /**
     * 导入结果，SUCCESS成功ERROR错误EXCEPTION异常
     */
    private String  importResult;
    /**
     * 数据量，单位为条
     */
    private Integer dataNum;
    /**
     * 操作时间
     */
    private Date    opTime;
    /**
     * 操作人ID，通过TOKEN可直接获取
     */
    private String  opUserId;
    /**
     * 操作人名称，可为空，也可直接使用MEMBER的VIEW_NAME
     */
    private String  opUserName;
    /**
     * 操作部门ID
     */
    private String  opOrganId;
    /**
     * 操作部门名称
     */
    private String  opOrganName;
    /**
     * 状态：队列中、下载中、已完成
     */
    private String  status;
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
