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
	//Target database schema
	private String dbSchema;
	//Target table
	private String table;
	//Target query operation - INSERT, UPDATE, DELETE
	private String queryType;
	//Row number of header record in file
	private int headerRowPos=1;
	//Row number from where data starts
	private int dataRecordStartPos=2;
	//Are file column and table column names case sensitive
	private boolean isCaseSensitive;
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
	
	public QueryConfig() {
	}
	public String getDbSchema() {
		return dbSchema;
	}
	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public int getHeaderRowPos() {
		return headerRowPos;
	}
	public void setHeaderRowPos(int headerRowPos) {
		this.headerRowPos = headerRowPos;
	}
	public int getDataRecordStartPos() {
		return dataRecordStartPos;
	}
	public void setDataRecordStartPos(int dataRecordStartPos) {
		this.dataRecordStartPos = dataRecordStartPos;
	}
	
	public boolean isCaseSensitive() {
		return isCaseSensitive;
	}
	public void setCaseSensitive(boolean isCaseSensitive) {
		this.isCaseSensitive = isCaseSensitive;
	}
	public Map<String, String> getFileColToDbCalMap() {
		return fileColToDbCalMap;
	}
	public void setFileColToDbCalMap(Map<String, String> fileColToDbCalMap) {
		this.fileColToDbCalMap = fileColToDbCalMap;
	}
	public Map<String, String> getDefaultValueMap() {
		return defaultValueMap;
	}
	public void setDefaultValueMap(Map<String, String> defaultValueMap) {
		this.defaultValueMap = defaultValueMap;
	}
	public List<String> getNotNullFieldList() {
		return notNullFieldList;
	}
	public void setNotNullFieldList(List<String> notNullFieldList) {
		this.notNullFieldList = notNullFieldList;
	}
	public boolean isIdToBeAdded() {
		return isIdToBeAdded;
	}
	public void setIdToBeAdded(boolean isIdToBeAdded) {
		this.isIdToBeAdded = isIdToBeAdded;
	}
	public long getIdStartValue() {
		return idStartValue;
	}
	public void setIdStartValue(long idStartValue) {
		this.idStartValue = idStartValue;
	}
	public short getIdIncrementBy() {
		return idIncrementBy;
	}
	public void setIdIncrementBy(short idIncrementBy) {
		this.idIncrementBy = idIncrementBy;
	}
	
	
}
