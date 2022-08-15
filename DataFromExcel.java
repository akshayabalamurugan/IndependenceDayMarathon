package marathon3;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFromExcel {
	
	public String[][] readData(String excelName) throws IOException {
		
		XSSFWorkbook workbook= new XSSFWorkbook("Data/"+excelName+".xlsx");
		XSSFSheet sheetAt = workbook.getSheetAt(0);
		int rowNumber = sheetAt.getLastRowNum();
		short colNumber = sheetAt.getRow(1).getLastCellNum();
		String[][] data= new String [rowNumber][colNumber];
		for (int i = 1; i <=rowNumber; i++) {
			XSSFRow row = sheetAt.getRow(i);
			for (int j = 0; j < colNumber; j++) {
			XSSFCell cell = row.getCell(j);	
			data[i-1][j]= cell.getStringCellValue();
			}
		}
		workbook.close();
		return data;
	}
}
