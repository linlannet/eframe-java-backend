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
import net.linlan.sys.role.dto.SysPositionDto;
import net.linlan.sys.role.entity.SysPosition;

/**
 *
 * EntSysPosition视图域:企业平台岗位信息显示Vo类
 * 
 * @author Linlan
 * CreateTime 2023-09-05 10:02:32
 *
 */
@Data
public class SysPositionVo {
    /** 岗位序号 */
    @Excel(name = "岗位序号", cellType = Excel.ColumnType.STRING)
    private String   postId;

    /** 岗位编码 */
    @Excel(name = "岗位编码")
    private String   postCode;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String   postName;

    /** 岗位排序 */
    @Excel(name = "岗位排序")
    private Integer  postSort;

    /** 状态（0未生效 1正常） */
    @Excel(name = "状态", readConverterExp = "0=未生效,1=正常")

    /** 状态（0未生效1正常2受限3锁定4删除） */
    private Integer  status;

    /** 创建者 */
    private String   creatorId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date     createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date     lastTime;

    /** 删除标记（0正常 1删除） */
    private Integer  delFlag;

    /**
     * 备注
     */
    private String   remark;
    /**
     * 角色id集合
     */
    private String[] ids;
    /**
     * 岗位ID
     */
    private String   positionId;

    /** 用户是否存在此岗位标识 默认不存在 */
    private boolean  flag = false;

    /**
     * 无参构造
     */
    public SysPositionVo() {
    }

    /**
     * 数据赋值TO方法，将SysPosition的input对象赋值给SysPositionVo
     */
    public static final Function TO = new Function<SysPosition, SysPositionVo>() {
        @Nullable
        @Override
        public SysPositionVo apply(@Nullable SysPosition input) {
            return new SysPositionVo(input);
        }
    };

    /**
     * @param input 数据库查询出的entity对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public SysPositionVo(SysPosition input) {
        this.postId = input.getId();
        this.postName = input.getName();
        this.postCode = input.getCode();
        this.status = input.getStatus();
        this.postSort = input.getPriority();
        this.creatorId = input.getUserId();
        this.createTime = input.getCreateTime();
        this.lastTime = input.getLastTime();

    }

    /**
     * 数据赋值DTO方法，将SysPositionDto的input对象赋值给SysPositionVo
     */
    public static final Function DTO = new Function<SysPositionDto, SysPositionVo>() {
        @Nullable
        @Override
        public SysPositionVo apply(@Nullable SysPositionDto input) {
            return new SysPositionVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public SysPositionVo(SysPositionDto input) {
        this.postId = input.getId();
        this.postName = input.getName();
        this.postCode = input.getCode();
        this.status = input.getStatus();
        this.postSort = input.getPriority();
        this.creatorId = input.getUserId();
        this.createTime = input.getCreateTime();
        this.lastTime = input.getLastTime();
    }

}
