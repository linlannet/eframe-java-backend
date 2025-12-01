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
import net.linlan.social.third.dto.ThirdMemberDto;
import net.linlan.social.third.entity.ThirdMember;
import net.linlan.social.third.param.ThirdMemberParam;
import net.linlan.social.third.service.ThirdMemberService;

/**
*
* 第三方用户读写控制类
* @author Linlan
* CreateTime 2025-10-13 16:58:20
* @version 1.0
* @since 1.0
*
*/
@RestController
@RequestMapping("/api/third")
public class ThirdMemberController extends BaseController {
    @Resource
    private ThirdMemberService thirdMemberService;

    /** Get ThirdMember list. 获取第三方用户列表或分页, 返回ThirdMember对象.
     * @param param 参数查询对象
     * @return 列表的第三方用户数据 {@link List} 对象，包含 {@link ThirdMember} 列表:null,error;page,success
     */
    @PreAuthorize("@ss.hasPerms('third:member:list')")
    @PlatLog(value = "查询第三方用户分页", category = 0)
    @GetMapping("/member/list")
    @Encrypt
    public ResponseEntity<List<ThirdMember>> list(ThirdMemberParam param) {
        Page<ThirdMemberDto> result = thirdMemberService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * Get ThirdMember by id. 主键获取第三方用户详细信息.
     * @param id 主键ID|1
     * @return {@link ThirdMember}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('third:member:detail')")
    @PlatLog(value = "主键获取第三方用户详细信息", category = 1)
    @GetMapping(value = "/member/{id}")
    @Encrypt
    public ResponseEntity<ThirdMember> findById(@PathVariable("id") Long id) {
        return success(thirdMemberService.findById(id));
    }

    /** ThirdMember Operation. 新增第三方用户数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入ThirdMember对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('third:member:save')")
    @PlatLog(value = "新增第三方用户", category = 10)
    @PostMapping("/member/save")
    @Encrypt
    @LimitScope(name = "thirdMemberSave", key = "thirdMemberSave")
    public ResponseEntity<String> save(@RequestBody ThirdMember input) {
        thirdMemberService.save(input);
        return success();
    }

    /** ThirdMember Operation. 修改第三方用户数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入ThirdMember对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('third:member:update')")
    @PlatLog(value = "修改第三方用户", category = 20)
    @PostMapping("/member/update")
    @Encrypt
    @LimitScope(name = "thirdMemberUpdate", key = "thirdMemberUpdate")
    public ResponseEntity<String> update(@RequestBody ThirdMember input) {
        thirdMemberService.update(input);
        return success();
    }

    /** ThirdMember Operation. 删除第三方用户数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 主键ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('third:member:delete')")
    @PlatLog(value = "删除第三方用户", category = 40)
    @PostMapping("/member/delete/{ids}")
    @Encrypt
    @LimitScope(name = "thirdMemberDelete", key = "thirdMemberDelete")
    public ResponseEntity<String> delete(@PathVariable Long[] ids) {
        thirdMemberService.deleteByIds(ids);
        return success();
    }

}
