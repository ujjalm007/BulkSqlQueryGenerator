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
	//Row number of header record in file
	private int headerRecordPos=1;
	//Row number from where data starts
	private int dataRecordStartPos=2;
	//List of configurations received in the request
	private List<QueryConfig> queryConfigList;

}
