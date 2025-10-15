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
package net.linlan.sys.base.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * BaseUser数据域:统一用户表查询参数实体类
 * @author Linlan
 * CreateTime 2023-08-12 13:37:57 *
 */
@Data
public class BaseUserParam extends BaseParam {

    /**
    * 行政区划编号，用户来源地
    */
    private Long     xzqhId;
    /**
    * 创建来源类型1后台，2前台，101网格化201公众号
    */
    private Integer  source;
    /**
    * 创建方式0导入1录入2授权
    */
    private Integer  createType;
    /**
    * 用户名，城市APP市民云的用户名
    */
    private String   username;
    /**
    * 手机号码
    */
    private String   mobile;
    /**
    * 电子邮箱
    */
    private String   email;
    /**
    * 当前来源0缺省1:WEB或PC,2APP21:AndroidAPP,22:IOSAPP,3WAP,4MINI
    */
    private Integer  srcCode;
    /**
    * 注册时间
    */
    private Date     registerTime;
    /**
    * 最后登录的应用ID
    */
    private String   lastAppId;
    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer  delFlag;
    /**
    * 描述
    */
    private String   description;
    /**
    * 备用1，第三方的平台的用户名，如随申办统一身份体系的用户名
    */
    private String   spare1;
    /**
    * 备用2，第三方用户ID，OpenId
    */
    private String   spare2;
    /**
     * 关键字
     */
    private String   key;
    /**
     * 绑定机构ID
     */
    private String   bindOrganId;
    /**
     * 绑定机构类型
     */
    private String   bindOrganType;
    /**
     * 绑定站点用户
     */
    private String   isBindFrontUser;
    /**
     * 关键字
     */
    private String   createTime;
    /**
     * 搜索编码
     */
    private String   searchCode;
    /**
     * 用户编号
     */
    private String   workUserId;
    /**
     * id集合
     */
    private String[] ids;
}
