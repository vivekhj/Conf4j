package com.vvk.conf4j.configuration.builder.core;

import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.io.FilenameUtils;

import com.vvk.conf4j.configuration.TokenInfo;
import com.vvk.conf4j.configuration.builder.ConfigurationFileBuilder;

public class ConfigurationBuilderFactoryHelper {

	public static ReloadingFileBasedConfigurationBuilder createReloadingFileBasedConfigurationBuilder(
			TokenInfo tokenInfo) {
		
		String fileExtension = FilenameUtils.getExtension(tokenInfo.getConfigFilePath());
		ConfigurationFileBuilder configurationFileBuilder = ConfigurationFileBuilderFactory.getConfigurationFileBuilder(fileExtension);
		return configurationFileBuilder.getBuilder(tokenInfo.getConfigFilePath(), tokenInfo.getFileWatcherInterval());	
	}

}
