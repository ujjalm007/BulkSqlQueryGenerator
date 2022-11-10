package com.ujjalmajumdar.db.generator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InsertQuery {
	// Target database schema
	private String dbSchema;
	// Target table
	private String table;

	// Target table column list
	private List<String> columnNames = new ArrayList<>();
	private String commaSeptColNames = null;
	// Target data row data values
	private List<ArrayList<String>> records = new ArrayList<>();

	public InsertQuery() {
	}

	public InsertQuery(String dbSchema, String table, List<String> columnNames, List<ArrayList<String>> records) {
		this.dbSchema = dbSchema;
		this.table = table;
		this.columnNames = columnNames;
		this.records = records;
	}

	/**
	 * Convert the column names into a comma separated column names
	 * @return comma separated column names
	 */
	private String formCommaSeptColNames() {
		if (null == commaSeptColNames) {
			Optional<String> colNames = columnNames.stream().reduce((s1, s2) -> s1 + "," + s2);
			if (colNames.isPresent()) {
				commaSeptColNames = colNames.get();
			}
		}
		return commaSeptColNames;

	}

	public List<String> getQueryList() {
		//StringBuilder queries = new StringBuilder();
		List<String> queryList = new ArrayList<>();
		boolean firstRow = true;
		//Loop through the records
		for(List<String> row: records) {
			String cols = null;
			//Convert the column values list to a string of comma separated
			Optional<String> colVals = row.stream().reduce((c1, c2) -> c1 + "," + c2);
			if (colVals.isPresent()) {
				cols = colVals.get();
			}
			//Form the query
			String query = "INSERT INTO "+ table +"(" + formCommaSeptColNames() + ") " 
				+ "VALUES ("+cols+");";
			
			queryList.add(query);
			//Join the queries into a single string
			/*
			if(firstRow) {
				queries.append(query);
				firstRow = false;
			} else {
				queries.append(query+"\n");
			}
			*/
		}
		return queryList;
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
