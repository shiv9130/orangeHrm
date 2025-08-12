package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilityHrm {
	
	public String excelUtility(String Sheet,int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new  FileInputStream("C:\\Users\\Nis\\Desktop\\OrangeHrm.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    String data = wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

}
