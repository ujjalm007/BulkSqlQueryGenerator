package com.ujjalmajumdar.db.generator.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttachmentResponse {

	private int id;
	private String fileName;
	private String downloadUri;
	private String contentType;
	private long size;
	
}
