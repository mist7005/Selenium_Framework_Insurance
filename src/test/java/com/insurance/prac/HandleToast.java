package com.insurance.prac;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleToast {

	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.google.com/");
//		WebElement icon = driver.findElement(By.xpath("//*[name()='svg' and @class='gb_Ve']"));
//		Actions a=new Actions(driver);
//		a.moveToElement(icon).perform();
//		String hiddenTxt = driver.findElement(By.xpath("//div[@class='gb_Qe']")).getText();
//		System.out.println(hiddenTxt);
		
		char  c[]= {'a','b'};
		Character.toLowerCase(c[1]);
		Scanner sc=new Scanner(System.in);
		StringBuffer g=new StringBuffer(sc.next());
		System.out.println(g);
	}

}
