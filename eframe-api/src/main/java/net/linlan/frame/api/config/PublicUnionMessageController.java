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
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.config.dto.PublicUnionMessageDto;
import net.linlan.frame.config.entity.PublicUnionMessage;
import net.linlan.frame.config.param.PublicUnionMessageParam;
import net.linlan.frame.config.service.PublicUnionMessageService;
import net.linlan.frame.view.admin.utils.ExcelUtil;

/**
 *
 * 消息阅读读写控制类
 * @author Linlan
 * CreateTime 2024-11-19 14:58:52
 *
 */
@RestController
@RequestMapping("/api/system")
public class PublicUnionMessageController extends BaseController {

    @Resource
    private PublicUnionMessageService portalUnionMessageService;

    /** Get PublicUnionMessage list. 获取消息阅读列表或分页, 返回PublicUnionMessage对象.
     * @param param 参数查询对象
     * @return 获取消息阅读列表或分页, 返回PublicUnionMessage对象.
     */
    @PreAuthorize("@ss.hasPerms('system:message:list')")
    @PlatLog(value = "查询消息阅读分页")
    @GetMapping("/message/list")
    @Encrypt
    public ResponseEntity<List<PublicUnionMessageDto>> list(PublicUnionMessageParam param) {
        Page<PublicUnionMessageDto> result = portalUnionMessageService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /** PublicUnionMessage Operation. PublicUnionMessage数据操作逻辑，导出操作.
     * @param response 响应体
     * @param param 参数查询对象
     */
    @PreAuthorize("@ss.hasPerms('system:message:export')")
    @PlatLog(value = "导出消息阅读列表", category = 52)
    @PostMapping("/message/export")
    @Encrypt
    public void export(HttpServletResponse response, PublicUnionMessageParam param) {
        List<PublicUnionMessageDto> list = portalUnionMessageService.getPageDto(param);
        ExcelUtil<PublicUnionMessageDto> util = new ExcelUtil<PublicUnionMessageDto>(
            PublicUnionMessageDto.class);
        util.exportExcel(response, list, "消息阅读数据导出");
    }

    /**
     * Get PublicUnionMessage by id. 主键获取消息阅读详细信息.
     * @param id 主键ID|1
     * @return {@link PublicUnionMessage}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:message:detail')")
    @PlatLog(value = "主键获取消息阅读详细信息", category = 1)
    @GetMapping(value = "/message/{id}")
    @Encrypt
    public ResponseEntity<PublicUnionMessage> getPublicUnionMessageById(@PathVariable("id") String id) {
        return success(portalUnionMessageService.findById(id));
    }

    /** PublicUnionMessage Operation. 新增消息阅读数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入PublicUnionMessage对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:message:save')")
    @PlatLog(value = "新增消息阅读", category = 10)
    @PostMapping("/message/save")
    @Encrypt
    @LimitScope(name = "publicUnionMessageSave", key = "publicUnionMessageSave")
    public ResponseEntity<String> save(@RequestBody PublicUnionMessage input) {
        portalUnionMessageService.save(input);
        return success();
    }

    /** PublicUnionMessage Operation. 修改消息阅读数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入PublicUnionMessage对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:message:update')")
    @PlatLog(value = "修改消息阅读", category = 20)
    @PostMapping("/message/update")
    @Encrypt
    @LimitScope(name = "publicUnionMessageUpdate", key = "publicUnionMessageUpdate")
    public ResponseEntity<String> update(@RequestBody PublicUnionMessage input) {
        portalUnionMessageService.update(input);
        return success();
    }

    /** PublicUnionMessage Operation. 删除消息阅读数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 主键ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:message:delete')")
    @PlatLog(value = "删除消息阅读", category = 40)
    @PostMapping("/message/delete/{ids}")
    @Encrypt
    @LimitScope(name = "publicUnionMessageDelete", key = "publicUnionMessageDelete")
    public ResponseEntity<String> delete(@PathVariable String[] ids) {
        portalUnionMessageService.deleteByIds(ids);
        return success();
    }

    /** PublicUnionMessage Operation. 删除消息阅读数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 主键ID:null;1;1,2,3|1
     * @param status 消息状态
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:message:list')")
    @PlatLog(value = "消息批量已读", category = 21)
    @PostMapping("/message/read/{ids}/{status}")
    @Encrypt
    @LimitScope(name = "publicUnionMessageRead", key = "publicUnionMessageRead")
    public ResponseEntity<String> read(@PathVariable String[] ids, @PathVariable String status) {
        if (ObjectUtils.isEmpty(ids)) {
            return error();
        }
        //设置批量已读未读
        for (String pkId : ids) {

            PublicUnionMessage portalUnionMessage = portalUnionMessageService.findById(pkId);
            if (portalUnionMessage == null) {
                return error();
            }
            if (portalUnionMessage.getStatus() != null) {
                portalUnionMessage.setStatus(status);
            }
            portalUnionMessageService.update(portalUnionMessage);
        }

        return success();
    }

}
