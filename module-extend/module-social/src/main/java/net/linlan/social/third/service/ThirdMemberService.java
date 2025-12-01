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
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.*;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.social.manage.constant.BindFromEnum;
import net.linlan.social.third.dao.ThirdMemberDao;
import net.linlan.social.third.dto.ThirdMemberDto;
import net.linlan.social.third.dto.ThirdUserDto;
import net.linlan.social.third.entity.ThirdMember;
import net.linlan.social.third.entity.ThirdMemberBind;
import net.linlan.social.third.param.ThirdMemberParam;
import net.linlan.sys.base.constant.CreateTypeEnum;
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.base.constant.SrcCodeEnum;
import net.linlan.sys.base.entity.BaseUser;
import net.linlan.sys.base.entity.BaseUserExt;
import net.linlan.sys.base.service.BaseUserExtService;
import net.linlan.sys.base.service.BaseUserService;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.core.service.CoreAccountService;
import net.linlan.utils.ServletUtils;
import net.linlan.utils.bean.BeanUtils;
import net.linlan.utils.exception.CommonException;
import net.linlan.utils.ip.IPUtils;
import static net.linlan.social.manage.constant.ProviderSource.*;

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
    private ThirdMemberDao         dao;
    @Resource
    private CoreAccountService     coreAccountService;
    @Resource
    private AdminUserService       adminUserService;
    @Resource
    private BaseUserService        baseUserService;
    @Resource
    private BaseUserExtService     baseUserExtService;
    @Resource
    private ThirdMemberBindService thirdMemberBindService;

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

    public ThirdMember findByOpenId(String openId, String source) {
        return dao.findByOpenId(openId, source);
    }

    public ThirdMember findByUnionId(String unionId) {
        return dao.findByUnionId(unionId);
    }

    public ThirdMember findByUserIdAccountId(String userId, String accountId) {
        return dao.findByUserIdAccountId(userId, accountId);
    }

    /**
     * 根据类型，获取授权请求
     *
     * @param serverType 第三方登录类型，如：wechat_oauth，alipay_oauth
     * @return 返回授权请求对象
     */
    public AuthRequest getAuthRequest(String serverType) {
        CoreAccount config = coreAccountService.getByServerType(serverType);

        if (config == null) {
            throw new CommonException("未配置第三方登录，请配置后再尝试");
        }

        AuthRequest authRequest;

        if (WECHAT_WORK.getKey().equals(serverType)) {
            authRequest = new AuthWeChatEnterpriseQrcodeRequest(AuthConfig.builder()
                .clientId(config.getClientId()).clientSecret(config.getClientSecret())
                .redirectUri(config.getServerUrl()).agentId(config.getServerConf1()).build());
        } else if (DINGTALK.getKey().equals(serverType)) {
            authRequest = new AuthDingTalkRequest(AuthConfig.builder()
                .clientId(config.getClientId()).clientSecret(config.getClientSecret())
                .redirectUri(config.getServerUrl()).build());
        } else if (FEISHU.getKey().equals(serverType)) {
            authRequest = new AuthFeishuRequest(AuthConfig.builder().clientId(config.getClientId())
                .clientSecret(config.getClientSecret()).redirectUri(config.getServerUrl()).build());
        } else if (WECHAT_OPEN.getKey().equals(serverType)) {
            authRequest = new AuthWeChatOpenRequest(AuthConfig.builder()
                .clientId(config.getClientId()).clientSecret(config.getClientSecret())
                .redirectUri(config.getServerUrl()).build());
        } else {
            throw new IllegalArgumentException("Unsupported identity provider type: " + serverType);
        }

        return authRequest;
    }

    @Transactional
    public void bindFromSocial(String userId, String bindFrom, String platformType,
                               AuthUser authUser) {
        CoreAccount coreAccount = coreAccountService.getByServerType(platformType);
        if (coreAccount == null) {
            return;
        }

        //保存ThirdMember
        Long memberId = RandomUtils.randomLid();
        ThirdMember thirdMember = findByOpenId(authUser.getUuid(), platformType);
        String unionId = "";
        if (authUser.getRawUserInfo().get("unionid") != null) {
            unionId = authUser.getRawUserInfo().get("unionid").toString();
        }
        if (thirdMember == null) {
            thirdMember = new ThirdMember();
            thirdMember.setId(memberId);
            thirdMember.setUserId(userId);
            thirdMember.setUnionId(unionId);
            thirdMember.setOpenId(authUser.getUuid());
            thirdMember.setAccountId(coreAccount.getId());
            thirdMember.setAccountType(platformType);
            thirdMember.setNickName(authUser.getNickname());
            thirdMember.setAvatarUrl(authUser.getAvatar());
            thirdMember.setAdditionInfo(authUser.getRawUserInfo().toJSONString());
            save(thirdMember);

        } else {
            memberId = thirdMember.getId();
            thirdMember.setNickName(authUser.getNickname());
            thirdMember.setAvatarUrl(authUser.getAvatar());
            thirdMember.setAdditionInfo(authUser.getRawUserInfo().toJSONString());
            thirdMember.setDelFlag(DelFlagEnum.NORMAL.getKey());
            update(thirdMember);
        }
        //当前用户可能已经通过其他渠道进行过BaseUser保存，也可能是管理员进行绑定，进行区分处理
        //保存BaseUser和BaseUserExt
        //AdminUser登录进行绑定时，BaseUser信息可能不存在，ThirdMember登录，BaseUser都存在
        BaseUser baseUser = baseUserService.findById(userId);
        if (baseUser == null) {
            baseUser = new BaseUser();
            if (bindFrom.equals(BindFromEnum.ADMIN_WORK.getKey())) {
                //管理员绑定，直接拷贝AdminUser的信息到BaseUser中
                AdminUser adminUser = adminUserService.findByUserId(userId);
                if (adminUser != null) {
                    BeanUtils.copyProperties(adminUser, baseUser);
                    //单独设置差异化的信息
                    baseUser.setCreateType(CreateTypeEnum.AUTH.getKey());
                    baseUser.setSrcCode(SrcCodeEnum.SRC_CODE_THIRD.getKey());
                    baseUser.setLastLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
                    baseUser.setLastLoginTime(new Date());
                    baseUser.setCurrentLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
                    baseUser.setCurrentLoginTime(new Date());
                    if (unionId != null) {
                        baseUser.setSpare1(unionId);
                    }
                    baseUser.setSpare2(authUser.getUuid());
                    baseUserService.save(baseUser);
                    //保存人员扩展信息
                    BaseUserExt baseUserExt = new BaseUserExt();
                    baseUserExt.setId(userId);
                    baseUserExt.setNickname(authUser.getNickname());
                    baseUserExt.setSex(authUser.getGender().getDesc());
                    baseUserExt.setImagePath(authUser.getAvatar());
                    baseUserExt.setWeiboId(authUser.getBlog());
                    baseUserExt.setIntro(authUser.getRemark());
                    baseUserExt.setComefrom(authUser.getLocation());
                    baseUserExt.setSpare1(authUser.getCompany());
                    baseUserExt.setSpare2(authUser.getSource());
                    baseUserExtService.save(baseUserExt);
                }
            }
        } else {
            //微信支付宝绑定同一个人的处理
            baseUser.setId(userId);
            //原有信息如果已经存在，则不更新
            if (baseUser.getSource() == null) {
                baseUser.setSource(coreAccount.getId());
            }
            baseUser.setCreateType(CreateTypeEnum.AUTH.getKey());
            baseUser.setSrcCode(SrcCodeEnum.SRC_CODE_THIRD.getKey());

            if (baseUser.getEmail() == null) {
                baseUser.setEmail(authUser.getEmail());
            }
            if (unionId != null) {
                if (baseUser.getSpare1() == null) {
                    baseUser.setSpare1(unionId);
                } else {
                    if (!baseUser.getSpare1().contains(unionId)) {
                        baseUser.setSpare1(baseUser.getSpare1() + ";" + unionId);
                    }
                }
            }

            if (baseUser.getSpare2() == null) {
                baseUser.setSpare2(authUser.getUuid());
            } else {
                if (!baseUser.getSpare2().contains(authUser.getUuid())) {
                    baseUser.setSpare2(baseUser.getSpare2() + ";" + authUser.getUuid());
                }
            }
            baseUser.setLastLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
            baseUser.setLastLoginTime(new Date());
            baseUser.setCurrentLoginIp(IPUtils.getIpAddr(ServletUtils.getRequest()));
            baseUser.setCurrentLoginTime(new Date());
            baseUserService.update(baseUser);

            BaseUserExt baseUserExt = baseUserExtService.findById(userId);
            baseUserExt.setId(userId);
            baseUserExt.setNickname(authUser.getNickname());
            baseUserExt.setSex(authUser.getGender().getDesc());
            baseUserExt.setImagePath(authUser.getAvatar());
            baseUserExt.setIntro(authUser.getRemark());
            baseUserExt.setComefrom(authUser.getLocation());
            baseUserExt.setWeiboId(authUser.getBlog());
            baseUserExt.setSpare1(authUser.getCompany());
            baseUserExt.setSpare2(authUser.getSource());
            baseUserExtService.update(baseUserExt);
        }

        //保存绑定记录
        ThirdMemberBind thirdMemberBind = thirdMemberBindService.findByUserIdAccountKey(userId,
            authUser.getUuid());
        if (thirdMemberBind == null) {
            thirdMemberBind = new ThirdMemberBind();
            thirdMemberBind.setMemberId(memberId);
            thirdMemberBind.setUserId(userId);
            thirdMemberBind.setUsername(authUser.getUsername());
            thirdMemberBind.setAccountId(coreAccount.getId());
            thirdMemberBind.setAccountKey(authUser.getUuid());
            thirdMemberBind.setBindTime(new Date());
            thirdMemberBind.setAdditionInfo(authUser.getRawUserInfo().toJSONString());
            thirdMemberBind.setDelFlag(DelFlagEnum.NORMAL.getKey());
            thirdMemberBind.setSpare1(authUser.getNickname());
            thirdMemberBindService.save(thirdMemberBind);
        } else {
            //当前用户可能解绑过，设置状态可用即可
            thirdMemberBind.setAccountId(coreAccount.getId());
            thirdMemberBind.setDelFlag(DelFlagEnum.NORMAL.getKey());
            thirdMemberBind.setSpare1(authUser.getNickname());
            thirdMemberBindService.update(thirdMemberBind);
        }

    }

    public void unBindFromSocial(String userId, String platformType) {
        CoreAccount coreAccount = coreAccountService.getByServerType(platformType);
        String accountId = "";
        if (coreAccount != null) {
            accountId = coreAccount.getId();
        }

        ThirdMember thirdMember = findByUserIdAccountId(userId, accountId);

        if (thirdMember != null && StringUtils.isNotBlank(accountId)) {
            //设置会员用户状态为应用锁定
            thirdMember.setDelFlag(DelFlagEnum.LOCKED.getKey());
            update(thirdMember);
            //设置会员用户绑定状态为应用锁定
            ThirdMemberBind thirdMemberBind = thirdMemberBindService.findByUserIdAccountId(userId,
                accountId);
            if (thirdMemberBind != null) {
                thirdMemberBind.setDelFlag(DelFlagEnum.LOCKED.getKey());
                thirdMemberBindService.update(thirdMemberBind);
            }
        }
    }

    /** find the entity by input id, return ThirdUserDto
     * 对象详情方法，通过id查询对象{@link ThirdUserDto}
     * @param id 主键ID|1
     * @return {@link ThirdUserDto}
     */
    public ThirdUserDto getThirdUserById(Long id) {
        return dao.getThirdUserById(id);
    }

    public ThirdUserDto getThirdUserByUserId(String userId) {
        return dao.getThirdUserByUserId(userId);
    }

    public ThirdUserDto getThirdUserByOpenId(String openId, String source) {
        return dao.getThirdUserByOpenId(openId, source);
    }

    public ThirdUserDto getThirdUserByUnionId(String unionId) {
        return dao.getThirdUserByUnionId(unionId);
    }

    /**
     * 根据手机号码获取会员信息
     * @param mobile    手机号码
     * @param source    来源
     * @return    第三方会员对象
     */

    public ThirdMember getByMobile(String mobile, String source) {
        //由于存在多条记录，此处需要处理
        List<ThirdMember> list = dao.getByMobile(mobile, source);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据账号获取会员信息
     * @param username  用户名
     * @param source    来源
     * @return    第三方会员对象
     */

    public ThirdMember getByUsername(String username, String source) {
        //由于存在多条记录，此处需要处理
        List<ThirdMember> list = dao.getByUsername(username, source);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据邮箱获取会员用户信息
     * @param email     邮箱地址
     * @param source    来源
     * @return    第三方会员对象
     */

    public ThirdMember getByEmail(String email, String source) {
        //由于存在多条记录，此处需要处理
        List<ThirdMember> list = dao.getByEmail(email, source);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 通过username, mobile, email获取对象
     * @param userkey   用户名邮箱或手机号码
     * @param source    来源
     * @return    第三方会员对象
     */

    public ThirdMember getByUserkey(String userkey, String source) {
        //由于存在多条记录，此处需要处理
        List<ThirdMember> list = dao.getByUserkey(userkey, source);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public Long getMemberId(String userId) {
        return dao.getMemberId(userId);
    }

}
