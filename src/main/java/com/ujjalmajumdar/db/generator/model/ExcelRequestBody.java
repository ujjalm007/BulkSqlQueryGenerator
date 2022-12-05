package com.ujjalmajumdar.db.generator.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class ExcelRequestBody {
	//unique identifier of the file in DB
	private int fileId;
	//start row position, default to 0
	private int startRow = 0;
	//end row position, default to (max number of rows - 1) in the file
	private int endRow = 0;
	//start column, default to 0
	private int startColumn = 0;
	//end column position, default to (max number of columns -1 ) in the row
	private int endColumn = 0;
	//Row number of header record in file
	private int headerRecordPos=1;
	//Row number from where data starts
	private int dataRecordStartPos=2;
	//List of configurations received in the request
	private List<QueryConfig> queryConfigList;

}
