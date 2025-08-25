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
 * 工具类异常
 * 
 * @author Linlan
 */
public class UtilsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UtilsException(Throwable e) {
        super(e.getMessage(), e);
    }

    public UtilsException(String message) {
        super(message);
    }

    public UtilsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
