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
package net.linlan.frame.config.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.config.dto.PublicTemplateInfoDto;
import net.linlan.frame.config.entity.PublicTemplateInfo;
import net.linlan.frame.config.param.PublicTemplateInfoParam;

/**
*
* PublicTemplateInfo数据域:模板信息配置持久层Dao
* 
* @author Linlan
* CreateTime 2025-10-15 13:52:44
* @version 1.0
* @since 1.0
*
*/
@Mapper
public interface PublicTemplateInfoDao extends MybatisBaseDao<PublicTemplateInfo> {

    /** get the page of dto PublicTemplateInfoDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param 查询参数
     * @return 分页的模板信息配置数据 {@link Page} 对象，包含 {@link PublicTemplateInfo} 列表
     */
    Page<PublicTemplateInfoDto> getPageDto(PublicTemplateInfoParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link PublicTemplateInfoDto}
     * @param id 模板ID|1
     * @return {@link PublicTemplateInfoDto}
     */
    PublicTemplateInfoDto getDtoById(String id);

    List<PublicTemplateInfoDto> getConfigByAppId(PublicTemplateInfoParam param);

    List<PublicTemplateInfoDto> getConfigByOrganId(PublicTemplateInfoParam param);
}
