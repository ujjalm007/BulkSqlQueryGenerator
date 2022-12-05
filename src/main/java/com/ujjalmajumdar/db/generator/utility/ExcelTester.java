package com.ujjalmajumdar.db.generator.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTester {

	public static void main(String[] args) throws IOException {
		test();
	}

	public static void test() throws IOException {

		String file = "C:\\D-Drive\\Personal\\ITR\\Assessment_2022_2023\\Zerodha_Q3_FY_2021_2022.xlsx";
		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Decide which rows to process
		int rowStart = sheet.getFirstRowNum();
		int rowEnd = sheet.getLastRowNum();
		for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
			Row row = sheet.getRow(rowNum);
			if (row == null) {
				// This whole row is empty
				// Handle it as needed
				continue;
			}
			ArrayList<String> colList = new ArrayList<>();
			int lastColumn = row.getLastCellNum();
			for (int cn = 0; cn < lastColumn; cn++) {
				Cell cell = row.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if (cell == null) {
					// The spreadsheet is empty in this cell
					colList.add(null);
				} else {
					// Do something useful with the cell's contents
					switch (cell.getCellType()) {
					case NUMERIC:
						colList.add(String.valueOf(cell.getNumericCellValue()));
						break;
					case STRING:
						colList.add(cell.getStringCellValue());
						break;
					case BOOLEAN:
						colList.add(String.valueOf(cell.getBooleanCellValue()));
						break;
					default:
						colList.add(null);
						break;
					}
				}
			}
			System.out.println(colList);
		}

		/*
		 * 
		 * 
		 * // Iterate through each rows one by one Iterator<Row> rowIterator =
		 * sheet.iterator();
		 * 
		 * while (rowIterator.hasNext()) { Row row = rowIterator.next(); // For each
		 * row, iterate through all the columns Iterator<Cell> cellIterator =
		 * row.cellIterator(); ArrayList<String> colList = new ArrayList<>();
		 * 
		 * while (cellIterator.hasNext()) { Cell cell = cellIterator.next(); // Check
		 * the cell type and format accordingly switch (cell.getCellType()) { case
		 * NUMERIC: colList.add(String.valueOf(cell.getNumericCellValue())); break; case
		 * STRING: colList.add(cell.getStringCellValue()); break; case BOOLEAN:
		 * colList.add(String.valueOf(cell.getBooleanCellValue())); break; default:
		 * colList.add(null); break; } } System.out.println(colList); }
		 */
		workbook.close();
	}
}
