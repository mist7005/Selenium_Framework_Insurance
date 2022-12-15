package com.insurance.prac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PccSJ {

	public static void handleCalenderPopUp(List<WebElement> listMonthYear,String reqdDate,WebDriver driver)
	{
		int count=0;
		for (int i = 0; i < listMonthYear.size(); i++) {
			WebElement currentMonthYearElement = listMonthYear.get(i);
			String currentMonthYear = currentMonthYearElement.getText();
			System.out.println(currentMonthYear);
			String currentMonth = currentMonthYearElement.getText().split(" ")[0];
			String currentYear = currentMonthYearElement.getText().split(" ")[1];
			if(currentMonth.equals("December") && currentYear.equals("2022"))
			{
				count=i+1;
				break;
			}
		}
		if(count>=1)
		{
			driver.findElement(By.xpath("(//div[text()='"+reqdDate+"'])["+count+"]")).click();
		}
		else
			System.out.println("enter a valid month and year");
	}
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start1");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='From']/parent::div/descendant::div/input")).sendKeys("DEL");
		driver.findElement(By.xpath("//div[text()='BLR']")).click();
		List<WebElement> listMonthYear = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
		handleCalenderPopUp(listMonthYear, "10",driver);
		handleCalenderPopUp(listMonthYear, "20",driver);
		
	}

}
