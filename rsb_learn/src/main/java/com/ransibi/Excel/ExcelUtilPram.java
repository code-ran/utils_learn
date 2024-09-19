package com.ransibi.Excel;

import java.util.ArrayList;
import java.util.List;
/**
 * Excel工具类传参.
 */
public class ExcelUtilPram {
    /**
     * 页签名称.
     */
    private String sheetName = "Sheet1";
    /**
     * 表头名称.
     */
    private List<String> tableHead = new ArrayList<String>();
    /**
     * 表头平均列宽.
     */
    private Integer tableHeadPerWidth = 5000;
    /**
     * 表数据.
     */
    private List<List<Object>> tableData = new ArrayList<>();

    public String getSheetName() {
        return sheetName;
    }
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
    public List<String> getTableHead() {
        return tableHead;
    }
    public void setTableHead(List<String> tableHead) {
        this.tableHead = tableHead;
    }
    public Integer getTableHeadPerWidth() {
        return tableHeadPerWidth;
    }
    public void setTableHeadPerWidth(Integer tableHeadPerWidth) {
        this.tableHeadPerWidth = tableHeadPerWidth;
    }
    public List<List<Object>> getTableData() {
        return tableData;
    }
    public void setTableData(List<List<Object>> tableData) {
        this.tableData = tableData;
    }
}

