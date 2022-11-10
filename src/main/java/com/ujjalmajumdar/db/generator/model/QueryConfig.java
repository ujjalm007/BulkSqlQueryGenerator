package com.ujjalmajumdar.db.generator.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
//@Builder
public class QueryConfig {
	//Target database schema
	private String dbSchema;
	//Target table
	private String table;
	//Target query operation - INSERT, UPDATE, DELETE
	private String queryType;
	//Are file column and table column names case sensitive
	private boolean isCaseSensitive;
	//File columns which need to be considered for upload
	private List<String> fileActiveColList = null;
	//File columns which need to be mapped to table columns
	private Map<String,String> fileColToDbCalMap;
	//Default values specific to table columns
	private Map<String,String> defaultValueMap;
	//List of not-null table columns
	private List<String> notNullFieldList;
	//Is ID field to be added separately
	private boolean isIdToBeAdded=false;
	//If ID to be added, its start value
	private long idStartValue=1;
	//If ID to be added, it would be incremented by
	private short idIncrementBy=1;
	
	
	
}
