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
import net.linlan.commons.core.*;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.api.BaseController;
import net.linlan.sys.base.dto.BaseUserDto;
import net.linlan.sys.base.dto.BaseUserExtDto;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.base.entity.BaseUserExt;
import net.linlan.sys.base.param.BaseUserExtParam;
import net.linlan.sys.base.param.BaseUserParam;
import net.linlan.sys.base.service.BaseUserExtService;
import net.linlan.sys.base.service.BaseUserService;

/**
*
* 基础用户读写控制类
* @author Linlan
* CreateTime 2025-10-13 16:58:20
* @version 1.0
* @since 1.0
*
*/
@RestController
@RequestMapping("/api/system")
public class BaseUserController extends BaseController {
    @Resource
    private BaseUserService baseUserService;

    /** Get BaseUser list. 获取基础用户列表或分页, 返回BaseUser对象.
     * @param param 参数查询对象
     * @return 列表的基础用户数据 {@link List} 对象，包含 {@link BaseUser} 列表:null,error;page,success
     */
    @PreAuthorize("@ss.hasPerms('system:baseuser:list')")
    @PlatLog(value = "查询基础用户分页", category = 0)
    @GetMapping("/baseuser/list")
    @Encrypt
    public ResponseResult<List<BaseUser>> list(BaseUserParam param) {
        Page<BaseUserDto> result = baseUserService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * Get BaseUser by id. 主键获取基础用户详细信息.
     * @param id 用户ID|1
     * @return {@link BaseUser}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:baseuser:detail')")
    @PlatLog(value = "主键获取基础用户详细信息", category = 1)
    @GetMapping(value = "/baseuser/{id}")
    @Encrypt
    public ResponseResult<BaseUser> findById(@PathVariable("id") String id) {
        return success(baseUserService.findById(id));
    }

    /** BaseUser Operation. 新增基础用户数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入BaseUser对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:baseuser:save')")
    @PlatLog(value = "新增基础用户", category = 10)
    @PostMapping("/baseuser/save")
    @Encrypt
    @LimitScope(name = "baseUserSave", key = "baseUserSave")
    public ResponseResult<String> save(@RequestBody BaseUser input) {
        baseUserService.save(input);
        return success();
    }

    /** BaseUser Operation. 修改基础用户数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入BaseUser对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:baseuser:update')")
    @PlatLog(value = "修改基础用户", category = 20)
    @PostMapping("/baseuser/update")
    @Encrypt
    @LimitScope(name = "baseUserUpdate", key = "baseUserUpdate")
    public ResponseResult<String> update(@RequestBody BaseUser input) {
        baseUserService.update(input);
        return success();
    }

    /** BaseUser Operation. 删除基础用户数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 用户ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:baseuser:delete')")
    @PlatLog(value = "删除基础用户", category = 40)
    @PostMapping("/baseuser/delete/{ids}")
    @Encrypt
    @LimitScope(name = "baseUserDelete", key = "baseUserDelete")
    public ResponseResult<String> delete(@PathVariable String[] ids) {
        baseUserService.deleteByIds(ids);
        return success();
    }

    @Resource
    private BaseUserExtService baseUserExtService;

    /** Get BaseUserExt list. 获取基础用户扩展信息列表或分页, 返回BaseUserExt对象.
     * @param param 参数查询对象
     * @return 列表的基础用户扩展信息数据 {@link List} 对象，包含 {@link BaseUserExt} 列表:null,error;page,success
     */
    @PreAuthorize("@ss.hasPerms('system:baseuserext:list')")
    @PlatLog(value = "查询基础用户扩展信息分页", category = 0)
    @GetMapping("/baseuserext/list")
    @Encrypt
    public ResponseResult<List<BaseUserExt>> listExt(BaseUserExtParam param) {
        Page<BaseUserExtDto> result = baseUserExtService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * Get BaseUserExt by id. 主键获取基础用户扩展信息详细信息.
     * @param id 用户ID|1
     * @return {@link BaseUserExt}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:baseuserext:detail')")
    @PlatLog(value = "主键获取基础用户扩展信息详细信息", category = 1)
    @GetMapping(value = "/baseuserext/{id}")
    @Encrypt
    public ResponseResult<BaseUserExt> findByIdExt(@PathVariable("id") String id) {
        return success(baseUserExtService.findById(id));
    }

    /** BaseUserExt Operation. 新增基础用户扩展信息数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入BaseUserExt对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:baseuserext:save')")
    @PlatLog(value = "新增基础用户扩展信息", category = 10)
    @PostMapping("/baseuserext/save")
    @Encrypt
    @LimitScope(name = "baseUserExtSave", key = "baseUserExtSave")
    public ResponseResult<String> saveExt(@RequestBody BaseUserExt input) {
        baseUserExtService.save(input);
        return success();
    }

    /** BaseUserExt Operation. 修改基础用户扩展信息数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入BaseUserExt对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:baseuserext:update')")
    @PlatLog(value = "修改基础用户扩展信息", category = 20)
    @PostMapping("/baseuserext/update")
    @Encrypt
    @LimitScope(name = "baseUserExtUpdate", key = "baseUserExtUpdate")
    public ResponseResult<String> updateExt(@RequestBody BaseUserExt input) {
        baseUserExtService.update(input);
        return success();
    }

    /** BaseUserExt Operation. 删除基础用户扩展信息数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 用户ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:baseuserext:delete')")
    @PlatLog(value = "删除基础用户扩展信息", category = 40)
    @PostMapping("/baseuserext/delete/{ids}")
    @Encrypt
    @LimitScope(name = "baseUserExtDelete", key = "baseUserExtDelete")
    public ResponseResult<String> deleteExt(@PathVariable String[] ids) {
        baseUserExtService.deleteByIds(ids);
        return success();
    }
}
