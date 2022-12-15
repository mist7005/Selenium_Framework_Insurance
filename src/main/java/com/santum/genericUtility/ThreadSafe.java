package com.santum.genericUtility;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafe {

	private static ThreadLocal<WebDriverUtility> webdriverUtility=new ThreadLocal<WebDriverUtility>();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public static WebDriverUtility getwebdriverUtility()
	{
		return webdriverUtility.get();
	}
	public static void setwebdriverUtility(WebDriverUtility swebdriverUtility)
	{
		webdriverUtility.set(swebdriverUtility);
	}
	
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}
	public static void setExtentTest(ExtentTest sextentTest)
	{
		extentTest.set(sextentTest);
	}
}
