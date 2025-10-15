/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.admin.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.script.json.StringMap;
import net.linlan.frame.admin.dao.AdminRoleVoDao;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.view.admin.vo.AdminUserVo;
import net.linlan.frame.view.admin.vo.SysPositionVo;
import net.linlan.frame.view.admin.vo.SysRoleVo;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.sys.role.dto.SysPositionDto;
import net.linlan.sys.role.dto.SysRoleDto;
import net.linlan.sys.role.entity.SysPosition;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.sys.role.param.SysPositionParam;
import net.linlan.sys.role.param.SysRoleParam;
import net.linlan.sys.role.service.SysPositionService;
import net.linlan.sys.role.service.SysRoleService;
import net.linlan.utils.constant.UserConstants;
import net.linlan.utils.exception.CommonException;

/**
 *
 * SysPosition视图域:岗位信息查询读取管理类
 * 
 * @author Linlan
 * CreateTime 2023-09-05 10:02:32
 *
 */
@Component
@Slf4j
public class AdminMenuRolePosEntryManager {

    @Resource
    private SysPositionService sysPositionService;
    @Resource
    private SysRoleService     sysRoleService;
    @Resource
    private AdminRoleVoDao     frameAdminRoleDao;
    @Resource
    private AdminUserService   adminUserService;

    /**
     * 查询所有角色
     *
     * @return 角色列表
     */
    public List<SysRoleVo> selectRoleAll() {
        Page<SysRoleDto> result = sysRoleService.getPageDto(new SysRoleParam());
        if (result == null) {
            return null;
        }
        List<SysRoleVo> vos = Lists.transform(result.getResult(), SysRoleVo.DTO);
        return vos;
    }

    /**
     * 根据用户LID查询角色
     *
     * @param adminId 用户LID
     * @return 角色列表
     */
    public List<SysRoleVo> selectRolesByAdminId(Long adminId) {
        List<String> userRoles = frameAdminRoleDao.selectRoleCodeByAdminId(adminId);
        List<SysRoleVo> roles = selectRoleAll();
        for (SysRoleVo role : roles) {
            if (userRoles.contains(role.getRoleKey())) {
                role.setFlag(true);
                break;
            }
        }
        return roles;
    }

    /**
     * 查询所有岗位
     *
     * @return 岗位列表
     */
    public List<SysPositionVo> selectPositionAll() {
        Page<SysPositionDto> result = sysPositionService.getPageDto(new SysPositionParam());
        if (result == null) {
            return null;
        }
        List<SysPositionVo> vos = Lists.transform(result.getResult(), SysPositionVo.DTO);
        return vos;
    }

    /**
     * 校验岗位名称是否唯一
     *
     * @param input 岗位
     * @return 结果
     */
    public boolean checkPostNameUnique(SysPositionDto input) {
        String postId = ObjectUtils.isEmpty(input.getId()) ? "root" : input.getId();
        List<SysPosition> result = sysPositionService
            .getList(new StringMap().put("name", input.getName()).map());
        if (ObjectUtils.isNotEmpty(result) && result.get(0).getId().equals(postId)) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验岗位编码是否唯一
     *
     * @param input 岗位
     * @return 结果
     */
    public boolean checkPostCodeUnique(SysPositionDto input) {
        String postId = ObjectUtils.isEmpty(input.getId()) ? "root" : input.getId();
        List<SysPosition> result = sysPositionService
            .getList(new StringMap().put("code", input.getCode()).map());
        if (ObjectUtils.isNotEmpty(result) && result.get(0).getId().equals(postId)) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验角色名称是否唯一
     *
     * @param input 角色信息
     * @return 结果
     */
    public boolean checkRoleNameUnique(SysRoleVo input) {
        Long roleId = ObjectUtils.isEmpty(input.getRoleId()) ? 0L : input.getRoleId();
        List<SysPosition> result = sysPositionService
            .getList(new StringMap().put("name", input.getRoleName()).map());
        if (ObjectUtils.isNotEmpty(result) && result.get(0).getId().equals(roleId)) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验角色权限是否唯一
     *
     * @param input 角色信息
     * @return 结果
     */
    public boolean checkRoleCodeUnique(SysRoleVo input) {
        Long roleId = ObjectUtils.isEmpty(input.getRoleId()) ? 0L : input.getRoleId();
        List<SysPosition> result = sysPositionService
            .getList(new StringMap().put("code", input.getRoleKey()).map());
        if (ObjectUtils.isNotEmpty(result) && result.get(0).getId().equals(roleId)) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验角色是否有数据权限
     *
     * @param roleIds 角色id
     */
    public void checkRoleDataScope(Long... roleIds) {
        String userId = SecurityUtils.getUserId();
        AdminUser adminUser = adminUserService.findByUserId(userId);
        if (adminUser == null) {
            return;
        }
        if (!AdminUserVo.isAdmin(adminUser.getId())) {
            for (Long roleId : roleIds) {
                SysRole entity = sysRoleService.findById(roleId);
                if (ObjectUtils.isEmpty(entity)) {
                    throw new CommonException("没有权限访问角色数据！");
                }
            }
        }
    }

    /**
     * 获取岗位列表
     *
     * @param param    查询参数
     * @return  查询结果
     */
    public Page<SysPositionDto> getPositionList(SysPositionParam param) {
        String parentId = param.getParentId();
        String regexJslx = "JSLX;.*";
        String regexJs = "JS;.*";
        String regexFgw = "FGW;.*";
        Page<SysPositionDto> positionList = new Page<>();

        if (StringUtils.isBlank(parentId)) {
            positionList = sysPositionService.getPositionList(param);
        }
        String zgwParentId;
        if (parentId.matches(regexJslx)) {
            zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
            param.setParentId(zgwParentId);
            positionList = sysPositionService.getPositionListByRoleType(param);

        }
        if (parentId.matches(regexJs)) {
            zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
            param.setParentId(zgwParentId);
            positionList = sysPositionService.getPositionListByRole(param);

        }
        if (parentId.matches(regexFgw)) {
            zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
            param.setParentId(zgwParentId);
            positionList = sysPositionService.getPositionListByPosition(param);

        }
        return positionList;
    }

}
