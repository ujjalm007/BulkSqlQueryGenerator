package com.ujjalmajumdar.db.bulksqlquerygenerator.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@Builder
public class QueryConfig {
	private String dbSchema;
	private String table;
	private String queryType;
	private int headerRowPos;
	private int dataRecordStartPos;
	private Map<String,String> fileColToDbCallMap;
	private Map<String,String> defaultValueMap;
	private List<String> notNullFieldList;	
	private boolean isIdToBeAdded;
	private long startIndex;
	private short incrementBy;
}
