/*
 * module-authn - 动态认证对接模块
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
package net.linlan.authn.sms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.authn.sms.dto.SmsSendRecordDto;
import net.linlan.authn.sms.entity.SmsSendRecord;
import net.linlan.authn.sms.param.SmsSendRecordParam;
import net.linlan.authn.sms.service.SmsSendRecordService;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.frame.api.BaseController;

/**
*
* 短信发送记录读写控制类
* @author Linlan
* CreateTime 2025-10-15 14:07:47
* @version 1.0
* @since 1.0
*
*/
@RestController
@RequestMapping("/api/store")
public class SmsSendRecordController extends BaseController {
    @Resource
    private SmsSendRecordService smsSendRecordService;

    /** Get SmsSendRecord list. 获取短信发送记录列表或分页, 返回SmsSendRecord对象.
     * @param param 参数查询对象
     * @return 列表的短信发送记录数据 {@link List} 对象，包含 {@link SmsSendRecord} 列表:null,error;page,success
     */
    @PreAuthorize("@ss.hasPerms('store:smssendrecord:list')")
    @PlatLog(value = "查询短信发送记录分页", category = 0)
    @GetMapping("/smssendrecord/list")
    @Encrypt
    public ResponseEntity<List<SmsSendRecord>> list(SmsSendRecordParam param) {
        Page<SmsSendRecordDto> result = smsSendRecordService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * Get SmsSendRecord by id. 主键获取短信发送记录详细信息.
     * @param id 主键ID|1
     * @return {@link SmsSendRecord}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('store:smssendrecord:detail')")
    @PlatLog(value = "主键获取短信发送记录详细信息", category = 1)
    @GetMapping(value = "/smssendrecord/{id}")
    @Encrypt
    public ResponseEntity<SmsSendRecord> findById(@PathVariable("id") Long id) {
        return success(smsSendRecordService.findById(id));
    }

    /** SmsSendRecord Operation. 新增短信发送记录数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入SmsSendRecord对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('store:smssendrecord:save')")
    @PlatLog(value = "新增短信发送记录", category = 10)
    @PostMapping("/smssendrecord/save")
    @Encrypt
    @LimitScope(name = "smsSendRecordSave", key = "smsSendRecordSave")
    public ResponseEntity<String> save(@RequestBody SmsSendRecord input) {
        smsSendRecordService.save(input);
        return success();
    }

    /** SmsSendRecord Operation. 修改短信发送记录数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入SmsSendRecord对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('store:smssendrecord:update')")
    @PlatLog(value = "修改短信发送记录", category = 20)
    @PostMapping("/smssendrecord/update")
    @Encrypt
    @LimitScope(name = "smsSendRecordUpdate", key = "smsSendRecordUpdate")
    public ResponseEntity<String> update(@RequestBody SmsSendRecord input) {
        smsSendRecordService.update(input);
        return success();
    }

    /** SmsSendRecord Operation. 删除短信发送记录数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 主键ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('store:smssendrecord:delete')")
    @PlatLog(value = "删除短信发送记录", category = 40)
    @PostMapping("/smssendrecord/delete/{ids}")
    @Encrypt
    @LimitScope(name = "smsSendRecordDelete", key = "smsSendRecordDelete")
    public ResponseEntity<String> delete(@PathVariable Long[] ids) {
        smsSendRecordService.deleteByIds(ids);
        return success();
    }

}
