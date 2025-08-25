/*
 * module-generator - generator代码生成模块
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
package net.linlan.tools.generator.util;

import java.util.*;

import org.apache.velocity.VelocityContext;

import com.alibaba.fastjson2.JSONObject;

import net.linlan.commons.core.DateUtils;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.tools.generator.config.GenConfig;
import net.linlan.tools.generator.constant.GenConstants;
import net.linlan.tools.generator.entity.GenTable;
import net.linlan.tools.generator.entity.GenTableColumn;
import net.linlan.utils.constant.Constants;

/**
 * 模板处理工具类
 * 
 * @author Linlan
 */
public class VelocityUtils {
    /** 项目空间路径 */
    private static final String PROJECT_PATH           = "main/java";

    /** mybatis空间路径 */
    private static final String MYBATIS_PATH           = "main/resources/mapper";

    /** html空间路径 */
    private static final String TEMPLATES_PATH         = "main/resources/templates";
    /** 默认上级菜单，系统工具 */
    private static final String DEFAULT_PARENT_MENU_ID = "3";

    /**
     * 设置模板变量信息
     * @param genTable 表对象
     * @return 模板列表
     */
    public static VelocityContext prepareContext(GenTable genTable) {
        String moduleName = genTable.getModuleName();
        String businessName = genTable.getBusinessName();
        String packageName = genTable.getPackageName();
        String tplCategory = genTable.getTplCategory();
        String functionName = genTable.getFunctionName();

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("tplCategory", genTable.getTplCategory());
        velocityContext.put("tableName", genTable.getTableName());
        velocityContext.put("functionName",
            ObjectUtils.isNotEmpty(functionName) ? functionName : "【请填写功能名称】");
        velocityContext.put("ClassName", genTable.getClassName());
        velocityContext.put("className", StringUtils.uncapitalize(genTable.getClassName()));
        velocityContext.put("moduleName", genTable.getModuleName());
        velocityContext.put("BusinessName", StringUtils.capitalize(genTable.getBusinessName()));
        velocityContext.put("businessName", genTable.getBusinessName());
        velocityContext.put("basePackage", getPackagePrefix(packageName));
        velocityContext.put("packageName", packageName);
        velocityContext.put("author", genTable.getFunctionAuthor());
        velocityContext.put("colXsNum", getColXsNum(genTable.getFormColNum()));
        velocityContext.put("colSmNum", getColSmNum(genTable.getFormColNum()));
        velocityContext.put("datetime", DateUtils.formatDate(new Date()));
        velocityContext.put("pkColumn", genTable.getPkColumn());
        velocityContext.put("importList", getImportList(genTable));
        velocityContext.put("permissionPrefix", getPermissionPrefix(moduleName, businessName));
        velocityContext.put("columns", genTable.getColumns());
        velocityContext.put("table", genTable);
        velocityContext.put("dicts", getDicts(genTable));
        setMenuVelocityContext(velocityContext, genTable);
        if (GenConstants.TPL_TREE.equals(tplCategory)) {
            setTreeVelocityContext(velocityContext, genTable);
        }
        if (GenConstants.TPL_SUB.equals(tplCategory)) {
            setSubVelocityContext(velocityContext, genTable);
        }
        return velocityContext;
    }

    public static void setMenuVelocityContext(VelocityContext context, GenTable genTable) {
        String options = genTable.getOptionLists();
        JSONObject paramsObj = JSONObject.parseObject(options);
        String parentMenuId = getParentMenuId(paramsObj);
        context.put("parentMenuId", parentMenuId);
        context.put("menuId", RandomUtils.randomLid());
        context.put("defAppId", Constants.ENT_APP_ID);
        context.put("code", RandomUtils.randomCode());
    }

    public static void setTreeVelocityContext(VelocityContext context, GenTable genTable) {
        String options = genTable.getOptionLists();
        JSONObject paramsObj = JSONObject.parseObject(options);
        String treeCode = getTreecode(paramsObj);
        String treeParentCode = getTreeParentCode(paramsObj);
        String treeName = getTreeName(paramsObj);

        context.put("treeCode", treeCode);
        context.put("treeParentCode", treeParentCode);
        context.put("treeName", treeName);
        context.put("expandColumn", getExpandColumn(genTable));
        if (paramsObj.containsKey(GenConstants.TREE_PARENT_CODE)) {
            context.put("tree_parent_code", paramsObj.getString(GenConstants.TREE_PARENT_CODE));
        }
        if (paramsObj.containsKey(GenConstants.TREE_NAME)) {
            context.put("tree_name", paramsObj.getString(GenConstants.TREE_NAME));
        }
    }

