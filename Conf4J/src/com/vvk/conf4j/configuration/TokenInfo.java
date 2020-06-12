package com.vvk.conf4j.configuration;

import org.apache.commons.io.FilenameUtils;

public class TokenInfo {
	
	private String name="";
	private String configFilePath = "";
	private int configFilePriority = 0;
	private boolean isFileWatcherEnabled = false;
	private int fileWatcherInterval = 0;
	private boolean isConfigFileBackupEnabled = false;
	private int configFileBackupInterval = 0;
	private String fileExtension = "";
	
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConfigFilePath() {
		return configFilePath;
	}
	public void setConfigFilePath(String configFilePath) {
		this.configFilePath = configFilePath;
		this.fileExtension = FilenameUtils.getExtension(configFilePath);
	}
	public int getConfigFilePriority() {
		return configFilePriority;
	}
	public void setConfigFilePriority(int configFilePriority) {
		this.configFilePriority = configFilePriority;
	}
	public boolean isFileWatcherEnabled() {
		return isFileWatcherEnabled;
	}
	public void setFileWatcherEnabled(boolean isFileWatcherEnabled) {
		this.isFileWatcherEnabled = isFileWatcherEnabled;
	}
	public int getFileWatcherInterval() {
		return fileWatcherInterval;
	}
	public void setFileWatcherInterval(int fileWatcherInterval) {
		this.fileWatcherInterval = fileWatcherInterval;
	}
	public boolean isConfigFileBackupEnabled() {
		return isConfigFileBackupEnabled;
	}
	public void setConfigFileBackupEnabled(boolean isConfigFileBackupEnabled) {
		this.isConfigFileBackupEnabled = isConfigFileBackupEnabled;
	}
	public int getConfigFileBackupInterval() {
		return configFileBackupInterval;
	}
	public void setConfigFileBackupInterval(int configFileBackupInterval) {
		this.configFileBackupInterval = configFileBackupInterval;
	}
	public String getFileExtension() {
		return fileExtension;
	}

}
