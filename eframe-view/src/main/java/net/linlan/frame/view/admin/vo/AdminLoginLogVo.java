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
package net.linlan.frame.view.admin.vo;

import java.util.Date;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.base.Function;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.annotation.Excel.ColumnType;
import net.linlan.frame.admin.dto.AdminLoginLogDto;
import net.linlan.frame.admin.entity.AdminLoginLog;

/**
 * 系统访问记录表 sys_loginlog
 * 
 * @author Linlan
 */
@Data
public class AdminLoginLogVo {

    /** ID */
    @Excel(name = "序号", cellType = ColumnType.NUMERIC)
    private Long                 infoId;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String               username;

    /** 登录状态 0成功 1失败 */
    @Excel(name = "登录状态", readConverterExp = "0=成功,1=失败")
    private String               status;

    /** 登录IP地址 */
    @Excel(name = "登录地址")
    private String               ipaddr;

    /** 登录地点 */
    @Excel(name = "登录地点")
    private String               loginLocation;

    /** 浏览器类型 */
    @Excel(name = "浏览器")
    private String               browser;

    /** 操作系统 */
    @Excel(name = "操作系统")
    private String               os;

    /** 提示消息 */
    @Excel(name = "提示消息")
    private String               msg;

    /** 访问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date                 loginTime;

    /** 备注 */
    private String               remark;

    /**
     * 数据赋值TO方法，将AdminLoginLog的input对象赋值给EntAdminLoginLogVo
     */
    public static final Function TO = new Function<AdminLoginLog, AdminLoginLogVo>() {
                                        @Nullable
                                        @Override
                                        public AdminLoginLogVo apply(@Nullable AdminLoginLog input) {
                                            return new AdminLoginLogVo(input);
                                        }
                                    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminLoginLogVo(AdminLoginLog input) {
        this.infoId = input.getId();
        this.username = input.getUserId();
        this.msg = input.getTitle();
        this.loginTime = input.getLogTime();
        this.ipaddr = input.getLogIp();
        this.browser = input.getLogBrowse();
        this.os = input.getLogOs();
        this.status = input.getStatus();
        this.remark = input.getDescription();
    }

    /**
     * 数据赋值DTO方法，将AdminLoginLogDto的input对象赋值给EntAdminLoginLogVo
     */
    public static final Function DTO = new Function<AdminLoginLogDto, AdminLoginLogVo>() {
        @Nullable
        @Override
        public AdminLoginLogVo apply(@Nullable AdminLoginLogDto input) {
            return new AdminLoginLogVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public AdminLoginLogVo(AdminLoginLogDto input) {
        this.infoId = input.getId();
        this.username = input.getUserId();
        this.msg = input.getTitle();
        this.loginTime = input.getLogTime();
        this.ipaddr = input.getLogIp();
        this.browser = input.getLogBrowse();
        this.os = input.getLogOs();
        this.status = input.getStatus();
        this.remark = input.getDescription();
    }

}
