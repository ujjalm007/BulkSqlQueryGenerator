package com.ujjalmajumdar.db.bulksqlquerygenerator.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class ExcelRequestBody {
	private String filePath;
	private List<QueryConfig> queryConfigList;
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public List<QueryConfig> getQueryConfigList() {
		return queryConfigList;
	}
	public void setQueryConfigList(List<QueryConfig> queryConfigList) {
		this.queryConfigList = queryConfigList;
	}
	
	

}
