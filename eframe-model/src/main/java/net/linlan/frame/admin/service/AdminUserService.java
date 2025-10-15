/*
 * eframe-model - model模型数据模块
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
package net.linlan.frame.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.admin.dao.*;
import net.linlan.frame.admin.dto.AdminUserDto;
import net.linlan.frame.admin.dto.AdminUserRoleDto;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.entity.AdminUserPosition;
import net.linlan.frame.admin.entity.AdminUserRole;
import net.linlan.frame.admin.param.AdminUserParam;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.sys.role.entity.SysPosition;
import net.linlan.sys.role.entity.SysRole;
import net.linlan.utils.constant.UserConstants;
import net.linlan.utils.exception.CommonException;

/**
 *
 * AdminUser数据域:管理用户服务类
 * @author Linlan
 * CreateTime 2024-10-02 23:27:08
 *
 */
@Service
@Slf4j
public class AdminUserService {

    @Resource
    private AdminUserDao         dao;

    @Resource
    private AdminRoleVoDao       frameAdminRoleDao;

    @Resource
    private AdminUserRoleDao     adminUserRoleDao;

    @Resource
    private AdminUserPositionDao adminUserPositionDao;

    /** get the list of entity AdminUser
     * 列表方法，返回列表的管理员数据 {@link Page} 对象，包含 {@link AdminUser} 列表
     * @param map the input select conditions
     * @return 列表的管理员数据 {@link Page} 对象，包含 {@link AdminUser} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<AdminUser> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link AdminUser}
     * @param id 企业管理用户ID|1
     * @return {@link AdminUser}
     */
    public AdminUser findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param adminUser the input adminUser
     */
    //@Transactional
    public void save(AdminUser adminUser) {
        adminUser.init();
        dao.save(adminUser);
    }

