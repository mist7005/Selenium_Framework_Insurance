package com.insurance.prac;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.santum.genericUtility.BaseClass;

//@Listeners(com.santum.genericUtility.ListnerImplementationClass.class)
public class TestNgPrac extends BaseClass {

	
//	@Test(retryAnalyzer = com.santum.genericUtility.RetryImplementationClass.class,groups = "sanity")
	@Test
	public void testPrac()
	{
		System.out.println("test15"+Thread.currentThread().getId());
		Assert.fail();
//		Assert.assertEquals(1, 2);
	}
//	@Test(groups = "reg")
//	public void test2()
//	{
//		System.out.println("regTest");
//		Assert.fail();
//	}
//	
//	@Test(groups ="sanity")
//	public void test10()
//	{
//		System.out.println("sanityTest1");
//	}
	
	
}
