package com.ujjalmajumdar.db.bulksqlquerygenerator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujjalmajumdar.db.bulksqlquerygenerator.model.ExcelRequestBody;
import com.ujjalmajumdar.db.bulksqlquerygenerator.model.SqlResponse;
import com.ujjalmajumdar.db.bulksqlquerygenerator.service.SqlService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path="/api/v1")
@Slf4j
public class ControllerApi {
	
	@Autowired
	private SqlService sqlService;
	
	@PostMapping(path="/excelToSql")
	public ResponseEntity<SqlResponse>convertExcelToSql(@RequestBody ExcelRequestBody excelRequestBody) {
		sqlService.generateQueryFromExcel(excelRequestBody);
		return null;
	}

}
