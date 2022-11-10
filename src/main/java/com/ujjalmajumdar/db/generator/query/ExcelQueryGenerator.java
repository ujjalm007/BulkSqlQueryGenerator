package com.ujjalmajumdar.db.generator.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ujjalmajumdar.db.generator.model.InsertQuery;
import com.ujjalmajumdar.db.generator.model.QueryConfig;

public class ExcelQueryGenerator extends QueryGenerator {

	@Override
	public List<String> generateQuery(List<ArrayList<String>> data, QueryConfig queryConfig) {
		if (0 == data.size())
			return null;

		InsertQuery insertQuery = new InsertQuery();
		insertQuery.setDbSchema(queryConfig.getDbSchema());
		insertQuery.setTable(queryConfig.getTable());
		Map<String, String> columnNamesMap;
		if (queryConfig.isCaseSensitive()) {
			columnNamesMap = new HashMap<>(queryConfig.getFileColToDbCalMap());
			for (String column : data.get(0)) {
				if (columnNamesMap.containsKey(column)) {
					insertQuery.getColumnNames().add(columnNamesMap.get(column));
				} else {
					insertQuery.getColumnNames().add(column);
				}
			}
		} else {
			columnNamesMap = new HashMap<>();
			queryConfig.getFileColToDbCalMap().forEach((k, v) -> columnNamesMap.put(k.toUpperCase(), v.toUpperCase()));
			for (String column : data.get(0)) {
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
