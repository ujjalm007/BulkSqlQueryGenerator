package com.ujjalmajumdar.db.bulksqlquerygenerator.query;

public class QueryGeneratorFactory extends BaseQueryGeneratorFactory {

	@Override
	public QueryGenerator createQueryGeneratorFactory(String type) {
		QueryGenerator queryGenerator;
        switch (type.toLowerCase())
        {
            case "insert":
            	queryGenerator = new InsertQueryGenerator();
                break;
            case "update":
            	queryGenerator = new UpdateQueryGenerator();
                break;
            case "delete":
            	queryGenerator = new DeleteQueryGenerator();
                break;
            default: throw new IllegalArgumentException("No such query generator.");
        }
        return queryGenerator;
	}

}
