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
package net.linlan.sys.base.dto;

import lombok.Data;

/**
 *
 * BaseApp,应用信息表查询结果应用配置详情Dto对象
 * @author Linlan
 * CreateTime 2021-08-16 11:12:25
 *
 */
@Data
public class BaseAppInfoDto extends BaseAppDto {
    /**
     * hcday add 2018-04-17
     */
    /**
     * 全局文件上传服务器名称
     */
    private String ftpName;
    /**
     * 服务类型名称
     */
    private String sertypeName;
    /**
     * 域平台名称
     */
    private String domainName;
    /**
     * 机构名称
     */
    private String organName;

}
