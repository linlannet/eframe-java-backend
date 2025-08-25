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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.db.page.Pagination;
import net.linlan.commons.script.json.StringMap;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.service.InitialRedisService;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.sys.param.BaseDicTypeVoParam;
import net.linlan.frame.view.sys.service.FrameDictionaryService;
import net.linlan.frame.view.sys.vo.BaseDicTypeVo;
import net.linlan.sys.base.dto.BaseDicTypeDto;
import net.linlan.sys.base.param.BaseDicTypeParam;
import net.linlan.sys.base.service.BaseDicTypeService;

/**
 * 字典类型信息
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/system/")
public class BaseDicTypeController extends BaseController {
    @Resource
    private InitialRedisService   initialRedisService;
    @Resource
    private BaseDicTypeService    baseDicTypeService;
    @Resource
    public FrameDictionaryService frameDictionaryService;

    /**
     * 获取字典类型列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取字典类型列表")
    @PreAuthorize("@ss.hasPerms('system:dictype:list')")
    @GetMapping("dictype/list")
    @Encrypt
    public ResponseResult<Pagination<BaseDicTypeVo>> list(BaseDicTypeVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<BaseDicTypeDto> result = baseDicTypeService.getPageDto(param.toModelParam());
        Map<String, String> translate = new HashMap<>();
        translate.put("typeClass", "DIC_TYPE");
        frameDictionaryService.translate(result, translate);
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<BaseDicTypeVo> vos = Lists.transform(result.getResult(), BaseDicTypeVo.DTO);
        return successPage(vos, result.getPageNum(), result.getPageNum(), result.getTotal());
    }

    /**
     * 字典类型导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "字典类型导出", category = 52)
    @PreAuthorize("@ss.hasPerms('system:dictype:export')")
    @PostMapping("dictype/export")
    @Encrypt
    public void export(HttpServletResponse response, BaseDicTypeVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<BaseDicTypeDto> result = baseDicTypeService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<BaseDicTypeVo> vos = Lists.transform(result.getResult(), BaseDicTypeVo.DTO);
        ExcelUtil<BaseDicTypeVo> util = new ExcelUtil<>(BaseDicTypeVo.class);
        util.exportExcel(response, vos, "字典类型");
    }

    /**
     * 查询字典类型详细
     * @param dictId    字典分类ID
     * @return 字典分类信息
     */
    @PlatLog(value = "查询字典类型详细")
    @PreAuthorize("@ss.hasPerms('system:dictype:detail')")
    @GetMapping(value = "dictype/{dictId}")
    @Encrypt
    public ResponseResult<BaseDicTypeVo> getInfo(@PathVariable String dictId) {
        if (ObjectUtils.isEmpty(dictId)) {
            return failure();
        }
        BaseDicTypeDto dto = baseDicTypeService.getDtoById(dictId);
        if (ObjectUtils.isEmpty(dto)) {
            return empty();
        }
        return success(BaseDicTypeVo.DTO.apply(dto));
    }

    /**
     * 新增字典类型
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:dictype:save')")
    @PlatLog(value = "新增字典类型", category = 10)
    @PostMapping("dictype/save")
    @Encrypt
    @LimitScope(name = "baseDicTypeSave", key = "baseDicTypeSave")
    public ResponseResult<String> save(@Validated @RequestBody BaseDicTypeVo input) {
        if (ObjectUtils.isNotEmpty(
            baseDicTypeService.getList(new StringMap().put("typeId", input.getTypeId()).map()))) {
            return error("新增字典'" + input.getTypeId() + "'失败，字典类型已存在");
        }
        baseDicTypeService.save(BaseDicTypeVo.transTo(input));
        return success();
    }

    /**
     * 修改字典类型
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:dictype:update')")
    @PlatLog(value = "修改字典类型", category = 20)
    @PostMapping("dictype/update")
    @Encrypt
    @LimitScope(name = "baseDicTypeUpdate", key = "baseDicTypeUpdate")
    public ResponseResult<String> update(@Validated @RequestBody BaseDicTypeVo input) {
        baseDicTypeService.update(BaseDicTypeVo.transTo(input));
        return success();
    }

    /**
     * 删除字典类型
     * @param dictIds    字典分类Ids
     * @return 操作状态
     */
    @PreAuthorize("@ss.hasPerms('system:dictype:delete')")
    @PlatLog(value = "删除字典类型", category = 40)
    @PostMapping("dictype/delete/{dictIds}")
    @Encrypt
    @LimitScope(name = "baseDicTypeDelete", key = "baseDicTypeDelete")
    public ResponseResult<String> delete(@PathVariable String[] dictIds) {
        baseDicTypeService.deleteByIds(dictIds);
        return success();
    }

    /**
     * 刷新字典类型缓存
     * @return 刷新结果
     */
    @PreAuthorize("@ss.hasPerms('system:dictype:delete')")
    @PlatLog(value = "刷新字典类型缓存", category = 21)
    @DeleteMapping("dictype/refreshCache")
    @Encrypt
    @LimitScope(name = "baseDicTypeRefresh", key = "baseDicTypeRefresh")
    public ResponseResult<String> refreshCache() {
        initialRedisService.resetDictCache();
        return success();
    }

    /**
     * 获取字典选择框列表
     * @return 字典选择框列表
     */
    @PlatLog(value = "获取字典选择框列表")
    @GetMapping("dictype/option/select")
    @Encrypt
    public ResponseResult<List<BaseDicTypeVo>> optionSelect() {
        Page<BaseDicTypeDto> result = baseDicTypeService.getPageDto(new BaseDicTypeParam());
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<BaseDicTypeVo> vos = Lists.transform(result.getResult(), BaseDicTypeVo.DTO);
        return success(vos);
    }
}
