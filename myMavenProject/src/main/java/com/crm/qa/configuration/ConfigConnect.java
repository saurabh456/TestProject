package com.crm.qa.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigConnect {
	
	Properties pro;
	public ConfigConnect() throws Exception {
		
		File ff = new File("./Configuration/config.property");
		FileInputStream fis = new FileInputStream(ff);
		 pro = new Properties();
		pro.load(fis);
	}

	public String getChromePath() {
		return pro.getProperty("ChromeDriver");
	}

public String getUrl() {
	return pro.getProperty("URL");
}

}


