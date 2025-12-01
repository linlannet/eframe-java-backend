/*
 * eframe-api - api接口网关模块
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
package net.linlan.frame.api.monitor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.commons.env.server.ServerInfo;

/**
 * 服务器监控
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("/api/monitor/")
public class ServerInfoController {

    /**
     * 获取服务器基本信息
     * @return 服务器基本信息
     * @throws Exception    异常
     */
    @PlatLog(value = "获取服务器基本信息")
    @PreAuthorize("@ss.hasPerms('monitor:server:list')")
    @GetMapping("server")
    public ResponseEntity<ServerInfo> getInfo() throws Exception {
        ServerInfo server = new ServerInfo();
        server.copyTo();
        return ResponseEntity.ok(server);
    }
}
