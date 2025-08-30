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
package net.linlan.frame.web;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.PatternMatchUtils;

import net.linlan.commons.core.StringUtils;
import net.linlan.frame.FrameAdminUser;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.exception.CommonException;
import net.linlan.utils.http.HttpStatus;

/**
 * 安全服务工具类
 * 
 * @author Linlan
 */
public class SecurityUtils {
    private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    /**
     * 用户LID
     * @return 管理用户LID
     **/
    public static Long getAdminId() {
        try {
            return getLoginUser().getAdminId();
        } catch (Exception e) {
            throw new CommonException("获取用户LID异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 用户UUID
     * @return 管理用户ID
     **/
    public static String getUserId() {
        try {
            return getLoginUser().getUserId();
        } catch (Exception e) {
            throw new CommonException("获取用户LID异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取部门ID
     * @return 管理用户部门ID
     **/
    public static Long getDeptId() {
        try {
            return getLoginUser().getDeptId();
        } catch (Exception e) {
            throw new CommonException("获取部门ID异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取机构ID
     * @return 管理用户机构ID
     **/
    public static String getOrganId() {
        try {
            return getLoginUser().getOrganId();
        } catch (Exception e) {
            throw new CommonException("获取部门ID异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取用户账户
     * @return 管理用户名
     **/
    public static String getUsername() {
        try {
            return getLoginUser().getUsername();
        } catch (Exception e) {
            throw new CommonException("获取用户账户异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取用户
     * @return 管理用户对象
     **/
    public static FrameAdminUser getLoginUser() {
        try {
            return (FrameAdminUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            //在登出的时候，没有用户，此时仍然需要保存操作记录，返回null对象
            logger.info("获取用户信息异常", HttpStatus.UNAUTHORIZED);
            return null;
        }
    }

    /**
     * 获取Authentication
     * @return Authentication对象
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 验证用户是否具备某权限
     * 
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public static boolean hasPermi(String permission) {
        return hasPermi(getLoginUser().getPerms(), permission);
    }

    /**
     * 判断是否包含权限
     * 
     * @param authorities 权限列表
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public static boolean hasPermi(Collection<String> authorities, String permission) {
        return authorities.stream().filter(StringUtils::hasText)
            .anyMatch(x -> Constants.ALL_PERMISSION.equals(x)
                           || PatternMatchUtils.simpleMatch(x, permission));
    }

    /**
     * 判断是否包含角色
     * 
     * @param roles 角色列表
     * @param role 角色
     * @return 用户是否具备某角色权限
     */
    public static boolean hasRole(Collection<String> roles, String role) {
        return roles.stream().filter(StringUtils::hasText)
            //                .anyMatch(x -> Constants.SUPER_ADMIN.equals(x) || PatternMatchUtils.simpleMatch(x, role));
            .anyMatch(x -> PatternMatchUtils.simpleMatch(x, role));
    }

}
