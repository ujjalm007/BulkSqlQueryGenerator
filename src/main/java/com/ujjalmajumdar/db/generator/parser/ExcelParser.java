package com.ujjalmajumdar.db.generator.parser;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.ujjalmajumdar.db.generator.model.ExcelRequestBody;
import com.ujjalmajumdar.db.generator.settings.Settings;

public class ExcelParser extends Parser {

	@Autowired
	Settings settings;
	
	@Override
	public List<ArrayList<String>> parseFile(String filePath, ExcelRequestBody excelRequestBody) {

		List<ArrayList<String>> rowList = new ArrayList<ArrayList<String>>();
		List<String> headers = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new File(filePath));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Decide which rows to process
			int rowStart = Math.max(excelRequestBody.getStartRow(), sheet.getFirstRowNum());
			int rowEnd = Math.min(excelRequestBody.getEndRow(), sheet.getLastRowNum());
			
			for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
				Row row = sheet.getRow(rowNum);
				if (row == null) {
					// This whole row is empty
					// Handle it as needed
					continue;
				}
				ArrayList<String> colList = new ArrayList<>();
				int firstColumn = Math.max(excelRequestBody.getStartColumn(),0);
				int lastColumn = Math.min(excelRequestBody.getEndColumn(),row.getLastCellNum());
				for (int cn = firstColumn; cn < lastColumn; cn++) {
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
				// Check if the processing will be done through DB
				if(settings.isProcessingThroughDb()) {
					//store in DB once rowLimit is reached
					if(rowList.size() >= settings.getRowLimit()) {
						//Insert into DB *****
						
						//Empty the rowList
						rowList.clear();
					}
					
				}
			}
			

			//Insert the remaining rows into DB
			if(rowList.size() >= 0) {
				//Insert into DB *****
				
				//Empty the rowList
				rowList.clear();
			}
			
			workbook.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowList;
	}

}
