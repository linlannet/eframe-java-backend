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
import net.linlan.frame.api.BaseController;
import net.linlan.social.third.dto.ThirdMemberTokenDto;
import net.linlan.social.third.entity.ThirdMemberToken;
import net.linlan.social.third.param.ThirdMemberTokenParam;
import net.linlan.social.third.service.ThirdMemberTokenService;

/**
*
* 会员用户令牌读写控制类
* @author Linlan
* CreateTime 2025-10-13 16:58:20
* @version 1.0
* @since 1.0
*
*/
@RestController
@RequestMapping("/api/third")
public class ThirdMemberTokenController extends BaseController {
    @Resource
    private ThirdMemberTokenService thirdMemberTokenService;

    /** Get ThirdMemberToken list. 获取会员用户令牌列表或分页, 返回ThirdMemberToken对象.
     * @param param 参数查询对象
     * @return 列表的会员用户令牌数据 {@link List} 对象，包含 {@link ThirdMemberToken} 列表:null,error;page,success
     */
    @PreAuthorize("@ss.hasPerms('third:token:list')")
    @PlatLog(value = "查询会员用户令牌分页", category = 0)
    @GetMapping("/token/list")
    @Encrypt
    public ResponseResult<List<ThirdMemberToken>> list(ThirdMemberTokenParam param) {
        Page<ThirdMemberTokenDto> result = thirdMemberTokenService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /** ThirdMemberToken Operation. 删除会员用户令牌数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 主键ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('third:token:delete')")
    @PlatLog(value = "删除会员用户令牌", category = 40)
    @PostMapping("/token/delete/{ids}")
    @Encrypt
    @LimitScope(name = "thirdMemberTokenDelete", key = "thirdMemberTokenDelete")
    public ResponseResult<String> delete(@PathVariable Long[] ids) {
        thirdMemberTokenService.deleteByIds(ids);
        return success();
    }

}
