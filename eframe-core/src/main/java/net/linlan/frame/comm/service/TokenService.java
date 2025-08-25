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
package net.linlan.frame.comm.service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import eu.bitwalker.useragentutils.UserAgent;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.frame.FrameAdminUser;
import net.linlan.frame.comm.vo.AppLoginInfo;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.ServletUtils;
import net.linlan.utils.TokenGenerator;
import net.linlan.utils.constant.CacheConstants;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.crypt.RSAUtil;
import net.linlan.utils.ip.IPUtils;

/**
 * token验证处理
 *
 * @author Linlan
 */
@Component
public class TokenService {
    private static final Logger log               = LoggerFactory.getLogger(TokenService.class);

    // 令牌自定义标识
    @Value("${platform.token.header}")
    private String              header;

    // 令牌秘钥
    @Value("${platform.token.secret}")
    private String              secret;

    // 令牌有效期（默认30分钟）
    @Value("${platform.token.expireTime}")
    private int                 expireTime;

    protected static final long MILLIS_SECOND     = 1000;

    protected static final long MILLIS_MINUTE     = 60 * MILLIS_SECOND;

    private static final Long   MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    public static final String  PERMISSION_MODEL  = "permissionKey";

    private static String       tokenPrivateKey   = "";

    @Resource
    private RedisService        redisService;

    /**
     * 获取用户身份信息
     * @param request   请求request
     * @return 用户信息
     */
    public FrameAdminUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (ObjectUtils.isNotEmpty(token)) {
            try {
                Claims claims = parseToken(token);
                // 解析对应的权限以及用户信息
                String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
                String userKey = getTokenKey(uuid);
                FrameAdminUser user = redisService.get(userKey, FrameAdminUser.class);
                return user;
            } catch (Exception e) {
                log.error("获取用户信息异常'{}'", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 获取用户身份信息
     * @param token     token令牌
     * @return 用户信息
     */
    public FrameAdminUser getLoginUserByToken(String token) {
        if (StringUtils.isNotEmpty(token)) {
            try {
                Claims claims = parseToken(token);
                // 解析对应的权限以及用户信息
                String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
                String userKey = getTokenKey(uuid);
                FrameAdminUser user = redisService.get(userKey, FrameAdminUser.class);
                return user;
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     * 根据用户id获取用户身份信息
     * 由于多端登录，根据token获取的用户信息不一样，所以增加一个根据用户id获取用户信息的缓存key，以后多端需要获取用户最新信息就用这个方法吧
     * @param userId    用户ID
     * @return 用户信息
     */
    public FrameAdminUser getLoginUserByUserId(Long userId) {
        if (userId != null) {
            try {
                String userKey = getAdminIdKey(userId);
                return redisService.get(userKey, FrameAdminUser.class);
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     * 设置用户身份信息
     * @param loginUser 设置登录用户
     */
    public void setLoginUser(FrameAdminUser loginUser) {
        if (ObjectUtils.isNotEmpty(loginUser) && ObjectUtils.isNotEmpty(loginUser.getToken())) {
            refreshToken(loginUser);
        }
    }

    /**
     * 删除用户身份信息
     * @param token 当前令牌
     */
    public void delLoginUser(String token) {
        if (ObjectUtils.isNotEmpty(token)) {
            String userKey = getTokenKey(token);
            redisService.delete(userKey);
        }
    }

    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 登录对象
     */
    public AppLoginInfo createToken(FrameAdminUser loginUser) {
        String token = TokenGenerator.generateValue();
        loginUser.setToken(token);
        setUserAgent(loginUser);
        refreshToken(loginUser);

        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);
        String newtoken = createToken(claims);
        AppLoginInfo appLoginInfo = new AppLoginInfo();
        appLoginInfo.setAdminId(loginUser.getAdminId());
        appLoginInfo.setToken(newtoken);
        return appLoginInfo;
    }

    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUser 登录用户信息
     */
    public void verifyToken(FrameAdminUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUser);
        }
    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录用户信息
     */
    public void refreshToken(FrameAdminUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisService.set(userKey, loginUser, expireTime * 60);
    }

    /**
     * 设置用户代理信息
     *
     * @param loginUser 登录用户信息
     */
    public void setUserAgent(FrameAdminUser loginUser) {
        UserAgent userAgent = UserAgent
            .parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String ip = IPUtils.getIpAddr(ServletUtils.getRequest());
        loginUser.setLoginIp(ip);
        loginUser.setLoginBrowse(userAgent.getBrowser().getName());
        loginUser.setLoginOs(userAgent.getOperatingSystem().getName());
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return token令牌
     */
    private String createToken(Map<String, Object> claims) {
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret)
            .compact();
        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    /**
     * 获取请求token
     *
     * @param request   请求
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);

        //permissionKey 导出  序列化token +  1,时间戳 的加密字符串   字符串格式必须遵循  XXX,时间戳 不然无法解密
        String permissionKey = request.getParameter(PERMISSION_MODEL);

        if (StringUtils.isNotBlank(permissionKey)) {
            try {
                String[] split = permissionKey.split(",");

                token = split[0];
                String time = split[1];

                if (split.length == 1) {
                    return null;
                }

                //decode一次，前端可能Encode过了
                time = URLDecoder.decode(time, StandardCharsets.UTF_8.name());
                time = time.replaceAll(" ", "+");
                //end
                //permissionKey= permissionKey.replace(" ","+");
                time = RSAUtil.decrypt(time, RSAUtil.getPrivateKey(tokenPrivateKey));
                //只有token的不让过
                time = time.split(",")[1];
                //end
                //校验时效性,十分钟内有效
                long currTime = System.currentTimeMillis();
                if (currTime - Long.valueOf(time) > 10 * 60 * 1000) {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (ObjectUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    /** 获取Redis的TOKEN减值
     * @param uuid  主键ID
     * @return    token
     */
    private String getTokenKey(String uuid) {
        return CacheConstants.LOGIN_TOKEN_KEY + uuid;
    }

    /** 获取用户AdminId
     * @param adminId    管理员ID
     * @return    查询信息
     */
    private String getAdminIdKey(Long adminId) {
        return CacheConstants.LOGIN_ADMIN_ID_KEY + adminId;
    }

    /** 获取用户UserId
     * @param userId    用户ID
     * @return    查询信息
     */
    private String getUserIdKey(String userId) {
        return CacheConstants.LOGIN_USER_ID_KEY + userId;
    }

}
