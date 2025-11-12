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

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.admin.dao.AdminDeptRoleDao;
import net.linlan.frame.admin.dao.AdminUserRoleDao;
import net.linlan.frame.admin.entity.AdminDeptRole;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.view.admin.vo.SysRoleVo;
import net.linlan.sys.role.dto.SysPositionDto;
import net.linlan.sys.role.dto.SysRoleMenuDto;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.sys.role.entity.SysRolePosition;
import net.linlan.sys.role.service.SysPositionService;
import net.linlan.sys.role.service.SysRoleService;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.exception.CommonException;

/**
 *
 * SysPosition视图域:岗位信息增删改操作管理类
 * 
 * @author Linlan
 * CreateTime 2023-09-05 10:02:32
 *
 */
@Component
@Slf4j
public class AdminMenuRolePosOpManager {

    @Resource
    private SysPositionService sysPositionService;
    @Resource
    private SysRoleService     sysRoleService;
    @Resource
    private AdminUserService   adminUserService;
    @Resource
    private AdminUserRoleDao   adminUserRoleDao;

    @Resource
    private AdminDeptRoleDao   adminDeptRoleDao;

    /**
     * 岗位操作（新增，修改，删除，）
     * @param id    主键ID
     * @param actionType    操作类型
     * @param dto    dto对象
     * @return  操作结果
     * @throws CommonException  异常
     */
    @Transactional
    public boolean doSysPositionOp(String actionType, String id, SysPositionDto dto) {
        if (StringUtils.isNotBlank(actionType)) {
            if (ApiIntfConfig.VALUE_AT_ADD.equals(actionType)) {//新增
                String parentId = dto.getParentId();
                String regexJslx = "JSLX;.*";
                String regexJs = "JS;.*";
                String regexFgw = "FGW;.*";
                dto.init();
                dto.setCreateTime(new Date());
                String zgwParentId;
                if (parentId.matches(regexJslx)) {
                    zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
                    return false;
                }
                if (parentId.matches(regexJs)) {
                    dto.setParentId(null);
                    zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
                    SysRolePosition adminRolePosition = new SysRolePosition();
                    adminRolePosition.init();
                    adminRolePosition.setPositionId(dto.getId());
                    adminRolePosition.setRoleId(Long.valueOf(zgwParentId));
                    adminRolePosition.setStatus(1);
                    adminRolePosition.setBeginTime(new Date());
                    sysPositionService.saveRolePosition(adminRolePosition);
                }
                if (parentId.matches(regexFgw)) {
                    zgwParentId = parentId.substring(parentId.indexOf(";") + 1);
                    dto.setParentId(zgwParentId);
                }
                if (parentId.equals("")) {
                    dto.setParentId(null);
                }
                sysPositionService.save(dto);
                return true;
            } else if (ApiIntfConfig.VALUE_AT_UPDATE.equals(actionType)) {//修改——重新申请
                if (StringUtils.isNotBlank(id)) {
                    dto.setId(id);
                    sysPositionService.update(dto);
                }
                return true;
            } else if (ApiIntfConfig.VALUE_AT_DELETE.equals(actionType)) {
                //删除业务，可传递多个id
                String[] ids = id.split(StringUtils.COMMA);
                sysPositionService.deleteByIds(ids);
                sysPositionService.deleteByPositionIds(ids);
                return true;
            }
        }
        return false;
    }

