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
package net.linlan.frame.api.sys;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.sys.core.dto.CoreRoletypeDto;
import net.linlan.sys.core.entity.CoreRoletype;
import net.linlan.sys.core.param.CoreRoletypeParam;
import net.linlan.sys.core.service.CoreRoletypeService;

/**
 *
 * CoreRoletype控制域:角色分类读写控制类
 * @author Linlan
 * CreateTime 2024-12-16 10:47:36
 *
 */
@RestController
@RequestMapping("/api/system")
public class CoreRoletypeController extends BaseController {
    @Resource
    private CoreRoletypeService coreRoletypeService;

    /** Get CoreRoletype list. 获取角色分类列表或分页, 返回CoreRoletype对象.
     * @param param 参数查询对象
     * @return 获取角色分类列表或分页, 返回CoreRoletype对象.
     */
    @PreAuthorize("@ss.hasPerms('system:roletype:list')")
    @PlatLog(value = "查询角色分类分页")
    @GetMapping("/roletype/list")
    @Encrypt
    public ResponseResult<List<CoreRoletype>> list(CoreRoletypeParam param) {
        Page<CoreRoletypeDto> result = coreRoletypeService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /** CoreRoletype Operation. CoreRoletype数据操作逻辑，导出操作.
     * @param response 响应体
     * @param param 参数查询对象
     */
    @PreAuthorize("@ss.hasPerms('system:roletype:export')")
    @PlatLog(value = "导出角色分类列表", category = 52)
    @PostMapping("/roletype/export")
    @Encrypt
    public void export(HttpServletResponse response, CoreRoletypeParam param) {
        param.setPage(1);
        param.setLimit(30000);
        Page<CoreRoletypeDto> result = coreRoletypeService.getPageDto(param);
        ExcelUtil<CoreRoletypeDto> util = new ExcelUtil<CoreRoletypeDto>(CoreRoletypeDto.class);
        util.exportExcel(response, result.getResult(), "角色分类数据导出");
    }

    /**
     * Get CoreRoletype by id. 主键获取角色分类详细信息.
     * @param id 角色分类ID|1
     * @return {@link CoreRoletype}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:roletype:detail')")
    @PlatLog(value = "主键获取角色分类详细信息", category = 1)
    @GetMapping(value = "/roletype/{id}")
    @Encrypt
    public ResponseResult<CoreRoletype> getCoreRoletypeById(@PathVariable("id") String id) {
        return success(coreRoletypeService.findById(id));
    }

    /** CoreRoletype Operation. 新增角色分类数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入CoreRoletype对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:roletype:save')")
    @PlatLog(value = "新增角色分类", category = 10)
    @PostMapping("/roletype/save")
    @Encrypt
    @LimitScope(name = "coreRoletypeSave", key = "coreRoletypeSave")
    public ResponseResult<String> save(@RequestBody CoreRoletype input) {
        coreRoletypeService.save(input);
        return success();
    }

    /** CoreRoletype Operation. 修改角色分类数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入CoreRoletype对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:roletype:update')")
    @PlatLog(value = "修改角色分类", category = 20)
    @PostMapping("/roletype/update")
    @Encrypt
    @LimitScope(name = "coreRoletypeUpdate", key = "coreRoletypeUpdate")
    public ResponseResult<String> update(@RequestBody CoreRoletype input) {
        coreRoletypeService.update(input);
        return success();
    }

    /** CoreRoletype Operation. 删除角色分类数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 角色分类ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:roletype:delete')")
    @PlatLog(value = "删除角色分类", category = 40)
    @PostMapping("/roletype/delete/{ids}")
    @Encrypt
    @LimitScope(name = "coreRoletypeDelete", key = "coreRoletypeDelete")
    public ResponseResult<String> delete(@PathVariable String[] ids) {
        coreRoletypeService.deleteByIds(ids);
        return success();
    }

}
