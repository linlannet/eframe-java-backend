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
package net.linlan.frame.view.admin.param;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.annotation.Excel.ColumnType;
import net.linlan.sys.comm.param.CommLogParam;
import net.linlan.utils.param.BaseParam;

/**
 * 操作日志记录表 oper_log
 * 
 * @author Linlan
 */
@Data
public class CommLogVoParam extends BaseParam {

    /** 日志主键 */
    @Excel(name = "操作序号", cellType = ColumnType.NUMERIC)
    private Long    operId;

    /** 操作模块 */
    @Excel(name = "操作模块")
    private String  title;

    /** 业务类型（0其它 1新增 2修改 3删除） */
    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据")
    private Integer businessType;

    /** 操作类别（0其它 1后台用户 2手机端用户） */
    @Excel(name = "操作类别", readConverterExp = "0=其它,1=后台用户,2=手机端用户")
    private Integer operatorType;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String  operName;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String  deptName;

    /** 操作地址 */
    @Excel(name = "操作地址")
    private String  operIp;

    /** 操作状态（0正常 1异常） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    private Integer status;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date    operTime;

    /** 备注 */
    private String  remark;

    public CommLogParam toModelParam() {
        CommLogParam result = new CommLogParam();
        result.setIp(operIp);
        result.setOperation(title);
        result.setUsername(operName);
        result.setCategory(businessType);
        result.setPage(super.getPage());
        result.setLimit(super.getLimit());
        return result;
    }
}
