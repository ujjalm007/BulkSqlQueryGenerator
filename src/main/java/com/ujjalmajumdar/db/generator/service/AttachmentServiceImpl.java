package com.ujjalmajumdar.db.generator.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ujjalmajumdar.db.generator.entity.Attachment;
import com.ujjalmajumdar.db.generator.model.QueryStat;
import com.ujjalmajumdar.db.generator.repository.AttachmentRepository;
import com.ujjalmajumdar.db.generator.utility.RandomFileName;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	private final Path uploads = Paths.get("C:\\D-Drive\\uploads\\");

	@Autowired
	private AttachmentRepository attachmentRepository;

	@Override
	public void init() {
		try {
			Files.createDirectory(uploads);
		} catch (IOException e) {
			throw new RuntimeException("Technical error: Could not initialize folder for upload!");
		}

	}

	@Override
	public Attachment saveAttachment(MultipartFile file) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			String randomName = RandomFileName.getRandomFileName(8);
			Path fullPathFileName = this.uploads.resolve(randomName+"_"+fileName);
			Files.copy(file.getInputStream(), fullPathFileName);

			Attachment attachment = new Attachment(fileName, fullPathFileName.toString(), randomName, file.getContentType());
			return attachmentRepository.save(attachment);

		} catch (Exception e) {
			throw new RuntimeException("Technical error: Could not store the file. Error: " + e.getMessage());
		}

	}

	@Override
	public Attachment getAttachment(int fileId) throws Exception {
		return attachmentRepository.findById(fileId)
				.orElseThrow(() -> new Exception("Technical error: File not found with id: " + fileId));
	}

	
}
