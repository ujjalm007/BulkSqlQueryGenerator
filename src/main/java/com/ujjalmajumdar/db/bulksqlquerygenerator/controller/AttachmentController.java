package com.ujjalmajumdar.db.bulksqlquerygenerator.controller;


import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ujjalmajumdar.db.bulksqlquerygenerator.entity.Attachment;
import com.ujjalmajumdar.db.bulksqlquerygenerator.response.AttachmentResponse;
import com.ujjalmajumdar.db.bulksqlquerygenerator.service.AttachmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path="/api/v1")
@Slf4j
public class AttachmentController {
	@Autowired
	private AttachmentService attachmentService;
	
	@PostMapping(path="/upload/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttachmentResponse> uploadFile(@RequestPart(required = false,value = "File") MultipartFile file) throws Exception {
		if(null == file) {
			throw new Exception ("Nothing got uploaded!");
		}
		Attachment attachment = attachmentService.saveAttachment(file);
		//String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		//		.path("/download/")
		//		.path(attachment.getId())
		//		.toUriString();
		//String downloadUri = ServletUriComponentsBuilder.fromPath(attachment.getRandomFileName())
		//		.toUriString();
		String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/download/")
				.path(attachment.getRandomFileName())
				.toUriString();
		AttachmentResponse attachmentResponse =  new AttachmentResponse(attachment.getActualFileName(),
				downloadUri,
				file.getContentType(),
				file.getSize());

		return new ResponseEntity<>(attachmentResponse, HttpStatus.OK);
	}
	/*
	@GetMapping(path="/download/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
		Attachment attachment = attachmentService.getAttachment(fileId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(attachment.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+attachment.getFileName()+"\"")
				.body(new ByteArrayResource(attachment.getData()));

	}
	*/
	private Resource createResource(String filename) {
		try {
			Path file = Paths.get(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Technical error: Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}
	
	
}
