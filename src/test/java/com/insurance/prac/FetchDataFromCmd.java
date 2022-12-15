package com.insurance.prac;

import org.testng.annotations.Test;

public class FetchDataFromCmd {

	@Test
	public void test()
	{
		String url = System.getProperty("url");
		String un = System.getProperty("un");
		String pw = System.getProperty("pw");
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);
	}
}
