package com.insurance.prac;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.santum.genericUtility.JavaUtility;
import com.santum.genericUtility.WebDriverUtility;

public class HandleCalender {

	public static void main(String[] args) {
		String reqdMonth="December";
		int reqdYear=Integer.parseInt("2022");
		String reqdDate="15";
		HashMap<String, Integer> hs=new HashMap<String, Integer>();
		hs.put("January", 1);
		hs.put("February", 2);
		hs.put("March", 3);
		hs.put("April", 4);
		hs.put("May", 5);
		hs.put("June", 6);
		hs.put("July", 7);
		hs.put("August", 8);
		hs.put("September", 9);
		hs.put("October", 10);
		hs.put("November", 11);
		hs.put("December", 12);
		int monNUm=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqdMonth).get(ChronoField.MONTH_OF_YEAR);
		System.out.println("mon NUmber"+monNUm);
		WebDriverUtility wdu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		WebDriver driver = wdu.setApplication("chrome", 10l, "https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		int currentMonth=hs.get(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText()); 
		int currentYear=(Integer)ju.convertToAnyDataType(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(),"int");

	
		while(hs.get(reqdMonth)> currentMonth || reqdYear>currentYear)
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			currentMonth=hs.get(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText()); 
			currentYear=(Integer)ju.convertToAnyDataType(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(),"int");
			System.out.println(currentMonth+" "+currentYear);
		}
		while(hs.get(reqdMonth)< currentMonth || reqdYear<currentYear)
		{
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			currentMonth=hs.get(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText()); 
			currentYear=(Integer)ju.convertToAnyDataType(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(),"int");
			System.out.println(currentMonth+" "+currentYear);
		}
		driver.findElement(By.xpath("//a[text()='"+reqdDate+"']")).click();


	}

}
