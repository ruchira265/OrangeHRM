package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelLibrary extends ReusableMethods
{
	
	
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	int conntrows;

	// construtor 
	public ExcelLibrary() throws Exception
	{
		String filepath  = "C:\\Users\\Ruchira Sumit\\Desktop\\TestData.xlsx";
		String fileName = "TestData";
		String sheetName = "demo";
		
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
	}
	
	public static String readData(String sheetName , int rno, int cno)
	{
	
		sh = wb.getSheet(sheetName);
		String data = sh.getRow(rno).getCell(cno).getStringCellValue();
		
		return data;
	}
	
	public int getLastRow()
	{
		 conntrows = sh.getLastRowNum();
		return conntrows;
	}
	
	
	
}
