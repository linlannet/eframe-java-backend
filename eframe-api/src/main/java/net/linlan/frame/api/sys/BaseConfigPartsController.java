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
import org.springframework.web.bind.annotation.DeleteMapping;
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
import net.linlan.frame.view.sys.param.BaseConfigPartsVoParam;
import net.linlan.frame.view.sys.vo.BaseConfigPartsVo;
import net.linlan.sys.base.dto.BaseConfigPartsDto;
import net.linlan.sys.base.service.BaseConfigPartsService;

/**
 * 键值配置信息操作处理
 *
 * @author Linlan
 */
@RestController
@RequestMapping("/api/system/")
public class BaseConfigPartsController extends BaseController {

    @Resource
    private BaseConfigPartsService baseConfigPartsService;
    @Resource
    private InitialRedisService    initialRedisService;

    /**
     * 获取键值配置列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取键值配置列表")
    @PreAuthorize("@ss.hasPerms('system:configparts:list')")
    @GetMapping("parts/list")
    @Encrypt
    public ResponseEntity<Pagination<BaseConfigPartsVo>> list(BaseConfigPartsVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<BaseConfigPartsDto> result = baseConfigPartsService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<BaseConfigPartsVo> vos = Lists.transform(result.getResult(), BaseConfigPartsVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 键值配置导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "键值配置导出", category = 52)
    @PreAuthorize("@ss.hasPerms('system:configparts:export')")
    @PostMapping("parts/export")
    @Encrypt
    public void export(HttpServletResponse response, BaseConfigPartsVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<BaseConfigPartsDto> result = baseConfigPartsService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<BaseConfigPartsVo> vos = Lists.transform(result.getResult(), BaseConfigPartsVo.DTO);
        ExcelUtil<BaseConfigPartsVo> util = new ExcelUtil<>(BaseConfigPartsVo.class);
        util.exportExcel(response, vos, "参数数据");
    }

    /**
     * 根据参数编号获取详细信息
     * @param cfgKey    配置KEY
     * @return 键值对象
     */
    @PlatLog(value = "根据参数编号获取详细信息")
    @PreAuthorize("@ss.hasPerms('system:configparts:detail')")
    @GetMapping(value = "parts/{cfgKey}")
    @Encrypt
    public ResponseEntity<BaseConfigPartsVo> getInfo(@PathVariable String cfgKey) {
        if (ObjectUtils.isEmpty(cfgKey)) {
            return failure();
        }
        BaseConfigPartsDto dto = baseConfigPartsService.getDtoById(cfgKey);
        if (ObjectUtils.isEmpty(dto)) {
            return empty();
        }
        return success(BaseConfigPartsVo.DTO.apply(dto));
    }

    /**
     * 新增参数配置
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:configparts:save')")
    @PlatLog(value = "新增参数配置", category = 10)
    @PostMapping("parts/save")
    @Encrypt
    @LimitScope(name = "baseConfigPartsSave", key = "baseConfigPartsSave")
    public ResponseEntity<String> save(@Validated @RequestBody BaseConfigPartsVo input) {
        if (ObjectUtils.isNotEmpty(baseConfigPartsService.findById(input.getCfgValue()))) {
            return error("新增键值'" + input.getCfgKey() + "'失败，参数键名已存在");
        }
        baseConfigPartsService.save(BaseConfigPartsVo.transTo(input));
        return success();
    }

    /**
     * 修改参数配置
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:configparts:update')")
    @PlatLog(value = "修改参数配置", category = 20)
    @PostMapping("parts/update")
    @Encrypt
    @LimitScope(name = "baseConfigPartsUpdate", key = "baseConfigPartsUpdate")
    public ResponseEntity<String> update(@Validated @RequestBody BaseConfigPartsVo input) {
        //        if (ObjectUtils.isNotEmpty(baseConfigPartsService.findById(config.getId())))
        //        {
        //            return error("修改参数'" + config.getId() + "'失败，参数键名已存在");
        //        }
        baseConfigPartsService.update(BaseConfigPartsVo.transTo(input));
        return success();
    }

    /**
     * 删除参数配置
     * @param cfgKeys  配置Keys
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:configparts:delete')")
    @PlatLog(value = "删除参数配置", category = 40)
    @PostMapping("parts/delete/{cfgKeys}")
    @Encrypt
    @LimitScope(name = "baseConfigPartsDelete", key = "baseConfigPartsDelete")
    public ResponseEntity<String> delete(@PathVariable String[] cfgKeys) {
        baseConfigPartsService.deleteByIds(cfgKeys);
        return success();
    }

    /**
     * 刷新参数缓存
     * @return 刷新结果
     */
    @PreAuthorize("@ss.hasPerms('system:configparts:delete')")
    @PlatLog(value = "刷新参数缓存", category = 21)
    @DeleteMapping("config/refreshCache")
    @Encrypt
    @LimitScope(name = "baseConfigPartsRefresh", key = "baseConfigPartsRefresh")
    public ResponseEntity<String> refreshCache() {
        initialRedisService.resetConfigCache();
        return success();
    }
}
