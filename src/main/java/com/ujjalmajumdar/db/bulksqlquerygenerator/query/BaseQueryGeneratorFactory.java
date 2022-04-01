package com.ujjalmajumdar.db.bulksqlquerygenerator.query;

public abstract class BaseQueryGeneratorFactory {
	public abstract QueryGenerator createQueryGeneratorFactory(String type);
}
