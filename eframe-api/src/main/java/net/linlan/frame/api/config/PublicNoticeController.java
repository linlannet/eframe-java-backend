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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.commons.script.json.JsonMapUtils;
import net.linlan.commons.script.json.StringMap;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.config.dto.PublicNoticeDto;
import net.linlan.frame.config.entity.PublicNotice;
import net.linlan.frame.config.entity.PublicUnionMessage;
import net.linlan.frame.config.param.PublicNoticeParam;
import net.linlan.frame.config.service.PublicNoticeService;
import net.linlan.frame.config.service.PublicUnionMessageService;
import net.linlan.frame.view.admin.utils.ExcelUtil;

/**
 *
 * 平台公共消息读写控制类
 * @author Linlan
 * CreateTime 2024-11-19 14:58:36
 *
 */
@RestController
@RequestMapping("/api/system")
public class PublicNoticeController extends BaseController {
    @Resource
    private PublicNoticeService       publicNoticeService;
    @Resource
    private PublicUnionMessageService portalUnionMessageService;

    /** Get PublicNotice list. 获取平台公共消息列表或分页, 返回PublicNotice对象.
     * @param param 参数查询对象
     * @return 获取平台公共消息列表或分页, 返回PublicNotice对象.
     */
    @PreAuthorize("@ss.hasPerms('system:notice:list')")
    @PlatLog(value = "查询平台公共消息分页")
    @GetMapping("/notice/list")
    @Encrypt
    public ResponseEntity<List<PublicNotice>> list(PublicNoticeParam param) {

        Page<PublicNoticeDto> result = publicNoticeService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /** Get PublicNotice list. 获取所有信息列表分页
     * @param param 参数查询对象
     * @return 获取所有信息列表分页
     */
    @PreAuthorize("@ss.hasPerms('system:notice:list')")
    @PlatLog(value = "查询平台公共消息分页")
    @GetMapping("/notice/list/myself")
    @Encrypt
    public ResponseEntity<List<PublicNotice>> myselfList(PublicNoticeParam param) {
        FrameUserDetails loginUser = getLoginUser();
        if (loginUser.getUserId() == null) {
            return error();
        }
        param.setRecvMemberId(loginUser.getUserId());
        Page<PublicNoticeDto> result = publicNoticeService.getMyselfList(param);
        if (result == null) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /** PublicNotice Operation. PublicNotice数据操作逻辑，导出操作.
     * @param response 响应体
     * @param param 参数查询对象
     */
    @PreAuthorize("@ss.hasPerms('system:notice:export')")
    @PlatLog(value = "导出平台公共消息列表", category = 52)
    @PostMapping("/notice/export")
    @Encrypt
    public void export(HttpServletResponse response, PublicNoticeParam param) {
        List<PublicNotice> list = publicNoticeService.getList(JsonMapUtils.beanToMap(param));
        ExcelUtil<PublicNotice> util = new ExcelUtil<PublicNotice>(PublicNotice.class);
        util.exportExcel(response, list, "平台公共消息数据导出");
    }

    /**
     * Get PublicNotice by id. 主键获取平台公共消息详细信息.
     * @param id 信息ID|1
     * @return {@link PublicNotice}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:notice:detail')")
    @PlatLog(value = "主键获取平台公共消息详细信息", category = 1)
    @GetMapping(value = "/notice/{id}")
    @Encrypt
    public ResponseEntity<PublicNotice> getPublicNoticeById(@PathVariable("id") Long id) {
        return success(publicNoticeService.findById(id));
    }

    /** PublicNotice Operation. 新增平台公共消息数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入PublicNotice对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:notice:save')")
    @PlatLog(value = "新增平台公共消息", category = 10)
    @PostMapping("/notice/save")
    @Encrypt
    @LimitScope(name = "publicNoticeSave", key = "publicNoticeSave")
    public ResponseEntity<String> save(@RequestBody PublicNotice input) {
        publicNoticeService.save(input);
        return success();
    }

    /** PublicNotice Operation. 修改平台公共消息数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入PublicNotice对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:notice:update')")
    @PlatLog(value = "修改平台公共消息", category = 20)
    @PostMapping("/notice/update")
    @Encrypt
    @LimitScope(name = "publicNoticeUpdate", key = "publicNoticeUpdate")
    public ResponseEntity<String> update(@RequestBody PublicNotice input) {
        publicNoticeService.update(input);
        return success();
    }

    /** PublicNotice Operation. 删除平台公共消息数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 信息ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:notice:delete')")
    @PlatLog(value = "删除平台公共消息", category = 40)
    @PostMapping("/notice/delete/{ids}")
    @Encrypt
    @LimitScope(name = "publicNoticeDelete", key = "publicNoticeDelete")
    public ResponseEntity<String> delete(@PathVariable Long[] ids) {
        publicNoticeService.deleteByIds(ids);
        return success();
    }

    /** PublicNotice Operation. 将当前账户的未读消息全部设置为已读.
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:notice:list')")
    @PlatLog(value = "消息全部已读", category = 21)
    @PostMapping("/notice/read/all")
    @Encrypt
    @LimitScope(name = "publicNoticeReadAll", key = "publicNoticeReadAll")
    public ResponseEntity<String> allRead() {

        FrameUserDetails loginUser = getLoginUser();
        if (loginUser.getUserId() == null) {
            return error();
        }
        PublicNoticeParam param = new PublicNoticeParam();
        param.setRecvMemberId(loginUser.getUserId());
        param.setBizType("ent");
        param.setReadStatus("0");

        Page<PublicNoticeDto> page = publicNoticeService.getMyselfList(param);

        if (page != null && page.size() > 0) {
            for (PublicNoticeDto publicNoticeDto : page) {
                PublicUnionMessage message = new PublicUnionMessage();
                message.init();
                message.setType("PUBLIC_NOTICE");
                message.setMsgId(publicNoticeDto.getId());
                message.setMsgUserId(loginUser.getUserId());
                message.setCreateTime(new Date());
                portalUnionMessageService.save(message);
            }
        }

        return success();
    }

    /** PublicNotice Operation. 将当前账户的未读消息全部设置为已读.
     * @param ids   主键Ids
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:notice:list')")
    @PlatLog(value = "消息批量已读", category = 21)
    @PostMapping("/notice/read/{ids}")
    @Encrypt
    @LimitScope(name = "publicNoticeRead", key = "publicNoticeRead")
    public ResponseEntity<String> read(@PathVariable Long[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            return error();
        }
        FrameUserDetails loginUser = getLoginUser();
        if (loginUser.getUserId() == null) {
            return error();
        }
        //设置批量已读未读
        for (Long pkId : ids) {
            PublicUnionMessage message = new PublicUnionMessage();
            message.init();
            message.setType("PUBLIC_NOTICE");
            message.setMsgId(pkId);
            message.setMsgUserId(loginUser.getUserId());
            message.setCreateTime(new Date());
            portalUnionMessageService.save(message);
        }

        return success();
    }

    /** PublicNotice Operation. 将指定的消息设置为未读状态.
     * @param ids 主键ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:notice:list')")
    @PlatLog(value = "消息标记未读", category = 21)
    @PostMapping("/notice/unRead/{ids}")
    @Encrypt
    @LimitScope(name = "publicNoticeUnRead", key = "publicNoticeUnRead")
    public ResponseEntity<String> unRead(@PathVariable Long[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            return error();
        }
        FrameUserDetails loginUser = getLoginUser();
        if (loginUser.getUserId() == null) {
            return error();
        }
        //设置批量已读未读
        for (Long pkId : ids) {

            List<PublicUnionMessage> list = portalUnionMessageService.getList(
                new StringMap().put("msgId", pkId).put("msgUserId", loginUser.getUserId()).map());
            if (list != null && list.size() > 0) {
                for (PublicUnionMessage message : list) {
                    portalUnionMessageService.deleteById(message.getId());
                }
            }
        }

        return success();
    }

    /** PublicNotice Operation. . 获取获取未读消息数量
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:notice:list')")
    @PlatLog(value = "获取未读消息数据", category = 21)
    @GetMapping("/notice/num")
    @Encrypt
    public ResponseEntity<Map<String, String>> getNum() {

        FrameUserDetails loginUser = getLoginUser();

        if (loginUser.getUserId() == null) {
            return error();
        }
        PublicNoticeParam param = new PublicNoticeParam();
        param.setRecvMemberId(loginUser.getUserId());
        param.setBizType("ent");
        param.setReadStatus("0");

        Page<PublicNoticeDto> page = publicNoticeService.getMyselfList(param);
        param.setType(1);
        Page<PublicNoticeDto> page1 = publicNoticeService.getMyselfList(param);
        param.setType(2);
        Page<PublicNoticeDto> page2 = publicNoticeService.getMyselfList(param);

        Map map = new HashMap<>();

        //所有未读
        map.put("all", page.getTotal());
        //
        map.put("num1", page1.getTotal());
        //
        map.put("num2", page2.getTotal());

        return success(map);
    }

}
