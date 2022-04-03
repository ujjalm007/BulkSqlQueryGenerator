package com.ujjalmajumdar.db.bulksqlquerygenerator.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ujjalmajumdar.db.bulksqlquerygenerator.entity.Attachment;
import com.ujjalmajumdar.db.bulksqlquerygenerator.model.QueryStat;

public interface AttachmentService {

	public Attachment saveAttachment(MultipartFile file);

	public Attachment getAttachment(String fileId) throws Exception;

}
