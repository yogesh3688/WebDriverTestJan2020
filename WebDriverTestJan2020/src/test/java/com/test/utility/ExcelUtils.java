package com.test.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

	private static HSSFSheet sheet1;
	private static XSSFSheet sheet2;
	private static XSSFWorkbook workbook2; // This is for xlsx
	private static HSSFWorkbook workbook1; // This is for xls
	private static HSSFCell cell1;
	private static XSSFCell cell2;
	private static HSSFRow row1;
	private static XSSFRow row2;

	public static Object[][] readExcel(String filePath, String sheetName) throws Exception {
		Object data[][] = null;
		System.out.println("inside readExcel");
		try {
			String inputFilename = new File(filePath).getName();
			System.out.println(filePath);
			if (filePath.contains("xls")) {
				workbook1 = new HSSFWorkbook(new FileInputStream(new File(filePath)));
				sheet1 = workbook1.getSheet(sheetName);
				int startRow = 0;
				int startColumn = 0;
				int ci, cj;
				int totalRows = sheet1.getLastRowNum();
//					System.out.println("total rows "+totalRows);
				int totalColumn = 2;
				data = new Object[totalRows][totalColumn];
				ci = 0;
				cj = 0;
				for (int i = startRow; i < totalRows; i++) {
					for (int j = startColumn; j < totalColumn; j++) {
						ci = i;
						cj = j;
						data[ci][cj] = getCellData1(i, j);
					}
				}
			} else if (filePath.contains("xlsx")) {
				workbook2 = new XSSFWorkbook(new FileInputStream(new File(filePath)));
				sheet2 = workbook2.getSheet(sheetName);
				int startRow = 0;
				int startColumn = 0;
				int ci, cj;
				int totalRows = sheet2.getLastRowNum();
				int totalColumn = 2;
				data = new String[totalRows][totalColumn];
				ci = 0;
				for (int i = startRow; i < totalRows; i++) {
					cj = 0;
					for (int j = startColumn; j < totalColumn; j++) {
						data[ci][cj] = getCellData2(i, j);
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found " + filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read Excel Sheet");
			e.printStackTrace();
		}
		return data;
	}

	private static String getCellData1(int row, int cols) throws Exception {
		// TODO Auto-generated method stub
		try {
			cell1 = sheet1.getRow(row).getCell(cols);
			int dataType = cell1.getCellType();
			// System.out.println(" data type"+dataType);
			if (dataType == 3) {
				return "";
			} else {
				String cellData = cell1.getStringCellValue();
//				System.out.println("cellData "+cellData);
				return cellData;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw (e);
		}
	}

	private static String getCellData2(int row, int cols) throws Exception {
		// TODO Auto-generated method stub
		try {
			cell2 = sheet2.getRow(row).getCell(cols);
			int dataType = cell2.getCellType();
			System.out.println(" data type" + dataType);
			if (dataType == 3) {
				return "";
			} else {
				String cellData = cell2.getStringCellValue();
				System.out.println("cellData " + cellData);
				return cellData;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw (e);
		}
	}

}
