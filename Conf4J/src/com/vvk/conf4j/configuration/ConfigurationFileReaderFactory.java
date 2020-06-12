package com.vvk.conf4j.configuration;

import com.vvk.conf4j.configuration.reader.ConfigurationFileReader;
import com.vvk.conf4j.configuration.reader.ConfigurationPropertiesReader;
import com.vvk.conf4j.configuration.reader.ConfigurationJSONReader;
import com.vvk.conf4j.configuration.reader.ConfigurationXMLReader;
import com.vvk.conf4j.configuration.reader.ConfigurationYAMLReader;

public class ConfigurationFileReaderFactory {
	
	public static ConfigurationFileReader getConfigurationFileReader(String fileExtension) {
		
		ConfigurationFileType configFileType = ConfigurationFileType.valueOf(fileExtension.toUpperCase().trim());	
		ConfigurationFileReader configreader = null;
		switch(configFileType) {
		case JSON:
			configreader = new ConfigurationJSONReader();
			break;
		case YAML:
		case YML:
			configreader = new ConfigurationYAMLReader();
			break;
		case XML:
			configreader = new ConfigurationXMLReader();
			break;
		case PROPERTIES:
			configreader = new ConfigurationPropertiesReader();
			break;
		}		
		return configreader;	
	}
}
