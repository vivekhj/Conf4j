//package com.vvk.conf4j.configuration.reader;
//
//import java.io.File;
//
//import org.apache.commons.configuration2.Configuration;
//import org.apache.commons.configuration2.XMLConfiguration;
//import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
//import org.apache.commons.configuration2.builder.fluent.FileBasedBuilderParameters;
//import org.apache.commons.configuration2.builder.fluent.Parameters;
//import org.apache.commons.configuration2.ex.ConfigurationException;
//
//public class ConfigurationXMLReader implements ConfigurationFileReader {
//
//	@Override
//	public Configuration read(String configFilePath) {
//		
//		Parameters params = new Parameters();
//		Configuration config = null;		
//		FileBasedBuilderParameters buildParams = params.fileBased();		
//		try {
//			buildParams.setFile(new File(configFilePath));
//			FileBasedConfigurationBuilder<XMLConfiguration> builder =
//					new FileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
//					.configure(buildParams);
//			config = builder.getConfiguration();
//		} catch (ConfigurationException e) {
//			e.printStackTrace();
//		}		
//		return config;
//	}
//
//
//
//
//}
