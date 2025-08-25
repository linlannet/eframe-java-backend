/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.mbiz;

/**
 * Filename:ApiIntfConfig.java
 * Desc:会员接口类前后端交互的常量配置类
 * @author Linlan
 * CreateTime:2018/11/2 14:06
 * @version 1.0
 * @since 1.0
 */
public abstract class ApiIntfConfig {

    /**
     * The Constant VALUE_MAX_COUNT. 默认最大列表返回数量
     * 1000：为了防止数据刻意获取，设定最大返回值为1000
     */
    public static final int    VALUE_MAX_COUNT              = 1000;
    /**
     * The Constant VALUE_DEFAULT. 默认缺省的字符串值
     * 0：全部，此条件忽略，表示全部数据
     */
    public static final String VALUE_DEFAULT                = "0";
    public static final String VALUE_DEFAULT_TRUE           = "1";

    /**
     * The Constant SOURCE. 数据来源，业务来源的值
     * 0或null：全部，此条件忽略；
     * 10：市民云数据来源FROM，用于接收数据；
     * 11：市民云数据来源TO，返回数据按照特定对象进行返回；
     */
    public static final String VALUE_SOURCE_SMY             = "11";

    /**
     * The Constant ACTIONTYPE. 操作类型的值
     * 0或null：全部，此条件忽略；
     * 10：增加、新增，同add，save，new等；
     */
    public static final String VALUE_AT_ADD                 = "10";
    /**
     * 复制
     */
    public static final String VALUE_AT_COPY                = "11";
    /**
     * 批量新增
     */
    public static final String VALUE_AT_BATCH_ADD           = "12";
    /**
     * 20：修改保存，同update，modify。21-29可表示修改保存操作的各个流程环节，如初审、审核、审批、终审、回退、立案、复核、处置、核查、结案等各个环节的状态修改业务。
     */
    public static final String VALUE_AT_UPDATE              = "20";
    /**
     * 21：外部更新
     */
    public static final String VALUE_AT_OTUPDATE            = "21";
    /**
     * 31：认领、授权、上架
     */
    public static final String VALUE_AT_GRAND_DUTY          = "31";
    /**
     * 32：取消认领、取消授权、下架
     */
    public static final String VALUE_AT_REVOKE_DUTY         = "32";
    /**
     * 40：删除，设置删除标记。
     */
    public static final String VALUE_AT_DELETE              = "40";
    /**
     * 50：为其他特殊操作。
     */
    public static final String VALUE_AT_OTHER               = "50";
    /**
     * 51：导入
     */
    public static final String VALUE_AT_IMPORT              = "51";
    /**
     * 52：导出
     */
    public static final String VALUE_AT_EXPORT              = "52";
    /**
     * 53：绑定
     */
    public static final String VALUE_AT_BIND                = "53";
    /**
     * 54：解绑
     */
    public static final String VALUE_AT_UNBIND              = "54";

    /**
     * The Constant TYPE. type值的定义
     * 在其他地方的应用，type可区分内部、外部，在线、离线等条件拆分，采用10以内的数字表示
     *             1：在线方式；
     *             2：离线方式；
     * 在二维码的应用，type可区分场景的子类，1为服务2为推荐
     *             1：场景的服务项，包括BANNER等；
     *             2：场景等业务项，包括办理点，活动点等；
     */
    public static final String VALUE_TYPE_A                 = "1";
    public static final String VALUE_TYPE_B                 = "2";
    public static final String VALUE_TYPE_C                 = "3";
    public static final String VALUE_TYPE_D                 = "4";
    public static final String VALUE_TYPE_E                 = "5";
    public static final String VALUE_TYPE_F                 = "6";
    public static final String VALUE_TYPE_G                 = "7";
    public static final String VALUE_TYPE_H                 = "8";
    public static final String VALUE_TYPE_Z                 = "9";

