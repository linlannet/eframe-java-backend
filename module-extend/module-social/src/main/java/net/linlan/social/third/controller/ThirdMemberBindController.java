/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.third.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.*;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.social.third.dto.ThirdMemberBindDto;
import net.linlan.social.third.entity.ThirdMemberBind;
import net.linlan.social.third.param.ThirdMemberBindParam;
import net.linlan.social.third.service.ThirdMemberBindService;

/**
*
* 第三方用户身份提供商绑定读写控制类
* @author Linlan
* CreateTime 2025-10-13 16:58:20
* @version 1.0
* @since 1.0
*
*/
@RestController
@RequestMapping("/api/third")
public class ThirdMemberBindController extends BaseController {

    @Resource
    private ThirdMemberBindService thirdMemberBindService;

    /** Get ThirdMemberBind list. 获取用户身份提供商绑定列表或分页, 返回ThirdMemberBind对象.
     * @param param 参数查询对象
     * @return 列表的用户身份提供商绑定数据 {@link List} 对象，包含 {@link ThirdMemberBind} 列表:null,error;page,success
     */
    @PreAuthorize("@ss.hasPerms('third:memberbind:list')")
    @PlatLog(value = "查询用户身份提供商绑定分页", category = 0)
    @GetMapping("/memberbind/list")
    @Encrypt
    public ResponseEntity<List<ThirdMemberBindDto>> list(ThirdMemberBindParam param) {
        Page<ThirdMemberBindDto> result = thirdMemberBindService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * Get ThirdMemberBind by id. 主键获取用户身份提供商绑定详细信息.
     * @param id 主键ID|1
     * @return {@link ThirdMemberBind}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('third:memberbind:detail')")
    @PlatLog(value = "主键获取用户身份提供商绑定详细信息", category = 1)
    @GetMapping(value = "/memberbind/{id}")
    @Encrypt
    public ResponseEntity<ThirdMemberBind> findById(@PathVariable("id") String id) {
        return success(thirdMemberBindService.findById(id));
    }

    /** ThirdMemberBind Operation. 新增用户身份提供商绑定数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入ThirdMemberBind对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('third:memberbind:save')")
    @PlatLog(value = "新增用户身份提供商绑定", category = 10)
    @PostMapping("/memberbind/save")
    @Encrypt
    @LimitScope(name = "thirdMemberBindSave", key = "thirdMemberBindSave")
    public ResponseEntity<String> save(@RequestBody ThirdMemberBind input) {
        thirdMemberBindService.save(input);
        return success();
    }

    /** ThirdMemberBind Operation. 修改用户身份提供商绑定数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入ThirdMemberBind对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('third:memberbind:update')")
    @PlatLog(value = "修改用户身份提供商绑定", category = 20)
    @PostMapping("/memberbind/update")
    @Encrypt
    @LimitScope(name = "thirdMemberBindUpdate", key = "thirdMemberBindUpdate")
    public ResponseEntity<String> update(@RequestBody ThirdMemberBind input) {
        thirdMemberBindService.update(input);
        return success();
    }

    /** 删除用户身份提供商绑定数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 主键ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('third:memberbind:delete')")
    @PlatLog(value = "删除用户身份提供商绑定", category = 40)
    @PostMapping("/memberbind/delete/{ids}")
    @Encrypt
    @LimitScope(name = "thirdMemberBindDelete", key = "thirdMemberBindDelete")
    public ResponseEntity<String> delete(@PathVariable String[] ids) {
        thirdMemberBindService.deleteByIds(ids);
        return success();
    }

    /** 获取我的绑定列表或分页, 返回ThirdMemberBind对象.
     * @param param 参数查询对象
     * @return 列表的用户身份提供商绑定数据 {@link List} 对象，包含 {@link ThirdMemberBind} 列表:null,error;page,success
     */
    @PlatLog(value = "获取我的绑定列表或分页", category = 0)
    @GetMapping("/memberbind/mylist")
    public ResponseEntity<List<ThirdMemberBindDto>> mylist(ThirdMemberBindParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return null;
        }
        param.setUserId(SecurityUtils.getUserId());
        Page<ThirdMemberBindDto> result = thirdMemberBindService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }
}
