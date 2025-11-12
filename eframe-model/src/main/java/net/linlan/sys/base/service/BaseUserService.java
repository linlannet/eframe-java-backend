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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.script.json.StringMap;
import net.linlan.sys.base.dao.BaseUserDao;
import net.linlan.sys.base.dto.BaseUserDto;
import net.linlan.sys.base.dto.BaseUserSelect;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.base.entity.BaseUserExt;
import net.linlan.sys.base.param.BaseUserParam;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.ServletUtils;
import net.linlan.utils.crypt.ShaUtils;
import net.linlan.utils.http.HttpContextUtils;
import net.linlan.utils.ip.IPUtils;

/**
 *
 * BaseUser数据域:基础用户服务类
 * @author Linlan
 * CreateTime 2018-03-02 17:41:37 *
 */
@Service
@Slf4j
public class BaseUserService {

    @Resource
    private BaseUserDao        dao;

    @Resource
    private BaseUserExtService baseUserExtService;

    /** get the list of entity BaseUser
     * 列表方法，返回BaseUser列表
     * @param map the input select conditions
     * @return 分页的基础机构数据 {@link Page} 对象，包含 {@link BaseUser} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<BaseUser> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link BaseUser}
     * @param id 用户ID|1
     * @return {@link BaseUser}
     */
    public BaseUser findById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param baseUser the input baseUser
     */
    //@Transactional
    public void save(BaseUser baseUser) {
        //sha256加密，从62个char中随即取出20个作为混淆码
        String salt = RandomUtils.random(20, RandomUtils.CHARS_WHOLE_62);
        // shuxiaobo add 20250205 保存BCryptPasswordEncoder的密码
        String bcryptPassword = "";
        if (StringUtils.isNotBlank(baseUser.getNewPassword())) {
            baseUser.setPassword(ShaUtils.encryptPassword(baseUser.getNewPassword()));
            bcryptPassword = baseUser.getNewPassword();
        } else if (StringUtils.isNotBlank(baseUser.getPassword())) {
            baseUser.setPassword(ShaUtils.encryptPassword(baseUser.getPassword()));
            bcryptPassword = baseUser.getNewPassword();
        }
        baseUser.setSalt(salt);
        //初始化对象
        baseUser.init();
        //统一ID
        String id = baseUser.getId();
        if (baseUser.getId() == null) {
            id = RandomUtils.UUID();
            baseUser.setId(id);
        }
        dao.save(baseUser);
        BaseUserExt baseUserExt = new BaseUserExt();
        baseUserExt.setId(id);
        baseUserExt.setNamePy(ShaUtils.encryptPassword(bcryptPassword));
        baseUserExtService.save(baseUserExt);
    }

    /** save the entity with input list
     * 保存对象基础用户，批量保存list
     * @param list {@link BaseUser}
     */
    public void batchSave(List<BaseUser> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param baseUser the input baseUser
     */
    //@Transactional
    public void update(BaseUser baseUser) {
        if (StringUtils.isEmpty(baseUser.getId())) {
            return;
        }
        // shuxiaobo add 20250205 保存BCryptPasswordEncoder的密码
        String bcryptPassword = "";
        //默认保存原来的密码
        if (StringUtils.isNotBlank(baseUser.getNewPassword())) {
            bcryptPassword = baseUser.getNewPassword();
            baseUser.setPassword(ShaUtils.encryptPassword(baseUser.getNewPassword()));
        }
        baseUser.setLastTime(new Timestamp(System.currentTimeMillis()));
        dao.update(baseUser);
        BaseUserExt baseUserExt = baseUserExtService.findById(baseUser.getId());
        if (ObjectUtils.isEmpty(baseUserExt)) {
            baseUserExt = new BaseUserExt();
            baseUserExt.setId(baseUser.getId());
            baseUserExt.setNamePy(ShaUtils.encryptPassword(bcryptPassword));
            baseUserExtService.save(baseUserExt);
        } else {
            baseUserExt.setId(baseUser.getId());
            baseUserExt.setNamePy(ShaUtils.encryptPassword(bcryptPassword));
            baseUserExtService.update(baseUserExt);
        }

    }

    /** delete the entity by input id
     * 删除方法，通过id删除对象
     * @param id 用户ID|1
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

    /** get the page of dto BaseUserDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param {@link BaseUserParam }
     * @return 分页的基础机构数据 {@link Page} 对象，包含 {@link BaseUserDto} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<BaseUserDto> getPageDto(BaseUserParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link BaseUserDto}
     * @param id 用户ID|1
     * @return {@link BaseUserDto}
     */
    public BaseUserDto getDtoById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return dao.getDtoById(id);
    }

    public BaseUser getByUsername(String username) {
        return dao.getByUsername(username);
    }

    public BaseUser getByMobile(String mobile) {
        return dao.getByMobile(mobile);
    }

    public BaseUser getByEmail(String email) {
        return dao.getByEmail(email);
    }

