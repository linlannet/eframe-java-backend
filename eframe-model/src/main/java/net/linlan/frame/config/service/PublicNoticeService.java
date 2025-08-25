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
package net.linlan.frame.config.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.frame.config.dao.PublicNoticeDao;
import net.linlan.frame.config.dto.PublicNoticeDto;
import net.linlan.frame.config.entity.PublicNotice;
import net.linlan.frame.config.param.PublicNoticeParam;

/**
 *
 * PublicNotice数据域:平台公共消息服务类
 * @author Linlan
 * CreateTime 2023-10-02 22:29:22
 *
 */
@Service
@Slf4j
public class PublicNoticeService {

    @Resource
    private PublicNoticeDao dao;

    /** get the list of entity PublicNotice
     * 列表方法，返回列表的通告数据 {@link List} 对象，包含 {@link PublicNotice} 列表
     * @param map the input select conditions
     * @return 列表的通告数据 {@link List} 对象，包含 {@link PublicNotice} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<PublicNotice> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link PublicNotice}
     * @param id 信息ID|1
     * @return {@link PublicNotice}
     */
    public PublicNotice findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param publicNotice the input publicNotice
     */
    //@Transactional
    public void save(PublicNotice publicNotice) {
        publicNotice.init();
        dao.save(publicNotice);
    }

    /** batch save the entity with input list
     * 保存对象平台公共消息，批量保存list
     * @param list {@link PublicNotice}
     */
    public void batchSave(List<PublicNotice> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param publicNotice the input publicNotice
     */
    //@Transactional
    public void update(PublicNotice publicNotice) {
        dao.update(publicNotice);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 信息ID|1
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

    /** get the page of dto PublicNoticeDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link PublicNoticeParam }
     * @return 分页的通告数据 {@link Page} 对象，包含 {@link PublicNotice} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<PublicNoticeDto> getPageDto(PublicNoticeParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link PublicNoticeDto}
     * @param id 信息ID|1
     * @return {@link PublicNoticeDto}
     */
    public PublicNoticeDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    /** get the page of dto PublicNoticeDto
     * 列表分页方法，返回分页DTO对象列表  获取用户自身的数据
     * @param param the input param {@link PublicNoticeParam }
     * @return 分页的通告数据 {@link Page} 对象，包含 {@link PublicNotice} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<PublicNoticeDto> getMyselfList(PublicNoticeParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getMyselfList(param);
    }

}
