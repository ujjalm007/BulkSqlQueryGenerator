package com.ujjalmajumdar.db.generator.query;

public abstract class BaseQueryGeneratorFactory {
	public abstract QueryGenerator createQueryGeneratorFactory(String type);
}
