/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.comm.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import net.linlan.commons.core.StringUtils;

/**
 *
 * Filename:ApiWebSocketController.java
 * Desc:@ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端
 *  * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 *
 */
//访问服务端的url地址
@Component
@Slf4j
@ServerEndpoint(value = "/api/websocket/V1/{userId}")
public class WebSocketV1Service {
    //用于记录接入的websocket连接
    private static ConcurrentHashMap<String, List<WebSocketDto>> websocketMap = new ConcurrentHashMap<String, List<WebSocketDto>>();

    /**
     * 连接建立成功调用的方法
     *
     * @param userId   用户ID
     * @param session   session信息
     * 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        WebSocketDto websocketDto = new WebSocketDto();
        websocketDto.setUserId(userId);
        websocketDto.setSession(session);
        //设置最大连接时长 20秒
        //        session.setMaxIdleTimeout(20000);
        //update by shuxiaobo 一个userId多个连接全部推送
        List<WebSocketDto> list = websocketMap.get(userId);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(websocketDto);
        websocketMap.put(userId, list);
        //心跳，20秒发一次
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    session.getBasicRemote().sendText(
                        "[{\"countNum\":0,\"name\":\"test\",\"countTotal\":0,\"id\":0,\"countRate\":0}]");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 20, TimeUnit.SECONDS);
        //end
    }

    /**
     * 连接关闭调用的方法
     * @param userId   用户ID
     * @param session   session信息
     */
    @OnClose
    public void onClose(@PathParam("userId") String userId, Session session) {
        List<WebSocketDto> list = websocketMap.get(userId);
        if (list == null || list.size() == 0) {
            return;
        }
        List<WebSocketDto> temp = new ArrayList<>();
        for (WebSocketDto aa : list) {
            Session session1 = aa.getSession();
            if (!session1.getId().equals(session.getId())) {
                temp.add(aa);
            }
        }
        websocketMap.put(userId, temp);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message   客户端发送过来的消息
     * @param session   可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
    }

    /**
     * 发生错误时调用
     *
     * @param session   session信息
     * @param error     错误信息
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    //发送消息
    public void sendMessage(String userId, String message) throws IOException {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(message)) {
            List<WebSocketDto> webSocketDtos = websocketMap.get(userId);
            if (webSocketDtos != null) {
                for (WebSocketDto webSocketDto : webSocketDtos) {
                    Session session = webSocketDto.getSession();
                    if (session == null) {
                        continue;
                    }
                    try {
                        session.getBasicRemote().sendText(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static ConcurrentHashMap<String, List<WebSocketDto>> getWebsocketMap() {
        return websocketMap;
    }

    public static void setWebsocketMap(ConcurrentHashMap<String, List<WebSocketDto>> websocketMap) {
        WebSocketV1Service.websocketMap = websocketMap;
    }
}
