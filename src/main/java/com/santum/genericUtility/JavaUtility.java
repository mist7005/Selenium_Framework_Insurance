package com.santum.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains generic methods of java
 * @author sbhishek
 *
 */
public class JavaUtility {

	/**
	 * This method is used to generate a random number
	 * @param limit
	 * @return
	 */
	public int generateRandomNumber(int limit)
	{
		return new Random().nextInt(limit);
	}

	/**
	 * This method is used to convert String into any datatype
	 * @param value
	 * @param strategy
	 * @return
	 */
	public Object convertToAnyDataType(String value,String strategy)
	{
		Object data=null;
		if(strategy.equals("int"))
		{
			data=Integer.parseInt(value);
		}
		else if(strategy.equals("long"))
		{
			data=Long.parseLong(value);
		}
		return data;
	}

	/**
	 * This method is used to verify two values
	 * @param actualMsg
	 * @param expMsg
	 */
	public void checkConfirmationMessage(String actualMsg,String expMsg)
	{
		if(actualMsg.contains(expMsg))
			System.out.println("pass"+"----->"+expMsg);
		else
			System.out.println("fail");
	}

	/**
	 * This method is used to get the current time along with the month an year 
	 * @return
	 */
	public String getCurrentDate()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss");
		String time=sdf.format(date);
		return time;
	}
}
