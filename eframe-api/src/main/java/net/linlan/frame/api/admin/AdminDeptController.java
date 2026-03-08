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

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import jakarta.annotation.Resource;
import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.*;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.commons.script.json.JsonMapUtils;
import net.linlan.frame.admin.dto.AdminDeptDto;
import net.linlan.frame.admin.dto.AdminMenuVo;
import net.linlan.frame.admin.entity.AdminDept;
import net.linlan.frame.admin.param.AdminDeptParam;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.vo.AdminDeptVo;
import net.linlan.utils.LayuiCompUtils;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.constant.UserConstants;
import net.linlan.utils.dto.LayuiTree;
import net.linlan.utils.exception.CommonException;

/**
 *
 * 系统机构部门读写控制类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@RestController
@RequestMapping("api/admin/")
public class AdminDeptController extends BaseController {

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
    public ResponseEntity<Page<AdminDeptVo>> list(AdminDeptParam param) {

        List<AdminDept> result = adminDeptService.getList(JsonMapUtils.beanToMap(param));
        return success(result);

    }

    /**
     * 获取部门分页
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取部门分页")
    @PreAuthorize("@ss.hasPerms('admin:menu:list')")
    @GetMapping("dept/page")
    @Encrypt
    public ResponseEntity<Page<AdminMenuVo>> page(AdminDeptParam param) {
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
    public ResponseEntity<List<AdminDeptVo>> excludeChild(@PathVariable(value = "deptId", required = false) Long deptId) {
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
    public ResponseEntity<AdminDeptVo> getInfo(@PathVariable Long deptId) {
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
    public ResponseEntity<List<LayuiTree>> treeInit(AdminDeptParam params) {
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

    /**
     * 新增部门
     * @param input  保存对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:dept:save')")
    @PlatLog(value = "新增部门管理", category = 10)
    @PostMapping("dept/save")
    @Encrypt
    @LimitScope(name = "adminDeptSave", key = "adminDeptSave")
    public ResponseEntity<String> save(@Validated @RequestBody AdminDept input) {
        if (!adminDeptService.checkDeptNameUnique(input)) {
            return error("新增部门'" + input.getName() + "'失败，部门名称已存在");
        }
        if (input.getParentId() == null) {
            input.setParentId(0L);
        }
        AdminDept info = adminDeptService.findById(input.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if (info != null && info.getDelFlag() != 0) {
            throw new CommonException("部门停用，不允许新增");
        }
        input.setId(RandomUtils.randomLid());
        input.setIsDisabled(false);
        input.setAppId(Constants.ENT_APP_ID);
        if (info != null && StringUtils.isNotBlank(info.getSearchCode())) {
            input.setSearchCode(info.getSearchCode() + "," + input.getParentId());
        } else {
            input.setSearchCode("0");
        }
        input.setCreatorId(getUsername());
        adminDeptService.save(input);
        return returnRow(1);
    }

    /**
     * 修改部门
     * @param input  修改对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:dept:update')")
    @PlatLog(value = "修改部门管理", category = 20)
    @PostMapping("dept/update")
    @Encrypt
    @LimitScope(name = "adminDeptUpdate", key = "adminDeptUpdate")
    public ResponseEntity<String> update(@Validated @RequestBody AdminDept input) {
        Long deptId = input.getId();
        adminDeptService.checkDeptDataScope(deptId);
        if (!adminDeptService.checkDeptNameUnique(input)) {
            return error("修改部门'" + input.getName() + "'失败，部门名称已存在");
        } else if (input.getParentId().equals(deptId)) {
            return error("修改部门'" + input.getName() + "'失败，上级部门不能是自己");
        } else if (StringUtils.equals(UserConstants.DEPT_DISABLE, input.getDelFlag().toString())
                   && adminDeptService.selectNormalChildrenDeptById(deptId) > 0) {
            return error("该部门包含未停用的子部门！");
        }
        adminDeptService.update(input);
        return returnRow(1);
    }

    /**
     * 删除部门
     * @param deptIds  部门Ids
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:dept:delete')")
    @PlatLog(value = "删除部门管理", category = 40)
    @PostMapping("dept/delete/{deptIds}")
    @Encrypt
    @LimitScope(name = "adminDeptDelete", key = "adminDeptDelete")
    public ResponseEntity<String> delete(@PathVariable Long[] deptIds) {
        for (Long deptId : deptIds) {
            if (adminDeptService.hasChildByDeptId(deptId)) {
                return warn("存在下级部门,不允许删除");
            }
            if (adminDeptService.checkDeptExistUser(deptId)) {
                return warn("部门存在用户,不允许删除");
            }
            adminDeptService.checkDeptDataScope(deptId);
            adminDeptService.deleteById(deptId);
        }
        return success();
    }

    /**
     * 停用启用部门
     * @param input  部门对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('admin:dept:update')")
    @PlatLog(value = "停用启用部门管理", category = 20)
    @PostMapping("dept/disable/{id}")
    @Encrypt
    public ResponseEntity<String> disable(@RequestBody AdminDept input) {
        Long deptId = input.getId();
        adminDeptService.checkDeptDataScope(deptId);
        if (adminDeptService.selectNormalChildrenDeptById(deptId) > 0) {
            return error("该部门包含未停用的子部门！");
        }
        adminDeptService.update(input);
        return returnRow(1);
    }

}