    /**
     * The Constant SUB_TYPE. 根据type细分后的子类类型
     * 采用1-2位数字表示，区分业务中台的每个业务服务的业务类型的下级类型，该参数用于GET和POST的读、写上。
     *             0或null，全部，此条件忽略；
     *             10业务内的分类，如站点，栏目，事件类型等；
     */
    //type为SM：31时，表示站点
    //type为SA：40时，表示栏目
    //type为NGS：44时，表示网格时间
    public static final String VALUE_SUB_TYPE_BIZ1          = "11";
    public static final String VALUE_SUB_TYPE_BIZ2          = "12";
    public static final String VALUE_SUB_TYPE_BIZ3          = "13";

    /**
     * 地域编码，通地域ID，采用国标六位编码
     *     采用6-12位数字表示，区分业务中台的每个业务服务的数据所涉及的地域编码条件，6位编码与国标的行政区划一致。9-12位的编码采用现有街道、居委等编码规则。
     *     在查询数据时，可结合dataRange一起使用。
     */
    public static final String VALUE_AREACODE_DEFAULT       = "000000";
    public static final String VALUE_CHANNEL_JINGAN_DEFAULT = "159972619624292";
    /**
     * 排序方式
     * 采用1-2位数字表示，区分业务中台的每个业务服务的查询数据是排序操作。涉及主要的范围为GET读（entry类）操作。orderBy：排序方式，默认1。
     * 通用信息的orderBy
     * 0：ID降序
     * 1：ID升序
     * 2：创建时间CREATE_TIME降序
     * 3：创建时间CREATE_TIME升序
     * 4：排序码PRIORITY降序
     * 5：排序码PRIORITY升序
     * 6：排序字段等降序，如SEARCH_CODE，SHORTCALL，KEYWORDS
     * 7：排序字段等升序，如SEARCH_CODE，SHORTCALL，KEYWORDS
     * 11：业务字段1降序，如国家地区内的NAME，TITLE，CHANNEL_NAME
     * 12：业务字段1升序，如国家地区内的NAME
     * 13：业务字段2降序，如国家地区内的SNAME，FIELDNAME，PATH
     * 14：业务字段2升序，如国家地区内的SNAME
     * 15：业务字段3降序，如国家地区内的NAME_EN
     * 16：业务字段3升序，如国家地区内的NAME_EN
     * 17：业务字段4降序
     * 18：业务字段4升序
     * 内容发布的orderBy
     * 0：ID降序
     * 1：ID升序
     * 2：发布时间降序
     * 3：发布时间升序
     * 4：置顶级别降序，发布时间降序
     * 5：置顶级别降序，发布时间升序
     * 6：日访问降序（推荐）
     * 7：周访问降序
     * 8：月访问降序
     * 9：总访问降序
     * 10：日评论降序（推荐）
     * 11：周评论降序
     * 12：月评论降序
     * 13：总评论降序
     * 14：日下载降序（推荐）
     * 15：周下载降序
     * 16：月下载降序
     * 17：总下载降序
     * 18：日顶降序（推荐）
     * 19：周顶降序
     * 20：月顶降序
     * 21：总顶降序
     * 22：按照栏目编号升序。
     */
    public static final String VALUE_ORDERBY_DEFAULT        = "0";

    /**
     * The Constant LIMIT，或pageSize，每页多少条
     * 采用数字表示，区分业务中台的每个业务服务的数据获取数量或者限制条数，涉及主要的范围为GET读（entry类）操作。
     * 0或null：采用默认值，一般列表为10，文章等为3。
     * Num：具体数字，表示需要获取的数据条数。
     */
    public static final int    LIMIT                        = 10;

    /**
     * The Constant PAGE，或currPage，当前页面数
     * 采用数字表示，区分业务中台的每个业务服务的数据获取按照分页模式的当前页面，从当前页面获取limit或者count的记录数量，涉及主要的范围为GET读（entry类）操作。
     * 0或null：采用默认值，一般为1。
     * Num：具体数字，表示需要开始的页面数。
     */
    public static final String VALUE_PAGE_DEFAULT           = "1";
    public static final int    CURR_PAGE                    = 1;

    /**
     * 默认xy范围
     */
    public static final String VALUE_XY_DEFAULT             = "1";

    /**
     * 成功标记
     */
    public static final String SUCCESS                      = "操作成功";
    /**
     * 失败标记
     */
    public static final String FAILURE                      = "操作失败";

}
