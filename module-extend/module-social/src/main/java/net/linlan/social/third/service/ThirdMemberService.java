/*
 * module-social - 社交平台对接模块
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
package net.linlan.social.third.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.social.third.dao.ThirdMemberDao;
import net.linlan.social.third.dto.ThirdMemberDto;
import net.linlan.social.third.entity.ThirdMember;
import net.linlan.social.third.param.ThirdMemberParam;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.core.service.CoreAccountService;

/**
 *
 * ThirdMember数据域:第三方用户服务类
 * 
 * @author Linlan
 * CreateTime 2025-10-13 16:35:28
 * @version 1.0
 * @since 1.0
 *
 */
@Service
public class ThirdMemberService {

    @Resource
    private ThirdMemberDao     dao;
    @Resource
    private CoreAccountService coreAccountService;

    /** get the list of entity ThirdMember
     * 列表方法，返回{@link ThirdMember} 列表
     * @param map the input select conditions
     * @return 列表的第三方用户数据 {@link List} 对象，包含 {@link ThirdMember} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<ThirdMember> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link ThirdMember}
     * @param id 主键ID|1
     * @return {@link ThirdMember}
     */
    public ThirdMember findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param thirdMember the input thirdMember
     */
    //@Transactional
    public void save(ThirdMember thirdMember) {
        thirdMember.init();
        dao.save(thirdMember);
    }

    /** batch save the entity with input list
     * 保存对象第三方用户，批量保存list
     * @param list {@link ThirdMember}
     */
    public void batchSave(List<ThirdMember> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param thirdMember the input thirdMember
     */
    //@Transactional
    public void update(ThirdMember thirdMember) {
        dao.update(thirdMember);
    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 主键ID|1
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

    /** get the page of dto ThirdMemberDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param 查询参数
     * @return 分页的第三方用户数据 {@link Page} 对象，包含 {@link ThirdMember} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<ThirdMemberDto> getPageDto(ThirdMemberParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link ThirdMemberDto}
     * @param id 主键ID|1
     * @return {@link ThirdMemberDto}
     */
    public ThirdMemberDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    public List<ThirdMemberDto> getByParams(Map<String, Object> map) {
        return dao.getByParams(map);
    }

    public ThirdMember findByUserId(String userId) {
        return dao.findByUserId(userId);
    }

    public ThirdMember getByServerTypeAndOpenId(String serverType, String openId) {
        CoreAccount coreAccount = coreAccountService.getByServerType(serverType);
        if (ObjectUtils.isEmpty(coreAccount) && StringUtils.isBlank(openId)) {
            return null;
        }
        //通过accountId和openId查询正常状态的用户
        ThirdMember thirdMember = findByAccountIdOpenId(coreAccount.getId(), openId);
        if (null != thirdMember) {
            return thirdMember;
        }
        return null;
    }

    public ThirdMember findByAccountIdOpenId(String accountId, String openId) {
        return dao.findByAccountIdOpenId(accountId, openId);
    }

    public ThirdMember findByUserIdOpenId(String userId, String openId) {
        return dao.findByUserIdOpenId(userId, openId);
    }

    public ThirdMember findByUserIdAccountId(String userId, String accountId) {
        return dao.findByUserIdAccountId(userId, accountId);
    }

}
