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
package net.linlan.utils.poi;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.misc.BASE64Encoder;

public class ExcelStyleUtils {

    /**
     * 生成标题样式
     * @param workbook 工作表单
     * @return  XSSFCellStyle对象
     */
    public static XSSFCellStyle getHeaderStyle(XSSFWorkbook workbook) {
        // 生成一个标题样式
        XSSFCellStyle headStyle = workbook.createCellStyle();
        // 生成一个字体
        XSSFFont headfont = workbook.createFont();
        // 加粗
        headfont.setBold(true);
        // 字体名称
        headfont.setFontName("楷体");
        // 字体大小
        headfont.setFontHeight(12);
        // 把字体应用到当前的样式
        headStyle.setFont(headfont);

        headStyle.setAlignment(HorizontalAlignment.CENTER);
        // 边框
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setBorderTop(BorderStyle.THIN);

        return headStyle;
    }

    /**
     * 生成标题样式（宋体)
     * @param workbook 工作表单
     * @return  XSSFCellStyle对象
     */
    public static XSSFCellStyle getHeaderStStyle(XSSFWorkbook workbook) {
        // 生成一个标题样式
        XSSFCellStyle headStyle = workbook.createCellStyle();
        // 生成一个字体
        XSSFFont headfont = workbook.createFont();
        // 加粗
        headfont.setBold(true);
        // 字体名称
        headfont.setFontName("宋体");
        // 字体大小
        headfont.setFontHeight(18);
        // 把字体应用到当前的样式
        headStyle.setFont(headfont);

        headStyle.setAlignment(HorizontalAlignment.CENTER);
        // 边框
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setBorderTop(BorderStyle.THIN);

        return headStyle;
    }

    /**
     * 生成第一行标题样式（宋体）
     * @param workbook 工作表单
     * @return  XSSFCellStyle对象
     */
    public static XSSFCellStyle getFirstHeaderStStyle(XSSFWorkbook workbook) {
        // 生成一个标题样式
        XSSFCellStyle firstHeaderStyle = workbook.createCellStyle();
        // 生成一个字体
        XSSFFont firstHeadfont = workbook.createFont();
        // 加粗
        firstHeadfont.setBold(true);
        // 字体名称
        firstHeadfont.setFontName("宋体");
        // 字体大小
        firstHeadfont.setFontHeight(8);
        // 把字体应用到当前的样式
        firstHeaderStyle.setFont(firstHeadfont);

        firstHeaderStyle.setWrapText(true);

        firstHeaderStyle.setAlignment(HorizontalAlignment.CENTER);
        // 边框
        firstHeaderStyle.setBorderBottom(BorderStyle.THIN);
        firstHeaderStyle.setBorderLeft(BorderStyle.THIN);
        firstHeaderStyle.setBorderRight(BorderStyle.THIN);
        firstHeaderStyle.setBorderTop(BorderStyle.THIN);

        return firstHeaderStyle;
    }

    /**
     * 生成第一行标题样式
     * @param workbook 工作表单
     * @return  XSSFCellStyle对象
     */
    public static XSSFCellStyle getFirstHeaderStyle(XSSFWorkbook workbook) {
        // 生成一个标题样式
        XSSFCellStyle firstHeaderStyle = workbook.createCellStyle();
        // 生成一个字体
        XSSFFont firstHeadfont = workbook.createFont();
        // 加粗
        firstHeadfont.setBold(true);
        // 字体名称
        firstHeadfont.setFontName("楷体");
        // 字体大小
        firstHeadfont.setFontHeight(14);
        // 把字体应用到当前的样式
        firstHeaderStyle.setFont(firstHeadfont);

        firstHeaderStyle.setAlignment(HorizontalAlignment.CENTER);

        return firstHeaderStyle;
    }

    /**
     * 生成第二行标题样式
     * @param workbook 工作表单
     * @return  XSSFCellStyle对象
     */
    public static XSSFCellStyle getSecHeaderStyle(XSSFWorkbook workbook) {
        // 生成一个标题样式
        XSSFCellStyle secHeaderStyle = workbook.createCellStyle();
        // 生成一个字体
        XSSFFont secHeadfont = workbook.createFont();
        // 加粗
        secHeadfont.setBold(true);
        // 字体名称
        secHeadfont.setFontName("楷体");
        // 字体大小
        secHeadfont.setFontHeight(11);
        // 把字体应用到当前的样式
        secHeaderStyle.setFont(secHeadfont);

        secHeaderStyle.setAlignment(HorizontalAlignment.RIGHT);

        return secHeaderStyle;
    }

