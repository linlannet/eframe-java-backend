/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.script.html.EscapeUtils;
import net.linlan.utils.http.HttpStatus;
import net.linlan.utils.text.Convert;

/**
 * 全局异常处理器
 * 
 * @author Linlan
 */
@RestControllerAdvice
public class ExceptionEntHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionEntHandler.class);

    /**
     * 权限校验异常
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseResult handleAccessDeniedException(AccessDeniedException e,
                                                      HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return ResponseResult.error(HttpStatus.FORBIDDEN + "", "没有权限，请联系管理员授权");
    }

    /**
     * 请求方式不支持
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                              HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return ResponseResult.error(e.getMessage());
    }

    /**
     * 业务异常
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(CommonException.class)
    public ResponseResult handleServiceException(CommonException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        Integer code = e.getCode();
        return ObjectUtils.isNotEmpty(code) ? ResponseResult.error(code + "", e.getMessage())
            : ResponseResult.error(e.getMessage());
    }

    /**
     * 请求路径中缺少必需的路径变量
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseResult handleMissingPathVariableException(MissingPathVariableException e,
                                                             HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求路径中缺少必需的路径变量'{}',发生系统异常.", requestURI, e);
        return ResponseResult.error(String.format("请求路径中缺少必需的路径变量[%s]", e.getVariableName()));
    }

    /**
     * 请求参数类型不匹配
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseResult handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e,
                                                                    HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String value = Convert.toStr(e.getValue());
        if (ObjectUtils.isNotEmpty(value)) {
            value = EscapeUtils.clean(value);
        }
        log.error("请求参数类型不匹配'{}',发生系统异常.", requestURI, e);
        return ResponseResult.error(String.format("请求参数类型不匹配，参数[%s]要求类型为：'%s'，但输入值为：'%s'",
            e.getName(), e.getRequiredType().getName(), value));
    }

    /**
     * 拦截未知的运行时异常
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return ResponseResult.error(e.getMessage());
    }

    /**
     * 系统异常
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return ResponseResult.error(e.getMessage());
    }

    /**
     * 自定义验证异常
     * @param e     异常
     * @return  响应对象
     */
    @ExceptionHandler(BindException.class)
    public ResponseResult handleBindException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return ResponseResult.error(message);
    }

    /**
     * 自定义验证异常
     * @param e     异常
     * @return  对象
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseResult.error(message);
    }

    /**
     * 演示模式异常
     * @param e     异常
     * @return  响应对象
     */
    @ExceptionHandler(DemoModeException.class)
    public ResponseResult handleDemoModeException(DemoModeException e) {
        return ResponseResult.error("演示模式，不允许操作");
    }
}
