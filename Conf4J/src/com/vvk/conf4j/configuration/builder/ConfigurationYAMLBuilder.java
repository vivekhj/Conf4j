package com.vvk.conf4j.configuration.builder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration2.YAMLConfiguration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.FileBasedBuilderParameters;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;

public class ConfigurationYAMLBuilder implements ConfigurationFileBuilder {

	@Override
	public ReloadingFileBasedConfigurationBuilder getBuilder(String configFilePath, int reloadTriggerPeriod) {

		Parameters params = new Parameters();
		ReloadingFileBasedConfigurationBuilder<YAMLConfiguration> builder = null;		
		FileBasedBuilderParameters buildParams = params.fileBased();		
		buildParams.setFile(new File(configFilePath));

		builder = new ReloadingFileBasedConfigurationBuilder<YAMLConfiguration>(YAMLConfiguration.class)
				.configure(buildParams);

		if(reloadTriggerPeriod > 0) {
			PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
					null, reloadTriggerPeriod, TimeUnit.SECONDS);
			trigger.start();
		}

		return builder;

	}

}
