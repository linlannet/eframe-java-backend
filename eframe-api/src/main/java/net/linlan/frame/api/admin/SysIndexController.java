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
package net.linlan.frame.api.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.linlan.annotation.Encrypt;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.admin.dto.IndexApplicationDto;
import net.linlan.frame.admin.dto.IndexElementDto;
import net.linlan.frame.admin.dto.IndexManageDto;
import net.linlan.frame.admin.param.FrameIndexParam;
import net.linlan.frame.admin.service.FrameIndexService;
import net.linlan.utils.config.PlatformConfig;

/**
 * 平台首页入口
 *
 * @author Linlan
 */
@RestController
public class SysIndexController {
    /** 系统基础配置 */
    @Resource
    private PlatformConfig   platformConfig;

    @Resource
    public FrameIndexService frameIndexService;

    /**
     * 访问首页，提示语
     * @return 返回首页欢迎信息
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", platformConfig.getName(),
            platformConfig.getVersion());
    }

    /**
     *  工作台应用支撑统计
     * @param param 查询参数对象
     * @return 工作台应用支撑统计
     */
    @PlatLog("工作台应用支撑统计")
    @GetMapping("/api/admin/index/application")
    @Encrypt
    public ResponseResult<List<IndexApplicationDto>> getApplicationNum(FrameIndexParam param) {
        List<IndexApplicationDto> result = frameIndexService.getIndexApplicationCount(param);
        return ResponseResult.ok().setResultData(result);
    }

    /**
     *  工作台要素支撑统计
     * @param param 查询参数对象
     * @return 工作台应用支撑统计
     */
    @PlatLog("工作台要素支撑统计")
    @GetMapping("/api/admin/index/element")
    @Encrypt
    public ResponseResult<List<IndexElementDto>> getIndexElementCount(FrameIndexParam param) {
        List<IndexElementDto> result = frameIndexService.getIndexElementCount(param);
        return ResponseResult.ok().setResultData(result);
    }

    /**
     *  工作台管理支撑统计
     * @param param 查询参数对象
     * @return 工作台管理支撑统计
     */
    @PlatLog("工作台管理支撑统计")
    @GetMapping("/api/admin/index/manage")
    @Encrypt
    public ResponseResult<List<IndexManageDto>> getIndexManageCount(FrameIndexParam param) {
        List<IndexManageDto> result = frameIndexService.getIndexManageCount(param);
        return ResponseResult.ok().setResultData(result);
    }

}
