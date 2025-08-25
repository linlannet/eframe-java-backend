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
package net.linlan.frame.api;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.github.pagehelper.Page;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.DateUtils;
import net.linlan.commons.core.Rcode;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.FrameAdminUser;
import net.linlan.frame.mbiz.ApiIntfConfig;
import net.linlan.frame.mbiz.constant.HttpStatusEnum;
import net.linlan.frame.web.SecurityUtils;

/**
 * web层通用数据处理
 *
 * @author Linlan
 */
@Slf4j
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回成功，信息同时放入data中
     * @return  返回对象
     */
    public ResponseResult success() {
        return ResponseResult.ok().setResultData(ApiIntfConfig.SUCCESS);
    }

    /**
     * 返回失败消息，信息同时放入data中
     * @return  返回对象
     */
    public ResponseResult failure() {
        return ResponseResult.error(HttpStatusEnum.PARAMETER_ERROR.getCode(),
            HttpStatusEnum.PARAMETER_ERROR.getMsg()).setResultData(ApiIntfConfig.FAILURE);
    }

    /**
     * 返回失败消息，信息同时放入data中
     * @return  返回对象
     */
    public ResponseResult empty() {
        return ResponseResult.error(HttpStatusEnum.RETURN_NONE.getCode(),
            HttpStatusEnum.RETURN_NONE.getMsg());
    }

    /**
     * 返回成功消息
     *
     * @param message 提示消息
     * @return  返回对象
     */
    public ResponseResult<String> okMsg(String message) {
        return ResponseResult.ok(message);
    }

    /**
     * 返回失败消息
     * @param message 提示消息
     * @return  返回对象
     */
    public ResponseResult errorMsg(String message) {
        return ResponseResult.error(message);
    }

    /**
     * 返回成功消息
     * @param data 返回对象
     * @return  返回对象
     */
    public ResponseResult success(Object data) {
        return ResponseResult.ok(data);
    }

    /**
     * 返回警告消息
     * @param message 提示消息
     * @return  返回对象
     */
    public ResponseResult warnMsg(String message) {
        return ResponseResult.warn(message);
    }

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     * @param binder    构造器
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 将数据list生成page对象
     * @param list  数据集合
     * @param limit 每页条数
     * @param page 当前页
     * @param total 总条数
     * @return  返回对象
     * @return  返回对象
     */
    public ResponseResult successPage(List<?> list, int limit, int page, long total) {
        if (list == null) {
            return null;
        }
        return success(new Pagination(list, (int) total, limit, page));
    }

    /**
     * 将数据list生成page对象
     * @param page 页面
     * @return  返回对象
     */
    public ResponseResult successPage(Page page) {
        if (page == null) {
            return null;
        }
        return success(new Pagination(page));
    }

    @ExceptionHandler({ Exception.class })
    public Rcode fix(Exception e) {
        e.printStackTrace();
        Rcode rcode = Rcode
            .error(e.getMessage() != null ? e.getMessage() : "Internal Server Error");
        return rcode;
    }

    /**
     * 返回失败消息
     * @return  返回对象
     */
    public ResponseResult error() {
        return ResponseResult.error("失败");
    }

    /**
     * 返回成功消息
     * @param message 提示消息
     * @return  返回对象
     */
    public ResponseResult success(String message) {
        return ResponseResult.ok(message);
    }

    /**
     * 返回失败消息
     * @param message 提示消息
     * @return  返回对象
     */
    public ResponseResult error(String message) {
        return ResponseResult.error(message);
    }

    /**
     * 返回警告消息
     * @param message 提示消息
     * @return  返回对象
     */
    public ResponseResult warn(String message) {
        return ResponseResult.warn(message);
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected ResponseResult returnRow(int rows) {
        return rows > 0 ? ResponseResult.ok() : ResponseResult.error("error");
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected ResponseResult returnRow(boolean result) {
        return result ? success() : error();
    }

    /**
     * 页面跳转
     * @param url 重定向地址
     * @return 操作结果
     */
    public String redirect(String url) {
        return StringUtils.format("redirect:{}", url);
    }

    /**
     * 获取用户缓存信息
     * @return 返回结果
     */
    public FrameAdminUser getLoginUser() {
        return SecurityUtils.getLoginUser();
    }

    /**
     * 获取登录用户lid
     * @return 返回结果
     */
    public Long getAdminId() {
        return getLoginUser().getAdminId();
    }

    /**
     * 获取登录用户UUID
     * @return 返回结果
     */
    public String getUserId() {
        return getLoginUser().getUserId();
    }

    /**
     * 获取登录部门id
     * @return 返回结果
     */
    public Long getDeptId() {
        return getLoginUser().getDeptId();
    }

    /**
     * 获取登录用户机构ID
     * @return 返回结果
     */
    public String getOrganId() {
        return getLoginUser().getOrganId();
    }

    /**
     * 获取登录用户名
     * @return 返回结果
     */
    public String getUsername() {
        return getLoginUser().getUsername();
    }
}
