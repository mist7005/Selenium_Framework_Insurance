package com.santum.genericUtility;

/**
 * This enum contains the sheet names
 * @author abhishek
 *
 */
public enum SheetName {
	CLIENTS("clients");
	private String sheetName;
	private SheetName(String sheetName)
	{
		this.sheetName=sheetName;
	}
	public String convertToString()
	{
		return sheetName.toString();
	}
	
}
