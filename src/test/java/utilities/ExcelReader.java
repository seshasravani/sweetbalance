package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }
    
	public List<Map<String, String>> getDataAll(String sheetName){
        List<Map<String, String>> sheetData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Map<String, String> rowData = new LinkedHashMap<>();
                Row row = sheet.getRow(i);
                if (row == null) continue;

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    Cell headerCell = headerRow.getCell(j);
                    Cell cell = row.getCell(j);
                    String header = headerCell.getStringCellValue();
                    String value = (cell == null) ? "" : cell.toString();
                    rowData.put(header.trim(), value.trim());
                }

                sheetData.add(rowData);
            }
        }catch (IOException e) {
                e.printStackTrace();
            }
            return sheetData;
        }

}
