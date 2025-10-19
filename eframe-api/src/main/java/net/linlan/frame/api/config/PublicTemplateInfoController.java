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

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.*;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.config.dto.PublicTemplateInfoDto;
import net.linlan.frame.config.entity.PublicTemplateInfo;
import net.linlan.frame.config.param.PublicTemplateInfoParam;
import net.linlan.frame.config.service.PublicTemplateInfoService;

/**
*
* 模板信息配置读写控制类
* @author Linlan
* CreateTime 2025-10-15 13:52:44
* @version 1.0
* @since 1.0
*
*/
@RestController
@RequestMapping("/api/system")
public class PublicTemplateInfoController extends BaseController {
    @Resource
    private PublicTemplateInfoService publicTemplateInfoService;

    /** Get PublicTemplateInfo list. 获取模板信息配置列表或分页, 返回PublicTemplateInfo对象.
     * @param param 参数查询对象
     * @return 列表的模板信息配置数据 {@link List} 对象，包含 {@link PublicTemplateInfo} 列表:null,error;page,success
     */
    @PreAuthorize("@ss.hasPerms('system:template:list')")
    @PlatLog(value = "查询模板信息配置分页", category = 0)
    @GetMapping("/template/list")
    @Encrypt
    public ResponseResult<List<PublicTemplateInfo>> list(PublicTemplateInfoParam param) {
        Page<PublicTemplateInfoDto> result = publicTemplateInfoService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * Get PublicTemplateInfo by id. 主键获取模板信息配置详细信息.
     * @param id 模板ID|1
     * @return {@link PublicTemplateInfo}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:template:detail')")
    @PlatLog(value = "主键获取模板信息配置详细信息", category = 1)
    @GetMapping(value = "/template/{id}")
    @Encrypt
    public ResponseResult<PublicTemplateInfo> findById(@PathVariable("id") String id) {
        return success(publicTemplateInfoService.findById(id));
    }

    /** PublicTemplateInfo Operation. 新增模板信息配置数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入PublicTemplateInfo对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:template:save')")
    @PlatLog(value = "新增模板信息配置", category = 10)
    @PostMapping("/template/save")
    @Encrypt
    @LimitScope(name = "publicTemplateInfoSave", key = "publicTemplateInfoSave")
    public ResponseResult<String> save(@RequestBody PublicTemplateInfo input) {
        publicTemplateInfoService.save(input);
        return success();
    }

    /** PublicTemplateInfo Operation. 修改模板信息配置数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入PublicTemplateInfo对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:template:update')")
    @PlatLog(value = "修改模板信息配置", category = 20)
    @PostMapping("/template/update")
    @Encrypt
    @LimitScope(name = "publicTemplateInfoUpdate", key = "publicTemplateInfoUpdate")
    public ResponseResult<String> update(@RequestBody PublicTemplateInfo input) {
        publicTemplateInfoService.update(input);
        return success();
    }

    /** PublicTemplateInfo Operation. 删除模板信息配置数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 模板ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:template:delete')")
    @PlatLog(value = "删除模板信息配置", category = 40)
    @PostMapping("/template/delete/{ids}")
    @Encrypt
    @LimitScope(name = "publicTemplateInfoDelete", key = "publicTemplateInfoDelete")
    public ResponseResult<String> delete(@PathVariable String[] ids) {
        publicTemplateInfoService.deleteByIds(ids);
        return success();
    }

}
