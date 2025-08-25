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
import net.linlan.sys.comm.dto.CommLogDto;

/**
 * 操作日志记录表 oper_log
 * 
 * @author Linlan
 */
@Data
public class CommLogVo {
    private static final long    serialVersionUID = 1L;

    /** 日志主键 */
    @Excel(name = "操作序号", cellType = ColumnType.NUMERIC)
    private Long                 operId;

    /** 操作模块 */
    @Excel(name = "操作模块")
    private String               title;

    /** 业务类型（0其它 1新增 2修改 3删除） */
    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据")
    private Integer              businessType;

    private String               businessTypeName;

    /** 业务类型数组 */
    private Integer[]            businessTypes;

    /** 请求方法 */
    @Excel(name = "请求方法")
    private String               method;

    /** 请求方式 */
    @Excel(name = "请求方式")
    private String               requestMethod;

    /** 操作类别（0其它 1后台用户 2手机端用户） */
    @Excel(name = "操作类别", readConverterExp = "0=其它,1=后台用户,2=手机端用户")
    private Integer              operatorType;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String               operName;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String               deptName;

    /** 请求url */
    @Excel(name = "请求地址")
    private String               operUrl;

    /** 操作地址 */
    @Excel(name = "操作地址")
    private String               operIp;

    /** 操作地点 */
    @Excel(name = "操作地点")
    private String               operLocation;

    /** 请求参数 */
    @Excel(name = "请求参数")
    private String               operParam;

    /** 返回参数 */
    @Excel(name = "返回参数")
    private String               jsonResult;

    /** 操作状态（0正常 1异常） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    private Integer              status;

    /** 错误消息 */
    @Excel(name = "错误消息")
    private String               errorMsg;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date                 operTime;

    /** 消耗时间 */
    @Excel(name = "消耗时间", suffix = "毫秒")
    private Long                 costTime;

    /** 备注 */
    private String               remark;

    /**
     * 数据赋值DTO方法，将CommLogDto的input对象赋值给EntCommLogVo
     */
    public static final Function DTO              = new Function<CommLogDto, CommLogVo>() {
                                                      @Nullable
                                                      @Override
                                                      public CommLogVo apply(@Nullable CommLogDto input) {
                                                          return new CommLogVo(input);
                                                      }
                                                  };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public CommLogVo(CommLogDto input) {
        this.operId = input.getId();
        this.operName = input.getUsername();
        this.businessType = input.getCategory();
        if (businessType != null) {
            if (businessType == 0) {
                this.businessTypeName = "查询";
            } else if (businessType == 10) {
                this.businessTypeName = "新增";
            } else if (businessType == 20) {
                this.businessTypeName = "修改";
            } else if (businessType == 40) {
                this.businessTypeName = "删除";
            } else if (businessType == 50) {
                this.businessTypeName = "其他";
            } else {
                this.businessTypeName = "其他";
            }
        }
        this.title = input.getOperation();
        this.method = input.getMethod();
        this.operParam = input.getParams();
        this.operIp = input.getIp();
        this.operTime = input.getCreateTime();
        this.costTime = input.getTime();
        this.status = 0;
    }

}
