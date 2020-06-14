package com.vvk.conf4j.configuration.builder;

import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;

public interface ConfigurationFileBuilder {

	ReloadingFileBasedConfigurationBuilder getBuilder(String configFilePath, int reloadTriggerPeriod);
}
