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
package net.linlan.utils.exception.file;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 文件上传异常类
 * 
 * @author Linlan
 */
public class FileUploadException extends Exception {

    private static final long serialVersionUID = 1L;

    private final Throwable   cause;

    public FileUploadException() {
        this(null, null);
    }

    public FileUploadException(final String msg) {
        this(msg, null);
    }

    public FileUploadException(String msg, Throwable cause) {
        super(msg);
        this.cause = cause;
    }

    @Override
    public void printStackTrace(PrintStream stream) {
        super.printStackTrace(stream);
        if (cause != null) {
            stream.println("Caused by:");
            cause.printStackTrace(stream);
        }
    }

    @Override
    public void printStackTrace(PrintWriter writer) {
        super.printStackTrace(writer);
        if (cause != null) {
            writer.println("Caused by:");
            cause.printStackTrace(writer);
        }
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}
