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
package net.linlan.frame.comm.vo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import lombok.Data;

import net.linlan.utils.entity.BaseEntity;

/**
 *
 * 动态模型对象数据域:通用表实体类
 * @author Linlan
 * CreateTime 2024-12-19 17:27:08
 *
 */
@Data
public class CommTable extends BaseEntity {
    private static final long     serialVersionUID = 1L;

    /** 模型编号，对应表编号 */
    private Long                  modelId;

    /** 表名称 */
    @NotBlank(message = "表名称不能为空")
    private String                tableName;

    /** 表描述 */
    @NotBlank(message = "表描述不能为空")
    private String                tableComment;

    /** 关联父表的表名 */
    private String                subTableName;

    /** 本表关联父表的外键名 */
    private String                subTableFkName;

    /** 实体类名称(首字母大写) */
    @NotBlank(message = "实体类名称不能为空")
    private String                className;

    /** 使用的模板（crud单表操作 tree树表操作 sub主子表操作） */
    private String                tplCategory;

    /** 前端类型（element-ui模版 element-plus模版） */
    private String                tplWebType;

    /** 生成包路径 */
    @NotBlank(message = "生成包路径不能为空")
    private String                packageName;

    /** 生成模块名 */
    @NotBlank(message = "生成模块名不能为空")
    private String                moduleName;

    /** 生成业务名 */
    @NotBlank(message = "生成业务名不能为空")
    private String                businessName;

    /** 生成功能名 */
    @NotBlank(message = "生成功能名不能为空")
    private String                functionName;

    /** 生成作者 */
    @NotBlank(message = "作者不能为空")
    private String                functionAuthor;

    /** 表单布局，单列 双列 三列 */
    private int                   formColNum;

    /** 生成代码方式（0zip压缩包 1自定义路径） */
    private String                genType;

    /** 生成路径（不填默认项目路径） */
    private String                genPath;

    /** 主键信息 */
    private CommTableColumn       pkColumn;

    /** 子表信息 */
    private CommTable             subTable;

    /** 表列信息 */
    @Valid
    private List<CommTableColumn> columns;

    /** 其它生成选项 */
    private String                optionLists;

    /** 树编码字段 */
    private String                treeCode;

    /** 树父编码字段 */
    private String                treeParentCode;

    /** 树名称字段 */
    private String                treeName;

    /** 上级菜单ID字段 */
    private Long                  parentMenuId;

    /** 上级菜单名称字段 */
    private String                parentMenuName;

    /** 备注 */
    private String                Description;
    /**
     * 分页信息：默认第1页
     */
    private Integer               page             = 1;
    /**
     * 分页每页条数，默认10条
     */
    private Integer               limit            = 10;

}
