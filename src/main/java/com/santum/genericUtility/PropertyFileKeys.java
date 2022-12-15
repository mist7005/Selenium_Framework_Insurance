package com.santum.genericUtility;

/**
 * This enum contains keys of property file
 * @author abhishek
 *
 */
public enum PropertyFileKeys {

	URL("url"),USERNAME("username"),PASSWORD("password"),TIMEOUT("time"),BROWSER("browser"),LIMIT("limit");

	private String keys;

	//setter
	private PropertyFileKeys(String keys)
	{
		this.keys=keys;
	}

	//getter
	public String convertToString()
	{
		return keys.toString();
	}
}
