package com.automation.study.officeHour;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class OH_2020_04_13_Nurullah_ExcelConnection {

    @Test
    public void testcase1() throws IOException {
        // what file we are calling. Location of file
        String filePath = "UnderstandingExcelConnection.xlsx";
        // We mush load our Excel file as java file (bytecode)
        FileInputStream byteCodeOfExcelFile = new FileInputStream(filePath);
        //Load our workbook as a file
        Workbook workbook = WorkbookFactory.create(byteCodeOfExcelFile);
        // the sheet we are working on
        Sheet workSheet = workbook.getSheet("Sheet1");

        // read the Cell data of Cell 1A and Cell 1B
        // to Load the cell we need the row and column reference
        // ** --> as index numbers row 1 = index 0 and column A = index 0
        // ** as index numbers row 1 = index 0 and column B = index 1
        Cell cell1 = workSheet.getRow(0).getCell(0);
        System.out.println(cell1.toString());  // print the first cell CELL 1A

        Cell cell2 = workSheet.getRow(0).getCell(1);
        System.out.println(cell2);  // print the first cell CELL 1B

        Cell cell3 = workSheet.getRow(0).getCell(2);
        if (cell3 == null) {
            System.out.println("Cell is empty");  // print the first cell CELL 1С
        }else{
            System.out.println(cell3.toString());
        }
    }
}
