//package com.vvk.conf4j.configuration.reader;
//
//import java.io.File;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.commons.configuration2.Configuration;
//import org.apache.commons.configuration2.PropertiesConfiguration;
//import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
//import org.apache.commons.configuration2.builder.fluent.FileBasedBuilderParameters;
//import org.apache.commons.configuration2.builder.fluent.Parameters;
//import org.apache.commons.configuration2.ex.ConfigurationException;
//import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
//
//public class ConfigurationPropertiesReader implements ConfigurationFileReader {
//
//	@Override
//	public ReloadingFileBasedConfigurationBuilder getBuilder(String configFilePath) {
//		Parameters params = new Parameters();
////		PropertiesConfiguration config = null;		
//		ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder = null;
//		
//		FileBasedBuilderParameters buildParams = params.fileBased();		
//		try {
//			buildParams.setFile(new File(configFilePath));
//			
//			builder = new ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration>(PropertiesConfiguration.class)
//					.configure(buildParams);
//					
//			PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
//				    null, 10, TimeUnit.SECONDS);
//			trigger.start();
//			
////			config = builder.getConfiguration();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//		return builder;
//	}
//
//
//
//}
