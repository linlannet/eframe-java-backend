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
package net.linlan.frame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.linlan.commons.db.mybatis.MybatisBaseDao;
import net.linlan.frame.admin.dto.IndexApplicationDto;
import net.linlan.frame.admin.dto.IndexElementDto;
import net.linlan.frame.admin.dto.IndexManageDto;
import net.linlan.frame.admin.entity.AdminDept;
import net.linlan.frame.admin.param.FrameIndexParam;

@Mapper
public interface FrameIndexDao extends MybatisBaseDao<AdminDept> {

    List<IndexApplicationDto> getIndexApplicationCount(FrameIndexParam param);

    List<IndexElementDto> getIndexElementCount(FrameIndexParam param);

    List<IndexManageDto> getIndexManageCount(FrameIndexParam param);

}
