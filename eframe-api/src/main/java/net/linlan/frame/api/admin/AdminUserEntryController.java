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
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import net.linlan.annotation.Encrypt;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.frame.admin.dao.AdminUserRoleDao;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.dto.AdminUserRoleDto;
import net.linlan.frame.admin.param.AdminDeptParam;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.manager.AdminMenuRolePosEntryManager;
import net.linlan.frame.view.admin.param.AdminUserVoParam;
import net.linlan.frame.view.admin.vo.AdminUserVo;
import net.linlan.frame.view.admin.vo.LoginUserRolesPosVo;
import net.linlan.frame.view.admin.vo.SysPositionVo;
import net.linlan.frame.view.admin.vo.SysRoleVo;
import net.linlan.frame.web.model.TreeSelect;
import net.linlan.sys.role.entity.SysRole;

/**
 *
 * AdminUser控制域:管理用户查询读取控制类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@RestController
@RequestMapping("api/admin/")
public class AdminUserEntryController extends BaseController {

    @Resource
    private AdminMenuRolePosEntryManager PositionEntryManager;
    @Resource
    private AdminUserService             adminUserService;
    @Resource
    private AdminDeptService             adminDeptService;
    @Resource
    private AdminUserRoleDao             adminUserRoleDao;

    /**
     * 获取用户列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取用户列表")
    @PreAuthorize("@ss.hasPerms('admin:user:list')")
    @GetMapping("user/list")
    @Encrypt
    public ResponseResult<List<AdminUserVo>> list(AdminUserVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<AdminUserDto> adminUserDtoList = adminUserService.getPageDto(param.toModelParam());
        if (adminUserDtoList == null) {
            return empty();
        }
        List<AdminUserVo> vos = Lists.transform(adminUserDtoList.getResult(), AdminUserVo.DTO);
        return successPage(vos, adminUserDtoList.getPageSize(), adminUserDtoList.getPageNum(),
            adminUserDtoList.getTotal());
    }

    /**
     * 根据用户编号获取详细信息
     * @param adminId  管理员ID
     * @return  返回对象
     */
    @PlatLog(value = "根据用户编号获取详细信息")
    @PreAuthorize("@ss.hasPerms('admin:user:detail')")
    @GetMapping(value = { "user/", "user/{adminId}" })
    @Encrypt
    public ResponseResult<LoginUserRolesPosVo> getInfo(@PathVariable(value = "adminId", required = false) Long adminId) {
        LoginUserRolesPosVo loginUserRolesPosVo = new LoginUserRolesPosVo();
        if (ObjectUtils.isNotEmpty(adminId)) {
            adminUserService.checkUserDataScope(adminId);
            AdminUserDto dto = adminUserService.selectAdminById(adminId);
            AdminUserVo vo = null;
            if (ObjectUtils.isNotEmpty(dto)) {
                vo = (AdminUserVo) AdminUserVo.DTO.apply(dto);
            }
            loginUserRolesPosVo.setUser(vo);
            loginUserRolesPosVo.setPositionIds(adminUserService.selectPostListByAdminId(adminId));
            if (vo != null && vo.getRoles() != null) {
                loginUserRolesPosVo.setRoleIds(
                    vo.getRoles().stream().map(SysRole::getId).collect(Collectors.toList()));
            }
        }
        List<SysRoleVo> roles = PositionEntryManager.selectRoleAll();
        loginUserRolesPosVo.setRoles(AdminUserVo.isAdmin(adminId) ? roles
            : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        List<SysPositionVo> positions = PositionEntryManager.selectPositionAll();
        loginUserRolesPosVo.setPositions(positions);
        List<AdminUserRoleDto> roleDtoList = adminUserRoleDao.selectUserRoleListByAdminId(adminId);
        loginUserRolesPosVo.setRoleList(roleDtoList);
        return success(loginUserRolesPosVo);
    }

    /**
     * 获取用户部门树列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取用户部门树列表")
    @PreAuthorize("@ss.hasPerms('admin:user:list')")
    @GetMapping("user/deptTree")
    @Encrypt
    public ResponseResult<List<TreeSelect>> deptTree(AdminDeptParam param) {
        return success(adminDeptService.selectDeptTreeList(param));
    }

}
