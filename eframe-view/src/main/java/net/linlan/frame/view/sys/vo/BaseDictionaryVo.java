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
import net.linlan.commons.core.ObjectUtils;
import net.linlan.sys.base.dto.BaseDictionaryDto;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.entity.BaseDictionary;

/**
 * 字典数据表 sys_dict_data
 * 
 * @author Linlan
 */
@Data
public class BaseDictionaryVo {
    private static final long serialVersionUID = 1L;

    /** 字典编码 */
    @Excel(name = "字典编码")
    private Long              cddId;

    /** 字典排序 */
    @Excel(name = "字典类型代码")
    private String            typeCode;

    /** 字典标签 */
    @Excel(name = "字典父节点编号")
    private Long              parentId;

    /** 字典键值 */
    @Excel(name = "字典名称")
    private String            name;

    /** 字典类型 */
    @Excel(name = "简称")
    private String            sname;

    /** 字典值 */
    @Excel(name = "字典值")
    private String            cddValue;

    /** 快速码 */
    @Excel(name = "快速码")
    private String            searchCode;

    /** 排序码 */
    @Excel(name = "排序码")
    private Integer           priority;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Date              createTime;

    /** 备注 */
    private String            remark;

    /** 备注 */
    private String            dictLabel;
    /**
     * 类型名称
     */
    private String            typeCodeName;
    /**
     * 父节点名称
     */
    private String            parentName;

    public BaseDictionaryVo() {
    }

    /**
     * 数据赋值DTO方法，将BaseDictionaryDto的input对象赋值给GlobalConfigVo
     */
    public static final Function TO = new Function<BaseDictionary, BaseDictionaryVo>() {
        @Nullable
        @Override
        public BaseDictionaryVo apply(@Nullable BaseDictionary input) {
            return new BaseDictionaryVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseDictionaryVo(BaseDictionary input) {
        if (input.getId() != null) {
            this.cddId = input.getId();
        }
        this.typeCode = input.getTypeCode();
        this.parentId = input.getParentId();
        this.name = input.getName();
        this.sname = input.getSname();
        this.cddValue = input.getCddValue();
        this.searchCode = input.getSearchCode();
        this.priority = input.getPriority();
        this.createTime = input.getCreateTime();
        this.remark = input.getDescription();
    }

    /**
     * 数据赋值DTO方法，将BaseDictionaryDto的input对象赋值给GlobalConfigVo
     */
    public static final Function INITO = new Function<DictionaryInitDto, BaseDictionaryVo>() {
        @Nullable
        @Override
        public BaseDictionaryVo apply(@Nullable DictionaryInitDto input) {
            return new BaseDictionaryVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseDictionaryVo(DictionaryInitDto input) {
        if (input.getId() != null) {
            this.cddId = Long.parseLong(input.getId());
        }
        if (input.getParentId() != null) {
            this.parentId = Long.valueOf(input.getParentId());
        }
        this.name = input.getName();
        this.cddValue = input.getCddValue();
        this.searchCode = input.getSearchCode();
        this.remark = input.getDescription();
    }

    /**
     * 数据赋值DTO方法，将BaseDictionaryDto的input对象赋值给GlobalConfigVo
     */
    public static final Function DTO = new Function<BaseDictionaryDto, BaseDictionaryVo>() {
        @Nullable
        @Override
        public BaseDictionaryVo apply(@Nullable BaseDictionaryDto input) {
            return new BaseDictionaryVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public BaseDictionaryVo(BaseDictionaryDto input) {
        this.cddId = input.getId();
        this.typeCode = input.getTypeCode();
        this.typeCodeName = input.getTypeCodeName();
        this.parentId = input.getParentId();
        this.parentName = input.getParentName();
        this.name = input.getName();
        this.sname = input.getSname();
        this.cddValue = input.getCddValue();
        this.searchCode = input.getSearchCode();
        this.priority = input.getPriority();
        this.createTime = input.getCreateTime();
        this.remark = input.getDescription();
    }

    public static BaseDictionary transTo(BaseDictionaryVo input) {
        BaseDictionary result = new BaseDictionary();
        if (ObjectUtils.isNotEmpty(input.getCddId())) {
            result.setId(input.getCddId());
        }
        result.setTypeCode(input.getTypeCode());
        result.setParentId(input.getParentId());
        result.setName(input.getName());
        result.setSname(input.getSname());
        result.setCddValue(input.getCddValue());
        result.setSearchCode(input.getSearchCode());
        result.setPriority(input.getPriority());
        result.setCreateTime(input.getCreateTime());
        result.setDescription(input.getRemark());
        return result;
    }

}
