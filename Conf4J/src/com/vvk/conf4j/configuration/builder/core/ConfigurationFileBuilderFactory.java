package com.vvk.conf4j.configuration.builder.core;

import com.vvk.conf4j.configuration.ConfigurationFileType;
import com.vvk.conf4j.configuration.builder.ConfigurationFileBuilder;
import com.vvk.conf4j.configuration.builder.ConfigurationJSONBuilder;
import com.vvk.conf4j.configuration.builder.ConfigurationPropertiesBuilder;
import com.vvk.conf4j.configuration.builder.ConfigurationXMLBuilder;
import com.vvk.conf4j.configuration.builder.ConfigurationYAMLBuilder;

public class ConfigurationFileBuilderFactory {
	
public static ConfigurationFileBuilder getConfigurationFileBuilder(String fileExtension) {
		
		ConfigurationFileType configFileType = ConfigurationFileType.valueOf(fileExtension.toUpperCase().trim());	
		ConfigurationFileBuilder configBuilder = null;
		switch(configFileType) {
		case JSON:
			configBuilder = new ConfigurationJSONBuilder();
			break;
		case YAML:
		case YML:
			configBuilder = new ConfigurationYAMLBuilder();
			break;
		case XML:
			configBuilder = new ConfigurationXMLBuilder();
			break;
		case PROPERTIES:
			configBuilder = new ConfigurationPropertiesBuilder();
			break;
		}		
		return configBuilder;	
	}

}
