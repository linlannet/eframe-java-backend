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

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.sys.core.dto.CoreRighttypeDto;
import net.linlan.sys.core.entity.CoreRighttype;
import net.linlan.sys.core.param.CoreRighttypeParam;
import net.linlan.sys.core.service.CoreRighttypeService;

/**
 *
 * 权限分类读写控制类
 * @author Linlan
 * CreateTime 2024-12-16 10:58:56
 *
 */
@RestController
@RequestMapping("/api/system")
public class CoreRighttypeController extends BaseController {
    @Resource
    private CoreRighttypeService coreRighttypeService;

    /** Get CoreRighttype list. 获取权限分类列表或分页, 返回CoreRighttype对象.
     * @param param 参数查询对象
     * @return 获取权限分类列表或分页, 返回CoreRighttype对象.
     */
    @PreAuthorize("@ss.hasPerms('system:righttype:list')")
    @PlatLog(value = "查询权限分类分页")
    @GetMapping("/righttype/list")
    @Encrypt
    public ResponseEntity<List<CoreRighttype>> list(CoreRighttypeParam param) {
        Page<CoreRighttypeDto> result = coreRighttypeService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /** CoreRighttype Operation. CoreRighttype数据操作逻辑，导出操作.
     * @param response 响应体
     * @param param 参数查询对象
     */
    @PreAuthorize("@ss.hasPerms('system:righttype:export')")
    @PlatLog(value = "导出权限分类列表", category = 52)
    @PostMapping("/righttype/export")
    @Encrypt
    public void export(HttpServletResponse response, CoreRighttypeParam param) {
        param.setPage(1);
        param.setLimit(30000);
        Page<CoreRighttypeDto> result = coreRighttypeService.getPageDto(param);
        ExcelUtil<CoreRighttypeDto> util = new ExcelUtil<CoreRighttypeDto>(CoreRighttypeDto.class);
        util.exportExcel(response, result.getResult(), "权限分类数据导出");
    }

    /**
     * Get CoreRighttype by id. 主键获取权限分类详细信息.
     * @param id 资源类型ID|1
     * @return {@link CoreRighttype}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:righttype:detail')")
    @PlatLog(value = "主键获取权限分类详细信息", category = 1)
    @GetMapping(value = "/righttype/{id}")
    @Encrypt
    public ResponseEntity<CoreRighttype> getCoreRighttypeById(@PathVariable("id") String id) {
        return success(coreRighttypeService.findById(id));
    }

    /** CoreRighttype Operation. 新增权限分类数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入CoreRighttype对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:righttype:save')")
    @PlatLog(value = "新增权限分类", category = 10)
    @PostMapping("/righttype/save")
    @Encrypt
    @LimitScope(name = "coreRighttypeSave", key = "coreRighttypeSave")
    public ResponseEntity<String> save(@RequestBody CoreRighttype input) {
        coreRighttypeService.save(input);
        return success();
    }

    /** CoreRighttype Operation. 修改权限分类数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入CoreRighttype对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:righttype:update')")
    @PlatLog(value = "修改权限分类", category = 20)
    @PostMapping("/righttype/update")
    @Encrypt
    @LimitScope(name = "coreRighttypeUpdate", key = "coreRighttypeUpdate")
    public ResponseEntity<String> update(@RequestBody CoreRighttype input) {
        coreRighttypeService.update(input);
        return success();
    }

    /** CoreRighttype Operation. 删除权限分类数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 资源类型ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:righttype:delete')")
    @PlatLog(value = "删除权限分类", category = 40)
    @PostMapping("/righttype/delete/{ids}")
    @Encrypt
    @LimitScope(name = "coreRighttypeDelete", key = "coreRighttypeDelete")
    public ResponseEntity<String> delete(@PathVariable String[] ids) {
        coreRighttypeService.deleteByIds(ids);
        return success();
    }

}
