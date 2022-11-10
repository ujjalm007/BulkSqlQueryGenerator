package com.ujjalmajumdar.db.generator.parser;

public class ParserFactory extends BaseParserFactory{

	@Override
	public Parser createParser(String type) {
		Parser parser;
        switch (type.toLowerCase())
        {
            case "excel":
            	parser = new ExcelParser();
                break;
            case "csv":
            	parser = new CsvPerser();
                break;
            case "json":
            	parser = new JsonPerser();
                break;
            case "xml":
            	parser = new XmlPerser();
                break;
            default: throw new IllegalArgumentException("No such parser.");
        }
        //parser.parseFile(filePath);
        return parser;
	}

}
