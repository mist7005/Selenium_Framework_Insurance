package com.insurance.prac;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportPrac {

	public static void main(String[] args) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Reporter Name");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report =new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating system","Windows 11");
		report.setSystemInfo("Browser name","Chrome");
		report.setSystemInfo("Browser Version","10");
		report.setSystemInfo("Reporter Name","jdnkcn");
		
		ExtentTest test1 = report.createTest("test1");
		test1.info("This information is coming from script");
		test1.warning("warning message");
		
		ExtentTest test2 = report.createTest("test2");
		test2.info("This information is coming from script");
		test2.pass("warning message");
		
		ExtentTest test3 = report.createTest("test3");
		test3.info("This information is coming from script");
		test3.fail("warning message");
		
		report.flush();

	}

}
