package com.ujjalmajumdar.db.bulksqlquerygenerator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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
	
	@PostMapping(path="/upload")
	public ResponseEntity<AttachmentResponse> uploadFile(@RequestParam("file") MultipartFile file) {
		Attachment attachment = attachmentService.saveAttachment(file);
		String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/download/")
				.path(attachment.getId())
				.toUriString();
		AttachmentResponse attachmentResponse =  new AttachmentResponse(attachment.getFileName(),
				downloadUri,
				file.getContentType(),
				file.getSize());

		return new ResponseEntity<>(attachmentResponse, HttpStatus.OK);
	}
	@GetMapping(path="/download/{fileId}")
	public ResponseEntity<Resource> uploadFile(@PathVariable String fileId) throws Exception {
		Attachment attachment = attachmentService.getAttachment(fileId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(attachment.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+attachment.getFileName()+"\"")
				.body(new ByteArrayResource(attachment.getData()));

	}
	
}