    public static void setSubVelocityContext(VelocityContext context, GenTable genTable) {
        GenTable subTable = genTable.getSubTable();
        String subTableName = genTable.getSubTableName();
        String subTableFkName = genTable.getSubTableFkName();
        String subClassName = genTable.getSubTable().getClassName();
        String subTableFkClassName = StringUtils.convertToCamelCase(subTableFkName);

        context.put("subTable", subTable);
        context.put("subTableName", subTableName);
        context.put("subTableFkName", subTableFkName);
        context.put("subTableFkClassName", subTableFkClassName);
        context.put("subTableFkclassName", StringUtils.uncapitalize(subTableFkClassName));
        context.put("subClassName", subClassName);
        context.put("subclassName", StringUtils.uncapitalize(subClassName));
        context.put("subImportList", getImportList(genTable.getSubTable()));
    }

    /**
     * 获取模板信息
     * @param tplCategory 生成的模板
     * @param tplWebType 前端类型
     * @return 模板列表
     */
    public static List<String> getTemplateList(String tplCategory, String tplWebType) {
        String useWebType = "vm/vue";
        if ("element-ui".equals(tplWebType)) {
            useWebType = "vm/vue/v2";
        }
        List<String> templates = new ArrayList<String>();
        templates.add("vm/java/model/Entity.java.vm");
        templates.add("vm/java/model/Dto.java.vm");
        templates.add("vm/java/model/Param.java.vm");
        templates.add("vm/java/model/Dao.java.vm");
        templates.add("vm/java/model/Service.java.vm");
        templates.add("vm/xml/dao.xml.vm");
        templates.add("vm/sql/sql.vm");
        if (GenConstants.TPL_CRUD.equals(tplCategory)) {
            templates.add("vm/java/model/Controller.java.vm");
            templates.add("vm/vue/api.js.vm");
            templates.add(useWebType + "/index.vue.vm");
            //            templates.add("vm/html/list.html.vm");
            //            templates.add("vm/html/add.html.vm");
            //            templates.add("vm/html/edit.html.vm");
        } else if (GenConstants.TPL_TREE.equals(tplCategory)) {
            templates.add("vm/java/model/Controller.java.vm");
            templates.add("vm/vue/api.js.vm");
            templates.add(useWebType + "/index-tree.vue.vm");
            //            templates.add("vm/html/tree.html.vm");
            //            templates.add("vm/html/add.html.vm");
            //            templates.add("vm/html/edit.html.vm");
            //            templates.add("vm/html/list-tree.html.vm");
        } else if (GenConstants.TPL_SUB.equals(tplCategory)) {
            templates.add("vm/java/model/Controller.java.vm");
            templates.add("vm/java/model/SubEntity.java.vm");
            templates.add("vm/vue/api.js.vm");
            templates.add(useWebType + "/index.vue.vm");
            //            templates.add("vm/html/list.html.vm");
            //            templates.add("vm/html/add.html.vm");
            //            templates.add("vm/html/edit.html.vm");
        } else if (GenConstants.TPL_JSON.equals(tplCategory)) {
            templates.add("vm/java/model/Controller.java.vm");
            templates.add("vm/vue/api.js.vm");
            templates.add(useWebType + "/index.vue.vm");
            templates.add("vm/vue/json/data.json.vm");
        } else if (GenConstants.TPL_VO.equals(tplCategory)) {
            templates.add("vm/java/controller/EntryApi.java.vm");
            templates.add("vm/java/controller/OpApi.java.vm");
            templates.add("vm/java/view/EntryManager.java.vm");
            templates.add("vm/java/view/OpManager.java.vm");
            templates.add("vm/java/view/Vo.java.vm");
            templates.add("vm/vue/json/data.json.vm");
        }
        return templates;
    }

