package com.automation.study.day25_excelReader;

import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws Exception {
        // we need to get a file as an object
        File file = new File("VytrackTestUsers.xlsx");
        // object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        // get 1st row
        Row firstRow = workSheet.getRow(0);
        // get 1st cell
        Cell firstCell = firstRow.getCell(0);
        // ret String value
        String value = firstCell.getStringCellValue();

        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondCellValue);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        int lastCell = firstRow.getLastCellNum();
        for (int i = 0; i < lastCell; i++) {
            if (i < (lastCell - 1)) {
                System.out.print(firstRow.getCell(i) + " | ");
            } else
                System.out.println(firstRow.getCell(i));
        }
        // last row is 16th --> index is 15
        // index of last cell
        int numberOfCells = workSheet.getRow(0).getLastCellNum();
        //returns how many rows at all
        int numberOfRows = workSheet.getLastRowNum();
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();


        System.out.println("\nNumber Of Cells : " + numberOfCells);
        System.out.println("\nIndex Of Last Rows = " + numberOfRows);
        System.out.println("\nNumber Of Rows : " + numberOfRows2);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue + " | ");
            }
            System.out.println();
        }
    }

    @Test
    public void excelUtilityTest() {
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-all";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        // printing every List of Map
        excelUtil.getDataList().forEach(System.out::println);
        // OR
//        excelUtil.getDataList().forEach(p -> System.out.println (p));
        // OR
//        for (Map<String, String> record : excelUtil.getDataList()) {
//            System.out.println(record);
//        }
    }

    @Test
    public void getColumnNamesText() {
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        // [execute, username, password, firstname, lastname, result]
        System.out.println(excelUtil.getColumnsNames());
    }
}
