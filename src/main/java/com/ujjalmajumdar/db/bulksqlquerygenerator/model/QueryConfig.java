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
	private int headerRowPos=1;
	private int dataRecordStartPos=2;
	private Map<String,String> fileColToDbCallMap;
	private Map<String,String> defaultValueMap;
	private List<String> notNullFieldList;	
	private boolean isIdToBeAdded=false;
	private long startIndex=1;
	private short incrementBy=1;
}
