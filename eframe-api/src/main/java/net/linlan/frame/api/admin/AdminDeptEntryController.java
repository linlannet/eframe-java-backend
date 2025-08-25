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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import net.linlan.annotation.Encrypt;
import net.linlan.commons.core.ArrayUtils;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.admin.dto.AdminDeptDto;
import net.linlan.frame.admin.entity.AdminDept;
import net.linlan.frame.admin.param.AdminDeptParam;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.vo.AdminDeptVo;
import net.linlan.utils.LayuiCompUtils;
import net.linlan.utils.dto.LayuiTree;

/**
 *
 * AdminDept控制域:系统机构部门查询读取控制类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@RestController
@RequestMapping("api/admin/")
public class AdminDeptEntryController extends BaseController {

    @Resource
    private AdminDeptService adminDeptService;

    /**
     * 获取部门列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取部门列表")
    @PreAuthorize("@ss.hasPerms('admin:dept:list')")
    @GetMapping("dept/list")
    @Encrypt
    public ResponseResult<Page<AdminDeptVo>> list(AdminDeptParam param) {
        Page<AdminDeptDto> result = adminDeptService.getPageDto(param);
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<AdminDeptVo> vos = Lists.transform(result.getResult(), AdminDeptVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 查询部门列表（排除节点）
     * @param deptId  部门ID
     * @return  返回对象
     */
    @PlatLog(value = "查询部门列表（排除节点）")
    @PreAuthorize("@ss.hasPerms('admin:dept:list')")
    @GetMapping("dept/list/exclude/{deptId}")
    @Encrypt
    public ResponseResult<List<AdminDeptVo>> excludeChild(@PathVariable(value = "deptId", required = false) Long deptId) {
        Page<AdminDeptDto> depts = adminDeptService.getPageDto(new AdminDeptParam());
        depts.removeIf(
            d -> d.getId().intValue() == deptId
                 || ArrayUtils.contains(StringUtils.split(d.getSearchCode(), ","), deptId + ""));
        List<AdminDeptVo> vos = Lists.transform(depts.getResult(), AdminDeptVo.DTO);
        return success(vos);
    }

    /**
     * 根据部门编号获取详细信息
     * @param deptId  部门ID
     * @return  返回对象
     */
    @PlatLog(value = "根据部门编号获取详细信息")
    @PreAuthorize("@ss.hasPerms('admin:dept:detail')")
    @GetMapping(value = "dept/{deptId}")
    @Encrypt
    public ResponseResult<AdminDeptVo> getInfo(@PathVariable Long deptId) {
        adminDeptService.checkDeptDataScope(deptId);
        AdminDeptVo vo = null;
        AdminDeptDto dto = adminDeptService.getDtoById(deptId);
        if (dto != null) {
            vo = (AdminDeptVo) AdminDeptVo.DTO.apply(dto);
        }
        return success(vo);
    }

    /**
     * 获取部门树
     * @param params  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取部门树")
    @GetMapping("dept/tree")
    @Encrypt
    public ResponseResult<List<LayuiTree>> treeInit(AdminDeptParam params) {
        params.setLimit(30000);
        Page<AdminDeptDto> page = adminDeptService.getPageDto(params);
        List<LayuiTree> deptTreeList = new ArrayList<>();

        for (AdminDept adminMenu : page.getResult()) {
            LayuiTree tree = new LayuiTree();
            tree.setId(adminMenu.getId().toString());
            if (adminMenu.getParentId() == null) {
                tree.setParentId("0");
            } else {
                tree.setParentId(adminMenu.getParentId().toString());
            }
            tree.setTitle(adminMenu.getName());
            deptTreeList.add(tree);
        }

        deptTreeList = LayuiCompUtils.buildLayuiTree(deptTreeList, "0");

        return success(deptTreeList);
    }
}
