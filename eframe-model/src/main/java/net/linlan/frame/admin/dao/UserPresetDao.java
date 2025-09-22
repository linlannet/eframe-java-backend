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
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.admin.dto.UserPresetDto;
import net.linlan.frame.admin.entity.UserPreset;
import net.linlan.frame.admin.param.UserPresetParam;

/**
*
* SasPowerPreset数据域:权限预置信息持久层Dao
* @author Linlan
* CreateTime 2021-09-18 17:42:58
*
*/
@Mapper
public interface UserPresetDao extends MybatisBaseDao<UserPreset> {

    /** get the page of dto SasPowerPresetDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link UserPresetParam }
     * @return 分页的权限预置数据 {@link Page} 对象，包含 {@link UserPreset} 列表
     */
    Page<UserPresetDto> getPageDto(UserPresetParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link UserPresetDto}
     * @param id the SasPowerPreset 预置信息ID | 1
     * @return {@link UserPresetDto}
     */
    UserPresetDto getDtoById(Long id);

    void batchSave(List<UserPreset> list);

    /**
     * 是否有预置的信息
     * @param mobile    手机号码
     * @param positionId    岗位ID
     * @return  返回结果
     */
    UserPreset getPresetByMobileAndPositionId(@Param("mobile") String mobile,
                                              @Param("positionId") String positionId);

    /** 根据手机号和类别、地域ID查询
     * @param mobile    手机号码
     * @param type  类型
     * @param areaId    手机所属地域
     * @return 返回信息
     */
    List<UserPreset> getByMobileAndType(@Param("mobile") String mobile, @Param("type") String type,
                                        @Param("areaId") String areaId);

}
