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
import net.linlan.sys.base.dto.BaseXzqhDto;
import net.linlan.sys.base.entity.BaseXzqh;
import net.linlan.sys.base.param.BaseXzqhParam;
import net.linlan.sys.base.service.BaseXzqhService;

/**
 *
 * 行政区划管理读写控制类
 * @author Linlan
 * CreateTime 2024-12-16 16:04:14
 *
 */
@RestController
@RequestMapping("/api/system")
public class BaseXzqhController extends BaseController {
    @Resource
    private BaseXzqhService baseXzqhService;

    /** Get BaseXzqh list. 获取行政区划管理列表或分页, 返回BaseXzqh对象.
     * @param param 参数查询对象
     * @return 获取行政区划管理列表或分页, 返回BaseXzqh对象.
     */
    @PreAuthorize("@ss.hasPerms('system:xzqh:list')")
    @PlatLog(value = "查询行政区划管理分页")
    @GetMapping("/xzqh/list")
    @Encrypt
    public ResponseEntity<List<BaseXzqh>> list(BaseXzqhParam param) {
        Page<BaseXzqhDto> result = baseXzqhService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /** BaseXzqh Operation. BaseXzqh数据操作逻辑，导出操作.
     * @param response 响应体
     * @param param 参数查询对象
     */
    @PreAuthorize("@ss.hasPerms('system:xzqh:export')")
    @PlatLog(value = "导出行政区划管理列表", category = 52)
    @PostMapping("/xzqh/export")
    @Encrypt
    public void export(HttpServletResponse response, BaseXzqhParam param) {
        param.setPage(1);
        param.setLimit(30000);
        Page<BaseXzqhDto> result = baseXzqhService.getPageDto(param);
        ExcelUtil<BaseXzqhDto> util = new ExcelUtil<BaseXzqhDto>(BaseXzqhDto.class);
        util.exportExcel(response, result.getResult(), "行政区划管理数据导出");
    }

    /**
     * Get BaseXzqh by id. 主键获取行政区划管理详细信息.
     * @param id 行政区划编号|1
     * @return {@link BaseXzqh}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:xzqh:detail')")
    @PlatLog(value = "主键获取行政区划管理详细信息", category = 1)
    @GetMapping(value = "/xzqh/{id}")
    @Encrypt
    public ResponseEntity<BaseXzqh> getBaseXzqhById(@PathVariable("id") Long id) {
        return success(baseXzqhService.findById(id));
    }

    /** BaseXzqh Operation. 新增行政区划管理数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入BaseXzqh对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:xzqh:save')")
    @PlatLog(value = "新增行政区划管理", category = 10)
    @PostMapping("/xzqh/save")
    @Encrypt
    @LimitScope(name = "baseXzqhSave", key = "baseXzqhSave")
    public ResponseEntity<String> save(@RequestBody BaseXzqh input) {
        baseXzqhService.save(input);
        return success();
    }

    /** BaseXzqh Operation. 修改行政区划管理数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入BaseXzqh对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:xzqh:update')")
    @PlatLog(value = "修改行政区划管理", category = 20)
    @PostMapping("/xzqh/update")
    @Encrypt
    @LimitScope(name = "baseXzqhUpdate", key = "baseXzqhUpdate")
    public ResponseEntity<String> update(@RequestBody BaseXzqh input) {
        baseXzqhService.update(input);
        return success();
    }

    /** BaseXzqh Operation. 删除行政区划管理数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 行政区划编号:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:xzqh:delete')")
    @PlatLog(value = "删除行政区划管理", category = 40)
    @PostMapping("/xzqh/delete/{ids}")
    @Encrypt
    @LimitScope(name = "baseXzqhDelete", key = "baseXzqhDelete")
    public ResponseEntity<String> delete(@PathVariable Long[] ids) {
        baseXzqhService.deleteByIds(ids);
        return success();
    }

}