    /** batch save the entity with input list
     * 保存对象管理用户，批量保存list
     * @param list {@link AdminUser}
     */
    public void batchSave(List<AdminUser> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param adminUser the input adminUser
     */
    //@Transactional
    public void update(AdminUser adminUser) {
        dao.update(adminUser);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 企业管理用户ID|1
     */
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    @Transactional
    public void deleteByIds(Long[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            return;
        }
        dao.deleteByIds(ids);
    }

    @Transactional
    public void deleteByIdsWithRelation(Long[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            return;
        }
        // 删除用户与角色关联
        adminUserRoleDao.deleteByAdminIds(ids);
        // 删除用户与岗位表
        adminUserPositionDao.deleteUserPositionByAdminIds(ids);
        dao.deleteByIds(ids);
    }

    /** query the total count by input select conditions
     * 通过输入的条件查询记录总数
     * @param map the input select conditions
     * @return total count
     */
    public int getCount(Map<String, Object> map) {
        return dao.getCount(map);
    }

    /** get the page of dto AdminUserDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link AdminUserParam }
     * @return 分页的管理员数据 {@link Page} 对象，包含 {@link AdminUser} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<AdminUserDto> getPageDto(AdminUserParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link AdminUserDto}
     * @param id 企业管理用户ID|1
     * @return {@link AdminUserDto}
     */
    public AdminUserDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /**
     * 通过岗位ID查询岗位使用数量
     *
     * @param postId 岗位ID
     * @return 结果
     */
    public int countUserPositionById(String postId) {
        return adminUserPositionDao.countUserPositionById(postId);
    }

    /**
     * 根据用户LID获取岗位选择框列表
     *
     * @param adminId 用户LID
     * @return 选中岗位ID列表
     */
    public List<Long> selectPostListByAdminId(Long adminId) {
        return adminUserPositionDao.selectPostListByAdminId(adminId);
    }

    /**
     * 查询用户所属岗位组
     *
     * @param username 用户名
     * @return 结果
     */
    public List<SysPosition> selectPositionsByUsername(String username) {
        return adminUserPositionDao.selectPositionsByUsername(username);
    }

    /**
     * 根据条件分页查询已分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<AdminUserDto> selectAllocatedList(AdminUserParam user) {
        return dao.selectAllocatedList(user);
    }

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<AdminUserDto> selectUnallocatedList(AdminUserParam user) {
        return dao.selectUnallocatedList(user);
    }

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 用户对象信息
     */
    public AdminUserDto getByUsername(String username) {
        return dao.getByUsername(username);
    }

    /**
     * 通过用户LID查询用户
     *
     * @param adminId 用户LID
     * @return 用户对象信息
     */
    public AdminUserDto getMoreById(Long adminId) {
        return dao.getMoreById(adminId);
    }

    /**
     * 通过用户手机查询用户
     *
     * @param mobile 手机号
     * @return 用户对象信息
     */
    public AdminUserDto getByMobile(String mobile) {
        return dao.getByMobile(mobile);
    }

    /**
     * 查询用户所属角色组
     *
     * @param username 用户名
     * @return 结果
     */
    public String selectUserRoleGroup(String username) {
        List<SysRole> list = frameAdminRoleDao.selectRolesByUsername(username);
        if (CollectionUtils.isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        return list.stream().map(SysRole::getName).collect(Collectors.joining(","));
    }

    /**
     * 查询用户所属岗位组
     *
     * @param username 用户名
     * @return 结果
     */
    public String selectUserPostGroup(String username) {
        List<SysPosition> list = adminUserPositionDao.selectPositionsByUsername(username);
        if (CollectionUtils.isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        return list.stream().map(SysPosition::getName).collect(Collectors.joining(","));
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param username 用户名
     * @param adminId 用户LID
     * @return 结果
     */
    public boolean checkUsernameUnique(String username, Long adminId) {
        Long localId = ObjectUtils.isEmpty(adminId) ? -1L : adminId;
        AdminUser info = dao.checkUsernameUnique(username);
        if (ObjectUtils.isNotEmpty(info) && info.getId().longValue() != localId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验手机号码是否唯一
     *
     * @param mobile 用户手机
     * @param adminId 管理员ID
     * @return    是否满足
     */
    public boolean checkMobileUnique(String mobile, Long adminId) {
        Long localId = ObjectUtils.isEmpty(adminId) ? -1L : adminId;
        AdminUser info = dao.checkMobileUnique(mobile);
        if (ObjectUtils.isNotEmpty(info) && info.getId().longValue() != localId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param email 用户EMAIL
     * @param adminId 管理员ID
     * @return    是否满足
     */
    public boolean checkEmailUnique(String email, Long adminId) {
        Long localId = ObjectUtils.isEmpty(adminId) ? -1L : adminId;
        AdminUser info = dao.checkEmailUnique(email);
        if (ObjectUtils.isNotEmpty(info) && info.getId().longValue() != localId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    public void checkUserAllowed(AdminUser user) {

        if (ObjectUtils.isNotEmpty(user) && user.isAdmin()) {
            throw new CommonException("不允许操作超级管理员用户");
        }
    }

    /**
     * 校验用户是否有数据权限
     *
     * @param adminId 用户LID
     */
    public void checkUserDataScope(Long adminId) {
        String userId = SecurityUtils.getUserId();
        AdminUser adminUser = findByUserId(userId);
        if (adminUser == null) {
            return;
        }
        if (!adminUser.isAdmin()) {
            AdminUser user = findById(adminId);
            if (ObjectUtils.isEmpty(user)) {
                throw new CommonException("没有权限访问用户数据！");
            }
        }
    }

    /**
     * 注册用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public boolean registerUser(AdminUser user) {
        save(user);
        return true;
    }

    /**
     * 用户授权角色
     *
     * @param adminId 用户LID
     * @param roleIds 角色组
     */
    @Transactional
    public void insertUserAuth(Long adminId, Long[] roleIds) {
        adminUserRoleDao.deleteByAdminId(adminId);
        insertUserRole(adminId, roleIds);
    }

    /**
     * 修改用户状态
     *
     * @param adminId 用户LID
     * @param status 状态
     * @return 结果
     */
    public int updateUserStatus(Long adminId, Integer status) {
        return dao.updateUserStatus(adminId, status);
    }

    /**
     * 修改用户基本信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserProfile(AdminUser user) {
        return dao.update(user);
    }

    /**
     * 修改用户头像
     *
     * @param username 用户名
     * @param imagePath 头像地址
     * @return 结果
     */
    public boolean updateUserImagePath(String username, String imagePath) {
        return dao.updateUserImagePath(username, imagePath) > 0;
    }

    /**
     * 重置用户密码
     *
     * @param id 用户ID
     * @param password 密码
     * @return 结果
     */
    public int updateUserPwd(Long id, String password) {
        return dao.updateUserPwd(id, password);
    }

    /**
     * 重置用户密码
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    public int resetUserPwd(String username, String password) {
        return dao.resetUserPwd(username, password);
    }

    /**
     * 新增用户角色信息
     *
     * @param adminId 用户LID
     * @param positionIds 岗位组
     */
    public void insertUserPost(Long adminId, String[] positionIds) {
        if (ObjectUtils.isNotEmpty(positionIds)) {
            // 新增用户与岗位管理
            List<AdminUserPosition> list = new ArrayList<AdminUserPosition>(positionIds.length);
            for (String postId : positionIds) {
                AdminUserPosition up = new AdminUserPosition();
                up.setAdminId(adminId);
                up.setPositionId(postId);
                list.add(up);
            }
            adminUserPositionDao.batchUserPosition(list);
        }
    }

    /**
     * 是否有某个角色
     * @param roleId    角色ID
     * @param adminId    管理员ID
     * @return    是否满足
     */
    public boolean hasRole(Long roleId, Long adminId) {
        List<AdminUserRoleDto> roleIds = adminUserRoleDao.selectUserRoleListByAdminId(adminId);
        if (roleIds == null || roleIds.size() == 0) {
            return false;
        }
        for (AdminUserRoleDto temp : roleIds) {
            if (temp.getRoleId().equals(roleId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 添加角色
     * @param adminId    管理员ID
     * @param roleId    角色ID
     */
    public void insertUserRole(Long adminId, Long roleId) {
        if (!hasRole(roleId, adminId)) {
            AdminUserRole ur = new AdminUserRole();
            ur.setAdminId(adminId);
            ur.setRoleId(roleId);
            adminUserRoleDao.save(ur);
        }
    }

    /**
     * 新增用户角色信息
     *
     * @param adminId 用户LID
     * @param roleIds 角色组
     */
    public void insertUserRole(Long adminId, Long[] roleIds) {
        if (ObjectUtils.isNotEmpty(roleIds)) {
            // 新增用户与角色管理
            List<AdminUserRole> list = new ArrayList<AdminUserRole>(roleIds.length);
            for (Long roleId : roleIds) {
                AdminUserRole ur = new AdminUserRole();
                ur.setAdminId(adminId);
                ur.setRoleId(roleId);
                list.add(ur);
            }
            adminUserRoleDao.batchSave(list);
        }
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link AdminUser}
     * @param id 企业管理用户ID|1
     * @return {@link AdminUser}
     */
    public AdminUser findByUserId(String id) {
        return dao.findByUserId(id);
    }

    /**
     * 通过用户手机查询用户
     *
     * @param email 邮箱地址
     * @return 用户对象信息
     */
    public AdminUserDto getByEmail(String email) {
        return dao.getByEmail(email);
    }

    /** delete the entity by input userId
     * 删除方法，通过id删除对象
     * @param userId 用户ID|1
     */
    public void deleteByUserId(String userId) {
        AdminUser entity = findByUserId(userId);
        if (entity != null) {
            dao.deleteById(entity.getId());
        }
    }

    /** delete the entity by input userId
     * 删除方法，通过id删除对象
     * @param adminId 用户ID|1
     * @param ip ip|192.168.1.1
     * @return 更新状态
     */
    public int updateLoginCount(Long adminId, String ip) {
        return dao.updateLoginCount(adminId, ip);
    }
}
