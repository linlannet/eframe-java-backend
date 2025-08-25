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
package net.linlan.frame.view.sys.vo;

import java.util.Date;

import org.springframework.lang.Nullable;

import com.google.common.base.Function;

import lombok.Data;

import net.linlan.annotation.Excel;
import net.linlan.annotation.Excel.ColumnType;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.dto.BaseDicTypeDto;
import net.linlan.sys.base.entity.BaseDicType;

/**
 * 字典类型表 sys_dict_type
 * 
 * @author Linlan
 */
@Data
public class BaseDicTypeVo {
    private static final long serialVersionUID = 1L;

    /** 字典主键 */
    @Excel(name = "字典主键", cellType = ColumnType.STRING)
    private String            typeId;

    /** 字典名称 */
    @Excel(name = "字典名称")
    private String            name;

    /** 类型分类 */
    @Excel(name = "类型分类")
    private String            typeClass;
    /** 字典引用名称 */
    @Excel(name = "字典引用名称")
    private String            typeRef;
    /** 字典类型模式 0平面1树形  */
    @Excel(name = "类型模式")
    private Integer           typeMode;
    /** 快速码 */
    @Excel(name = "快速码")
    private String            searchCode;
    /** 排序码 */
    @Excel(name = "排序码")
    private Integer           priority;
    /** 创建时间 */
    @Excel(name = "创建时间")
    private Date              createTime;

    /** 状态（0未生效 1正常） */
    @Excel(name = "状态", readConverterExp = "0=未生效,1=正常")
    private Integer           status;

    /** 备注 */
    private String            remark;

    public BaseDicTypeVo() {
    }

    /**
     * 数据赋值DTO方法，将BaseDicTypeDto的input对象赋值给GlobalConfigVo
     */
    public static final Function TO = new Function<BaseDicType, BaseDicTypeVo>() {
        @Nullable
        @Override
        public BaseDicTypeVo apply(@Nullable BaseDicType input) {
            return new BaseDicTypeVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseDicTypeVo(BaseDicType input) {
        this.typeId = input.getId();
        this.name = input.getName();
        this.typeClass = input.getTypeClass();
        this.typeRef = input.getTypeRef();
        this.typeMode = input.getTypeMode();
        this.searchCode = input.getSearchCode();
        this.priority = input.getPriority();
        this.createTime = input.getCreateTime();
        this.status = input.getStatus();
        this.remark = input.getDescription();
    }

    /**
     * 数据赋值DTO方法，将BaseDicTypeDto的input对象赋值给GlobalConfigVo
     */
    public static final Function DTO = new Function<BaseDicTypeDto, BaseDicTypeVo>() {
        @Nullable
        @Override
        public BaseDicTypeVo apply(@Nullable BaseDicTypeDto input) {
            return new BaseDicTypeVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseDicTypeVo(BaseDicTypeDto input) {
        this.typeId = input.getId();
        this.name = input.getName();
        this.typeClass = input.getTypeClass();
        this.typeRef = input.getTypeRef();
        this.typeMode = input.getTypeMode();
        this.searchCode = input.getSearchCode();
        this.priority = input.getPriority();
        this.createTime = input.getCreateTime();
        this.status = input.getStatus();
        this.remark = input.getDescription();
    }

    public static BaseDicType transTo(BaseDicTypeVo input) {
        BaseDicType result = new BaseDicType();
        if (StringUtils.isNotEmpty(input.getTypeId())) {
            result.setId(input.getTypeId());
        }
        result.init();
        result.setName(input.getName());
        result.setTypeClass(input.getTypeClass());
        result.setTypeRef(input.getTypeRef());
        result.setTypeMode(input.getTypeMode());
        result.setSearchCode(input.getSearchCode());
        result.setPriority(input.getPriority());
        if (input.getCreateTime() != null) {
            result.setCreateTime(input.getCreateTime());
        }
        result.setStatus(input.getStatus());
        result.setDescription(input.getRemark());
        return result;
    }

}
