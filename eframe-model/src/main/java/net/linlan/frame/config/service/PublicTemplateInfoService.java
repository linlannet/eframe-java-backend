package net.linlan.frame.config.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.config.dao.PublicTemplateInfoDao;
import net.linlan.frame.config.entity.PublicTemplateInfo;
import net.linlan.frame.config.dto.PublicTemplateInfoDto;
import net.linlan.frame.config.param.PublicTemplateInfoParam;

/**
 *
 * PublicTemplateInfo数据域:模板信息配置服务类
 * 
 * @author Linlan
 * CreateTime 2025-10-15 13:52:44
 * @version 1.0
 * @since 1.0
 *
 */
@Service
public class PublicTemplateInfoService {

    @Resource
    private PublicTemplateInfoDao dao;

    /** get the list of entity PublicTemplateInfo
     * 列表方法，返回{@link PublicTemplateInfo} 列表
     * @param map the input select conditions
     * @return 列表的模板信息配置数据 {@link List} 对象，包含 {@link PublicTemplateInfo} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<PublicTemplateInfo> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link PublicTemplateInfo}
     * @param id 模板ID|1
     * @return {@link PublicTemplateInfo}
     */
    public PublicTemplateInfo findById(String id) {
        if (StringUtils.isBlank(id)){
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param publicTemplateInfo the input publicTemplateInfo
     */
    //@Transactional
    public void save(PublicTemplateInfo publicTemplateInfo) {
        publicTemplateInfo.init();
        dao.save(publicTemplateInfo);
    }

    /** batch save the entity with input list
     * 保存对象模板信息配置，批量保存list
     * @param list {@link PublicTemplateInfo}
     */
    public void batchSave(List<PublicTemplateInfo> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param publicTemplateInfo the input publicTemplateInfo
     */
    //@Transactional
    public void update(PublicTemplateInfo publicTemplateInfo) {
        dao.update(publicTemplateInfo);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 模板ID|1
     */
    public void deleteById(String id) {
        if (StringUtils.isBlank(id)){
            return;
        }
        dao.deleteById(id);
    }

    /** batch delete the entity by input ids
     * 批量删除方法，通过ids删除对象
     * @param ids the input ids
     */
    //@Transactional
    public void deleteByIds(String[] ids) {
        if(ObjectUtils.isEmpty(ids)){
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

    /** get the page of dto PublicTemplateInfoDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param 查询参数
     * @return 分页的模板信息配置数据 {@link Page} 对象，包含 {@link PublicTemplateInfo} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<PublicTemplateInfoDto> getPageDto(PublicTemplateInfoParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link PublicTemplateInfoDto}
     * @param id 模板ID|1
     * @return {@link PublicTemplateInfoDto}
     */
    public PublicTemplateInfoDto getDtoById(String id) {
        if (StringUtils.isBlank(id)){
            return null;
        }
        return dao.getDtoById(id);
    }

}