    /**
     * 岗位绑定角色操作
     * @param idStr     拼接的Ids
     * @param actionType    操作类型
     * @param dto    dto对象
     * @return 绑定状态
     */
    @Transactional
    public boolean doBindPosition(String actionType, String idStr, SysRolePosition dto) {
        if (StringUtils.isNotBlank(actionType)) {
            if (ApiIntfConfig.VALUE_AT_BIND.equals(actionType)) {//绑定
                //删除原本绑定的角色
                sysPositionService.deleteByPositionId(dto.getPositionId());
                List<SysRolePosition> list = new ArrayList<SysRolePosition>();
                String[] ids = idStr.split(StringUtils.COMMA);
                for (String id : ids) {
                    if (StringUtils.isBlank(id)) {
                        continue;
                    }
                    SysRolePosition adminRolePosition = new SysRolePosition();
                    adminRolePosition.setPositionId(dto.getPositionId());
                    adminRolePosition.init();
                    adminRolePosition.setRoleId(Long.valueOf(id.substring(id.indexOf(";") + 1)));
                    adminRolePosition.setStatus(1);
                    adminRolePosition.setBeginTime(new Date());
                    list.add(adminRolePosition);
                }
                if (list.size() > 0) {
                    sysPositionService.batchSaveRolePosition(list);
                }
                return true;
            } else if (ApiIntfConfig.VALUE_AT_UNBIND.equals(actionType)) {
                if (dto.getPositionId() != null) {
                    sysPositionService.deleteByPositionId(dto.getPositionId());
                }
                return true;
            }
        }
        return false;
    }

