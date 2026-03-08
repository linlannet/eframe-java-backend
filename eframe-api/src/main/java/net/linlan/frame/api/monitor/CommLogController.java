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

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.param.CommLogVoParam;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.admin.vo.CommLogVo;
import net.linlan.sys.comm.dto.CommLogDto;
import net.linlan.sys.comm.param.CommLogParam;
import net.linlan.sys.comm.service.CommLogService;

/**
 * 系统操作日志记录
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/monitor/")
public class CommLogController extends BaseController {
    @Resource
    private CommLogService commLogService;

    /**
     * 查看全部日志列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "查看全部日志列表")
    @PreAuthorize("@ss.hasPerms('monitor:commlog:list')")
    @GetMapping("commlog/list")
    public ResponseEntity<Pagination<CommLogVo>> list(CommLogParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<CommLogDto> result = commLogService.getPageDto(param);
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<CommLogVo> vos = Lists.transform(result.getResult(), CommLogVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 操作日志导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "操作日志导出", category = 52)
    @PreAuthorize("@ss.hasPerms('monitor:commlog:export')")
    @PostMapping("commlog/export")
    public void export(HttpServletResponse response, CommLogVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<CommLogDto> result = commLogService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<CommLogVo> vos = Lists.transform(result.getResult(), CommLogVo.DTO);
        ExcelUtil<CommLogVo> util = new ExcelUtil<CommLogVo>(CommLogVo.class);
        util.exportExcel(response, vos, "操作日志");
    }

    /**
     * 操作日志清理
     * @param ids  主键Ids
     * @return 查询结果
     */
    @PlatLog(value = "操作日志清理", category = 40)
    @PreAuthorize("@ss.hasPerms('monitor:commlog:delete')")
    @DeleteMapping("commlog/{ids}")
    @LimitScope(name = "commLogDelete", key = "commLogDelete")
    public ResponseEntity<String> delete(@PathVariable Long[] ids) {
        commLogService.deleteByIds(ids);
        return success();
    }

}
