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
package net.linlan.sys.comm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.sys.comm.dto.AttachInitInfo;
import net.linlan.sys.comm.dto.CommAttachDto;
import net.linlan.sys.comm.entity.CommAttach;
import net.linlan.sys.comm.param.CommAttachParam;

/**
*
* CommAttach数据域:应用基础通用附件持久层Dao
* @author Linlan
* CreateTime 2021-05-07 16:25:50
*
*/
@Mapper
public interface CommAttachDao extends MybatisBaseDao<CommAttach> {

    /** get the page of dto CommAttachDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CommAttachParam }
     * @return 分页的通用附件数据 {@link Page} 对象，包含 {@link CommAttach} 列表
     */
    Page<CommAttachDto> getPageDto(CommAttachParam param);

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CommAttachDto}
     * @param id the CommAttach 附件ID | 1
     * @return {@link CommAttachDto}
     */
    CommAttachDto getDtoById(Long id);

    List<CommAttach> getByResType(@Param("businessId") String businessId,
                                  @Param("restypeId") String restypeId,
                                  @Param("attachType") String attachType);

    /**
     * 修改绑定
     * @param newBusinessId     新业务ID
     * @param oldBusinessId     旧业务ID
     */
    void changeBind(@Param("newBusinessId") String newBusinessId,
                    @Param("oldBusinessId") String oldBusinessId);

    /**
     * 删除文件
     * @param businessId 业务ID
     * @param restypeId 资源分类ID
     * @param attachType    附件类型
     */
    void deleteByResType(@Param("businessId") String businessId,
                         @Param("restypeId") String restypeId,
                         @Param("attachType") String attachType);

    List<CommAttach> getByForeignId(@Param("foreignId") String foreignId);

    int batchUpdateByForeignId(Object[] attachments, String foreignId);

    int deleteByForeignId(@Param("foreignId") String foreignId);

    List<CommAttach> getAttachList(@Param("foreignId") String foreignId,
                                   @Param("resTypeId") String resTypeId);

    List<CommAttach> getByForeignIdAndFlowId(@Param("foreignId") String foreignId,
                                             @Param("flowId") String flowId);

    void batchSaveByInit(List<AttachInitInfo> attaches);

}
