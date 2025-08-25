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
package net.linlan.sys.comm.entity;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.base.constant.SrcCodeEnum;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * CommLog数据域:管理日志表实体类
 * @author Linlan
 * CreateTime 2018-03-02 17:26:29
 *
 */
@Data
public class CommLog extends BaseEntity {

    /**
     * 后台管理日志类型，缺省
     */
    public static int CATEGORY_ADMIN     = SrcCodeEnum.SRC_CODE_DEFAULT.getKey();
    /**
     * 后台平台对接日志类型
     */
    public static int CATEGORY_PLAT      = SrcCodeEnum.SRC_CODE_THIRD.getKey();
    /**
     * 前台业务类型，10
     */
    public static int CATEGORY_BUSINESS  = SrcCodeEnum.SRC_CODE_WEB.getKey();
    /**
     * 前台单点登录类型，11
     */
    public static int CATEGORY_SSOLOGIN  = SrcCodeEnum.SRC_CODE_WEB_SSO.getKey();
    /**
     * 前台运营类型，12
     */
    public static int CATEGORY_OPERATION = SrcCodeEnum.SRC_CODE_WEB_OPERATION.getKey();
    /**
     * 前台租户类型，13
     */
    public static int CATEGORY_RENTUSER  = SrcCodeEnum.SRC_CODE_WEB_RENTUSER.getKey();

    /**
     * 其他日志类型
     */
    public static int CATEGORY_OTHER     = SrcCodeEnum.SRC_CODE_OTH.getKey();

    /**
    * 日志ID
    */
    private Long      id;

    /**
    * 应用ID
    */
    private String    appId;

    /**
    * 用户名
    */
    private String    username;

    /**
    * 日志类型
    */
    private Integer   category;

    /**
    * 操作
    */
    private String    operation;

    /**
    * 方法
    */
    private String    method;

    /**
    * 访问的路径地址详情
    */
    private String    params;

    /**
    * 当前登录来源
    */
    private Integer   srcCode;

    /**
    * 来访IP地址
    */
    private String    ip;

    /**
    * 执行时长
    */
    private Long      time;

    /**
    * 备用1
    */
    private String    spare1;

    /**
    * 备用1
    */
    private String    spare2;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }
        if (getCategory() == null) {
            setCategory(CATEGORY_BUSINESS);
        }
        if (getSrcCode() == null) {
            setSrcCode(CATEGORY_BUSINESS);
        }
    }

}
