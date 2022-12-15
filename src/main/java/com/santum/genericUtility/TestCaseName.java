package com.santum.genericUtility;

/**
 * This enum contains the test case names
 * @author abhishek
 *
 */
public enum TestCaseName {
	CREATECLIENTTEST("CreateClientTest");
	private String testCaseName;
	private TestCaseName(String testCaseName)
	{
		this.testCaseName=testCaseName;
	}
	public String convertToString()
	{
		return testCaseName.toString();
	}
}

