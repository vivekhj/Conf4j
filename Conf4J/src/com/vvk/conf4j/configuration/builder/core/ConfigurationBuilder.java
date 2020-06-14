package com.vvk.conf4j.configuration.builder.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration2.CompositeConfiguration;

import com.vvk.conf4j.Configuration;
import com.vvk.conf4j.ConfigurationManager;

public class ConfigurationBuilder {

	ConfigurationBuilderManager configurationBuilderManager = null;
	
	public ConfigurationBuilder(ConfigurationBuilderManager configurationBuilderManager) {
		this.configurationBuilderManager = configurationBuilderManager;
	}

	public Configuration getConfiguration() {
		
		Map<String, org.apache.commons.configuration2.Configuration> mapOfTokenConfigurations = getMapOfTokenConfigurations();
		org.apache.commons.configuration2.Configuration masterConfiguration = createMasterConfiguration(mapOfTokenConfigurations);
		
		ConfigurationManager configurationManager = new ConfigurationManager(mapOfTokenConfigurations, masterConfiguration);
		Configuration configuration = new Configuration(configurationManager);
		return configuration;
	}

	private Map<String, org.apache.commons.configuration2.Configuration> getMapOfTokenConfigurations() {
		return configurationBuilderManager.getMapOfTokenConfigurations();
	}
	
	private org.apache.commons.configuration2.Configuration createMasterConfiguration(Map<String, org.apache.commons.configuration2.Configuration> mapOfTokenConfigMaps) {
		List<org.apache.commons.configuration2.Configuration> configurations = new ArrayList<>();
		mapOfTokenConfigMaps.forEach((k, v) -> configurations.add(v));		
		return new CompositeConfiguration(configurations);
	}


}
