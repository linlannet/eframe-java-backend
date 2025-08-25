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
package net.linlan.frame.view.sys.param;

import lombok.Data;

import net.linlan.sys.base.param.BaseAppParam;
import net.linlan.utils.param.BaseParam;

@Data
public class BaseAppVoParam extends BaseParam {
    /**
     * 资源存储ID
     */
    private String  ftpId;
    /**
     * 域平台编号
     */
    private String  domainId;
    /**
     * 单位编码，所属单位，管理单位
     */
    private String  organId;
    /**
     * 应用适用顶级行政区划ID
     */
    private Long    xzqhId;
    /**
     * 应用服务类型ID
     */
    private String  sertypeId;
    /**
     * 应用名称
     */
    private String  name;
    /**
     * 应用访问路径
     */
    private String  path;
    /**
     * 应用类型，B/S，C/S
     */
    private String  appType;
    /**
     * 是否站点，如果是站点，则SITE内存在记录
     */
    private Boolean isSite;
    /**
     * 是否禁用0否1是
     */
    private Boolean isDisabled;
    /**
     * 是否为复杂权限应用0否（一般应用APP应用）1是
     */
    private Boolean isMobileApp;
    /**
     * 状态0异常关闭1正常2升级3锁定
     */
    private Integer status;
    /**
     * 删除标记0正常1已删除2应用内受限3回收站
     */
    private Integer delFlag;
    /**
     * 描述
     */
    private String  description;
    /**
     * 关键字查询，以前的保留，以后用q
     */
    private String  existKey;
    /**
     * 模式
     */
    private Integer mode;
    /**
     *
     */
    private String  ids[];
    /**
     * id字符串
     */
    private String  idArr;

    public BaseAppVoParam(String ftpId, String domainId, String organId, Long xzqhId,
                          String sertypeId, String name, String path, String appType,
                          Boolean isSite, Boolean isDisabled, Boolean isMobileApp, Integer status,
                          Integer delFlag, String description, String existKey, Integer mode,
                          String[] ids, String idArr) {
        this.ftpId = ftpId;
        this.domainId = domainId;
        this.organId = organId;
        this.xzqhId = xzqhId;
        this.sertypeId = sertypeId;
        this.name = name;
        this.path = path;
        this.appType = appType;
        this.isSite = isSite;
        this.isDisabled = isDisabled;
        this.isMobileApp = isMobileApp;
        this.status = status;
        this.delFlag = delFlag;
        this.description = description;
        this.existKey = existKey;
        this.mode = mode;
        this.ids = ids;
        this.idArr = idArr;
    }

    public BaseAppParam toModelParam() {
        BaseAppParam result = new BaseAppParam();
        result.setFtpId(ftpId);
        result.setDomainId(domainId);
        result.setOrganId(organId);
        result.setXzqhId(xzqhId);
        result.setSertypeId(sertypeId);
        result.setName(name);
        result.setPath(path);
        result.setAppType(appType);
        result.setIsSite(isSite);
        result.setIsDisabled(isDisabled);
        result.setIsMobileApp(isMobileApp);
        result.setStatus(status);
        result.setDelFlag(delFlag);
        result.setDescription(description);
        result.setExistKey(existKey);
        result.setMode(mode);
        result.setIds(ids);
        result.setQ(super.getQ());
        result.setOrderBy(super.getOrderBy());
        result.setStartTime(super.getStartTime());
        result.setEndTime(super.getEndTime());
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        return result;
    }

}
