package com.vvk.conf4j.configuration.builder.core;

import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.io.FilenameUtils;

import com.vvk.conf4j.configuration.ConfigurationFileBuilderFactory;
import com.vvk.conf4j.configuration.builder.ConfigurationFileBuilder;

public class ConfigurationBuilderFactoryHelper {

	public static ReloadingFileBasedConfigurationBuilder createReloadingFileBasedConfigurationBuilder(
			String configFilePath) {
		String fileExtension = FilenameUtils.getExtension(configFilePath);
		ConfigurationFileBuilder configurationFileBuilder = ConfigurationFileBuilderFactory.getConfigurationFileBuilder(fileExtension);
		return configurationFileBuilder.getBuilder(configFilePath);	
	}

}
