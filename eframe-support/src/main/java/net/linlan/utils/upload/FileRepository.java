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

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import net.linlan.commons.core.FilePathUtils;
import net.linlan.commons.core.StringUtils;

/**
 *
 * Filename:FileRepository.java
 * Desc: 本地文件存储包装类
 *
 * @author Linlan
 * CreateTime:2017/6/19 14:36
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Component
public class FileRepository implements ServletContextAware {

    /** The log. */
    private Logger log = LoggerFactory.getLogger(FileRepository.class);

    /**
     * Store by ext.
     *
     * @param path
     *            the path
     * @param ext
     *            the ext
     * @param file    文件
     *            the file
     * @return the string
     * @throws IOException
     *             Signals that an I/O exceptions has occurred.
     */
    public String storeByExt(String path, String ext, MultipartFile file) throws IOException {
        String filename = FilePathUtils.getPathOfDay(path, ext);
        File dest = new File(getRealPath(filename));
        //        dest = FilePathUtils.getUniqueFile(dest);
        store(file, dest);
        return filename;
    }

    /**
     * Store by filename.
     *
     * @param filename
     *            the filename
     * @param file    文件
     *            the file
     * @return the string
     * @throws IOException
     *             Signals that an I/O exceptions has occurred.
     */
    public String storeByFilename(String filename, MultipartFile file) throws IOException {
        File dest = new File(getRealPath(filename));
        store(file, dest);
        return filename;
    }

    /**
     * Store.
     *
     * @param file    文件
     *            the file
     * @param dest
     *            the dest
     * @throws IOException
     *             Signals that an I/O exceptions has occurred.
     */
    private void store(MultipartFile file, File dest) throws IOException {
        try {
            FilePathUtils.checkDirAndCreate(dest.getParentFile());
            file.transferTo(dest);
        } catch (IOException e) {
            log.error("Transfer file error when upload file", e);
            throw e;
        }
    }

    /**
     * Retrieve.
     *
     * @param name  the name
     * @return the file
     */
    public File retrieve(String name) {
        return new File(ctx.getRealPath(name));
    }

    /**
     * Gets the real path.
     *
     * @param name    the name
     * @return the real path
     */
    private String getRealPath(String name) {
        String realpath = ctx.getRealPath(name);
        //判断文件是否存在
        if (realpath == null) {
            //文件不存在，则进行创建
            realpath = ctx.getRealPath(StringUtils.SLASH) + name;
        }
        return realpath;
    }

    public String storeByExtWithRealPath(String realPath, String prefix, String ext,
                                         MultipartFile file) throws IOException {
        String filename = FilePathUtils.getPathOfDay(prefix, ext);
        //        File dest = new File(getRealPath(filename));
        File dest = new File(realPath + filename);
        log.info("文件存储路径为:" + dest.getPath());
        storeShare(file, dest);
        return filename;
    }

    private void storeShare(MultipartFile file, File dest) throws IOException {
        try {
            FilePathUtils.checkDirAndCreate(dest.getParentFile());
            //file.transferTo(dest);
            FileUtils.copyInputStreamToFile(file.getInputStream(), dest);
        } catch (IOException e) {
            log.error("Transfer file error when upload file", e);
            throw e;
        }
    }

    /** The ctx. */
    private ServletContext ctx;

    /* (non-Javadoc)
     * Title:setServletContext
     * @param servletContext
     * @see org.springframework.web.context.ServletContextAware#setServletContext(jakarta.servlet.ServletContext)
     */
    public void setServletContext(ServletContext servletContext) {
        this.ctx = servletContext;
    }
}