    /**
     * 生成内容样式
     * @param workbook 工作表单
     * @return  XSSFCellStyle对象
     */
    public static XSSFCellStyle getContentStyle(XSSFWorkbook workbook) {
        // 内容字体样式
        XSSFFont contFont = workbook.createFont();
        // 加粗
        contFont.setBold(false);
        // 字体名称
        contFont.setFontName("楷体");
        // 字体大小
        contFont.setFontHeight(11);
        // 内容样式
        XSSFCellStyle contentStyle = workbook.createCellStyle();
        // 设置字体css
        contentStyle.setFont(contFont);
        // 边框
        contentStyle.setBorderBottom(BorderStyle.THIN);
        contentStyle.setBorderLeft(BorderStyle.THIN);
        contentStyle.setBorderRight(BorderStyle.THIN);
        contentStyle.setBorderTop(BorderStyle.THIN);

        return contentStyle;
    }

    /**
     * 生成宋体内容样式
     * @param workbook 工作表单
     * @return  XSSFCellStyle对象
     */
    public static XSSFCellStyle getContentStStyle(XSSFWorkbook workbook) {
        // 内容字体样式
        XSSFFont contFont = workbook.createFont();
        // 加粗
        contFont.setBold(false);
        // 字体名称
        contFont.setFontName("宋体");
        // 字体大小
        contFont.setFontHeight(11);
        // 内容样式
        XSSFCellStyle contentStyle = workbook.createCellStyle();
        // 设置字体css
        contentStyle.setFont(contFont);
        // 边框
        contentStyle.setBorderBottom(BorderStyle.THIN);
        contentStyle.setBorderLeft(BorderStyle.THIN);
        contentStyle.setBorderRight(BorderStyle.THIN);
        contentStyle.setBorderTop(BorderStyle.THIN);

        return contentStyle;
    }

    /**
     * 生成标题样式
     * @param workbook  工作表单
     * @param fontName  字体
     * @param isBold    是否加粗
     * @param fontHeight    字体大小
     * @param isThin    是否需要边框
     * @param align 位置
     * @return      XSSFCellStyle对象
     */
    public static XSSFCellStyle getExcelStyle(XSSFWorkbook workbook, String fontName,
                                              Boolean isBold, Double fontHeight, Boolean isThin,
                                              HorizontalAlignment align) {
        // 生成一个标题样式
        XSSFCellStyle style = workbook.createCellStyle();
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        // 加粗
        font.setBold(isBold);
        // 字体名称
        font.setFontName(fontName);
        // 字体大小
        font.setFontHeight(fontHeight);
        // 把字体应用到当前的样式
        style.setFont(font);

        style.setAlignment(align);
        if (isThin) {
            // 边框
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setBorderTop(BorderStyle.THIN);
        }
        return style;
    }

    /**
     * 设置自动换行样式
     * @param workbook  工作表单
     * @return      XSSFCellStyle对象
     */
    public static XSSFCellStyle getAutoRowStyle(XSSFWorkbook workbook) {
        XSSFCellStyle autoRowStyle = workbook.createCellStyle();
        autoRowStyle.setWrapText(true);

        return autoRowStyle;
    }

    /**
     * 下载文件时，针对不同浏览器，进行附件名的编码
     *
     * @param filename  下载文件名
     * @param agent     客户端浏览器
     * @return 编码后的下载附件名
     * @throws IOException  异常
     */
    public static String encodeDownloadFilename(String filename, String agent) throws IOException {
        if (agent.contains("Firefox")) { // 火狐浏览器
            filename = "=?UTF-8?B?" + new BASE64Encoder().encode(filename.getBytes("utf-8")) + "?=";
            filename = filename.replaceAll("\r\n", "");
        } else { // IE及其他浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        }
        return filename;
    }

}
