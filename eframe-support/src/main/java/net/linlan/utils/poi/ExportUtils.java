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

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.Page;

import net.linlan.commons.core.DateUtils;
import net.linlan.utils.dto.FileDto;
import net.linlan.utils.dto.ZipFileDto;

/**
 * Excel导出工具类
 * CreateTime 2018/10/24 14:34
 */
public class ExportUtils {
    /**
     * 时间格式化方式
     */
    public String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式化方式：字段名以"日期"结尾
     */
    public String date_format     = "yyyy-MM-dd";
    /**
     * BigDecimal 默认小数位数
     */
    public int    SCALE           = 3;

    /**
     * Excel导出工具类
     *
     * @param titles    Excel表头
     * @param columns   表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param fileName  导出的文件名称（不需要后缀）
     * @param sheetName 导出文件的sheet名称
     * @param response  response
     */
    public void export(Object[] titles, Object[] columns, List datas, String fileName,
                       String sheetName, HttpServletResponse response) {

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet1 = wb.createSheet(sheetName);
        XSSFRow header = sheet1.createRow(0);
        //设置表头信息
        XSSFCellStyle headerStyle = getHeaderStyle(wb);
        header.setHeightInPoints(20);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = header.createCell(i);
            cell.setCellValue((String) titles[i]);
            cell.setCellStyle(headerStyle);
        }

        XSSFCellStyle defaultCellStyle = getCellStyle(wb);

        XSSFCellStyle numCellStyle = getNumCellStyle(wb);
        XSSFCellStyle integerCellStyle = getIntegerCellStyle(wb);
        //填充数据
        setData(titles, columns, datas, sheet1, defaultCellStyle, numCellStyle, integerCellStyle);
        if ("序号".equals(titles[0])) {
            sheet1.setColumnWidth(0, 150 * 20);
        } else {
            sheet1.setColumnWidth(0, 300 * 20);
        }

