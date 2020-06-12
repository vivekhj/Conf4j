package com.vvk.conf4j.configuration;

import java.io.FileInputStream;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;

public class PropertyConfigurator {
	
	static final String CONFIG_FILES_TOKEN = "conf4j.configuration.files.Token";
	static final String FILE_PATH_SUFFIX = "conf4j.configuration.files.Path";
	static final String FILE_PRIORITY_SUFFIX = "conf4j.configuration.files.Priority";
	static final String FILE_WATCHER_ENABLE_SUFFIX = "conf4j.fileWatcher.Enable";
	static final String FILE_WATCHER_INTERVAL_SUFFIX = "conf4j.fileWatcher.Interval";
	static final String FILE_BACKUP_ENABLE_SUFFIX = "conf4j.backup.Enable";
	static final String FILE_BACKUP_DIRECTORY_SUFFIX = "conf4j.backup.Directory";
	static final String FILE_BACKUP_INTERVAL_SUFFIX = "conf4j.backup.Interval";	
	static final String CONF4J_PROPERTIES_KEY = "conf4j.properties";
	
	Map<String, PropertiesConfiguration> mapOfTokenConfigurations = null;
	Configuration masterConfiguration = null;
	
	public PropertyConfigurator() throws Exception {
		doConfigure();
	}
	
	public Map<String, PropertiesConfiguration> getMapOfTokenConfigurations(){
		return mapOfTokenConfigurations;
	}
	
	public Configuration getMasterConfiguration(){
		return masterConfiguration;
	}
	
	private void doConfigure() throws Exception {
		String propertyPath = System.getProperty(CONF4J_PROPERTIES_KEY);
		if(propertyPath == null) {
			propertyPath = this.getClass().getClassLoader().getResource(CONF4J_PROPERTIES_KEY).getPath();
		}
		if(propertyPath == null) {
			throw new Exception(CONF4J_PROPERTIES_KEY + " not found.");
		}
		doConfigure(propertyPath);
	}
	
	private void doConfigure(String configFileNameWithPath) {
		Properties props = new Properties();
	    FileInputStream istream = null;
	    try {
	      istream = new FileInputStream(configFileNameWithPath);
	      props.load(istream);
	      istream.close();
	    } catch (Exception e) {
	      if (e instanceof InterruptedIOException || e instanceof InterruptedException) {
	          Thread.currentThread().interrupt();
	      }
//	      LogLog.error("Could not read configuration file ["+configFileName+"].", e);
//	      LogLog.error("Ignoring configuration file [" + configFileName+"].");
	      return;
	    } finally {
	        if(istream != null) {
	            try {
	                istream.close();
	            } catch(InterruptedIOException ignore) {
	                Thread.currentThread().interrupt();
	            } catch(Throwable ignore) {
	            }
	        }
	    }
	    // If we reach here, then the config file is alright.
	    doConfigure(props);
	}
	
	private void doConfigure(Properties props) {	
		String[] fileTokens = props.getProperty(CONFIG_FILES_TOKEN).split(",");
		int noOfTokens = fileTokens.length;
		List<TokenInfo> listOfTokenInfo = new ArrayList<>(noOfTokens);
		for(String token:fileTokens) {
			TokenInfo tokenInfo = createTokenInfo(props, token);
			int index = tokenInfo.getConfigFilePriority() - 1;
			listOfTokenInfo.add(index, tokenInfo);
		}
		
		mapOfTokenConfigurations = new HashMap<String, PropertiesConfiguration>(noOfTokens);		
		for(TokenInfo tokenInfo:listOfTokenInfo) {
			PropertiesConfiguration configuration = 
					(PropertiesConfiguration) ConfigurationReader.readAsConfiguration(tokenInfo.getConfigFilePath());
			mapOfTokenConfigurations.put(tokenInfo.getName(), configuration);
		}		
		masterConfiguration = createMasterConfiguration(mapOfTokenConfigurations);		
	}

	private Configuration createMasterConfiguration(Map<String, PropertiesConfiguration> mapOfTokenConfigMaps) {
		List<PropertiesConfiguration> configurations = new ArrayList<>();
		mapOfTokenConfigMaps.forEach((k, v) -> configurations.add(v));		
		return new CompositeConfiguration(configurations);
	}
	
	private TokenInfo createTokenInfo(Properties props, String token) {
		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setName(token);
		
		String configFilePath = props.getProperty(token + "." + FILE_PATH_SUFFIX);
		tokenInfo.setConfigFilePath(configFilePath);
		
		int configFilePriority = Integer.parseInt(props.getProperty(token + "." + FILE_PRIORITY_SUFFIX));
		tokenInfo.setConfigFilePriority(configFilePriority);
		
		boolean isFileWatcherEnabled = Boolean.parseBoolean(props.getProperty(token + "." + FILE_WATCHER_ENABLE_SUFFIX));
		tokenInfo.setFileWatcherEnabled(isFileWatcherEnabled);
		
		int fileWatcherInterval = Integer.parseInt(props.getProperty(token + "." + FILE_WATCHER_INTERVAL_SUFFIX));
		tokenInfo.setFileWatcherInterval(fileWatcherInterval);
		
		boolean isConfigFileBackupEnabled = Boolean.parseBoolean(props.getProperty(token + "." + FILE_BACKUP_ENABLE_SUFFIX));
		tokenInfo.setConfigFileBackupEnabled(isConfigFileBackupEnabled);
		
		int configFileBackupInterval = Integer.parseInt(props.getProperty(token + "." + FILE_BACKUP_INTERVAL_SUFFIX));
		tokenInfo.setConfigFileBackupInterval(configFileBackupInterval);
		
		return tokenInfo;
	}

}
