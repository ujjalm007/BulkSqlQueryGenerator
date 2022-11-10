package com.ujjalmajumdar.db.generator.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@PropertySource("file:config.properties")
public class Settings {
	
	@Value("${generator.processing.db}")
	private boolean isProcessingThroughDb;
	
	@Value("${generator.processing.db.rowLimit}")
	private short rowLimit;
	
	public void init() throws Exception
    {

    }
}