    /** 执行AdminRole对象Op操作，进行增加、删除、修改业务
     * @param action 操作类型:10,新增;20,修改;40,删除|20
     * @param id 单位ID:null,1;1,2,3|1
     * @param input 输入对象信息
     * @return {@link Boolean}:true,success;false,failure
     */
    public boolean doAdminRoleOp(String action, String id, SysRoleVo input) {
        if (StringUtils.isBlank(action)) {
            return false;
        }
        if (StringUtils.isNotBlank(action)) {
            if (action.equals(ApiIntfConfig.VALUE_AT_ADD)) {
                if (ObjectUtils.isEmpty(input)) {
                    return false;
                }
                //保存SysRole
                SysRole Position = new SysRole();
                if (ObjectUtils.isNotEmpty(input.getRoleId())) {
                    Position.setId(input.getRoleId());
                }
                Position.setName(input.getRoleName());
                Position.setAppId(Constants.ENT_APP_ID);
                Position.setCode(input.getRoleKey());
                Position.setStatus(input.getStatus());
                Position.setPriority(input.getRoleSort());
                Position.setCreatorId(input.getCreatorId());
                Position.setCreateTime(new Date());
                Position.setLastTime(new Timestamp(System.currentTimeMillis()));
                Position.setPriority(input.getRoleSort());
                Position.setRoletypeId(input.getRoletypeId());
                Position.setIsPublic(input.getDeptCheckStrictly());
                Position.setIsRegular(input.getMenuCheckStrictly());
                Position.setIsSuper(input.getIsSuper());
                Position.setDescription(input.getRemark());
                sysRoleService.save(Position);
                insertRoleMenu(input);
                return true;
            } else if (action.equals(ApiIntfConfig.VALUE_AT_UPDATE)) {
                if (ObjectUtils.isEmpty(id) || ObjectUtils.isEmpty(input)) {
                    return false;
                }
                SysRole adminRole = sysRoleService.findById(Long.valueOf(id));
                if (adminRole != null) {
                    //部分字段需要单独更新的，此处请删除，如密码、创建时间等，如有关联更新请添加关联方法
                    adminRole.setAppId(Constants.ENT_APP_ID);
                    adminRole.setName(input.getRoleName());
                    adminRole.setCode(input.getRoleKey());
                    adminRole.setStatus(input.getStatus());
                    adminRole.setPriority(input.getRoleSort());
                    adminRole.setCreatorId(input.getCreatorId());
                    adminRole.setCreateTime(new Date());
                    adminRole.setLastTime(new Timestamp(System.currentTimeMillis()));
                    adminRole.setPriority(input.getRoleSort());
                    adminRole.setRoletypeId(input.getRoletypeId());
                    adminRole.setIsPublic(input.getDeptCheckStrictly());
                    adminRole.setIsRegular(input.getMenuCheckStrictly());
                    adminRole.setIsSuper(input.getIsSuper());
                    adminRole.setDescription(input.getRemark());
                    sysRoleService.update(adminRole);
                    // 删除角色与菜单关联
                    if (ObjectUtils.isNotEmpty(input.getMenuIds())) {
                        sysRoleService.deleteMenuById(input.getRoleId());
                    }
                    insertRoleMenu(input);
                    return true;
                }
            } else if (action.equals(ApiIntfConfig.VALUE_AT_DELETE)) {
                if (ObjectUtils.isEmpty(id)) {
                    return false;
                }
                //删除业务，可传递多个id
                String[] ids = id.split(StringUtils.COMMA);
                for (String pkId : ids) {
                    if (isValidRoleDeleteSuccess(pkId)) {
                        // 删除角色与菜单关联
                        sysRoleService.deleteMenuById(Long.valueOf(pkId));
                        // 删除角色与部门关联
                        adminDeptRoleDao.deleteByRoleIds(new Long[] { Long.valueOf(pkId) });
                        sysRoleService.deleteById(Long.valueOf(pkId));
                    }
                }
                return true;
            } else if (ApiIntfConfig.VALUE_AT_BIND.equals(action)) { //53绑定菜单
                Long roleId = input.getRoleId();
                Long[] menuIds = input.getMenuIds();
                if (roleId != null) {
                    if (menuIds == null || menuIds.length == 0) {
                        sysRoleService.deleteMenuById(roleId);
                    } else {
                        List<Long> menuIdList = new ArrayList<>();
                        menuIdList.addAll(Arrays.asList(menuIds));
                        sysRoleService.saveOrUpdateMenu(roleId, menuIdList);
                    }
                }
                return true;
            } else if (ApiIntfConfig.VALUE_AT_OTHER.equals(action)) { //50绑定部门
                Long roleId = input.getRoleId();
                Long[] menuIds = input.getDeptIds();
                if (roleId != null) {
                    if (menuIds == null || menuIds.length == 0) {
                        adminDeptRoleDao.deleteByRoleId(roleId);
                    } else {
                        insertRoleDept(input);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean isValidPositionDeleteSuccess(Serializable id) {
        if (adminUserService.countUserPositionById((String) id) > 0) {
            throw new CommonException(String.format("岗位已分配,不能删除"));
        }
        return true;
    }

    public boolean isValidRoleDeleteSuccess(Serializable id) {
        if (adminUserRoleDao.countByRoleId((Long) id) > 0) {
            throw new CommonException(String.format("角色已分配,不能删除"));
        }

        return true;
    }

    /**
     * 新增角色菜单信息
     *
     * @param role 角色对象
     * @return 插入状态
     */
    public int insertRoleMenu(SysRoleVo role) {
        int rows = 1;
        // 新增用户与角色管理
        List<SysRoleMenuDto> list = new ArrayList<>();
        if (ObjectUtils.isNotEmpty(role.getMenuIds())) {
            for (Long menuId : role.getMenuIds()) {
                SysRoleMenuDto PositionMenuDto = new SysRoleMenuDto();
                PositionMenuDto.setMenuroleId(RandomUtils.randomLid());
                PositionMenuDto.setRoleId(role.getRoleId());
                PositionMenuDto.setMenuId(menuId);
                list.add(PositionMenuDto);
            }
            if (list.size() > 0) {
                sysRoleService.sysRoleMenuBatchInsert(list);
            }
        }

        return rows;
    }

    /**
     * 新增角色部门信息(数据权限)
     *
     * @param role 角色对象
     * @return 插入状态
     */
    public int insertRoleDept(SysRoleVo role) {
        int rows = 1;
        // 新增角色与部门（数据权限）管理
        List<AdminDeptRole> list = new ArrayList<>();
        if (ObjectUtils.isNotEmpty(role.getDeptIds())) {
            for (Long deptId : role.getDeptIds()) {
                AdminDeptRole rd = new AdminDeptRole();
                rd.setRoleId(role.getRoleId());
                rd.setDeptId(deptId);
                list.add(rd);
            }
            if (list.size() > 0) {
                rows = adminDeptRoleDao.batchSaveDeptRole(list);
            }
        }

        return rows;
    }

}
