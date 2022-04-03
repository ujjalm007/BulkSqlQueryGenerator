package com.ujjalmajumdar.db.bulksqlquerygenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujjalmajumdar.db.bulksqlquerygenerator.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, String>{

}
