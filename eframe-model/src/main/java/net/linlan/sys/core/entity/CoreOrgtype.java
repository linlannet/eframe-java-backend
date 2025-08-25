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
package net.linlan.sys.core.entity;

import java.util.List;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * CoreOrgtype数据域:机构分类表实体类
 * @author Linlan
 * CreateTime 2018-03-02 17:19:48
 *
 */
@Data
public class CoreOrgtype extends BaseEntity {

    /**
    * 机构分类ID
    */
    private Long    id;

    /**
    * 父分类ID
    */
    private Long    parentId;

    /**
    * 分类编码
    */
    private String  code;

    /**
    * 分类名称
    */
    private String  name;

    /**
    * 分类简称，英文
    */
    private String  sname;

    /**
    * 排序
    */
    private Integer priority;

    /**
    * 删除标记0正常1已删除2应用内受限3回收站
    */
    private Integer delFlag;

    /**
    * 描述
    */
    private String  description;

    /**
     * ztree属性
     */
    private Boolean open;
    /**
     * ztree属性list
     */
    private List<?> list;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }
        if (getCode() == null) {
            setCode(RandomUtils.randomCode());
        }
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
        if (getDelFlag() == null) {
            setDelFlag(KernelConstant.DEL_FLAG_DEFAULT);
        }
    }

}
