package com.ujjalmajumdar.db.bulksqlquerygenerator.query;

import java.util.ArrayList;
import java.util.List;

import com.ujjalmajumdar.db.bulksqlquerygenerator.model.QueryConfig;

public abstract class QueryGenerator {
	public abstract List<String> generateQuery(List<ArrayList<String>> data, QueryConfig queryConfig);
}
