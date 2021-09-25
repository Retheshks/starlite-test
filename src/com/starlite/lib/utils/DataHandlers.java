package com.starlite.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers 
{
	public static String getDataFromExcel(String fileName, String sheetName, int rowIndex, int cellIndex)
	{
		try {
			File f = new File("./test-data/" + fileName + ".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			String data = c.toString();
			return data;
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static void setDataTOExcel(String fileName, String sheetName, int rowIndex, int cellIndex, String data)
	{
		try 
		{
			File f = new File("./test-data/" + fileName + ".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r;	
			try {
				r = st.getRow(rowIndex);
			} catch(Exception e) {
				r = st.createRow(rowIndex);
			}
			Cell c;
			try {
				c = r.getCell(cellIndex);
			} catch(Exception e) {
				c = r.createCell(cellIndex);
			}
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
