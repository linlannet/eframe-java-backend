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
package net.linlan.frame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.admin.entity.AdminUserPosition;
import net.linlan.sys.role.entity.SysPosition;

/**
*
* AdminUserPosition数据域:用户岗位关联持久层Dao
* @author Linlan
* CreateTime 2024-10-02 23:27:08
*
*/
@Mapper
public interface AdminUserPositionDao extends MybatisBaseDao<AdminUserPosition> {

    /**
     * 通过用户LID删除用户和岗位关联
     *
     * @param adminId 用户LID
     * @return 结果
     */
    public int deleteUserPositionByAdminId(Long adminId);

    /**
     * 通过岗位ID查询岗位使用数量
     *
     * @param postId 岗位ID
     * @return 结果
     */
    public int countUserPositionById(String postId);

    /**
     * 批量删除用户和岗位关联
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserPositionByAdminIds(Long[] ids);

    /**
     * 批量新增用户岗位信息
     *
     * @param userPostList 用户岗位列表
     * @return 结果
     */
    public int batchUserPosition(List<AdminUserPosition> userPostList);

    List<Long> selectPostListByAdminId(Long adminId);

    /**
     * 查询用户所属岗位组
     *
     * @param username 用户名
     * @return 结果
     */
    public List<SysPosition> selectPositionsByUsername(String username);

}
