/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.sys.manager;

import java.sql.Timestamp;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.view.sys.service.FrameDictionaryService;
import net.linlan.sys.base.constant.DelFlagEnum;
import net.linlan.sys.base.entity.BaseOrgan;
import net.linlan.sys.base.entity.BaseOrganExt;
import net.linlan.sys.base.service.BaseOrganExtService;
import net.linlan.sys.base.service.BaseOrganService;
import net.linlan.sys.core.dto.OrganBaseInfoDto;
import net.linlan.sys.core.entity.CoreOrgan;
import net.linlan.sys.core.param.OrganAccountParam;
import net.linlan.sys.core.service.CoreAccountService;
import net.linlan.sys.core.service.CoreOrganService;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.exception.CommonException;

/**
 * SasPubOrganMemberService视图域: SA应用域内机构公共读取服务类
 * Desc:SA应用域内管理机构、服务机构、机构个性化、机构旗舰店等读取业务逻辑
 *
 * @author Linlan
 * CreateTime 2020-08-19 10:40:58
 * @version 1.0
 * @since 1.0
 */
@Service
public class FrameOrganManager {
    @Resource
    private CoreAccountService     coreOrganEntService;
    @Resource
    private CoreOrganService       coreOrganService;
    @Resource
    private BaseOrganService       baseOrganService;
    @Resource
    private BaseOrganExtService    baseOrganExtService;
    @Resource
    private FrameDictionaryService frameDictionaryService;

    /**
     * 系统机构列表
     * @param params    查询参数
     * @return  查询结果
     */
    public Page<OrganBaseInfoDto> getCoreOrganList(OrganAccountParam params) {
        Page<OrganBaseInfoDto> result = coreOrganEntService.getCoreOrganList(params);
        Map<String, String> organTypeMap = frameDictionaryService.getDictionaryList("WL_TYPE");
        for (OrganBaseInfoDto organBaseInfoDto : result) {
            String wlTypeName = getWlType(organTypeMap, organBaseInfoDto.getWlType());
            organBaseInfoDto.setWlTypeName(wlTypeName);
        }
        return result;
    }

