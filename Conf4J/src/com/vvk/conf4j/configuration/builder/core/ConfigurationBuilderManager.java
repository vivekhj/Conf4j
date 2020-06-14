package com.vvk.conf4j.configuration.builder.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConfigurationBuilderManager {

	Map<String, ReloadingFileBasedConfigurationBuilder> mapOfTokenConfigurationBuilder = null;
	ReloadingFileBasedConfigurationBuilder masterConfigurationBuilder = null;
			
	public ConfigurationBuilderManager(
			Map<String, ReloadingFileBasedConfigurationBuilder> mapOfTokenConfigurationBuilder,
			ReloadingFileBasedConfigurationBuilder masterConfigurationBuilder) {
		this.mapOfTokenConfigurationBuilder = mapOfTokenConfigurationBuilder;
		this.masterConfigurationBuilder = masterConfigurationBuilder;
	}

	public Map<String, Configuration> getMapOfTokenConfigurations() {
		Map<String, Configuration> mapOfConfigurations = new HashMap<String, Configuration>();
		for(String key:mapOfTokenConfigurationBuilder.keySet()) {
			Configuration configuration = null;
			try {
				configuration = (Configuration) mapOfTokenConfigurationBuilder.get(key).getConfiguration();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			} 
			mapOfConfigurations.put(key, configuration);
		}
		return mapOfConfigurations;
	}

	public Configuration getMasterConfiguration() {
		Configuration configuration = null;
		try {
			configuration = (Configuration) masterConfigurationBuilder.getConfiguration();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} 
		return configuration;
	}

}
