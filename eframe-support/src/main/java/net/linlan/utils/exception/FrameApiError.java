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

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Linlan
 */
@Data
@Getter
@Setter
public class FrameApiError {

    private Integer       status = 400;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String        message;

    private FrameApiError() {
        timestamp = LocalDateTime.now();
    }

    public static FrameApiError error(String message) {
        FrameApiError apiError = new FrameApiError();
        apiError.setMessage(message);
        return apiError;
    }

    public static FrameApiError error(Integer status, String message) {
        FrameApiError apiError = new FrameApiError();
        apiError.setStatus(status);
        apiError.setMessage(message);
        return apiError;
    }
}
