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

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.quartz.param.SysJobParam;
import net.linlan.quartz.vo.SysJobVo;
import net.linlan.sys.job.dto.ScheduleInfoDto;
import net.linlan.sys.job.entity.ScheduleInfo;
import net.linlan.sys.job.service.ScheduleInfoService;
import net.linlan.sys.job.utils.ScheduleUtils;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.http.HttpContextUtils;

/**
 * 调度任务信息操作处理
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/monitor/")
public class SysJobController extends BaseController {
    @Resource
    private ScheduleInfoService scheduleInfoService;

    /**
     * 查询定时任务列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:list')")
    @GetMapping("job/list")
    public ResponseEntity<List<SysJobVo>> list(SysJobParam param) {
        Page<ScheduleInfoDto> result = scheduleInfoService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<SysJobVo> vos = Lists.transform(result.getResult(), SysJobVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 导出定时任务列表
     * @param response  响应
     * @param param     导出查询条件
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:export')")
    @PlatLog(value = "定时任务", category = 52)
    @PostMapping("job/export")
    public void export(HttpServletResponse response, SysJobParam param) {
        Page<ScheduleInfoDto> result = scheduleInfoService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<SysJobVo> vos = Lists.transform(result.getResult(), SysJobVo.DTO);
        ExcelUtil<SysJobVo> util = new ExcelUtil<SysJobVo>(SysJobVo.class);
        util.exportExcel(response, vos, "定时任务");
    }

    /**
     * 获取定时任务详细信息
     * @param jobId     任务ID
     * @return 任务详情
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:detail')")
    @GetMapping(value = "job/{jobId}")
    public ResponseEntity<SysJobVo> getInfo(@PathVariable("jobId") String jobId) {
        if (ObjectUtils.isEmpty(jobId)) {
            return failure();
        }
        SysJobVo vo = null;
        ScheduleInfo entity = scheduleInfoService.findById(jobId);
        if (entity != null) {
            vo = (SysJobVo) SysJobVo.TO.apply(entity);
        }
        return success(vo);
    }

    /**
     * 新增定时任务
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:save')")
    @PlatLog(value = "定时任务", category = 10)
    @PostMapping("job/save")
    @LimitScope(name = "sysJobSave", key = "sysJobSave")
    public ResponseEntity<String> save(@RequestBody SysJobVo input) {
        if (!ScheduleUtils.isValid(input.getCronExpression())) {
            return error("新增任务'" + input.getJobName() + "'失败，Cron表达式不正确");
        } else if (StringUtils.containsIgnoreCase(input.getInvokeTarget(), Constants.LOOKUP_RMI)) {
            return error("新增任务'" + input.getJobName() + "'失败，目标字符串不允许'rmi'调用");
        } else if (StringUtils.containsAnyIgnoreCase(input.getInvokeTarget(),
            new String[] { Constants.LOOKUP_LDAP, Constants.LOOKUP_LDAPS })) {
            return error("新增任务'" + input.getJobName() + "'失败，目标字符串不允许'ldap(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(input.getInvokeTarget(),
            new String[] { HttpContextUtils.HTTP, HttpContextUtils.HTTPS })) {
            return error("新增任务'" + input.getJobName() + "'失败，目标字符串不允许'http(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(input.getInvokeTarget(),
            Constants.JOB_ERROR_STR)) {
            return error("新增任务'" + input.getJobName() + "'失败，目标字符串存在违规");
        } else if (!ScheduleUtils.whiteList(input.getInvokeTarget())) {
            return error("新增任务'" + input.getJobName() + "'失败，目标字符串不在白名单内");
        }
        scheduleInfoService.save(SysJobVo.transTo(input));
        return success();
    }

    /**
     * 修改定时任务
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:update')")
    @PlatLog(value = "定时任务", category = 20)
    @PostMapping("job/update")
    @LimitScope(name = "sysJobUpdate", key = "sysJobUpdate")
    public ResponseEntity<String> edit(@RequestBody SysJobVo input) {
        if (!ScheduleUtils.isValid(input.getCronExpression())) {
            return error("修改任务'" + input.getJobName() + "'失败，Cron表达式不正确");
        } else if (StringUtils.containsIgnoreCase(input.getInvokeTarget(), Constants.LOOKUP_RMI)) {
            return error("修改任务'" + input.getJobName() + "'失败，目标字符串不允许'rmi'调用");
        } else if (StringUtils.containsAnyIgnoreCase(input.getInvokeTarget(),
            new String[] { Constants.LOOKUP_LDAP, Constants.LOOKUP_LDAPS })) {
            return error("修改任务'" + input.getJobName() + "'失败，目标字符串不允许'ldap(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(input.getInvokeTarget(),
            new String[] { HttpContextUtils.HTTP, HttpContextUtils.HTTPS })) {
            return error("修改任务'" + input.getJobName() + "'失败，目标字符串不允许'http(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(input.getInvokeTarget(),
            Constants.JOB_ERROR_STR)) {
            return error("修改任务'" + input.getJobName() + "'失败，目标字符串存在违规");
        } else if (!ScheduleUtils.whiteList(input.getInvokeTarget())) {
            return error("修改任务'" + input.getJobName() + "'失败，目标字符串不在白名单内");
        }
        scheduleInfoService.update(SysJobVo.transTo(input));
        return success();
    }

    /**
     * 定时任务状态修改
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:changeStatus')")
    @PlatLog(value = "定时任务", category = 20)
    @PostMapping("job/changeStatus")
    public ResponseEntity<String> changeStatus(@RequestBody SysJobVo input) {
        ScheduleInfo newJob = scheduleInfoService.findById(input.getJobId());
        newJob.setStatus(input.getStatus());
        scheduleInfoService.update(newJob);
        return success();
    }

    /**
     * 定时任务立即执行一次
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:changeStatus')")
    @PlatLog(value = "定时任务", category = 20)
    @PostMapping("job/run")
    public ResponseEntity<String> run(@RequestBody SysJobVo input) {
        scheduleInfoService.run(new String[] { input.getJobId() });
        return success();
    }

    /**
     * 删除定时任务
     * @param jobIds    任务Ids
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('monitor:job:delete')")
    @PlatLog(value = "定时任务", category = 40)
    @DeleteMapping("job/{jobIds}")
    @LimitScope(name = "sysJobDelete", key = "sysJobDelete")
    public ResponseEntity<String> delete(@PathVariable String[] jobIds) {
        scheduleInfoService.deleteByIds(jobIds);
        return success();
    }
}
