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

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.FrameUserDetails;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.social.third.dao.ThirdMemberTokenDao;
import net.linlan.social.third.dto.ThirdMemberTokenDto;
import net.linlan.social.third.entity.ThirdMember;
import net.linlan.social.third.entity.ThirdMemberToken;
import net.linlan.social.third.param.ThirdMemberTokenParam;
import net.linlan.sys.base.dto.TokenResponse;
import net.linlan.sys.base.entity.BaseConfigParts;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.base.service.BaseConfigPartsService;
import net.linlan.sys.base.service.BaseUserService;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.TokenGenerator;

/**
 *
 * ThirdMemberToken数据域:会员用户令牌服务类
 *
 * @author Linlan
 * CreateTime 2025-10-13 16:35:28
 * @version 1.0
 * @since 1.0
 *
 */
@Service
public class ThirdMemberTokenService {

    public final static String     MEMBER_TOKEN_REFRESH_TIME = "MEMBER_TOKEN_REFRESH_TIME";

    @Resource
    private ThirdMemberTokenDao    dao;
    @Resource
    private BaseConfigPartsService baseConfigPartsService;
    @Resource
    private ThirdMemberService     thirdMemberService;
    @Resource
    private BaseUserService        baseUserService;

    /** get the list of entity ThirdMemberToken
     * 列表方法，返回{@link ThirdMemberToken} 列表
     * @param map the input select conditions
     * @return 列表的会员用户令牌数据 {@link List} 对象，包含 {@link ThirdMemberToken} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public List<ThirdMemberToken> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    /** find the entity by input id, return entity
     * 对象详情方法，通过id查询对象{@link ThirdMemberToken}
     * @param id 主键ID|1
     * @return {@link ThirdMemberToken}
     */
    public ThirdMemberToken findById(Long id) {
        return dao.findById(id);
    }

    /** save the entity with input object
     * 保存对象方法
     * @param thirdMemberToken the input thirdMemberToken
     */
    //@Transactional
    public void save(ThirdMemberToken thirdMemberToken) {
        thirdMemberToken.init();
        dao.save(thirdMemberToken);
    }

    /** batch save the entity with input list
     * 保存对象会员用户令牌，批量保存list
     * @param list {@link ThirdMemberToken}
     */
    public void batchSave(List<ThirdMemberToken> list) {
        dao.batchSave(list);
    }

