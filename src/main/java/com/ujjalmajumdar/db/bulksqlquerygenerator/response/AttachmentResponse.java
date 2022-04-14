package com.ujjalmajumdar.db.bulksqlquerygenerator.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttachmentResponse {

	private String fileName;
	private String downloadUri;
	private String contentType;
	private long size;
	
}
