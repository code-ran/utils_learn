package com.ransibi.Excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ExcelUtil {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try {
            dataToExcelUnitTable();
        } catch (Exception e) {
            log.error("导出数据失败100", e);
        }
    }

    /**
     * 合并单元格案例.
     * 因为合并的特性无法封装为通用函数.
     */
    private static void dataToExcelUnitTable() {
        ByteArrayOutputStream bas = null;
        final Workbook workbook = new XSSFWorkbook();
        try {
            // 创建工作表
            final Sheet sheet = workbook.createSheet("充电保护巡视导出");
            // 设置表头样式
            final CellStyle headerCellStyle = createHeadStyle(workbook);
            // 填充表头数据
            final List<List<String>> headerData = new ArrayList<List<String>>();
            // 制造表头的数据
            headerData.add(Arrays.asList("地区,厂站,装置,结果,软压板,软压板,开关量,开关量,时间".split(",")));
            headerData.add(Arrays.asList("地区,厂站,装置,结果,名称,值,名称,值,时间".split(",")));
            for (int i = 0; i < headerData.size(); i++) {
                // 创建表头行
                final Row headerRow = sheet.createRow(i);
                for (int j = 0; j < headerData.get(i).size(); j++) {
                    Cell cell = headerRow.createCell(j);
                    cell.setCellValue(headerData.get(i).get(j).toString());
                    cell.setCellStyle(headerCellStyle);
                    sheet.setColumnWidth(j, 5000); //设置列宽度
                }
            }
            //表头垂直合并
            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
            sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
            sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 2));
            sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
            sheet.addMergedRegion(new CellRangeAddress(0, 1, 9, 9));
            //表头水平合并
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 5, 6));
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 8));
            //表头已经占用的行数
            final int tbHeadUseNo = headerData.size();
            // 设置表数据样式
            final CellStyle tbStyle = createDataStyle(workbook);
            final List<List<String>> tableData = new ArrayList<List<String>>();
            // 造点数据
            tableData.add(Arrays.asList("白银", "330kV永登变", "保护1", "正常", "充电过流保护软压板", "投", "充电过流保护硬压板", "投", "2024-09-19"));
            tableData.add(Arrays.asList("白银", "330kV永登变", "保护1", "正常", "-", "-", "充电保护投入", "退", "2024-09-19"));

            tableData.add(Arrays.asList("白银", "330kV永登变", "保护2", "异常", "充电过流保护软压板1", "投", "充电过流保护硬压板1", "投", "2024-09-19"));
            tableData.add(Arrays.asList("白银", "330kV永登变", "保护2", "异常", "充电过流保护软压板1", "投", "-", "-", "2024-09-19"));

            tableData.add(Arrays.asList("白银", "330kV永登变", "保护3", "正常", "充电过流保护软压板2", "投", "充电过流保护硬压板2", "投", "2024-09-19"));
            tableData.add(Arrays.asList("白银", "330kV永登变", "保护3", "正常", "充电过流保护软压板2", "投", "-", "-", "2024-09-19"));

            tableData.add(Arrays.asList("测试", "测试变", "保护4", "异常", "充电过流保护软压板3", "退", "-", "-", "2024-09-19"));
            tableData.add(Arrays.asList("测试", "测试变", "保护4", "异常", "-", "-", "-", "-", "2024-09-19"));

            for (int rowIndex = 0; rowIndex < tableData.size(); rowIndex++) {
                //创建每一行
                final Row row = sheet.createRow(rowIndex + tbHeadUseNo);
                final List<String> rowData = tableData.get(rowIndex);
                for (int columnIndex = 0; columnIndex < rowData.size(); columnIndex++) {
                    Cell cell = row.createCell(columnIndex);
                    //cell.setCellType(CellType.STRING);
                    cell.setCellValue(rowData.get(columnIndex).toString());
                    cell.setCellStyle(tbStyle);
                }
            }
            // 合并数据单元格 垂直合并
            int loopNum = tableData.size() / 2;
            int temp = 2;
            for (int i = 0; i < loopNum; i++) {
                sheet.addMergedRegion(new CellRangeAddress(temp, temp+1, 0, 0));
                //厂站合并
                sheet.addMergedRegion(new CellRangeAddress(temp, temp+1, 1, 1));
                //装置合并
                sheet.addMergedRegion(new CellRangeAddress(temp, temp+1, 2, 2));
                //结果合并
                sheet.addMergedRegion(new CellRangeAddress(temp, temp+1, 3, 3));
                //时间合并
                sheet.addMergedRegion(new CellRangeAddress(temp, temp+1, 8, 8));
                temp = temp+2;
            }
            bas = new ByteArrayOutputStream();
            workbook.write(bas);
            //
            final String savePath = "D:\\stdown\\甘肃重合闸_充电保护复杂导出测试\\" + "fileName" + ".xlsx";
            FileUtils.writeByteArrayToFile(new File(savePath), bas.toByteArray());
            log.info("字节大小:" + bas.size() + ",导出合并单元格成功:" + savePath);
        } catch (Exception e) {
            log.error("导出合并单元格数据失败", e);
        } finally {
//            log.ioClose(workbook);
        }
    }

    /**
     * 创建表头样式.
     *
     * @param
     * @param
     */
    private static CellStyle createHeadStyle(final Workbook workbook) {
        final CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        headerCellStyle.setBorderBottom(BorderStyle.THIN);// 下边框
        headerCellStyle.setBorderLeft(BorderStyle.THIN);// 左边框
        headerCellStyle.setBorderTop(BorderStyle.THIN);// 上边框
        headerCellStyle.setBorderRight(BorderStyle.THIN);// 右边框
//        headerCellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.index);//蓝色背景色
//        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);//全填充模式
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());// 背景颜色
        final Font font = workbook.createFont();
//        font.setColor(IndexedColors.WHITE.getIndex());//设置字体颜色
//        font.setBold(true);
//        headerCellStyle.setFont(font);//表头字体加粗
        font.setBold(true); // 字体加粗
        font.setFontName("黑体"); // 设置字体类型
        font.setFontHeightInPoints((short) 15); // 设置字体大小
        headerCellStyle.setFont(font); // 为标题样式设置字体样式
        return headerCellStyle;
    }

    /**
     * 创建数据样式.
     *
     * @param
     * @param
     */
    private static CellStyle createDataStyle(final Workbook workbook) {
        final CellStyle tbStyle = workbook.createCellStyle();
        tbStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        tbStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        tbStyle.setWrapText(true);// 设置自动换行
        tbStyle.setBorderBottom(BorderStyle.THIN); // 下边框
        tbStyle.setBorderLeft(BorderStyle.THIN); // 左边框
        tbStyle.setBorderRight(BorderStyle.THIN); // 右边框
        tbStyle.setBorderTop(BorderStyle.THIN); // 上边框
        final Font tbfont = workbook.createFont();
        tbfont.setColor((short) 8);
        tbfont.setFontHeightInPoints((short) 12);
        tbStyle.setFont(tbfont);
        return tbStyle;
    }
}
