package com.Test.utilities;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	public  FileInputStream fis = null;
	public static  XSSFWorkbook workbook = null;
	public static  XSSFSheet sheet = null;
	private static XSSFRow row   =null;
	private static XSSFCell cell = null;
	static DataFormatter formatter= new DataFormatter();

public ExcelReader(String path, String sheetName) 
{	
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			//fis.close();
		} catch (Exception e) 
		{		
			e.printStackTrace();
		} 		
}

//returns the row count in a sheet
	public static int getRowCount()
	{	
		//sheet = workbook.getSheet(sheetName);
		int number=sheet.getLastRowNum();
		return number;	
	}
	
	// returns number of columns in a sheet	
	public static int getColumnCount()
	{		
			//sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);			
			return row.getLastCellNum();		
	}
	
	public static String getCellData(int colNum,int rowNum)
	{
		try
		{
			//sheet= workbook.getSheet(sheetName);
			row= sheet.getRow(rowNum);
			cell= row.getCell(colNum);
			String value= formatter.formatCellValue(cell).trim();
			return value;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist in xls";
		}
		
	}
	
	//Verify the empty cell
	public static boolean isRowEmpty(int rowNum)
	{
		//sheet= workbook.getSheet(sheetName);
		XSSFRow rowCount= sheet.getRow(rowNum);
	    for (int c = rowCount.getFirstCellNum(); c < rowCount.getLastCellNum(); c++) 
	    {
	        XSSFCell cell = rowCount.getCell(c);
	        if (cell != null && cell.getCellType() != XSSFCell.CELL_TYPE_BLANK)
	            return false;
	    }
	    return true;
	}
}