        for (int i = 1; i < header.getPhysicalNumberOfCells(); i++) {
            sheet1.setColumnWidth(i, 300 * 20);
        }
        export(response, wb, fileName);
    }

    /**
     * Excel 创建sheet
     *
     * @param wb        工作表单
     * @param titles    Excel表头
     * @param columns   表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param sheetName 导出文件的sheet名称
     */
    public void setSheet(XSSFWorkbook wb, String[] titles, String[] columns, List datas,
                         String sheetName) {
        XSSFSheet sheet1 = wb.createSheet(sheetName);
        XSSFRow header = sheet1.createRow(0);
        //设置表头信息
        XSSFCellStyle headerStyle = getHeaderStyle(wb);
        header.setHeightInPoints(20);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = header.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(headerStyle);
        }

        XSSFCellStyle defaultCellStyle = getCellStyle(wb);

        XSSFCellStyle numCellStyle = getNumCellStyle(wb);
        XSSFCellStyle integerCellStyle = getIntegerCellStyle(wb);
        //填充数据
        setData(titles, columns, datas, sheet1, defaultCellStyle, numCellStyle, integerCellStyle);
        if ("序号".equals(titles[0])) {
            sheet1.setColumnWidth(0, 150 * 20);
        } else {
            sheet1.setColumnWidth(0, 300 * 20);
        }

        for (int i = 1; i < header.getPhysicalNumberOfCells(); i++) {
            sheet1.setColumnWidth(i, 300 * 20);
        }
    }

    /**
     * 分页导出：适合导出数量大于3万条的
     * @param titles    Excel表头
     * @param columns   表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param sheetName 导出文件的sheet名称
     * @param wb        工作表单
     * @param sheet1        工作表页
     * @param header        工作表头
     */
    public void exportByPage(String[] titles, String[] columns, Page datas, String sheetName,
                             XSSFWorkbook wb, XSSFSheet sheet1, XSSFRow header) {

        //第一页才设置表头信息
        if (datas.getPageNum() == 1) {
            XSSFCellStyle headerStyle = getHeaderStyle(wb);
            header.setHeightInPoints(20);
            for (int i = 0; i < titles.length; i++) {
                XSSFCell cell = header.createCell(i);
                cell.setCellValue(titles[i]);
                cell.setCellStyle(headerStyle);
            }
            if ("序号".equals(titles[0])) {
                sheet1.setColumnWidth(0, 150 * 20);
            } else {
                sheet1.setColumnWidth(0, 300 * 20);
            }
            for (int i = 1; i < header.getPhysicalNumberOfCells(); i++) {
                sheet1.setColumnWidth(i, 300 * 20);
            }
        }
        XSSFCellStyle defaultCellStyle = getCellStyle(wb);
        XSSFCellStyle numCellStyle = getNumCellStyle(wb);
        XSSFCellStyle integerCellStyle = getIntegerCellStyle(wb);
        setPageData(titles, columns, datas, sheet1, defaultCellStyle, numCellStyle,
            integerCellStyle);
    }

    /**
     * Excel导出工具类
     * @param titles    Excel表头
     * @param columns   表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param fileName  导出的文件名称（不需要后缀）
     * @param sheetName 导出文件的sheet名称
     */
    public void export(String[] titles, String[] columns, List datas, String fileName,
                       String sheetName) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes()).getResponse();
        export(titles, columns, datas, fileName, sheetName, response);
    }

    /**
     * 创建Excel对象
     * @param titles    Excel表头
     * @param columns   表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param sheetName 导出文件的sheet名称
     * @return      创建文件名称
     */
    public XSSFWorkbook createExcel(String[] titles, String[] columns, List datas,
                                    String sheetName) {

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet1 = wb.createSheet(sheetName);
        XSSFRow header = sheet1.createRow(0);
        //设置表头信息
        XSSFCellStyle headerStyle = getHeaderStyle(wb);
        header.setHeightInPoints(20);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = header.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(headerStyle);
        }

        XSSFCellStyle defaultCellStyle = getCellStyle(wb);

        XSSFCellStyle numCellStyle = getNumCellStyle(wb);
        XSSFCellStyle integerCellStyle = getIntegerCellStyle(wb);
        //填充数据
        setData(titles, columns, datas, sheet1, defaultCellStyle, numCellStyle, integerCellStyle);
        if ("序号".equals(titles[0])) {
            sheet1.setColumnWidth(0, 150 * 20);
        } else {
            sheet1.setColumnWidth(0, 300 * 20);
        }

        for (int i = 1; i < header.getPhysicalNumberOfCells(); i++) {
            sheet1.setColumnWidth(i, 300 * 20);
        }
        return wb;
    }

    /**
     * @param titles    Excel表头
     * @param columns   表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param fileName  导出的文件名称（不需要后缀）
     * @param sheetName 导出文件的sheet名称
     * @param response  请求响应
     * @return      导出的WB对象
     */
    public XSSFWorkbook getExportInfo(String[] titles, String[] columns, List datas,
                                      String fileName, String sheetName,
                                      HttpServletResponse response) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet1 = wb.createSheet(sheetName);
        XSSFRow header = sheet1.createRow(0);
        //设置表头信息
        XSSFCellStyle headerStyle = getHeaderStyle(wb);
        header.setHeightInPoints(20);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = header.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(headerStyle);
        }

        XSSFCellStyle defaultCellStyle = getCellStyle(wb);

        XSSFCellStyle numCellStyle = getNumCellStyle(wb);
        XSSFCellStyle integerCellStyle = getIntegerCellStyle(wb);
        //填充数据
        setData(titles, columns, datas, sheet1, defaultCellStyle, numCellStyle, integerCellStyle);
        if ("序号".equals(titles[0])) {
            sheet1.setColumnWidth(0, 150 * 20);
        } else {
            sheet1.setColumnWidth(0, 300 * 20);
        }
        for (int i = 1; i < header.getPhysicalNumberOfCells(); i++) {
            sheet1.setColumnWidth(i, 300 * 20);
        }
        return wb;
    }

    /**
     * 获取WB表头样式
     * @param wb    表单
     * @return  样式对象
     */
    private XSSFCellStyle getHeaderStyle(XSSFWorkbook wb) {
        //设置标题
        XSSFCellStyle titleStyle = wb.createCellStyle();
        // 水平居中
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setFillForegroundColor(IndexedColors.BLUE1.getIndex());

        // 垂直居中
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setBorderBottom(BorderStyle.THIN); //下边框
        titleStyle.setBorderLeft(BorderStyle.THIN);//左边框
        titleStyle.setBorderTop(BorderStyle.THIN);//上边框
        titleStyle.setBorderRight(BorderStyle.THIN);//右边框

        XSSFFont font = wb.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 13);
        //粗体显示
        font.setBold(true);
        titleStyle.setFont(font);
        return titleStyle;
    }

    /**
     * 数字表头格式
     *
     * @param wb    工作表单
     * @return  表单头样式
     */
    private XSSFCellStyle getIntegerCellStyle(XSSFWorkbook wb) {
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
        return cellStyle;
    }

    /**
     * 数字格式
     *
     * @param wb    工作表单
     * @return  数字格式表单头样式
     */
    private XSSFCellStyle getNumCellStyle(XSSFWorkbook wb) {
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        return cellStyle;
    }

    /**
     * 表头格式
     *
     * @param wb    工作表单
     * @return  表单头样式
     */
    private XSSFCellStyle getCellStyle(XSSFWorkbook wb) {
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框
        return cellStyle;
    }

    /**
     * 设置单元格的值
     *
     * @param columnName    列名称
     * @param obj   对象
     * @param cell   单元格
     * @param defaultStyle   默认样式
     * @param numCellStyle   数字样式
     * @param integerCellStyle   整形样式
     */
    private void setValue(Object columnName, Object title, Object obj, XSSFCell cell,
                          XSSFCellStyle defaultStyle, XSSFCellStyle numCellStyle,
                          XSSFCellStyle integerCellStyle) {
        if (obj == null || columnName == null || "".equals(columnName)) {
            return;
        }
        String cellValue = "";
        String methodName = "get" + columnName.toString().substring(0, 1).toUpperCase()
                            + columnName.toString().substring(1);
        Object objectValue = null;
        if (obj instanceof Map) {
            Map<String, Object> objectMap = (Map<String, Object>) obj;
            objectValue = objectMap.get(columnName);
        } else if (obj instanceof JSONObject) {
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(obj));
            if (jsonObject.containsKey(columnName)) {
                objectValue = jsonObject.get(columnName);
            }
        } else {
            objectValue = getMethodValue(methodName, obj);
        }
        if (objectValue == null) {
            return;
        }
        if (objectValue instanceof BigDecimal) {
            BigDecimal setScale = ((BigDecimal) objectValue).setScale(SCALE,
                BigDecimal.ROUND_HALF_UP);
            cell.setCellValue(setScale.doubleValue());
            cell.setCellStyle(numCellStyle);
            return;
        } else {
            if (objectValue instanceof Date && !title.toString().endsWith("日期")) {
                cellValue = DateUtils.format((Date) objectValue, DATETIME_FORMAT);
            } else if (objectValue instanceof Date && title.toString().endsWith("日期")) {
                cellValue = DateUtils.format((Date) objectValue, date_format);
            } else if (objectValue instanceof String) {
                cellValue = (String) objectValue;
            } else if (objectValue instanceof Integer) {
                cell.setCellStyle(integerCellStyle);
                cell.setCellValue((Integer) objectValue);
                return;
            } else if (objectValue instanceof Double) {
                cell.setCellStyle(numCellStyle);
                cell.setCellValue((Double) objectValue);
                return;
            } else if (objectValue instanceof Boolean) {
                if ((Boolean) objectValue) {
                    cellValue = "是";
                } else {
                    cellValue = "否";
                }
            } else {
                cellValue = objectValue.toString();
            }
            cell.setCellStyle(defaultStyle);
            cell.setCellValue(cellValue);
        }
    }

    /**
     * 是否为数字
     * @param str   字符串
     * @return  是否为数字，true，false
     */
    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+.*[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 获取方法名的值
     * @param methodName    方法名称
     * @param obj       对象
     * @param args  可变参数
     * @return return value
     */
    private static Object getMethodValue(String methodName, Object obj, Object... args) {
        Object resut = "";
        try {
            Method[] methods = obj.getClass().getMethods();
            if (methods.length <= 0) {
                return resut;
            }
            Method method = null;
            for (int i = 0, len = methods.length; i < len; i++) {
                if (methods[i].getName().equalsIgnoreCase(methodName)) {
                    method = methods[i];
                    break;
                }
            }
            if (method == null) {
                return resut;
            }
            resut = method.invoke(obj, args);
            if (resut == null) {
                resut = "";
            }
            return resut; //返回结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resut;
    }

    /** 导出WB对象
     * @param response  响应
     * @param wb    工作表单
     * @param fileName  文件名称
     */
    public void export(HttpServletResponse response, XSSFWorkbook wb, String fileName) {

        ServletOutputStream outputStream = null;
        try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition",
                "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
            response.setHeader("Content-Type", response.getContentType());
            outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();//刷新流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    Cookie cookie = new Cookie("status", "success");
                    cookie.setPath("/");
                    cookie.setMaxAge(-1);
                    response.addCookie(cookie);
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 一张Excel导出多个sheet工具类
     *
     * @param titles  Excel表头
     * @param columns 表头对应的字段，和headers一一对应
     * @param datas   需要导出的数据对象集合
     * @param wb      excel对像
     * @param sheet      excel的sheet名称
     */
    public void exportManySheet(String[] titles, String[] columns, List datas, XSSFWorkbook wb,
                                XSSFSheet sheet) {
        XSSFRow header = sheet.createRow(0);
        //设置表头信息
        XSSFCellStyle headerStyle = getHeaderStyle(wb);
        header.setHeightInPoints(20);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = header.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(headerStyle);
        }
        XSSFCellStyle cellStyle = getCellStyle(wb);
        XSSFCellStyle numCellStyle = getNumCellStyle(wb);
        XSSFCellStyle integerCellStyle = getIntegerCellStyle(wb);
        //填充数据
        setData(titles, columns, datas, sheet, cellStyle, numCellStyle, integerCellStyle);
        sheet.setColumnWidth(0, 300 * 20);
        for (int i = 1; i < header.getPhysicalNumberOfCells(); i++) {
            sheet.setColumnWidth(i, 300 * 20);
        }
    }

    /**
     * 设置数据
     * @param titles       Excel表头
     * @param columns       表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param sheet1    sheet页
     * @param cellStyle 通用样式
     * @param numCellStyle   数字样式
     * @param integerCellStyle   整形样式
     */
    private void setData(Object[] titles, Object[] columns, List datas, XSSFSheet sheet1,
                         XSSFCellStyle cellStyle, XSSFCellStyle numCellStyle,
                         XSSFCellStyle integerCellStyle) {
        for (int i = 0; i < datas.size(); i++) {
            Object obj = datas.get(i);
            XSSFRow row = sheet1.createRow(i + 1);
            row.setHeightInPoints(20);
            for (int j = 0; j < titles.length; j++) {
                XSSFCell cell = row.createCell(j);
                setValue(columns[j], titles[j], obj, cell, cellStyle, numCellStyle,
                    integerCellStyle);
            }
        }
    }

    /**
     * 设置页面数据
     * @param titles       Excel表头
     * @param columns       表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param sheet1    sheet页
     * @param cellStyle 通用样式
     * @param numCellStyle   数字样式
     * @param integerCellStyle   整形样式
     */
    private void setPageData(String[] titles, String[] columns, Page datas, XSSFSheet sheet1,
                             XSSFCellStyle cellStyle, XSSFCellStyle numCellStyle,
                             XSSFCellStyle integerCellStyle) {
        int start = (datas.getPageNum() - 1) * datas.getPageSize();
        for (int i = 0; i < +datas.size(); i++) {
            Object obj = datas.get(i);
            XSSFRow row = sheet1.createRow(start + i + 1);
            row.setHeightInPoints(20);
            for (int j = 0; j < titles.length; j++) {
                XSSFCell cell = row.createCell(j);
                setValue(columns[j], titles[j], obj, cell, cellStyle, numCellStyle,
                    integerCellStyle);
            }
        }
    }

    /**
     * Excel导出Zip工具类
     *
     * @param titles    Excel表头
     * @param columns   表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param fileName  导出的文件名称（不需要后缀）
     * @param sheetName 导出文件的sheet名称
     * @param response  response
     * @return 文件对象
     */
    public FileDto getExportFile(String[] titles, String[] columns, List datas, String fileName,
                                 String sheetName, HttpServletResponse response) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet1 = wb.createSheet(sheetName);
        XSSFRow header = sheet1.createRow(0);
        //设置表头信息
        XSSFCellStyle headerStyle = getHeaderStyle(wb);
        header.setHeightInPoints(20);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = header.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(headerStyle);
        }

        XSSFCellStyle defaultCellStyle = getCellStyle(wb);
        XSSFCellStyle numCellStyle = getNumCellStyle(wb);
        XSSFCellStyle integerCellStyle = getIntegerCellStyle(wb);
        //填充数据
        setData(titles, columns, datas, sheet1, defaultCellStyle, numCellStyle, integerCellStyle);
        if ("序号".equals(titles[0])) {
            sheet1.setColumnWidth(0, 150 * 20);
        } else {
            sheet1.setColumnWidth(0, 300 * 20);
        }

        for (int i = 1; i < header.getPhysicalNumberOfCells(); i++) {
            sheet1.setColumnWidth(i, 300 * 20);
        }
        FileDto fileDto = getFileDto(wb, fileName);
        return fileDto;
    }

    /**
     * 获取文件对象
     * @param wb    工作表单
     * @param fileName  文件名称
     * @return  文件对象
     */
    public FileDto getFileDto(XSSFWorkbook wb, String fileName) {
        try {
            FileDto fileDto = new FileDto();
            fileDto.setFileName(fileName + ".xlsx");
            // 创建一个ByteArrayOutputStream用于存储数据
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            // 将XSSFWorkbook写入ByteArrayOutputStream
            wb.write(out);
            fileDto.setStream(out);
            out.close(); // 关闭流释出系统资源
            return fileDto;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 打包成zip下载
     * @param response  响应
     * @param fileDTO   文件zip
     */
    public void downloadZipFile(HttpServletResponse response, ZipFileDto fileDTO) {
        List<String> names = fileDTO.getFileNames();
        List<ByteArrayOutputStream> streams = fileDTO.getStreams();
        //输出Excel文件
        try (OutputStream output = response.getOutputStream();
                ZipOutputStream zipStream = new ZipOutputStream(output)) {
            String filename = URLEncoder.encode(fileDTO.getZipFileName(),
                StandardCharsets.UTF_8.toString());
            response.setHeader("Content-Disposition",
                "attachment;filename=" + filename + ";filename*=utf-8''" + filename);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());

            //创建压缩文件,并进行打包
            for (int i = 0; i < names.size(); i++) {
                ZipEntry z = new ZipEntry(names.get(i));
                zipStream.putNextEntry(z);
                streams.get(i).writeTo(zipStream);
            }
            zipStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取一个文件，暂存入ByteArrayOutputStream
     *
     * @param fullPath 文件路径
     * @return  流数据
     */
    public ByteArrayOutputStream getByteArrayOutputStream(String fullPath) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (FileInputStream inputStream = new FileInputStream(fullPath)) {
            //小数组大法读取文件流，提高性能
            byte[] buff = new byte[8 * 1024];
            int len;
            while (-1 != (len = inputStream.read(buff))) {
                outputStream.write(buff, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream;
    }

}
