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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.admin.dto.UserPresetDto;
import net.linlan.frame.admin.entity.UserPreset;
import net.linlan.frame.admin.param.UserPresetParam;
import net.linlan.frame.admin.service.UserPresetService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.service.InitialRedisService;
import net.linlan.frame.view.admin.utils.ExcelUtil;

/**
 *
 * PowerPreset控制域: 用户权限预置
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@RestController
@RequestMapping("/api/admin")
public class UserPresetController extends BaseController {

    @Resource
    private UserPresetService   userPresetEntService;
    @Resource
    private InitialRedisService initialRedisService;

    /**
     * 用户权限预置列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "用户权限预置列表")
    @PreAuthorize("@ss.hasPerms('admin:preset:list')")
    @GetMapping("preset/list")
    @Encrypt
    public ResponseResult<Pagination<UserPresetDto>> list(UserPresetParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<UserPresetDto> result = userPresetEntService.getPageDto(param);
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageSize(),
            result.getTotal());
    }

    /**
     * 根据用户权限预置导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "根据用户权限预置导出", category = 52)
    @PreAuthorize("@ss.hasPerms('admin:preset:export')")
    @PostMapping("preset/export")
    @Encrypt
    public void export(HttpServletResponse response, UserPresetParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<UserPresetDto> result = userPresetEntService.getPageDto(param);
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        ExcelUtil<UserPresetDto> util = new ExcelUtil<>(UserPresetDto.class);
        util.exportExcel(response, result, "参数数据");
    }

    /**
     * 根据用户权限预置获取详细信息
     * @param configId  配置ID
     * @return 查询结果
     */
    @PlatLog(value = "根据用户权限预置获取详细信息")
    @PreAuthorize("@ss.hasPerms('admin:preset:detail')")
    @GetMapping(value = "preset/{configId}")
    @Encrypt
    public ResponseResult<UserPresetDto> getInfo(@PathVariable Long configId) {
        if (ObjectUtils.isEmpty(configId)) {
            return failure();
        }
        UserPresetDto dto = userPresetEntService.getDtoById(configId);
        if (ObjectUtils.isEmpty(dto)) {
            return empty();
        }
        return success(dto);
    }

    /**
     * 新增户权限预置
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:preset:save')")
    @PlatLog(value = "新增户权限预置", category = 10)
    @PostMapping("preset/save")
    @Encrypt
    @LimitScope(name = "userPresetSave", key = "userPresetSave")
    public ResponseResult<String> save(@Validated @RequestBody UserPreset input) {
        if (ObjectUtils.isNotEmpty(userPresetEntService.findById(input.getId()))) {
            return error("新增参数'" + input.getId() + "'失败，参数键名已存在");
        }
        userPresetEntService.save(input);
        return success();
    }

    /**
     * 修改户权限预置
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:preset:update')")
    @PlatLog(value = "修改户权限预置", category = 20)
    @PostMapping("preset/update")
    @Encrypt
    @LimitScope(name = "userPresetUpdate", key = "userPresetUpdate")
    public ResponseResult<String> update(@Validated @RequestBody UserPreset input) {
        userPresetEntService.update(input);
        return success();
    }

    /**
     * 删除户权限预置
     * @param configIds  配置IDs
     * @return 删除结果
     */
    //    @PreAuthorize("@ss.hasPerms('admin:preset:delete')")
    @PlatLog(value = "删除户权限预置", category = 40)
    @PostMapping("preset/delete/{configIds}")
    @Encrypt
    @LimitScope(name = "userPresetDelete", key = "userPresetDelete")
    public ResponseResult<String> delete(@PathVariable Long[] configIds) {
        userPresetEntService.deleteByIds(configIds);
        return success();
    }

    /**
     * 刷新户权限预置缓存
     * @return 刷新结果
     */
    @PreAuthorize("@ss.hasPerms('admin:preset:delete')")
    @PlatLog(value = "刷新户权限预置缓存", category = 21)
    @DeleteMapping("preset/refreshCache")
    @Encrypt
    @LimitScope(name = "userPresetRefresh", key = "userPresetRefresh")
    public ResponseResult<String> refreshCache() {
        initialRedisService.resetConfigCache();
        return success();
    }

}
