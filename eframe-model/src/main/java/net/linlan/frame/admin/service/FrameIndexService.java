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
package net.linlan.frame.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import net.linlan.frame.admin.dao.FrameIndexDao;
import net.linlan.frame.admin.dto.IndexApplicationDto;
import net.linlan.frame.admin.dto.IndexElementDto;
import net.linlan.frame.admin.dto.IndexManageDto;
import net.linlan.frame.admin.param.FrameIndexParam;

@Service
@Slf4j
public class FrameIndexService {

    @Resource
    private FrameIndexDao dao;

    public List<IndexApplicationDto> getIndexApplicationCount(FrameIndexParam param) {
        return dao.getIndexApplicationCount(param);
    }

    public List<IndexElementDto> getIndexElementCount(FrameIndexParam param) {
        return dao.getIndexElementCount(param);
    }

    public List<IndexManageDto> getIndexManageCount(FrameIndexParam param) {
        return dao.getIndexManageCount(param);
    }

}
