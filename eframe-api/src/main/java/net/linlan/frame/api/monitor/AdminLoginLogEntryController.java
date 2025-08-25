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
package net.linlan.frame.api.monitor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.admin.dto.AdminLoginLogDto;
import net.linlan.frame.admin.service.AdminLoginLogService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.comm.service.SysPasswordService;
import net.linlan.frame.view.admin.param.AdminLoginLogVoParam;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.admin.vo.AdminLoginLogVo;

/**
 *
 * AdminLoginLog控制域:管理员登录日志查询读取控制类
 * @author Linlan
 * CreateTime 2024-10-07 20:45:06
 *
 */
@RestController
@RequestMapping("api/monitor/")
public class AdminLoginLogEntryController extends BaseController {

    @Resource
    private AdminLoginLogService adminLoginLogService;
    @Resource
    private SysPasswordService   sysPasswordService;

    /**
     * 获取管理员登录日志列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取管理员登录日志列表")
    @PreAuthorize("@ss.hasPerms('monitor:loginlog:list')")
    @GetMapping("loginlog/list")
    public ResponseResult<Pagination<AdminLoginLogVo>> list(AdminLoginLogVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<AdminLoginLogDto> result = adminLoginLogService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<AdminLoginLogVo> vos = Lists.transform(result.getResult(), AdminLoginLogVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 获取管理员登录日志列表
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "管理员登录日志列表导出", category = 52)
    @PreAuthorize("@ss.hasPerms('monitor:loginlog:export')")
    @PostMapping("loginlog/export")
    public void export(HttpServletResponse response, AdminLoginLogVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<AdminLoginLogDto> result = adminLoginLogService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<AdminLoginLogVo> vos = Lists.transform(result.getResult(), AdminLoginLogVo.DTO);
        ExcelUtil<AdminLoginLogVo> util = new ExcelUtil<AdminLoginLogVo>(AdminLoginLogVo.class);
        util.exportExcel(response, vos, "登录日志");
    }

    /**
     * 删除管理员登录日志
     * @param infoIds  信息Ids
     * @return 删除结果
     */
    @PreAuthorize("@ss.hasPerms('monitor:loginlog:delete')")
    @PlatLog(value = "删除管理员登录日志", category = 40)
    @DeleteMapping("loginlog/{infoIds}")
    @LimitScope(name = "adminLoginLogDelete", key = "adminLoginLogDelete")
    public ResponseResult<String> delete(@PathVariable Long[] infoIds) {
        adminLoginLogService.deleteByIds(infoIds);
        return success();
    }

    /**
     * 清理管理员登录日志
     * @return 清理结果
     */
    @PreAuthorize("@ss.hasPerms('monitor:loginlog:delete')")
    @PlatLog(value = "清理管理员登录日志", category = 21)
    @DeleteMapping("loginlog/clean")
    public ResponseResult<String> clean() {
        return success();
    }

    /**
     * 账户解锁
     * @param username  用户名
     * @return 账号解锁结果
     */
    @PreAuthorize("@ss.hasPerms('monitor:loginlog:unlock')")
    @PlatLog(value = "账户解锁", category = 50)
    @GetMapping("loginlog/unlock/{username}")
    public ResponseResult<String> unlock(@PathVariable("username") String username) {
        sysPasswordService.clearLoginRecordCache(username);
        return success();
    }

}
