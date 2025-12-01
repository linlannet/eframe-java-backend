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
package net.linlan.sys.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.base.dto.BaseUserExtDto;
import net.linlan.sys.base.entity.BaseUserExt;
import net.linlan.sys.base.param.BaseUserExtParam;

/**
*
* BaseUserExt数据域:基础用户扩展信息持久层Dao
*
* @author Linlan
 * CreateTime 2018-03-08 13:41:37
* @version 1.0
* @since 1.0
*
*/
@Mapper
public interface BaseUserExtDao extends MybatisBaseDao<BaseUserExt> {

    /** get the page of dto BaseUserExtDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseUserExtParam }
     * @return 分页的基础机构数据 {@link Page} 对象，包含 {@link BaseUserExtDto} 列表
     */
    Page<BaseUserExtDto> getPageDto(BaseUserExtParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseUserExtDto}
     * @param id 用户ID|1
     * @return {@link BaseUserExtDto}
     */
    BaseUserExtDto getDtoById(String id);

    /** 通过身份证号码的中间位数查询用户年龄段
     * @param map
     * @return    返回列表
     */
    List<Map<String, Object>> getUserAgeList(Map<String, Object> map);

    /** 修改用户登录密码
     * @param map   参数
     * @return  更新密码状态
     */
    int updatePassword(Map<String, Object> map);

    /**
     * 批量更新用户密码
     * @param userIds   用户IDs
     * @param password  密码
     * @return  更新状态
     */
    int batUpdatePassword(@Param("userIds") String[] userIds, @Param("password") String password);

    int updateSensitiveInfo(BaseUserExt baseUserExt);

}
