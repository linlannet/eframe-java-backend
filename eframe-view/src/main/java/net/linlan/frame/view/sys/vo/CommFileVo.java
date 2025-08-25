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

import net.linlan.commons.core.StringUtils;
import net.linlan.sys.comm.dto.CommFileDto;
import net.linlan.sys.comm.entity.CommFile;

@Data
public class CommFileVo {

    /**
     * 文件路径
     */
    private String   id;
    /**
     * 资源种类ID
     */
    private String   resclassId;
    /**
     * 文件名称
     */
    private String   fileName;
    /**
     * 是否有效
     */
    private Boolean  fileIsvalid;
    /**
     * 创建时间
     */
    private Date     createTime;
    /**
     * 创建时间
     */
    private String   fileExtension;
    /**
     * 数组
     */
    private String[] ids;

    public CommFileVo() {
    }

    /**
     * 数据赋值方法，将CommFile的input对象赋值给CommFileEntVo
     */
    public static final Function TO = new Function<CommFile, CommFileVo>() {
        @Nullable
        @Override
        public CommFileVo apply(@Nullable CommFile input) {
            return new CommFileVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public CommFileVo(CommFile input) {
        this.id = input.getId();
        this.resclassId = input.getResclassId();
        this.fileName = input.getFileName();
        this.fileIsvalid = input.getFileIsvalid();
        this.createTime = input.getCreateTime();
        this.fileExtension = input.getFileExtension();

    }

    /**
     * 数据赋值DTO方法，将CommFileDto的input对象赋值给CommFileEntVo
     */
    public static final Function DTO = new Function<CommFileDto, CommFileVo>() {
        @Nullable
        @Override
        public CommFileVo apply(@Nullable CommFileDto input) {
            return new CommFileVo(input);
        }
    };

    /**
     * @param input 数据库查询出的Dto对象，对VO对象进行赋值，默认的字段为全部字段，可结合实际调整
     */
    public CommFileVo(CommFileDto input) {
        this.id = input.getId();
        this.resclassId = input.getResclassId();
        this.fileName = input.getFileName();
        this.fileIsvalid = input.getFileIsvalid();
        this.createTime = input.getCreateTime();
    }

    public static CommFile transTo(CommFileVo input) {
        CommFile result = new CommFile();
        if (StringUtils.isNotEmpty(input.getId())) {
            result.setId(input.getId());
        }
        result.init();
        result.setResclassId(input.getResclassId());
        result.setFileName(input.getFileName());
        result.setFileIsvalid(input.getFileIsvalid());
        result.setCreateTime(input.getCreateTime());
        result.setFileExtension(input.getFileExtension());
        return result;
    }

}
