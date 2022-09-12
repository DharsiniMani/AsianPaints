package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestDataUtil {
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException {
		File file=new File("C:\\Users\\DHARMANI\\eclipse-workspace\\SprintAsianPaints\\src\\main\\java\\ExcelDatas\\Data.xlsx");
		FileInputStream xlFis = new FileInputStream(file);
		Workbook workBook = WorkbookFactory.create(xlFis);
		Sheet sheet = workBook.getSheet(sheetName);
		
		DataFormatter format= new DataFormatter();
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=format.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return data;
	}
}
