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
package net.linlan.frame.api.sys;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.service.InitialRedisService;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.sys.param.BaseConfigWholeVoParam;
import net.linlan.frame.view.sys.vo.BaseConfigWholeVo;
import net.linlan.sys.base.dto.BaseConfigWholeDto;
import net.linlan.sys.base.entity.BaseConfigWhole;
import net.linlan.sys.base.service.BaseConfigWholeService;

/**
 * 参数配置信息操作处理
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/system/")
public class BaseConfigWholeController extends BaseController {

    @Resource
    private BaseConfigWholeService baseConfigWholeService;
    @Resource
    private InitialRedisService    initialRedisService;

    /**
     * 获取参数配置列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取参数配置列表")
    @PreAuthorize("@ss.hasPerms('system:configwhole:list')")
    @GetMapping("configwhole/list")
    @Encrypt
    public ResponseEntity<Pagination<BaseConfigWholeVo>> list(BaseConfigWholeVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<BaseConfigWholeDto> result = baseConfigWholeService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<BaseConfigWholeVo> vos = Lists.transform(result.getResult(), BaseConfigWholeVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 参数配置导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "参数配置导出", category = 52)
    @PreAuthorize("@ss.hasPerms('system:configwhole:export')")
    @PostMapping("configwhole/export")
    @Encrypt
    public void export(HttpServletResponse response, BaseConfigWholeVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<BaseConfigWholeDto> result = baseConfigWholeService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<BaseConfigWholeVo> vos = Lists.transform(result.getResult(), BaseConfigWholeVo.DTO);
        ExcelUtil<BaseConfigWholeVo> util = new ExcelUtil<>(BaseConfigWholeVo.class);
        util.exportExcel(response, vos, "参数数据");
    }

    /**
     * 根据参数编号获取详细信息
     * @param configId    配置ID
     * @return 配置对象
     */
    @PlatLog(value = "根据参数编号获取详细信息")
    @PreAuthorize("@ss.hasPerms('system:configwhole:detail')")
    @GetMapping(value = "configwhole/{configId}")
    @Encrypt
    public ResponseEntity<BaseConfigWholeVo> getInfo(@PathVariable String configId) {
        if (ObjectUtils.isEmpty(configId)) {
            return failure();
        }
        BaseConfigWholeDto dto = baseConfigWholeService.getDtoById(configId);
        if (ObjectUtils.isEmpty(dto)) {
            return empty();
        }
        return success(BaseConfigWholeVo.DTO.apply(dto));
    }

    /**
     * 根据参数键名查询参数值
     * @param configKey     键值Key
     * @return 配置对象
     */
    @PlatLog(value = "根据参数键名查询参数值")
    @GetMapping(value = "configwhole/configKey/{configKey}")
    @Encrypt
    public ResponseEntity<BaseConfigWholeVo> getConfigKey(@PathVariable String configKey) {
        if (ObjectUtils.isEmpty(configKey)) {
            return failure();
        }
        BaseConfigWhole entity = baseConfigWholeService.getByKey(configKey);
        if (ObjectUtils.isEmpty(entity)) {
            return empty();
        }
        return success(BaseConfigWholeVo.TO.apply(entity));
    }

    /**
     * 新增参数配置
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:configwhole:save')")
    @PlatLog(value = "新增参数配置", category = 10)
    @PostMapping("configwhole/save")
    @Encrypt
    @LimitScope(name = "baseConfigWholeSave", key = "baseConfigWholeSave")
    public ResponseEntity<String> save(@Validated @RequestBody BaseConfigWholeVo input) {
        if (ObjectUtils.isNotEmpty(baseConfigWholeService.getByKey(input.getConfigKey()))) {
            return error("新增参数'" + input.getConfigKey() + "'失败，参数键名已存在");
        }
        baseConfigWholeService.save(BaseConfigWholeVo.transTo(input));
        return success();
    }

    /**
     * 修改参数配置
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:configwhole:update')")
    @PlatLog(value = "修改参数配置", category = 20)
    @PostMapping("configwhole/update")
    @Encrypt
    @LimitScope(name = "baseConfigWholeUpdate", key = "baseConfigWholeUpdate")
    public ResponseEntity<String> update(@Validated @RequestBody BaseConfigWholeVo input) {
        //        if (ObjectUtils.isNotEmpty(baseConfigWholeService.getByKey(config.getConfigKey())))
        //        {
        //            return error("修改参数'" + config.getConfigName() + "'失败，参数键名已存在");
        //        }
        baseConfigWholeService.update(BaseConfigWholeVo.transTo(input));
        return success();
    }

    /**
     * 删除参数配置
     * @param configIds    配置Ids
     * @return 删除结果
     */
    @PreAuthorize("@ss.hasPerms('system:configwhole:delete')")
    @PlatLog(value = "删除参数配置", category = 40)
    @PostMapping("configwhole/delete/{configIds}")
    @Encrypt
    @LimitScope(name = "baseConfigWholeDelete", key = "baseConfigWholeDelete")
    public ResponseEntity<String> delete(@PathVariable String[] configIds) {
        baseConfigWholeService.deleteByIds(configIds);
        return success();
    }

    /**
     * 刷新参数缓存
     * @return 刷新结果
     */
    @PreAuthorize("@ss.hasPerms('system:configwhole:delete')")
    @PlatLog(value = "刷新参数缓存", category = 21)
    @PostMapping("configwhole/refreshCache")
    @Encrypt
    @LimitScope(name = "baseConfigWholeRefresh", key = "baseConfigWholeRefresh")
    public ResponseEntity<String> refreshCache() {
        initialRedisService.resetConfigCache();
        return success();
    }
}
