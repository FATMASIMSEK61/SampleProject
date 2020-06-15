package com.hrms.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static Workbook book1;
	private static Sheet sheet1;
	
	private static void openExcel(String filePath) {
		try {
			FileInputStream fileIS=new FileInputStream(filePath);
				book1=new XSSFWorkbook(fileIS);
		}catch(Exception e) {
			e.printStackTrace();
		}
				
			}
		
	private static void loadSheet(String sheetName) {
	sheet1=book1.getSheet(sheetName);
}
	private static int rowCount() {
	return sheet1.getPhysicalNumberOfRows();
}
	private static int colsCount(int row) {
	return sheet1.getRow(row).getLastCellNum();
}
	private static String cellData(int rowIndex,int colIndex) {
	return sheet1.getRow(rowIndex). getCell(colIndex).toString();
}
//return a 2d object array of data
	private static Object[][] excelIntroArray(String filePath,String sheetName){
	openExcel(filePath);
	loadSheet(sheetName);
	
	int rows=rowCount();
	int cols=colsCount(0);
	
	Object[][]data= new Object[rows-1][cols];
	
	//iterating rows
	for(int i=1; i<rows; i++) {
		
		//iterating cols
		for(int j=0; j<cols; j++) {
			
			//storying values into 2d array
			data[i-1][j]=cellData(i,j);
		}
	}
	return data;
}



}