    /** update the entity with input object
     * 更新对象方法
     * @param thirdMemberToken the input thirdMemberToken
     */
    //@Transactional
    public void update(ThirdMemberToken thirdMemberToken) {
        dao.update(thirdMemberToken);
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

    /** get the page of dto ThirdMemberTokenDto
     * 列表分页方法，返回分页DTO对象列表
     * @param param the input param 查询参数
     * @return 分页的会员用户令牌数据 {@link Page} 对象，包含 {@link ThirdMemberToken} 列表
     */
    //@DataFilter(tableAlias = "B", owner = false)
    public Page<ThirdMemberTokenDto> getPageDto(ThirdMemberTokenParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        return dao.getPageDto(param);
    }

    /** get the dto by input id, return dto
     * 对象详情方法，通过id查询对象{@link ThirdMemberTokenDto}
     * @param id 主键ID|1
     * @return {@link ThirdMemberTokenDto}
     */
    public ThirdMemberTokenDto getDtoById(Long id) {
        return dao.getDtoById(id);
    }

    public void saveOrUpdateFromThird(AppLoginInfo appLoginInfo, FrameUserDetails loginUser) {
        ThirdMemberToken entity = findById(loginUser.getUserLid());
        if (entity == null) {
            entity = new ThirdMemberToken();
            entity.setId(loginUser.getUserLid());
            entity.setUserId(loginUser.getUserId());
            entity.setToken(appLoginInfo.getToken());
            entity.setForeignId(loginUser.getForeignId());
            entity.setUsername(loginUser.getUsername());
            entity.setLoginIp(loginUser.getLoginIp());
            entity.setUpdateTime(appLoginInfo.getUpdateTime());
            entity.setExpireTime(appLoginInfo.getExpireTime());
            save(entity);
        } else {
            entity.setToken(appLoginInfo.getToken());
            entity.setUpdateTime(appLoginInfo.getUpdateTime());
            entity.setExpireTime(appLoginInfo.getExpireTime());
            update(entity);
        }
    }

    /**
     * get the ThirdMemberToken by input token
     *
     * @param token the input token
     * @return {@link ThirdMemberToken}
     */
    public ThirdMemberToken getByToken(String token) {
        return dao.getByToken(token);
    }

    /**
     * create token of member user by id. 生成用户TOKEN
     *
     * @param id       member user id
     * @param foreignId   site id 或 app id
     * @param token  token
     * @param ip       ip address
     * @return {@link TokenResponse}
     */
    public TokenResponse createToken(Long id, String foreignId, String token, String ip) {
        //当前时间
        Date now = new Date();
        //过期时间，默认设置为三十天，后台可调整时间，存储到BASE_CONFIG_PARRTS内，可通过数据库调整
        //        Date expireTime = DateUtils.addDays(now, KernelConstant.THIRTY_DAY);
        Long duration = KernelConstant.THIRTY_DAY_EXPIRE * 10 / 1000;
        BaseConfigParts baseConfigParts = baseConfigPartsService
            .findById(MEMBER_TOKEN_REFRESH_TIME);
        if (baseConfigParts != null) {
            duration = Long.parseLong(baseConfigParts.getCfgValue());
        }
        Date expireTime = new Date(now.getTime() + duration * 1000);

        //之前判断是否生成过token
        //存在一个人同时通过不同终端登录多个账号的情况
        ThirdMemberToken entity = findById(id);
        if (entity == null) {
            entity = new ThirdMemberToken();
            entity.setId(id);
            entity.setForeignId(foreignId);
            entity.setToken(token);
            entity.setLoginIp(ip);
            entity.setUpdateTime(now);
            entity.setExpireTime(expireTime);
            //保存token
            save(entity);
        } else {
            entity.setForeignId(foreignId);
            entity.setToken(token);
            entity.setLoginIp(ip);
            entity.setUpdateTime(now);
            entity.setExpireTime(expireTime);
            //更新token
            update(entity);
        }
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        tokenResponse.setExpireTime(expireTime);
        return tokenResponse;
    }

    /**
     * 通过有效TOKEN刷新Token，按照后台配置的时间进行刷新
     *
     * @param oldToken 有效的现有TOKEN
     * @param ip       IP地址
     * @return {@link TokenResponse}
     */
    public TokenResponse refreshToken(String oldToken, String ip) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间，默认设置为三十天，后台可调整时间，存储到BASE_CONFIG_PARRTS内，可通过数据库调整
        Long duration = KernelConstant.THIRTY_DAY_EXPIRE / 1000;

        BaseConfigParts baseConfigParts = baseConfigPartsService
            .findById(MEMBER_TOKEN_REFRESH_TIME);
        if (baseConfigParts != null) {
            duration = Long.parseLong(baseConfigParts.getCfgValue());
        }
        Date expireTime = new Date(now.getTime() + duration * 1000);

        ThirdMemberToken entity = getByToken(oldToken);
        if (entity != null) {
            entity.setToken(token);
            entity.setLoginIp(ip);
            entity.setUpdateTime(now);
            entity.setExpireTime(expireTime);
            //更新token
            update(entity);
        }
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        tokenResponse.setExpireTime(expireTime);
        return tokenResponse;
    }

    /**
     * 通过会员ID刷新TOKEN，按照后台配置的时间进行刷新
     *
     * @param id 会员ID
     * @param ip IP地址
     * @return {@link TokenResponse}
     */
    public TokenResponse refreshToken(Long id, String ip) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间，默认设置为三十天，后台可调整时间，存储到BASE_CONFIG_PARRTS内，可通过数据库调整
        Long duration = KernelConstant.THIRTY_DAY_EXPIRE / 1000;
        BaseConfigParts baseConfigParts = baseConfigPartsService
            .findById(MEMBER_TOKEN_REFRESH_TIME);
        if (baseConfigParts != null) {
            duration = Long.parseLong(baseConfigParts.getCfgValue());
        }
        Date expireTime = new Date(now.getTime() + duration * 1000);

        ThirdMemberToken entity = findById(id);
        if (entity != null) {
            entity.setToken(token);
            entity.setLoginIp(ip);
            entity.setUpdateTime(now);
            entity.setExpireTime(expireTime);
            //更新token
            update(entity);
        }
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        tokenResponse.setExpireTime(expireTime);
        return tokenResponse;
    }

    /**
     * 登出并且设置token无效
     *
     * @param id 会员ID
     * @return true 成功; false 失败
     */
    public boolean logout(Long id) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //生成一个新的token，已区分是登出状态
        ThirdMemberToken entity = findById(id);
        entity.setToken(token);
        update(entity);

        //保存最后一次登出时间
        if (null != id) {
            ThirdMember thirdMember = thirdMemberService.findById(id);
            if (null != thirdMember && StringUtils.isNotBlank(thirdMember.getUserId())) {
                BaseUser baseUser = baseUserService.findById(thirdMember.getUserId());
                baseUser.setLastLogoutTime(new Date());
                baseUserService.update(baseUser);
            }
        }
        return Boolean.TRUE;
    }
}
