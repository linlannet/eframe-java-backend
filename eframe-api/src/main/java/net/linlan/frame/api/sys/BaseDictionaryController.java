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

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.sys.param.BaseDictionaryTreeParam;
import net.linlan.frame.view.sys.param.BaseDictionaryVoParam;
import net.linlan.frame.view.sys.service.FrameDictionaryService;
import net.linlan.frame.view.sys.vo.BaseDictionaryVo;
import net.linlan.sys.base.dto.BaseDictionaryDto;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.entity.BaseDictionary;
import net.linlan.sys.base.param.BaseDictionaryParam;
import net.linlan.sys.base.param.TreeParam;
import net.linlan.sys.base.service.BaseDictionaryService;

/**
 * 数据字典信息读写
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/system/")
public class BaseDictionaryController extends BaseController {

    @Resource
    private BaseDictionaryService  baseDictionaryService;
    @Resource
    private FrameDictionaryService frameDictionaryService;

    /**
     * 获取数据字典信息列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取数据字典信息列表")
    @PreAuthorize("@ss.hasPerms('system:dictionary:list')")
    @GetMapping("dictionary/list")
    @Encrypt
    public ResponseEntity<Pagination<BaseDictionaryVo>> list(BaseDictionaryVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<BaseDictionaryDto> result = baseDictionaryService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<BaseDictionaryVo> vos = Lists.transform(result.getResult(), BaseDictionaryVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 数据字典导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "数据字典导出", category = 52)
    @PreAuthorize("@ss.hasPerms('system:dictionary:export')")
    @PostMapping("dictionary/export")
    @Encrypt
    public void export(HttpServletResponse response, BaseDictionaryVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<BaseDictionaryDto> result = baseDictionaryService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<BaseDictionaryVo> vos = Lists.transform(result.getResult(), BaseDictionaryVo.DTO);
        ExcelUtil<BaseDictionaryVo> util = new ExcelUtil<>(BaseDictionaryVo.class);
        util.exportExcel(response, vos, "字典类型");
    }

    /**
     * 查询字典数据详细
     * @param dictId    字典ID
     * @return 字典详情
     */
    @PlatLog(value = "查询字典数据详细")
    @PreAuthorize("@ss.hasPerms('system:dictionary:detail')")
    @GetMapping(value = "dictionary/{dictId}")
    @Encrypt
    public ResponseEntity<BaseDictionaryVo> getInfo(@PathVariable Long dictId) {
        if (ObjectUtils.isEmpty(dictId)) {
            return failure();
        }
        BaseDictionaryDto dto = baseDictionaryService.getDtoById(dictId);
        if (ObjectUtils.isEmpty(dto)) {
            return empty();
        }
        return success(BaseDictionaryVo.DTO.apply(dto));
    }

    /**
     * 根据字典类型查询字典数据信息
     * @param dictType  字典分类
     * @param param    查询条件
     * @return 字典分类下全部字典
     */
    @PlatLog(value = "根据字典类型查询字典数据信息")
    @GetMapping(value = "dictionary/type/{dictType}")
    @Encrypt
    public ResponseEntity dictType(@PathVariable String dictType, BaseDictionaryTreeParam param) {
        List<DictionaryInitDto> data = frameDictionaryService.getDict(dictType, param);
        if (ObjectUtils.isEmpty(data)) {
            return empty();
        }
        List<BaseDictionaryVo> vos = Lists.transform(data, BaseDictionaryVo.INITO);
        return success(vos);
    }

    /**
     * 新增字典
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:dictionary:save')")
    @PlatLog(value = "新增字典", category = 10)
    @PostMapping("dictionary/save")
    @Encrypt
    @LimitScope(name = "baseDictionarySave", key = "baseDictionarySave")
    public ResponseEntity<String> save(@Validated @RequestBody BaseDictionaryVo input) {
        baseDictionaryService.save(BaseDictionaryVo.transTo(input));
        return success();
    }

    /**
     * 修改保存字典
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:dictionary:update')")
    @PlatLog(value = "修改保存字典", category = 20)
    @PostMapping("dictionary/update")
    @Encrypt
    @LimitScope(name = "baseDictionaryUpdate", key = "baseDictionaryUpdate")
    public ResponseEntity<String> update(@Validated @RequestBody BaseDictionaryVo input) {
        baseDictionaryService.update(BaseDictionaryVo.transTo(input));
        return success();
    }

    /**
     * 删除字典
     * @param dictIds   字典Ids
     * @return 删除状态
     */
    @PreAuthorize("@ss.hasPerms('system:dictionary:delete')")
    @PlatLog(value = "删除字典", category = 40)
    @PostMapping("dictionary/delete/{dictIds}")
    @Encrypt
    @LimitScope(name = "baseDictionaryDelete", key = "baseDictionaryDelete")
    public ResponseEntity<String> delete(@PathVariable Long[] dictIds) {
        baseDictionaryService.deleteByIds(dictIds);
        return success();
    }

    /**
     * 通用字典树获取接口
     * @param param    查询条件
     * @return 返回结果
     */
    @PlatLog(value = "通用字典树获取接口")
    @GetMapping("/comm/tree")
    @Encrypt
    public ResponseEntity<List<TreeNode>> getTree(TreeParam param) {
        List<TreeNode> result = frameDictionaryService.getTree(param);
        return ResponseEntity.ok().setResultData(result);
    }

    /**
     * 字典树获取
     * @param param    查询条件
     * @return 查询结果
     */
    @PlatLog(value = "字典树获取")
    @GetMapping("/dictionary/tree")
    @Encrypt
    public ResponseEntity<List<BaseDictionary>> getBaseDictionaryTree(BaseDictionaryParam param) {
        List<BaseDictionary> pubLinkageTypeTree = new ArrayList<>();
        List<BaseDictionary> dictionaryList = new ArrayList<>();
        param.setLimit(30000);
        Page<BaseDictionaryDto> page = baseDictionaryService.getPageDto(param);//获取查询数据
        for (BaseDictionaryDto baseDictionaryDto : page) {
            BaseDictionary dictionary = new BaseDictionary();
            BeanUtils.copyProperties(baseDictionaryDto, dictionary);
            dictionaryList.add(dictionary);
        }

        if (ObjectUtils.isNotEmpty(dictionaryList) && dictionaryList.size() > 0) {
            //过滤根节点
            List<BaseDictionary> rootList = getRootList(dictionaryList);
            if (rootList.size() > 0) {
                pubLinkageTypeTree = getPubLinkageTypeTree(rootList, dictionaryList);
            }
        }
        return ResponseEntity.ok().setResultData(pubLinkageTypeTree);
    }

    private List<BaseDictionary> getPubLinkageTypeTree(List<BaseDictionary> parentList,
                                                       List<BaseDictionary> allList) {
        LinkedList<BaseDictionary> temp = new LinkedList<>();
        for (int i = 0; i < parentList.size(); i++) {
            // 通过当前的parentId，查询出list内的全部第一级子节点
            temp = getPubLinkageTypeChildren(parentList.get(i).getId(), allList);
            if (temp != null && temp.size() > 0) {
                parentList.get(i).setChildren(getPubLinkageTypeTree(temp, allList));
            }
            continue;
        }
        return parentList;
    }

    private LinkedList<BaseDictionary> getPubLinkageTypeChildren(Long parentId,
                                                                 List<BaseDictionary> allList) {
        LinkedList<BaseDictionary> temp = new LinkedList<>();
        for (int j = 0; j < allList.size(); j++) {
            Long pid = allList.get(j).getParentId();
            if (pid != null && pid.equals(parentId)) {
                temp.add(allList.get(j));
            }
        }
        return temp;
    }

    public List<BaseDictionary> getRootList(List<BaseDictionary> labelTypeList) {
        List<BaseDictionary> parList = new ArrayList<>();
        for (BaseDictionary item : labelTypeList) {
            if (ObjectUtils.isEmpty(item.getParentId()) || "0".equals(item.getParentId())) {
                parList.add(item);
            }
        }
        return parList;
    }

}
