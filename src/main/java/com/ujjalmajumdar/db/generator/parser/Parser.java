package com.ujjalmajumdar.db.generator.parser;

import java.util.ArrayList;
import java.util.List;

import com.ujjalmajumdar.db.generator.model.ExcelRequestBody;

public abstract class Parser {
	public abstract List<ArrayList<String>> parseFile(String filePath, ExcelRequestBody excelRequestBody);

}
