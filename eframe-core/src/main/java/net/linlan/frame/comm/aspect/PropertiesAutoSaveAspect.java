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
package net.linlan.frame.comm.aspect;

import java.sql.Timestamp;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import net.linlan.frame.FrameAdminUser;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.utils.entity.BaseEntity;

/**
 *
 * Filename:ObjSaveAspect.java
 * 对象保存,修改,切面处理类
 * @author Linlan
 * CreateTime 2021年11月23日14:10:22
 * @version 1.0
 * @since 1.0
 *
 */
@Aspect
@Component
@Slf4j
public class PropertiesAutoSaveAspect {

    @Pointcut(value = "execution(* net.linlan.commons.db.mybatis.MybatisBaseDao.save(..))")
    public void savePointCut() {

    }

    /**
     * 对象保存，自动赋值创建时间、修改时间、创建人
     * @param point 拦截point
     * @throws Throwable    异常
     */
    @Before("savePointCut()")
    public void before(JoinPoint point) throws Throwable {
        Object[] args = point.getArgs();

        if (args != null && args.length > 0) {
            Object obj = args[0];
            if (obj instanceof BaseEntity) {
                BaseEntity baseEntity = (BaseEntity) obj;
                Date date = new Date();
                if (baseEntity.getCreateTime() == null) {
                    baseEntity.setCreateTime(date);
                }
                if (baseEntity.getLastTime() == null) {
                    baseEntity.setLastTime(date);
                }
                if (baseEntity.getCreatorId() == null) {
                    FrameAdminUser user = SecurityUtils.getLoginUser();
                    if (user != null) {
                        baseEntity.setCreatorId(user == null ? null : user.getUserId());
                    }
                }
            }
        }
    }

    @Pointcut(value = "execution(* net.linlan.commons.db.mybatis.MybatisBaseDao.update(..))")
    public void updatePointCut() {

    }

    /**
     * 对象修改，自动赋值修改时间
     * @param point     拦截point
     * @throws Throwable    异常
     */
    @Before("updatePointCut()")
    public void beforeUpdate(JoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            Object obj = args[0];
            if (obj instanceof BaseEntity) {
                BaseEntity baseEntity = (BaseEntity) obj;
                if (baseEntity.getLastTime() == null) {
                    baseEntity.setLastTime(new Timestamp(System.currentTimeMillis()));
                }
            }
        }
    }

}
