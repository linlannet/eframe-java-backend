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
package net.linlan.sys.base.entity;

import java.util.Date;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.base.constant.AppTypeEnum;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * BaseApp数据域:应用信息实体类
 * @author Linlan
* CreateTime 2018-03-02 17:17:54
 *
 */
@Data
public class BaseApp extends BaseEntity {

    /**
     * 应用ID
     */
    private String  id;

    /**
     * 文件上传配置ID
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
     * 应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选
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
     * 排序
     */
    private Integer priority;

    /**
     * 删除标记0正常1已删除2应用内受限3回收站
     */
    private Integer delFlag;

    /**
     * 删除时间
     */
    private Date    deleteTime;

    /**
     * 描述
     */
    private String  description;

    /**
     * 备用1，LOGO图标
     */
    private String  spare1;

    /**
     * 备用2
     */
    private String  spare2;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomSid());
        }
        if (getAppType() == null) {
            setAppType(AppTypeEnum.QUANBU.getKey());
        }
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
        if (getDelFlag() == null) {
            setDelFlag(KernelConstant.DEL_FLAG_DEFAULT);
        }
    }

}
