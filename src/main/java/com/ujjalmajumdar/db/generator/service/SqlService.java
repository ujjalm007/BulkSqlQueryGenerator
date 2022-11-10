package com.ujjalmajumdar.db.generator.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujjalmajumdar.db.generator.entity.Attachment;
import com.ujjalmajumdar.db.generator.model.ExcelRequestBody;
import com.ujjalmajumdar.db.generator.model.QueryConfig;
import com.ujjalmajumdar.db.generator.model.QueryStat;
import com.ujjalmajumdar.db.generator.parser.BaseParserFactory;
import com.ujjalmajumdar.db.generator.parser.Parser;
import com.ujjalmajumdar.db.generator.parser.ParserFactory;
import com.ujjalmajumdar.db.generator.query.BaseQueryGeneratorFactory;
import com.ujjalmajumdar.db.generator.query.QueryGenerator;
import com.ujjalmajumdar.db.generator.query.QueryGeneratorFactory;
import com.ujjalmajumdar.db.generator.repository.AttachmentRepository;
import com.ujjalmajumdar.db.generator.settings.Settings;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class SqlService {
	
	@Autowired
	private AttachmentRepository attachmentRepository;
	
	@Autowired
	Settings settings;
	
	public List<QueryStat> generateQueryFromExcel(ExcelRequestBody excelRequestBody) {
		
		Optional<Attachment> tempAttachment= attachmentRepository.findById(excelRequestBody.getFileId());
		String fullPathFileName = null;
		if(tempAttachment.isPresent()) {
			fullPathFileName = tempAttachment.get().getActualPathFileName();
		}
		
		BaseParserFactory parserFactory = new ParserFactory();
		Parser parser = parserFactory.createParser("excel");
		List<ArrayList<String>> data = parser.parseFile(fullPathFileName, excelRequestBody);
		
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
