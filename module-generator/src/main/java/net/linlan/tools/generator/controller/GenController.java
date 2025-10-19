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
package net.linlan.tools.generator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.github.pagehelper.Page;

import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.tools.generator.entity.GenTable;
import net.linlan.tools.generator.entity.GenTableColumn;
import net.linlan.tools.generator.service.GenTableColumnService;
import net.linlan.tools.generator.service.GenTableService;
import net.linlan.utils.sql.SqlUtil;
import net.linlan.utils.text.Convert;

/**
 * 代码生成操作处理
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/tool/")
public class GenController extends BaseController {
    @Resource
    private GenTableService       genTableService;

    @Resource
    private GenTableColumnService genTableColumnService;

    /**
     * 查询代码生成列表
     * @param genTable 表对象
     * @return 当前全部表
     */
    @PlatLog(value = "查询代码生成列表")
    @PreAuthorize("@ss.hasPerms('tool:gen:list')")
    @GetMapping("gen/list")
    public ResponseResult<List<GenTable>> genList(GenTable genTable) {
        List<GenTable> list = genTableService.selectGenTableList(genTable);
        return success(list);
    }

    /**
     * 查询某个表的全部字段
     * @param tableId 表对象ID
     * @return 表的全部字段
     */
    @PlatLog(value = "查询某个表的全部字段")
    @PreAuthorize("@ss.hasPerms('tool:gen:detail')")
    @GetMapping(value = "gen/{tableId}")
    public ResponseResult<Map<String, Object>> getInfo(@PathVariable Long tableId) {
        GenTable table = genTableService.selectGenTableById(tableId);
        List<GenTable> tables = genTableService.selectGenTableAll();
        List<GenTableColumn> list = genTableColumnService
            .selectGenTableColumnListByTableId(tableId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("info", table);
        map.put("rows", list);
        map.put("tables", tables);
        return success(map);
    }

    /**
     * 查询数据库分页
     * @param genTable 表对象
     * @return 当前数据库内全部表分页
     */
    @PlatLog(value = "查询数据库分页")
    @PreAuthorize("@ss.hasPerms('tool:gen:list')")
    @GetMapping("gen/db/list")
    public ResponseResult<Page<GenTable>> dataList(GenTable genTable) {
        Page<GenTable> list = genTableService.selectDbTablePageDto(genTable);
        return successPage(list.getResult(), list.getPageSize(), list.getPageNum(),
            list.getTotal());
    }

    /**
     * 查询数据表字段列表
     * @param tableId 表对象ID
     * @return 表的全部字段
     */
    @PlatLog(value = "查询数据表字段列表")
    @PreAuthorize("@ss.hasPerms('tool:gen:list')")
    @GetMapping(value = "gen/column/{tableId}")
    public ResponseResult<List<GenTableColumn>> columnList(Long tableId) {
        List<GenTableColumn> list = genTableColumnService
            .selectGenTableColumnListByTableId(tableId);
        return success(list);
    }

    /**
     * 导入表结构（保存）
     * @param tables 表名称前缀
     * @return 表的全部代码
     */
    @PreAuthorize("@ss.hasPerms('tool:gen:import')")
    @PlatLog(value = "导入表结构（保存）", category = 51)
    @PostMapping("gen/importTable")
    public ResponseResult<String> importTableSave(String tables) {
        String[] tableNames = Convert.toStrArray(tables);
        // 查询表信息
        List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
        genTableService.importGenTable(tableList, SecurityUtils.getUsername());
        return success();
    }

    /**
     * 创建表结构（保存）
     * @param sql   SQL脚本
     * @return 创建表结构SQL
     */
    @PlatLog(value = "创建表结构（保存）", category = 50)
    @PostMapping("gen/createTable")
    @LimitScope(name = "genTableSave", key = "genTableSave")
    public ResponseResult<String> save(String sql) {
        try {
            SqlUtil.filterKeyword(sql);
            List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, DbType.mysql);
            List<String> tableNames = new ArrayList<>();
            for (SQLStatement sqlStatement : sqlStatements) {
                if (sqlStatement instanceof MySqlCreateTableStatement) {
                    MySqlCreateTableStatement createTableStatement = (MySqlCreateTableStatement) sqlStatement;
                    if (genTableService.createTable(createTableStatement.toString())) {
                        String tableName = createTableStatement.getTableName().replaceAll("`", "");
                        tableNames.add(tableName);
                    }
                }
            }
            List<GenTable> tableList = genTableService
                .selectDbTableListByNames(tableNames.toArray(new String[tableNames.size()]));
            String operName = SecurityUtils.getUsername();
            genTableService.importGenTable(tableList, operName);
            return ResponseResult.ok();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseResult.error("创建表结构异常");
        }
    }

    /**
     * 修改保存代码生成业务
     * @param genTable 表对象
     * @return 基于表生成的代码
     */
    @PreAuthorize("@ss.hasPerms('tool:gen:update')")
    @PlatLog(value = "修改保存代码生成业务", category = 20)
    @PostMapping("gen")
    @LimitScope(name = "genTableUpdate", key = "genTableUpdate")
    public ResponseResult<String> editSave(@Validated @RequestBody GenTable genTable) {
        genTableService.validateEdit(genTable);
        genTableService.updateGenTable(genTable);
        return success();
    }

    /**
     * 删除代码生成
     * @param tableIds  表名Ids
     * @return 操作结果
     */
    @PreAuthorize("@ss.hasPerms('tool:gen:delete')")
    @PlatLog(value = "删除代码生成", category = 40)
    @DeleteMapping("gen/{tableIds}")
    @LimitScope(name = "genTableDelete", key = "genTableDelete")
    public ResponseResult<String> delete(@PathVariable Long[] tableIds) {
        genTableService.deleteGenTableByIds(tableIds);
        return success();
    }

    /**
     * 预览代码
     * @param tableId 表对象ID
     * @return 表生成的代码
     * @throws IOException  异常
     */
    @PlatLog(value = "预览代码", category = 50)
    @PreAuthorize("@ss.hasPerms('tool:gen:preview')")
    @GetMapping("gen/preview/{tableId}")
    public ResponseResult<Map<String, String>> preview(@PathVariable("tableId") Long tableId) throws IOException {
        Map<String, String> dataMap = genTableService.previewCode(tableId);
        return success(dataMap);
    }

    /**
     * 生成代码（下载方式）
     * @param response  响应
     * @param tableName 表名称
     * @throws IOException  异常
     */
    @PreAuthorize("@ss.hasPerms('tool:gen:code')")
    @PlatLog(value = "生成代码（下载方式）", category = 50)
    @GetMapping("gen/download/{tableName}")
    public void download(HttpServletResponse response,
                         @PathVariable("tableName") String tableName) throws IOException {
        byte[] data = genTableService.downloadCode(tableName);
        genCode(response, data);
    }

    /**
     * 生成代码（自定义路径）
     * @param tableName 表名称
     * @return 生成代码
     */
    @PreAuthorize("@ss.hasPerms('tool:gen:code')")
    @PlatLog(value = "生成代码（自定义路径）", category = 50)
    @GetMapping("gen/genCode/{tableName}")
    public ResponseResult<String> genCode(@PathVariable("tableName") String tableName) {
        genTableService.generatorCode(tableName);
        return success();
    }

    /**
     * 同步数据库
     * @param tableName 表名称
     * @return 同步数据库结构
     */
    @PreAuthorize("@ss.hasPerms('tool:gen:update')")
    @PlatLog(value = "同步数据库结构", category = 20)
    @GetMapping("gen/synchDb/{tableName}")
    public ResponseResult<String> synchDb(@PathVariable("tableName") String tableName) {
        genTableService.synchDb(tableName);
        return success();
    }

    /**
     * 批量生成代码
     * @param response  响应
     * @param tables    表名称前缀
     * @throws  IOException 异常
     */
    @PreAuthorize("@ss.hasPerms('tool:gen:code')")
    @PlatLog(value = "批量生成代码", category = 50)
    @GetMapping("gen/batchGenCode")
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException {
        String[] tableNames = Convert.toStrArray(tables);
        byte[] data = genTableService.downloadCode(tableNames);
        genCode(response, data);
    }

    /**
     * 生成zip文件
     * @param response  响应
     * @param data    数据
     * @return 生成zip文件
     * @throws  IOException 异常
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"eframe.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

}
