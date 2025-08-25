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

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.*;

import net.linlan.commons.core.CollectionUtils;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.script.json.JsonMapUtils;
import net.linlan.utils.dto.CheckRow;

/**
 * Excel读取器
 * 读取Excel工作簿
 *CreateTime  2021年12月13日14:08:53
 * @since 3.1.0
 */
public class ExcelReader {
    /**
     * 工作簿
     */
    protected Workbook          workbook;
    /**
     * Excel中对应的Sheet
     */
    protected Sheet             sheet;

    /** 是否忽略空行 */
    private boolean             ignoreEmptyRow   = true;
    /**
     *  行名称所在行数
     */
    private int                 titleRow         = 1;
    /**
     *  标题别名
     *  格式为：key 中文列名，value
     */
    private Map<String, String> headerAlias      = new HashMap<>();
    /**
     * 忽略Excel模板表头
     */
    private boolean             ignoreHeaderName = false;

    // ------------------------------------------ Constructor start

    /**
     * 构造
     *
     * @param bookFile Excel文件
     */
    public ExcelReader(File bookFile) {
        try {
            workbook = WorkbookFactory.create(bookFile);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造
     * 
     * @param bookFile Excel文件
     * @param sheetIndex sheet序号，0表示第一个sheet
     */
    public ExcelReader(File bookFile, int sheetIndex) {
        try {
            workbook = WorkbookFactory.create(bookFile);
            sheet = workbook.getSheetAt(sheetIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 是否忽略空行
     * 
     * @return 是否忽略空行
     */
    public boolean isIgnoreEmptyRow() {
        return ignoreEmptyRow;
    }

    /**
     * 设置是否忽略空行
     * 
     * @param ignoreEmptyRow 是否忽略空行
     * @return this
     */
    public ExcelReader setIgnoreEmptyRow(boolean ignoreEmptyRow) {
        this.ignoreEmptyRow = ignoreEmptyRow;
        return this;
    }

    /**
     * 获得标题行的别名Map
     * 
     * @return 别名Map
     */
    public Map<String, String> getHeaderAlias() {
        return headerAlias;
    }

    /**
     * 设置标题行的别名Map
     * 
     * @param headerAlias 别名Map
     * @return this
     */
    public ExcelReader setHeaderAlias(Map<String, String> headerAlias) {
        this.headerAlias = headerAlias;
        return this;
    }

    /**
     * 增加标题别名
     * 
     * @param header 标题
     * @param alias 别名
     * @return this
     */
    public ExcelReader addHeaderAlias(String header, String alias) {
        this.headerAlias.put(header, alias);
        return this;
    }

    /**
     * 去除标题别名
     * 
     * @param header 标题
     * @return this
     */
    public ExcelReader removeHeaderAlias(String header) {
        this.headerAlias.remove(header);
        return this;
    }
    // ------------------------------------------------------------------------------------------------------- Getters and Setters end

    /**
     * 读取Excel为Map的列表，读取所有行，默认第一行做为标题，数据从第二行开始
     * Map表示一行，标题为key，单元格内容为value
     * 
     * @return Map的列表
     */
    public List<Map<String, Object>> readAll() {
        return read(titleRow - 1, titleRow, Integer.MAX_VALUE);
    }

    /**
     * 读取Excel为Bean的列表，读取所有行，默认第一行做为标题，数据从第二行开始
     * 
     * @param <T> Bean类型
     * @param beanType 每行对应Bean的类型
     * @return Map的列表
     */
    public <T> List<T> readAll(Class<T> beanType) {
        return read(titleRow - 1, titleRow, Integer.MAX_VALUE, beanType);
    }

    /**
     * 读取Excel为Bean的列表
     * 
     * @param <T> Bean类型
     * @param headerRowIndex 标题所在行，如果标题行在读取的内容行中间，这行做为数据将忽略，，从0开始计数
     * @param startRowIndex 起始行（包含，从0开始计数）
     * @param beanType 每行对应Bean的类型
     * @return Map的列表
     * @since 4.0.1
     */
    public <T> List<T> read(int headerRowIndex, int startRowIndex, Class<T> beanType) {
        return read(headerRowIndex, startRowIndex, Integer.MAX_VALUE, beanType);
    }

    /**
     * 读取一行
     *
     * @param row 行
     * @return 单元格值列表
     */
    public static List<Object> readRow(Row row) {
        if (null == row) {
            return new ArrayList<>(0);
        }
        final short length = row.getLastCellNum();
        if (length < 0) {
            return new ArrayList<>(0);
        }
        final List<Object> cellValues = new ArrayList<>(length);
        Object cellValue;
        boolean isAllNull = true;
        for (short i = 0; i < length; i++) {
            cellValue = getCellValue(row.getCell(i),
                row.getCell(i) == null ? null : row.getCell(i).getCellType());
            isAllNull &= ObjectUtils.isEmpty(cellValue);
            cellValues.add(cellValue);
        }

        if (isAllNull) {
            // 如果每个元素都为空，则定义为空行
            return new ArrayList<>(0);
        }
        return cellValues;
    }

    /**
     * 获取单元格值
     * 如果单元格值为数字格式，则判断其格式中是否有小数部分，无则返回Long类型，否则返回Double类型
     *
     * @param cell       {@link Cell}单元格
     * @param cellType   单元格值类型{@link CellType}枚举，如果为{@code null}默认使用cell的类型
     * @return 值，类型可能为：Date、Double、Boolean、String
     */
    public static Object getCellValue(Cell cell, CellType cellType) {
        if (null == cell) {
            return null;
        }
        if (null == cellType) {
            cellType = cell.getCellTypeEnum();
        }

        if (CellType.BLANK == cellType) {
            // 空白单元格可能为合并单元格
            cell = getMergedRegionCell(cell);
            cellType = cell.getCellTypeEnum();
        }

        Object value;
        switch (cellType) {
            case NUMERIC:
                value = getNumericValue(cell);
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case FORMULA:
                // 遇到公式时查找公式结果类型
                value = getCellValue(cell, cell.getCachedFormulaResultTypeEnum());
                break;
            case BLANK:
                value = StringUtils.EMPTY;
                break;
            case ERROR:
                final FormulaError error = FormulaError.forInt(cell.getErrorCellValue());
                value = (null == error) ? StringUtils.EMPTY : error.getString();
                break;
            default:
                value = cell.getStringCellValue();
        }

        return value;
    }

    /**
     * 获取合并单元格
     * 传入的x,y坐标（列行数）可以是合并单元格范围内的任意一个单元格
     *
     * @param cell {@link Cell}
     * @return 合并单元格
     * @since 5.1.5
     */
    public static Cell getMergedRegionCell(Cell cell) {
        return getMergedRegionCell(cell.getSheet(), cell.getColumnIndex(), cell.getRowIndex());
    }

    /**
     * 获取合并单元格
     * 传入的x,y坐标（列行数）可以是合并单元格范围内的任意一个单元格
     *
     * @param sheet {@link Sheet}
     * @param x     列号，从0开始，可以是合并单元格范围中的任意一列
     * @param y     行号，从0开始，可以是合并单元格范围中的任意一行
     * @return 合并单元格，如果非合并单元格，返回坐标对应的单元格
     * @since 5.1.5
     */
    public static Cell getMergedRegionCell(Sheet sheet, int x, int y) {
        final List<CellRangeAddress> addrs = sheet.getMergedRegions();

        int firstColumn;
        int lastColumn;
        int firstRow;
        int lastRow;
        for (CellRangeAddress ca : addrs) {
            firstColumn = ca.getFirstColumn();
            lastColumn = ca.getLastColumn();
            firstRow = ca.getFirstRow();
            lastRow = ca.getLastRow();

            if (y >= firstRow && y <= lastRow) {
                if (x >= firstColumn && x <= lastColumn) {
                    return SheetUtil.getCell(sheet, firstRow, firstColumn);
                }
            }
        }

        return SheetUtil.getCell(sheet, y, x);
    }

    /**
     *
     * 获取数字类型的单元格值
     *
     * @param cell 单元格
     * @return 单元格值，可能为Long、Double、Date
     */
    private static Object getNumericValue(Cell cell) {
        final double value = cell.getNumericCellValue();

        final CellStyle style = cell.getCellStyle();
        if (null != style) {
            final short formatIndex = style.getDataFormat();
            // 判断是否为日期
            if (isDateType(cell, formatIndex)) {
                return cell.getDateCellValue();
            }

            final String format = style.getDataFormatString();
            // 普通数字
            if (null != format && format.indexOf(StringUtils.C_DOT) < 0) {
                final long longPart = (long) value;
                if (((double) longPart) == value) {
                    // 对于无小数部分的数字类型，转为Long
                    return longPart;
                }
            }
        }

        // 某些Excel单元格值为double计算结果，可能导致精度问题，通过转换解决精度问题。
        return Double.parseDouble(NumberToTextConverter.toText(value));
    }

    /**
     * 是否为日期格式
     * 判断方式：
     *
     * <pre>
     * 1、指定序号
     * 2、org.apache.poi.ss.usermodel.DateUtil.isADateFormat方法判定
     * </pre>
     *
     * @param cell        单元格
     * @param formatIndex 格式序号
     * @return 是否为日期格式
     */
    private static boolean isDateType(Cell cell, int formatIndex) {
        // yyyy-MM-dd----- 14
        // yyyy年m月d日---- 31
        // yyyy年m月------- 57
        // m月d日 ---------- 58
        // HH:mm----------- 20
        // h时mm分 -------- 32
        if (formatIndex == 14 || formatIndex == 31 || formatIndex == 57 || formatIndex == 58
            || formatIndex == 20 || formatIndex == 32) {
            return true;
        }

        return DateUtil.isCellDateFormatted(cell);
    }

    /**
     * 读取Excel为Bean的列表
     * 
     * @param <T> Bean类型
     * @param headerRowIndex 标题所在行，如果标题行在读取的内容行中间，这行做为数据将忽略，，从0开始计数
     * @param startRowIndex 起始行（包含，从0开始计数）
     * @param endRowIndex 读取结束行（包含，从0开始计数）
     * @param beanType 每行对应Bean的类型
     * @return Map的列表
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> read(int headerRowIndex, int startRowIndex, int endRowIndex,
                            Class<T> beanType) {
        final List<Map<String, Object>> mapList = read(headerRowIndex, startRowIndex, endRowIndex);
        if (Map.class.isAssignableFrom(beanType)) {
            return (List<T>) mapList;
        }

        final List<T> beanList = new ArrayList<>(mapList.size());
        for (Map<String, Object> map : mapList) {
            beanList.add((T) JsonMapUtils.mapToObject(map, beanType));
        }
        return beanList;
    }

    /**
     * 读取Excel为Map的列表
     * Map表示一行，标题为key，单元格内容为value
     *
     * @param headerRowIndex 标题所在行，如果标题行在读取的内容行中间，这行做为数据将忽略
     * @param startRowIndex 起始行（包含，从0开始计数）
     * @param endRowIndex 读取结束行（包含，从0开始计数）
     * @return Map的列表
     */
    public List<Map<String, Object>> read(int headerRowIndex, int startRowIndex, int endRowIndex) {
        // 边界判断
        final int firstRowNum = sheet.getFirstRowNum();
        final int lastRowNum = sheet.getLastRowNum();
        if (headerRowIndex < firstRowNum) {
            throw new IndexOutOfBoundsException(
                StringUtils.format("Header row index {} is lower than first row index {}.",
                    headerRowIndex, firstRowNum));
        } else if (headerRowIndex > lastRowNum) {
            throw new IndexOutOfBoundsException(
                StringUtils.format("Header row index {} is greater than last row index {}.",
                    headerRowIndex, firstRowNum));
        }
        startRowIndex = Math.max(startRowIndex, firstRowNum);// 读取起始行（包含）
        endRowIndex = Math.min(endRowIndex, lastRowNum);// 读取结束行（包含）

        // 读取header
        List<Object> headerList = readRow(sheet.getRow(headerRowIndex));

        final List<Map<String, Object>> result = new ArrayList<>(endRowIndex - startRowIndex + 1);
        List<Object> rowList;
        for (int i = startRowIndex; i <= endRowIndex; i++) {
            if (i != headerRowIndex) {
                // 跳过标题行
                rowList = readRow(sheet.getRow(i));
                if (!CollectionUtils.isEmpty(rowList) || false == ignoreEmptyRow) {
                    List<String> headers = aliasHeader(headerList);
                    Map value = toMap(null == headers ? null : headers.iterator(),
                        rowList == null ? null : rowList.iterator());
                    result.add(value);
                }
            }
        }
        return result;
    }

    /**
     * 根据是否*开头验证是否有非空校验
     * @return  反馈行检查是否符合
     */
    public List<CheckRow> checkRows() {
        List<CheckRow> result = new ArrayList<>();
        List<Map<String, Object>> dataList = this.readAll();
        int i = titleRow + 1;
        Map<String, String> needCheckMap = getNeedCheckMap();
        for (Map<String, Object> row : dataList) {
            CheckRow checkRow = new CheckRow();
            StringBuffer reason = new StringBuffer();
            for (String key : row.keySet()) {
                Object value = row.get(key);
                String needCheck = needCheckMap.get(key);
                if (needCheck != null
                    && (value == null || (value != null && "".equals(value.toString())))) {
                    reason.append(needCheck + "为空;");
                }
            }
            if (!"".equals(reason.toString())) {
                checkRow.setRow(i);
                checkRow.setReason(reason.toString());
                result.add(checkRow);
            }
            i++;
        }
        return result;
    }

    /**
     * @return  是否需要检查的数值
     */
    private Map<String, String> getNeedCheckMap() {
        Map<String, String> result = new HashMap<>();
        for (String key : headerAlias.keySet()) {
            String value = headerAlias.get(key).toString();
            if (key != null && key.startsWith("*")) {
                String aa = key.replace("*", "");
                result.put(value, aa);
            }
        }
        return result;

    }

    /** 获取map对象
     * @param keys  迭代器keys
     * @param values    迭代器values
     * @param <K>   键
     * @param <V>   值
     * @return      返回KV对象
     */
    public static <K, V> Map<K, V> toMap(Iterator<K> keys, Iterator<V> values) {

        final Map<K, V> resultMap = new HashMap<>();
        if (keys != null) {
            while (keys.hasNext()) {
                resultMap.put(keys.next(),
                    (null != values && values.hasNext()) ? values.next() : null);
            }
        }
        return resultMap;
    }

    /**
     * 转换标题别名，如果没有别名则使用原标题，当标题为空时，列号对应的字母便是header
     *
     * @param headerList 原标题列表
     * @return 转换别名列表
     */
    private List<String> aliasHeader(List<Object> headerList) {
        final int size = headerList.size();
        final ArrayList<String> result = new ArrayList<>(size);
        if (CollectionUtils.isEmpty(headerList)) {
            return result;
        }

        for (int i = 0; i < size; i++) {
            result.add(aliasHeader(headerList.get(i), i));
        }
        return result;
    }

    /**
     * 转换标题别名，如果没有别名则使用原标题，当标题为空时，列号对应的字母便是header
     *
     * @param headerObj 原标题
     * @param index 标题所在列号，当标题为空时，列号对应的字母便是header
     * @return 转换别名列表
     */
    private String aliasHeader(Object headerObj, int index) {
        if (null == headerObj || ignoreHeaderName) {
            return indexToColName(index);
        }

        final String header = headerObj.toString();
        return defaultIfNull(this.headerAlias.get(header), header);
    }

    /** 默认值是否为空
     * @param object    检查的对象
     * @param defaultValue  默认值
     * @param <T>   泛型对象
     * @return  对象
     */
    public static <T> T defaultIfNull(final T object, final T defaultValue) {
        return (null != object) ? object : defaultValue;
    }

    /**
     * 将Sheet列号变为列名
     *
     * @param index 列号, 从0开始
     * @return 0-》A; 1-》B...26-》AA
     */
    public static String indexToColName(int index) {
        if (index < 0) {
            return null;
        }
        final StringBuilder colName = StringUtils.builder();
        do {
            if (colName.length() > 0) {
                index--;
            }
            int remainder = index % 26;
            colName.append((char) (remainder + 'A'));
            index = (index - remainder) / 26;
        } while (index > 0);
        return colName.reverse().toString();
    }

    /**
     * 读取为文本格式
     * 使用{@link ExcelExtractor} 提取Excel内容
     * 
     * @param withSheetName 是否附带sheet名
     * @return Excel文本
     */
    public String readAsText(boolean withSheetName) {
        final ExcelExtractor extractor = getExtractor();
        extractor.setIncludeSheetNames(withSheetName);
        return extractor.getText();
    }

    /**
     * 获取 {@link ExcelExtractor} 对象
     * 
     * @return {@link ExcelExtractor}   对象
     */
    public ExcelExtractor getExtractor() {
        ExcelExtractor extractor;
        Workbook wb = this.workbook;
        if (wb instanceof HSSFWorkbook) {
            extractor = new org.apache.poi.hssf.extractor.ExcelExtractor((HSSFWorkbook) wb);
        } else {
            extractor = new XSSFExcelExtractor((XSSFWorkbook) wb);
        }
        return extractor;
    }

    /**
     * excel导入
     * 获取excel表格中图片
     *
     * @param xssfSheet XSSF表格
     * @return  excel表格中图片
     */
    public static Map<String, XSSFPictureData> getPictures(XSSFSheet xssfSheet) {
        Map<String, XSSFPictureData> map = new HashMap<>();
        List<POIXMLDocumentPart> partList = xssfSheet.getRelations();
        //		XSSFDrawing drawing = xssfSheet.getDrawingPatriarch();
        for (POIXMLDocumentPart part : partList) {
            //if中获取图片并处理对应行数据
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                if (drawing != null) {
                    List<XSSFShape> list = drawing.getShapes();
                    if (list != null) {
                        for (XSSFShape shape : list) {
                            if (shape instanceof XSSFPicture) {
                                XSSFPicture picture = (XSSFPicture) shape;
                                //行号-列号
                                XSSFClientAnchor xssfClientAnchor = (XSSFClientAnchor) picture
                                    .getAnchor();
                                //获取图片
                                XSSFPictureData pdata = picture.getPictureData();
                                // 行号-列号
                                String key = xssfClientAnchor.getRow1() + "-"
                                             + xssfClientAnchor.getCol1();
                                map.put(key, pdata);
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public int getTitleRow() {
        return titleRow;
    }

    public void setTitleRow(int titleRow) {
        this.titleRow = titleRow;
    }
}
