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

import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.http.HttpServletRequest;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.http.HttpStatus;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.commons.script.html.EscapeUtils;
import net.linlan.utils.text.Convert;

/**
 * 全局异常处理器
 * 
 * @author Linlan
 */
@Slf4j
@RestControllerAdvice
public class FrameExceptionHandler {

    /**
     * 权限校验异常
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity handleAccessDeniedException(AccessDeniedException e,
                                                      HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return ResponseEntity.error(HttpStatus.UNAUTHORIZED.value(), "没有权限，请联系管理员授权");
    }

    /**
     * 请求方式不支持
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                              HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return ResponseEntity.error(e.getMessage());
    }

    /**
     * 业务异常
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(CommonException.class)
    public ResponseEntity handleServiceException(CommonException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        Integer code = e.getCode();
        return ObjectUtils.isNotEmpty(code) ? ResponseEntity.error(code, e.getMessage())
            : ResponseEntity.error(e.getMessage());
    }

    /**
     * 请求路径中缺少必需的路径变量
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity handleMissingPathVariableException(MissingPathVariableException e,
                                                             HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求路径中缺少必需的路径变量'{}',发生系统异常.", requestURI, e);
        return ResponseEntity.error(String.format("请求路径中缺少必需的路径变量[%s]", e.getVariableName()));
    }

    /**
     * 请求参数类型不匹配
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e,
                                                                    HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String value = Convert.toStr(e.getValue());
        if (ObjectUtils.isNotEmpty(value)) {
            value = EscapeUtils.clean(value);
        }
        log.error("请求参数类型不匹配'{}',发生系统异常.", requestURI, e);
        return ResponseEntity.error(String.format("请求参数类型不匹配，参数[%s]要求类型为：'%s'，但输入值为：'%s'",
            e.getName(), e.getRequiredType().getName(), value));
    }

    /**
     * 拦截未知的运行时异常
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return ResponseEntity.error(e.getMessage());
    }

    /**
     * 系统异常
     * @param e     异常
     * @param request   请求
     * @return  响应对象
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return ResponseEntity.error(e.getMessage());
    }

    /**
     * 自定义验证异常
     * @param e     异常
     * @return  响应对象
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity handleBindException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.error(message);
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
        return ResponseEntity.error(message);
    }

    /**
     * 演示模式异常
     * @param e     异常
     * @return  响应对象
     */
    @ExceptionHandler(DemoModeException.class)
    public ResponseEntity handleDemoModeException(DemoModeException e) {
        return ResponseEntity.error("演示模式，不允许操作");
    }
}
