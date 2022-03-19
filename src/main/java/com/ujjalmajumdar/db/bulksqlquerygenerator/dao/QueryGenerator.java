package com.ujjalmajumdar.db.bulksqlquerygenerator.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ujjalmajumdar.db.bulksqlquerygenerator.model.InsertQuery;
import com.ujjalmajumdar.db.bulksqlquerygenerator.model.QueryConfig;

@Component
public class QueryGenerator {
	public String generateQuery(List<ArrayList<String>> excelData, QueryConfig queryConfig) {

		if (0 == excelData.size())
			return null;

		InsertQuery insertQuery = new InsertQuery();
		insertQuery.setDbSchema(queryConfig.getDbSchema());
		insertQuery.setTable(queryConfig.getTable());
		Map<String, String> columnNamesMap;
		if (queryConfig.isCaseSensitive()) {
			columnNamesMap = new HashMap<>(queryConfig.getFileColToDbCalMap());
			for (String column : excelData.get(0)) {
				if (columnNamesMap.containsKey(column)) {
					insertQuery.getColumnNames().add(columnNamesMap.get(column));
				} else {
					insertQuery.getColumnNames().add(column);
				}
			}
		} else {
			columnNamesMap = new HashMap<>();
			queryConfig.getFileColToDbCalMap().forEach((k, v) -> columnNamesMap.put(k.toUpperCase(), v.toUpperCase()));
			for (String column : excelData.get(0)) {
				String upperCaseCol = column.toUpperCase();
				if (columnNamesMap.containsKey(upperCaseCol)) {
					insertQuery.getColumnNames().add(columnNamesMap.get(upperCaseCol));
				} else {
					insertQuery.getColumnNames().add(upperCaseCol);
				}
			}
		}

		return null;
	}
}
