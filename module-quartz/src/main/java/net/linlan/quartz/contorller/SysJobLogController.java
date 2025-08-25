/*
 * module-quartz - quartz定时任务模块
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
package net.linlan.quartz.contorller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.quartz.param.SysJobLogParam;
import net.linlan.quartz.vo.SysJobLogVo;
import net.linlan.sys.job.dto.ScheduleLogDto;
import net.linlan.sys.job.entity.ScheduleLog;
import net.linlan.sys.job.service.ScheduleLogService;

/**
 * 调度日志操作处理
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/monitor/")
public class SysJobLogController extends BaseController {
    @Resource
    private ScheduleLogService scheduleLogService;

    /**
     * 查询定时任务调度日志列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:list')")
    @GetMapping("joblog/list")
    public ResponseResult<List<SysJobLogVo>> list(SysJobLogParam param) {
        Page<ScheduleLogDto> result = scheduleLogService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<SysJobLogVo> vos = Lists.transform(result.getResult(), SysJobLogVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 导出定时任务调度日志列表
     * @param response  响应
     * @param param     导出查询条件
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:export')")
    @PlatLog(value = "任务调度日志", category = 52)
    @PostMapping("joblog/export")
    public void export(HttpServletResponse response, SysJobLogParam param) {
        Page<ScheduleLogDto> result = scheduleLogService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<SysJobLogVo> vos = Lists.transform(result.getResult(), SysJobLogVo.DTO);
        ExcelUtil<SysJobLogVo> util = new ExcelUtil<SysJobLogVo>(SysJobLogVo.class);
        util.exportExcel(response, vos, "调度日志");
    }

    /**
     * 根据调度编号获取详细信息
     * @param jobLogId     任务日志ID
     * @return 任务日志详情
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:detail')")
    @GetMapping(value = "joblog/{jobLogId}")
    public ResponseResult<SysJobLogVo> getInfo(@PathVariable String jobLogId) {
        if (ObjectUtils.isEmpty(jobLogId)) {
            return failure();
        }
        SysJobLogVo vo = null;
        ScheduleLog entity = scheduleLogService.findById(jobLogId);
        if (entity != null) {
            vo = (SysJobLogVo) SysJobLogVo.TO.apply(entity);
        }
        return success(vo);
    }

    /**
     * 删除定时任务调度日志
     * @param jobLogIds     任务日志Ids
     * @return 删除结果
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:delete')")
    @PlatLog(value = "定时任务调度日志", category = 40)
    @DeleteMapping("joblog/{jobLogIds}")
    @LimitScope(name = "sysJobLogDelete", key = "sysJobLogDelete")
    public ResponseResult<String> delete(@PathVariable String[] jobLogIds) {
        scheduleLogService.deleteByIds(jobLogIds);
        return success();
    }

}
