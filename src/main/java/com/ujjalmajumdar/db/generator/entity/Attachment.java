package com.ujjalmajumdar.db.generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Lob;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Attachment {
	@Id
	//@GeneratedValue(generator="uuid")
	//@GenericGenerator(name="uuid", strategy="uuid2")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="actual_file_name")
	private String actualFileName;
	@Column(name="actual_path_file_name")
	private String actualPathFileName;
	@Column(name="random_file_name")
	private String randomFileName;
	@Column(name="file_type")
	private String fileType;
	//@Lob
	//private byte[] data;
	public Attachment(String actualFileName, String actualPathFileName, String randomFileName, String fileType) {
		this.actualFileName = actualFileName;
		this.actualPathFileName = actualPathFileName;
		this.randomFileName = randomFileName;
		this.fileType = fileType;
	}


}
