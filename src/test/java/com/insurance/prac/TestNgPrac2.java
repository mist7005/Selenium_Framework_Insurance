package com.insurance.prac;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgPrac2 {
	
	
//	@Test
	public void test1()
	{
		System.out.println("test1Prac2");
	}
//	@Test
	public void test2()
	{
		System.out.println("test2Prac2");
	}
//	@AfterMethod
	public void afterMethod()
	{
		System.out.println("afterMethodPrac2");
	}
//	@AfterClass
	public void afterClass()
	{
		System.out.println("afterClassPrac2");
	}
//	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("beforeSuitePrac2");
	}
//	@BeforeTest
	public void beforeTest1()
	{
		System.out.println("beforeTest1Prac2");
	}
//	@BeforeClass
	public void beforeClass()
	{
		System.out.println("beforeClassPrac2");
	}
//	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("beforeMethodPrac2");
	}
//	@AfterSuite
	public void afterSuite()
	{
		System.out.println("afterSuitePrac2");
	}
}
