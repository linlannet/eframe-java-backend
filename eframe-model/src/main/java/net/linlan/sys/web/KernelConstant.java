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
package net.linlan.sys.web;

import net.linlan.commons.core.CharsetUtils;
import net.linlan.commons.core.StringUtils;

/**
 * Filename:KernelConstants.java
 * Desc:系统支撑的后台常量类，定义常量为后续各包应用提供统一管理
 *
 * @author Linlan
 * CreateTime:2017/10/18 21:33
 * @version 1.0
 * @since 1.0
 */
public class KernelConstant {

    /**
     * the default chartset name
     */
    public static final String  UTF8                    = CharsetUtils.UTF_8;

    /**
     * 超级管理员ID
     */
    public static final long    SUPER_ADMIN             = 1;
    public static final String  SUPER_SYS               = "7890d4se-ae5x-11fb-b488-00163e4231ec";

    /**
     * default site id
     */
    public static final long    DEFAULT_SITE_ID         = 1;
    /**
     * default app id
     */
    public static final String  DEFAULT_APP_ID          = "PA-STAGE";

    /**
     * 缺省的产品域APP_ID前缀
     */
    public static final String  DEFAULT_APP_PREFIX      = "EFRAME-";
    /**
     * default 页码
     */
    public static final int     DEFAULT_PAGE            = 1;

    /**
     * default page count 10
     */
    public static final int     DEFAULT_PAGECOUNT       = 10;

    /**
     * 数据禁用缺省值
     */
    public static final boolean DEFAULT_DISABLED        = false;
    /**
     * 数据量
     */
    public static final int     DEFAULT_COUNT           = 1;

    /**
     * default display, true 1 show, false 0 hide
     */
    public static final boolean DEFAULT_DISPLAY         = true;
    /**
     * 数据排序码缺省值
     */
    public static final int     DEFAULT_PRIORITY        = 10;

    /**
     * 缺省整形值，0
     */
    public static final int     DEFAULT_INT             = 0;
    /**
     * 缺省长整形值，0L
     */
    public static final long    DEFAULT_BIGINT          = 0L;
    /**
     * 缺省DOUBLE值，0.00D
     */
    public static final double  DEFAULT_DOUBLE          = 0.00D;
    /**
     * 缺省布尔值，false
     */
    public static final boolean DEFAULT_BOOLEAN         = false;

    /**
     * 默认过期时长，单位：秒，5秒
     */
    public final static long    FIVE_SECOND_EXPIRE      = 5;
    /**
     * 默认过期时长，单位：秒， 20秒
     */
    public final static long    TWENTY_SECOND_EXPIRE    = 20;

    /**
     * 默认过期时长，单位：秒， 60秒，1分钟
     */
    public final static long    ONE_MINUTE_EXPIRE       = 60;

    /**
     * 默认过期时长，单位：秒，10分钟
     */
    public final static long    TEN_MINUTE_EXPIRE       = ONE_MINUTE_EXPIRE * 10;

    /**
     * 默认过期时长，单位：秒，1小时
     */
    public final static long    ONE_HOUR_EXPIRE         = 6 * TEN_MINUTE_EXPIRE;

    /**
     * 默认过期时长，单位：秒， 1天
     */
    public final static long    ONE_DAY_EXPIRE          = ONE_HOUR_EXPIRE * 24;

    /**
     * 默认过期时长，单位：秒，30天
     */
    public final static long    THIRTY_DAY_EXPIRE       = 30 * ONE_DAY_EXPIRE;

    /**
     * 默认过期时长，单位：天
     */
    public final static int     THIRTY_DAY              = 30;

    /**
     * 不设置过期时长
     */
    public final static long    NOT_EXPIRE              = -1;

    /** The user，用户对象 type admin. 管理用户*/
    public static int           USER_TYPE_ADMIN         = 0;

    /** The user，用户对象 type member. 会员用户*/
    public static int           USER_TYPE_MEMBER        = 1;

    /** The src code web. WEB端网页访问和登录来源*/
    /** The src code mini. 后台中台授权登录*/
    public static int           SRC_CODE_DEFAULT        = 10;

    /** runnable flag. 自动执行标记*/
    public static String        RUNNABLE_FLAG           = "AUTO";

    /** 上传文件的目录*/
    public static String        UPLOAD_PATH             = "/u";

    /** 文件路径标记符 */
    public static String        SPT                     = StringUtils.SLASH;

    /**
     * default resclassId, 缺省的文件类型ID
     */
    public static final String  DEFAULT_RESCLASS_ID     = "RES-FILE";

    /**
     * default nameMode, 1登录用户名2手机3昵称4真名
     */
    public static final Integer DEFAULT_NAME_MODE       = 1;

    /**
     * baseUser创建来源类型：后台
     */
    public static final Integer SOURCE_TYPE_ADMIN       = 0;
    /**
     * baseUser创建来源类型：前台
     */
    public static final Integer SOURCE_TYPE_FRONT       = 1;

    /**
     * 用户激活
     */
    public static final Integer ACTIVATION_STATUS_YES   = 1;

    /**
     * 用户未激活
     */
    public static final Integer ACTIVATION_STATUS_NO    = 0;

    /**
     * 默认初始化密码，简单
     */
    public static final String  DEFAULT_PASSWORD_NORMAL = "Eframe_123456!";

    /**
     * 删除标记：delFlag
     */
    public static final String  FIELD_DEL_FLAG          = "delFlag";
    /**
     * 状态标记：status
     */
    public static final String  FIELD_STATUS            = "status";
    /**
     * 禁用标记：isDisabled
     */
    public static final String  FIELD_IS_DISABLED       = "isDisabled";
    /**
     * 缺省标记：isDefault
     */
    public static final String  FIELD_IS_DEFAULT        = "isDefault";
    /**
     * 显示标记：isDisplay
     */
    public static final String  FIELD_IS_DISPLAY        = "isDisplay";

    /**
     * 最大错误次数
     */
    public static final int     ERROR_COUNT_LIMIT       = 6;

    /**
     * 默认证件类型，身份证为1908
     */
    public static final String  DEFAULT_ID_TYPE         = "shenfenzheng";

    //--------------------各种配置项的key值---------------------------------

    public static void main(String[] args) {

    }

}
