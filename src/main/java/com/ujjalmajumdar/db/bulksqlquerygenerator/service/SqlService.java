package com.ujjalmajumdar.db.bulksqlquerygenerator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujjalmajumdar.db.bulksqlquerygenerator.dao.ExcelParcer;
import com.ujjalmajumdar.db.bulksqlquerygenerator.dao.QueryGenerator;
import com.ujjalmajumdar.db.bulksqlquerygenerator.model.ExcelRequestBody;
import com.ujjalmajumdar.db.bulksqlquerygenerator.model.QueryConfig;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class SqlService {

	@Autowired
	ExcelParcer excelParcer;
	
	@Autowired
	QueryGenerator queryGenerator;
	
	public List<String> generateQueryFromExcel(ExcelRequestBody excelRequestBody) {
		
		List<ArrayList<String>> excelData = excelParcer.readExcel(excelRequestBody.getFilePath());
		
		List<QueryConfig> queryConfigList = excelRequestBody.getQueryConfigList();
		List<String> queryOutputList = new ArrayList<>();
		for(QueryConfig queryConfig: queryConfigList) {
			queryOutputList.add(queryGenerator.generateQuery(excelData, queryConfig));
		}
		return null;
	}
	
}
