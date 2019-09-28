package com.crm.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT=80;
	public static long IMPLICIT_WAIT=0;
	
public static String TESTDATA_SHEET_PATH="C:\\Users\\saurabhverma02\\git\\TestProject\\"
			+ "myMavenProject\\src\\main\\java\\com\\crm\\qa\\testdata\\CRMTestData.xlsx";
	
	/* public static String TESTDATA_SHEET_PATH="F:\\selenium_1\\myMavenProject\\src\\main\\"
			+ "java\\com\\crm\\qa\\testdata\\CRMTestData.xlsx"; */
	
	static Workbook workbook;
	static Sheet w_sheet;
	static Cell cell;
	
	public static void explicitWait()
	{
	userwait();
	}
	
	public static void userwait()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void scrollWindow(WebDriver driver, WebElement element)
	
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
		userwait();
	}
	
	public static Object[][] getTestData(String sheet_name)
	{
		FileInputStream fis= null;
		try 
		{
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
			System.out.println("Input Stream is now initialised");
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			workbook = WorkbookFactory.create(fis);
		} 
		catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sheet name is before:"+sheet_name);
		w_sheet = workbook.getSheetAt(0);
		System.out.println("Sheet name is:"+w_sheet);
		 int last_row = w_sheet.getLastRowNum();
		 int last_col = w_sheet.getRow(0).getLastCellNum();
		 System.out.println("rows are coulmns are:"+last_row+":"+last_col);
		
		Object[][] data = new Object[last_row][last_col];
		
		for (int i=0;i<last_row;i++)
		{
			for(int j=0;j<last_col;j++)
			{
				//data[i][j]= w_sheet.getRow(i+1).getCell(j).toString();
				Cell cell = w_sheet.getRow(i+1).getCell(j);
				
				
				if(cell.getCellType()==CellType.STRING)
				{
					data[i][j]=cell.getStringCellValue();
					
				}
				
				else if(cell.getCellType()==CellType.NUMERIC)
				{
					String phone_no = new BigDecimal(cell.getNumericCellValue()).toPlainString();
				//int value =	new Double(cell.getNumericCellValue()).intValue();
				//int value =	(int)cell.getNumericCellValue();
				//String phone_no=String.valueOf(value);
					//String phone_no = String.valueOf(cell.getNumericCellValue());
				
					data[i][j]=phone_no;
				}
				
				else
					System.out.println("the type is different");
					
				//cell.setCellType(Cell.CELL_TYPE_STRING;
				
				System.out.println("The value is:"+data[i][j]);
			}
		}
		return data;
	}
}

