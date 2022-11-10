package com.ujjalmajumdar.db.generator.service;

import org.springframework.web.multipart.MultipartFile;

import com.ujjalmajumdar.db.generator.entity.Attachment;

public interface AttachmentService {

	public void init();
	
	public Attachment saveAttachment(MultipartFile file);

	public Attachment getAttachment(int fileId) throws Exception;

	
}
