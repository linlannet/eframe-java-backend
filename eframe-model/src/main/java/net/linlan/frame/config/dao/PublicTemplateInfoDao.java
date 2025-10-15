package net.linlan.frame.config.dao;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.config.entity.PublicTemplateInfo;
import net.linlan.frame.config.dto.PublicTemplateInfoDto;
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

}
