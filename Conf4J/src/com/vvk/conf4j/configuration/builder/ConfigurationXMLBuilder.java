package com.vvk.conf4j.configuration.builder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.FileBasedBuilderParameters;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;

public class ConfigurationXMLBuilder implements ConfigurationFileBuilder {

	@Override
	public ReloadingFileBasedConfigurationBuilder getBuilder(String configFilePath) {
		Parameters params = new Parameters();
		ReloadingFileBasedConfigurationBuilder<XMLConfiguration> builder = null;		
		FileBasedBuilderParameters buildParams = params.fileBased();		
		buildParams.setFile(new File(configFilePath));

		builder = new ReloadingFileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
				.configure(buildParams);

		PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
				null, 10, TimeUnit.SECONDS);
		trigger.start();

		return builder;
	}

}
