package com.vvk.conf4j.configuration.reader;

import org.apache.commons.configuration2.Configuration;

public interface ConfigurationFileReader {
	
	Configuration read(String configFilePath);
}