    /**
     * 获取文件名
     * @param genTable 表对象
     * @param template 模板名称
     * @return 渲染后的文件
     */
    public static String getFileName(String template, GenTable genTable) {
        // 文件名称
        String fileName = "";
        // 包路径
        String packageName = genTable.getPackageName();
        // 模块名
        String moduleName = genTable.getModuleName();
        // 大写类名
        String className = genTable.getClassName();
        // 业务名称
        String businessName = genTable.getBusinessName();

        String javaPath = PROJECT_PATH + "/" + StringUtils.replace(packageName, ".", "/");
        String mybatisPath = MYBATIS_PATH + "/" + StringUtils.replace(packageName, ".", "/") + "/"
                             + moduleName;
        String vuePath = "vue";
        String htmlPath = TEMPLATES_PATH + "/" + moduleName + "/" + businessName;

        if (template.contains("Entity.java.vm")) {
            fileName = StringUtils.format("{}/entity/{}.java", javaPath, className);
        }
        if (template.contains("Dto.java.vm")) {
            fileName = StringUtils.format("{}/dto/{}Dto.java", javaPath, className);
        }
        if (template.contains("Param.java.vm")) {
            fileName = StringUtils.format("{}/param/{}Param.java", javaPath, className);
        }
        if (template.contains("SubEntity.java.vm")
            && StringUtils.equals(GenConstants.TPL_SUB, genTable.getTplCategory())) {
            fileName = StringUtils.format("{}/entity/{}.java", javaPath,
                genTable.getSubTable().getClassName());
        } else if (template.contains("Dao.java.vm")) {
            fileName = StringUtils.format("{}/dao/{}Dao.java", javaPath, className);
        } else if (template.contains("Service.java.vm")) {
            fileName = StringUtils.format("{}/service/{}Service.java", javaPath, className);
        } else if (template.contains("Controller.java.vm")) {
            fileName = StringUtils.format("{}/controller/{}Controller.java", javaPath, className);
        } else if (template.contains("dao.xml.vm")) {
            fileName = StringUtils.format("{}/{}Dao.xml", mybatisPath, className);
        } else if (template.contains("sql.vm")) {
            fileName = businessName + "Menu.sql";
        } else if (template.contains("api.js.vm")) {
            fileName = StringUtils.format("{}/api/{}/{}.js", vuePath, moduleName, businessName);
        } else if (template.contains("index.vue.vm")) {
            fileName = StringUtils.format("{}/views/{}/{}/index.vue", vuePath, moduleName,
                businessName);
        } else if (template.contains("index-tree.vue.vm")) {
            fileName = StringUtils.format("{}/views/{}/{}/index.vue", vuePath, moduleName,
                businessName);
        } else if (template.contains("data.json.vm")) {
            fileName = StringUtils.format("{}/views/{}/{}/data.json", vuePath, moduleName,
                businessName);
        }
        //20241103 添加ruoyi最新的html版本
        else if (template.contains("list.html.vm")) {
            fileName = StringUtils.format("{}/{}.html", htmlPath, businessName);
        } else if (template.contains("list-tree.html.vm")) {
            fileName = StringUtils.format("{}/{}.html", htmlPath, businessName);
        } else if (template.contains("tree.html.vm")) {
            fileName = StringUtils.format("{}/tree.html", htmlPath);
        } else if (template.contains("add.html.vm")) {
            fileName = StringUtils.format("{}/add.html", htmlPath);
        } else if (template.contains("edit.html.vm")) {
            fileName = StringUtils.format("{}/edit.html", htmlPath);
        }
        //20241031 增加复杂业务vo对象和manager，独立两个读写Api
        else if (template.contains("EntryApi.java.vm")) {
            fileName = StringUtils.format("{}/api/{}EntryApi.java", javaPath, className);
        } else if (template.contains("OpApi.java.vm")) {
            fileName = StringUtils.format("{}/api/{}OpApi.java", javaPath, className);
        } else if (template.contains("EntryManager.java.vm")) {
            fileName = StringUtils.format("{}/view/{}EntryManager.java", javaPath, className);
        } else if (template.contains("OpManager.java.vm")) {
            fileName = StringUtils.format("{}/view/{}OpManager.java", javaPath, className);
        } else if (template.contains("Vo.java.vm")) {
            fileName = StringUtils.format("{}/view/{}Vo.java", javaPath, className);
        }
        return fileName;
    }

    /**
     * 获取项目文件路径
     * 
     * @return 路径
     */
    public static String getProjectPath() {
        String packageName = GenConfig.getPackageName();
        StringBuffer projectPath = new StringBuffer();
        projectPath.append("main/java/");
        projectPath.append(packageName.replace(".", "/"));
        projectPath.append("/");
        return projectPath.toString();
    }

    /**
     * 获取包前缀
     *
     * @param packageName 包名称
     * @return 包前缀名称
     */
    public static String getPackagePrefix(String packageName) {
        int lastIndex = packageName.lastIndexOf(".");
        return StringUtils.substring(packageName, 0, lastIndex);
    }

    /**
     * 根据列类型获取导入包
     * 
     * @param genTable 表对象
     * @return 返回需要导入的包列表
     */
    public static HashSet<String> getImportList(GenTable genTable) {
        List<GenTableColumn> columns = genTable.getColumns();
        GenTable subGenTable = genTable.getSubTable();
        HashSet<String> importList = new HashSet<String>();
        if (ObjectUtils.isNotEmpty(subGenTable)) {
            importList.add("java.util.List");
        }
        for (GenTableColumn column : columns) {
            if (!column.isSuperColumn() && GenConstants.TYPE_DATE.equals(column.getJavaType())) {
                importList.add("java.util.Date");
                importList.add("com.fasterxml.jackson.annotation.JsonFormat");
            } else if (!column.isSuperColumn()
                       && GenConstants.TYPE_BIGDECIMAL.equals(column.getJavaType())) {
                importList.add("java.math.BigDecimal");
            }
        }
        return importList;
    }

