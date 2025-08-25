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
package net.linlan.sys.base.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

import net.linlan.commons.core.RandomUtils;
import net.linlan.sys.web.KernelConstant;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * BaseDictionary数据域:公共字典明细实体类
 * @author Linlan
 * CreateTime 2018-05-08 18:37:58
 *
 */
@Data
public class BaseDictionary extends BaseEntity {

    /**
     * 字典编号
     */
    private Long                 id;

    /**
     * 字典类型代码
     */
    private String               typeCode;

    /**
     * 字典父节点编号，简单的字典使用
     */
    private Long                 parentId;

    /**
     * 字典名称
     */
    private String               name;

    /**
     * 字典名称简称，英文，多语种名称
     */
    private String               sname;

    /**
     * 字典值
     */
    private String               cddValue;

    /**
     * 字典级别, tree时有效
     */
    private String               cddLevel;

    /**
     * 快速码
     */
    private String               searchCode;

    /**
     * 显示标记，用|分隔，第1位全部第2位重点第3位特殊分类；如1|1|0
     */
    private String               dispFlag;

    /**
     * 排序码
     */
    private Integer              priority;

    /**
     * 删除标记0正常1已删除2应用内受限3回收站
     */
    private Integer              delFlag;

    /**
     * 删除时间
     */
    private Date                 deleteTime;

    /**
     * 描述
     */
    private String               description;

    /**
     * 备用1
     */
    private String               spare1;

    /**
     * 备用2
     */
    private String               spare2;

    private List<BaseDictionary> children;

    /**
     * 初始化方法
     */
    public void init() {
        //添加对数据库或实体对象的默认值处理
        if (getId() == null) {
            setId(RandomUtils.randomLid());
        }

        if (getDelFlag() == null) {
            setDelFlag(KernelConstant.DEL_FLAG_DEFAULT);
        }
        setCddLevel(KernelConstant.DEFAULT_INT + "");
        if (getPriority() == null) {
            setPriority(KernelConstant.DEFAULT_PRIORITY);
        }
    }

}
