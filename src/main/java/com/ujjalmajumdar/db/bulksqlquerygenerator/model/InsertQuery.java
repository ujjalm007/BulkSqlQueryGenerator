package com.ujjalmajumdar.db.bulksqlquerygenerator.model;

import java.util.ArrayList;
import java.util.List;

public class InsertQuery {
	// Target database schema
	private String dbSchema;
	// Target table
	private String table;

	//Target table column list
	private List<String> columnNames = new ArrayList<>();
	//Target data row data values
	private List<ArrayList<String>> records = new ArrayList<>();
	public InsertQuery() {}
	public InsertQuery(String dbSchema, String table, List<String> columnNames, List<ArrayList<String>> records) {
		this.dbSchema = dbSchema;
		this.table = table;
		this.columnNames = columnNames;
		this.records = records;
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
	public List<String> getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}
	public List<ArrayList<String>> getRecords() {
		return records;
	}
	public void setRecords(List<ArrayList<String>> records) {
		this.records = records;
	}

}
