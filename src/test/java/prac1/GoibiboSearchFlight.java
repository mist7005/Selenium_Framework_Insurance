package prac1;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboSearchFlight {

	public static void main(String[] args) throws AWTException, InterruptedException {
		String depMonth="April";
		String retMonth="August";
		String Date="1";
		String depLoc="BLR";
		String arrLoc="DEL";
	
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[text()='Round-trip']")).click();
		driver.findElement(By.xpath("//span[text()='From']/following-sibling::p[text()='Enter city or airport']")).click();
		driver.findElement(By.xpath("//span[@class='sc-iAKWXU fyJDfj']/following-sibling::input")).sendKeys("BLR");
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']//li/descendant::span[text()='"+depLoc+"']")).click();
		
		driver.findElement(By.xpath("//span[@class='sc-iAKWXU fyJDfj']/following-sibling::input")).sendKeys("DEL");
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']//li/descendant::span[text()='"+arrLoc+"']")).click();

		
		String monthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText();
		String month = monthYear.split(" ")[0];
		
		while(true)
		{
				monthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText();
				month = monthYear.split(" ")[0];
				if(month.equals(depMonth))
				{
					System.out.println(month);
					driver.findElement(By.xpath("(//div[@class='DayPicker-Day']/p[text()='"+ Date+"'])[1]")).click();
					break;
				}
				else
				{
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				}
			
			
		}
		
		while(true)
		{
				monthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText();
				month = monthYear.split(" ")[0];
				if(month.equals(retMonth))
				{
					System.out.println(month);
					driver.findElement(By.xpath("(//div[@class='DayPicker-Day']/p[text()='"+ Date+"'])[1]")).click();
					break;
				}
				else
				{
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				}
			
		}
		
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();		
	}

}
