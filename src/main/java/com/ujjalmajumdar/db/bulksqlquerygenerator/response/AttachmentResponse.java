package com.ujjalmajumdar.db.bulksqlquerygenerator.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AttachmentResponse {

	private String fileName;
	private String downloadUri;
	private String contentType;
	private long size;
	
}
