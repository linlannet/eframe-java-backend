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
package net.linlan.frame.view.sys.vo;

import java.util.Date;
import java.util.LinkedHashMap;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.commons.core.StringUtils;
import net.linlan.frame.comm.utils.EnumUtil;
import net.linlan.sys.base.constant.AppStatusEnum;
import net.linlan.sys.base.dto.BaseAppDto;
import net.linlan.sys.base.entity.BaseApp;

@Data
public class BaseAppVo {

    /**
     * 应用ID
     */
    private String                        id;
    /**
     * 文件上传配置ID
     */
    private String                        ftpId;
    /**
     * 资源仓库名称
     */
    private String                        ftpName;
    /**
     * 域平台编号
     */
    private String                        domainId;
    /**
     * 域平台名称
     */
    private String                        domainName;
    /**
     * 单位编码，所属单位，管理单位
     */
    private String                        organId;
    /**
     * 机构名称
     */
    private String                        organName;
    /**
     * 应用适用顶级行政区划ID
     */
    private Long                          xzqhId;
    /**
     * 应用适用顶级行政区划名称
     */
    private String                        xzqhName;
    /**
     * 应用服务类型ID
     */
    private String                        sertypeId;
    /**
     * 服务类型名称
     */
    private String                        sertypeName;
    /**
     * 应用名称
     */
    private String                        name;
    /**
     * 应用访问路径
     */
    private String                        path;
    /**
     * 应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选
     */
    private String                        appType;
    /**
     * 是否站点，如果是站点，则SITE内存在记录
     */
    private Boolean                       isSite;
    /**
     * 是否启用0否1是
     */
    private Boolean                       isOpen;
    /**
     * 是否为复杂权限应用0否（一般应用APP应用）1是
     */
    private Boolean                       isMobileApp;
    /**
     * 状态0异常关闭1正常2升级3锁定
     */
    private Integer                       status;
    /**
     * 状态，0异常关闭1正常2升级
     */
    private String                        statusName;
    /**
     * 排序
     */
    private Integer                       priority;
    /**
     * 创建时间
     */
    private Date                          createTime;
    /**
     * 描述
     */
    private String                        description;
    /**
     * 备用1，LOGO图标
     */
    private String                        spare1;

    private LinkedHashMap<String, String> statusMap = EnumUtil.enumToMap(AppStatusEnum.class);

    /**
     * 无参构造
     */
    public BaseAppVo() {

    }

    /**
     * 数据赋值TO方法，将BaseApp的input对象赋值给BaseAppEntVo
     */
    public static final Function TO = new Function<BaseApp, BaseAppVo>() {
        @Nullable
        @Override
        public BaseAppVo apply(@Nullable BaseApp input) {
            return new BaseAppVo(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseAppVo(BaseApp input) {
        this.id = input.getId();
        this.ftpId = input.getFtpId();
        this.domainId = input.getDomainId();
        this.organId = input.getOrganId();
        this.xzqhId = input.getXzqhId();
        this.sertypeId = input.getSertypeId();
        this.name = input.getName();
        this.path = input.getPath();
        this.appType = input.getAppType();
        this.isSite = input.getIsSite();
        if (input.getIsDisabled() != null) {
            this.isOpen = !input.getIsDisabled();
        } else {
            this.isOpen = true;
        }
        this.isMobileApp = input.getIsMobileApp();
        this.status = input.getStatus();
        this.createTime = input.getCreateTime();
        this.description = input.getDescription();
        this.spare1 = input.getSpare1();
    }

    /**
     * 数据赋值DTO方法，将BaseAppDto的input对象赋值给BaseAppEntVo
     */
    public static final Function DTO = new Function<BaseAppDto, BaseAppVo>() {
        @Nullable
        @Override
        public BaseAppVo apply(@Nullable BaseAppDto input) {
            return new BaseAppVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseAppVo(BaseAppDto input) {
        this.id = input.getId();
        this.ftpId = input.getFtpId();
        this.domainId = input.getDomainId();
        this.organId = input.getOrganId();
        this.xzqhId = input.getXzqhId();
        this.xzqhName = input.getXzqhName();
        this.sertypeId = input.getSertypeId();
        this.name = input.getName();
        this.path = input.getPath();
        this.appType = input.getAppType();
        this.isSite = input.getIsSite();
        if (input.getIsDisabled() != null) {
            this.isOpen = !input.getIsDisabled();
        } else {
            this.isOpen = true;
        }
        this.isMobileApp = input.getIsMobileApp();
        this.status = input.getStatus();
        this.statusName = statusMap.get(input.getStatus() + "");
        this.priority = input.getPriority();
        this.createTime = input.getCreateTime();
        this.description = input.getDescription();
        this.spare1 = input.getSpare1();
    }

    public static BaseApp transTo(BaseAppVo input) {
        BaseApp result = new BaseApp();
        if (StringUtils.isNotEmpty(input.getId())) {
            result.setId(input.getId());
        }
        result.setId(input.getId());
        result.setFtpId(input.getFtpId());
        result.setDomainId(input.getDomainId());
        result.setOrganId(input.getOrganId());
        result.setXzqhId(input.getXzqhId());
        result.setSertypeId(input.getSertypeId());
        result.setName(input.getName());
        result.setPath(input.getPath());
        result.setAppType(input.getAppType());
        result.setIsSite(input.getIsSite());
        if (input.getIsOpen() != null) {
            result.setIsSite(input.getIsOpen());
        } else {
            result.setIsSite(false);
        }
        result.setIsMobileApp(input.getIsMobileApp());
        result.setStatus(input.getStatus());
        result.setPriority(input.getPriority());
        result.setCreateTime(input.getCreateTime());
        result.setDescription(input.getDescription());
        result.setSpare1(input.getSpare1());

        return result;
    }

}