    /**
     * 根据列类型获取字典组
     * 
     * @param genTable 表对象
     * @return 返回字典组
     */
    public static String getDicts(GenTable genTable) {
        List<GenTableColumn> columns = genTable.getColumns();
        Set<String> dicts = new HashSet<String>();
        addDicts(dicts, columns);
        if (ObjectUtils.isNotEmpty(genTable.getSubTable())) {
            List<GenTableColumn> subColumns = genTable.getSubTable().getColumns();
            addDicts(dicts, subColumns);
        }
        return StringUtils.join(dicts, ", ");
    }

    /**
     * 添加字典列表
     * 
     * @param dicts 字典列表
     * @param columns 列集合
     */
    public static void addDicts(Set<String> dicts, List<GenTableColumn> columns) {
        for (GenTableColumn column : columns) {
            if (!column.isSuperColumn() && ObjectUtils.isNotEmpty(column.getDictType())
                && StringUtils.equalsAny(column.getHtmlType(),
                    new String[] { GenConstants.HTML_SELECT, GenConstants.HTML_RADIO,
                                   GenConstants.HTML_CHECKBOX })) {
                dicts.add("'" + column.getDictType() + "'");
            }
        }
    }

    /**
     * 获取权限前缀
     *
     * @param moduleName 模块名称
     * @param businessName 业务名称
     * @return 返回权限前缀
     */
    public static String getPermissionPrefix(String moduleName, String businessName) {
        return StringUtils.format("{}:{}", moduleName, businessName);
    }

    /**
     * 获取上级菜单ID字段
     *
     * @param paramsObj 生成其他选项
     * @return 上级菜单ID字段
     */
    public static String getParentMenuId(JSONObject paramsObj) {
        if (ObjectUtils.isNotEmpty(paramsObj) && paramsObj.containsKey(GenConstants.PARENT_MENU_ID)
            && ObjectUtils.isNotEmpty(paramsObj.getString(GenConstants.PARENT_MENU_ID))) {
            return paramsObj.getString(GenConstants.PARENT_MENU_ID);
        }
        return DEFAULT_PARENT_MENU_ID;
    }

    /**
     * 获取树编码
     *
     * @param paramsObj 生成其他选项
     * @return 树编码
     */
    public static String getTreecode(JSONObject paramsObj) {
        if (paramsObj.containsKey(GenConstants.TREE_CODE)) {
            return StringUtils.toCamelCase(paramsObj.getString(GenConstants.TREE_CODE));
        }
        return StringUtils.EMPTY;
    }

    /**
     * 获取树父编码
     *
     * @param paramsObj 生成其他选项
     * @return 树父编码
     */
    public static String getTreeParentCode(JSONObject paramsObj) {
        if (paramsObj.containsKey(GenConstants.TREE_PARENT_CODE)) {
            return StringUtils.toCamelCase(paramsObj.getString(GenConstants.TREE_PARENT_CODE));
        }
        return StringUtils.EMPTY;
    }

    /**
     * 获取树名称
     *
     * @param paramsObj 生成其他选项
     * @return 树名称
     */
    public static String getTreeName(JSONObject paramsObj) {
        if (paramsObj.containsKey(GenConstants.TREE_NAME)) {
            return StringUtils.toCamelCase(paramsObj.getString(GenConstants.TREE_NAME));
        }
        return StringUtils.EMPTY;
    }

    /**
     * 获取需要在哪一列上面显示展开按钮
     *
     * @param genTable 表对象
     * @return 展开按钮列序号
     */
    public static int getExpandColumn(GenTable genTable) {
        String options = genTable.getOptionLists();
        JSONObject paramsObj = JSONObject.parseObject(options);
        String treeName = paramsObj.getString(GenConstants.TREE_NAME);
        int num = 0;
        for (GenTableColumn column : genTable.getColumns()) {
            if (column.isList()) {
                num++;
                String columnName = column.getColumnName();
                if (columnName.equals(treeName)) {
                    break;
                }
            }
        }
        return num;
    }

    /**
     * 获取表单排列网格
     * 
     * @param formColNum 表单布局方式
     * @return 排列类样式
     */
    public static String getColXsNum(int formColNum) {
        String colXsNum = "col-xs-12";
        if (formColNum == 2) {
            return "col-xs-6";
        } else if (formColNum == 3) {
            return "col-xs-4";
        }
        return colXsNum;
    }

    /**
     * 获取表单label网格
     * 
     * @param formColNum 表单布局方式
     * @return 网格类样式
     */
    public static String getColSmNum(int formColNum) {
        String colSmNum = "col-sm-3";
        if (formColNum == 2 || formColNum == 3) {
            return "col-sm-4";
        }
        return colSmNum;
    }
}
