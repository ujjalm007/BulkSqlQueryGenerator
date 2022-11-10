package com.ujjalmajumdar.db.generator.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ujjalmajumdar.db.generator.model.InsertQuery;
import com.ujjalmajumdar.db.generator.model.QueryConfig;

/**
 * 
 * @author Ujjal Majumdar
 *
 */
public class InsertQueryGenerator extends QueryGenerator {

	/**
	 * @return
	 */
	@Override
	public List<String> generateQuery(List<ArrayList<String>> data, QueryConfig queryConfig) {
		if (0 == data.size())
			return null;

		InsertQuery insertQuery = new InsertQuery();
		insertQuery.setDbSchema(queryConfig.getDbSchema());
		insertQuery.setTable(queryConfig.getTable());
		Map<String, String> columnNamesMap;

		// Calculate the final column names
		// If DB is case sensitive
		if (queryConfig.isCaseSensitive()) {
			columnNamesMap = new HashMap<>(queryConfig.getFileColToDbCalMap());
			// Read through the first record which is column names
			for (String column : data.get(0)) {
				if (columnNamesMap.containsKey(column)) {// If column name needs to be updated
					insertQuery.getColumnNames().add(columnNamesMap.get(column)); // Add new column name
				} else {
					insertQuery.getColumnNames().add(column); // Add existing column name
				}
			}
		} else { // If DB is NOT case sensitive -- convert all column names to upper case
			columnNamesMap = new HashMap<>();
			// Convert all column key values to upper case
			queryConfig.getFileColToDbCalMap().forEach((k, v) -> columnNamesMap.put(k.toUpperCase(), v.toUpperCase()));
			// Read through the first record which is column names
			for (String column : data.get(0)) {
				String upperCaseCol = column.toUpperCase();
				if (columnNamesMap.containsKey(upperCaseCol)) {// If column name needs to be updated
					insertQuery.getColumnNames().add(columnNamesMap.get(upperCaseCol)); // Add new column name
				} else {
					insertQuery.getColumnNames().add(upperCaseCol); // Add existing column name
				}
			}
		}

		// Calculate which columns to be dropped
		List<Integer> droppedColIndexs = new ArrayList<>();
		List<String> cols = data.get(0);
		List<String> actCols = queryConfig.getFileActiveColList();
		//If fileActiveColList is not passed we will consider all the records in the file
		if (null != actCols) {
			for (int i = 0; i < cols.size(); i++) {
				if (actCols.contains(cols.get(i))) {
					droppedColIndexs.add(i);
					insertQuery.getColumnNames().remove(i);
				}
			}
		}

		// Create the list of records which will be created from input data after
		// dropping the columns
		for (List<String> vals : data) {
			int len = vals.size();
			ArrayList<String> newVals = new ArrayList<>();
			
			for (int i = 0; i < len; i++) {
				if(droppedColIndexs.contains(i))
					continue;
				newVals.add(vals.get(i));
			}
			insertQuery.getRecords().add(newVals);
		}
		
		return insertQuery.getQueryList();
	}

}
