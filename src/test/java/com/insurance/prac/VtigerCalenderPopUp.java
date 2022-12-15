package com.insurance.prac;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.santum.genericUtility.WebDriverUtility;

public class VtigerCalenderPopUp {

	public static void main(String[] args) {
		String reqdMonth="January";
		String reqdYear="2023";
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
		WebDriverUtility wdu=new WebDriverUtility();
		WebDriver driver = wdu.setApplication("chrome", 10l, "http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Calendar")).click();
		driver.findElement(By.xpath("//a[text()='All Events & Todos']/preceding::img[@title='Open Calendar...']")).click();

		String currentMonthYear = driver.findElement(By.xpath("//table[@class='mailClient ']//b")).getText();
		String currentMonth = currentMonthYear.split(" ")[0];
		String cuurentYear = currentMonthYear.split(" ")[1];

		WebDriverWait wait=new WebDriverWait(driver, 10);


		while(hs.get(reqdMonth)>hs.get(currentMonth) || Integer.parseInt(reqdYear)>Integer.parseInt(cuurentYear))
		{
			driver.findElement(By.xpath("//img[@src='themes/images/small_right.gif']")).click();
			System.out.println(currentMonthYear);
			wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//table[@class='mailClient ']//b"), currentMonthYear));
			currentMonthYear = driver.findElement(By.xpath("//table[@class='mailClient ']//b")).getText();
			currentMonth = currentMonthYear.split(" ")[0];
			cuurentYear = currentMonthYear.split(" ")[1];
		}

		while(hs.get(reqdMonth)<hs.get(currentMonth) || Integer.parseInt(reqdYear)<Integer.parseInt(cuurentYear))
		{
			driver.findElement(By.xpath("//img[@src='themes/images/small_left.gif']")).click();
			System.out.println(currentMonthYear);
			wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//table[@class='mailClient ']//b"), currentMonthYear));
			currentMonthYear = driver.findElement(By.xpath("//table[@class='mailClient ']//b")).getText();
			currentMonth = currentMonthYear.split(" ")[0];
			cuurentYear = currentMonthYear.split(" ")[1];
		}
		driver.findElement(By.xpath("//a[text()='"+reqdDate+"']")).click();
		DateTimeFormatter.ofPattern("YYYY").withLocale(Locale.ENGLISH).parse("24").get(ChronoField.YEAR);
	}
	
	public By stringToBy(String s)
	{
		return By.xpath(s);
		
	}

}
