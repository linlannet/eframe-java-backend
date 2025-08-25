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
package net.linlan.utils.file;

/**
 * 媒体类型工具类
 * 
 * @author Linlan
 */
public class MimeTypeUtils {
    public static final String   IMAGE_PNG                 = "image/png";

    public static final String   IMAGE_JPG                 = "image/jpg";

    public static final String   IMAGE_JPEG                = "image/jpeg";

    public static final String   IMAGE_BMP                 = "image/bmp";

    public static final String   IMAGE_GIF                 = "image/gif";

    public static final String[] IMAGE_EXTENSION           = { "bmp", "gif", "jpg", "jpeg", "png" };

    public static final String[] FLASH_EXTENSION           = { "swf", "flv" };

    public static final String[] MEDIA_EXTENSION           = { "swf", "flv", "mp3", "wav", "wma",
                                                               "wmv", "mid", "avi", "mpg", "asf",
                                                               "rm", "rmvb" };

    public static final String[] VIDEO_EXTENSION           = { "mp4", "avi", "rmvb" };

    public static final String[] DEFAULT_ALLOWED_EXTENSION = {
                                                               // 图片
                                                               "bmp", "gif", "jpg", "jpeg", "png",
                                                               // word excel powerpoint
                                                               "doc", "docx", "xls", "xlsx", "ppt",
                                                               "pptx", "html", "htm", "txt",
                                                               // 压缩文件
                                                               "rar", "zip", "gz", "bz2",
                                                               // 视频格式
                                                               "mp4", "avi", "rmvb",
                                                               // pdf
                                                               "pdf" };

    public static String getExtension(String prefix) {
        switch (prefix) {
            case IMAGE_PNG:
                return "png";
            case IMAGE_JPG:
                return "jpg";
            case IMAGE_JPEG:
                return "jpeg";
            case IMAGE_BMP:
                return "bmp";
            case IMAGE_GIF:
                return "gif";
            default:
                return "";
        }
    }
}
