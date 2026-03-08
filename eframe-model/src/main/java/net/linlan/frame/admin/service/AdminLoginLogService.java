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

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.frame.admin.dao.AdminLoginLogDao;
import net.linlan.frame.admin.dto.AdminLoginLogDto;
import net.linlan.frame.admin.entity.AdminLoginLog;
import net.linlan.frame.admin.param.AdminLoginLogParam;

/**
 *
 * AdminLoginLog数据域:管理员登录日志服务类
 * @author Linlan
 * CreateTime 2024-10-07 20:45:06
 *
 */
@Service
@Slf4j
public class AdminLoginLogService {

    @Resource
    private AdminLoginLogDao dao;

    /** get the list of entity AdminLoginLog
     * 列表方法，返回分页的管理员登录数据 {@link Page} 对象，包含 {@link AdminLoginLog} 列表
     * @param map the input select conditions
     * @return 分页的管理员登录数据 {@link Page} 对象，包含 {@link AdminLoginLog} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<AdminLoginLog> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link AdminLoginLog}
     * @param id 登录ID|1
     * @return {@link AdminLoginLog}
     */
    public AdminLoginLog findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param adminLoginLog the input adminLoginLog
     */
    //@Transactional
    public void save(AdminLoginLog adminLoginLog) {
        adminLoginLog.init();
        dao.save(adminLoginLog);
    }

    /** batch save the entity with input list
     * 保存对象管理员登录日志，批量保存list
     * @param list {@link AdminLoginLog}
     */
    public void batchSave(List<AdminLoginLog> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param adminLoginLog the input adminLoginLog
     */
    //@Transactional
    public void update(AdminLoginLog adminLoginLog) {
        dao.update(adminLoginLog);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 登录ID|1
     */
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    //@Transactional
    public void deleteByIds(Long[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            return;
        }
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

    /** get the page of dto AdminLoginLogDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link AdminLoginLogParam }
     * @return 分页的管理员登录数据 {@link Page} 对象，包含 {@link AdminLoginLog} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<AdminLoginLogDto> getPageDto(AdminLoginLogParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link AdminLoginLogDto}
     * @param id 登录ID|1
     * @return {@link AdminLoginLogDto}
     */
    public AdminLoginLogDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

}
