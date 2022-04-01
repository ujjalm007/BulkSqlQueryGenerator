package com.ujjalmajumdar.db.bulksqlquerygenerator.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujjalmajumdar.db.bulksqlquerygenerator.model.ExcelRequestBody;
import com.ujjalmajumdar.db.bulksqlquerygenerator.model.QueryConfig;
import com.ujjalmajumdar.db.bulksqlquerygenerator.model.QueryStat;
import com.ujjalmajumdar.db.bulksqlquerygenerator.parser.BaseParserFactory;
import com.ujjalmajumdar.db.bulksqlquerygenerator.parser.Parser;
import com.ujjalmajumdar.db.bulksqlquerygenerator.parser.ParserFactory;
import com.ujjalmajumdar.db.bulksqlquerygenerator.query.BaseQueryGeneratorFactory;
import com.ujjalmajumdar.db.bulksqlquerygenerator.query.QueryGenerator;
import com.ujjalmajumdar.db.bulksqlquerygenerator.query.QueryGeneratorFactory;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class SqlService {
	
	public List<QueryStat> generateQueryFromExcel(ExcelRequestBody excelRequestBody) {
		
		BaseParserFactory parserFactory = new ParserFactory();
		Parser parser = parserFactory.createParser("excel");
		List<ArrayList<String>> data = parser.parseFile(excelRequestBody.getFilePath());
		
		BaseQueryGeneratorFactory queryGeneratorFactory = new QueryGeneratorFactory();
		
		List<QueryConfig> queryConfigList = excelRequestBody.getQueryConfigList();
		
		Map<String, List<String>> queryOutputListMap = new HashMap<>();
		
		for(QueryConfig queryConfig: queryConfigList) {
			String queryType = queryConfig.getQueryType();
			QueryGenerator queryGenerator = queryGeneratorFactory.createQueryGeneratorFactory(queryType);
			List<String> queryOutputList = new ArrayList<>();
			queryOutputListMap.put(queryType,queryOutputList);
			queryOutputList = queryGenerator.generateQuery(data, queryConfig);
		}
		
		List<QueryStat> queryStatList = new ArrayList<QueryStat>();
		for(String type: queryOutputListMap.keySet()) {
			QueryStat queryStat = new QueryStat();
			queryStatList.add(queryStat);
			queryStat.setQueryType(type);
			queryStat.setNumOfRecs(queryOutputListMap.get(type).size());
		}
		return queryStatList;
	}
	
}
