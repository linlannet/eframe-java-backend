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
package net.linlan.sys.core.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.script.json.StringMap;
import net.linlan.sys.core.dao.CoreAccountDao;
import net.linlan.sys.core.dto.CoreAccountDto;
import net.linlan.sys.core.dto.CoreAccountMapDto;
import net.linlan.sys.core.dto.OrganBaseInfoDto;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.core.param.CoreAccountParam;
import net.linlan.sys.core.param.OrganAccountParam;

/**
 *
 * CoreAccount数据域:平台对接账户服务类
 * @author Linlan
 * CreateTime 2018-03-01 19:01:51
 *
 */
@Service
@Slf4j
public class CoreAccountService {

    @Resource
    private CoreAccountDao dao;

    /** get the list of entity CoreAccount
     * 列表方法，返回列表的平台账户数据 {@link List} 对象，包含 {@link CoreAccount} 列表
     * @param map the input select conditions
     * @return 列表的平台账户数据 {@link List} 对象，包含 {@link CoreAccount} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<CoreAccount> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link CoreAccount}
     * @param id 对接账户ID，外部系统分配的主键|1
     * @return {@link CoreAccount}
     */
    public CoreAccount findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param coreAccount the input coreAccount
     */
    //@Transactional
    public void save(CoreAccount coreAccount) {
        coreAccount.init();
        dao.save(coreAccount);
    }

    /** save the entity with input list
     * 保存对象平台对接账户，批量保存list
     * @param list {@link CoreAccount}
     */
    public void batchSave(List<CoreAccount> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param coreAccount the input coreAccount
     */
    //@Transactional
    public void update(CoreAccount coreAccount) {
        dao.update(coreAccount);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 对接账户ID，外部系统分配的主键|1
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

    public List<CoreAccount> getByParams(Map<String, Object> map) {
        return dao.getByParams(map);
    }

    /**
     * 根据域名获取账户信息
     * @param domain    域路径
     * @return    查询结果
     */
    public CoreAccount findByDomain(String domain) {
        if (StringUtils.isNotBlank(domain)) {
            List<CoreAccount> coreAccountList = getByParams(
                new StringMap().put("serverIp", domain).map());
            if (null != coreAccountList && coreAccountList.size() > 0) {
                return coreAccountList.get(0);
            }
        }
        return null;
    }

    public CoreAccount findByClientInfo(String accountId, String clientId, String clientSecret) {
        if (StringUtils.isBlank(accountId) || StringUtils.isBlank(clientId)
            || StringUtils.isBlank(clientSecret)) {
            return null;
        }
        List<CoreAccount> coreAccountList = getByParams(new StringMap().put("accountId", accountId)
            .put("clientId", clientId).put("clientSecret", clientSecret).map());
        if (null != coreAccountList && coreAccountList.size() > 0) {
            return coreAccountList.get(0);
        }
        return null;
    }

    public CoreAccount getByClientSecret(String clientSecret) {
        if (StringUtils.isBlank(clientSecret)) {
            return null;
        }
        List<CoreAccount> coreAccountList = getByParams(
            new StringMap().put("clientSecret", clientSecret).map());
        if (null != coreAccountList && coreAccountList.size() > 0) {
            return coreAccountList.get(0);
        }
        return null;

    }

    public CoreAccount getByClientId(String clientId) {
        if (StringUtils.isBlank(clientId)) {
            return null;
        }
        List<CoreAccount> coreAccountList = getByParams(
            new StringMap().put("clientId", clientId).map());
        if (null != coreAccountList && coreAccountList.size() > 0) {
            return coreAccountList.get(0);
        }
        return null;

    }

    /** get the page of dto CoreAccountDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link CoreAccountParam }
     * @return 分页的平台账户数据 {@link Page} 对象，包含 {@link CoreAccount} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<CoreAccountDto> getPageDto(CoreAccountParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link CoreAccountDto}
     * @param id 对接账户ID，外部系统分配的主键|1
     * @return {@link CoreAccountDto}
     */
    public CoreAccountDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    public Page<CoreAccountMapDto> getKeyValueList(CoreAccountParam coreAccountParam) {
        PageHelper.startPage(coreAccountParam.getPage(), coreAccountParam.getLimit());
        return dao.getKeyValueList(coreAccountParam);
    }

    /**
     * 系统机构列表
     * @param param    查询参数
     * @return  查询结果
     */
    public Page<OrganBaseInfoDto> getCoreOrganList(OrganAccountParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        Page<OrganBaseInfoDto> result = dao.getCoreOrganList(param);
        return result;
    }

    /**
     * 获取机构详情
     * @param organId  机构ID
     * @return  查询结果
     */
    public OrganBaseInfoDto getCoreOrganInfo(String organId) {
        OrganBaseInfoDto result = dao.getCoreOrganInfo(organId);
        return result;
    }

}
