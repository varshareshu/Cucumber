package SwagLabs.GenericUtility;


import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



/**
 * This class consists of generic methods related to Excel file
 * @author Varsha k
 * 
 */

public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel file by taking sheet name, row no and
	 * cell no from caller and return value
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo 
	 * @return 
	 * @throws  
	 * @throws IOException
	 * 
	 */
	
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo, Object c1) throws  IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell cl = rw.getCell(cellNo);
		String value = ((Cell) cl).getStringCellValue();
		return value;
		
	}

	public String readDataFromExcel(String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	
}


