package com.ujjalmajumdar.db.generator.query;

import java.util.ArrayList;
import java.util.List;

import com.ujjalmajumdar.db.generator.model.QueryConfig;

public abstract class QueryGenerator {
	public abstract List<String> generateQuery(List<ArrayList<String>> data, QueryConfig queryConfig);
}
