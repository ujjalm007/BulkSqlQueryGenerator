package com.ujjalmajumdar.db.bulksqlquerygenerator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ujjalmajumdar.db.bulksqlquerygenerator.entity.Attachment;
import com.ujjalmajumdar.db.bulksqlquerygenerator.model.QueryStat;
import com.ujjalmajumdar.db.bulksqlquerygenerator.repository.AttachmentRepository;

public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;

	@Override
	public Attachment saveAttachment(MultipartFile file) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
			return attachmentRepository.save(attachment);

		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Attachment getAttachment(String fileId) throws Exception {
		return attachmentRepository.findById(fileId)
				.orElseThrow(() -> new Exception("File not found with id: "+fileId));
	}
	
	

}
