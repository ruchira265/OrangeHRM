package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel 
{
	
	String filepath  = "C:\\Users\\Ruchira Sumit\\Desktop\\TestData.xlsx";
	String fileName = "TestData";
	String sheetName = "demo";
	
	@Test
	public void ReadData() throws Exception
	{
		// to open an Excel file we need object of File class
		File f = new File(filepath);
		
		// To read the file
		FileInputStream fis = new FileInputStream(f);
		
		// Workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		// Sheet 
		XSSFSheet sh = wb.getSheet(sheetName);
		
		// to get the no of rows in your sheet 
		int conntrows = sh.getLastRowNum();
		
		System.out.println("The total no of rows in Excel =="+(conntrows+1));
		
		// to get data inside your excel for particular row data 
		
		String data = sh.getRow(7).getCell(0).getStringCellValue();
		
		System.out.println("data inside row ="+data);
		
		
		// to print all the vaalues 
		for(int i= 0 ;i<=conntrows ;i++)
		{
			Row row = sh.getRow(i);
			for(int j =0;j<row.getLastCellNum();j++)
			{
				String output  =  sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(output + " ");
			}
			System.out.println();
		}
		
		
	}

	
	
	
	
}
