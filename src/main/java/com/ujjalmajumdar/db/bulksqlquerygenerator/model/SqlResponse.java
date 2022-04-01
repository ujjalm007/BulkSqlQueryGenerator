package com.ujjalmajumdar.db.bulksqlquerygenerator.model;

import java.util.List;

public class SqlResponse {
	List<QueryStat> queryStatList;

	public SqlResponse() {}

	public SqlResponse(List<QueryStat> queryStatList) {
		this.queryStatList = queryStatList;
	}

	public List<QueryStat> getQueryStatList() {
		return queryStatList;
	}

	public void setQueryStatList(List<QueryStat> queryStatList) {
		this.queryStatList = queryStatList;
	}

}
