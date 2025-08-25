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
package net.linlan.sys.base.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dao.BaseAppDao;
import net.linlan.sys.base.dto.BaseAppDto;
import net.linlan.sys.base.dto.BaseAppInfoDto;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.entity.BaseApp;
import net.linlan.sys.base.param.BaseAppParam;

/**
 *
 * BaseApp数据域:应用信息服务类
 * @author Linlan
* CreateTime 2018-03-02 17:17:54
 *
 */
@Service
@Slf4j
public class BaseAppService {

    @Resource
    private BaseAppDao dao;

    /** get the list of entity BaseApp
     * 列表方法，返回列表的基础应用数据 {@link List} 对象，包含 {@link BaseApp} 列表
     * @param map the input select conditions
     * @return 列表的基础应用数据 {@link List} 对象，包含 {@link BaseApp} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseApp> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseApp}
     * @param id 应用ID|1
     * @return {@link BaseApp}
     */
    public BaseApp findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseApp the input baseApp
     */
    //@Transactional
    public void save(BaseApp baseApp) {
        baseApp.init();
        dao.save(baseApp);
    }

    /** save the entity with input list
     * 保存对象应用信息，批量保存list
     * @param list {@link BaseApp}
     */
    public void batchSave(List<BaseApp> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseApp the input baseApp
     */
    //@Transactional
    public void update(BaseApp baseApp) {
        dao.update(baseApp);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 应用ID|1
     */
    public void deleteById(String id) {
        if (StringUtils.isBlank(id)) {
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

    /** get the page of dto BaseAppDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseAppParam }
     * @return 分页的应用数据 {@link Page} 对象，包含 {@link BaseApp} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseAppDto> getPageDto(BaseAppParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseAppDto}
     * @param id 应用ID|1
     * @return {@link BaseAppDto}
     */
    public BaseAppDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    /**
     * 获取应用行政区划code
     * @param params    查询参数
     * @return  查询结果
     */
    public String getAreaCodeByParams(Map<String, Object> params) {
        return dao.getAreaCodeByParams(params);
    }
    //    /** 通过线程获取当前appId条件是否需要加入
    //     * @param params
    //     * @return    结果MAP
    //     */
    //    public Map<String, Object> getParamsByEnv(Map<String, Object> params){
    //        String appId = KernelThreadVariable.getBaseAppId();
    //        if (StringUtils.isNotBlank(appId)){
    //            BaseApp app = findById(appId);
    //            if (app != null){
    //                if (!app.getDomainId().equals(KernelConstant.DEFAULT_DOMAIN)){
    //                    params.put("appId", appId);
    //                }
    //            }
    //        }
    //        return params;
    //    }

    //    /** 获取缺省的应用列表，可传入appId,当传入的appId为产品coc域时,返回全部应用列表,不添加appId条件
    //     * 当传入的appId为非coc域时,此时表示,只查询此应用的相关资源,即某一个具体项目的资源
    //     */
    //    public StringMap getAppIdByEnv(){
    //        StringMap map = new StringMap();
    //        String appId = KernelThreadVariable.getBaseAppId();
    //        if (StringUtils.isNotBlank(appId)){
    //            BaseApp app = findById(appId);
    //            if (app != null){
    //                if (!app.getDomainId().equals(KernelConstant.DEFAULT_DOMAIN)){
    //                    map.put("appId", appId);
    //                }
    //            }
    //        }
    //        return map;
    //    }

    /** 通过ID获取包含更多名称信息的BaseAppInfoDto对象
     * @param id    主键ID
     * @return    查询对象
     */
    public BaseAppInfoDto getBaseAppInfoDto(String id) {
        return dao.getBaseAppInfoDto(id);
    }

    /** 通过字典CODE主键获取APP的ID和NAME，返回基本字典对象BaseDictionary
     * @return    返回结果List
     */
    public List<DictionaryInitDto> getForSelect() {
        return dao.getForSelect();
    }

}
