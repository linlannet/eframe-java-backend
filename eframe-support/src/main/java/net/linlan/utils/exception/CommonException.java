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

/**
 *
 * Filename:ServiceException.java
 * Desc:抛出异常错误信息,新增msg和code，在本系统内进行异常的消息和状态进行显示
 *
 * @author Linlan
 * CreateTime:2017/12/5 22:21
 *
 * @version 1.0
 * @since 1.0
 *
 */
public final class CommonException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer           code             = 500;

    /**
     * 错误提示
     */
    private String            message;

    /**
     * 错误明细，内部调试错误
     *
     * 和 {@link CommonException#getDetailMessage()} 一致的设计
     */
    private String            detailMessage;

    /**
     * 空构造方法，避免反序列化问题
     */
    public CommonException() {
    }

    public CommonException(String message) {
        this.message = message;
    }

    /**
     * Constructs a new commons utils exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     * @param   code   the http status. {@link #getCode()} method.
     */
    public CommonException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public CommonException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.setCode(errorCode);
        this.setMessage(message);
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public CommonException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public CommonException setMessage(String message) {
        this.message = message;
        return this;
    }

    public CommonException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }
}
