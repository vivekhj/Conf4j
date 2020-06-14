package com.vvk.conf4j.configuration.builder.core;

import java.util.Map;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;

import com.vvk.conf4j.configuration.PropertyConfigurator;


public class ConfigurationBuilderFactory {
	
	private static ConfigurationBuilder configurationBuilder = null;

	public static ConfigurationBuilder createConfigurationBuilder() {
		try {
			if(configurationBuilder == null) {
				PropertyConfigurator propertyConfigurator = new PropertyConfigurator();
				ReloadingFileBasedConfigurationBuilder masterConfigurationBuilder = 
						propertyConfigurator.getMasterConfigurationBuilder();
				Map<String, ReloadingFileBasedConfigurationBuilder> mapOfTokenConfigurationBuilder = 
						propertyConfigurator.getMapOfTokenConfigurationBuilders();
				System.out.println("vvk mapOfTokenConfigurationBuilder.size:" + mapOfTokenConfigurationBuilder.size());
				ConfigurationBuilderManager configurationBuilderManager = 
						new ConfigurationBuilderManager(mapOfTokenConfigurationBuilder, masterConfigurationBuilder);
				configurationBuilder = new ConfigurationBuilder(configurationBuilderManager);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return configurationBuilder;
	}

}
