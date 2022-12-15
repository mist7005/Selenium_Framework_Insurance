package com.santum.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		ThreadSafe.setExtentTest(test);
	}

	public void onTestSuccess(ITestResult result) {
		ThreadSafe.getExtentTest().pass(result.getMethod().getMethodName());
//		test.info("This information is coming from script");
//		test.pass("test case pass");	
	}

	public void onTestFailure(ITestResult result) {
		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName());
		ThreadSafe.getExtentTest().fail(result.getThrowable());
//		test.info("This information is coming from script");
//		test.fail("test case fail");
		System.out.println("screenshot"+Thread.currentThread().getId());
//		String ss = ThreadSafe.getwebdriverUtility().takeScreenshot(result.getMethod().getMethodName());
//		ThreadSafe.getExtentTest().addScreenCaptureFromPath(ss);
		String ss = ThreadSafe.getwebdriverUtility().takeScreenshot();
		ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(ss);
	}

	public void onTestSkipped(ITestResult result) {
		ThreadSafe.getExtentTest().skip(result.getMethod().getMethodName());
		ThreadSafe.getExtentTest().skip(result.getThrowable());
//		test.info("This information is coming from script");
//		test.skip("test case skipped");
	}
 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Reporter Name");
		spark.config().setTheme(Theme.DARK);
		report =new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating system","Windows 11");
		report.setSystemInfo("Browser name","Chrome");
		report.setSystemInfo("Browser Version","10");
		report.setSystemInfo("Reporter Name","jdnkcn");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
