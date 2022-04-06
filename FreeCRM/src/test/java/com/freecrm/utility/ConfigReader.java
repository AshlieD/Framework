package com.freecrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	//create Global variable
	Properties prop;
	
	//We need the Properties class to read the config file along with the File and FileInputStream class.
	public ConfigReader() {
		
		File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load the config file" + e.getMessage());
			
		}
		
	}
	
	//create a generic method to retrieve any value by passing the key as args
	public String getConfigData(String searchKey) {
		return prop.getProperty(searchKey);
	}
	
	//or specific keys
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getqaURL() {
		return prop.getProperty("qaURL");
	}
	
	
	

}