    public BaseUser getByUserkey(String userkey) {
        List<BaseUser> list = dao.getByUserkey(userkey);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /** 通过用户ID和原密码，更新用户密码
     * @param id    用户ID
     * @param password  密码
     * @param newPassword   新密码
     * @return  更新状态
     */
    public int updatePassword(String id, String password, String newPassword) {
        BaseUser entity = findById(id);
        if (entity == null) {
            return -1;
        }
        //sha256加密
        password = ShaUtils.encryptPassword(password);
        //sha256加密
        newPassword = ShaUtils.encryptPassword(newPassword);
        int result = dao.updatePassword(new StringMap().put("id", id).put("password", password)
            .put("newPassword", newPassword).map());
        // shuxiaobo modify 20250205 同步更新BcryptPassword
        baseUserExtService
            .updatePassword(new StringMap().put("id", id).put("newPassword", newPassword).map());
        return result;
    }

    /**  验证用户的密码是否正确，正确返回true，错误返回false
     * @param id    用户ID
     * @param password  用户密码
     * @return  密码是否匹配
     */
    public boolean verifyPassword(String id, String password) {
        BaseUser entity = findById(id);
        if (entity == null) {
            return false;
        }
        if (entity.getPassword().equals(ShaUtils.encryptPassword(password))) {
            return true;
        }
        return false;
    }

    /** 检查当前id的信息是否能够删除，如果能够删除，则返回true
     * @param id    the input id
     * @return    true    can be delete
     *            false   cannot be delete
     */
    public boolean isValidByDelete(String id) {
        //检查数据是否能够被删除，默认为true
        return true;
    }

    /** 保存当前登录的信息，更新登录状态，并且重置错误次数、锁定标记
     * @param userId    用户ID
     * @param srcCode   用户来源
     */
    public void updateLoginSuccess(String userId, Integer srcCode) {
        BaseUser bean = findById(userId);
        if (bean == null) {
            return;
        }
        if (srcCode == null) {
            srcCode = 0;
        }
        //add by linlan on 2023年8月14日 空指针异常
        if (srcCode == null) {
            srcCode = 0;
        }
        //end
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        String ip = IPUtils.getIpAddr(request);
        Date now = new Timestamp(System.currentTimeMillis());
        bean.setLoginCount(bean.getLoginCount() + 1);
        bean.setLastLoginIp(ip);
        bean.setLastLoginTime(now);
        bean.setSrcCode(srcCode);
        bean.setCurrentLoginIp(ip);
        bean.setCurrentLoginTime(now);
        //重置错误次数和错误时间
        bean.setErrorCount(KernelConstant.DEFAULT_INT);
        bean.setErrorTime(null);
        //重置锁定时间
        bean.setLockTime(null);
        bean.setLastTime(now);
        update(bean);
    }

    public List<BaseUserSelect> getListByCode(Map<String, Object> map) {
        return dao.getListByCode(map);
    }

    public BaseUser getByParams(Map<String, Object> map) {
        List<BaseUser> list = dao.getByParams(map);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public BaseUser getIfExists(Map<String, Object> map) {
        List<BaseUser> list = dao.getIfExists(map);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public BaseUser getByIdNum(Map<String, Object> map) {
        List<BaseUser> list = dao.getByIdNum(map);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /** 增加错误登录次数，未达到6次时，仅增加错误次数，达到6次，需要设置锁定时间
     * @param id    当前用户ID
     * @return
     */
    public int addErrorLoginInfo(String id) {
        if (StringUtils.isBlank(id)) {
            return KernelConstant.DEFAULT_INT;
        }
        BaseUser entity = findById(id);
        if (entity == null) {
            return KernelConstant.DEFAULT_INT;
        }
        //错误密码次数的LIMIT，默认为6
        if (entity.getErrorCount() > KernelConstant.ERROR_COUNT_LIMIT - 1) {
            //抵达最大次数，需要设置锁定标记
            entity.setErrorCount(entity.getErrorCount() + 1);
            //登陆失败重新刷新锁定时间
            entity.setLockTime(new Date());
        } else {
            //没有达到最大标记
            entity.setLockTime(new Date());
            entity.setErrorCount(entity.getErrorCount() + 1);
        }
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        String ip = IPUtils.getIpAddr(request);
        entity.setErrorIp(ip);
        entity.setLastTime(new Timestamp(System.currentTimeMillis()));
        update(entity);
        return entity.getErrorCount();
    }

    /**
     * 批量更新用户密码
     * @param userIds   用户ID列表
     * @param password  用户密码
     * @return  更新状态
     */
    public int batUpdatePassword(String[] userIds, String password) {
        if (ObjectUtils.isEmpty(userIds) || ObjectUtils.isEmpty(password)) {
            return -1;
        }
        //重新设置秘钥
        String salt = RandomUtils.random(20, RandomUtils.CHARS_WHOLE_62);
        //sha256加密
        password = ShaUtils.encryptPassword(password);
        int result = dao.batUpdatePassword(userIds, password, salt);
        // shuxiaobo modify 20250205 同步更新BcryptPassword
        baseUserExtService.batUpdatePassword(userIds, password);
        return result;
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(String userId) {
        if (StringUtils.isNotBlank(userId)) {

            BaseUser baseUser = findById(userId);
            if (baseUser != null) {
                baseUser.setId(userId);
                baseUser.setLastLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
                baseUser.setLastLoginTime(new Date());
                baseUser.setLoginCount(baseUser.getLoginCount() + 1);
                update(baseUser);
            }

        }
    }
}
