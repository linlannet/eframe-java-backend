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
package net.linlan.utils.upload;

import net.linlan.commons.core.StringUtils;

/**
 *
 * Filename:ResourceType.java
 * Desc:
 * File Browser resource types. The File Browser provides a specific resource
 * type for each and every request. This class is intended to reflect these in
 * an Enum-like manner.
 * <p>
 * The resource types are:
 * <ul>
 * <li>File</li>
 * <li>Document</li>
 * <li>Image</li>
 * <li>Media</li>
 * </ul>
 * @author Linlan
 * CreateTime:2017/7/12 19:56
 *
 * @version 1.0
 * @since 1.0
 *
 */
public class ResourceType {

    /**
     * 数据库
     */
    public static String DATABASE_SUFFIX     = "sql|dmp|mdf";

    /**
     * 电子期刊
     */
    public static String EJOURNAL_SUFFIX     = "exe|bin|dmg";

    /**
     * 电子图书
     */
    public static String EBOOK_SUFFIX        = "exe|bat|bin";

    /**
     * 文件
     */
    public static String DOCUMENT_SUFFIX     = "csv|ods|odt|ofd|pdf|rtf|txt|doc|ppt|vsd|xls|docx|pptx|vsdx|xlsx|pages|zip|rar";

    /**
     * 网页
     */
    public static String SOURCE_FRONT_SUFFIX = "htm|html|php|jsp|jspx|asp|aspx|js|css|mht|mhtml|ts";

    /**
     * 文件，源代码
     */
    public static String SOURCE_STAGE_SUFFIX = "xml|chm|java|c|cpp|h|hpp|go|cs|vb|py|vue";

    /**
     * 图片图像
     */
    public static String IMAGE_SUFFIX        = "bmp|gif|jpeg|jpg|png|tif|tiff|svg";
    /**
     * 声音视频
     */
    public static String MEDIA_SUFFIX        = "asf|avi|fla|flv|f4v|mid|mov|mp3|mp4|mpc|mpeg|mpg|ram|rm|rmi|rmvb|swf|wav|wma|wmv|3gp|3gpp";

    /**
     * 链接
     */
    public static String LINK_SUFFIX         = "ln|shortcut";

    /**
     * 文件
     */
    public static String FILE_SUFFIX         = IMAGE_SUFFIX + "|" + MEDIA_SUFFIX + "|"
                                               + DOCUMENT_SUFFIX;

    /**
     * 全部文件类型，包括页面、源码
     */
    public static String ALL_FILE_SUFFIX     = FILE_SUFFIX + "|" + SOURCE_STAGE_SUFFIX + "|"
                                               + SOURCE_FRONT_SUFFIX;

    /** 通过文件扩展名后缀获取资源类型
     * @param extension 文件扩展名
     * @return 返回扩展名对应的类型
     */
    public static String valueOfByExt(final String extension) {
        if (StringUtils.isBlank(extension)) {
            return "null";
        }

        //优先考虑图片类型
        if (IMAGE_SUFFIX.contains(extension)) {
            return "IMAGE";
        } else if (MEDIA_SUFFIX.contains(extension)) {
            return "MEDIA";
        } else if (DOCUMENT_SUFFIX.contains(extension)) {
            return "DOCUMENT";
        } else if (SOURCE_FRONT_SUFFIX.contains(extension)) {
            return "DOC-FRONT";
        } else if (SOURCE_STAGE_SUFFIX.contains(extension)) {
            return "DOC-STAGE";
        }
        return "FILE";
    }

}
