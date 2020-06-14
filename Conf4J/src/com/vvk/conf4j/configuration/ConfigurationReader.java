//package com.vvk.conf4j.configuration;
//
//import java.util.Map;
//
//import org.apache.commons.configuration2.Configuration;
//import org.apache.commons.configuration2.ConfigurationMap;
//import org.apache.commons.io.FilenameUtils;
//
//import com.vvk.conf4j.configuration.reader.ConfigurationFileReader;
//
//public class ConfigurationReader {
//	
//	public static Map readAsMap(String configFilePath) {
//		Configuration configuration = getConfiguration(configFilePath);		
//		return new ConfigurationMap(configuration);
//	}
//	
//	public static Configuration readAsConfiguration(String configFilePath) {
//		return getConfiguration(configFilePath);
//	}
//		
//	private static Configuration getConfiguration(String configFilePath) {
//		String fileExtension = FilenameUtils.getExtension(configFilePath);
//		ConfigurationFileReader configurationFileReader = ConfigurationFileReaderFactory.getConfigurationFileReader(fileExtension);
//		return configurationFileReader.read(configFilePath);	
//	}
//
//}
