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

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.view.sys.manager.FrameOrganManager;
import net.linlan.sys.core.dto.OrganBaseInfoDto;
import net.linlan.sys.core.param.OrganAccountParam;
import net.linlan.utils.exception.CommonException;

/**
 *
 * CoreOrgan控制域:系统机构表读写控制类
 * @author Linlan
 * CreateTime 2024-11-21 15:35:19
 *
 */
@RestController
@RequestMapping("/api/system")
public class CoreOrganController extends BaseController {
    @Resource
    private FrameOrganManager coreOrganEntManager;

    /** Get CoreOrgan list. 获取系统机构表列表或分页, 返回CoreOrgan对象.
     * @param param 参数查询对象
     * @return 获取系统机构表列表或分页, 返回CoreOrgan对象.
     */
    @PreAuthorize("@ss.hasPerms('system:organ:list')")
    @PlatLog(value = "查询系统机构表分页")
    @GetMapping("/organ/list")
    @Encrypt
    public ResponseResult<List<OrganBaseInfoDto>> list(OrganAccountParam param) {
        Page<OrganBaseInfoDto> result = coreOrganEntManager.getCoreOrganList(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * Get CoreOrgan by id. 主键获取系统机构表详细信息.
     * @param id 机构ID|1
     * @return {@link OrganBaseInfoDto}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:organ:detail')")
    @PlatLog(value = "主键获取系统机构表详细信息", category = 1)
    @GetMapping(value = "/organ/{id}")
    @Encrypt
    public ResponseResult<OrganBaseInfoDto> getCoreOrganById(@PathVariable("id") String id) {
        return success(coreOrganEntManager.getOrganDetail(id));
    }

    /** CoreOrgan Operation. 新增系统机构表数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入CoreOrgan对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:organ:save')")
    @PlatLog(value = "新增系统机构表", category = 10)
    @PostMapping("/organ/save")
    @Encrypt
    @LimitScope(name = "coreOrganSave", key = "coreOrganSave")
    public ResponseResult<String> save(@RequestBody OrganBaseInfoDto input) throws CommonException {

        return success(coreOrganEntManager.doCoreOrganOperation(input, ApiIntfConfig.VALUE_AT_ADD));
    }

    /** CoreOrgan Operation. 修改系统机构表数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入CoreOrgan对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:organ:update')")
    @PlatLog(value = "修改系统机构表", category = 20)
    @PostMapping("/organ/update")
    @Encrypt
    @LimitScope(name = "coreOrganUpdate", key = "coreOrganUpdate")
    public ResponseResult<String> update(@RequestBody OrganBaseInfoDto input) throws CommonException {
        return success(
            coreOrganEntManager.doCoreOrganOperation(input, ApiIntfConfig.VALUE_AT_UPDATE));
    }

    /** CoreOrgan Operation. 删除系统机构表数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 机构ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:organ:delete')")
    @PlatLog(value = "删除系统机构表", category = 40)
    @PostMapping("/organ/delete/{ids}")
    @Encrypt
    @LimitScope(name = "coreOrganDelete", key = "coreOrganDelete")
    public ResponseResult<String> delete(@PathVariable String[] ids) throws CommonException {
        OrganBaseInfoDto input = new OrganBaseInfoDto();
        input.setIds(ids);
        return success(
            coreOrganEntManager.doCoreOrganOperation(input, ApiIntfConfig.VALUE_AT_DELETE));
    }

    /** CoreOrgan Operation. 系统机构表数据操作逻辑，根据操作类型，执行停用启用操作.
     * @param input 机构ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:organ:delete')")
    @PlatLog(value = "停用启用系统机构表", category = 40)
    @PostMapping("/organ/disable/{id}")
    @Encrypt
    @LimitScope(name = "coreOrganDisable", key = "coreOrganDisable")
    public ResponseResult<String> disable(@RequestBody OrganBaseInfoDto input) throws CommonException {
        return success(
            coreOrganEntManager.doCoreOrganOperation(input, ApiIntfConfig.VALUE_AT_OTHER));
    }

}
