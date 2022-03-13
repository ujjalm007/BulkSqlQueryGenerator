package com.ujjalmajumdar.db.bulksqlquerygenerator.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter 
@Setter
@NoArgsConstructor
public class ExcelRequestBody {
	private String filePath;
	private List<QueryConfig> queryConfigList;
		

}
