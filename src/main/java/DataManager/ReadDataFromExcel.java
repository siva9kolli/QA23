package DataManager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {
    public String readCellValue(String sheetName, String rowValue, String columnValue) throws IOException {

        File file = new File(System.getProperty("user.dir") + "/testData/TestData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowNumber = 0;
        int colNumber = 0;

        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(rowValue)) {
                rowNumber = row.getRowNum();
            }
        }

        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(columnValue)) {
                colNumber =  cell.getColumnIndex();
            }
        }

        String cellvalue = sheet.getRow(rowNumber).getCell(colNumber).toString();
        System.out.println("cellvalue :: " + cellvalue);
        return cellvalue;
    }
}
