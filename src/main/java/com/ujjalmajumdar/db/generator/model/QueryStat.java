package com.ujjalmajumdar.db.generator.model;

public class QueryStat {
	//Could be enum - insert, update, delete
	String queryType;
	int numOfRecs;
	
	public QueryStat() {}
	public QueryStat(String queryType, int numOfRecs) {
		this.queryType = queryType;
		this.numOfRecs = numOfRecs;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public int getNumOfRecs() {
		return numOfRecs;
	}
	public void setNumOfRecs(int numOfRecs) {
		this.numOfRecs = numOfRecs;
	}
	
	
	
}
