package com.insurance.prac;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.santum.genericUtility.BaseClass;

public class TestNgPrac1 extends BaseClass{
//	@Test
	public void testPrac1()
	{
		System.out.println("test15"+Thread.currentThread().getId());
		Assert.fail();
	}
}