    private String getWlType(Map<String, String> map, String wlType) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(wlType)) {
            String[] aa = wlType.split(",");
            if (aa == null || aa.length == 0) {
                return null;
            }
            for (String str : aa) {
                String a = map.get(str);
                if (StringUtils.isNotEmpty(a)) {
                    sb.append(a + ",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return null;
    }

    /**
     * 机构详情
     * @param organId  机构ID
     * @return  查询结果
     */
    public OrganBaseInfoDto getOrganDetail(String organId) {
        OrganBaseInfoDto coreOrganInfo = coreOrganEntService.getCoreOrganInfo(organId);
        Map<String, String> organTypeMap = frameDictionaryService.getDictionaryList("WL_TYPE");
        String wlTypeName = getWlType(organTypeMap, coreOrganInfo.getWlType());
        coreOrganInfo.setWlTypeName(wlTypeName);
        return coreOrganInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean doCoreOrganOperation(OrganBaseInfoDto dto,
                                        String actionType) throws CommonException {
        if (ApiIntfConfig.VALUE_AT_ADD.equals(actionType)) {//新增
            String organId = RandomUtils.UUID32();
            setOrganData(dto, organId);
            return true;
        } else if (ApiIntfConfig.VALUE_AT_UPDATE.equals(actionType)) {//修改——重新申请
            if (dto != null && dto.getOrganId() != null) {
                getOrganData(dto, dto.getOrganId());
            }
            return true;
        } else if (ApiIntfConfig.VALUE_AT_DELETE.equals(actionType)) {// 40 2 删除
            if (dto.getIds() != null && dto.getIds().length > 0) {
                String[] ids = dto.getIds();
                for (String organId : ids) {
                    CoreOrgan coreOrgan = new CoreOrgan();
                    coreOrgan.setId(organId);
                    coreOrgan.setDelFlag(DelFlagEnum.LOCKED.getKey());

                    BaseOrgan baseOrgan = new BaseOrgan();
                    baseOrgan.setId(organId);
                    baseOrgan.setLastTime(new Timestamp(System.currentTimeMillis()));
                    baseOrgan.setDelFlag(DelFlagEnum.LOCKED.getKey());

                    BaseOrganExt baseOrganExt = new BaseOrganExt();
                    baseOrganExt.setId(organId);
                    baseOrganExt.setEstablishDate(new Date());
                    baseOrgan.setBaseOrganExt(baseOrganExt);
                    coreOrgan.setBaseOrgan(baseOrgan);
                    coreOrganService.update(coreOrgan);

                }
                return true;
            }
        } else if (ApiIntfConfig.VALUE_AT_OTHER.equals(actionType)) {//50  1停用，0启用,2已删除
            if (dto.getDelFlag() != null) {
                String organId = dto.getOrganId();
                CoreOrgan coreOrgan = new CoreOrgan();
                coreOrgan.setId(organId);
                coreOrgan.setDelFlag(dto.getDelFlag());

                BaseOrgan baseOrgan = new BaseOrgan();
                baseOrgan.setId(organId);
                baseOrgan.setDelFlag(dto.getDelFlag());

                BaseOrganExt baseOrganExt = new BaseOrganExt();
                baseOrganExt.setId(organId);
                baseOrganExt.setEstablishDate(new Date());
                baseOrgan.setBaseOrganExt(baseOrganExt);
                coreOrgan.setBaseOrgan(baseOrgan);
                coreOrganService.update(coreOrgan);
                return true;
            }
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    public void setOrganData(OrganBaseInfoDto dto, String organId) throws CommonException {
        BaseOrgan baseOrgan = new BaseOrgan();
        baseOrgan = new BaseOrgan();
        baseOrgan.setName(dto.getOrganName());
        baseOrgan.setUnionCode(dto.getOrganCode());
        baseOrgan.setSpare1(dto.getOrganSName());
        baseOrgan.setDelFlag(dto.getDelFlag());
        if (dto.getDelFlag() != null) {
            baseOrgan.setDelFlag(dto.getDelFlag());
        }
        baseOrgan.setCreateType(KernelConstant.SOURCE_TYPE_ADMIN);
        baseOrgan.setSource(KernelConstant.SOURCE_TYPE_ADMIN);
        baseOrgan.setPriority(dto.getPriority());
        baseOrgan.setDescription(dto.getDescription());

        BaseOrganExt baseOrganExt = new BaseOrganExt();
        baseOrganExt.setNamePy(dto.getOrganName());
        baseOrganExt.setSname(dto.getOrganSName());
        baseOrganExt.setNameEn(dto.getOrganName());
        baseOrganExt.setTel(dto.getTel());

        baseOrganExt.setContactName(dto.getContactName());
        baseOrganExt.setContactEmail(dto.getContactEmail());
        baseOrganExt.setContactMobile(dto.getContactMobile());
        baseOrganExt.setAddress(dto.getAddress());
        baseOrganExt.setDescription(dto.getDescription());

        boolean isVirtual = false;
        CoreOrgan coreOrgan = new CoreOrgan();
        coreOrgan.setId(organId);
        coreOrgan.setIsVirtual(isVirtual);
        coreOrgan.setOrganType(dto.getWlType());
        coreOrgan.setPriority(dto.getPriority());
        coreOrgan.setIsAdmin(KernelConstant.DEFAULT_DISPLAY);
        coreOrgan.setIsMember(KernelConstant.DEFAULT_BOOLEAN);
        coreOrgan.setIsDisabled(KernelConstant.DEFAULT_DISABLED);
        coreOrgan.setDelFlag(dto.getDelFlag());
        baseOrgan.setBaseOrganExt(baseOrganExt);
        coreOrgan.setBaseOrgan(baseOrgan);
        coreOrganService.save(coreOrgan);
    }

    public void getOrganData(OrganBaseInfoDto dto, String organId) throws CommonException {
        BaseOrgan baseOrgan = baseOrganService.findById(organId);
        if (ObjectUtils.isEmpty(baseOrgan)) {
            throw new CommonException("机构id错误");
        }
        baseOrgan.setName(dto.getOrganName());
        baseOrgan.setUnionCode(dto.getOrganCode());
        baseOrgan.setSpare1(dto.getOrganSName());
        baseOrgan.setDelFlag(dto.getDelFlag());
        if (dto.getDelFlag() != null) {
            baseOrgan.setDelFlag(dto.getDelFlag());
        }
        baseOrgan.setCreateType(KernelConstant.SOURCE_TYPE_ADMIN);
        baseOrgan.setSource(KernelConstant.SOURCE_TYPE_ADMIN);
        baseOrgan.setPriority(dto.getPriority());
        baseOrgan.setDescription(dto.getDescription());

        BaseOrganExt baseOrganExt = baseOrganExtService.findById(organId);
        baseOrganExt.setNamePy(dto.getOrganName());
        baseOrganExt.setSname(dto.getOrganSName());
        baseOrganExt.setNameEn(dto.getOrganName());
        baseOrganExt.setTel(dto.getTel());

        baseOrganExt.setContactName(dto.getContactName());
        baseOrganExt.setContactEmail(dto.getContactEmail());
        baseOrganExt.setContactMobile(dto.getContactMobile());
        baseOrganExt.setAddress(dto.getAddress());
        baseOrganExt.setDescription(dto.getDescription());

        boolean isVirtual = false;
        baseOrgan.setBaseOrganExt(baseOrganExt);

        CoreOrgan coreOrgan = coreOrganService.findById(organId);
        coreOrgan.setId(organId);
        coreOrgan.setIsVirtual(isVirtual);
        coreOrgan.setOrganType(dto.getWlType());
        coreOrgan.setPriority(dto.getPriority());
        coreOrgan.setIsAdmin(KernelConstant.DEFAULT_DISPLAY);
        coreOrgan.setIsMember(KernelConstant.DEFAULT_BOOLEAN);
        coreOrgan.setIsDisabled(KernelConstant.DEFAULT_DISABLED);
        coreOrgan.setDelFlag(dto.getDelFlag());
        coreOrgan.setBaseOrgan(baseOrgan);
        coreOrganService.update(coreOrgan);

    }

}
