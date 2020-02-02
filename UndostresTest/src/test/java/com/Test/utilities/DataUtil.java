package com.Test.utilities;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.testng.annotations.DataProvider;


public class DataUtil 
{
	@DataProvider(name="excelData")
	public static Object[][] getData(Method m) 
	{
		String testName = m.getName();
		//Please not that test method name should be same as excel sheet name.
	    ExcelReader excel = new ExcelReader("./src/test/resources/testData/TestDataFile.xlsx", testName);	    
		int row= ExcelReader.getRowCount();
		int col= ExcelReader.getColumnCount();
		int temp=0;
		Object[][] data = new Object[row][1];
		Hashtable<String, String> table=null;
		
		for(int rowNum=1; rowNum<=row; rowNum++)
		{
			table= new Hashtable<String, String>();
			for(int colNum=0; colNum< col; colNum++)
			{
				table.put(ExcelReader.getCellData(colNum, 0), ExcelReader.getCellData(colNum, rowNum));	
			}
			if(ExcelReader.isRowEmpty(rowNum)== false)
			{
				data[temp][0]= table;
				temp++;
			}		
		}
		 
		 Object[][] excelValue= new Object[temp][1];
		 for(int i=0;i<temp;i++)
		 {
			 excelValue[i]= data[i];
		 }
				
		 return excelValue;
	}

}
