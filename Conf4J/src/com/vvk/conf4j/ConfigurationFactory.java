package com.vvk.conf4j;

import java.util.Map;

import com.vvk.conf4j.configuration.PropertyConfigurator;

public class ConfigurationFactory {
	
	private static Configuration configuration = null;

	public static Configuration createConfiguration() throws Exception {
		if(configuration == null) {
			PropertyConfigurator propertyConfigurator = new PropertyConfigurator();
			org.apache.commons.configuration2.Configuration masterConfiguration = propertyConfigurator.getMasterConfiguration();
			Map<String, org.apache.commons.configuration2.PropertiesConfiguration> mapOfTokenConfigurations = propertyConfigurator.getMapOfTokenConfigurations();
			ConfigurationManager configurationManager = new ConfigurationManager(mapOfTokenConfigurations, masterConfiguration);
			configuration = new Configuration(configurationManager);
		} 
		return configuration;
	}

}
