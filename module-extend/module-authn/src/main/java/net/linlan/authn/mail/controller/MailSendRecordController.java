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
package net.linlan.authn.mail.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import jakarta.annotation.Resource;
import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.authn.mail.dto.MailSendRecordDto;
import net.linlan.authn.mail.entity.MailSendRecord;
import net.linlan.authn.mail.param.MailSendRecordParam;
import net.linlan.authn.mail.service.MailSendRecordService;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.frame.api.BaseController;

/**
*
* 邮件发送记录读写控制类
* @author Linlan
* CreateTime 2025-10-15 14:09:40
* @version 1.0
* @since 1.0
*
*/
@RestController
@RequestMapping("/api/store")
public class MailSendRecordController extends BaseController {
    @Resource
    private MailSendRecordService mailSendRecordService;

    /** Get MailSendRecord list. 获取邮件发送记录列表或分页, 返回MailSendRecord对象.
     * @param param 参数查询对象
     * @return 列表的邮件发送记录数据 {@link List} 对象，包含 {@link MailSendRecord} 列表:null,error;page,success
     */
    @PreAuthorize("@ss.hasPerms('store:mailsendrecord:list')")
    @PlatLog(value = "查询邮件发送记录分页", category = 0)
    @GetMapping("/mailsendrecord/list")
    @Encrypt
    public ResponseEntity<List<MailSendRecord>> list(MailSendRecordParam param) {
        Page<MailSendRecordDto> result = mailSendRecordService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * Get MailSendRecord by id. 主键获取邮件发送记录详细信息.
     * @param id 主键ID|1
     * @return {@link MailSendRecord}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('store:mailsendrecord:detail')")
    @PlatLog(value = "主键获取邮件发送记录详细信息", category = 1)
    @GetMapping(value = "/mailsendrecord/{id}")
    @Encrypt
    public ResponseEntity<MailSendRecord> findById(@PathVariable("id") Long id) {
        return success(mailSendRecordService.findById(id));
    }

    /** MailSendRecord Operation. 新增邮件发送记录数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入MailSendRecord对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('store:mailsendrecord:save')")
    @PlatLog(value = "新增邮件发送记录", category = 10)
    @PostMapping("/mailsendrecord/save")
    @Encrypt
    @LimitScope(name = "mailSendRecordSave", key = "mailSendRecordSave")
    public ResponseEntity<String> save(@RequestBody MailSendRecord input) {
        mailSendRecordService.save(input);
        return success();
    }

    /** MailSendRecord Operation. 修改邮件发送记录数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入MailSendRecord对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('store:mailsendrecord:update')")
    @PlatLog(value = "修改邮件发送记录", category = 20)
    @PostMapping("/mailsendrecord/update")
    @Encrypt
    @LimitScope(name = "mailSendRecordUpdate", key = "mailSendRecordUpdate")
    public ResponseEntity<String> update(@RequestBody MailSendRecord input) {
        mailSendRecordService.update(input);
        return success();
    }

    /** MailSendRecord Operation. 删除邮件发送记录数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 主键ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('store:mailsendrecord:delete')")
    @PlatLog(value = "删除邮件发送记录", category = 40)
    @PostMapping("/mailsendrecord/delete/{ids}")
    @Encrypt
    @LimitScope(name = "mailSendRecordDelete", key = "mailSendRecordDelete")
    public ResponseEntity<String> delete(@PathVariable Long[] ids) {
        mailSendRecordService.deleteByIds(ids);
        return success();
    }

}
