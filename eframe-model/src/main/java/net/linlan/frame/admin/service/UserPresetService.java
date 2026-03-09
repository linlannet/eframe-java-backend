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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import net.linlan.frame.admin.constant.PresetTypeEnum;
import net.linlan.frame.admin.dao.UserPresetDao;
import net.linlan.frame.admin.dto.UserPresetDto;
import net.linlan.frame.admin.entity.UserPreset;
import net.linlan.frame.admin.param.UserPresetParam;

/**
 *
 * SasPowerPreset数据域:权限预置信息服务类
 * @author Linlan
 * CreateTime 2021-09-18 17:42:58
 *
 */
@Service
@Slf4j
public class UserPresetService {

    @Resource
    private UserPresetDao       dao;

    /**
     * 用户默认密码
     */
    private static final String DEFAULT_PASSWORD = "Z123456";
    private Map<String, Long>   groupMap         = new HashMap<>();

    /** get the list of entity SasPowerPreset
     * 列表方法，返回列表的管理员预置权限 {@link Page} 对象，包含 {@link UserPreset} 列表
     * @param map the input select conditions
     * @return 列表的管理员预置权限 {@link Page} 对象，包含 {@link UserPreset} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<UserPreset> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link UserPreset}
     * @param id the SasPowerPreset 预置信息ID | 1
     * @return {@link UserPreset}
     */
    public UserPreset findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param userPreset the input userPreset
     */
    //@Transactional
    public void save(UserPreset userPreset) {
        userPreset.init();
        //        if(BaseConfigPartsService.openEncrypt){
        //            encrypt(userPreset);
        //        }
        dao.save(userPreset);
    }

    /** save the entity with input list
     * 保存对象权限预置信息，批量保存list
     * @param list {@link UserPreset}
     */
    public void batchSave(List<UserPreset> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param userPreset the input userPreset
     */
    //@Transactional
    public void update(UserPreset userPreset) {
        dao.update(userPreset);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id the SasPowerPreset 预置信息ID | 1
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

    /** get the page of dto SasPowerPresetDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link UserPresetParam }
     * @return 分页的权限预置数据 {@link Page} 对象，包含 {@link UserPreset} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<UserPresetDto> getPageDto(UserPresetParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link UserPresetDto}
     * @param id the SasPowerPreset 预置信息ID | 1
     * @return {@link UserPresetDto}
     */
    public UserPresetDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    private boolean checkAuthType(String authType) {
        for (PresetTypeEnum presetTypeEnum : PresetTypeEnum.values()) {
            if (presetTypeEnum.getKey().equals(authType)) {
                return true;
            }
        }
        return false;
    }

    public UserPreset getPresetByMobileAndPositionId(@Param("mobile") String mobile,
                                                     @Param("positionId") String positionId) {
        return dao.getPresetByMobileAndPositionId(mobile, positionId);
    }

    public List<UserPreset> getByMobileAndType(@Param("mobile") String mobile,
                                               @Param("type") String type,
                                               @Param("areaId") String areaId) {
        return dao.getByMobileAndType(mobile, type, areaId);
    }

}
