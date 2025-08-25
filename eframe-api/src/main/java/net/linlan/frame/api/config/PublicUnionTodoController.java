/*
 * eframe-api - api接口网关模块
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
package net.linlan.frame.api.config;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.config.dto.PublicUnionTodoDto;
import net.linlan.frame.config.entity.PublicUnionTodo;
import net.linlan.frame.config.param.PublicUnionTodoParam;
import net.linlan.frame.config.service.PublicUnionTodoService;
import net.linlan.frame.view.admin.utils.ExcelUtil;

/**
 *
 * PublicUnionTodo控制域:统一待办读写控制类
 * @author Linlan
 * CreateTime 2024-11-19 14:58:52
 *
 */
@RestController
@RequestMapping("/api/system")
public class PublicUnionTodoController extends BaseController {

    @Autowired
    private PublicUnionTodoService portalUnionTodoService;

    /** Get PublicUnionTodo list. 获取统一待办列表或分页, 返回PublicUnionTodo对象.
     * @param param 参数查询对象
     * @return 获取统一待办列表或分页, 返回PublicUnionTodo对象.
     */
    @PreAuthorize("@ss.hasPerms('system:todo:list')")
    @PlatLog(value = "查询统一待办分页")
    @GetMapping("/todo/list")
    @Encrypt
    public ResponseResult<List<PublicUnionTodoDto>> list(PublicUnionTodoParam param) {
        Page<PublicUnionTodoDto> result = portalUnionTodoService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /** PublicUnionTodo Operation. PublicUnionTodo数据操作逻辑，导出操作.
     * @param response 响应体
     * @param param 参数查询对象
     */
    @PreAuthorize("@ss.hasPerms('system:todo:export')")
    @PlatLog(value = "导出统一待办列表", category = 52)
    @PostMapping("/todo/export")
    @Encrypt
    public void export(HttpServletResponse response, PublicUnionTodoParam param) {
        List<PublicUnionTodoDto> list = portalUnionTodoService.getPageDto(param);
        ExcelUtil<PublicUnionTodoDto> util = new ExcelUtil<PublicUnionTodoDto>(
            PublicUnionTodoDto.class);
        util.exportExcel(response, list, "统一待办数据导出");
    }

    /**
     * Get PublicUnionTodo by id. 主键获取统一待办详细信息.
     * @param id 主键ID|1
     * @return {@link PublicUnionTodoDto}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:todo:detail')")
    @PlatLog(value = "主键获取统一待办详细信息", category = 1)
    @GetMapping(value = "/todo/{id}")
    @Encrypt
    public ResponseResult<PublicUnionTodoDto> getPublicUnionTodoById(@PathVariable("id") String id) {
        return success(portalUnionTodoService.findById(id));
    }

    /** PublicUnionTodo Operation. 新增统一待办数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入PublicUnionTodo对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:todo:save')")
    @PlatLog(value = "新增统一待办", category = 10)
    @PostMapping("/todo/save")
    @Encrypt
    @LimitScope(name = "publicUnionTodoSave", key = "publicUnionTodoSave")
    public ResponseResult<String> save(@RequestBody PublicUnionTodo input) {
        portalUnionTodoService.save(input);
        return success();
    }

    /** PublicUnionTodo Operation. 修改统一待办数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入PublicUnionTodo对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:todo:update')")
    @PlatLog(value = "修改统一待办", category = 20)
    @PostMapping("/todo/update")
    @Encrypt
    @LimitScope(name = "publicUnionTodoUpdate", key = "publicUnionTodoUpdate")
    public ResponseResult<String> update(@RequestBody PublicUnionTodo input) {
        portalUnionTodoService.update(input);
        return success();
    }

    /** PublicUnionTodo Operation. 删除统一待办数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 主键ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:todo:delete')")
    @PlatLog(value = "删除统一待办", category = 40)
    @PostMapping("/todo/delete/{ids}")
    @Encrypt
    @LimitScope(name = "publicUnionTodoDelete", key = "publicUnionTodoDelete")
    public ResponseResult<String> delete(@PathVariable String[] ids) {
        portalUnionTodoService.deleteByIds(ids);
        return success();
    }

}
