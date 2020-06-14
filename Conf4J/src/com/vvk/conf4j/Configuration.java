package com.vvk.conf4j;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Configuration {
	
	ConfigurationManager confManager = null;
	
	public Configuration(ConfigurationManager confManager) {
		this.confManager = confManager; 
	}
	
	public void addProperty(String key, Object value) {
		confManager.addProperty(key,value);
	}
	
	public void addProperty(String key, Object value, String token) {
		confManager.addProperty(key,value, token);
	}
	
	public void clear() {
		confManager.clear();
	}
	
	public void clear(String token) {
		confManager.clear(token);
	}
	
	public void clearProperty(String key) {
		confManager.clearProperty(key);
	}
	
	public void clearProperty(String key, String token) {
		confManager.clearProperty(key, token);
	}
	
	public boolean containsKey(String key) {		
		return confManager.containsKey(key);
	}
	
	public boolean containsKey(String key, String token) {		
		return confManager.containsKey(key, token);
	}
	
	public <T> T get(Class<T> cls, String key) {		
		return confManager.get(cls, key);
	}
	
	public <T> T get(Class<T> cls, String key, String token) {		
		return confManager.get(cls, key, token);
	}
	
	public <T> T get(Class<T> cls, String key, T defaultValue) {	
		return confManager.get(cls, key, defaultValue);
	}

	public <T> T get(Class<T> cls, String key, T defaultValue, String token) {	
		return confManager.get(cls, key, defaultValue, token);
	}
	
	public Object getArray(Class<?> cls, String key) {		
		return confManager.getArray(cls, key);
	}
	
	public Object getArray(Class<?> cls, String key, String token) {		
		return confManager.getArray(cls, key, token);
	}
		
	public boolean getBoolean(String key) {	
		return confManager.getBoolean(key);
	}
	
	public boolean getBoolean(String key, String token) {
		return confManager.getBoolean(key, token);
	}
	
	public boolean getBoolean(String key,
            boolean defaultValue) {
		return confManager.getBoolean(key, defaultValue);
	}
	
	public boolean getBoolean(String key,
            boolean defaultValue, String token) {
		return confManager.getBoolean(key, defaultValue, token);
	}
		
	public <T> Collection<T> getCollection(Class<T> cls,
            String key,
            Collection<T> target){		
		return confManager.getCollection(cls, key, target);
	}
	
	public <T> Collection<T> getCollection(Class<T> cls,
            String key,
            Collection<T> target,
            String token){		
		return confManager.getCollection(cls, key, target, token);
	}
	
	public double getDouble(String key) {		
		return confManager.getDouble(key);
	}
	
	public double getDouble(String key, String token) {		
		return confManager.getDouble(key, token);
	}
	
	public double getDouble(String key,
            double defaultValue) {		
		return confManager.getDouble(key, defaultValue);
	}
	
	public double getDouble(String key,
            double defaultValue,
            String token) {		
		return confManager.getDouble(key, defaultValue, token);
	}
	
	public float getFloat(String key) {		
		return confManager.getFloat(key);
	}
	
	public float getFloat(String key, String token) {		
		return confManager.getFloat(key, token);
	}
	
	public float getFloat(String key,
            float defaultValue) {		
		return confManager.getFloat(key, defaultValue);
	}
	
	public float getFloat(String key,
            float defaultValue,
            String token) {		
		return confManager.getFloat(key, defaultValue, token);
	}
	
	public int getInt(String key) {		
		return confManager.getInt(key);
	}
	
	public int getInt(String key, String token) {		
		return confManager.getInt(key, token);
	}
	
	public int getInt(String key,
            int defaultValue) {	
		return confManager.getInt(key, defaultValue);
	}
	
	public int getInt(String key,
            int defaultValue, String token) {	
		return confManager.getInt(key, defaultValue, token);
	}
		
	public Iterator<String> getKeys(){
		return confManager.getKeys();
	}
	
	public Iterator<String> getKeys(String token){
		return confManager.getKeys(token);
	}
	
	public List<Object> getList(String key){		
		return confManager.getList(key);
	}
	
	public List<Object> getList(String key, String token){		
		return confManager.getList(key, token);
	}
	
	public <T> List<T> getList(Class<T> cls,
            String key){		
		return confManager.getList(cls, key);
	}
	
	public <T> List<T> getList(Class<T> cls,
            String key, String token){		
		return confManager.getList(cls, key, token);
	}
	
	public long getLong(String key) {
		return confManager.getLong(key);
	}
	
	public long getLong(String key, String token) {
		return confManager.getLong(key, token);
	}
	
	public long getLong(String key,
            long defaultValue) {	
		return confManager.getLong(key, defaultValue);
	}
	
	public long getLong(String key,
            long defaultValue, String token) {	
		return confManager.getLong(key, defaultValue, token);
	}
	
	public HashMap<String, String> getPropertiesAsHashMap(){		
		return confManager.getPropertiesAsHashMap();		
	}
	
	public HashMap<String, String> getPropertiesAsHashMap(String token){		
		return confManager.getPropertiesAsHashMap(token);		
	}
	
	public Object getProperty(String key) {
		return confManager.getProperty(key);
	}
	
	public Object getProperty(String key, String token) {
		return confManager.getProperty(key, token);
	}
	
	public String getString(String key) {
		return confManager.getPropertyString(key);		
	}
	
	public String getString(String key, String token) {
		return confManager.getPropertyString(key, token);		
	}
	
	public String[] getStringArray(String key) {
		return confManager.getPropertyAsStringArray(key);		
	}
	
	public String[] getStringArray(String key, String token) {
		return confManager.getPropertyAsStringArray(key, token);		
	}
	
	public boolean isEmpty() {
		return confManager.isEmpty();
	}
	
	public boolean isEmpty(String token) {
		return confManager.isEmpty(token);
	}
	
	public final int size() {
		return confManager.size();
	}
	
	public final int size(String token) {
		return confManager.size(token);
	}
	
	//will replace any previously set values. Set values is implicitly a call to clearProperty(key), addProperty(key, value).
	public final void setProperty(String key,
            Object value) {		
		confManager.setProperty(key, value);
	}
	
	public final void setProperty(String key,
            Object value,
            String token) {		
		confManager.setProperty(key, value, token);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
		

	

	

	
	
	
}
