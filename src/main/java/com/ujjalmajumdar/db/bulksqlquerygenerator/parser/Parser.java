package com.ujjalmajumdar.db.bulksqlquerygenerator.parser;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser {
	public abstract List<ArrayList<String>> parseFile(String filePath);

}
