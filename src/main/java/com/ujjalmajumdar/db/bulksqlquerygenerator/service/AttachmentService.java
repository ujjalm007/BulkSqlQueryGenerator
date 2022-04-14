package com.ujjalmajumdar.db.bulksqlquerygenerator.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ujjalmajumdar.db.bulksqlquerygenerator.entity.Attachment;

public interface AttachmentService {

	public void init();
	
	public Attachment saveAttachment(MultipartFile file);

	public Attachment getAttachment(Long fileId) throws Exception;

	
}
