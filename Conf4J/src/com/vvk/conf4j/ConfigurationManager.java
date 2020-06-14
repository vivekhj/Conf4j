package com.vvk.conf4j;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;

public class ConfigurationManager {
	
	Map<String, Configuration> mapOfTokenConfigurations = null;
	Configuration masterConfiguration = null;
	
	static {
		
	}
	
	public ConfigurationManager(Map<String, Configuration> mapOfTokenConfigurations2, Configuration masterConfiguration) {
		this.mapOfTokenConfigurations = mapOfTokenConfigurations2;
		this.masterConfiguration = masterConfiguration;
	}

	public void addProperty(String key, Object value) {
		masterConfiguration.addProperty(key, value);		
	}

	public void addProperty(String key, Object value, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		configuration.addProperty(key, value);
	}

	public void clear() {
		masterConfiguration.clear();
	}

	public void clear(String token) {
		Configuration configuration = getConfigurationFromToken(token);
		configuration.clear();
	}

	public void clearProperty(String key) {
		masterConfiguration.clearProperty(key);
	}

	public void clearProperty(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		configuration.clearProperty(key);
	}

	public boolean containsKey(String key) {		
		return masterConfiguration.containsKey(key);
	}

	public boolean containsKey(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);		
		return configuration.containsKey(key);
	}

	public <T> T get(Class<T> cls, String key) {		
		return masterConfiguration.get(cls, key);
	}

	public <T> T get(Class<T> cls, String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);		
		return configuration.get(cls, key);
	}

	public <T> T get(Class<T> cls, String key, T defaultValue) {
		return masterConfiguration.get(cls, key, defaultValue);
	}

	public <T> T get(Class<T> cls, String key, T defaultValue, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.get(cls, key, defaultValue);
	}

	public Object getArray(Class<?> cls, String key) {
		return masterConfiguration.getArray(cls, key);
	}

	public Object getArray(Class<?> cls, String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);	
		return configuration.getArray(cls, key);
	}

	public boolean getBoolean(String key) {
		return masterConfiguration.getBoolean(key);
	}

	public boolean getBoolean(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getBoolean(key);
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		return masterConfiguration.getBoolean(key, defaultValue);
	}

	public boolean getBoolean(String key, boolean defaultValue, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getBoolean(key, defaultValue);
	}

	public <T> Collection<T> getCollection(Class<T> cls, String key, Collection<T> target) {
		return masterConfiguration.getCollection(cls, key, target);
	}

	public <T> Collection<T> getCollection(Class<T> cls, String key, Collection<T> target, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getCollection(cls, key, target);
	}

	public double getDouble(String key) {
		return masterConfiguration.getDouble(key);
	}

	public double getDouble(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getDouble(key);
	}

	public double getDouble(String key, double defaultValue) {
		return masterConfiguration.getDouble(key, defaultValue);
	}

	public double getDouble(String key, double defaultValue, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getDouble(key, defaultValue);
	}

	public float getFloat(String key) {
		return masterConfiguration.getFloat(key);
	}

	public float getFloat(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getFloat(key);
	}

	public float getFloat(String key, float defaultValue) {
		return masterConfiguration.getFloat(key, defaultValue);
	}
	
	public float getFloat(String key, float defaultValue, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getFloat(key, defaultValue);
	}

	public int getInt(String key) {
		return masterConfiguration.getInt(key);
	}

	public int getInt(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getInt(key);
	}

	public int getInt(String key, int defaultValue) {
		return masterConfiguration.getInt(key, defaultValue);
	}

	public int getInt(String key, int defaultValue, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getInt(key, defaultValue);
	}

	public Iterator<String> getKeys() {
		return masterConfiguration.getKeys();
	}

	public Iterator<String> getKeys(String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getKeys();
	}
	
	public List<Object> getList(String key){
		return masterConfiguration.getList(key);
	}
	
	public List<Object> getList(String key, String token){
		Configuration configuration = getConfigurationFromToken(token);		
		return configuration.getList(key);
	}

	public <T> List<T> getList(Class<T> cls, String key) {
		return masterConfiguration.getList(cls, key);
	}

	public <T> List<T> getList(Class<T> cls, String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);		
		return configuration.getList(cls, key);
	}

	public long getLong(String key) {
		return masterConfiguration.getLong(key);
	}

	public long getLong(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getLong(key);
	}

	public long getLong(String key, long defaultValue) {
		return masterConfiguration.getLong(key, defaultValue);
	}

	public long getLong(String key, long defaultValue, String token) {
		Configuration configuration = getConfigurationFromToken(token);	
		return configuration.getLong(key);
	}

	public HashMap<String, String> getPropertiesAsHashMap() {
		return configurationToMap(masterConfiguration);
	}
	
	public HashMap<String, String> getPropertiesAsHashMap(String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configurationToMap(configuration);
	}
		
	public Object getProperty(String key) {
		return masterConfiguration.getProperty(key);
	}

	public Object getProperty(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getProperty(key);
	}

	public String getPropertyString(String key) {
		return masterConfiguration.getString(key);
	}

	public String getPropertyString(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.getString(key);
	}
	
	public String[] getPropertyAsStringArray(String key) {
		return masterConfiguration.getStringArray(key);
	}

	public String[] getPropertyAsStringArray(String key, String token) {
		Configuration configuration = getConfigurationFromToken(token);		
		return configuration.getStringArray(key);
	}

	public boolean isEmpty() {
		return masterConfiguration.isEmpty();
	}

	public boolean isEmpty(String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.isEmpty();
	}
	
	public int size() {
		return masterConfiguration.size();
	}

	public int size(String token) {
		Configuration configuration = getConfigurationFromToken(token);
		return configuration.size();
	}

	public void setProperty(String key, Object value) {
		masterConfiguration.setProperty(key, value);
	}

	public void setProperty(String key, Object value, String token) {
		Configuration configuration = getConfigurationFromToken(token);
		configuration.setProperty(key, value);
	}


	//-------------------------private methods
	private HashMap<String, String> configurationToMap(Configuration configuration) {
		HashMap<String, String> map = new HashMap<String, String>();
		return map;
	}
	
	private Configuration getConfigurationFromToken(String token) {
		return mapOfTokenConfigurations.get(token);
	}

}
