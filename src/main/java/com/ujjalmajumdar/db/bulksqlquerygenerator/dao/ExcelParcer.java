package com.ujjalmajumdar.db.bulksqlquerygenerator.dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.ujjalmajumdar.db.bulksqlquerygenerator.model.QueryConfig;

@Component
public class ExcelParcer {

	public List<ArrayList<String>> readExcel(String filePath) {

		List<ArrayList<String>> rowList = new ArrayList<ArrayList<String>>();
		try {
			FileInputStream file = new FileInputStream(new File(filePath));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				ArrayList<String> colList = new ArrayList<>();
				rowList.add(colList);
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
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
			workbook.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowList;
	}

}
